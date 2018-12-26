package com.lubaszak.bean;


import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "food_name",
        "brand_name",
        "serving_qty",
        "serving_unit",
        "serving_weight_grams",
        "nf_calories",
        "nf_total_fat",
        "nf_saturated_fat",
        "nf_cholesterol",
        "nf_sodium",
        "nf_total_carbohydrate",
        "nf_dietary_fiber",
        "nf_sugars",
        "nf_protein",
        "nf_potassium",
        "nf_p",
        "nix_brand_name",
        "nix_brand_id",
        "nix_item_name",
        "nix_item_id"
})


@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    @JsonProperty("food_name")
    public String foodName;
    @JsonProperty("brand_name")
    public String brandName;
    @JsonProperty("serving_qty")
    public Integer servingQty;
    @JsonProperty("serving_unit")
    public String servingUnit;
    @JsonProperty("serving_weight_grams")
    public Integer servingWeightGrams;
    @JsonProperty("nf_calories")
    public Integer calories;
    @JsonProperty("nf_total_fat")
    public Integer totalFat;
    @JsonProperty("nf_saturated_fat")
    public Integer saturatedFat;
    @JsonProperty("nf_cholesterol")
    public Integer cholesterol;
    @JsonProperty("nf_sodium")
    public Integer sodium;
    @JsonProperty("nf_total_carbohydrate")
    public Integer totalCarbohydrate;
    @JsonProperty("nf_dietary_fiber")
    public Integer dietaryFiber;
    @JsonProperty("nf_sugars")
    public Integer sugars;
    @JsonProperty("nf_protein")
    public Integer protein;
    @JsonProperty("nf_potassium")
    public Object potassium;
    @JsonProperty("nf_p")
    public Object nfP;
    @JsonProperty("nix_brand_name")
    public String nixBrandName;
    @JsonProperty("nix_brand_id")
    public String nixBrandId;
    @JsonProperty("nix_item_name")
    public String nixItemName;
    @JsonProperty("nix_item_id")
    public String nixItemId;


    public String getFoodName() {
        return foodName;
    }

    public String getBrandName() {
        return brandName;
    }

    public Integer getServingQty() {
        return servingQty;
    }

    public String getServingUnit() {
        return servingUnit;
    }

    public Integer getServingWeightGrams() {
        return servingWeightGrams;
    }

    public Integer getCalories() {
        return calories;
    }

    public Integer getTotalFat() {
        return totalFat;
    }

    public Integer getSaturatedFat() {
        return saturatedFat;
    }

    public Integer getCholesterol() {
        return cholesterol;
    }

    public Integer getSodium() {
        return sodium;
    }

    public Integer getTotalCarbohydrate() {
        return totalCarbohydrate;
    }

    public Integer getDietaryFiber() {
        return dietaryFiber;
    }

    public Integer getSugars() {
        return sugars;
    }

    public Integer getProtein() {
        return protein;
    }

    public Object getPotassium() {
        return potassium;
    }

    public Object getNfP() {
        return nfP;
    }

    public String getNixBrandName() {
        return nixBrandName;
    }

    public String getNixBrandId() {
        return nixBrandId;
    }

    public String getNixItemName() {
        return nixItemName;
    }

    public String getNixItemId() {
        return nixItemId;
    }
}
