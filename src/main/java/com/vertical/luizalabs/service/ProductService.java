package com.vertical.luizalabs.service;

import com.vertical.luizalabs.model.Order;
import com.vertical.luizalabs.model.Product;
import com.vertical.luizalabs.model.User;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product save(Product user);
    void addProductToOrder(Order order, Product product);

}