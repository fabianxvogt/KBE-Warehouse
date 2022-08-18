// Java Program to Illustrate ProductServiceImpl File

// Importing package module to code fragment
package com.shoppingapp.service;

import com.shoppingapp.model.Product;
import com.shoppingapp.repository.ProductRepository;
// Importing required classes
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Annotation
@Service
public class ProductService
	implements IProductService {

	//@Autowired
	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	// Save operation
	@Override
	public Product saveProduct(Product Product)
	{
		return this.productRepository.save(Product);
	}

	// Read operation
	@Override public List<Product> fetchProductList()
	{
		return (List<Product>)
        this.productRepository.findAll();
	}

	// Update operation
	@Override
	public Product
	updateProduct(Product Product,
					Long ProductId)
	{
		Product prodDB
			= this.productRepository.findById(ProductId)
				.get();
/* 
		if (Objects.nonNull(Product.getProductName())
			&& !"".equalsIgnoreCase(
				Product.getProductName())) {
			depDB.setProductName(
				Product.getProductName());
		}

		if (Objects.nonNull(
				Product.getProductAddress())
			&& !"".equalsIgnoreCase(
				Product.getProductAddress())) {
			depDB.setProductAddress(
				Product.getProductAddress());
		}

		if (Objects.nonNull(Product.getProductCode())
			&& !"".equalsIgnoreCase(
				Product.getProductCode())) {
			depDB.setProductCode(
				Product.getProductCode());
		}

        */
		return this.productRepository.save(prodDB);
	}

	// Delete operation
	@Override
	public void deleteProductById(Long ProductId)
	{
		this.productRepository.deleteById(ProductId);
	}
}
