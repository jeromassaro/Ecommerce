package com.Ecommerce.services;

import com.Ecommerce.models.Order;

import java.util.List;

public interface IOrderService {

    List<Order> getOrders();
    Order createOrder(Order oder);
    Order updateOrder(Order oder);
    void deleteOrder(int id);
    Order getOrderbyID(int id);
}
