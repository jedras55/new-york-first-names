package pl.ostrowski.newyorkfirstnames.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.ostrowski.newyorkfirstnames.facade.BabyNamesFacade;
import pl.ostrowski.newyorkfirstnames.repository.BabyNamesRepository;

@Configuration
@ComponentScan(
    basePackages = {"pl.ostrowski.newyorkfirstnames.repository"},
    basePackageClasses = {BabyNamesConfiguration.class})
public class BabyNamesConfiguration {
  @Bean
  BabyNamesFacade babyNamesFacade(BabyNamesRepository babyNamesRepository) {
    return new BabyNamesFacade(babyNamesRepository);
  }
}
