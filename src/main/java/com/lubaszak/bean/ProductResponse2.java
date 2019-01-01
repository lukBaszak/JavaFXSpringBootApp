package com.lubaszak.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductResponse2 {
    @JsonProperty("foods")
    private Product[] products;


    public Product getProduct() {
        return products[0];
    }


}
