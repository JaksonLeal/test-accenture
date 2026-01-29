package com.test.back_accenture.application.usecase;

import com.test.back_accenture.domain.ports.ProductRepository;

import reactor.core.publisher.Mono;

public class UpdateProductStockUC {

	private final ProductRepository productRepository;

	public UpdateProductStockUC(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

	public Mono<Void> execute(Long productId, int newStock) {

		return productRepository.findById(productId)
				.switchIfEmpty(Mono.error(new IllegalArgumentException("Product not found"))).flatMap(product -> {
					// Regla de negocio en el dominio
					product.updateStock(newStock);
					return productRepository.save(product);
				}).then(); // Convierte Mono<Product> en Mono<Void>
	}

}
