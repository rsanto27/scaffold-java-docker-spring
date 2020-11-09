package com.seed;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.seed.domain.Category;
import com.seed.domain.City;
import com.seed.domain.Product;
import com.seed.domain.State;
import com.seed.repositories.CategoryRepository;
import com.seed.repositories.CityRepository;
import com.seed.repositories.ProductRepository;
import com.seed.repositories.StateRepository;

@SpringBootApplication
public class SeedJavaSpringbootApplication implements CommandLineRunner{
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CityRepository cityRepository;

	public static void main(String[] args) {
		SpringApplication.run(SeedJavaSpringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Office");
		Category cat2 = new Category(null, "Computing");
		
		Product p1 = new Product(null, "computer", 7000.00);
		Product p2 = new Product(null, "printer", 1500.00);
		Product p3 = new Product(null, "mouse", 110.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));

		State sta1 = new State(null, "Minas Gerais");
		State sta2 = new State(null, "São Paulo");
		
		City cit1 = new City(null, "Uberlândia", sta1);
		City cit2 = new City(null, "São Paulo", sta2);
		City cit3 = new City(null, "Campinas", sta2);
		
		sta1.getCities().addAll(Arrays.asList(cit1));
		sta2.getCities().addAll(Arrays.asList(cit2, cit3));
		
		stateRepository.saveAll(Arrays.asList(sta1, sta2));
		cityRepository.saveAll(Arrays.asList(cit1, cit2, cit3));
		
	}

}
