package com.test.back_accenture.application.usecase;

import com.test.back_accenture.domain.model.Product;
import com.test.back_accenture.domain.ports.ProductRepository;

import reactor.core.publisher.Mono;

public class RenameProductUC {

	private final ProductRepository productRepository;

	/**
     * Se inyecta el puerto del dominio.
     */
    public RenameProductUC(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

	/**
	 * Ejecuta el cambio de nombre de un producto.
	 *
	 * @param productId id del producto
	 * @param newName   nuevo nombre del producto
	 * @return Mono con el producto actualizado
	 */
	public Mono<Product> execute(Long productId, String newName) {

		return productRepository.findById(productId)
				// Si el producto no existe, se corta el flujo
				.switchIfEmpty(Mono.error(new IllegalArgumentException("Product not found"))).flatMap(product -> {

					// Regla de negocio vive en el dominio
					product.rename(newName);

					// Persistimos el cambio
					return productRepository.save(product);
				});
	}

}
