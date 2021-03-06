package com.atynine.fflogsprogress.services.impl;

import com.atynine.fflogsprogress.entities.Player;
import com.atynine.fflogsprogress.repositories.PlayerRepository;
import com.atynine.fflogsprogress.services.PlayerService;
import com.atynine.fflogsprogress.services.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
	@Autowired
	PlayerRepository playerRepo;
	@Autowired
	ServerService serverService;

	@Override
	public Player save(Player player) {
		if(player.getServer() != null) serverService.save(player.getServer());
		return playerRepo.save(player);
	}

	@Override
	public Player fetchByNameAndServer(String name, String server) {
		List<Player> players = playerRepo.findByNameAndServer(name, serverService.fetchByName(server));
		if(players.isEmpty()) return null;
		return players.get(0);
	}

	@Override
	public boolean existsById(Integer id) {
		return false;
	}
}
