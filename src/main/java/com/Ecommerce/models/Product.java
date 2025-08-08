package com.Ecommerce.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "products")
public class Product {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private double price;
    private String image;
    private int stock;

    @OneToMany(mappedBy = "product")
    private List<Order> orders;
}
