package com.todocode.microservicios.e_commerce.products.services;

import com.todocode.microservicios.e_commerce.products.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> getProducts();

    Product getProductById(Long id);

    Product createProduct(Product product);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);

    List<Product> getProductsByIds(List<Long> productsIds);
}