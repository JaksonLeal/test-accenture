package com.test.back_accenture.domain.ports;

import com.test.back_accenture.domain.model.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository {

	Mono<Product> save(Product product);

	Mono<Product> findById(Long productId);

	Mono<Void> deleteById(Long productId);

	Flux<Product> findByBranchId(Long branchId);

}
