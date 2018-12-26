package com.lubaszak.service;

import com.lubaszak.bean.Product;
import com.lubaszak.bean.ProductInfo;

import java.util.ArrayList;

public interface FoodService {

     ArrayList<ProductInfo> getProductByQuery(String query);

     Product getProductById(String id);

}
