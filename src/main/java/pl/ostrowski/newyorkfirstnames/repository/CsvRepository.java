package pl.ostrowski.newyorkfirstnames.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import pl.ostrowski.newyorkfirstnames.model.BabyNames;

import java.util.List;

@Repository
@Profile("csv")
public class CsvRepository implements BabyNamesRepository {
  @Override
  public List<BabyNames> findAll() {
    return null;
  }
}
