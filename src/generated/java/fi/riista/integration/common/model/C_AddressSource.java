//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.25 at 05:49:37 PM EET 
//


package fi.riista.integration.common.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OsoiteLahde.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OsoiteLahde"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="VTJ"/&gt;
 *     &lt;enumeration value="LupaHallinta"/&gt;
 *     &lt;enumeration value="Manual"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "OsoiteLahde")
@XmlEnum
public enum C_AddressSource {

    VTJ("VTJ"),
    @XmlEnumValue("LupaHallinta")
    LUPA_HALLINTA("LupaHallinta"),
    @XmlEnumValue("Manual")
    MANUAL("Manual");
    private final String value;

    C_AddressSource(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static C_AddressSource fromValue(String v) {
        for (C_AddressSource c: C_AddressSource.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}