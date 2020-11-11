package com.seed.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seed.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
