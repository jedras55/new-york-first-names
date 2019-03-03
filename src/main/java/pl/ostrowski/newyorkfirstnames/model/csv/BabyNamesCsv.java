package pl.ostrowski.newyorkfirstnames.model.csv;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class BabyNamesCsv {
  @CsvBindByName(column = "Year of Birth")
  private Integer yearOfBirth;

  @CsvBindByName(column = "Gender")
  private String gender;

  @CsvBindByName(column = "Ethnicity")
  private String ethnicity;

  @CsvBindByName(column = "Child's First Name")
  private String firstName;

  @CsvBindByName(column = "Count")
  private Integer count;

  @CsvBindByName(column = "Rank")
  private Integer rank;
}
