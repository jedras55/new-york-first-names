package pl.ostrowski.newyorkfirstnames.facade;

import lombok.AllArgsConstructor;
import pl.ostrowski.newyorkfirstnames.model.BabyNames;
import pl.ostrowski.newyorkfirstnames.repository.BabyNamesRepository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
public class BabyNamesFacade {

  private final BabyNamesRepository babyNamesRepository;

  public List<String> queryTenMostPopularFirstNames() {
    return sortFirstNamesByCount(groupBabyNamesByFirstName(babyNamesRepository.findAll()), 10);
  }

  public String queryMostPopularFemaleName() {
    return sortFirstNamesByCount(
            groupBabyNamesByFirstName(
                filterBabyNamesByGender(babyNamesRepository.findAll(), BabyNames.Gender.FEMALE)),
            1)
        .stream()
        .findFirst()
        .orElse(null);
  }

  public Map<Character, Integer> queryThreeMostPopularFirstCharactersWithCount() {
    return sortFirstCharactersByCount(
        groupBabyNamesByFirstCharacter(babyNamesRepository.findAll()), 3);
  }

  private Map<String, Integer> groupBabyNamesByFirstName(List<BabyNames> babyNamesList) {
    return babyNamesList.stream()
        .collect(
            Collectors.groupingBy(
                BabyNames::getFirstName, Collectors.summingInt(BabyNames::getCount)));
  }

  private List<String> sortFirstNamesByCount(
      Map<String, Integer> babyNamesGroupedByFirstName, Integer size) {
    return babyNamesGroupedByFirstName.entrySet().stream()
        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
        .limit(size)
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
  }

  private List<BabyNames> filterBabyNamesByGender(
      List<BabyNames> babyNamesList, BabyNames.Gender gender) {
    return babyNamesList.stream()
        .filter(babyNames -> gender.equals(babyNames.getGender()))
        .collect(Collectors.toList());
  }

  private Map<Character, Integer> groupBabyNamesByFirstCharacter(List<BabyNames> babyNamesList) {
    return babyNamesList.stream()
        .collect(
            Collectors.groupingBy(
                babyNames -> babyNames.getFirstName().charAt(0),
                Collectors.summingInt(BabyNames::getCount)));
  }

  private Map<Character, Integer> sortFirstCharactersByCount(
      Map<Character, Integer> babyNamesGroupedByFirstName, Integer size) {
    return babyNamesGroupedByFirstName.entrySet().stream()
        .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
        .limit(size)
        .collect(
            Collectors.toMap(
                Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
  }
}
