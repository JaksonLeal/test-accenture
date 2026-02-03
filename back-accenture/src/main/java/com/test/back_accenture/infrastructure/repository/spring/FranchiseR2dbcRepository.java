package com.test.back_accenture.infrastructure.repository.spring;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.test.back_accenture.infrastructure.repository.entity.FranchiseEntity;

public interface FranchiseR2dbcRepository extends ReactiveCrudRepository<FranchiseEntity, Long> {

}
