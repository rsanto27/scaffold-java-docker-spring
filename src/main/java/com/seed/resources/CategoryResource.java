package com.seed.resources;


import java.net.URI;
import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

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

import com.seed.domain.Category;
import com.seed.dto.CategoryDTO;
import com.seed.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService catService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Category> find(@PathVariable Integer id) {
		Category category = catService.find(id);
		return ResponseEntity.ok().body(category);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CategoryDTO>> findAll() {
		List<CategoryDTO> catsDto = new ArrayList<CategoryDTO>();
		catService.findAll().forEach(cat -> catsDto.add(new CategoryDTO(cat)));
		return ResponseEntity.ok().body(catsDto);
		
		// or
//		List<Category> categories = catService.findAll();
//		List<CategoryDTO> categoriesDTO = categories.stream().map(cat -> new CategoryDTO(cat)).collect(Collectors.toList());
//		return ResponseEntity.ok().body(categoriesDTO);
	
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/page")
	public ResponseEntity<Page<CategoryDTO>> findPaginated(
			@RequestParam(value = "offset", defaultValue = "0") Integer offset, 
			@RequestParam(value = "limit", defaultValue = "10") Integer limit, 
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<CategoryDTO> categoriesDTOPage = catService.findPaginated(offset, limit, orderBy, direction)
				.map(cat -> new CategoryDTO(cat));
		return ResponseEntity.ok().body(categoriesDTOPage);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CategoryDTO categoryDTO){
		Category category = catService.insert(new Category(categoryDTO));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(category.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody CategoryDTO categoryDTO, @PathVariable Integer id){
		Category category = new Category(categoryDTO);
		category.setId(id);
		catService.update(category);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		catService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
