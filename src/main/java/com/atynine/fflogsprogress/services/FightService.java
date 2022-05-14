package com.atynine.fflogsprogress.services;

import com.atynine.fflogsprogress.entities.Fight;

import java.util.Set;

public interface FightService {
	Fight save(Fight fight);
	Set<Fight> fetchByGuildIdAndEncounterId(Integer guildId, Integer encounterId);
	boolean existsById(Integer id);
	boolean existsByStartTimestampAndEndTimestamp(Long startTimestamp, Long fightPercentage);
}
