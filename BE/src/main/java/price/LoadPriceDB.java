package warehouse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadPriceDB {

    private static final Logger log = LoggerFactory.getLogger(LoadPriceDB.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Price(0.00)));
            log.info("Preloading " + repository.save(new Price(1.99)));
        };
    }
}