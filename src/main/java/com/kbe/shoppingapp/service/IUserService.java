package com.kbe.shoppingapp.service;
  
import com.kbe.shoppingapp.exception.EmailAlreadyExistsException;
import com.kbe.shoppingapp.model.User;
import java.util.List;
import org.springframework.stereotype.Service;
  
@Service
public interface IUserService {
        // Save operation
        User singUp(User user) throws EmailAlreadyExistsException;

        User singIn(String email, String password) throws Exception;
  
        // Read operation
        List<User> readAll();
    
        User readByEmail(String email);
      
        // Update operation
        User update(User user);
      
        // Delete operation
        void deleteByEmail(String email);
    
        void deleteAll();
}