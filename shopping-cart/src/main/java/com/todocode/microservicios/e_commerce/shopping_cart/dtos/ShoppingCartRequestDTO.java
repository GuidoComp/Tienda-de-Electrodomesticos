package com.todocode.microservicios.e_commerce.shopping_cart.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartRequestDTO {
    private List<Long> productsIds;
}
