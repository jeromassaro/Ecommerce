package com.Ecommerce.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate orderDate;
    private double totalPrice;
    @ManyToOne
    @JoinColumn(name = "fkIdClient")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "fkProduct")
    private Product product;

    // A la hora de crear una orden se asigna la fecha y hora del momento de creacion.
    @PrePersist
    protected void onCreate(){
        this.orderDate = LocalDate.now();
    }

}
