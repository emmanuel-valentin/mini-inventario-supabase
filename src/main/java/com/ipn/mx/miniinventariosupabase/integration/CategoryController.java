package com.ipn.mx.miniinventariosupabase.integration;

import com.ipn.mx.miniinventariosupabase.domain.entity.Category;
import com.ipn.mx.miniinventariosupabase.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping({"/", ""})
    private List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping({"/{id}", "/{id}/"})
    private Category findById(@PathVariable Long id) {
        return categoryService.findById(id).orElseThrow();
    }

    @PostMapping({"/", ""})
    private Category save(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @PutMapping({"/{id}", "/{id}/"})
    private Category update(@PathVariable Long id, @RequestBody Category category) {
        return categoryService.update(id, category);
    }

    @DeleteMapping({"/{id}", "/{id}/"})
    private void deleteById(@PathVariable Long id) {
        categoryService.deleteById(id);
    }
}
