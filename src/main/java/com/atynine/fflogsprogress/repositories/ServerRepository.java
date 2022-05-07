package com.atynine.fflogsprogress.repositories;

import com.atynine.fflogsprogress.entities.Server;
import org.springframework.data.repository.CrudRepository;

public interface ServerRepository extends CrudRepository<Server, Integer> {
	Server findFirstByName(String name);
}
