package com.lubaszak.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResponse {
    @JsonProperty("branded")
    private BrandedProductInfo[] branded;

    @JsonProperty("common")
    private CommonFoodInfo[] common;

    public BrandedProductInfo[] getBranded() {
        return branded;
    }

    public void setBranded(BrandedProductInfo[] branded) {
        this.branded = branded;
    }

    public CommonFoodInfo[] getCommon() {
        return common;
    }

    public void setCommon(CommonFoodInfo[] common) {
        this.common = common;
    }
}