package com.todocode.microservicios.e_commerce.sales.services;

import com.todocode.microservicios.e_commerce.sales.dtos.SaleDTO;
import com.todocode.microservicios.e_commerce.sales.dtos.ShoppingCartDTO;
import com.todocode.microservicios.e_commerce.sales.models.Sale;
import com.todocode.microservicios.e_commerce.sales.repositories.ISaleRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaleService implements ISaleService {
    private final ISaleRepository saleRepository;
    private final IShoppingCartApiClient shoppingCartApi;

    public SaleService(ISaleRepository saleRepository, IShoppingCartApiClient shoppingCartApi) {
        this.saleRepository = saleRepository;
        this.shoppingCartApi = shoppingCartApi;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Sale> getSales() {
        return saleRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public SaleDTO getSaleById(Long id) {
        Sale sale = saleRepository.findById(id).orElse(null);
        if (sale == null) {
            return null;
        }
        Long shoppingCartId = sale.getShoppingCart();
        SaleDTO saleDTO = new SaleDTO();
        saleDTO.setDate(sale.getDate());
        saleDTO.setSaleId(sale.getSaleId());
//        try {
//            saleDTO.setShoppingCart(fetchShoppingCartsById(shoppingCartId));
//        } catch (RuntimeException e) {
//            return null;
//        }

        saleDTO.setShoppingCart(fetchShoppingCartsById(shoppingCartId));

        //createException();
        return saleDTO;
    }

    private void createException() {
        throw new RuntimeException("Error al obtener el carrito de compras");
    }

    @CircuitBreaker(name = "shopping-cart", fallbackMethod = "fallbackFetchProducts")
    @Retry(name = "shopping-cart")
    private ShoppingCartDTO fetchShoppingCartsById(Long shoppingCartId) {
        return shoppingCartApi.getShoppingCartById(shoppingCartId);
    }

    private void fallbackFetchProducts(Long shoppingCartId, Throwable throwable) {
        throw new RuntimeException("No se pudo obtener el carrito de compras con id: " + shoppingCartId);
    }

    @Transactional
    @Override
    public Sale createSale(Sale sale) {
        return saleRepository.save(sale);
    }

    @Transactional
    @Override
    public void deleteSale(Long id) {
        saleRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Sale updateSale(Long id, Sale sale) {
        Sale saleToUpdate = saleRepository.findById(id).orElse(null);
        if (saleToUpdate == null) {
            return null;
        }
        saleToUpdate.setDate(sale.getDate());
        saleToUpdate.setShoppingCart(sale.getShoppingCart());
        return saleRepository.save(saleToUpdate);
    }
}
