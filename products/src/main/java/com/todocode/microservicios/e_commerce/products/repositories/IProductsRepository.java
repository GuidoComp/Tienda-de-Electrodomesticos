package com.todocode.microservicios.e_commerce.products.repositories;

import com.todocode.microservicios.e_commerce.products.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductsRepository extends JpaRepository<Product, Long> {
}
