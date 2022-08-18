package com.kbe.shoppingapp.model;

import java.util.Objects;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@Document
public class ProductType {

  @Transient
  public static final String SEQUENCE_NAME = "productType";

  private @Id Long id;
  private String name;
  
  ProductType() {}

  ProductType(String name) {
    this.name = name;
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof ProductType))
      return false;
      ProductType c = (ProductType) o;
    return Objects.equals(this.id, c.id) && Objects.equals(this.name, c.name);
  }
  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name);
  }

  @Override
  public String toString() {
    return "Product{" + "id=" + this.id + ", name='" + this.name + '\'' + '}';
  }
}