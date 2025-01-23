package com.todocode.microservicios.e_commerce.products.services;

import com.todocode.microservicios.e_commerce.products.models.Product;
import com.todocode.microservicios.e_commerce.products.repositories.IProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductsRepository productsRepository;

    @Override
    public List<Product> getProducts() {
        return productsRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productsRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        return productsRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product productDb = productsRepository.findById(id).orElse(null);
        if (productDb == null) {
            return null;
        }
        productDb.setCode(product.getCode());
        productDb.setName(product.getName());
        productDb.setBrand(product.getBrand());
        productDb.setPrice(product.getPrice());
        return productsRepository.save(productDb);
    }

    @Override
    public void deleteProduct(Long id) {
        productsRepository.deleteById(id);
    }

    @Override
    public List<Product> getProductsByIds(List<Long> productsIds) {
        return productsRepository.findAllById(productsIds);
    }
}
