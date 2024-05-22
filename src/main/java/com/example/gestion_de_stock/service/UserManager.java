package com.example.gestion_de_stock.service;
import  com.example.gestion_de_stock.Dao.entities.User;
import  com.example.gestion_de_stock.Dao.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserManager implements UserService{
    @Autowired
    UserRepository userRepository ;
    @Override
    public User getUserById(Integer id) {
        return userRepository.findUserById(id) ;
    }

    @Override
    public User addUser(User e) {
        return userRepository.save(e);
    }

    @Override
    public User getFirst() {
        return userRepository.findAll().get(0);
    }

    @Override
    public User getUserByUsername(String username) {
        return  userRepository.findByUsername(username);
    }
}
