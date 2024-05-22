package com.example.gestion_de_stock.service;

import com.example.gestion_de_stock.Dao.entities.Produit;
import com.example.gestion_de_stock.Dao.entities.Produit;
import com.example.gestion_de_stock.Dao.repositories.ProduitRepository;
import com.example.gestion_de_stock.Dao.repositories.ProduitRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitManager implements ProduitService{
    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public List<Produit> getAllProduit() {
        try {
            return produitRepository.findAll();
        }catch (Exception e) {

            System.out.println(e.getMessage());
            return null;
        }}

    @Override
    public Produit addProduit(Produit produit) {
        try {
            return produitRepository.save(produit);
        }catch (Exception e) {

            System.out.println(e.getMessage());
            return null;
        }}

    @Override
    public Produit updateProduit(Produit produit) {
        try {
            return produitRepository.save(produit);
        }catch (Exception e) {

            System.out.println(e.getMessage());
            return null;
        }}

    @Override
    public Boolean deleteProduit(Produit produit) {
        try {
            produitRepository.delete(produit);
            return true;
        }catch (Exception e) {

            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Produit getProduitById(Integer id) {
        try{
            return produitRepository.findById(id).get();
        }catch (Exception e){

            System.out.println(e.getMessage());
            return null;

        }

    }

    @Override
    public Boolean deleteProduitById(Integer id) {
        try{
            produitRepository.deleteById(id);
            return  true;
        }catch (Exception e){

            System.out.println(e.getMessage());
            return false;

        }

    }

    @Override
    public Page<Produit> searchProduit(String keyword, int page, int taille) {

        return produitRepository.findBynameContains(keyword, (Pageable) PageRequest.of(page, taille));

    }


}
