package com.todocode.microservicios.e_commerce.sales.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long productId;
    private Long code;
    private String name;
    private String brand;
    private Double price;
}
