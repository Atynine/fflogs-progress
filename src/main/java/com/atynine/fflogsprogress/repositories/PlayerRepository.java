package com.atynine.fflogsprogress.repositories;

import com.atynine.fflogsprogress.entities.Player;
import com.atynine.fflogsprogress.entities.Server;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
	List<Player> findByNameAndServer(String name, Server server);
}
