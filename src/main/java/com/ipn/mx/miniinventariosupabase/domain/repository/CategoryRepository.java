package com.ipn.mx.miniinventariosupabase.domain.repository;

import com.ipn.mx.miniinventariosupabase.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);
}
