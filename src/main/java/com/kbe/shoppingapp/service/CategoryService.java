package com.kbe.shoppingapp.service;

import com.kbe.shoppingapp.model.Category;
import com.kbe.shoppingapp.repository.CategoryRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
		this.categoryRepository.deleteAll();
	}

	// Save operation
	@Override
	public Category create(Category Category)
	{
		return this.categoryRepository.save(Category);
	}

	// Read operation
	@Override 
	public List<Category> readAll()
	{
		return (List<Category>) this.categoryRepository.findAll();
	}

	// Read operation
	@Override 
	public Category readById(Long categoryId)
	{
		return this.categoryRepository.findById(categoryId).get();
	}

	// Update operation
	@Override
	public Category update(Category category, Long categoryId) {
		Category _category = this.categoryRepository.findById(categoryId).get();

		_category.setCategoryName(category.getCategoryName());
		_category.setDescription(category.getDescription());
		_category.setProductIds(category.getProductIds());
				
		return this.categoryRepository.save(_category);
	}

	// Delete operation
	@Override
	public void deleteById(Long CategoryId)
	{
		this.categoryRepository.deleteById(CategoryId);
	}

	@Override
	public void deleteAll()
	{
		this.categoryRepository.deleteAll();
	}
}