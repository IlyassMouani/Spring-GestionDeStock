package com.example.gestion_de_stock.web;

import com.example.gestion_de_stock.Dao.entities.Category;
import com.example.gestion_de_stock.Dao.entities.Fournisseur;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.gestion_de_stock.Dao.entities.Produit;
import com.example.gestion_de_stock.service.ProduitService;

@Controller
public class ProduitController {


    @Autowired
    private ProduitService produitService ;

    @PostMapping("/saveproduit")
    public String ajoutercust(Model model,
                              @Valid Produit produit ,
                              BindingResult bindingResult) {
        produitService.addProduit(produit);
        return "redirect:/indexpage";
    }


    @GetMapping("indexlayoutproduit")
    public String acc() {
        return "redirect:/listproduit";
    }




    @GetMapping("/deleteproduit")
    public String deleteproduit(@RequestParam(name = "id") Integer id) {
        if (produitService.deleteProduitById(id)) {
            return "redirect:/listproduit";
        } else {
            return "error";
        }
    }


    @PostMapping("/ajouterP")
    public String modifierproduitAction(Model model,
                                         @RequestParam(name = "id") Integer id,
                                         @RequestParam(name = "name") String nom,
                                         @RequestParam(name = "description") String description,
                                         @RequestParam(name = "price") Double prix) {
        Produit produit  = produitService.getProduitById(id);
        if (produit != null) {
            produit.setName(nom);
            produit.setDescription(description);
            produit.setPrice(prix);
            produitService.updateProduit(produit);
            return "redirect:/listproduit";
        } else {
            return "error";
        }
    }



    @GetMapping("/ajouterproduit")
    public String ajouterproduit(Model model) {
        model.addAttribute("Produit", new Produit());
        return "ajouterproduit";
    }



    @PostMapping("/ajouterOncee")
    public String ajouteraproduit(Model model,
                                   @Valid Produit produit  ,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "ajouterproduit";
        }
        produitService.addProduit(produit);
        return "redirect:/listproduit";
    }



    @GetMapping("/listproduit")
    public String listproduit(Model model,
                               @RequestParam(name = "page", defaultValue = "0") int page,
                               @RequestParam(name = "taille", defaultValue = "6") int taille,
                               @RequestParam(name = "search", defaultValue = "") String keyword) {
        Page<Produit> produit = produitService.searchProduit(keyword, page, taille);
        model.addAttribute("listProduit", produit.getContent());

        int[] pages = new int[produit.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        return "indexlayoutproduit";
    }



    @GetMapping("/editproduit")
    public String editproduitAction(Model model, @RequestParam(name = "id") Integer id) {
        Produit produit  = produitService.getProduitById(id);
        if (produit != null) {
            model.addAttribute("ProduitToBeUpdated", produit);
            return "updateproduit";
        } else {
            return "error";
        }
    }
}









