package com.todocode.microservicios.e_commerce.sales.services;

import com.todocode.microservicios.e_commerce.sales.dtos.ShoppingCartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("shopping-cart")
public interface IShoppingCartApiClient {
    @GetMapping("/shopping-carts/{id}")
    ShoppingCartDTO getShoppingCartById(@PathVariable Long id);
}
