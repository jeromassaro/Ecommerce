package com.Ecommerce.services;

import com.Ecommerce.models.Order;

import java.util.List;

public interface IOrderService {

    List<Order> getOrders();
    Order createOrder(Order order);
    Order updateOrder(Order order,Long id);
    void deleteOrder(Long id);
    Order getOrderbyID(Long id);
}
