package com.kbe.shoppingapp.controller;
import java.util.ArrayList;
import java.util.List;

import com.kbe.shoppingapp.model.Component;
import com.kbe.shoppingapp.model.Product;
import com.kbe.shoppingapp.service.IComponentService;
import com.kbe.shoppingapp.service.IProductService;
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
class ProductController {

  @Autowired
  private SequenceGeneratorService sequenceGeneratorService;

  @Autowired
  private IProductService productService;

  @Autowired
  private IComponentService componentService;

  @GetMapping("/product")
  public List<Product> getProducts() {
    return (List<Product>) this.productService.readAll();
  }

  @GetMapping("/product/{id}")
  public Product getProductById(
    @PathVariable("id") long id,
    @RequestParam(value = "loadChildProducts") Boolean loadChildProducts
  ) {
    Product product = (Product) this.productService.readById(id);
    if (loadChildProducts) {
      product = loadComponents(product);
    }
    return product;
  }

  private Product loadComponents(Product product) {
      List<Component> components = new ArrayList<Component>();
      for (Long componentId : product.getComponentIds()) {
        try {
          Component c = this.componentService.readById(componentId);  
          components.add(c);   
          if (c.getComponentIds().size() > 0) {
            System.out.println(c.getComponentIds());   
            //c = loadComponents(child);
          }
        } catch (Exception e) {
          continue;
        }
      }
      product.setComponents(components);
      return product;
  }

  @PostMapping("/product")
  Product insertProduct(@RequestBody Product product) {
    product.setId(sequenceGeneratorService.generateSequence(Product.SEQUENCE_NAME));
    return this.productService.create(product);
  }

  @PutMapping("/product/{id}")
  public Product updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
    return this.productService.update(product, id);
  }

  @DeleteMapping("/product/{id}")
  public String deleteProduct(@PathVariable("id") long id) {
    this.productService.deleteById(id);

    return "deleted product: " + id;
  }

  @DeleteMapping("/product")
  public String deleteAllProducts() {
    this.productService.deleteAll();

    return "deleted all product";
  }
  @PostMapping("/productTypes/{productTypeId}/product")
  public Product create(
      @PathVariable(value = "productTypeId") Long productTypeId,
      @RequestBody Product product) {
    product.setId(sequenceGeneratorService.generateSequence(Product.SEQUENCE_NAME));
    return this.productService.create(product);
  }
}