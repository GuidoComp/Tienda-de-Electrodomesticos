package com.todocode.microservicios.e_commerce.shopping_cart.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shopping_carts")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shoppingCartId;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private double total;
    @ElementCollection
    private List<Long> productsIds;
}
