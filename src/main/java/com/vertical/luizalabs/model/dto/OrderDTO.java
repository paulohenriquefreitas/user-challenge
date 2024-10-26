package com.vertical.luizalabs.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vertical.luizalabs.model.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
public class OrderDTO {
    @JsonProperty("order_id")
    private int orderId;
    @JsonProperty("total")
    private double total;
    @JsonProperty("date")
    private String date;
    @JsonProperty("products")
    private List<Product> products;
}
