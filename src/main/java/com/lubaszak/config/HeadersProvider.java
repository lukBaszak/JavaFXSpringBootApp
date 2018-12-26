package com.lubaszak.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class HeadersProvider {


    @Value("${api.apiId}")
    private String apiId;

    @Value("${api.apiKey}")
    private String apiKey;


    @Bean
    public HttpEntity getHeaders() {
        Map<String, Object> headersMap = Collections.unmodifiableMap(
                Stream.of(

                        new AbstractMap.SimpleEntry<>("x-app-id", apiId),
                        new AbstractMap.SimpleEntry<>("x-app-key", apiKey)
                )
                        .collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue())));
        System.out.print(apiId);
        HttpEntity<?> httpEntity = buildHttpEntity(headersMap);

        return httpEntity;
    }


    private HttpEntity<String> buildHttpEntity(Map<String,Object> headerParams) {

        HttpHeaders headers = new HttpHeaders();
        headerParams.forEach((k, v) -> headers.set(k, v.toString()));
        return new HttpEntity<String>(headers);

    }
    }
