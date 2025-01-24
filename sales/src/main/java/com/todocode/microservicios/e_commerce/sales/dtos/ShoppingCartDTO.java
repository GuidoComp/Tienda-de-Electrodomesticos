package com.todocode.microservicios.e_commerce.sales.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartDTO {
    private Long shoppingCartId;
    private double total;
    private List<ProductDTO> products;
}
