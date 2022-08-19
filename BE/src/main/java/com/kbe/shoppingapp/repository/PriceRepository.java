package com.kbe.shoppingapp.repository;

import com.kbe.shoppingapp.model.Price;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends MongoRepository<Price, Long> {

}