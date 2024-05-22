package com.example.gestion_de_stock.service;

import com.example.gestion_de_stock.Dao.entities.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoryService {
     public List<Category> getAllCategoryList();

}
