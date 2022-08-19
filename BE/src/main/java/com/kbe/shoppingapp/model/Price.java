package com.kbe.shoppingapp.model;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Transient;

@Document
public class Price {

  @Transient
  public static final String SEQUENCE_NAME = "price";

  //private @Id Long id;

  private Float totalPrice;

  public Float getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Float totalPrice) {
    this.totalPrice = totalPrice;
  }

  public String getCurrencyIsoCode() {
    return currencyIsoCode;
  }

  public void setCurrencyIsoCode(String currencyIsoCode) {
    this.currencyIsoCode = currencyIsoCode;
  }

  public long getComponentId() {
    return componentId;
  }

  public void setComponentId(long componentId) {
    this.componentId = componentId;
  }
  private String currencyIsoCode;

  private long componentId;
  
  public Price() {}  

  public Price(Float totalPrice, String currencyIsoCode, long componentId) {
    this.totalPrice = totalPrice;
    this.currencyIsoCode = currencyIsoCode;
    this.componentId = componentId;
  }
/* 
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
    if (!(o instanceof Price))
      return false;
      Price c = (Price) o;
    return Objects.equals(this.id, c.id) && Objects.equals(this.name, c.name);
  }
  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name);
  }

*/
  @Override
  public String toString() {
    return "Price{" + 
      "component=" + this.componentId + ", " + 
      "currency='" + this.currencyIsoCode + "\'" + 
      "price=" + this.totalPrice + 
    "}";
  }
}