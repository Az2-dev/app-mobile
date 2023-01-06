package com.example.intelligentstore.controller;


import com.example.intelligentstore.dto.ProductDto;
import com.example.intelligentstore.entity.Category;
import com.example.intelligentstore.entity.Fournisseur;
import com.example.intelligentstore.entity.Product;
import com.example.intelligentstore.service.CategoryService;
import com.example.intelligentstore.service.FournisseurService;
import com.example.intelligentstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    private ProductService productservice;
    @Autowired
    private FournisseurService fournisseurservice;

    @Autowired
    private CategoryService categoryservice;

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productservice.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        return ResponseEntity.ok(productservice.findById(id));
    }

    @PostMapping("/add")
    public Product addproduct(@RequestBody ProductDto request) {
        var description = request.getDescription();
        var image = request.getImage();
        var price = request.getPrice();
        var title = request.getTitle();
        var idcategory = request.getIdcategory();
        var idfournisseur = request.getIdfournisseur();
        Fournisseur fournisseur = fournisseurservice.findById(idfournisseur);
        Category category = categoryservice.findById(idcategory);
        Product product = new Product(title, description, image, price, category, fournisseur);

        return productservice.save(product);
    }

    @PutMapping(value = "/modify/{id}", consumes = "application/json")
    public Product updateproduct(@PathVariable Long id, @RequestBody ProductDto request) {
        Fournisseur fournisseur = fournisseurservice.findById(request.getIdfournisseur());
        Category category = categoryservice.findById(request.getIdcategory());
        Product product = productservice.findById(id);
        product.setDescription(request.getDescription());
        product.setTitle(request.getTitle());
        product.setPrice(request.getPrice());
        product.setImage(request.getImage());
        product.setCategory(category);
        product.setFournisseur(fournisseur);
        return productservice.save(product);
    }

    @GetMapping("/by-category/{categoryId}")
    public ResponseEntity<List<Product>> getAllByCategoryId(@PathVariable Long categoryId) {
        return ResponseEntity.ok(productservice.findAllByCategoryId(categoryId));
    }

    @GetMapping("/by-provider/{providerId}")
    public ResponseEntity<List<Product>> getAllByProviderId(@PathVariable Long providerId) {
        return ResponseEntity.ok(productservice.findAllByProviderId(providerId));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.productservice.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
