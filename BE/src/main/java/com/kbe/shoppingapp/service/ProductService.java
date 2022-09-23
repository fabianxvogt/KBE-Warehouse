package com.kbe.shoppingapp.service;

import com.kbe.shoppingapp.model.Product;
import com.kbe.shoppingapp.repository.ProductRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

	@Autowired
	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
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
		_product.setPrice(product.getPrice());
		_product.setComponentIds(product.getComponentIds());
				
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
}