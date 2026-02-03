package com.test.back_accenture.infrastructure.repository.spring;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.test.back_accenture.infrastructure.repository.entity.BranchEntity;

import reactor.core.publisher.Flux;

public interface BranchR2dbcRepository extends ReactiveCrudRepository<BranchEntity, Long> {

	Flux<BranchEntity> findByFranchiseId(Long franchiseId);
}
