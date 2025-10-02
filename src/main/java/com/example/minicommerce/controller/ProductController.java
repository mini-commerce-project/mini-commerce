package com.example.minicommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.minicommerce.global.dto.GetProductResponse;
import com.example.minicommerce.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/api/products")
    public List<GetProductResponse> getProduct(
        @RequestParam String name
    ) {
        return productService.getProduct(name);
    }
}
