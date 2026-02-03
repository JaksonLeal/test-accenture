package com.test.back_accenture.infrastructure.repository.adapter;

import com.test.back_accenture.domain.model.Branch;
import com.test.back_accenture.domain.ports.BranchRepository;
import com.test.back_accenture.infrastructure.repository.entity.BranchEntity;
import com.test.back_accenture.infrastructure.repository.spring.BranchR2dbcRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Adaptador de infraestructura. Implementa el puerto BranchRepository usando
 * MySQL reactivo (R2DBC).
 */
public class BranchRepositoryAdapter implements BranchRepository {

	private final BranchR2dbcRepository repository;

	// Spring inyecta el repositorio R2DBC aquí
	public BranchRepositoryAdapter(BranchR2dbcRepository repository) {
		this.repository = repository;
	}

	/**
	 * Guarda una sucursal. Convierte Domain -> Entity -> Domain
	 */
	@Override
	public Mono<Branch> save(Branch branch) {
		BranchEntity entity = new BranchEntity(branch.getId(), branch.getName(), branch.getFranchiseId());

		return repository.save(entity).map(e -> new Branch(e.getId(), e.getName(), e.getFranchiseId()));
	}

	/**
	 * Busca una sucursal por ID
	 */
	@Override
	public Mono<Branch> findById(Long id) {
		return repository.findById(id).map(e -> new Branch(e.getId(), e.getName(), e.getFranchiseId()));
	}

	/**
	 * Obtiene todas las sucursales de una franquicia
	 */
	@Override
	public Flux<Branch> findByFranchiseId(Long franchiseId) {
		return repository.findByFranchiseId(franchiseId)
				.map(e -> new Branch(e.getId(), e.getName(), e.getFranchiseId()));
	}
}
