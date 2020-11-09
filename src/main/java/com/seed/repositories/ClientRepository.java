package com.seed.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seed.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{

}
