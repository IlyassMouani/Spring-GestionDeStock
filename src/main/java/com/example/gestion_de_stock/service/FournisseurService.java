package com.example.gestion_de_stock.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import com.example.gestion_de_stock.Dao.entities.Fournisseur;

import java.util.List;

@Component
public interface FournisseurService {

    List<Fournisseur> getAllFournisseur();
    Fournisseur addFournisseur(Fournisseur fournisseur);
    Fournisseur updateFournisseur(Fournisseur fournisseur);
    Boolean deleteFournisseur(Fournisseur fournisseur);
    Fournisseur getFournisseurById(Integer id);
    Boolean deleteFournisseurById(Integer id);

    public Page<Fournisseur> searchFournisseur(String keyword, int page, int taille);

}