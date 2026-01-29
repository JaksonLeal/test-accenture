package com.test.back_accenture.application.usecase;

import com.test.back_accenture.domain.model.Product;
import com.test.back_accenture.domain.ports.BranchRepository;
import com.test.back_accenture.domain.ports.ProductRepository;

import reactor.core.publisher.Flux;

public class GetMaxStockProductsByFranchiseUC {

	private final BranchRepository branchRepository;
	private final ProductRepository productRepository;

	public GetMaxStockProductsByFranchiseUC(
            BranchRepository branchRepository,
            ProductRepository productRepository
    ) {
        this.branchRepository = branchRepository;
        this.productRepository = productRepository;
    }

	public Flux<Product> execute(Long franchiseId) {

		return branchRepository.findByFranchiseId(franchiseId)
				// Por cada sucursal, buscamos sus productos
				.flatMap(branch -> productRepository.findByBranchId(branch.getId())
						// Tomamos el de mayor stock
						.sort((p1, p2) -> Integer.compare(p2.getStock(), p1.getStock())).take(1));
	}

}
