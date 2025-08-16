package com.Ecommerce.controllers;

import com.Ecommerce.models.Order;
import com.Ecommerce.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getOrders(){
        List<Order> orders = orderService.getOrders();
        if (orders == null || orders.isEmpty()) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(orders, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById (@PathVariable Long id){
        Order order = orderService.getOrderbyID(id);
        if (order == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(order, HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder (@RequestBody Order order , @PathVariable Long id){
        Order updatedOrder = orderService.updateOrder(order,id);
        if (updatedOrder == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Order> createOrder (@RequestBody Order order){
        order = orderService.createOrder(order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder (@PathVariable Long id){
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
