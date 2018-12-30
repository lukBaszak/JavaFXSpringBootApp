package com.lubaszak.bean;



import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "food_name",
        "serving_unit",
        "nix_brand_id",
        "brand_name_item_name",
        "serving_qty",
        "nf_calories",
        "brand_name",
        "brand_type",
        "nix_item_id"
})

@JsonIgnoreProperties(ignoreUnknown = true)

public class BrandedProductInfo {

    @JsonProperty("food_name")
    public String foodName;
    @JsonProperty("serving_unit")
    public String servingUnit;
    @JsonProperty("nix_brand_id")
    public String nixBrandId;
    @JsonProperty("brand_name_item_name")
    public String brandNameItemName;
    @JsonProperty("serving_qty")
    public Integer servingQty;
    @JsonProperty("nf_calories")
    public Integer nfCalories;
    @JsonProperty("brand_name")
    public String brandName;
    @JsonProperty("brand_type")
    public Integer brandType;
    @JsonProperty("nix_item_id")
    public String nixItemId;


    public String getFoodName() {
        return foodName;
    }

    public String getServingUnit() {
        return servingUnit;
    }

    public String getNixBrandId() {
        return nixBrandId;
    }

    public String getBrandNameItemName() {
        return brandNameItemName;
    }

    public Integer getServingQty() {
        return servingQty;
    }

    public Integer getNfCalories() {
        return nfCalories;
    }

    public String getBrandName() {
        return brandName;
    }

    public Integer getBrandType() {
        return brandType;
    }

    public String getNixItemId() {
        return nixItemId;
    }
}
