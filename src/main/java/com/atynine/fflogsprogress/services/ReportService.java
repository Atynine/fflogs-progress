package com.atynine.fflogsprogress.services;

import com.atynine.fflogsprogress.entities.Report;

public interface ReportService {
	Report save(Report report);
	Report fetchById(String id);
	boolean existsById(String id);
}
