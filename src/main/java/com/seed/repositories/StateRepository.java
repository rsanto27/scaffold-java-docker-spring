package com.seed.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seed.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer>{

}
