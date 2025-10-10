package com.example.minicommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.minicommerce.entity.Product;
import com.example.minicommerce.global.dto.GetProductResponse;
import com.example.minicommerce.global.util.KoreanAnalyzer;
import com.example.minicommerce.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<GetProductResponse> getProduct(String name) {
        String analyzeName = KoreanAnalyzer.analyze(name);

        List<Product> product = productRepository.findByName(analyzeName);

        return product.stream().map(GetProductResponse::of).toList();
    }
}
