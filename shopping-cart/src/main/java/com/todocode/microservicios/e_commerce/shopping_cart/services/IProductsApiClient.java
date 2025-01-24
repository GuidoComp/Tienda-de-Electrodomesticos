package com.todocode.microservicios.e_commerce.shopping_cart.services;

import com.todocode.microservicios.e_commerce.shopping_cart.dtos.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "products")
public interface IProductsApiClient {
    @GetMapping("/products/select")
    List<ProductDTO> getProductsByIds (@RequestParam List<Long> ids);
}
