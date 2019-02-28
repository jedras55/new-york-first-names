package pl.ostrowski.newyorkfirstnames.repository;

import org.springframework.stereotype.Repository;
import pl.ostrowski.newyorkfirstnames.model.BabyNames;

import java.util.List;

@Repository
public interface BabyNamesRepository {
  List<BabyNames> findAll();
}
