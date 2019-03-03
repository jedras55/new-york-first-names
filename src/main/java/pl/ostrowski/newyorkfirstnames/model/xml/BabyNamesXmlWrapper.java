package pl.ostrowski.newyorkfirstnames.model.xml;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@EqualsAndHashCode
public class BabyNamesXmlWrapper {
  @XmlElement(name = "row")
  private List<BabyNamesXml> babyNamesXmlList;
}
