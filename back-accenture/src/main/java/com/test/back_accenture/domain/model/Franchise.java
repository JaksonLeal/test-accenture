package com.test.back_accenture.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Franchise {
	
	private final Long id;
	private String name;
	private final List<Branch> branches;

	public Franchise(Long id, String name) {
		this.id = id;
		this.name = name;
		this.branches = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	// Plus: actualizar nombre de la franquicia
	public void rename(String newName) {
		this.name = newName;
	}

	public List<Branch> getBranches() {
		return List.copyOf(branches);
	}

	public void addBranch(Branch branch) {
		branches.add(branch);
	}
	
}
