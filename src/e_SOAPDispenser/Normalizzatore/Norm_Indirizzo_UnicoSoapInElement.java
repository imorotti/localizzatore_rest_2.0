/**
 * Norm_Indirizzo_UnicoSoapInElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_Indirizzo_UnicoSoapInElement  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoInput norm_Indirizzo_UnicoInput;

    public Norm_Indirizzo_UnicoSoapInElement() {
    }

    public Norm_Indirizzo_UnicoSoapInElement(
           e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoInput norm_Indirizzo_UnicoInput) {
           this.norm_Indirizzo_UnicoInput = norm_Indirizzo_UnicoInput;
    }


    /**
     * Gets the norm_Indirizzo_UnicoInput value for this Norm_Indirizzo_UnicoSoapInElement.
     * 
     * @return norm_Indirizzo_UnicoInput
     */
    public e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoInput getNorm_Indirizzo_UnicoInput() {
        return norm_Indirizzo_UnicoInput;
    }


    /**
     * Sets the norm_Indirizzo_UnicoInput value for this Norm_Indirizzo_UnicoSoapInElement.
     * 
     * @param norm_Indirizzo_UnicoInput
     */
    public void setNorm_Indirizzo_UnicoInput(e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoInput norm_Indirizzo_UnicoInput) {
        this.norm_Indirizzo_UnicoInput = norm_Indirizzo_UnicoInput;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_Indirizzo_UnicoSoapInElement)) return false;
        Norm_Indirizzo_UnicoSoapInElement other = (Norm_Indirizzo_UnicoSoapInElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_Indirizzo_UnicoInput==null && other.getNorm_Indirizzo_UnicoInput()==null) || 
             (this.norm_Indirizzo_UnicoInput!=null &&
              this.norm_Indirizzo_UnicoInput.equals(other.getNorm_Indirizzo_UnicoInput())));
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
        if (getNorm_Indirizzo_UnicoInput() != null) {
            _hashCode += getNorm_Indirizzo_UnicoInput().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_Indirizzo_UnicoSoapInElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Indirizzo_UnicoSoapInElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_Indirizzo_UnicoInput");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_UnicoInput"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_UnicoInput"));
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
