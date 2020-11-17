package com.seed.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.seed.domain.Category;
import com.seed.repositories.CategoryRepository;
import com.seed.services.exceptions.DataIntegrityException;
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
		return catRepo.save(category);
	}
	
	public Category update(Category category) {
		find(category.getId());
		return catRepo.save(category);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			catRepo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			throw new DataIntegrityException("Not possible to delete a category that has products.");
		}
	}
	
	public List<Category> findAll(){
		return catRepo.findAll();
	}
	
	public Page<Category> findPaginated(Integer offset, Integer limit, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(offset, limit, Direction.valueOf(direction), orderBy);
		return catRepo.findAll(pageRequest);
	}
}