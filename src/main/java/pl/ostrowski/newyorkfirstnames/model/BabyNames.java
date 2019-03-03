package pl.ostrowski.newyorkfirstnames.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Data
@Builder
@EqualsAndHashCode
public class BabyNames {
  private Integer yearOfBirth;
  private Gender gender;
  private Ethnicity ethnicity;
  private String firstName;
  private Integer count;
  private Integer rank;

  public enum Gender {
    MALE,
    FEMALE
  }

  @AllArgsConstructor
  public enum Ethnicity {
    ASIAN_AND_PACIFIC_ISLANDER("ASIAN AND PACIFIC ISLANDER"),
    BLACK_NON_HISPANIC("BLACK NON HISPANIC"),
    HISPANIC("HISPANIC"),
    WHITE_NON_HISPANIC("WHITE NON HISPANIC"),
    ASIAN_AND_PACI("ASIAN AND PACI"),
    BLACK_NON_HISP("BLACK NON HISP"),
    WHITE_NON_HISP("WHITE NON HISP");

    @Getter private String ethnicityName;

    public static Ethnicity queryByValue(String ethnicityName) {

      for (Ethnicity ethnicity : values()) {
        if (ethnicity.getEthnicityName().equals(ethnicityName)) return ethnicity;
      }
      throw new IllegalArgumentException(ethnicityName);
    }
  }
}
