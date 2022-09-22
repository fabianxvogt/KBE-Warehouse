package com.kbe.shoppingapp.model;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Transient;

@Document
public class User {

  @Transient
  public static final String SEQUENCE_NAME = "user";

  public String email;
  public String password; // TODO: Hash

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  
  public User() {}  

  public User(String email, String password) {
    this.email = email;
    this.password = password;
  }
  @Override
  public String toString() {
    return "User{" + 
      "email=" + this.email + ", " + 
      "password='" + this.password + "\'" +
    "}";
  }
}