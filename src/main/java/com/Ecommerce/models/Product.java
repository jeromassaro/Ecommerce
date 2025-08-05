package com.Ecommerce.models;

import jakarta.persistence.*;
import lombok.*;

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
}
