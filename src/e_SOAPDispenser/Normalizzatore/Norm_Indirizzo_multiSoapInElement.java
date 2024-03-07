/**
 * Norm_Indirizzo_multiSoapInElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_Indirizzo_multiSoapInElement  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiInput norm_Indirizzo_multiInput;

    public Norm_Indirizzo_multiSoapInElement() {
    }

    public Norm_Indirizzo_multiSoapInElement(
           e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiInput norm_Indirizzo_multiInput) {
           this.norm_Indirizzo_multiInput = norm_Indirizzo_multiInput;
    }


    /**
     * Gets the norm_Indirizzo_multiInput value for this Norm_Indirizzo_multiSoapInElement.
     * 
     * @return norm_Indirizzo_multiInput
     */
    public e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiInput getNorm_Indirizzo_multiInput() {
        return norm_Indirizzo_multiInput;
    }


    /**
     * Sets the norm_Indirizzo_multiInput value for this Norm_Indirizzo_multiSoapInElement.
     * 
     * @param norm_Indirizzo_multiInput
     */
    public void setNorm_Indirizzo_multiInput(e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiInput norm_Indirizzo_multiInput) {
        this.norm_Indirizzo_multiInput = norm_Indirizzo_multiInput;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_Indirizzo_multiSoapInElement)) return false;
        Norm_Indirizzo_multiSoapInElement other = (Norm_Indirizzo_multiSoapInElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_Indirizzo_multiInput==null && other.getNorm_Indirizzo_multiInput()==null) || 
             (this.norm_Indirizzo_multiInput!=null &&
              this.norm_Indirizzo_multiInput.equals(other.getNorm_Indirizzo_multiInput())));
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
        if (getNorm_Indirizzo_multiInput() != null) {
            _hashCode += getNorm_Indirizzo_multiInput().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_Indirizzo_multiSoapInElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Indirizzo_multiSoapInElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_Indirizzo_multiInput");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_multiInput"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_multiInput"));
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
