package com.vertical.luizalabs.service;

import com.vertical.luizalabs.model.Order;
import com.vertical.luizalabs.model.Product;
import com.vertical.luizalabs.repository.OrderRepository;
import com.vertical.luizalabs.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void addProductToOrder(Order order, Product product) {
        Optional<Order> orderResult = orderRepository.findById(order.getOrderId());
        if (orderResult.isPresent()) {
            if(!orderResult.get().getProducts().contains(product)) {
                Double total = orderResult.get().getTotal();
                total += product.getValue();
                orderResult.get().setTotal(handleTotal(total));
                List<Product> list = orderResult.get().getProducts();
                list.add(product);
                orderResult.get().setProducts(list);
            }
            orderRepository.save(orderResult.get());

        } else {
            List<Product> products = new ArrayList<>();
            products.add(product);
            order.setProducts(products);
            order.setTotal(product.getValue());
            orderRepository.save(order);
        }
    }

    private double handleTotal(Double total) {
        return BigDecimal.valueOf(total).setScale(2, RoundingMode.HALF_UP).doubleValue();

    }
}
