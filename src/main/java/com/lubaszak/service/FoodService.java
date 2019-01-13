package com.lubaszak.service;

import com.lubaszak.model.Product;

import java.util.List;

public interface FoodService {

     List<Product> getProductsByQuery(String query);



}
