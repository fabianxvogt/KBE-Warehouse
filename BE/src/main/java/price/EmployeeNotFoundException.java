package warehouse;

class PriceNotFoundException extends RuntimeException {

  PriceNotFoundException(Long id) {
    super("Could not find price for the product with id:  " + id); //nur sinnvoll für Price von Produkt mit ID XY
  }
}