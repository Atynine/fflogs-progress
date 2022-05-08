package com.atynine.fflogsprogress;

import com.atynine.fflogsprogress.entities.*;
import com.atynine.fflogsprogress.services.FightService;
import com.atynine.fflogsprogress.services.PlayerService;
import com.atynine.fflogsprogress.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@SpringBootApplication
@RestController
public class FflogsProgressApplication {
	@Autowired private ReportService reportService;
	@Autowired private PlayerService playerService;
	@Autowired private FightService fightService;

	public static void main(String[] args) {
		SpringApplication.run(FflogsProgressApplication.class, args);
	}


	@PostMapping(value = "/reportData", consumes = "application/json", produces = "application/json")
	public Report postReportData(@RequestBody ReportWrapper reportWrapper) {
		Report report = reportWrapper.getReportData().getReport();
		if(!reportService.existsById(report.getCode())){
			reportService.save(report);
		}
		return report;
	}

	@PostMapping(value = "/player", consumes = "application/json", produces = "application/json")
	public Player postPlayer(@RequestBody Player player) {
		playerService.save(player);
		return player;
	}

	@GetMapping(value = "/guild/{guildId}/recent", produces = "application/json")
	public Set<Report> getGuildRecents(@PathVariable Integer guildId){
		return reportService.fetchRecentReportsByGuildId(guildId);
	}

	@GetMapping(value = "/guild/{guildId}/encounter/{encounterId}")
	public Set<Fight> getGuildFightsByEncounter(@PathVariable Integer guildId, @PathVariable Integer encounterId){
		return fightService.fetchByGuildIdAndEncounterId(guildId, encounterId);
	}
}