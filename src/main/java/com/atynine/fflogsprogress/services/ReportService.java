package com.atynine.fflogsprogress.services;

import com.atynine.fflogsprogress.entities.Report;

import java.util.Set;

public interface ReportService {
	Report save(Report report);
	Report fetchById(String id);
	boolean existsById(String id);
	Set<Report> fetchRecentReportsByGuildId(Integer guildId);
}
