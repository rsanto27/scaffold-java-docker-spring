package com.seed.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seed.domain.Category;
import com.seed.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository catRepo;
	
	public Category find(Integer id) {
		return catRepo.findById(id).orElse(null);
	}

}
