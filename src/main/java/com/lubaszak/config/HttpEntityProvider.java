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
public class HttpEntityProvider {


    //odnosnik do p
    @Value("${api.apiId}")
    private String apiId;

    @Value("${api.apiKey}")
    private String apiKey;


    @Bean
    public HttpEntity getHttpEntity() {
        HttpEntity<?> httpEntity = buildHttpEntity();
        return httpEntity;
    }


    private HttpEntity<String> buildHttpEntity() {
        return new HttpEntity<String>(getHeaders());
    }

    @Bean
    public HttpHeaders getHeaders() {
        Map<String, String> headersMap = Collections.unmodifiableMap(
                Stream.of(

                        new AbstractMap.SimpleEntry<>("x-app-id", apiId),
                        new AbstractMap.SimpleEntry<>("x-app-key", apiKey),
                        new AbstractMap.SimpleEntry<>("x-remote-user-id", "0")
                )
                        .collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue())));

        HttpHeaders headers = new HttpHeaders();
        headersMap.forEach((k, v) -> headers.set(k, v));
        return headers;
    }

    }
