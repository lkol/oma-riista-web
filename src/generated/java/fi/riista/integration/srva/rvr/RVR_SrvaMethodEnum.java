//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.03.24 at 03:00:27 PM EET 
//


package fi.riista.integration.srva.rvr;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for srvaMethodEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="srvaMethodEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="DOG"/&gt;
 *     &lt;enumeration value="PAIN_EQUIPMENT"/&gt;
 *     &lt;enumeration value="SOUND_EQUIPMENT"/&gt;
 *     &lt;enumeration value="TRACED_WITH_DOG"/&gt;
 *     &lt;enumeration value="TRACED_WITHOUT_DOG"/&gt;
 *     &lt;enumeration value="OTHER"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "srvaMethodEnum", namespace = "http://riista.fi/integration/srva/rvr")
@XmlEnum
public enum RVR_SrvaMethodEnum {

    DOG,
    PAIN_EQUIPMENT,
    SOUND_EQUIPMENT,
    TRACED_WITH_DOG,
    TRACED_WITHOUT_DOG,
    OTHER;

    public String value() {
        return name();
    }

    public static RVR_SrvaMethodEnum fromValue(String v) {
        return valueOf(v);
    }

}
