package com.test.back_accenture.application.usecase;

import com.test.back_accenture.domain.model.Branch;
import com.test.back_accenture.domain.ports.BranchRepository;

import reactor.core.publisher.Mono;

public class RenameBranchUC {

	private final BranchRepository branchRepository;

	/**
	 * Se inyecta el puerto del dominio.
	 */
	public RenameBranchUC(BranchRepository branchRepository) {
		this.branchRepository = branchRepository;
	}

	/**
	 * Ejecuta el cambio de nombre de una sucursal.
	 *
	 * @param branchId id de la sucursal
	 * @param newName  nuevo nombre de la sucursal
	 * @return Mono con la sucursal actualizada
	 */
	public Mono<Branch> execute(Long branchId, String newName) {

		return branchRepository.findById(branchId)
				// Si la sucursal no existe, se corta el flujo reactivo
				.switchIfEmpty(Mono.error(new IllegalArgumentException("Branch not found"))).flatMap(branch -> {

					// Regla de negocio delegada al dominio
					branch.rename(newName);

					// Persistimos el cambio
					return branchRepository.save(branch);
				});
	}

}
