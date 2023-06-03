package com.example.glovo.service.impl;

import com.example.glovo.model.Order;
import com.example.glovo.service.OrderService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class OrderServiceImplTest {
    private OrderService orderService;
    private Order order1;
    private Order order2;
    @Before
    public void setUp() {
        orderService = new OrderServiceImpl();
    }
    @BeforeEach
    void init(){
       order1 = Order.builder()
                .id(1)
                .cost(BigDecimal.valueOf(12))
                .build();
       order2 = Order.builder()
                .id(2)
                .cost(BigDecimal.valueOf(13))
                .build();
    }

    @Test
    public void testGetById() {
        orderService.addOrder(order1);
        orderService.addOrder(order2);

        Order result = orderService.getById(2);

        assertEquals(order2, result);
    }

    @Test
    public void testGetById_InvalidId() {
        orderService.addOrder(order1);
        orderService.addOrder(order2);

        assertThrows(IllegalArgumentException.class,
                ()-> orderService.getById(3));
    }

    @Test
    public void testGetAll() {
        orderService.addOrder(order1);
        orderService.addOrder(order2);

        List<Order> result = orderService.getAll();

        assertEquals(2, result.size());
        assertTrue(result.contains(order1));
        assertTrue(result.contains(order2));
    }

    @Test
    public void testAddOrder() {
        orderService.addOrder(order1);

        List<Order> orders = orderService.getAll();
        assertEquals(1, orders.size());
        assertTrue(orders.contains(order1));
    }
}
