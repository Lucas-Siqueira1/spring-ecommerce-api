package com.lucas.spring_ecommerce_api.services;

import com.lucas.spring_ecommerce_api.entities.Product;
import com.lucas.spring_ecommerce_api.repository.ProductRepository;
import com.lucas.spring_ecommerce_api.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product findProductById(Integer id) {
        Optional<Product> obj = productRepository.findById(id);
        return obj.orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public Product insert(Product product) {
        return productRepository.save(product);
    }

    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    public Product update(Integer id, Product newProduct) {
        Product oldProduct = productRepository.getReferenceById(id);
        oldProduct.setDescription(newProduct.getDescription());
        oldProduct.setName(newProduct.getName());
        oldProduct.setPrice(newProduct.getPrice());
        oldProduct.setImgUrl(newProduct.getImgUrl());

        return productRepository.save(oldProduct);
    }

}
