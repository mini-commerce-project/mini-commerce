package com.example.minicommerce.global.dto;

import com.example.minicommerce.entity.Product;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GetProductResponse {

    private final Long id;
    private final String name;
    private final String brandName;
    private final String description;

    public static GetProductResponse of(Product product) {
        return new GetProductResponse(
            product.getId(),
            product.getName(),
            product.getBrandName(),
            product.getDescription()
        );
    }
}
