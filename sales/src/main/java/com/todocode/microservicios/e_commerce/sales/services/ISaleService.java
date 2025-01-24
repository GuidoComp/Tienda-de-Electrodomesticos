package com.todocode.microservicios.e_commerce.sales.services;

import com.todocode.microservicios.e_commerce.sales.dtos.SaleDTO;
import com.todocode.microservicios.e_commerce.sales.models.Sale;

import java.util.List;

public interface ISaleService {
    List<Sale> getSales();

    SaleDTO getSaleById(Long id);

    Sale createSale(Sale sale);

    void deleteSale(Long id);

    Sale updateSale(Long id, Sale sale);
}

