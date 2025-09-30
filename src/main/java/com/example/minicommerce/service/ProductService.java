package com.example.minicommerce.service;

import org.springframework.stereotype.Service;

import com.example.minicommerce.entity.Product;
import com.example.minicommerce.global.dto.GetProductResponse;
import com.example.minicommerce.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public GetProductResponse getProduct(String name) {
        Product product = productRepository.findByName(name)
            .orElseThrow(() -> new RuntimeException("상품이 존재하지 않습니다."));

        return GetProductResponse.of(product);
    }
}
