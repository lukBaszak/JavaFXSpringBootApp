package com.lubaszak.service;

import com.lubaszak.model.Product;

import java.util.List;

public interface FoodProviderService {

     List<Product> getProductsByQuery(String query);

     Product getProductById(String itemId);

     Product getProductByName(String itemName);

}
