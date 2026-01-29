package com.test.back_accenture.application.usecase;

import com.test.back_accenture.domain.ports.ProductRepository;

import reactor.core.publisher.Mono;

public class RemoveProductUC {

	private final ProductRepository productRepository;

	public RemoveProductUC(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

	public Mono<Void> execute(Long productId) {
		return productRepository.deleteById(productId);
	}

}
