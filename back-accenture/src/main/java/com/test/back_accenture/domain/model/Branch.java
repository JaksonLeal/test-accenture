package com.test.back_accenture.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Branch {

	private final Long id;
	private String name;
	private final List<Product> products;

	public Branch(Long id, String name) {
		this.id = id;
		this.name = name;
		this.products = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	// Plus: actualizar nombre de la sucursal
	public void rename(String newName) {
		this.name = newName;
	}

	public List<Product> getProducts() {
		return List.copyOf(products); // Evita modificación externa
	}

	public void addProduct(Product product) {
		products.add(product);
	}

	public void removeProduct(Long productId) {
		products.removeIf(p -> p.getId().equals(productId));
	}

	public Product getProductWithMaxStock() {
		return products.stream().max((p1, p2) -> Integer.compare(p1.getStock(), p2.getStock())).orElse(null);
	}
}
