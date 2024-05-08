package com.ipn.mx.miniinventariosupabase.domain.repository;

import com.ipn.mx.miniinventariosupabase.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
