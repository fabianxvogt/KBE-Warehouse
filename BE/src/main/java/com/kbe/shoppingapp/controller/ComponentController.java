package com.kbe.shoppingapp.controller;
import java.util.ArrayList;
import java.util.List;

import com.kbe.shoppingapp.model.Component;
import com.kbe.shoppingapp.service.IComponentService;
import com.kbe.shoppingapp.utils.SequenceGeneratorService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
class ComponentController {

  @Autowired
  private SequenceGeneratorService sequenceGeneratorService;

  @Autowired
  private IComponentService componentService;

  @GetMapping("/components")
  public List<Component> getComponents() {
    return (List<Component>) this.componentService.readAll();
  }

  @GetMapping("/components/{id}")
  public Component getComponentById(
    @PathVariable("id") long id,
    @RequestParam(value = "loadChildComponents") Boolean loadChildComponents
  ) {
    Component component = (Component) this.componentService.readById(id);
    if (loadChildComponents) {
      component = loadComponentChildren(component);
    }
    return component;
  }

  private Component loadComponentChildren(Component component) {
      List<Component> children = new ArrayList<Component>();
      for (Long componentId : component.getComponentIds()) {
        try {
          Component child = this.componentService.readById(componentId);  
          children.add(child);   
          if (child.getComponentIds().size() > 0) {
            System.out.println(child.getComponentIds());   
            child = loadComponentChildren(child);
          }
        } catch (Exception e) {
          continue;
        }
      }
      component.setComponents(children);
      return component;
  }

  @PostMapping("/components")
  Component insertComponent(@RequestBody Component component) {
    component.setId(sequenceGeneratorService.generateSequence(Component.SEQUENCE_NAME));
    return this.componentService.create(component);
  }

  @PutMapping("/components/{id}")
  public Component updateComponent(@PathVariable("id") long id, @RequestBody Component component) {
    return this.componentService.update(component, id);
  }

  @DeleteMapping("/components/{id}")
  public String deleteComponent(@PathVariable("id") long id) {
    this.componentService.deleteById(id);

    return "deleted component: " + id;
  }

  @DeleteMapping("/components")
  public String deleteAllComponents() {
    this.componentService.deleteAll();

    return "deleted all components";
  }
  @PostMapping("/componentTypes/{componentTypeId}/components")
  public Component create(
      @PathVariable(value = "componentTypeId") Long componentTypeId,
      @RequestBody Component component) {
    component.setId(sequenceGeneratorService.generateSequence(Component.SEQUENCE_NAME));
    component.setComponentTypeId(componentTypeId);
    return this.componentService.create(component);
  }
}