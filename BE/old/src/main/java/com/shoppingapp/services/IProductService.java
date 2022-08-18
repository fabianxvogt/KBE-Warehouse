package com.shoppingapp.service;
  
import com.shoppingapp.model.Product;
// Importing required classes
import java.util.List;
import org.springframework.stereotype.Service;
  
// Interface
@Service
public interface IProductService {
  
    // Save operation
    Product saveProduct(Product product);
  
    // Read operation
    List<Product> fetchProductList();
  
    // Update operation
    Product updateProduct(Product product,
                                Long productId);
  
    // Delete operation
    void deleteProductById(Long productId);
}