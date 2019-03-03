package pl.ostrowski.newyorkfirstnames.model.xml;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "response")
@EqualsAndHashCode
public class BabyNamesXmlRoot {
  @XmlElement(name = "row")
  private BabyNamesXmlWrapper babyNamesXmlWrapper;
}
