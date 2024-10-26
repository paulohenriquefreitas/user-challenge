package com.vertical.luizalabs.repository;

import com.vertical.luizalabs.model.Product;
import com.vertical.luizalabs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}