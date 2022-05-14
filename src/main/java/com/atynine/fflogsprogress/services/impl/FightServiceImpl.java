package com.atynine.fflogsprogress.services.impl;

import com.atynine.fflogsprogress.entities.Fight;
import com.atynine.fflogsprogress.repositories.FightRepository;
import com.atynine.fflogsprogress.services.FightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FightServiceImpl implements FightService {
	@Autowired
	private FightRepository fightRepo;

	@Override
	public Fight save(Fight fight) {
		if(this.existsByStartTimestampAndEndTimestamp(fight.getStartTimestamp(), fight.getEndTimestamp())) return fight;
		return fightRepo.save(fight);
	}

	@Override
	public Set<Fight> fetchByGuildIdAndEncounterId(Integer guildId, Integer encounterId) {
		return fightRepo.findFightByGuildIDAndEncounterIDOrderByStartTimestampAsc(guildId, encounterId);
	}

	@Override
	public boolean existsById(Integer id) {
		return fightRepo.existsById(id);
	}

	@Override
	public boolean existsByStartTimestampAndEndTimestamp(Long startTimestamp, Long endTimestamp) {
		return fightRepo.existsByStartTimestampAndEndTimestamp(startTimestamp, endTimestamp);
	}
}
