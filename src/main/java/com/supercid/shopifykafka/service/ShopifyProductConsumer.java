package com.supercid.shopifykafka.service;

import com.supercid.shopifykafka.model.WebhookPayload;
import com.supercid.shopifykafka.model.ProductData;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ShopifyProductConsumer {

    private final ShopifyApiService shopifyApiService;
    private final DataStorageService dataStorageService;

    public ShopifyProductConsumer(ShopifyApiService shopifyApiService, DataStorageService dataStorageService) {
        this.shopifyApiService = shopifyApiService;
        this.dataStorageService = dataStorageService;
    }

    @KafkaListener(topics = "shopify-webhook-topic", groupId = "shopify-product-group")
    public void consumeWebhookPayload(WebhookPayload payload) {
        dataStorageService.storeWebhookPayload(payload);

        // Fetching additional data from Shopify API
        ProductData additionalData = shopifyApiService.getProductData(payload.getShopifyId());
        dataStorageService.storeProductData(additionalData);
    }
}