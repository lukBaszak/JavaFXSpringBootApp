package com.lubaszak.service;

import com.lubaszak.bean.Product;
import com.lubaszak.bean.ProductResponse;
import org.springframework.http.ResponseEntity;

public interface FoodService {

     ResponseEntity<ProductResponse> getProductByQuery(String query);

     Product getProductById(String id);

}
