package com.seed.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seed.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
