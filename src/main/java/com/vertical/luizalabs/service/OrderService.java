package com.vertical.luizalabs.service;

import com.vertical.luizalabs.model.Order;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    Optional<Order> findById(Integer orderId);
    List<Order> findOrdersByDateRange(String startDate, String endDate);
}