package com.atynine.fflogsprogress;

import com.atynine.fflogsprogress.entities.*;
import com.atynine.fflogsprogress.services.PlayerService;
import com.atynine.fflogsprogress.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class FflogsProgressApplication {
	@Autowired private ReportService reportService;
	@Autowired private PlayerService playerService;

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
}