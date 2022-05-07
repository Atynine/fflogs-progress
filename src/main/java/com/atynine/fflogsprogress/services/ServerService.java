package com.atynine.fflogsprogress.services;

import com.atynine.fflogsprogress.entities.Server;

public interface ServerService {
	Server save(Server server);
	Server fetchByName(String name);
	boolean existsById(Integer id);
}
