package pl.ostrowski.newyorkfirstnames.model.xml;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@EqualsAndHashCode
public class BabyNamesXml {
  @XmlElement(name = "brth_yr")
  private Integer yearOfBirth;

  @XmlElement(name = "gndr")
  private String gender;

  @XmlElement(name = "ethcty")
  private String ethnicity;

  @XmlElement(name = "nm")
  private String firstName;

  @XmlElement(name = "cnt")
  private Integer count;

  @XmlElement(name = "rnk")
  private Integer rank;
}
