package com.shoppingapp.controller;


import com.shoppingapp.model.Product; 
//import com.shoppingapp.repos.ProductRepository; 
import com.shoppingapp.service.IProductService; 
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
import java.util.List;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
class ProductController {

  @Autowired 
  private final IProductService productService;


  public ProductController(IProductService productService) {
      this.productService = productService;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/products")
  public ModelAndView getProducts() {

    List<Product> products = (List<Product>) this.productService.fetchProductList();

    HashMap<String, Object> params = new HashMap<String, Object>();
    params.put("products", products);

    return new ModelAndView("showProducts", params);
}

  /* 
  List<Product> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]
  @PostMapping("/products")
  Product newProduct(@RequestBody Product newProduct) {
    return repository.save(newProduct);
  }

  // Single item
  
  @GetMapping("/products/{id}")
  Product one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new ProductNotFoundException(id));
  }

  @PutMapping("/products/{id}")
  Product replaceProduct(@RequestBody Product newProduct, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(Product -> {
        Product.setName(newProduct.getName());
        //Product.setParent(newProduct.getParent());
        return repository.save(Product);
      })
      .orElseGet(() -> {
        newProduct.setId(id);
        return repository.save(newProduct);
      });
  }

  @DeleteMapping("/products/{id}")
  void deleteProduct(@PathVariable Long id) {
    repository.deleteById(id);
  }
  */
}