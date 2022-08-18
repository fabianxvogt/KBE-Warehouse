package com.kbe.shoppingapp.repository;

import com.kbe.shoppingapp.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {

}
/* 
package com.shoppingapp.repos;

import com.shoppingapp.model.Product; 
import com.shoppingapp.repos.ProductRepositoryInterface; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepository implements ProductRepositoryInterface {
  
    // Using an in-memory Map
    // to store the object data
    private Map<Long, Product> repository;
  
    public ProductRepository() {
        this.repository = new HashMap<>();
    }
  
    @Override
    public void save(Product product) {
        repository.put(product.getId(), product);
    }
  
    @Override
    public Product findProductById(Long id) {
        return repository.get(id);
    }
}

*/