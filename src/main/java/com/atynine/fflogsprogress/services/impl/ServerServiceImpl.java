package com.atynine.fflogsprogress.services.impl;

import com.atynine.fflogsprogress.entities.Server;
import com.atynine.fflogsprogress.repositories.ServerRepository;
import com.atynine.fflogsprogress.services.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServerServiceImpl implements ServerService {
	@Autowired
	ServerRepository serverRepo;
	@Override
	public Server save(Server server) {
		return serverRepo.save(server);
	}

	@Override
	public Server fetchByName(String name) {
		return serverRepo.findFirstByName(name);
	}

	@Override
	public boolean existsById(Integer id) {
		return serverRepo.existsById(id);
	}
}
