package com.seed.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seed.domain.CategoryDomain;
import com.seed.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository catRepo;
	
	public CategoryDomain find(Integer id) {
		return catRepo.findById(id).orElse(null);
	}

}
