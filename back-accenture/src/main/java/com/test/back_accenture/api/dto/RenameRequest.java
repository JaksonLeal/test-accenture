package com.test.back_accenture.api.dto;

import jakarta.validation.constraints.NotBlank;

// rename branch or product
public class RenameRequest {

	@NotBlank
	private String name;

	public String getName() {
		return name;
	}

}
