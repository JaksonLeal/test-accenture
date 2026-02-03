package com.test.back_accenture.infrastructure.repository.adapter;

import com.test.back_accenture.domain.model.Product;
import com.test.back_accenture.domain.ports.ProductRepository;
import com.test.back_accenture.infrastructure.repository.entity.ProductEntity;
import com.test.back_accenture.infrastructure.repository.spring.ProductR2dbcRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Adaptador de infraestructura para productos.
 */
public class ProductRepositoryAdapter implements ProductRepository {

	private final ProductR2dbcRepository repository;

	public ProductRepositoryAdapter(ProductR2dbcRepository repository) {
		this.repository = repository;
	}

	/**
	 * Guarda un producto.
	 */
	@Override
	public Mono<Product> save(Product product) {
		ProductEntity entity = new ProductEntity(product.getId(), product.getName(), product.getStock(),
				product.getBranchId());

		return repository.save(entity).map(e -> new Product(e.getId(), e.getName(), e.getStock(), e.getBranchId()));
	}

	/**
	 * Busca producto por ID
	 */
	@Override
	public Mono<Product> findById(Long id) {
		return repository.findById(id).map(e -> new Product(e.getId(), e.getName(), e.getStock(), e.getBranchId()));
	}

	/**
	 * Obtiene productos por sucursal
	 */
	@Override
	public Flux<Product> findByBranchId(Long branchId) {
		return repository.findByBranchId(branchId)
				.map(e -> new Product(e.getId(), e.getName(), e.getStock(), e.getBranchId()));
	}

	/**
	 * Elimina producto por ID
	 */
	@Override
	public Mono<Void> deleteById(Long id) {
		return repository.deleteById(id);
	}
}
