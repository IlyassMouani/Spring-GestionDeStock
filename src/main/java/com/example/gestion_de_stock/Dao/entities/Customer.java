package com.example.gestion_de_stock.Dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private String city;

    @OneToMany(mappedBy = "customer")
    private List<Produit> produits;
}
