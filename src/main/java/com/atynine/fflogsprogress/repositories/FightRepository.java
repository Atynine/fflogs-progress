package com.atynine.fflogsprogress.repositories;

import com.atynine.fflogsprogress.entities.Fight;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface FightRepository extends CrudRepository<Fight, Integer> {
	Set<Fight> findFightByGuildIDAndEncounterIDOrderByStartTimestampAsc(Integer guildID, Integer encounterID);
}
