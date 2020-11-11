package com.seed.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seed.domain.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
