//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.05.13 at 11:52:15 AM EEST 
//


package fi.riista.integration.luke_import.model.v1_0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import com.kscs.util.jaxb.Copyable;
import com.kscs.util.jaxb.PartialCopyable;
import com.kscs.util.jaxb.PropertyTree;
import com.kscs.util.jaxb.PropertyTreeUse;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for _3.1Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="_3.1Type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="_Päivittäiset_hirvihavainnot" type="{http://www.abbyy.com/FlexiCapture/Schemas/Export/Hirvitietokortti.xsd}_Päivittäiset_hirvihavainnotType" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "_3.1Type", namespace = "http://www.abbyy.com/FlexiCapture/Schemas/Export/Hirvitietokortti.xsd", propOrder = {
    "mooseObservations"
})
public class MooseDataCardSection_3_1 implements Cloneable, Copyable, PartialCopyable, ToString2
{

    @XmlElement(name = "_P\u00e4ivitt\u00e4iset_hirvihavainnot")
    protected List<MooseDataCardObservation> mooseObservations;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
     * 
     */
    public MooseDataCardSection_3_1() {
        // Generated by copy-constructor plugin, JAXB requires public no-arg constructor.
    }

    /**
     * Instantiates a MooseDataCardSection_3_1 copying the state of another MooseDataCardSection_3_1
     * 
     * @param _other
     *     The original MooseDataCardSection_3_1 from which to copy state.
     */
    public MooseDataCardSection_3_1(final MooseDataCardSection_3_1 _other) {
        if (_other.mooseObservations == null) {
            this.mooseObservations = null;
        } else {
            this.mooseObservations = new ArrayList<MooseDataCardObservation>();
            for (MooseDataCardObservation _item: _other.mooseObservations) {
                this.mooseObservations.add(((_item == null)?null:_item.createCopy()));
            }
        }
    }

    /**
     * Instantiates a MooseDataCardSection_3_1 copying the state of another MooseDataCardSection_3_1
     * 
     * @param _propertyTreeUse
     *     Meaning of the {@link PropertyPath}: Exclude or include members contained in property path.
     * @param _propertyTree
     *     A restricting {@link PropertyPath} that defines which nodes of the source object tree should actually be copied.
     * @param _other
     *     The original MooseDataCardSection_3_1 from which to copy state.
     */
    public MooseDataCardSection_3_1(final MooseDataCardSection_3_1 _other, final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        final PropertyTree mooseObservationsPropertyTree = ((_propertyTree == null)?null:_propertyTree.get("mooseObservations"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(mooseObservationsPropertyTree!= null):((mooseObservationsPropertyTree == null)||(!mooseObservationsPropertyTree.isLeaf())))) {
            if (_other.mooseObservations == null) {
                this.mooseObservations = null;
            } else {
                this.mooseObservations = new ArrayList<MooseDataCardObservation>();
                for (MooseDataCardObservation _item: _other.mooseObservations) {
                    this.mooseObservations.add(((_item == null)?null:_item.createCopy(mooseObservationsPropertyTree, _propertyTreeUse)));
                }
            }
        }
    }

