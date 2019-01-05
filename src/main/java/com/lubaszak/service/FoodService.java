package com.lubaszak.service;

import com.lubaszak.bean.Product;
import com.lubaszak.bean.ProductResponse;

import java.util.List;

public interface FoodService {

     List<Product> getProductsByQuery(String query);



}
