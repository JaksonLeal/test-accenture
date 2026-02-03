package com.test.back_accenture.infrastructure.repository.spring;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.test.back_accenture.infrastructure.repository.entity.ProductEntity;

import reactor.core.publisher.Flux;

public interface ProductR2dbcRepository extends ReactiveCrudRepository<ProductEntity, Long> {

	Flux<ProductEntity> findByBranchId(Long branchId);
}
