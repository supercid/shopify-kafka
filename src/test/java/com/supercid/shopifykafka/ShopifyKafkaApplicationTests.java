package com.supercid.shopifykafka;

import com.supercid.shopifykafka.model.WebhookPayload;
import com.supercid.shopifykafka.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class ShopifyKafkaApplicationTests {

	@MockBean
	private KafkaTemplate<String, WebhookPayload> kafkaTemplate;

	@MockBean
	private ProductRepository productRepository;

	@Test
	void contextLoads() {
	}
}