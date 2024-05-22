package com.example.gestion_de_stock.Dao.repositories;

import com.example.gestion_de_stock.Dao.entities.Customer;
import com.example.gestion_de_stock.Dao.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository  extends JpaRepository<Produit,Integer> {

    Page<Produit> findBynameContains(String keyword, Pageable pageable);
}
