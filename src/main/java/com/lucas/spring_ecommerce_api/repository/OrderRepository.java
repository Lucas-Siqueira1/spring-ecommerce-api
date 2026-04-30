package com.lucas.spring_ecommerce_api.repository;

import com.lucas.spring_ecommerce_api.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
