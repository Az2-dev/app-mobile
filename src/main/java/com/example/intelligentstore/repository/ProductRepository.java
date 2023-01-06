package com.example.intelligentstore.repository;


import com.example.intelligentstore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("from Product product " +
            "where product.category.id = :id")
    List<Product> findAllByCategoryId(@Param("id") Long id);

    @Query("from Product product " +
            "where product.fournisseur.id = :id")
    List<Product> findByProviderIdWithGettingProviderAndCategory(@Param("id") Long id);

}
