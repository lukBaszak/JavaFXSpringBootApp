package com.lubaszak.service;

import com.lubaszak.bean.Product;
import com.lubaszak.bean.ProductResponse;

public interface FoodService {

     ProductResponse getProductByQuery(String query);

     Product getProductById(String id);

     Product getProductByName(String name);

}
