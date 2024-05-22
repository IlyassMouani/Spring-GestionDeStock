package com.example.gestion_de_stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.gestion_de_stock.Dao.entities.Fournisseur;
import com.example.gestion_de_stock.Dao.repositories.FournisseurRepository;

import java.util.List;

@Service
public class FournisseurManager implements FournisseurService {
    @Autowired
    private FournisseurRepository fournisseurRepository;

    @Override
    public List<Fournisseur> getAllFournisseur() {
        try {
            return fournisseurRepository.findAll();
        }catch (Exception e) {

            System.out.println(e.getMessage());
            return null;
        }}

    @Override
    public Fournisseur addFournisseur(Fournisseur fournisseur) {
        try {
            return fournisseurRepository.save(fournisseur);
        }catch (Exception e) {

            System.out.println(e.getMessage());
            return null;
        }}

    @Override
    public Fournisseur updateFournisseur(Fournisseur fournisseur) {
        try {
            return fournisseurRepository.save(fournisseur);
        }catch (Exception e) {

            System.out.println(e.getMessage());
            return null;
        }}

    @Override
    public Boolean deleteFournisseur(Fournisseur fournisseur) {
        try {
            fournisseurRepository.delete(fournisseur);
            return true;
        }catch (Exception e) {

            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Fournisseur getFournisseurById(Integer id) {
        try{
            return fournisseurRepository.findById(id).get();
        }catch (Exception e){

            System.out.println(e.getMessage());
            return null;

        }

    }

    @Override
    public Boolean deleteFournisseurById(Integer id) {
        try{
            fournisseurRepository.deleteById(id);
            return  true;
        }catch (Exception e){

            System.out.println(e.getMessage());
            return false;

        }

    }

    @Override
    public Page<Fournisseur> searchFournisseur(String keyword, int page, int taille) {

        return fournisseurRepository.findByfirstnameContains(keyword, (Pageable) PageRequest.of(page, taille));

    }

}
