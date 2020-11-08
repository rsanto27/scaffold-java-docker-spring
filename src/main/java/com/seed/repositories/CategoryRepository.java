package com.seed.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seed.domain.CategoryDomain;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryDomain, Integer>{

}
