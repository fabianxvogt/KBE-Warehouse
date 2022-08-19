package com.kbe.shoppingapp.controller;


import com.kbe.shoppingapp.model.ComponentType; 
import com.kbe.shoppingapp.service.IComponentTypeService;
import com.kbe.shoppingapp.utils.SequenceGeneratorService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
class ComponentTypeController {

  @Autowired
  private SequenceGeneratorService sequenceGeneratorService;
  
  @Autowired 
  private IComponentTypeService componentTypeService;


  // public ComponentTypeController(IComponentTypeService componentTypeService) {
  //     this.componentTypeService = componentTypeService;
  // }

  @GetMapping("/componentTypes")
  public List<ComponentType> getComponentTypes() {
    return (List<ComponentType>) this.componentTypeService.readAll();
  }

  @GetMapping("/componentTypes/{id}")
  public ComponentType getComponentTypeById(@PathVariable("id") long id) {
    return (ComponentType) this.componentTypeService.readById(id);
  }

  @PostMapping("/componentTypes")
  ComponentType insertComponentType(@RequestBody ComponentType componentType) {
    componentType.setId(sequenceGeneratorService.generateSequence(ComponentType.SEQUENCE_NAME));
    return this.componentTypeService.create(componentType);
  }

  @PutMapping("/componentTypes/{id}")
  public ComponentType updateComponentType(@PathVariable("id") long id, @RequestBody ComponentType componentType) {
    return this.componentTypeService.update(componentType,id);
  }

  @DeleteMapping("/componentTypes/{id}")
  public String deleteComponentType(@PathVariable("id") long id) {
    this.componentTypeService.deleteById(id);
    
    return "deleted component type: " + id;
  }
  @DeleteMapping("/componentTypes")
  public String deleteAllComponentTypes() {
    this.componentTypeService.deleteAll();
    
    return "deleted all component types";
  }

  /* 
  List<ComponentType> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]
  @PostMapping("/componentTypes")
  ComponentType newComponentType(@RequestBody ComponentType newComponentType) {
    return repository.save(newComponentType);
  }

  // Single item
  
  @GetMapping("/componentTypes/{id}")
  ComponentType one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new ComponentTypeNotFoundException(id));
  }

  @PutMapping("/componentTypes/{id}")
  ComponentType replaceComponentType(@RequestBody ComponentType newComponentType, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(ComponentType -> {
        ComponentType.setName(newComponentType.getName());
        //ComponentType.setParent(newComponentType.getParent());
        return repository.save(ComponentType);
      })
      .orElseGet(() -> {
        newComponentType.setId(id);
        return repository.save(newComponentType);
      });
  }

  @DeleteMapping("/componentTypes/{id}")
  void deleteComponentType(@PathVariable Long id) {
    repository.deleteById(id);
  }
  */
}