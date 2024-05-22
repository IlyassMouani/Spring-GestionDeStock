package com.example.gestion_de_stock.Dao.repositories;

import com.example.gestion_de_stock.Dao.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository  extends JpaRepository<User,Integer>{
    public User findUserById(Integer id ) ;
    public List<User> findAll() ;
    public User  findByUsername(String username);
}
