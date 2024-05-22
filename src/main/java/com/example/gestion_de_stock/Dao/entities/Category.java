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

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Produit> products;
}
