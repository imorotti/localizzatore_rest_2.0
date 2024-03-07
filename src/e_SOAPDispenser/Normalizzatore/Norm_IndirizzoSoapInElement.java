/**
 * Norm_IndirizzoSoapInElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_IndirizzoSoapInElement  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_IndirizzoInput norm_IndirizzoInput;

    public Norm_IndirizzoSoapInElement() {
    }

    public Norm_IndirizzoSoapInElement(
           e_SOAPDispenser.Normalizzatore.Norm_IndirizzoInput norm_IndirizzoInput) {
           this.norm_IndirizzoInput = norm_IndirizzoInput;
    }


    /**
     * Gets the norm_IndirizzoInput value for this Norm_IndirizzoSoapInElement.
     * 
     * @return norm_IndirizzoInput
     */
    public e_SOAPDispenser.Normalizzatore.Norm_IndirizzoInput getNorm_IndirizzoInput() {
        return norm_IndirizzoInput;
    }


    /**
     * Sets the norm_IndirizzoInput value for this Norm_IndirizzoSoapInElement.
     * 
     * @param norm_IndirizzoInput
     */
    public void setNorm_IndirizzoInput(e_SOAPDispenser.Normalizzatore.Norm_IndirizzoInput norm_IndirizzoInput) {
        this.norm_IndirizzoInput = norm_IndirizzoInput;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_IndirizzoSoapInElement)) return false;
        Norm_IndirizzoSoapInElement other = (Norm_IndirizzoSoapInElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_IndirizzoInput==null && other.getNorm_IndirizzoInput()==null) || 
             (this.norm_IndirizzoInput!=null &&
              this.norm_IndirizzoInput.equals(other.getNorm_IndirizzoInput())));
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
        if (getNorm_IndirizzoInput() != null) {
            _hashCode += getNorm_IndirizzoInput().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_IndirizzoSoapInElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_IndirizzoSoapInElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_IndirizzoInput");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IndirizzoInput"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IndirizzoInput"));
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
