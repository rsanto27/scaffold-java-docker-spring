package com.seed.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seed.domain.Client;
import com.seed.repositories.ClientRepository;
import com.seed.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepo;
	
	public Client find(Integer id) {
		Optional<Client> client = clientRepo.findById(id);
		return client.orElseThrow(() -> new ObjectNotFoundException(
				"Not found. Id: " + id + ", Type: " + Client.class.getName()));
	}

}