package com.lucas.spring_ecommerce_api.repository;

import com.lucas.spring_ecommerce_api.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
