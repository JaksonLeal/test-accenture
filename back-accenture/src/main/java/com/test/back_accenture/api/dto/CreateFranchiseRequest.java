package com.test.back_accenture.api.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateFranchiseRequest {

	@NotBlank
	private String name;

	public String getName() {
		return name;
	}

}
