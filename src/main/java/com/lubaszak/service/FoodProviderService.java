package com.lubaszak.service;

import com.lubaszak.model.Product;
import com.lubaszak.model.ProductResponse;

public interface FoodProviderService {

     ProductResponse getProductsByQuery(String query);

     Product getProductById(String itemId);

     Product getProductByName(String itemName);

}
