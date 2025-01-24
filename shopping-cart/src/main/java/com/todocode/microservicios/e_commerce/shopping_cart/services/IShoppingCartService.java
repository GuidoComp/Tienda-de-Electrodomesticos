package com.todocode.microservicios.e_commerce.shopping_cart.services;

import com.todocode.microservicios.e_commerce.shopping_cart.dtos.ShoppingCartDTO;
import com.todocode.microservicios.e_commerce.shopping_cart.dtos.ShoppingCartRequestDTO;
import com.todocode.microservicios.e_commerce.shopping_cart.models.ShoppingCart;

import java.util.List;

public interface IShoppingCartService {
    List<ShoppingCart> getShoppingCarts();

    ShoppingCartDTO getShoppingCartById(Long id);

    //ShoppingCart createShoppingCart(ShoppingCart shoppingCart);

    ShoppingCart createShoppingCart();

    ShoppingCart createShoppingCart(ShoppingCartRequestDTO shoppingCartRequestDTO);

    ShoppingCart updateShoppingCart(Long id, ShoppingCartRequestDTO shoppingCart);

    void deleteShoppingCart(Long id);
}
