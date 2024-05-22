package com.example.gestion_de_stock.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import com.example.gestion_de_stock.Dao.entities.Customer;

import java.util.List;

@Component
public interface CustomerService {

    List<Customer> getAllCustomer();
    Customer addCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    Boolean deleteCustomer(Customer customer);
    Customer getCustomerById(Integer id);
    Boolean deleteCustomerById(Integer id);

    public Page<Customer> searchCustomer(String keyword, int page, int taille);

}