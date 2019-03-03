package pl.ostrowski.newyorkfirstnames.repository;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import pl.ostrowski.newyorkfirstnames.model.BabyNames;
import pl.ostrowski.newyorkfirstnames.model.xml.BabyNamesXml;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Profile("xml")
@Slf4j
public class XmlRepository implements BabyNamesRepository {
  @Override
  public List<BabyNames> findAll() {
    return readFile();
  }

  private List<BabyNames> readFile() {
    List<BabyNamesXml> babyNamesList = new ArrayList<>();
    try {
      babyNamesList =
          new CsvToBeanBuilder(
                  new FileReader(new ClassPathResource("Popular_Baby_Names.xml").getFile()))
              .withType(BabyNamesXml.class)
              .build()
              .parse();
    } catch (IOException e) {
      log.error("Error: ", e);
    }
    return babyNamesList.stream().map(this::parseBabyNames).collect(Collectors.toList());
  }

  private BabyNames parseBabyNames(BabyNamesXml babyNamesXml) {
    return BabyNames.builder()
        .yearOfBirth(babyNamesXml.getYearOfBirth())
        .gender(BabyNames.Gender.valueOf(babyNamesXml.getGender()))
        .ethnicity(BabyNames.Ethnicity.queryByValue(babyNamesXml.getEthnicity()))
        .firstName(babyNamesXml.getFirstName())
        .count(babyNamesXml.getCount())
        .rank(babyNamesXml.getRank())
        .build();
  }
}
