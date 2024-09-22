package com.supercid.shopifykafka.service;

import com.supercid.shopifykafka.model.WebhookPayload;
import org.springframework.stereotype.Service;

@Service
public class WebhookService {

    private final QueueService queueService;

    public WebhookService(QueueService queueService) {
        this.queueService = queueService;
    }

    public void processWebhook(WebhookPayload payload) {
        queueService.sendToKafka(payload);
    }
}