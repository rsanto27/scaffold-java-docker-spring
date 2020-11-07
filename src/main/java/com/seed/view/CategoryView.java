package com.seed.view;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.seed.model.CategoryModel;

@RestController
@RequestMapping(value = "/categories")
public class CategoryView {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<CategoryModel> toList() {
		
		CategoryModel category1 = new CategoryModel(1, "Computing");
		CategoryModel category2 = new CategoryModel(2, "Office");
		
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		list.add(category1);
		list.add(category2);
		
		return list;
	}

}
