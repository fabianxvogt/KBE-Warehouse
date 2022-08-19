package com.kbe.shoppingapp.repository;

import com.kbe.shoppingapp.model.Component;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentRepository extends MongoRepository<Component, Long> {

}