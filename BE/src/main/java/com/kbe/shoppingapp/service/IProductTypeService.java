package com.kbe.shoppingapp.service;
  
import com.kbe.shoppingapp.model.ProductType;
// Importing required classes
import java.util.List;
import org.springframework.stereotype.Service;
  
// Interface
@Service
public interface IProductTypeService {
  
    // Save operation
    ProductType create(ProductType productType);
  
    // Read operation
    List<ProductType> readAll();

    ProductType readById(Long productTypeId);
  
    // Update operation
    ProductType update(ProductType productType, Long productTypeId);
  
    // Delete operation
    void deleteById(Long productTypeId);

    void deleteAll();
}