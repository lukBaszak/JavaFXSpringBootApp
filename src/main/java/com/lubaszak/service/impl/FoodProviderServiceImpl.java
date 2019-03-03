package com.lubaszak.service.impl;

import com.lubaszak.model.Product;
import com.lubaszak.model.ProductResponse;
import com.lubaszak.model.ProductCommonResponse;
import com.lubaszak.config.HttpEntityProvider;
import com.lubaszak.config.RestConfig;
import com.lubaszak.service.FoodProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;


@Service
public class FoodProviderServiceImpl implements FoodProviderService {

    @Autowired
    RestConfig restConfig;

    @Autowired
    HttpEntityProvider httpEntityProvider;


    @Override
    public ProductResponse getProductsByQuery(@PathVariable String query) {

        List<Product> productList = new ArrayList<>();
        HttpEntity<?> httpEntity = httpEntityProvider.getHttpEntity();

        ResponseEntity<ProductResponse> response =  restConfig.createRestTemplate()
                .exchange("https://trackapi.nutritionix.com/v2/search/instant?query={query}&common=true&branded=true",HttpMethod.GET, httpEntity, ProductResponse.class, query);

        ProductResponse products = response.getBody();

        ProductResponse.BrandedProductInfo[] brandedProductInfos = products.getBranded();
        ProductResponse.CommonProductInfo[] commonProductInfos = products.getCommon();

/*
        for(int i=0; i<commonProductInfos.length ; i++)
        {
            Product product = getProductByName(commonProductInfos[i].getFoodName());

            productList.add(product);

        }

        for(int i=0; i<brandedProductInfos.length; i++)
        {
            Product product = getProductById(brandedProductInfos[i].getNixItemId());
            System.out.println(product.getBrandName());
            productList.add(product);

        }*/




        return products;
    }


    public Product getProductById(@PathVariable String itemId) {

        ResponseEntity<ProductCommonResponse> product =  restConfig.createRestTemplate().exchange("https://trackapi.nutritionix.com/v2/search/item?nix_item_id={query}",HttpMethod.GET, httpEntityProvider.getHttpEntity(), ProductCommonResponse.class ,itemId);


        return product.getBody().getProduct();
    }

    public Product getProductByName(String itemName) {


        HttpHeaders headers = httpEntityProvider.getHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("query", itemName);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<ProductCommonResponse> response = restConfig.createRestTemplate().postForEntity("https://trackapi.nutritionix.com/v2/natural/nutrients/", request , ProductCommonResponse.class );


        return response.getBody().getProduct();
    }






}
