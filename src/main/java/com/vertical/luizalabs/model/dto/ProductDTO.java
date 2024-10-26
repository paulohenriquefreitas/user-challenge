package com.vertical.luizalabs.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ProductDTO {
    @JsonProperty("product_id")
    private int productId;
    @JsonProperty("value")
    private double value;
}
