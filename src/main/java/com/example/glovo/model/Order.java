package com.example.glovo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Order {
    private int id;
    private LocalDate date;
    private BigDecimal cost;
    private List<Product> products;
}
