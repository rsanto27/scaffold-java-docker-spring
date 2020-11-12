package com.seed.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seed.domain.Order;
import com.seed.repositories.OrderRepository;
import com.seed.services.exceptions.ObjectNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepo;
	
	public Order find(Integer id) {
		Optional<Order> category = orderRepo.findById(id);
		return category.orElseThrow(() -> new ObjectNotFoundException(
				"Not found. Id: " + id + ", Type: " + Order.class.getName()));
	}

}