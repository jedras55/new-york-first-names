package pl.ostrowski.newyorkfirstnames.model.xml;

import lombok.Data;

@Data
public class BabyNamesXml {
  private Integer yearOfBirth;
  private String gender;
  private String ethnicity;
  private String firstName;
  private Integer count;
  private Integer rank;
}
