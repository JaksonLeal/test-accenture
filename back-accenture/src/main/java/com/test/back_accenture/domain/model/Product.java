package com.test.back_accenture.domain.model;

public class Product {

	private final Long id;
	private String name;
	private int stock;

	public Product(Long id, String name, int stock) {
		this.id = id;
		this.name = name;
		this.stock = stock;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	// Cambio de nombre (plus del enunciado)
	public void rename(String newName) {
		this.name = newName;
	}

	public int getStock() {
		return stock;
	}

	public void updateStock(int newStock) {
		this.stock = newStock;
	}
}
