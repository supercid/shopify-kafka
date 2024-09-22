package com.supercid.shopifykafka.service;

import com.supercid.shopifykafka.model.WebhookPayload;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class QueueService {

    private final KafkaTemplate<String, WebhookPayload> kafkaTemplate;

    public QueueService(KafkaTemplate<String, WebhookPayload> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendToKafka(WebhookPayload payload) {
        kafkaTemplate.send("shopify-webhook-topic", payload);
    }
}