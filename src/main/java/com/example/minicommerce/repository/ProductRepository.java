package com.example.minicommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.minicommerce.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(
        value = "SELECT * " +
            "FROM product p " +
            "WHERE (:name IS NULL OR MATCH(p.name) AGAINST(:name IN BOOLEAN MODE)) " +
            "AND (:category IS NULL OR p.category_type = :category) " +
            "ORDER BY p.id DESC",
        nativeQuery = true
    )
    List<Product> findByName(String name, String category);
}
