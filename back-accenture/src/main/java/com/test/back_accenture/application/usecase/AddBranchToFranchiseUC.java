package com.test.back_accenture.application.usecase;

import com.test.back_accenture.domain.model.Branch;
import com.test.back_accenture.domain.ports.BranchRepository;
import com.test.back_accenture.domain.ports.FranchiseRepository;

import reactor.core.publisher.Mono;

public class AddBranchToFranchiseUC {

	private final FranchiseRepository franchiseRepository;
	private final BranchRepository branchRepository;

	public AddBranchToFranchiseUC(
            FranchiseRepository franchiseRepository,
            BranchRepository branchRepository
    ) {
        this.franchiseRepository = franchiseRepository;
        this.branchRepository = branchRepository;
    }

	public Mono<Branch> execute(Long franchiseId, Long branchId, String branchName) {

		return franchiseRepository.findById(franchiseId)
				// Si la franquicia no existe, el flujo queda vacío
				.switchIfEmpty(Mono.error(new IllegalArgumentException("Franchise not found"))).flatMap(franchise -> {

					// Se crea la sucursal
					Branch branch = new Branch(branchId, branchName);

					// Se agrega al agregado de franquicia (regla de negocio)
					franchise.addBranch(branch);

					// Se persiste la sucursal
					return branchRepository.save(branch);
				});
	}

}
