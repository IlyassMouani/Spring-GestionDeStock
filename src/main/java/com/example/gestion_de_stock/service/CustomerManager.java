package com.example.gestion_de_stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.gestion_de_stock.Dao.entities.Customer;
import com.example.gestion_de_stock.Dao.repositories.CustomerRepository;

import java.util.List;

@Service
public class CustomerManager implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomer() {
      try {
          return customerRepository.findAll();
      }catch (Exception e) {

          System.out.println(e.getMessage());
          return null;
      }}

    @Override
    public Customer addCustomer(Customer customer) {
        try {
            return customerRepository.save(customer);
        }catch (Exception e) {

            System.out.println(e.getMessage());
            return null;
        }}

    @Override
    public Customer updateCustomer(Customer customer) {
        try {
            return customerRepository.save(customer);
        }catch (Exception e) {

            System.out.println(e.getMessage());
            return null;
        }}

    @Override
    public Boolean deleteCustomer(Customer customer) {
        try {
             customerRepository.delete(customer);
            return true;
        }catch (Exception e) {

            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Customer getCustomerById(Integer id) {
        try{
        return customerRepository.findById(id).get();
        }catch (Exception e){

            System.out.println(e.getMessage());
            return null;

        }

    }

    @Override
    public Boolean deleteCustomerById(Integer id) {
        try{
            customerRepository.deleteById(id);
            return  true;
        }catch (Exception e){

            System.out.println(e.getMessage());
            return false;

        }

    }

    @Override
    public Page<Customer> searchCustomer(String keyword, int page, int taille) {

        return customerRepository.findByfirstnameContains(keyword, (Pageable) PageRequest.of(page, taille));

    }

}
