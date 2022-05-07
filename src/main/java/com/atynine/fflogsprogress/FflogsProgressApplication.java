package com.atynine.fflogsprogress;

import com.atynine.fflogsprogress.entities.Guild;
import com.atynine.fflogsprogress.entities.Report;
import com.atynine.fflogsprogress.entities.ReportData;
import com.atynine.fflogsprogress.entities.Server;
import com.atynine.fflogsprogress.repositories.GuildRepository;
import com.atynine.fflogsprogress.repositories.ReportRepository;
import com.atynine.fflogsprogress.repositories.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@SpringBootApplication
@RestController
public class FflogsProgressApplication {
	@Autowired private ReportRepository reportRepo;
	@Autowired private GuildRepository guildRepo;
	@Autowired private ServerRepository serverRepo;

	public static void main(String[] args) {
		SpringApplication.run(FflogsProgressApplication.class, args);
	}


	@PostMapping(value = "/reportData", consumes = "application/json", produces = "application/json")
	public Report postReportData(@RequestBody ReportData reportData) {
		Report report = reportData.getReport();
		persistGuildAndServer(report);
		if(reportRepo.existsById(report.getCode())){
			reportRepo.save(report);
		}
		updateFightStartAndEndTimeForReport(report);
		return report;
	}

	private void persistGuildAndServer(Report report){
		Guild guild = report.getGuild();
		if(guild == null) return;
		Server server = guild.getServer();
		if(server == null) return;
		if(!serverRepo.existsById(server.getId())){
			guild.setServer(serverRepo.save(server));
		}
		if(!guildRepo.existsById(guild.getId())){
			report.setGuild(guildRepo.save(guild));
		}
	}

	private void updateFightStartAndEndTimeForReport(Report report){
		Timestamp reportStartTime = report.getStartTime();
		report.getFights().forEach(fight -> {
			fight.setStartTimestamp(new Timestamp((long) (reportStartTime.getTime() + fight.getStartTime())));
			fight.setEndTimestamp(new Timestamp((long) (reportStartTime.getTime() + fight.getEndTime())));
		});
	}
}