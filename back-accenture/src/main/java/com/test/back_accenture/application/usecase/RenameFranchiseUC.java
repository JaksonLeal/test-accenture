package com.test.back_accenture.application.usecase;

import com.test.back_accenture.domain.model.Franchise;
import com.test.back_accenture.domain.ports.FranchiseRepository;

import reactor.core.publisher.Mono;

public class RenameFranchiseUC {

	private final FranchiseRepository franchiseRepository;

	/**
     * Se inyecta el puerto del dominio, no una implementación concreta.
     */
    public RenameFranchiseUC(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }

	/**
	 * Ejecuta el cambio de nombre de una franquicia.
	 *
	 * @param franchiseId id de la franquicia a actualizar
	 * @param newName     nuevo nombre de la franquicia
	 * @return Mono con la franquicia actualizada
	 */
	public Mono<Franchise> execute(Long franchiseId, String newName) {

		return franchiseRepository.findById(franchiseId)
				// Si no existe la franquicia, se corta el flujo
				.switchIfEmpty(Mono.error(new IllegalArgumentException("Franchise not found"))).flatMap(franchise -> {

					// La regla de negocio vive en el dominio
					franchise.rename(newName);

					// Se persiste el cambio
					return franchiseRepository.save(franchise);
				});
	}

}
