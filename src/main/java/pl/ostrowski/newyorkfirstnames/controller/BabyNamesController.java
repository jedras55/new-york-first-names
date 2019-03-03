package pl.ostrowski.newyorkfirstnames.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.ostrowski.newyorkfirstnames.facade.BabyNamesFacade;
import pl.ostrowski.newyorkfirstnames.repository.BabyNamesRepository;

import java.util.List;
import java.util.Map;

@RestController
public class BabyNamesController {

  private final BabyNamesFacade babyNamesFacade;

  @Autowired
  public BabyNamesController(BabyNamesRepository babyNamesRepository) {
    this.babyNamesFacade = new BabyNamesFacade(babyNamesRepository);
  }

  @GetMapping("queryTenMostPopularFirstNames")
  List<String> queryTenMostPopularFirstNames() {
    return babyNamesFacade.queryTenMostPopularFirstNames();
  }

  @GetMapping("queryMostPopularFemaleName")
  String queryMostPopularFemaleName() {
    return babyNamesFacade.queryMostPopularFemaleName();
  }

  @GetMapping("queryThreeMostPopularFirstCharactersWithCount")
  Map<Character, Integer> queryThreeMostPopularFirstCharactersWithCount() {
    return babyNamesFacade.queryThreeMostPopularFirstCharactersWithCount();
  }
}
