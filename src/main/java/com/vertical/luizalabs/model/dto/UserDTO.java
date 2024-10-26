package com.vertical.luizalabs.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vertical.luizalabs.model.Order;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
public class UserDTO {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("orders")
    private List<Order> orders;
}
