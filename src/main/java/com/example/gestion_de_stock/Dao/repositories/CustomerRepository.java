package com.example.gestion_de_stock.Dao.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.gestion_de_stock.Dao.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Page<Customer> findByfirstnameContains(String keyword, Pageable pageable);
}
