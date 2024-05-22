package com.example.gestion_de_stock.service;

import com.example.gestion_de_stock.Dao.entities.Produit;
import com.example.gestion_de_stock.Dao.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProduitService {
    List<Produit> getAllProduit();
    Produit addProduit(Produit produit);
    Produit updateProduit(Produit produit);
    Boolean deleteProduit(Produit produit);
    Produit getProduitById(Integer id);
    Boolean deleteProduitById(Integer id);

    public Page<Produit> searchProduit(String keyword, int page, int taille);


}
