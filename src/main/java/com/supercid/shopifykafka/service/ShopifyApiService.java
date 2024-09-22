package com.supercid.shopifykafka.service;

import com.supercid.shopifykafka.model.ProductData;
import com.supercid.shopifykafka.util.RateLimiter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ShopifyApiService {

    private final RestTemplate restTemplate;
    private final RateLimiter rateLimiter;

    @Value("${shopify.api.base-url}")
    private String shopifyBaseUrl;

    @Value("${shopify.api.access-token}")
    private String accessToken;

    public ShopifyApiService(RestTemplate restTemplate, RateLimiter rateLimiter) {
        this.restTemplate = restTemplate;
        this.rateLimiter = rateLimiter;
    }

    public ProductData getProductData(Long productId) {
        String url = shopifyBaseUrl + "/admin/api/2024-07/products/" + productId + ".json";

        try {
            return rateLimiter.execute(() -> {
                HttpHeaders headers = new HttpHeaders();
                headers.set("X-Shopify-Access-Token", accessToken);
                HttpEntity<String> entity = new HttpEntity<>(headers);

                ResponseEntity<ProductData> response = restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        entity,
                        ProductData.class
                );

                return response.getBody();
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}