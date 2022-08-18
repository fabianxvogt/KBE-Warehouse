package com.kbe.shoppingapp.repository;

import com.kbe.shoppingapp.model.ProductType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends MongoRepository<ProductType, Long> {

}