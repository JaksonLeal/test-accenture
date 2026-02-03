package com.test.back_accenture.api.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.back_accenture.api.dto.RenameRequest;
import com.test.back_accenture.application.usecase.AddProductToBranchUC;
import com.test.back_accenture.application.usecase.RemoveProductUC;
import com.test.back_accenture.application.usecase.RenameProductUC;
import com.test.back_accenture.application.usecase.UpdateProductStockUC;
import com.test.back_accenture.domain.model.Product;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

/**
 * Controller REST para productos.
 */
@RestController
@RequestMapping("/products")
public class ProductController {

	private final AddProductToBranchUC addProductUseCase;
	private final RemoveProductUC removeProductUseCase;
	private final UpdateProductStockUC updateStockUseCase;
	private final RenameProductUC renameProductUseCase;

	public ProductController(AddProductToBranchUC addProductUseCase, RemoveProductUC removeProductUseCase,
			UpdateProductStockUC updateStockUseCase, RenameProductUC renameProductUseCase) {
		this.addProductUseCase = addProductUseCase;
		this.removeProductUseCase = removeProductUseCase;
		this.updateStockUseCase = updateStockUseCase;
		this.renameProductUseCase = renameProductUseCase;
	}

	/**
	 * Agregar producto a una sucursal.
	 */
	@PostMapping("/branch/{branchId}")
	public Mono<Product> addProduct(@PathVariable Long branchId, @RequestParam String name, @RequestParam int stock) {
		return addProductUseCase.execute(null, name, stock, branchId);
	}

	/**
	 * Actualizar stock de un producto.
	 */
	@PatchMapping("/{id}/stock")
	public Mono<Void> updateStock(@PathVariable Long id, @RequestParam int stock) {
		return updateStockUseCase.execute(id, stock);
	}

	/**
	 * Renombrar producto.
	 */
	@PatchMapping("/{id}")
	public Mono<Product> rename(@PathVariable Long id, @RequestBody @Valid RenameRequest request) {
		return renameProductUseCase.execute(id, request.getName());
	}

	/**
	 * Eliminar producto.
	 */
	@DeleteMapping("/{id}")
	public Mono<Void> delete(@PathVariable Long id) {
		return removeProductUseCase.execute(id);
	}
}
