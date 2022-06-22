package warehouse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadCurrencyDB {

    private static final Logger log = LoggerFactory.getLogger(LoadCurrencyDB.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Currency("Euro", 1)));
            log.info("Preloading " + repository.save(new Currency("US Dollar", 1.2)));
        };
    }
}