package com.example.minicommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.minicommerce.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(
        value = "SELECT * " +
            "FROM product p " +
            "WHERE MATCH(p.name) AGAINST(:name)",
        nativeQuery = true
    )
    Optional<Product> findByName(String name);
}
