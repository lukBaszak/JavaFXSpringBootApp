package com.lubaszak.service.impl;

import com.lubaszak.bean.ProductResponse;
import com.lubaszak.bean.ProductResponse2;
import com.lubaszak.config.HttpEntityProvider;
import com.lubaszak.config.RestConfig;
import com.lubaszak.bean.Product;
import com.lubaszak.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    RestConfig restConfig;

    @Autowired
    HttpEntityProvider httpEntityProvider;


    @Override
    public ProductResponse getProductByQuery(@PathVariable String query) {
        HttpEntity<?> httpEntity = httpEntityProvider.getHttpEntity();

        ResponseEntity<ProductResponse> product =  restConfig.createRestTemplate()
                .exchange("https://trackapi.nutritionix.com/v2/search/instant?query={query}&common=false",HttpMethod.GET, httpEntity, ProductResponse.class, query);

        ProductResponse products = product.getBody();



        return null;
    }

    @Override
    public Product getProductById(@PathVariable String itemId) {

        ResponseEntity<Product> product =  restConfig.createRestTemplate().exchange("https://trackapi.nutritionix.com/v2/search/item?nix_item_id={query}",HttpMethod.GET, httpEntityProvider.getHttpEntity(), Product.class ,itemId);

        return product.getBody();
    }

    @Override
    public Product getProductByName(String itemName) {



        HttpHeaders headers = httpEntityProvider.getHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("query", itemName);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        ResponseEntity<ProductResponse2> response = restConfig.createRestTemplate().postForEntity("https://trackapi.nutritionix.com/v2/natural/nutrients/", request , ProductResponse2.class );


        return response.getBody().getProduct();
    }






}
