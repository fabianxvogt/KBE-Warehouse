package com.kbe.shoppingapp.service;
  
import com.kbe.shoppingapp.model.Product;
import java.util.List;
import org.springframework.stereotype.Service;
  
@Service
public interface IProductService {
  
    // Save operation
    Product create(Product product);
  
    // Read operation
    List<Product> readAll();

    Product readById(Long productId);
  
    // Update operation
    Product update(Product product, Long productId);
  
    // Delete operation
    void deleteById(Long productId);

    void deleteAll();

}