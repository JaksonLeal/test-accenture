package com.test.back_accenture.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.back_accenture.api.dto.CreateFranchiseRequest;
import com.test.back_accenture.api.dto.RenameRequest;
import com.test.back_accenture.application.usecase.CreateFranchiseUC;
import com.test.back_accenture.application.usecase.GetMaxStockProductsByFranchiseUC;
import com.test.back_accenture.application.usecase.RenameFranchiseUC;
import com.test.back_accenture.domain.model.Franchise;
import com.test.back_accenture.domain.model.Product;

import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/franchises")
public class FranchiseController {

	private final CreateFranchiseUC createFranchiseUseCase;
	private final RenameFranchiseUC renameFranchiseUseCase;
	private final GetMaxStockProductsByFranchiseUC maxStockUseCase;

	public FranchiseController(CreateFranchiseUC createFranchiseUseCase,
			RenameFranchiseUC renameFranchiseUseCase, GetMaxStockProductsByFranchiseUC maxStockUseCase) {
		this.createFranchiseUseCase = createFranchiseUseCase;
		this.renameFranchiseUseCase = renameFranchiseUseCase;
		this.maxStockUseCase = maxStockUseCase;
	}

	/**
	 * Crear una nueva franquicia.
	 */
	@PostMapping
	public Mono<Franchise> create(@RequestBody @Valid CreateFranchiseRequest request) {

		// El controller NO crea lógica, solo delega
		return createFranchiseUseCase.execute(null, request.getName());
	}

	/**
	 * Renombrar una franquicia.
	 */
	@PatchMapping("/{id}")
	public Mono<Franchise> rename(@PathVariable Long id, @RequestBody @Valid RenameRequest request) {
		return renameFranchiseUseCase.execute(id, request.getName());
	}

	/**
	 * Obtener el producto con más stock por sucursal para una franquicia puntual.
	 */
	@GetMapping("/{id}/max-stock-products")
	public Flux<Product> getMaxStockProducts(@PathVariable Long id) {
		return maxStockUseCase.execute(id);
	}
}
