package com.ipn.mx.miniinventariosupabase.domain.repository;

import com.ipn.mx.miniinventariosupabase.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
