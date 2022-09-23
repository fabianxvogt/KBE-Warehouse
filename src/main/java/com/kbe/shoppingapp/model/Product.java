package com.kbe.shoppingapp.model;

import java.util.List;
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
  private List<Component> components; 
  private List<Long> componentIds; 
  private Float price;
  private String imageURL;
  private String description;
  private Long categoryId;
  
  Product() {}

  Product(String name, String description, Float price, String imageURL, Long categoryId, List<Long> componentIds) {

    this.name = name;
    this.description = description;
    this.price = price;
    this.imageURL = imageURL;
    this.categoryId = categoryId;
    this.componentIds = componentIds;
  }

  public Long getId() {
    return this.id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  public Long getCategoryId() {
    return this.categoryId;
  }
  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  public String getImageURL() {
    return this.imageURL;
  }
  public void setImageURL(String imageURL) {
    this.imageURL = imageURL;
  }

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
      "description='" + this.description + "\'," +
      "imageURL='" + this.imageURL + "\'," +
    "}";
  }
  

  public void setPrice(Float price) {
    this.price = price;
  }
  public Float getPrice() {
    return this.price;
  }
  // public void setProductType(ProductType componentType) {
  //   this.componentType = componentType;
  // }
  // public ProductType getProductType() {
  //   return this.componentType;
  // }
  public void setComponents(List<Component> components) {
    this.components = components;
  }
  public List<Component> getComponents() {
    return this.components;
  }
  public void setComponentIds(List<Long> componentIds) {
    this.componentIds = componentIds;
  }
  public List<Long> getComponentIds() {
    return this.componentIds;
  }
}
