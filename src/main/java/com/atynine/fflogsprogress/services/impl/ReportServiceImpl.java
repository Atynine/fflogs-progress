package com.atynine.fflogsprogress.services.impl;

import com.atynine.fflogsprogress.entities.Player;
import com.atynine.fflogsprogress.entities.Report;
import com.atynine.fflogsprogress.repositories.ReportRepository;
import com.atynine.fflogsprogress.services.GuildService;
import com.atynine.fflogsprogress.services.PlayerService;
import com.atynine.fflogsprogress.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashSet;

@Service
public class ReportServiceImpl implements ReportService {
	private static final String LIMIT_BREAK = "LimitBreak";

	@Autowired
	ReportRepository reportRepo;
	@Autowired
	GuildService guildService;
	@Autowired
	PlayerService playerService;

	@Override
	public Report save(Report report) {
		if(report == null) return null;
		if(report.getGuild() != null) guildService.save(report.getGuild());
		filterFights(report);
		updateFightStartAndEndTimeForReport(report);
		retrievePlayerData(report);
		return reportRepo.save(report);
	}

	@Override
	public Report fetchById(String id) {
		return reportRepo.findById(id).get();
	}

	@Override
	public boolean existsById(String id) {
		return reportRepo.existsById(id);
	}

	private void updateFightStartAndEndTimeForReport(Report report){
		Timestamp reportStartTime = report.getStartTime();
		report.getFights().forEach(fight -> {
			fight.setStartTimestamp(new Timestamp((long) (reportStartTime.getTime() + fight.getStartTime())));
			fight.setEndTimestamp(new Timestamp((long) (reportStartTime.getTime() + fight.getEndTime())));
		});
	}

	private void retrievePlayerData(Report report){
		HashSet<Player> players = new HashSet<>();
		if(report.getMasterData() == null) return;
		if(report.getMasterData().getActors() == null) return;
		report.getMasterData().getActors().forEach(actor -> {
			if(!actor.getSubType().equals(LIMIT_BREAK)){
				Player player = playerService.fetchByNameAndServer(actor.getName(), actor.getServer());
				if(player != null) players.add(player);
			}
		});
		report.setPlayers(players);
	}

	private void filterFights(Report report){
		if(report.getFights() == null) return;
		report.getFights().removeIf(fight -> (fight.getBossPercentage() == null || fight.getFightPercentage() == null || fight.getSize() == null));
	}
}
