package com.kbe.shoppingapp.service;
  
import com.kbe.shoppingapp.model.ComponentType;
import java.util.List;
import org.springframework.stereotype.Service;
  
@Service
public interface IComponentTypeService {
  
    // Save operation
    ComponentType create(ComponentType componentType);
  
    // Read operation
    List<ComponentType> readAll();

    ComponentType readById(Long componentTypeId);
  
    // Update operation
    ComponentType update(ComponentType componentType, Long componentTypeId);
  
    // Delete operation
    void deleteById(Long componentTypeId);

    void deleteAll();
}