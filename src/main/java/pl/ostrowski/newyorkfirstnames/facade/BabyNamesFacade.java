package pl.ostrowski.newyorkfirstnames.facade;

import org.springframework.stereotype.Service;
import pl.ostrowski.newyorkfirstnames.repository.BabyNamesRepository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BabyNamesFacade {

  private final BabyNamesRepository babyNamesRepository;

  public BabyNamesFacade(BabyNamesRepository babyNamesRepository) {
    this.babyNamesRepository = babyNamesRepository;
  }

  public List<String> queryTenMostPopularFirstNames() {
    return Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
  }

  public String queryMostPopularFemaleName() {
    return "Anna";
  }

  public Map<String, Integer> queryThreeMostPopularFirstCharactersWithCount() {
    return new HashMap<>();
  }
}
