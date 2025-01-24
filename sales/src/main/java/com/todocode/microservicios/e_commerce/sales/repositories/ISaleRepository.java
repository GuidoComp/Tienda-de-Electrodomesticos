package com.todocode.microservicios.e_commerce.sales.repositories;

import com.todocode.microservicios.e_commerce.sales.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISaleRepository extends JpaRepository<Sale, Long> {
}
