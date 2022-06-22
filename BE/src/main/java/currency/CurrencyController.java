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
class CurrencyController {

    private final CurrencyRepository repository;

    CurrencyController(CurrencyRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/currencies")
    List<Currency> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/currencies")
    Currency newCurrency(@RequestBody Currency newCurrency) {
        return repository.save(newCurrency);
    }

    // Single item

    @GetMapping("/currencies/{id}")
    Currency one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new CurrencyNotFoundException(id)); //Exception muss noch hinzugefügt werden
    }

    @PutMapping("/currencies/{id}")
    Currency replaceCurrency(@RequestBody Currency newCurrency, @PathVariable Long id) {

        return repository.findById(id)
                .map(currency -> {
                    currency.setName(newCurrency.getName());
                    currency.setRole(newCurrency.getRole());
                    currency.setValueToEuro(newCurrency.getValueToEuro());
                    return repository.save(currency);
                })
                .orElseGet(() -> {
                    newCurrency.setId(id);
                    return repository.save(newCurrency);
                });
    }

    @DeleteMapping("/currencies/{id}")
    void deleteCurrency(@PathVariable Long id) {
        repository.deleteById(id);
    }
}