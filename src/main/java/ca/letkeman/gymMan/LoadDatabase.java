package ca.letkeman.gymMan;

import ca.letkeman.gymMan.model.Person;
import ca.letkeman.gymMan.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(PersonRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Person(1L,"pete","letkeman")));
      log.info("Preloading " + repository.save(new Person(2L,"alex","bishop")));
    };
  }
}
