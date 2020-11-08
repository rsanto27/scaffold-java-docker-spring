package com.seed;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.seed.domain.CategoryDomain;
import com.seed.repositories.CategoryRepository;

@SpringBootApplication
public class SeedJavaSpringbootApplication implements CommandLineRunner{
	
	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(SeedJavaSpringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CategoryDomain cat1 = new CategoryDomain(null, "Office");
		CategoryDomain cat2 = new CategoryDomain(null, "Computing");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		
	}

}
