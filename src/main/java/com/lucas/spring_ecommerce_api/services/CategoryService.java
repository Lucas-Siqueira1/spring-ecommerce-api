package com.lucas.spring_ecommerce_api.services;

import com.lucas.spring_ecommerce_api.entities.Category;
import com.lucas.spring_ecommerce_api.repository.CategoryRepository;
import com.lucas.spring_ecommerce_api.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    public Category findCategoryById(Integer id) {
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public Category insert(Category category) {
       return categoryRepository.save(category);
    }

    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }

    public Category update(Integer id, Category newCategory) {
        Category oldCategory = categoryRepository.getReferenceById(id);
        oldCategory.setName(newCategory.getName());

        return categoryRepository.save(oldCategory);
    }




}
