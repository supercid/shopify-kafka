package com.supercid.shopifykafka.repository;

import com.supercid.shopifykafka.model.WebhookPayload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebhookPayloadRepository extends JpaRepository<WebhookPayload, Long> {
}