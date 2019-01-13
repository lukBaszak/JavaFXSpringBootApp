package com.lubaszak.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResponse {
    @JsonProperty("branded")
    private BrandedProductInfo[] branded;

    @JsonProperty("common")
    private CommonProductInfo[] common;

    public BrandedProductInfo[] getBranded() {
        return branded;
    }

    public void setBranded(BrandedProductInfo[] branded) {
        this.branded = branded;
    }

    public CommonProductInfo[] getCommon() {
        return common;
    }

    public void setCommon(CommonProductInfo[] common) {
        this.common = common;
    }



    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BrandedProductInfo {

        @JsonProperty("food_name")
        String foodName;
        @JsonProperty("serving_unit")
        String servingUnit;
        @JsonProperty("nix_brand_id")
        String nixBrandId;
        @JsonProperty("brand_name_item_name")
        String brandNameItemName;
        @JsonProperty("serving_qty")
         Integer servingQty;
        @JsonProperty("nf_calories")
        Integer nfCalories;
        @JsonProperty("brand_name")
         String brandName;
        @JsonProperty("brand_type")
         Integer brandType;
        @JsonProperty("nix_item_id")
         String nixItemId;


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

     public static class CommonProductInfo {

        @JsonProperty("food_name")
        private String foodName;

        public String getFoodName() {
            return foodName;
        }
        public void setFoodName(String foodName) {
            this.foodName = foodName;
        }
    }
}