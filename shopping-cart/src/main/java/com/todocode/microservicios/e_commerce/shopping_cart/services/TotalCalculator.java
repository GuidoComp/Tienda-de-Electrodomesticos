package com.todocode.microservicios.e_commerce.shopping_cart.services;

import com.todocode.microservicios.e_commerce.shopping_cart.dtos.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TotalCalculator {
    public double calculateTotal(List<ProductDTO> products) {
        return products.stream()
                .mapToDouble(ProductDTO::getPrice)
                .sum();
    }
}
