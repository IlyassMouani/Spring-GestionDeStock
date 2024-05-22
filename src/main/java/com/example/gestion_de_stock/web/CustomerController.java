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
import com.example.gestion_de_stock.Dao.entities.Customer;
import com.example.gestion_de_stock.service.CustomerService;

@Controller
public class CustomerController {

    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }

        @Autowired
        private CustomerService customerService ;

        @PostMapping("/savecustomer")
        public String ajoutercust(Model model,
                                   @Valid Customer customer ,
                                   BindingResult bindingResult) {
            customerService.addCustomer(customer);
            return "redirect:/indexpage";
        }


        @GetMapping("indexlayoutcustomer")
        public String acc() {
            return "redirect:/listcustomer";
        }








        @GetMapping("/deletecustomer")
        public String deletecustomer(@RequestParam(name = "id") Integer id) {
            if (customerService.deleteCustomerById(id)) {
                return "redirect:/listcustomer";
            } else {
                return "error";
            }
        }


        @PostMapping("/ajouter")
        public String modifiercustomerAction(Model model,
                                          @RequestParam(name = "id") Integer id,
                                          @RequestParam(name = "firstname") String prenom,
                                          @RequestParam(name = "lastname") String nom,
                                          @RequestParam(name = "email") String email,
                                          @RequestParam(name = "phone") String tel,
                                          @RequestParam(name = "city") String ville) {
            Customer customer  = customerService.getCustomerById(id);
            if (customer != null) {
                customer.setFirstname(prenom);
                customer.setLastname(nom);
                customer.setEmail(email);
                customer.setPhone(tel);
                customer.setCity(ville);
                customerService.updateCustomer(customer);
                return "redirect:/listcustomer";
            } else {
                return "error";
            }
        }



        @GetMapping("/ajoutercustomer")
        public String ajoutercustomer(Model model) {
            model.addAttribute("Customer", new Customer());
            return "ajoutercustomer";
        }



        @PostMapping("/ajouterOnce")
        public String ajouteracustomer(Model model,
                                    @Valid Customer customer  ,
                                    BindingResult bindingResult) {
            if (bindingResult.hasErrors()) {
                return "ajoutercustomer";
            }
            customerService.addCustomer(customer);
            return "redirect:/listcustomer";
        }



        @GetMapping("/listcustomer")
        public String listcustomer(Model model,
                                @RequestParam(name = "page", defaultValue = "0") int page,
                                @RequestParam(name = "taille", defaultValue = "6") int taille,
                                @RequestParam(name = "search", defaultValue = "") String keyword) {
            Page<Customer> customer = customerService.searchCustomer(keyword, page, taille);
            model.addAttribute("listCustomer", customer.getContent());

            int[] pages = new int[customer.getTotalPages()];
            model.addAttribute("pages", pages);
            model.addAttribute("keyword", keyword);
            model.addAttribute("page", page);
            return "indexlayoutcustomer";
        }



        @GetMapping("/editcustomer")
        public String editcustomerAction(Model model, @RequestParam(name = "id") Integer id) {
            Customer customer  = customerService.getCustomerById(id);
            if (customer != null) {
                model.addAttribute("CustomerToBeUpdated", customer);
                return "updatecustomer";
            } else {
                return "error";
            }
        }


}










