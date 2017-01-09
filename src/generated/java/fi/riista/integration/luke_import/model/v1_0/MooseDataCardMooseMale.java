//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.05.13 at 11:52:15 AM EEST 
//


package fi.riista.integration.luke_import.model.v1_0;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;
import com.kscs.util.jaxb.Copyable;
import com.kscs.util.jaxb.PartialCopyable;
import com.kscs.util.jaxb.PropertyTree;
import com.kscs.util.jaxb.PropertyTreeUse;
import fi.riista.feature.huntingclub.moosedatacard.MooseDataCardHarvest;
import fi.riista.integration.support.LocalDateAdapter;
import org.joda.time.LocalDate;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for _UroksetType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="_UroksetType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;group ref="{http://www.abbyy.com/FlexiCapture/Schemas/Export/Hirvitietokortti.xsd}MooseHarvestBasicInfoType"/&gt;
 *         &lt;element name="_Vasen" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="_Oikea" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="_Sarvityyppi" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="_Sarvien_kärkiväli" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;group ref="{http://www.abbyy.com/FlexiCapture/Schemas/Export/Hirvitietokortti.xsd}MooseHarvestConditionType"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;anyAttribute namespace='http://www.abbyy.com/FlexiCapture/Schemas/Export/AdditionalFormData.xsd'/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "_UroksetType", namespace = "http://www.abbyy.com/FlexiCapture/Schemas/Export/Hirvitietokortti.xsd", propOrder = {
    "date",
    "latitude",
    "longitude",
    "weightMeasured",
    "weightEstimated",
    "antlerPointsLeft",
    "antlerPointsRight",
    "antlersType",
    "antlersWidth",
    "fitnessClass",
    "additionalInfo",
    "notEdible"
})
public class MooseDataCardMooseMale implements Cloneable, Copyable, PartialCopyable, MooseDataCardHarvest, ToString2
{

    @XmlElement(name = "_P\u00e4iv\u00e4m\u00e4\u00e4r\u00e4", required = true, type = String.class, nillable = true)
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlSchemaType(name = "date")
    protected LocalDate date;
    @XmlElement(name = "_Koordinaatit_P", required = true)
    protected String latitude;
    @XmlElement(name = "_Koordinaatit_I", required = true)
    protected String longitude;
    @XmlElement(name = "_Punnittu", required = true, type = Double.class, nillable = true)
    protected Double weightMeasured;
    @XmlElement(name = "_Arvioitu", required = true, type = Double.class, nillable = true)
    protected Double weightEstimated;
    @XmlElement(name = "_Vasen", required = true, type = Integer.class, nillable = true)
    protected Integer antlerPointsLeft;
    @XmlElement(name = "_Oikea", required = true, type = Integer.class, nillable = true)
    protected Integer antlerPointsRight;
    @XmlElement(name = "_Sarvityyppi", required = true)
    protected String antlersType;
    @XmlElement(name = "_Sarvien_k\u00e4rkiv\u00e4li", required = true, type = Integer.class, nillable = true)
    protected Integer antlersWidth;
    @XmlElement(name = "_Kuntoluokka", required = true)
    protected String fitnessClass;
    @XmlElement(name = "_Lis\u00e4tietoja", required = true)
    protected String additionalInfo;
    @XmlElement(name = "_Ihmisravinnoksi_kelpaamaton")
    protected boolean notEdible;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
     * 
     */
    public MooseDataCardMooseMale() {
        // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
    }

    /**
     * Instantiates a MooseDataCardMooseMale copying the state of another MooseDataCardMooseMale
     * 
     * @param _other
     *     The original MooseDataCardMooseMale from which to copy state.
     */
    public MooseDataCardMooseMale(final MooseDataCardMooseMale _other) {
        this.date = _other.date;
        this.latitude = _other.latitude;
        this.longitude = _other.longitude;
        this.weightMeasured = _other.weightMeasured;
        this.weightEstimated = _other.weightEstimated;
        this.antlerPointsLeft = _other.antlerPointsLeft;
        this.antlerPointsRight = _other.antlerPointsRight;
        this.antlersType = _other.antlersType;
        this.antlersWidth = _other.antlersWidth;
        this.fitnessClass = _other.fitnessClass;
        this.additionalInfo = _other.additionalInfo;
        this.notEdible = _other.notEdible;
    }

