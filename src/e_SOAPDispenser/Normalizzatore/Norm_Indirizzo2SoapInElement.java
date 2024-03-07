/**
 * Norm_Indirizzo2SoapInElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_Indirizzo2SoapInElement  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_Indirizzo2Input norm_Indirizzo2Input;

    public Norm_Indirizzo2SoapInElement() {
    }

    public Norm_Indirizzo2SoapInElement(
           e_SOAPDispenser.Normalizzatore.Norm_Indirizzo2Input norm_Indirizzo2Input) {
           this.norm_Indirizzo2Input = norm_Indirizzo2Input;
    }


    /**
     * Gets the norm_Indirizzo2Input value for this Norm_Indirizzo2SoapInElement.
     * 
     * @return norm_Indirizzo2Input
     */
    public e_SOAPDispenser.Normalizzatore.Norm_Indirizzo2Input getNorm_Indirizzo2Input() {
        return norm_Indirizzo2Input;
    }


    /**
     * Sets the norm_Indirizzo2Input value for this Norm_Indirizzo2SoapInElement.
     * 
     * @param norm_Indirizzo2Input
     */
    public void setNorm_Indirizzo2Input(e_SOAPDispenser.Normalizzatore.Norm_Indirizzo2Input norm_Indirizzo2Input) {
        this.norm_Indirizzo2Input = norm_Indirizzo2Input;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_Indirizzo2SoapInElement)) return false;
        Norm_Indirizzo2SoapInElement other = (Norm_Indirizzo2SoapInElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_Indirizzo2Input==null && other.getNorm_Indirizzo2Input()==null) || 
             (this.norm_Indirizzo2Input!=null &&
              this.norm_Indirizzo2Input.equals(other.getNorm_Indirizzo2Input())));
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
        if (getNorm_Indirizzo2Input() != null) {
            _hashCode += getNorm_Indirizzo2Input().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_Indirizzo2SoapInElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Indirizzo2SoapInElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_Indirizzo2Input");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo2Input"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo2Input"));
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
