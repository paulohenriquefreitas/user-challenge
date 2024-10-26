package com.vertical.luizalabs.controller;

import com.vertical.luizalabs.model.Order;
import com.vertical.luizalabs.model.Product;
import com.vertical.luizalabs.model.User;
import com.vertical.luizalabs.service.ProductService;
import com.vertical.luizalabs.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    private final ProductService productService;
    @GetMapping("/")
    public List<User> getAll() {
        return userService.getAll();
    }


    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    ResponseEntity<?> saveUser(@RequestPart(name = "file") MultipartFile file) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        if (!file.isEmpty()) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                String line;
                // Read each line from the file
                while ((line = reader.readLine()) != null) {
                    int userId = Integer.parseInt(line.substring(0,10));
                    String userName = line.substring(11,55).trim();
                    int orderId = Integer.parseInt(line.substring(56,65));
                    Integer productId = Integer.parseInt(line.substring(66,75));
                    double value = Double.parseDouble(line.substring(76,87));
                    LocalDate parsedDate = LocalDate.parse(line.substring(87,95), formatter);
                    Product product = Product.builder().productId(productId).value(value).build();
                    User user = User.builder().userId(userId).name(userName).build();
                    List<Product> products = new ArrayList<>();
                    products.add(product);
                    Order order = Order.builder().orderId(orderId).date(parsedDate.toString()).user(user).products(products).build();
                    productService.save(product);
                    productService.addProductToOrder(order, product);
                }
            }
        } else {
            return new ResponseEntity<>("This file is empty.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("File uploaded successfully!", HttpStatus.CREATED);
        }
}
