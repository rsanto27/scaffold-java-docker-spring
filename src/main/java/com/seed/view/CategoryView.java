package com.seed.view;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categories")
public class CategoryView {
	
	@RequestMapping(method = RequestMethod.GET)
	public String toList() {
		return "Rest layer is working fine";
	}

}
