package com.example.gestion_de_stock.web;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.gestion_de_stock.Dao.entities.Fournisseur;
import com.example.gestion_de_stock.service.FournisseurService;

@Controller
public class FournisseurController {


    @Autowired
    private FournisseurService fournisseurService ;

    @PostMapping("/savefournisseur")
    public String ajoutercust(Model model,
                              @Valid Fournisseur fournisseur ,
                              BindingResult bindingResult) {
        fournisseurService.addFournisseur(fournisseur);
        return "redirect:/indexpage";
    }


    @GetMapping("indexlayoutfournisseur")
    public String acc() {
        return "redirect:/listfournisseur";
    }



    @GetMapping("/deletefournisseur")
    public String deletefournisseur(@RequestParam(name = "id") Integer id) {
        if (fournisseurService.deleteFournisseurById(id)) {
            return "redirect:/listfournisseur";
        } else {
            return "error";
        }
    }


    @PostMapping("/ajouterF")
    public String modifierfournisseurAction(Model model,
                                         @RequestParam(name = "id") Integer id,
                                         @RequestParam(name = "firstname") String prenom,
                                         @RequestParam(name = "lastname") String nom,
                                         @RequestParam(name = "email") String email,
                                         @RequestParam(name = "phone") String tel,
                                         @RequestParam(name = "city") String ville) {
        Fournisseur fournisseur  = fournisseurService.getFournisseurById(id);
        if (fournisseur != null) {
            fournisseur.setFirstname(prenom);
            fournisseur.setLastname(nom);
            fournisseur.setEmail(email);
            fournisseur.setPhone(tel);
            fournisseur.setCity(ville);
            fournisseurService.updateFournisseur(fournisseur);
            return "redirect:/listfournisseur";
        } else {
            return "error";
        }
    }



    @GetMapping("/ajouterfournisseur")
    public String ajouterfournisseur(Model model) {
        model.addAttribute("Fournisseur", new Fournisseur());
        return "ajouterfournisseur";
    }



    @PostMapping("/ajouterOnceee")
    public String ajouterafournisseur(Model model,
                                   @Valid Fournisseur fournisseur  ,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "ajouterfournisseur";
        }
        fournisseurService.addFournisseur(fournisseur);
        return "redirect:/listfournisseur";
    }



    @GetMapping("/listfournisseur")
    public String listfournisseur(Model model,
                               @RequestParam(name = "page", defaultValue = "0") int page,
                               @RequestParam(name = "taille", defaultValue = "6") int taille,
                               @RequestParam(name = "search", defaultValue = "") String keyword) {
        Page<Fournisseur> fournisseur = fournisseurService.searchFournisseur(keyword, page, taille);
        model.addAttribute("listFournisseur", fournisseur.getContent());

        int[] pages = new int[fournisseur.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        return "indexlayoutfournisseur";
    }



    @GetMapping("/editfournisseur")
    public String editfournisseurAction(Model model, @RequestParam(name = "id") Integer id) {
        Fournisseur fournisseur  = fournisseurService.getFournisseurById(id);
        if (fournisseur != null) {
            model.addAttribute("FournisseurToBeUpdated", fournisseur);
            return "updatefournisseur";
        } else {
            return "error";
        }
    }

}









