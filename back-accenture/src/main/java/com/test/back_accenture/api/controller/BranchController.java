package com.test.back_accenture.api.controller;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.back_accenture.api.dto.RenameRequest;
import com.test.back_accenture.application.usecase.AddBranchToFranchiseUC;
import com.test.back_accenture.application.usecase.RenameBranchUC;
import com.test.back_accenture.domain.model.Branch;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

/**
 * Controller REST para sucursales.
 */
@RestController
@RequestMapping("/branches")
public class BranchController {

	private final AddBranchToFranchiseUC addBranchUseCase;
	private final RenameBranchUC renameBranchUseCase;

	public BranchController(AddBranchToFranchiseUC addBranchUseCase, RenameBranchUC renameBranchUseCase) {
		this.addBranchUseCase = addBranchUseCase;
		this.renameBranchUseCase = renameBranchUseCase;
	}

	/**
	 * Agregar una sucursal a una franquicia.
	 */
	@PostMapping("/franchise/{franchiseId}")
	public Mono<Branch> addBranch(@PathVariable Long franchiseId, @RequestParam String name) {
		return addBranchUseCase.execute(franchiseId, null, name);
	}

	/**
	 * Renombrar sucursal.
	 */
	@PatchMapping("/{id}")
	public Mono<Branch> rename(@PathVariable Long id, @RequestBody @Valid RenameRequest request) {
		return renameBranchUseCase.execute(id, request.getName());
	}
}
