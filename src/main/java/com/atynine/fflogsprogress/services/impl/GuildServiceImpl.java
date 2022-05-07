package com.atynine.fflogsprogress.services.impl;

import com.atynine.fflogsprogress.entities.Guild;
import com.atynine.fflogsprogress.repositories.GuildRepository;
import com.atynine.fflogsprogress.services.GuildService;
import com.atynine.fflogsprogress.services.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuildServiceImpl implements GuildService {
	@Autowired
	GuildRepository guildRepo;
	@Autowired
	ServerService serverService;

	@Override
	public Guild save(Guild guild) {
		if(guild == null) return null;
		if(guild.getServer() != null) serverService.save(guild.getServer());
		return guildRepo.save(guild);
	}

	@Override
	public Guild fetchById(Integer id) {
		return guildRepo.findById(id).get();
	}

	@Override
	public boolean existsById(Integer id) {
		return false;
	}
}
