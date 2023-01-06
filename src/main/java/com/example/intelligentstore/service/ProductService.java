package com.example.intelligentstore.service;

import com.example.intelligentstore.entity.Product;
import com.example.intelligentstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productrepository;

    public List<Product> findAll() {
        return productrepository.findAll();
    }

    public Product save(Product product) {
        return productrepository.save(product);
    }

    public Product findById(Long id) {
        return productrepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
    }

    public void deleteById(Long id) {
        try {
            this.productrepository.deleteById(id);
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST");
        }
    }

    public List<Product> findAllByCategoryId(Long categoryId) {
        return productrepository.findAllByCategoryId(categoryId);
    }

    public List<Product> findAllByProviderId(Long providerId) {
        return productrepository.findByProviderIdWithGettingProviderAndCategory(providerId);
    }

}
