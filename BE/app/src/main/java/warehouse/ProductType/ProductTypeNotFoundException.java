package warehouse;

class ProductTypeNotFoundException extends RuntimeException {

    ProductTypeNotFoundException(Long id) {
    super("Could not find product type " + id);
  }
}