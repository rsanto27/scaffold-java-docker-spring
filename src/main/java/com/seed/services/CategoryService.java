package com.seed.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seed.domain.Category;
import com.seed.repositories.CategoryRepository;
import com.seed.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository catRepo;
	
	public Category find(Integer id) {
		Optional<Category> category = catRepo.findById(id);
		return category.orElseThrow(() -> new ObjectNotFoundException(
				"Not found. Id: " + id + ", Type: " + Category.class.getName()));
	}
	
	public Category insert(Category category) {
		category.setId(null);
		return  catRepo.save(category);
	}
	
	public Category update(Category category) {
		find(category.getId());
		return catRepo.save(category);
	}
}