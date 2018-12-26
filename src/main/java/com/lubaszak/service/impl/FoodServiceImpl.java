package com.lubaszak.service.impl;

import com.lubaszak.bean.ProductInfo;
import com.lubaszak.config.HeadersProvider;
import com.lubaszak.config.RestConfig;
import com.lubaszak.bean.Product;
import com.lubaszak.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    RestConfig restConfig;

    @Autowired
    HeadersProvider headersProvider;


    @Override
    public ArrayList<ProductInfo> getProductByQuery(@PathVariable String query) {
        HttpEntity<?> httpEntity = headersProvider.getHeaders();

        ResponseEntity<ArrayList<ProductInfo>> product =  restConfig.createRestTemplate()
                .exchange("https://trackapi.nutritionix.com/v2/search/instant?query={query}",HttpMethod.GET, httpEntity, new ParameterizedTypeReference<ArrayList<ProductInfo>>(){}, query);

        return product.getBody();
    }

    @Override
    public Product getProductById(@PathVariable String itemId) {
        HttpEntity<?> httpEntity = headersProvider.getHeaders();

        ResponseEntity<Product> product =  restConfig.createRestTemplate().exchange("https://trackapi.nutritionix.com/v2/search/item?nix_item_id={query}",HttpMethod.GET,httpEntity, Product.class ,itemId);

        return product.getBody();
    }
}
