/**
 * Norm_ProvinciaSoapInElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_ProvinciaSoapInElement  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_ProvinciaInput norm_ProvinciaInput;

    public Norm_ProvinciaSoapInElement() {
    }

    public Norm_ProvinciaSoapInElement(
           e_SOAPDispenser.Normalizzatore.Norm_ProvinciaInput norm_ProvinciaInput) {
           this.norm_ProvinciaInput = norm_ProvinciaInput;
    }


    /**
     * Gets the norm_ProvinciaInput value for this Norm_ProvinciaSoapInElement.
     * 
     * @return norm_ProvinciaInput
     */
    public e_SOAPDispenser.Normalizzatore.Norm_ProvinciaInput getNorm_ProvinciaInput() {
        return norm_ProvinciaInput;
    }


    /**
     * Sets the norm_ProvinciaInput value for this Norm_ProvinciaSoapInElement.
     * 
     * @param norm_ProvinciaInput
     */
    public void setNorm_ProvinciaInput(e_SOAPDispenser.Normalizzatore.Norm_ProvinciaInput norm_ProvinciaInput) {
        this.norm_ProvinciaInput = norm_ProvinciaInput;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_ProvinciaSoapInElement)) return false;
        Norm_ProvinciaSoapInElement other = (Norm_ProvinciaSoapInElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_ProvinciaInput==null && other.getNorm_ProvinciaInput()==null) || 
             (this.norm_ProvinciaInput!=null &&
              this.norm_ProvinciaInput.equals(other.getNorm_ProvinciaInput())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getNorm_ProvinciaInput() != null) {
            _hashCode += getNorm_ProvinciaInput().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_ProvinciaSoapInElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_ProvinciaSoapInElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_ProvinciaInput");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_ProvinciaInput"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_ProvinciaInput"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
