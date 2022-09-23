package com.kbe.shoppingapp.service;
  
import com.kbe.shoppingapp.model.Category;
import java.util.List;
import org.springframework.stereotype.Service;
  
@Service
public interface ICategoryService {
  
    // Save operation
    Category create(Category category);
  
    // Read operation
    List<Category> readAll();

    Category readById(Long categoryId);
  
    // Update operation
    Category update(Category category, Long categoryId);
  
    // Delete operation
    void deleteById(Long categoryId);

    void deleteAll();

}