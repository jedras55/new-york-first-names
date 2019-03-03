package pl.ostrowski.newyorkfirstnames.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import pl.ostrowski.newyorkfirstnames.model.BabyNames;
import pl.ostrowski.newyorkfirstnames.model.xml.BabyNamesXml;
import pl.ostrowski.newyorkfirstnames.model.xml.BabyNamesXmlRoot;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    BabyNamesXmlRoot babyNamesXmlRoot = null;
    try {
      File xmlFile = new ClassPathResource("Popular_Baby_Names.xml").getFile();
      JAXBContext jaxbContext = JAXBContext.newInstance(BabyNamesXmlRoot.class);
      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
      babyNamesXmlRoot = (BabyNamesXmlRoot) jaxbUnmarshaller.unmarshal(xmlFile);
    } catch (IOException | JAXBException e) {
      log.error("Error: ", e);
    }
    return Optional.ofNullable(babyNamesXmlRoot)
        .map(
            root ->
                root.getBabyNamesXmlWrapper().getBabyNamesXmlList().stream()
                    .map(this::parseBabyNames)
                    .collect(Collectors.toList()))
        .orElse(new ArrayList<>());
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
