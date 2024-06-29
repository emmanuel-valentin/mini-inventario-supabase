package com.ipn.mx.miniinventariosupabase.integration;

import com.ipn.mx.miniinventariosupabase.domain.entity.Product;
import com.ipn.mx.miniinventariosupabase.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping({"/", ""})
    private List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping({"/{id}", "/{id}/"})
    private Product findById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow();
    }

    @PostMapping({"/", ""})
    private Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping({"/{id}", "/{id}/"})
    private Product update(@PathVariable Long id, @RequestBody Product product) {
        return productService.update(id, product);
    }

    @DeleteMapping({"/{id}", "/{id}/"})
    private void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
