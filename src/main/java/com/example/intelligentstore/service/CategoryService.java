package com.example.intelligentstore.service;

import com.example.intelligentstore.entity.Category;
import com.example.intelligentstore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryService {
    @Autowired
    private CategoryRepository categoryrepository;

    public List<Category> findAll() {
        return categoryrepository.findAll();
    }

    public Category findById(Long id) {
        return categoryrepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category with id" + id + "not found"));
    }

    public Category save(Category category) {
        return categoryrepository.save(category);
    }

    public void deleteById(Long id) {
        try {
            this.categoryrepository.deleteById(id);
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST");
        }
    }

}
