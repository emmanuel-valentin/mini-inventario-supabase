package com.ipn.mx.miniinventariosupabase.service.impl;

import com.ipn.mx.miniinventariosupabase.domain.entity.Category;
import com.ipn.mx.miniinventariosupabase.domain.repository.CategoryRepository;
import com.ipn.mx.miniinventariosupabase.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Transactional(readOnly = false)
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Transactional
    public Category update(Long id, Category category) {
        Category categoryToUpdate = categoryRepository.findById(id).orElseThrow();
        categoryToUpdate.setName(category.getName());
        categoryToUpdate.setDescription(category.getDescription());
        return categoryRepository.save(categoryToUpdate);
    }

    @Transactional
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
