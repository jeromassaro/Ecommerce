package com.Ecommerce.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "clients")
public class Client {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String city;
    private String address;
    @Column(unique = true)
    private int dni;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "client")
    private List<Order> orders;
}
