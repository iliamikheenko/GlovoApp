package com.example.glovo.service.impl;

import com.example.glovo.model.Order;
import com.example.glovo.service.OrderService;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private final List<Order> orders = new ArrayList<>();

    @Override
    public Order getById(int id) {
        return orders.stream()
                .filter(o -> o.getId() == id)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Not found"));
    }

    @Override
    public List<Order> getAll() {
        return orders;
    }

    @Override
    public void addOrder(Order order) {
        orders.add(order);
    }
}
