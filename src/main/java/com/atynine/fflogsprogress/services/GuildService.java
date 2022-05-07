package com.atynine.fflogsprogress.services;

import com.atynine.fflogsprogress.entities.Guild;
import com.atynine.fflogsprogress.entities.Server;

public interface GuildService {
	Guild save(Guild guild);
	Guild fetchById(Integer id);
	boolean existsById(Integer id);
}
