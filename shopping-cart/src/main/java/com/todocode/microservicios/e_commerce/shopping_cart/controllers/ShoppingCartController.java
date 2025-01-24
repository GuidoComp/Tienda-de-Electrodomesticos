package com.todocode.microservicios.e_commerce.shopping_cart.controllers;

import com.todocode.microservicios.e_commerce.shopping_cart.dtos.ShoppingCartRequestDTO;
import com.todocode.microservicios.e_commerce.shopping_cart.models.ShoppingCart;
import com.todocode.microservicios.e_commerce.shopping_cart.services.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    @Autowired
    private IShoppingCartService shoppingCartService;

    @GetMapping
    public ResponseEntity<?> getShoppingCarts() {
        return ResponseEntity.ok(shoppingCartService.getShoppingCarts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getShoppingCartById(@PathVariable Long id) {
        return ResponseEntity.ok(shoppingCartService.getShoppingCartById(id));
    }

    @PostMapping
    public ResponseEntity<?> createShoppingCart() {
        return ResponseEntity.ok(shoppingCartService.createShoppingCart());
    }

    @PostMapping("/products")
    public ResponseEntity<?> createShoppingCart(@RequestBody ShoppingCartRequestDTO shoppingCartRequestDTO) {
        return ResponseEntity.ok(shoppingCartService.createShoppingCart(shoppingCartRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteShoppingCart(@PathVariable Long id) {
        shoppingCartService.deleteShoppingCart(id);
        return ResponseEntity.ok("Shopping Cart deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateShoppingCart(@PathVariable Long id, @RequestBody ShoppingCartRequestDTO shoppingCartRequestDTO) {
        return ResponseEntity.ok(shoppingCartService.updateShoppingCart(id, shoppingCartRequestDTO));
    }
}
