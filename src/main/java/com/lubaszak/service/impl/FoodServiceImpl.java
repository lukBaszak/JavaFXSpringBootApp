package com.lubaszak.service.impl;

import com.lubaszak.bean.Product;
import com.lubaszak.bean.ProductResponse;
import com.lubaszak.bean.ProductCommonResponse;
import com.lubaszak.config.HttpEntityProvider;
import com.lubaszak.config.RestConfig;
import com.lubaszak.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;


@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    RestConfig restConfig;

    @Autowired
    HttpEntityProvider httpEntityProvider;


    @Override
    public ArrayList<Product> getProductsByQuery(@PathVariable String query) {

        ArrayList<Product> productList = new ArrayList<>();
        HttpEntity<?> httpEntity = httpEntityProvider.getHttpEntity();

        ResponseEntity<ProductResponse> response =  restConfig.createRestTemplate()
                .exchange("https://trackapi.nutritionix.com/v2/search/instant?query={query}&common=true&branded=true",HttpMethod.GET, httpEntity, ProductResponse.class, query);

        ProductResponse products = response.getBody();

        ProductResponse.BrandedProductInfo[] brandedProductInfos = products.getBranded();
        ProductResponse.CommonProductInfo[] commonProductInfos = products.getCommon();

        for(int i=0; i>commonProductInfos.length +1; i++)
        {
            Product product = getProductByName(commonProductInfos[i].getFoodName());
            productList.add(product);
        }

        for(int i=0; i>brandedProductInfos.length +1; i++)
        {
            Product product = getProductById(brandedProductInfos[i].getNixItemId());
            productList.add(product);
        }




        return productList;
    }


    private Product getProductById(@PathVariable String itemId) {

        ResponseEntity<Product> product =  restConfig.createRestTemplate().exchange("https://trackapi.nutritionix.com/v2/search/item?nix_item_id={query}",HttpMethod.GET, httpEntityProvider.getHttpEntity(), Product.class ,itemId);

        return product.getBody();
    }


    private Product getProductByName(String itemName) {



        HttpHeaders headers = httpEntityProvider.getHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("query", itemName);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        ResponseEntity<ProductCommonResponse> response = restConfig.createRestTemplate().postForEntity("https://trackapi.nutritionix.com/v2/natural/nutrients/", request , ProductCommonResponse.class );


        return response.getBody().getProduct();
    }






}
