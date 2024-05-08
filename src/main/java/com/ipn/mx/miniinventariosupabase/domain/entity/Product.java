package com.ipn.mx.miniinventariosupabase.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name", nullable = false, length = 50)
    private String name;

    @Column(name = "product_description", nullable = false, length = 100)
    private String description;

    @Column(name = "product_price", nullable = false)
    private BigDecimal price;

    @Column(name = "product_stock", nullable = false)
    private Integer stock;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    private Category category;
}
