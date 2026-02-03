package com.test.back_accenture.infrastructure.repository.adapter;

import com.test.back_accenture.domain.model.Franchise;
import com.test.back_accenture.domain.ports.FranchiseRepository;
import com.test.back_accenture.infrastructure.repository.entity.FranchiseEntity;
import com.test.back_accenture.infrastructure.repository.spring.FranchiseR2dbcRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FranchiseRepositoryAdapter implements FranchiseRepository {

	private final FranchiseR2dbcRepository repository;

	public FranchiseRepositoryAdapter(FranchiseR2dbcRepository repository) {
		this.repository = repository;
	}

	@Override
	public Mono<Franchise> save(Franchise franchise) {
		FranchiseEntity entity = new FranchiseEntity(franchise.getId(), franchise.getName());

		return repository.save(entity).map(e -> new Franchise(e.getId(), e.getName()));
	}

	@Override
	public Mono<Franchise> findById(Long id) {
		return repository.findById(id).map(e -> new Franchise(e.getId(), e.getName()));
	}

	@Override
	public Flux<Franchise> findAll() {
		return repository.findAll().map(e -> new Franchise(e.getId(), e.getName()));
	}

}
