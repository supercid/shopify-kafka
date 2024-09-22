package com.supercid.shopifykafka.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "webhook_payloads")
public class WebhookPayload implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long entityId;

    @JsonProperty("id")
    @Column(name = "shopify_id")
    private Long shopifyId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("body_html")
    @Column(columnDefinition = "TEXT")
    private String bodyHtml;

    @JsonProperty("vendor")
    private String vendor;

    @JsonProperty("product_type")
    private String productType;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public Long getShopifyId() {
        return shopifyId;
    }

    public void setShopifyId(Long shopifyId) {
        this.shopifyId = shopifyId;
    }
}