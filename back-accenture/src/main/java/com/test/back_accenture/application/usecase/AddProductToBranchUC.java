package com.test.back_accenture.application.usecase;

import com.test.back_accenture.domain.model.Product;
import com.test.back_accenture.domain.ports.BranchRepository;
import com.test.back_accenture.domain.ports.ProductRepository;

import reactor.core.publisher.Mono;

public class AddProductToBranchUC {

	private final BranchRepository branchRepository;
	private final ProductRepository productRepository;

	public AddProductToBranchUC(
            BranchRepository branchRepository,
            ProductRepository productRepository
    ) {
        this.branchRepository = branchRepository;
        this.productRepository = productRepository;
    }

	public Mono<Product> execute(Long branchId, Long productId, String productName, int stock) {

		return branchRepository.findById(branchId)
				.switchIfEmpty(Mono.error(new IllegalArgumentException("Branch not found"))).flatMap(branch -> {

					// Se crea el producto
					Product product = new Product(productId, productName, stock);

					// Se agrega al dominio
					branch.addProduct(product);

					// Se persiste
					return productRepository.save(product);
				});
	}

}
