package com.example.gestion_de_stock.Dao.repositories;

import com.example.gestion_de_stock.Dao.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category,Integer> {
}
