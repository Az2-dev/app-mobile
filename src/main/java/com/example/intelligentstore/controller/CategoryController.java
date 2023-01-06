package com.example.intelligentstore.controller;

import com.example.intelligentstore.dto.CategoryDto;
import com.example.intelligentstore.entity.Category;
import com.example.intelligentstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "*")

public class CategoryController {
    @Autowired
    private CategoryService categoryservice;

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok(categoryservice.findAll());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryservice.findById(id));
    }

    @PostMapping("/add")
    public Category addcategory(@RequestBody CategoryDto request) {
        var name = request.getName();
        var description = request.getDescription();
        var image = request.getImage();
        Category category = new Category(name, description, image);
        return categoryservice.save(category);


    }

    @PutMapping(value = "/modify/{id}", consumes = "application/json")
    public Category updatecategory(@PathVariable Long id, @RequestBody CategoryDto request) {

        Category category = categoryservice.findById(id);
        category.setName(request.getName());
        category.setDescription(request.getDescription());
        category.setImage(request.getImage());
        return categoryservice.save(category);

    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.categoryservice.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
