package com.todocode.microservicios.e_commerce.shopping_cart.services;

import com.todocode.microservicios.e_commerce.shopping_cart.dtos.ProductDTO;
import com.todocode.microservicios.e_commerce.shopping_cart.dtos.ShoppingCartDTO;
import com.todocode.microservicios.e_commerce.shopping_cart.dtos.ShoppingCartRequestDTO;
import com.todocode.microservicios.e_commerce.shopping_cart.models.ShoppingCart;
import com.todocode.microservicios.e_commerce.shopping_cart.repositories.IShoppingCartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartService implements IShoppingCartService {
    private final IShoppingCartRepository shoppingCartRepository;
    private final IProductsApiClient productsApiClient;
    private final TotalCalculator totalCalculator;

    public ShoppingCartService(IShoppingCartRepository shoppingCartRepository, IProductsApiClient productsApiClient, TotalCalculator totalCalculator) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productsApiClient = productsApiClient;
        this.totalCalculator = totalCalculator;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ShoppingCart> getShoppingCarts() {
        return shoppingCartRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ShoppingCartDTO getShoppingCartById(Long id) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(id).orElse(null);
        if (shoppingCart == null) {
            return null;
        }
        List<ProductDTO> products = this.fetchProducts(shoppingCart.getProductsIds());

        return new ShoppingCartDTO(shoppingCart.getShoppingCartId(), shoppingCart.getTotal(), products);
    }

    @Override
    @Transactional
    public ShoppingCart createShoppingCart() {
        return shoppingCartRepository.save(new ShoppingCart());
    }

    @Override
    @Transactional
    public ShoppingCart createShoppingCart(ShoppingCartRequestDTO shoppingCartRequestDTO) {
        List<Long> productsIds = shoppingCartRequestDTO.getProductsIds();

        ShoppingCart shoppingCart = new ShoppingCart();

        List<ProductDTO> products = this.fetchProducts(productsIds);
        List<Long> productsIdsFromProducts = products.stream()
                .map(ProductDTO::getProductId)
                .collect(Collectors.toList());

        shoppingCart.setProductsIds(productsIdsFromProducts);
        shoppingCart.setTotal(totalCalculator.calculateTotal(products));

        return shoppingCartRepository.save(shoppingCart);
    }

    private List<ProductDTO> fetchProducts(List<Long> productsIds) {
        return productsApiClient.getProductsByIds(productsIds);
    }

    @Override
    @Transactional
    public ShoppingCart updateShoppingCart(Long id, ShoppingCartRequestDTO shoppingCartRequestDTO) {
        ShoppingCart shoppingCartDb = shoppingCartRepository.findById(id).orElse(null);
        if (shoppingCartDb == null) {
            return null;
        }
        List<Long> productsIds = shoppingCartRequestDTO.getProductsIds();

        List<ProductDTO> productsDTOs = this.fetchProducts(productsIds);
        if (productsDTOs == null || productsDTOs.size() == 0) {
            return null;
        }
        shoppingCartDb.setProductsIds(productsIds);
        shoppingCartDb.setTotal(totalCalculator.calculateTotal(productsDTOs));
        return shoppingCartRepository.save(shoppingCartDb);
    }

    @Override
    @Transactional
    public void deleteShoppingCart(Long id) {
        shoppingCartRepository.deleteById(id);
    }
}
