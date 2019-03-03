package pl.ostrowski.newyorkfirstnames.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import pl.ostrowski.newyorkfirstnames.model.BabyNames;

import java.util.Arrays;
import java.util.List;

@Repository
@Profile("test")
public class InMemoryRepository implements BabyNamesRepository {
  @Override
  public List<BabyNames> findAll() {
    return Arrays.asList(
        BabyNames.builder()
            .firstName("Audrey")
            .gender(BabyNames.Gender.FEMALE)
            .count(100)
            .ethnicity(BabyNames.Ethnicity.HISPANIC)
            .build(),
        BabyNames.builder()
            .firstName("Audrey")
            .gender(BabyNames.Gender.FEMALE)
            .ethnicity(BabyNames.Ethnicity.ASIAN_AND_PACI)
            .count(200)
            .build(),
        BabyNames.builder().firstName("Daniel").gender(BabyNames.Gender.MALE).count(1000).build(),
        BabyNames.builder()
            .firstName("Thiago")
            .gender(BabyNames.Gender.MALE)
            .count(500)
            .ethnicity(BabyNames.Ethnicity.HISPANIC)
            .build(),
        BabyNames.builder()
            .firstName("Thiago")
            .gender(BabyNames.Gender.MALE)
            .count(900)
            .ethnicity(BabyNames.Ethnicity.ASIAN_AND_PACI)
            .build(),
        BabyNames.builder().firstName("Fatima").gender(BabyNames.Gender.FEMALE).count(47).build(),
        BabyNames.builder().firstName("Gitty").gender(BabyNames.Gender.FEMALE).count(42).build(),
        BabyNames.builder().firstName("Georgia").gender(BabyNames.Gender.FEMALE).count(35).build(),
        BabyNames.builder().firstName("Lucia").gender(BabyNames.Gender.FEMALE).count(31).build(),
        BabyNames.builder().firstName("Louisa").gender(BabyNames.Gender.FEMALE).count(29).build(),
        BabyNames.builder().firstName("Tamar").gender(BabyNames.Gender.FEMALE).count(24).build(),
        BabyNames.builder().firstName("Maggie").gender(BabyNames.Gender.FEMALE).count(20).build(),
        BabyNames.builder().firstName("Nicholas").gender(BabyNames.Gender.MALE).count(17).build(),
        BabyNames.builder().firstName("Carson").gender(BabyNames.Gender.MALE).count(11).build(),
        BabyNames.builder().firstName("Hashim").gender(BabyNames.Gender.MALE).count(6).build(),
        BabyNames.builder().firstName("Ashton").gender(BabyNames.Gender.MALE).count(4).build(),
        BabyNames.builder().firstName("Jacob").gender(BabyNames.Gender.MALE).count(2).build());
  }
}
