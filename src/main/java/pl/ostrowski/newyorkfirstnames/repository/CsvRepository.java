package pl.ostrowski.newyorkfirstnames.repository;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import pl.ostrowski.newyorkfirstnames.model.BabyNames;
import pl.ostrowski.newyorkfirstnames.model.csv.BabyNamesCsv;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Profile("csv")
@Slf4j
public class CsvRepository implements BabyNamesRepository {
  @Override
  public List<BabyNames> findAll() {
    return readFile();
  }

  private List<BabyNames> readFile() {
    List<BabyNamesCsv> babyNamesList = new ArrayList<>();
    try {
      babyNamesList =
          new CsvToBeanBuilder(
                  new FileReader(new ClassPathResource("Popular_Baby_Names.csv").getFile()))
              .withType(BabyNamesCsv.class)
              .build()
              .parse();
    } catch (IOException e) {
      log.error("Error: ", e);
    }
    return babyNamesList.stream().map(this::parseBabyNames).collect(Collectors.toList());
  }

  private BabyNames parseBabyNames(BabyNamesCsv babyNamesCsv) {
    return BabyNames.builder()
        .yearOfBirth(babyNamesCsv.getYearOfBirth())
        .gender(BabyNames.Gender.valueOf(babyNamesCsv.getGender()))
        .ethnicity(BabyNames.Ethnicity.queryByValue(babyNamesCsv.getEthnicity()))
        .firstName(babyNamesCsv.getFirstName())
        .count(babyNamesCsv.getCount())
        .rank(babyNamesCsv.getRank())
        .build();
  }
}
