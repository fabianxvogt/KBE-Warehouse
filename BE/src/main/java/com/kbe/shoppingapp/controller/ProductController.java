package com.kbe.shoppingapp.controller;


import com.kbe.shoppingapp.model.Product; 
//import com.shoppingapp.repos.ProductRepository; 
import com.kbe.shoppingapp.service.IProductService;
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

import org.springframework.beans.factory.annotation.Autowired;

@RestController
class ProductController {

  @Autowired
  private SequenceGeneratorService sequenceGeneratorService;

  @Autowired 
  private IProductService productService;


  @GetMapping("/products")
  public List<Product> getProducts() {
    return (List<Product>) this.productService.readAll();
  }

  @GetMapping("/products/{id}")
  public Product getProductById(@PathVariable("id") long id) {
    return (Product) this.productService.readById(id);
  }

  @PostMapping("/products")
  Product insertProduct(@RequestBody Product product) {
    product.setId(sequenceGeneratorService.generateSequence(Product.SEQUENCE_NAME));
    return this.productService.create(product);
  }

  @PutMapping("/products/{id}")
  public Product updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
    return this.productService.update(product,id);
  }

  @DeleteMapping("/products/{id}")
  public String deleteProduct(@PathVariable("id") long id) {
    this.productService.deleteById(id);
    
    return "deleted product: " + id;
  }
  @DeleteMapping("/products")
  public String deleteAllProducts() {
    this.productService.deleteAll();
    
    return "deleted all products";
  }

  @PostMapping("/productTypes/{productTypeId}/products")
  public Product create(
    @PathVariable(value = "productTypeId") Long productTypeId, 
    @RequestBody Product product
  ) {
    product.setId(sequenceGeneratorService.generateSequence(Product.SEQUENCE_NAME));
    return this.productService.createForProductType(product, productTypeId);
  }
}