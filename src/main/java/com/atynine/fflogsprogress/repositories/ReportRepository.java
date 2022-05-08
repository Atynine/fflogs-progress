package com.atynine.fflogsprogress.repositories;

import com.atynine.fflogsprogress.entities.Guild;
import com.atynine.fflogsprogress.entities.Report;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ReportRepository extends CrudRepository<Report, String> {
	Set<Report> findTop5ReportByGuildOrderByEndTimeAsc(Guild guild);
}
