package com.Ecommerce.services;

import com.Ecommerce.models.Order;
import com.Ecommerce.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getOrders() {
        return List.of();
    }

    @Override
    public Order createOrder(Order oder) {
        return null;
    }

    @Override
    public Order updateOrder(Order oder) {
        return null;
    }

    @Override
    public void deleteOrder(int id) {

    }

    @Override
    public Order getOrderbyID(int id) {
        return null;
    }
}
