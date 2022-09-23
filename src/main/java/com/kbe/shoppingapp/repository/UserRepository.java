package com.kbe.shoppingapp.repository;

import com.kbe.shoppingapp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
    @Query("SELECT * FROM User u WHERE u.email = ?1")
    User findByEmail(String email);
}   