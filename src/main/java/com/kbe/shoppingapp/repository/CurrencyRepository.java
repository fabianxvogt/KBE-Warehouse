package com.kbe.shoppingapp.repository;

import com.kbe.shoppingapp.model.Currency;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends MongoRepository<Currency, Long> {
    
    @Query("SELECT * FROM Currency c WHERE c.isoCode = ?1")
    Currency findByIsoCode(String isoCode);

    @Query("DELETE FROM Currency c WHERE c.isoCode = ?1")
    void deleteByIsoCode(String isoCode);

}