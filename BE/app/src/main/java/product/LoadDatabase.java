package warehouse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(ProductTypeRepository repository) {

    return args -> {
        ProductType pc = new ProductType("PC", 0L);
        ProductType mainboard = new ProductType("Mainboard", pc.getId());
        ProductType graficCard = new ProductType("Grafic card", pc.getId());
        ProductType cpu = new ProductType("CPU", mainboard.getId());
      log.info("Preloading " + repository.save(pc));
      log.info("Preloading " + repository.save(mainboard));
      log.info("Preloading " + repository.save(new ProductType("Casing", pc.getId())));
      log.info("Preloading " + repository.save(new ProductType("Grafic card", pc.getId())));
      log.info("Preloading " + repository.save(new ProductType("CPU", mainboard.getId())));
    };
  }
}