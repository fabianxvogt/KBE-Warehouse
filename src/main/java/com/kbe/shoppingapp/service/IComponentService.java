package com.kbe.shoppingapp.service;
  
import com.kbe.shoppingapp.model.Component;
import java.util.List;
import org.springframework.stereotype.Service;
  
@Service
public interface IComponentService {
  
    // Save operation
    Component create(Component component);
  
    // Read operation
    List<Component> readAll();

    Component readById(Long componentId);
  
    // Update operation
    Component update(Component component, Long componentId);
  
    // Delete operation
    void deleteById(Long componentTypeId);

    void deleteAll();

}