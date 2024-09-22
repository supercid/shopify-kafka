package com.supercid.shopifykafka.controller;

import com.supercid.shopifykafka.model.WebhookPayload;
import com.supercid.shopifykafka.service.WebhookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebhookController {

    private final WebhookService webhookService;

    public WebhookController(WebhookService webhookService) {
        this.webhookService = webhookService;
    }

    @PostMapping("/webhook")
    public void handleWebhook(@RequestBody WebhookPayload payload) {
        webhookService.processWebhook(payload);
    }
}