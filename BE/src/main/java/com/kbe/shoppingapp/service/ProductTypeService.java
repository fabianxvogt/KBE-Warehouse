// Java Program to Illustrate ProductServiceImpl File

// Importing package module to code fragment
package com.kbe.shoppingapp.service;

import com.kbe.shoppingapp.exception.ResourceNotFoundException;
import com.kbe.shoppingapp.model.ProductType;
import com.kbe.shoppingapp.repository.ProductTypeRepository;
// Importing required classes
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

// Annotation
@Service
public class ProductTypeService
	implements IProductTypeService {

	@Autowired
	private final ProductTypeRepository productTypeRepository;

	public ProductTypeService(ProductTypeRepository productTypeRepository) {
		this.productTypeRepository = productTypeRepository;
		this.productTypeRepository.deleteAll();
	}

	// Save operation
	@Override
	public ProductType create(ProductType ProductType)
	{
		return this.productTypeRepository.save(ProductType);
	}

	// Read operation
	@Override 
	public List<ProductType> readAll()
	{
		return (List<ProductType>) this.productTypeRepository.findAll();
	}

	// Read operation
	@Override 
	public ProductType readById(Long productTypeId)
	{
		return this.productTypeRepository.findById(productTypeId).get();
	}

	// Update operation
	@Override
	public ProductType update(
		ProductType productType,
		Long productTypeId
	) {
		ProductType _productType = this.productTypeRepository.findById(productTypeId).get();

		_productType.setName(productType.getName());
				
		return this.productTypeRepository.save(_productType);
	}

	// Delete operation
	@Override
	public void deleteById(Long ProductTypeId)
	{
		this.productTypeRepository.deleteById(ProductTypeId);
	}

	@Override
	public void deleteAll()
	{
		this.productTypeRepository.deleteAll();
	}
}
