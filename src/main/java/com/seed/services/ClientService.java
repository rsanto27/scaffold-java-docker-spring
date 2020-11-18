package com.seed.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seed.domain.Client;
import com.seed.repositories.ClientRepository;
import com.seed.services.exceptions.DataIntegrityException;
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

	@Transactional
	public Client insert(Client client) {
		client.setId(null);
		return clientRepo.save(client);
	}
	
	public Client update(Client client) {
		Client cliFinded = find(client.getId());
		cliFinded.setName(client.getName());
		cliFinded.setEmail(client.getEmail());
		return clientRepo.save(cliFinded);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			clientRepo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			throw new DataIntegrityException("Not possible to delete a client that has relationships");
		}
	}
	
	public List<Client> findAll(){
		return clientRepo.findAll();
	}
	
	public Page<Client> findPaginated(Integer offset, Integer limit, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(offset, limit, Direction.valueOf(direction), orderBy);
		return clientRepo.findAll(pageRequest);
	}
}