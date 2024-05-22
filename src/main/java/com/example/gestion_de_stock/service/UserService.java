package com.example.gestion_de_stock.service;

import com.example.gestion_de_stock.Dao.entities.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserService {

    public User getUserById(Integer id);

    public User addUser(User e);

    public User getFirst() ;
    public User getUserByUsername(String username) ;

}