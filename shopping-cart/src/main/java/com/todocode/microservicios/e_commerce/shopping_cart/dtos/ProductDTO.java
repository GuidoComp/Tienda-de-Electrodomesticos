package com.todocode.microservicios.e_commerce.shopping_cart.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long productId;
    private Long code;
    private String name;
    private String brand;
    private Double price;
}
