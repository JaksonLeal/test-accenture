
package com.test.back_accenture.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.test.back_accenture.application.usecase.AddBranchToFranchiseUC;
import com.test.back_accenture.application.usecase.AddProductToBranchUC;
import com.test.back_accenture.application.usecase.CreateFranchiseUC;
import com.test.back_accenture.application.usecase.GetMaxStockProductsByFranchiseUC;
import com.test.back_accenture.application.usecase.RemoveProductUC;
import com.test.back_accenture.application.usecase.RenameBranchUC;
import com.test.back_accenture.application.usecase.RenameFranchiseUC;
import com.test.back_accenture.application.usecase.RenameProductUC;
import com.test.back_accenture.application.usecase.UpdateProductStockUC;
import com.test.back_accenture.domain.ports.BranchRepository;
import com.test.back_accenture.domain.ports.FranchiseRepository;
import com.test.back_accenture.domain.ports.ProductRepository;

@Configuration
public class UseCaseConfig {

	@Bean
	public CreateFranchiseUC createFranchiseUC(FranchiseRepository franchiseRepository) {
		return new CreateFranchiseUC(franchiseRepository);
	}

	@Bean
	public RenameFranchiseUC renameFranchiseUC(FranchiseRepository franchiseRepository) {
		return new RenameFranchiseUC(franchiseRepository);
	}

	@Bean
	public AddBranchToFranchiseUC addBranchToFranchiseUC(FranchiseRepository franchiseRepository,
			BranchRepository branchRepository) {
		return new AddBranchToFranchiseUC(franchiseRepository, branchRepository);
	}

	@Bean
	public RenameBranchUC renameBranchUC(BranchRepository branchRepository) {
		return new RenameBranchUC(branchRepository);
	}

	@Bean
	public AddProductToBranchUC addProductToBranchUC(BranchRepository branchRepository,
			ProductRepository productRepository) {
		return new AddProductToBranchUC(branchRepository, productRepository);
	}

	@Bean
	public RenameProductUC renameProductUC(ProductRepository productRepository) {
		return new RenameProductUC(productRepository);
	}

	@Bean
	public UpdateProductStockUC updateProductStockUC(ProductRepository productRepository) {
		return new UpdateProductStockUC(productRepository);
	}

	@Bean
	public RemoveProductUC removeProductUC(ProductRepository productRepository) {
		return new RemoveProductUC(productRepository);
	}

	@Bean
	public GetMaxStockProductsByFranchiseUC getMaxStockProductsByFranchiseUC(BranchRepository branchRepository,
			ProductRepository productRepository) {
		return new GetMaxStockProductsByFranchiseUC(branchRepository, productRepository);
	}
}
