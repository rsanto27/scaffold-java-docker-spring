package com.seed.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seed.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer>{

}
