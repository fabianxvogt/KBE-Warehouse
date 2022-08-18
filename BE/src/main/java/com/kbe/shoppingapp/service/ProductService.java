// Java Program to Illustrate ProductServiceImpl File

// Importing package module to code fragment
package com.kbe.shoppingapp.service;

import com.kbe.shoppingapp.model.Product;
import com.kbe.shoppingapp.repository.ProductRepository;
import com.kbe.shoppingapp.repository.ProductTypeRepository;
// Importing required classes
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Annotation
@Service
public class ProductService implements IProductService {

	@Autowired
	private final ProductRepository productRepository;
	@Autowired
	private final ProductTypeRepository productTypeRepository;

	public ProductService(ProductRepository productRepository, ProductTypeRepository productTypeRepository) {
		this.productRepository = productRepository;
		this.productTypeRepository = productTypeRepository;
		this.productRepository.deleteAll();
	}

	// Save operation
	@Override
	public Product create(Product Product)
	{
		return this.productRepository.save(Product);
	}

	// Read operation
	@Override 
	public List<Product> readAll()
	{
		return (List<Product>) this.productRepository.findAll();
	}

	// Read operation
	@Override 
	public Product readById(Long productId)
	{
		return this.productRepository.findById(productId).get();
	}

	// Update operation
	@Override
	public Product update(Product product, Long productId) {
		Product _product = this.productRepository.findById(productId).get();

		_product.setName(product.getName());
				
		return this.productRepository.save(_product);
	}

	// Delete operation
	@Override
	public void deleteById(Long ProductId)
	{
		this.productRepository.deleteById(ProductId);
	}

	@Override
	public void deleteAll()
	{
		this.productRepository.deleteAll();
	}

	@Override
	public Product createForProductType(Product product, Long productTypeId) {
		return this.productTypeRepository.findById(productTypeId).map(productType -> {
			product.setProductType(productType);
			return this.productRepository.save(product);
		}).get();
	}
}