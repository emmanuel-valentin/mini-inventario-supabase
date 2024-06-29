package com.ipn.mx.miniinventariosupabase.service.impl;

import com.ipn.mx.miniinventariosupabase.domain.entity.Category;
import com.ipn.mx.miniinventariosupabase.domain.entity.Product;
import com.ipn.mx.miniinventariosupabase.domain.repository.CategoryRepository;
import com.ipn.mx.miniinventariosupabase.domain.repository.ProductRepository;
import com.ipn.mx.miniinventariosupabase.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    public Product save(Product product) {
        if (product.getCategory().getId() != null) {
            Category existingCategory = categoryRepository.findById(product.getCategory().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Category not found"));
            product.setCategory(existingCategory);
        }
        return productRepository.save(product);
    }

    @Transactional
    public Product update(Long id, Product product) {
        Product productToUpdate = productRepository.findById(id).orElseThrow();
        productToUpdate.setName(product.getName());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setStock(product.getStock());
        productToUpdate.setCategory(product.getCategory());
        return productRepository.save(productToUpdate);
    }

    @Transactional
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
