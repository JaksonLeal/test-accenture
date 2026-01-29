package com.test.back_accenture.domain.ports;

import com.test.back_accenture.domain.model.Branch;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BranchRepository {

	Mono<Branch> save(Branch branch);

	Mono<Branch> findById(Long branchId);

	Flux<Branch> findByFranchiseId(Long franchiseId);

}
