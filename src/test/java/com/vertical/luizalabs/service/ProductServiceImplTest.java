package com.vertical.luizalabs.service;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.vertical.luizalabs.model.Order;
import com.vertical.luizalabs.model.Product;
import com.vertical.luizalabs.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddProductToExistingOrderWithNewProduct() {
        // Arrange
        Order existingOrder = new Order();
        existingOrder.setOrderId(1);
        existingOrder.setTotal(100.0);
        List<Product> products = new ArrayList<>();
        existingOrder.setProducts(products);

        Product newProduct = new Product();
        newProduct.setProductId(2);
        newProduct.setValue(50.0);

        when(orderRepository.findById(1)).thenReturn(Optional.of(existingOrder));

        // Act
        productService.addProductToOrder(existingOrder, newProduct);

        // Assert
        assertEquals(150.0, existingOrder.getTotal());
        assertTrue(existingOrder.getProducts().contains(newProduct));
        verify(orderRepository, times(1)).save(existingOrder);
    }

    @Test
    public void testAddProductToExistingOrderWithExistingProduct() {
        // Arrange
        Order existingOrder = new Order();
        existingOrder.setOrderId(1);
        existingOrder.setTotal(100.0);
        Product existingProduct = new Product();
        existingProduct.setProductId(2);
        existingProduct.setValue(50.0);
        List<Product> products = new ArrayList<>();
        products.add(existingProduct);
        existingOrder.setProducts(products);

        when(orderRepository.findById(1)).thenReturn(Optional.of(existingOrder));

        // Act
        productService.addProductToOrder(existingOrder, existingProduct);

        // Assert
        assertEquals(100.0, existingOrder.getTotal()); // Total should remain the same
        assertTrue(existingOrder.getProducts().contains(existingProduct)); // Product is already there
        verify(orderRepository, times(1)).save(existingOrder);
    }

    @Test
    public void testAddProductToNewOrder() {
        // Arrange
        Order newOrder = new Order();
        newOrder.setOrderId(2);
        newOrder.setTotal(0.0);

        Product newProduct = new Product();
        newProduct.setProductId(3);
        newProduct.setValue(75.0);

        when(orderRepository.findById(2)).thenReturn(Optional.empty());

        // Act
        productService.addProductToOrder(newOrder, newProduct);

        // Assert
        assertEquals(75.0, newOrder.getTotal()); // New order, total is the product's value
        assertTrue(newOrder.getProducts().contains(newProduct)); // Product is added
        verify(orderRepository, times(1)).save(newOrder);
    }
}
