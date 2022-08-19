package com.kbe.shoppingapp.service;
  
import com.kbe.shoppingapp.model.Price;
import java.util.List;
import org.springframework.stereotype.Service;
  
@Service
public interface IPriceService {
    /* 
    // Save operation
    Price create(Price component);
  
    // Read operation
    List<Price> readAll();

    Price readById(Long componentId);
  
    // Update operation
    Price update(Price component, Long componentId);
  
    // Delete operation
    void deleteById(Long componentTypeId);

    void deleteAll();
    */
    Price calculatePriceForComponent(long componentId, String currencyIso);
}