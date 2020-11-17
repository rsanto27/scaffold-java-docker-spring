package com.seed.resources;


import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.seed.domain.Client;
import com.seed.dto.ClientDTO;
import com.seed.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@Autowired
	private ClientService cliService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Client> find(@PathVariable Integer id) {
		Client client = cliService.find(id);
		return ResponseEntity.ok().body(client);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ClientDTO>> findAll() {
		List<ClientDTO> catsDto = new ArrayList<ClientDTO>();
		cliService.findAll().forEach(cat -> catsDto.add(new ClientDTO(cat)));
		return ResponseEntity.ok().body(catsDto);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/page")
	public ResponseEntity<Page<ClientDTO>> findPaginated(
			@RequestParam(value = "offset", defaultValue = "0") Integer offset, 
			@RequestParam(value = "limit", defaultValue = "10") Integer limit, 
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<ClientDTO> clientsDTOPage = cliService.findPaginated(offset, limit, orderBy, direction)
				.map(cat -> new ClientDTO(cat));
		return ResponseEntity.ok().body(clientsDTOPage);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ClientDTO clientDTO){
		Client client = cliService.insert(new Client(clientDTO));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(client.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody ClientDTO clientDTO, @PathVariable Integer id){
		Client client = new Client(clientDTO);
		client.setId(id);
		cliService.update(client);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		cliService.delete(id);
		return ResponseEntity.noContent().build();
	}
}

