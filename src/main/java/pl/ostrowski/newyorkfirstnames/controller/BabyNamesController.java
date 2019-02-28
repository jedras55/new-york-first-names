package pl.ostrowski.newyorkfirstnames.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.ostrowski.newyorkfirstnames.facade.BabyNamesFacade;

import java.util.List;
import java.util.Map;

@RestController
public class BabyNamesController {

  private final BabyNamesFacade babyNamesFacade;

  @Autowired
  public BabyNamesController(BabyNamesFacade babyNamesFacade) {
    this.babyNamesFacade = babyNamesFacade;
  }

  @GetMapping("elo1")
  List<String> queryTenMostPopularFirstNames() {
    return babyNamesFacade.queryTenMostPopularFirstNames();
  }

  @GetMapping("elo2")
  String queryMostPopularFemaleName() {
    return babyNamesFacade.queryMostPopularFemaleName();
  }

  @GetMapping("elo3")
  Map<String, Integer> queryThreeMostPopularFirstCharactersWithCount() {
    return babyNamesFacade.queryThreeMostPopularFirstCharactersWithCount();
  }
}
