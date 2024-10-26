package com.vertical.luizalabs.service;

import com.vertical.luizalabs.model.Order;
import com.vertical.luizalabs.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Optional<Order> findById(Integer orderId) {
        return orderRepository.findById(orderId);
    }

    public List<Order> findOrdersByDateRange(String startDate, String endDate) {
        try {
            // Define the formatter with the correct pattern
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

            // Parse the string into a LocalDate
            return orderRepository.findOrdersByDateRange(LocalDate.parse(startDate, formatter), LocalDate.parse(endDate, formatter));

        } catch (DateTimeParseException e) {
            System.out.println("Error parsing date: " + e.getMessage());
        }
return null;
    }
}