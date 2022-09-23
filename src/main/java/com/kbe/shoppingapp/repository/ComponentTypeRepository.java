package com.kbe.shoppingapp.repository;

import com.kbe.shoppingapp.model.ComponentType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentTypeRepository extends MongoRepository<ComponentType, Long> {

}