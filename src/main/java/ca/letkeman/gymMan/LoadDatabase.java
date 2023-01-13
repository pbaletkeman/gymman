package ca.letkeman.gymMan;

import ca.letkeman.gymMan.model.Exercise;
import ca.letkeman.gymMan.model.User;
import ca.letkeman.gymMan.repository.ExerciseRepository;
import ca.letkeman.gymMan.repository.UserRepository;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  @Order(value = 1)
  CommandLineRunner initUserTable(UserRepository repository) {
    User user1 = new User(1L, null, true, false, LocalDateTime.now(), "pete@letkeman.ca", "pete",
        "pete", "letkeman");

    return args -> {
      log.info("Preloading " + repository.save(user1));
      log.info("Preloading " + repository.save(
          new User(2L, user1, true, false, LocalDateTime.now(), "alex@letkeman.ca", "alex", "alex",
              "bishop")));
    };
  }

  @Bean
  @Order(value = 2)
  CommandLineRunner initExerciseTable(ExerciseRepository repository) {
    User user1 = new User(1L, null, true, false, LocalDateTime.now(), "pete@letkeman.ca", "pete",
        "pete", "letkeman");

    Exercise exercise1 = new Exercise(1L, user1, LocalDateTime.now(),true,false,"name1");
    Exercise exercise2 = new Exercise(2L, user1, LocalDateTime.now(),true,false,"name1");
    return args -> {
      log.info("Preloading " + repository.save(exercise1));
      log.info("Preloading " + repository.save(exercise2));
    };
  }
}
