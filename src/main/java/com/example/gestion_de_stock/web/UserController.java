package com.example.gestion_de_stock.web;

import com.example.gestion_de_stock.service.UserService;
import jakarta.servlet.http.HttpSession;
import com.example.gestion_de_stock.Dao.entities.User;
import com.example.gestion_de_stock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
@Controller
public class UserController {
    @Autowired
    UserService userManager ;


    @GetMapping("/rregister")
    public String re() {
        return "RegisterUser"; // Votre page de connexion
    }
    @PostMapping("/register")
    public String registerUser(

            @RequestParam(name = "password") String password ,
            @RequestParam(name = "username") String username )
    {

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userManager.addUser(user);
        return "redirect:/login";

    }

    @GetMapping("login")
    public String login() {
        return "login";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();  // Invalide la session pour déconnecter l'utilisateur
        return "redirect:/login";
    }
}
