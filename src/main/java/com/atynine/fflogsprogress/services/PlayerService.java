package com.atynine.fflogsprogress.services;

import com.atynine.fflogsprogress.entities.Player;
import com.atynine.fflogsprogress.entities.Server;

public interface PlayerService {

	Player save(Player player);
	Player fetchByNameAndServer(String name, String server);
	boolean existsById(Integer id);
}
