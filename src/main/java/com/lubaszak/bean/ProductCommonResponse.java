package com.lubaszak.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductCommonResponse {
    @JsonProperty("foods")
    private Product[] products;


    public Product getProduct() {
        return products[0];
    }


}
