package com.test.back_accenture.domain.ports;

import com.test.back_accenture.domain.model.Franchise;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FranchiseRepository {
	
    Mono<Franchise> save(Franchise franchise);

    Mono<Franchise> findById(Long franchiseId);

    Flux<Franchise> findAll();
}
