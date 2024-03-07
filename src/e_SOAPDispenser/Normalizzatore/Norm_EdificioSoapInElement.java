/**
 * Norm_EdificioSoapInElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_EdificioSoapInElement  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_EdificioInput norm_EdificioInput;

    public Norm_EdificioSoapInElement() {
    }

    public Norm_EdificioSoapInElement(
           e_SOAPDispenser.Normalizzatore.Norm_EdificioInput norm_EdificioInput) {
           this.norm_EdificioInput = norm_EdificioInput;
    }


    /**
     * Gets the norm_EdificioInput value for this Norm_EdificioSoapInElement.
     * 
     * @return norm_EdificioInput
     */
    public e_SOAPDispenser.Normalizzatore.Norm_EdificioInput getNorm_EdificioInput() {
        return norm_EdificioInput;
    }


    /**
     * Sets the norm_EdificioInput value for this Norm_EdificioSoapInElement.
     * 
     * @param norm_EdificioInput
     */
    public void setNorm_EdificioInput(e_SOAPDispenser.Normalizzatore.Norm_EdificioInput norm_EdificioInput) {
        this.norm_EdificioInput = norm_EdificioInput;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_EdificioSoapInElement)) return false;
        Norm_EdificioSoapInElement other = (Norm_EdificioSoapInElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_EdificioInput==null && other.getNorm_EdificioInput()==null) || 
             (this.norm_EdificioInput!=null &&
              this.norm_EdificioInput.equals(other.getNorm_EdificioInput())));
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
        if (getNorm_EdificioInput() != null) {
            _hashCode += getNorm_EdificioInput().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_EdificioSoapInElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_EdificioSoapInElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_EdificioInput");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_EdificioInput"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_EdificioInput"));
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
