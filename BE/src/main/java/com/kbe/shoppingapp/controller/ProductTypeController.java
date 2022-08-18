package com.kbe.shoppingapp.controller;


import com.kbe.shoppingapp.model.ProductType; 
//import com.shoppingapp.repos.ProductTypeRepository; 
import com.kbe.shoppingapp.service.IProductTypeService;
import com.kbe.shoppingapp.utils.SequenceGeneratorService;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import org.springframework.web.servlet.ModelAndView;
import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
class ProductTypeController {

  @Autowired
  private SequenceGeneratorService sequenceGeneratorService;
  
  @Autowired 
  private IProductTypeService productTypeService;


  // public ProductTypeController(IProductTypeService productTypeService) {
  //     this.productTypeService = productTypeService;
  // }

  @GetMapping("/productTypes")
  public List<ProductType> getProductTypes() {
    return (List<ProductType>) this.productTypeService.readAll();
  }

  @GetMapping("/productTypes/{id}")
  public ProductType getProductTypeById(@PathVariable("id") long id) {
    return (ProductType) this.productTypeService.readById(id);
  }

  @PostMapping("/productTypes")
  ProductType insertProductType(@RequestBody ProductType productType) {
    productType.setId(sequenceGeneratorService.generateSequence(ProductType.SEQUENCE_NAME));
    return this.productTypeService.create(productType);
  }

  @PutMapping("/productTypes/{id}")
  public ProductType updateProductType(@PathVariable("id") long id, @RequestBody ProductType productType) {
    return this.productTypeService.update(productType,id);
  }

  @DeleteMapping("/productTypes/{id}")
  public String deleteProductType(@PathVariable("id") long id) {
    this.productTypeService.deleteById(id);
    
    return "deleted product type: " + id;
  }
  @DeleteMapping("/productTypes")
  public String deleteAllProductTypes() {
    this.productTypeService.deleteAll();
    
    return "deleted all product types";
  }

  /* 
  List<ProductType> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]
  @PostMapping("/productTypes")
  ProductType newProductType(@RequestBody ProductType newProductType) {
    return repository.save(newProductType);
  }

  // Single item
  
  @GetMapping("/productTypes/{id}")
  ProductType one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new ProductTypeNotFoundException(id));
  }

  @PutMapping("/productTypes/{id}")
  ProductType replaceProductType(@RequestBody ProductType newProductType, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(ProductType -> {
        ProductType.setName(newProductType.getName());
        //ProductType.setParent(newProductType.getParent());
        return repository.save(ProductType);
      })
      .orElseGet(() -> {
        newProductType.setId(id);
        return repository.save(newProductType);
      });
  }

  @DeleteMapping("/productTypes/{id}")
  void deleteProductType(@PathVariable Long id) {
    repository.deleteById(id);
  }
  */
}