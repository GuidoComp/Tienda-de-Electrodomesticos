package com.todocode.microservicios.e_commerce.sales.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleDTO {
    private Long saleId;
    private LocalDate date;
    private ShoppingCartDTO shoppingCart;
}
