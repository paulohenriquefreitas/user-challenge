package com.vertical.luizalabs.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "products")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @Column(name="product_id")
    private Integer productId;
    @Column(name = "product_value")
    private double value;
    @JsonIgnore
    @ManyToMany(mappedBy = "products")
    private List<Order> orders = new ArrayList<>();

}
