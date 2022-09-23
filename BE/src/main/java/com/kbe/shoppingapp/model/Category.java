package com.kbe.shoppingapp.model;

import java.util.List;
import java.util.Objects;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@Document
public class Category {
    
  @Transient
  public static final String SEQUENCE_NAME = "category";

  private @Id Long id;
  private String categoryName;
  private List<Product> products; 
  private List<Long> productIds; 
  private String imageUrl;
  private String description;
  
  Category() {}

  Category(String categoryName, String description, String imageURL, List<Long> productIds) {

    this.categoryName = categoryName;
    this.description = description;
    this.imageUrl = imageURL;
    this.productIds = productIds;
  }

  public Long getId() {
    return this.id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  public String getCategoryName() {
    return this.categoryName;
  }
  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public String getDescription() {
    return this.description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  public String getImageUrl() {
    return this.imageUrl;
  }
  public void setImageUrl(String imageURL) {
    this.imageUrl = imageURL;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Category))
      return false;
      Category c = (Category) o;
    return Objects.equals(this.id, c.id) && Objects.equals(this.categoryName, c.categoryName);
  }
  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.categoryName);
  }

  @Override
  public String toString() {
    return "Category{" + 
      "id=" + this.id + ", " + 
      "name='" + this.categoryName + "\'," +
      "description='" + this.description + "\'," +
      "imageURL='" + this.imageUrl + "\'," +
    "}";
  }
  
  public void setProducts(List<Product> products) {
    this.products = products;
  }
  public List<Product> getProducts() {
    return this.products;
  }
  public void setProductIds(List<Long> productIds) {
    this.productIds = productIds;
  }
  public List<Long> getProductIds() {
    return this.productIds;
  }
}
