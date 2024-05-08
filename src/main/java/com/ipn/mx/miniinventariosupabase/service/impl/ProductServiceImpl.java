package com.ipn.mx.miniinventariosupabase.service.impl;

import com.ipn.mx.miniinventariosupabase.domain.entity.Product;
import com.ipn.mx.miniinventariosupabase.domain.repository.ProductRepository;
import com.ipn.mx.miniinventariosupabase.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional(readOnly = false)
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transactional(readOnly = false)
    public Product update(Long id, Product product) {
        Product productToSave = productRepository.findById(id).orElseThrow();
        productToSave.setName(product.getName());
        productToSave.setDescription(product.getDescription());
        productToSave.setPrice(product.getPrice());
        productToSave.setStock(product.getStock());
        return productRepository.save(productToSave);
    }

    @Transactional(readOnly = false)
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