    /**
     * Instantiates a MooseDataCardMooseMale copying the state of another MooseDataCardMooseMale
     * 
     * @param _propertyTreeUse
     *     Meaning of the {@link PropertyPath}: Exclude or include members contained in property path.
     * @param _propertyTree
     *     A restricting {@link PropertyPath} that defines which nodes of the source object tree should actually be copied.
     * @param _other
     *     The original MooseDataCardMooseMale from which to copy state.
     */
    public MooseDataCardMooseMale(final MooseDataCardMooseMale _other, final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        final PropertyTree datePropertyTree = ((_propertyTree == null)?null:_propertyTree.get("date"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(datePropertyTree!= null):((datePropertyTree == null)||(!datePropertyTree.isLeaf())))) {
            this.date = _other.date;
        }
        final PropertyTree latitudePropertyTree = ((_propertyTree == null)?null:_propertyTree.get("latitude"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(latitudePropertyTree!= null):((latitudePropertyTree == null)||(!latitudePropertyTree.isLeaf())))) {
            this.latitude = _other.latitude;
        }
        final PropertyTree longitudePropertyTree = ((_propertyTree == null)?null:_propertyTree.get("longitude"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(longitudePropertyTree!= null):((longitudePropertyTree == null)||(!longitudePropertyTree.isLeaf())))) {
            this.longitude = _other.longitude;
        }
        final PropertyTree weightMeasuredPropertyTree = ((_propertyTree == null)?null:_propertyTree.get("weightMeasured"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(weightMeasuredPropertyTree!= null):((weightMeasuredPropertyTree == null)||(!weightMeasuredPropertyTree.isLeaf())))) {
            this.weightMeasured = _other.weightMeasured;
        }
        final PropertyTree weightEstimatedPropertyTree = ((_propertyTree == null)?null:_propertyTree.get("weightEstimated"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(weightEstimatedPropertyTree!= null):((weightEstimatedPropertyTree == null)||(!weightEstimatedPropertyTree.isLeaf())))) {
            this.weightEstimated = _other.weightEstimated;
        }
        final PropertyTree antlerPointsLeftPropertyTree = ((_propertyTree == null)?null:_propertyTree.get("antlerPointsLeft"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(antlerPointsLeftPropertyTree!= null):((antlerPointsLeftPropertyTree == null)||(!antlerPointsLeftPropertyTree.isLeaf())))) {
            this.antlerPointsLeft = _other.antlerPointsLeft;
        }
        final PropertyTree antlerPointsRightPropertyTree = ((_propertyTree == null)?null:_propertyTree.get("antlerPointsRight"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(antlerPointsRightPropertyTree!= null):((antlerPointsRightPropertyTree == null)||(!antlerPointsRightPropertyTree.isLeaf())))) {
            this.antlerPointsRight = _other.antlerPointsRight;
        }
        final PropertyTree antlersTypePropertyTree = ((_propertyTree == null)?null:_propertyTree.get("antlersType"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(antlersTypePropertyTree!= null):((antlersTypePropertyTree == null)||(!antlersTypePropertyTree.isLeaf())))) {
            this.antlersType = _other.antlersType;
        }
        final PropertyTree antlersWidthPropertyTree = ((_propertyTree == null)?null:_propertyTree.get("antlersWidth"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(antlersWidthPropertyTree!= null):((antlersWidthPropertyTree == null)||(!antlersWidthPropertyTree.isLeaf())))) {
            this.antlersWidth = _other.antlersWidth;
        }
        final PropertyTree fitnessClassPropertyTree = ((_propertyTree == null)?null:_propertyTree.get("fitnessClass"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(fitnessClassPropertyTree!= null):((fitnessClassPropertyTree == null)||(!fitnessClassPropertyTree.isLeaf())))) {
            this.fitnessClass = _other.fitnessClass;
        }
        final PropertyTree additionalInfoPropertyTree = ((_propertyTree == null)?null:_propertyTree.get("additionalInfo"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(additionalInfoPropertyTree!= null):((additionalInfoPropertyTree == null)||(!additionalInfoPropertyTree.isLeaf())))) {
            this.additionalInfo = _other.additionalInfo;
        }
        final PropertyTree notEdiblePropertyTree = ((_propertyTree == null)?null:_propertyTree.get("notEdible"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(notEdiblePropertyTree!= null):((notEdiblePropertyTree == null)||(!notEdiblePropertyTree.isLeaf())))) {
            this.notEdible = _other.notEdible;
        }
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDate(LocalDate value) {
        this.date = value;
    }

    /**
     * Gets the value of the latitude property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * Sets the value of the latitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLatitude(String value) {
        this.latitude = value;
    }

    /**
     * Gets the value of the longitude property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * Sets the value of the longitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLongitude(String value) {
        this.longitude = value;
    }

    /**
     * Gets the value of the weightMeasured property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getWeightMeasured() {
        return weightMeasured;
    }

    /**
     * Sets the value of the weightMeasured property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setWeightMeasured(Double value) {
        this.weightMeasured = value;
    }

    /**
     * Gets the value of the weightEstimated property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getWeightEstimated() {
        return weightEstimated;
    }

    /**
     * Sets the value of the weightEstimated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setWeightEstimated(Double value) {
        this.weightEstimated = value;
    }

    /**
     * Gets the value of the antlerPointsLeft property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAntlerPointsLeft() {
        return antlerPointsLeft;
    }

    /**
     * Sets the value of the antlerPointsLeft property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAntlerPointsLeft(Integer value) {
        this.antlerPointsLeft = value;
    }

    /**
     * Gets the value of the antlerPointsRight property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAntlerPointsRight() {
        return antlerPointsRight;
    }

    /**
     * Sets the value of the antlerPointsRight property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAntlerPointsRight(Integer value) {
        this.antlerPointsRight = value;
    }

    /**
     * Gets the value of the antlersType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAntlersType() {
        return antlersType;
    }

    /**
     * Sets the value of the antlersType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAntlersType(String value) {
        this.antlersType = value;
    }

    /**
     * Gets the value of the antlersWidth property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAntlersWidth() {
        return antlersWidth;
    }

    /**
     * Sets the value of the antlersWidth property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAntlersWidth(Integer value) {
        this.antlersWidth = value;
    }

    /**
     * Gets the value of the fitnessClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFitnessClass() {
        return fitnessClass;
    }

    /**
     * Sets the value of the fitnessClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFitnessClass(String value) {
        this.fitnessClass = value;
    }

    /**
     * Gets the value of the additionalInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * Sets the value of the additionalInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalInfo(String value) {
        this.additionalInfo = value;
    }

    /**
     * Gets the value of the notEdible property.
     * 
     */
    public boolean isNotEdible() {
        return notEdible;
    }

    /**
     * Sets the value of the notEdible property.
     * 
     */
    public void setNotEdible(boolean value) {
        this.notEdible = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

    public String toString() {
        final ToStringStrategy2 strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
        {
            LocalDate theDate;
            theDate = this.getDate();
            strategy.appendField(locator, this, "date", buffer, theDate, (this.date!= null));
        }
        {
            String theLatitude;
            theLatitude = this.getLatitude();
            strategy.appendField(locator, this, "latitude", buffer, theLatitude, (this.latitude!= null));
        }
        {
            String theLongitude;
            theLongitude = this.getLongitude();
            strategy.appendField(locator, this, "longitude", buffer, theLongitude, (this.longitude!= null));
        }
        {
            Double theWeightMeasured;
            theWeightMeasured = this.getWeightMeasured();
            strategy.appendField(locator, this, "weightMeasured", buffer, theWeightMeasured, (this.weightMeasured!= null));
        }
        {
            Double theWeightEstimated;
            theWeightEstimated = this.getWeightEstimated();
            strategy.appendField(locator, this, "weightEstimated", buffer, theWeightEstimated, (this.weightEstimated!= null));
        }
        {
            Integer theAntlerPointsLeft;
            theAntlerPointsLeft = this.getAntlerPointsLeft();
            strategy.appendField(locator, this, "antlerPointsLeft", buffer, theAntlerPointsLeft, (this.antlerPointsLeft!= null));
        }
        {
            Integer theAntlerPointsRight;
            theAntlerPointsRight = this.getAntlerPointsRight();
            strategy.appendField(locator, this, "antlerPointsRight", buffer, theAntlerPointsRight, (this.antlerPointsRight!= null));
        }
        {
            String theAntlersType;
            theAntlersType = this.getAntlersType();
            strategy.appendField(locator, this, "antlersType", buffer, theAntlersType, (this.antlersType!= null));
        }
        {
            Integer theAntlersWidth;
            theAntlersWidth = this.getAntlersWidth();
            strategy.appendField(locator, this, "antlersWidth", buffer, theAntlersWidth, (this.antlersWidth!= null));
        }
        {
            String theFitnessClass;
            theFitnessClass = this.getFitnessClass();
            strategy.appendField(locator, this, "fitnessClass", buffer, theFitnessClass, (this.fitnessClass!= null));
        }
        {
            String theAdditionalInfo;
            theAdditionalInfo = this.getAdditionalInfo();
            strategy.appendField(locator, this, "additionalInfo", buffer, theAdditionalInfo, (this.additionalInfo!= null));
        }
        {
            boolean theNotEdible;
            theNotEdible = this.isNotEdible();
            strategy.appendField(locator, this, "notEdible", buffer, theNotEdible, true);
        }
        return buffer;
    }

    public MooseDataCardMooseMale withDate(LocalDate value) {
        setDate(value);
        return this;
    }

    public MooseDataCardMooseMale withLatitude(String value) {
        setLatitude(value);
        return this;
    }

    public MooseDataCardMooseMale withLongitude(String value) {
        setLongitude(value);
        return this;
    }

    public MooseDataCardMooseMale withWeightMeasured(Double value) {
        setWeightMeasured(value);
        return this;
    }

    public MooseDataCardMooseMale withWeightEstimated(Double value) {
        setWeightEstimated(value);
        return this;
    }

    public MooseDataCardMooseMale withAntlerPointsLeft(Integer value) {
        setAntlerPointsLeft(value);
        return this;
    }

    public MooseDataCardMooseMale withAntlerPointsRight(Integer value) {
        setAntlerPointsRight(value);
        return this;
    }

    public MooseDataCardMooseMale withAntlersType(String value) {
        setAntlersType(value);
        return this;
    }

    public MooseDataCardMooseMale withAntlersWidth(Integer value) {
        setAntlersWidth(value);
        return this;
    }

    public MooseDataCardMooseMale withFitnessClass(String value) {
        setFitnessClass(value);
        return this;
    }

    public MooseDataCardMooseMale withAdditionalInfo(String value) {
        setAdditionalInfo(value);
        return this;
    }

    public MooseDataCardMooseMale withNotEdible(boolean value) {
        setNotEdible(value);
        return this;
    }

    @Override
    public MooseDataCardMooseMale clone() {
        final MooseDataCardMooseMale _newObject;
        try {
            _newObject = ((MooseDataCardMooseMale) super.clone());
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return _newObject;
    }

    @Override
    public MooseDataCardMooseMale createCopy() {
        final MooseDataCardMooseMale _newObject;
        try {
            _newObject = ((MooseDataCardMooseMale) super.clone());
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        _newObject.date = this.date;
        _newObject.latitude = this.latitude;
        _newObject.longitude = this.longitude;
        _newObject.weightMeasured = this.weightMeasured;
        _newObject.weightEstimated = this.weightEstimated;
        _newObject.antlerPointsLeft = this.antlerPointsLeft;
        _newObject.antlerPointsRight = this.antlerPointsRight;
        _newObject.antlersType = this.antlersType;
        _newObject.antlersWidth = this.antlersWidth;
        _newObject.fitnessClass = this.fitnessClass;
        _newObject.additionalInfo = this.additionalInfo;
        _newObject.notEdible = this.notEdible;
        return _newObject;
    }

    @Override
    public MooseDataCardMooseMale createCopy(final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        final MooseDataCardMooseMale _newObject;
        try {
            _newObject = ((MooseDataCardMooseMale) super.clone());
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        final PropertyTree datePropertyTree = ((_propertyTree == null)?null:_propertyTree.get("date"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(datePropertyTree!= null):((datePropertyTree == null)||(!datePropertyTree.isLeaf())))) {
            _newObject.date = this.date;
        }
        final PropertyTree latitudePropertyTree = ((_propertyTree == null)?null:_propertyTree.get("latitude"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(latitudePropertyTree!= null):((latitudePropertyTree == null)||(!latitudePropertyTree.isLeaf())))) {
            _newObject.latitude = this.latitude;
        }
        final PropertyTree longitudePropertyTree = ((_propertyTree == null)?null:_propertyTree.get("longitude"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(longitudePropertyTree!= null):((longitudePropertyTree == null)||(!longitudePropertyTree.isLeaf())))) {
            _newObject.longitude = this.longitude;
        }
        final PropertyTree weightMeasuredPropertyTree = ((_propertyTree == null)?null:_propertyTree.get("weightMeasured"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(weightMeasuredPropertyTree!= null):((weightMeasuredPropertyTree == null)||(!weightMeasuredPropertyTree.isLeaf())))) {
            _newObject.weightMeasured = this.weightMeasured;
        }
        final PropertyTree weightEstimatedPropertyTree = ((_propertyTree == null)?null:_propertyTree.get("weightEstimated"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(weightEstimatedPropertyTree!= null):((weightEstimatedPropertyTree == null)||(!weightEstimatedPropertyTree.isLeaf())))) {
            _newObject.weightEstimated = this.weightEstimated;
        }
        final PropertyTree antlerPointsLeftPropertyTree = ((_propertyTree == null)?null:_propertyTree.get("antlerPointsLeft"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(antlerPointsLeftPropertyTree!= null):((antlerPointsLeftPropertyTree == null)||(!antlerPointsLeftPropertyTree.isLeaf())))) {
            _newObject.antlerPointsLeft = this.antlerPointsLeft;
        }
        final PropertyTree antlerPointsRightPropertyTree = ((_propertyTree == null)?null:_propertyTree.get("antlerPointsRight"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(antlerPointsRightPropertyTree!= null):((antlerPointsRightPropertyTree == null)||(!antlerPointsRightPropertyTree.isLeaf())))) {
            _newObject.antlerPointsRight = this.antlerPointsRight;
        }
        final PropertyTree antlersTypePropertyTree = ((_propertyTree == null)?null:_propertyTree.get("antlersType"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(antlersTypePropertyTree!= null):((antlersTypePropertyTree == null)||(!antlersTypePropertyTree.isLeaf())))) {
            _newObject.antlersType = this.antlersType;
        }
        final PropertyTree antlersWidthPropertyTree = ((_propertyTree == null)?null:_propertyTree.get("antlersWidth"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(antlersWidthPropertyTree!= null):((antlersWidthPropertyTree == null)||(!antlersWidthPropertyTree.isLeaf())))) {
            _newObject.antlersWidth = this.antlersWidth;
        }
        final PropertyTree fitnessClassPropertyTree = ((_propertyTree == null)?null:_propertyTree.get("fitnessClass"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(fitnessClassPropertyTree!= null):((fitnessClassPropertyTree == null)||(!fitnessClassPropertyTree.isLeaf())))) {
            _newObject.fitnessClass = this.fitnessClass;
        }
        final PropertyTree additionalInfoPropertyTree = ((_propertyTree == null)?null:_propertyTree.get("additionalInfo"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(additionalInfoPropertyTree!= null):((additionalInfoPropertyTree == null)||(!additionalInfoPropertyTree.isLeaf())))) {
            _newObject.additionalInfo = this.additionalInfo;
        }
        final PropertyTree notEdiblePropertyTree = ((_propertyTree == null)?null:_propertyTree.get("notEdible"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(notEdiblePropertyTree!= null):((notEdiblePropertyTree == null)||(!notEdiblePropertyTree.isLeaf())))) {
            _newObject.notEdible = this.notEdible;
        }
        return _newObject;
    }

    @Override
    public MooseDataCardMooseMale copyExcept(final PropertyTree _propertyTree) {
        return createCopy(_propertyTree, PropertyTreeUse.EXCLUDE);
    }

    @Override
    public MooseDataCardMooseMale copyOnly(final PropertyTree _propertyTree) {
        return createCopy(_propertyTree, PropertyTreeUse.INCLUDE);
    }

    public static class Select
        extends MooseDataCardMooseMale.Selector<MooseDataCardMooseMale.Select, Void>
    {


        Select() {
            super(null, null, null);
        }

        public static MooseDataCardMooseMale.Select _root() {
            return new MooseDataCardMooseMale.Select();
        }

    }

    public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?> , TParent >
        extends com.kscs.util.jaxb.Selector<TRoot, TParent>
    {

        private com.kscs.util.jaxb.Selector<TRoot, MooseDataCardMooseMale.Selector<TRoot, TParent>> date = null;
        private com.kscs.util.jaxb.Selector<TRoot, MooseDataCardMooseMale.Selector<TRoot, TParent>> latitude = null;
        private com.kscs.util.jaxb.Selector<TRoot, MooseDataCardMooseMale.Selector<TRoot, TParent>> longitude = null;
        private com.kscs.util.jaxb.Selector<TRoot, MooseDataCardMooseMale.Selector<TRoot, TParent>> weightMeasured = null;
        private com.kscs.util.jaxb.Selector<TRoot, MooseDataCardMooseMale.Selector<TRoot, TParent>> weightEstimated = null;
        private com.kscs.util.jaxb.Selector<TRoot, MooseDataCardMooseMale.Selector<TRoot, TParent>> antlerPointsLeft = null;
        private com.kscs.util.jaxb.Selector<TRoot, MooseDataCardMooseMale.Selector<TRoot, TParent>> antlerPointsRight = null;
        private com.kscs.util.jaxb.Selector<TRoot, MooseDataCardMooseMale.Selector<TRoot, TParent>> antlersType = null;
        private com.kscs.util.jaxb.Selector<TRoot, MooseDataCardMooseMale.Selector<TRoot, TParent>> antlersWidth = null;
        private com.kscs.util.jaxb.Selector<TRoot, MooseDataCardMooseMale.Selector<TRoot, TParent>> fitnessClass = null;
        private com.kscs.util.jaxb.Selector<TRoot, MooseDataCardMooseMale.Selector<TRoot, TParent>> additionalInfo = null;

        public Selector(final TRoot root, final TParent parent, final String propertyName) {
            super(root, parent, propertyName);
        }

        @Override
        public Map<String, PropertyTree> buildChildren() {
            final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
            products.putAll(super.buildChildren());
            if (this.date!= null) {
                products.put("date", this.date.init());
            }
            if (this.latitude!= null) {
                products.put("latitude", this.latitude.init());
            }
            if (this.longitude!= null) {
                products.put("longitude", this.longitude.init());
            }
            if (this.weightMeasured!= null) {
                products.put("weightMeasured", this.weightMeasured.init());
            }
            if (this.weightEstimated!= null) {
                products.put("weightEstimated", this.weightEstimated.init());
            }
            if (this.antlerPointsLeft!= null) {
                products.put("antlerPointsLeft", this.antlerPointsLeft.init());
            }
            if (this.antlerPointsRight!= null) {
                products.put("antlerPointsRight", this.antlerPointsRight.init());
            }
            if (this.antlersType!= null) {
                products.put("antlersType", this.antlersType.init());
            }
            if (this.antlersWidth!= null) {
                products.put("antlersWidth", this.antlersWidth.init());
            }
            if (this.fitnessClass!= null) {
                products.put("fitnessClass", this.fitnessClass.init());
            }
            if (this.additionalInfo!= null) {
                products.put("additionalInfo", this.additionalInfo.init());
            }
            return products;
        }

        public com.kscs.util.jaxb.Selector<TRoot, MooseDataCardMooseMale.Selector<TRoot, TParent>> date() {
            return ((this.date == null)?this.date = new com.kscs.util.jaxb.Selector<TRoot, MooseDataCardMooseMale.Selector<TRoot, TParent>>(this._root, this, "date"):this.date);
        }

        public com.kscs.util.jaxb.Selector<TRoot, MooseDataCardMooseMale.Selector<TRoot, TParent>> latitude() {
            return ((this.latitude == null)?this.latitude = new com.kscs.util.jaxb.Selector<TRoot, MooseDataCardMooseMale.Selector<TRoot, TParent>>(this._root, this, "latitude"):this.latitude);
        }

        public com.kscs.util.jaxb.Selector<TRoot, MooseDataCardMooseMale.Selector<TRoot, TParent>> longitude() {
            return ((this.longitude == null)?this.longitude = new com.kscs.util.jaxb.Selector<TRoot, MooseDataCardMooseMale.Selector<TRoot, TParent>>(this._root, this, "longitude"):this.longitude);
        }

        public com.kscs.util.jaxb.Selector<TRoot, MooseDataCardMooseMale.Selector<TRoot, TParent>> weightMeasured() {
            return ((this.weightMeasured == null)?this.weightMeasured = new com.kscs.util.jaxb.Selector<TRoot, MooseDataCardMooseMale.Selector<TRoot, TParent>>(this._root, this, "weightMeasured"):this.weightMeasured);
        }

        public com.kscs.util.jaxb.Selector<TRoot, MooseDataCardMooseMale.Selector<TRoot, TParent>> weightEstimated() {
            return ((this.weightEstimated == null)?this.weightEstimated = new com.kscs.util.jaxb.Selector<TRoot, MooseDataCardMooseMale.Selector<TRoot, TParent>>(this._root, this, "weightEstimated"):this.weightEstimated);
        }

        public com.kscs.util.jaxb.Selector<TRoot, MooseDataCardMooseMale.Selector<TRoot, TParent>> antlerPointsLeft() {
            return ((this.antlerPointsLeft == null)?this.antlerPointsLeft = new com.kscs.util.jaxb.Selector<TRoot, MooseDataCardMooseMale.Selector<TRoot, TParent>>(this._root, this, "antlerPointsLeft"):this.antlerPointsLeft);
        }

        public com.kscs.util.jaxb.Selector<TRoot, MooseDataCardMooseMale.Selector<TRoot, TParent>> antlerPointsRight() {
            return ((this.antlerPointsRight == null)?this.antlerPointsRight = new com.kscs.util.jaxb.Selector<TRoot, MooseDataCardMooseMale.Selector<TRoot, TParent>>(this._root, this, "antlerPointsRight"):this.antlerPointsRight);
        }

        public com.kscs.util.jaxb.Selector<TRoot, MooseDataCardMooseMale.Selector<TRoot, TParent>> antlersType() {
            return ((this.antlersType == null)?this.antlersType = new com.kscs.util.jaxb.Selector<TRoot, MooseDataCardMooseMale.Selector<TRoot, TParent>>(this._root, this, "antlersType"):this.antlersType);
        }

        public com.kscs.util.jaxb.Selector<TRoot, MooseDataCardMooseMale.Selector<TRoot, TParent>> antlersWidth() {
            return ((this.antlersWidth == null)?this.antlersWidth = new com.kscs.util.jaxb.Selector<TRoot, MooseDataCardMooseMale.Selector<TRoot, TParent>>(this._root, this, "antlersWidth"):this.antlersWidth);
        }

        public com.kscs.util.jaxb.Selector<TRoot, MooseDataCardMooseMale.Selector<TRoot, TParent>> fitnessClass() {
            return ((this.fitnessClass == null)?this.fitnessClass = new com.kscs.util.jaxb.Selector<TRoot, MooseDataCardMooseMale.Selector<TRoot, TParent>>(this._root, this, "fitnessClass"):this.fitnessClass);
        }

        public com.kscs.util.jaxb.Selector<TRoot, MooseDataCardMooseMale.Selector<TRoot, TParent>> additionalInfo() {
            return ((this.additionalInfo == null)?this.additionalInfo = new com.kscs.util.jaxb.Selector<TRoot, MooseDataCardMooseMale.Selector<TRoot, TParent>>(this._root, this, "additionalInfo"):this.additionalInfo);
        }

    }

}
