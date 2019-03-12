package com.lubaszak.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    @JsonProperty("food_name")
     private String foodName;
    @JsonProperty("brand_name")
    private String brandName;
    @JsonProperty("serving_qty")
    private Integer servingQty;
    @JsonProperty("serving_unit")
    private String servingUnit;
    @JsonProperty("serving_weight_grams")
    private double servingWeightGrams;
    @JsonProperty("nf_calories")
    private double calories;
    @JsonProperty("nf_total_fat")
    private Integer totalFat;
    @JsonProperty("nf_saturated_fat")
    private Integer saturatedFat;
    @JsonProperty("nf_cholesterol")
    private Integer cholesterol;
    @JsonProperty("nf_sodium")
    private Integer sodium;
    @JsonProperty("nf_total_carbohydrate")
    private Integer totalCarbohydrate;
    @JsonProperty("nf_dietary_fiber")
    private Integer dietaryFiber;
    @JsonProperty("nf_sugars")
    private Integer sugars;
    @JsonProperty("nf_protein")
    private Integer protein;
    @JsonProperty("nf_potassium")
    private Object potassium;
    @JsonProperty("nf_p")
    private Object nfP;
    @JsonProperty("nix_brand_name")
    private String nixBrandName;
    @JsonProperty("nix_brand_id")
    private String nixBrandId;
    @JsonProperty("nix_item_name")
    private String nixItemName;
    @JsonProperty("nix_item_id")
    private String nixItemId;
    @JsonProperty("alt_measures")
    private Measures[] measures;
    @JsonProperty("photo")
    private Photo photo;



    private String quantity;


    public String getQuantity() { return quantity; }
    public void setQuantity(String quantity) { this.quantity = quantity; }
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
    public double getServingWeightGrams() {
        return servingWeightGrams;
    }
    public double getCalories() {
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

    public Measures[] getMeasures() {
        return measures;
    }
    public Photo getPhoto() {return photo;}

    public static class Photo {
        @JsonProperty("thumb")
        String thumb;


        public String getThumb() {
            return thumb;
        }
        public void setThumb(String thumb) {
            this.thumb = thumb;
        }
    }


    public static class Measures {

        @JsonProperty("measure")
        private String measure;
        @JsonProperty("seq")
        private int seq;
        @JsonProperty("qty")
        private double qty;

        @JsonProperty("serving_weight")
        private float serving_Weight;

        public double getQty() {
            return qty;
        }

        public int getSeq() {
            return seq;
        }

        public double getServingWeight() {
            return serving_Weight;
        }

        public String getMeasure() {
            return measure;
        }
    }
}
