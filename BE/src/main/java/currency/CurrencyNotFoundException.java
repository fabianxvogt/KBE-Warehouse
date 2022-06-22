package warehouse;

class CurrencyNotFoundException extends RuntimeException {

    CurrencyNotFoundException(Long id) {
        super("Could not find currency " + id);
    }
}