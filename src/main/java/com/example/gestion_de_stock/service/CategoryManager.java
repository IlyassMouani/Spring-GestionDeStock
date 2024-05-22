package com.example.gestion_de_stock.service;

import com.example.gestion_de_stock.Dao.entities.Category;
import com.example.gestion_de_stock.Dao.repositories.CategoryRepository;
import com.example.gestion_de_stock.Dao.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategoryList() {
        return categoryRepository.findAll() ;
    }



}
