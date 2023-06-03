package com.example.glovo.service;

import com.example.glovo.model.Order;

import java.util.List;

public interface OrderService {
    Order getById(int id);
    List<Order> getAll();
    void addOrder(Order order);
}
