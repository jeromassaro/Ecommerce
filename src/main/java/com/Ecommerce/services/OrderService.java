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
        List<Order> orders = orderRepository.findAll();
        return orders;
    }

    @Override
    public Order createOrder(Order order) {
        order = orderRepository.save(order);
        return order;
    }

    @Override
    public Order updateOrder(Order order, Long id) {
        Order oldOrder = orderRepository.findById(id).orElse(null);
        if (oldOrder == null) return null;
        oldOrder.setTotalPrice(order.getTotalPrice());
        oldOrder.setProduct(order.getProduct());
        oldOrder.setClient(order.getClient());
        oldOrder = orderRepository.save(oldOrder);
        return oldOrder;
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order getOrderbyID(Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        return order;
    }
}
