package com.lucas.spring_ecommerce_api.repository;

import com.lucas.spring_ecommerce_api.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
