package com.kbe.shoppingapp.model;

import java.util.Objects;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@Document
public class Product {

  @Transient
  public static final String SEQUENCE_NAME = "product";

  private @Id Long id;
  private String name;
  private Long productTypeId;
  private ProductType productType;
  private Float price;
  
  Product() {}

  Product(String name, ProductType productType) {

    this.name = name;
    //this.productTypeId = productTypeId;
    this.productType = productType;
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  // public Long getProductTypeId() {
  //   return this.productTypeId;
  // }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  // public void setProductTypeId(Long productTypeId) {
  //   this.productTypeId = productTypeId;
  // }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Product))
      return false;
      Product c = (Product) o;
    return Objects.equals(this.id, c.id) && Objects.equals(this.name, c.name);
  }
  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name);
  }

  @Override
  public String toString() {
    return "Product{" + 
      "id=" + this.id + ", " + 
      "name='" + this.name + "\'," +
      "productTypeId=" + this.productTypeId + 
    "}";
  }

  public void setProductType(ProductType productType) {
    this.productType = productType;
  }
  public ProductType getProductType() {
    return this.productType;
  }
}