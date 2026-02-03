package com.test.back_accenture.infrastructure.repository.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("products")
public class ProductEntity {

	@Id
	private Long id;

	private String name;
	private int stock;
	private Long branchId;

	public ProductEntity(Long id, String name, int stock, Long branchId) {
		this.id = id;
		this.name = name;
		this.stock = stock;
		this.branchId = branchId;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getStock() {
		return stock;
	}

	public Long getBranchId() {
		return branchId;
	}
}
