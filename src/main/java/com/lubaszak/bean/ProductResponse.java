package com.lubaszak.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductResponse {
    @JsonProperty("branded")
    private ProductInfo[] branded;

    public ProductInfo[] getBranded() {
        return branded;
    }

    public void setBranded(ProductInfo[] branded) {
        this.branded = branded;
    }
}