    /**
     * Gets the value of the mooseObservations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mooseObservations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMooseObservations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MooseDataCardObservation }
     * 
     * 
     */
    public List<MooseDataCardObservation> getMooseObservations() {
        if (mooseObservations == null) {
            mooseObservations = new ArrayList<MooseDataCardObservation>();
        }
        return this.mooseObservations;
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
            List<MooseDataCardObservation> theMooseObservations;
            theMooseObservations = (((this.mooseObservations!= null)&&(!this.mooseObservations.isEmpty()))?this.getMooseObservations():null);
            strategy.appendField(locator, this, "mooseObservations", buffer, theMooseObservations, ((this.mooseObservations!= null)&&(!this.mooseObservations.isEmpty())));
        }
        return buffer;
    }

    public MooseDataCardSection_3_1 withMooseObservations(MooseDataCardObservation... values) {
        if (values!= null) {
            for (MooseDataCardObservation value: values) {
                getMooseObservations().add(value);
            }
        }
        return this;
    }

    public MooseDataCardSection_3_1 withMooseObservations(Collection<MooseDataCardObservation> values) {
        if (values!= null) {
            getMooseObservations().addAll(values);
        }
        return this;
    }

    @Override
    public MooseDataCardSection_3_1 clone() {
        final MooseDataCardSection_3_1 _newObject;
        try {
            _newObject = ((MooseDataCardSection_3_1) super.clone());
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        if (this.mooseObservations == null) {
            _newObject.mooseObservations = null;
        } else {
            _newObject.mooseObservations = new ArrayList<MooseDataCardObservation>();
            for (MooseDataCardObservation _item: this.mooseObservations) {
                _newObject.mooseObservations.add(((_item == null)?null:_item.clone()));
            }
        }
        return _newObject;
    }

    @Override
    public MooseDataCardSection_3_1 createCopy() {
        final MooseDataCardSection_3_1 _newObject;
        try {
            _newObject = ((MooseDataCardSection_3_1) super.clone());
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        if (this.mooseObservations == null) {
            _newObject.mooseObservations = null;
        } else {
            _newObject.mooseObservations = new ArrayList<MooseDataCardObservation>();
            for (MooseDataCardObservation _item: this.mooseObservations) {
                _newObject.mooseObservations.add(((_item == null)?null:_item.createCopy()));
            }
        }
        return _newObject;
    }

    @Override
    public MooseDataCardSection_3_1 createCopy(final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        final MooseDataCardSection_3_1 _newObject;
        try {
            _newObject = ((MooseDataCardSection_3_1) super.clone());
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        final PropertyTree mooseObservationsPropertyTree = ((_propertyTree == null)?null:_propertyTree.get("mooseObservations"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(mooseObservationsPropertyTree!= null):((mooseObservationsPropertyTree == null)||(!mooseObservationsPropertyTree.isLeaf())))) {
            if (this.mooseObservations == null) {
                _newObject.mooseObservations = null;
            } else {
                _newObject.mooseObservations = new ArrayList<MooseDataCardObservation>();
                for (MooseDataCardObservation _item: this.mooseObservations) {
                    _newObject.mooseObservations.add(((_item == null)?null:_item.createCopy(mooseObservationsPropertyTree, _propertyTreeUse)));
                }
            }
        }
        return _newObject;
    }

    @Override
    public MooseDataCardSection_3_1 copyExcept(final PropertyTree _propertyTree) {
        return createCopy(_propertyTree, PropertyTreeUse.EXCLUDE);
    }

    @Override
    public MooseDataCardSection_3_1 copyOnly(final PropertyTree _propertyTree) {
        return createCopy(_propertyTree, PropertyTreeUse.INCLUDE);
    }

    public static class Select
        extends MooseDataCardSection_3_1 .Selector<MooseDataCardSection_3_1 .Select, Void>
    {


        Select() {
            super(null, null, null);
        }

        public static MooseDataCardSection_3_1 .Select _root() {
            return new MooseDataCardSection_3_1 .Select();
        }

    }

    public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?> , TParent >
        extends com.kscs.util.jaxb.Selector<TRoot, TParent>
    {

        private MooseDataCardObservation.Selector<TRoot, MooseDataCardSection_3_1 .Selector<TRoot, TParent>> mooseObservations = null;

        public Selector(final TRoot root, final TParent parent, final String propertyName) {
            super(root, parent, propertyName);
        }

        @Override
        public Map<String, PropertyTree> buildChildren() {
            final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
            products.putAll(super.buildChildren());
            if (this.mooseObservations!= null) {
                products.put("mooseObservations", this.mooseObservations.init());
            }
            return products;
        }

        public MooseDataCardObservation.Selector<TRoot, MooseDataCardSection_3_1 .Selector<TRoot, TParent>> mooseObservations() {
            return ((this.mooseObservations == null)?this.mooseObservations = new MooseDataCardObservation.Selector<TRoot, MooseDataCardSection_3_1 .Selector<TRoot, TParent>>(this._root, this, "mooseObservations"):this.mooseObservations);
        }

    }

}
