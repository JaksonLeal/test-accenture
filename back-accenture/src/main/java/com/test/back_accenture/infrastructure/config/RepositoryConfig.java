package com.test.back_accenture.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.test.back_accenture.domain.ports.BranchRepository;
import com.test.back_accenture.domain.ports.FranchiseRepository;
import com.test.back_accenture.domain.ports.ProductRepository;
import com.test.back_accenture.infrastructure.repository.adapter.BranchRepositoryAdapter;
import com.test.back_accenture.infrastructure.repository.adapter.FranchiseRepositoryAdapter;
import com.test.back_accenture.infrastructure.repository.adapter.ProductRepositoryAdapter;
import com.test.back_accenture.infrastructure.repository.spring.BranchR2dbcRepository;
import com.test.back_accenture.infrastructure.repository.spring.FranchiseR2dbcRepository;
import com.test.back_accenture.infrastructure.repository.spring.ProductR2dbcRepository;

@Configuration
public class RepositoryConfig {

	@Bean
	public FranchiseRepository franchiseRepository(FranchiseR2dbcRepository repository) {
		return new FranchiseRepositoryAdapter(repository);
	}

	@Bean
	public BranchRepository branchRepository(BranchR2dbcRepository repository) {
		return new BranchRepositoryAdapter(repository);
	}

	@Bean
	public ProductRepository productRepository(ProductR2dbcRepository repository) {
		return new ProductRepositoryAdapter(repository);
	}
}
