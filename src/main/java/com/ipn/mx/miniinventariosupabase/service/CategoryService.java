package com.ipn.mx.miniinventariosupabase.service;

import com.ipn.mx.miniinventariosupabase.domain.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();
    Optional<Category> findById(Long id);
    Category save(Category category);
    Category update(Long id, Category category);
    void deleteById(Long id);
}
