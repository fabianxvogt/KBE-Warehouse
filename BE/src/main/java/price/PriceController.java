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
class PriceController {

    private final PriceRepository repository;

    PriceController(PriceRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/prices")
    List<Price> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/prices")
    Price newPrice(@RequestBody Price newPrice) {
        return repository.save(newPrice);
    }

    // Single item

    @GetMapping("/prices/{id}")
    Price one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new PriceNotFoundException(id)); //Exception muss noch hinzugefügt werden
    }

    @PutMapping("/prices/{id}")
    Price replacePrice(@RequestBody Price newPrice, @PathVariable Long id) {

        return repository.findById(id)
                .map(price -> {
                    price.setRole(newPrice.getRole());
                    price.setValue(newPrice.getValue());
                    return repository.save(price);
                })
                .orElseGet(() -> {
                    newPrice.setId(id);
                    return repository.save(newPrice);
                });
    }

    @DeleteMapping("/prices/{id}")
    void deletePrice(@PathVariable Long id) {
        repository.deleteById(id);
    }
}