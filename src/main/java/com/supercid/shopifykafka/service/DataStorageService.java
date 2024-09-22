package com.supercid.shopifykafka.service;

import com.supercid.shopifykafka.model.WebhookPayload;
import com.supercid.shopifykafka.model.ProductData;
import com.supercid.shopifykafka.repository.WebhookPayloadRepository;
import com.supercid.shopifykafka.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class DataStorageService {

    private final WebhookPayloadRepository webhookPayloadRepository;
    private final ProductRepository productRepository;

    public DataStorageService(WebhookPayloadRepository webhookPayloadRepository, ProductRepository productRepository) {
        this.webhookPayloadRepository = webhookPayloadRepository;
        this.productRepository = productRepository;
    }

    public void storeWebhookPayload(WebhookPayload payload) {
        webhookPayloadRepository.save(payload);
    }

    public void storeProductData(ProductData productData) {
        productRepository.save(productData);
    }
}