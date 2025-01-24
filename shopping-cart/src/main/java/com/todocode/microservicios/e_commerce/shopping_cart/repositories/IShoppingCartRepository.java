package com.todocode.microservicios.e_commerce.shopping_cart.repositories;

import com.todocode.microservicios.e_commerce.shopping_cart.models.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
}
