package com.kbe.shoppingapp.repository;

import com.kbe.shoppingapp.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, Long> {

}