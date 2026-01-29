package com.test.back_accenture.application.usecase;

import com.test.back_accenture.domain.model.Franchise;
import com.test.back_accenture.domain.ports.FranchiseRepository;

import reactor.core.publisher.Mono;

public class CreateFranchiseUC {

	private final FranchiseRepository franchiseRepository;

	public CreateFranchiseUC(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }

	public Mono<Franchise> execute(Long id, String name) {

		// Se crea la entidad de dominio
		Franchise franchise = new Franchise(id, name);

		// Se delega la persistencia al puerto
		return franchiseRepository.save(franchise);
	}

}
