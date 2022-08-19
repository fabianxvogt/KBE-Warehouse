package com.kbe.shoppingapp.model;

import java.util.List;
import java.util.Objects;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@Document
public class Component {

  @Transient
  public static final String SEQUENCE_NAME = "component";

  private @Id Long id;
  private String name;
  private Long componentTypeId;
  private List<Component> components; 
  private List<Long> componentIds; 
  //private ComponentType componentType;
  private Float usdPrice;
  
  Component() {}

  Component(String name, Long componentTypeId, Float usdPrice, List<Long> componentIds) {

    this.name = name;
    this.componentTypeId = componentTypeId;
    //this.componentType = componentType;
    this.usdPrice = usdPrice;
    this.componentIds = componentIds;
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public Long getComponentTypeId() {
    return this.componentTypeId;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setComponentTypeId(Long componentTypeId) {
    this.componentTypeId = componentTypeId;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Component))
      return false;
      Component c = (Component) o;
    return Objects.equals(this.id, c.id) && Objects.equals(this.name, c.name);
  }
  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name);
  }

  @Override
  public String toString() {
    return "Component{" + 
      "id=" + this.id + ", " + 
      "name='" + this.name + "\'," +
      "componentTypeId=" + this.componentTypeId + 
    "}";
  }
  

  public void setUsdPrice(Float usdPrice) {
    this.usdPrice = usdPrice;
  }
  public Float getUsdPrice() {
    return this.usdPrice;
  }
  // public void setComponentType(ComponentType componentType) {
  //   this.componentType = componentType;
  // }
  // public ComponentType getComponentType() {
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