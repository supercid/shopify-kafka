package com.supercid.shopifykafka.repository;

import com.supercid.shopifykafka.model.ProductData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgresProductRepository extends JpaRepository<ProductData, Long> {
}