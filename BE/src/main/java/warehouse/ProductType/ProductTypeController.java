package warehouse;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ProductTypeController {

  private final ProductTypeRepository repository;

  ProductTypeController(ProductTypeRepository repository) {
    this.repository = repository;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/product_types")
  List<ProductType> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/product_types")
  ProductType newProductType(@RequestBody ProductType newProductType) {
    return repository.save(newProductType);
  }

  // Single item
  
  @GetMapping("/product_types/{id}")
  ProductType one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new ProductTypeNotFoundException(id));
  }

  @PutMapping("/product_types/{id}")
  ProductType replaceProductType(@RequestBody ProductType newProductType, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(productType -> {
        productType.setName(newProductType.getName());
        productType.setRole(newProductType.getRole());
        return repository.save(productType);
      })
      .orElseGet(() -> {
        newProductType.setId(id);
        return repository.save(newProductType);
      });
  }

  @DeleteMapping("/product_types/{id}")
  void deleteProductType(@PathVariable Long id) {
    repository.deleteById(id);
  }
}