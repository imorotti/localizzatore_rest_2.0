/**
 * Norm_IncrocioSoapInElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_IncrocioSoapInElement  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_IncrocioInput norm_IncrocioInput;

    public Norm_IncrocioSoapInElement() {
    }

    public Norm_IncrocioSoapInElement(
           e_SOAPDispenser.Normalizzatore.Norm_IncrocioInput norm_IncrocioInput) {
           this.norm_IncrocioInput = norm_IncrocioInput;
    }


    /**
     * Gets the norm_IncrocioInput value for this Norm_IncrocioSoapInElement.
     * 
     * @return norm_IncrocioInput
     */
    public e_SOAPDispenser.Normalizzatore.Norm_IncrocioInput getNorm_IncrocioInput() {
        return norm_IncrocioInput;
    }


    /**
     * Sets the norm_IncrocioInput value for this Norm_IncrocioSoapInElement.
     * 
     * @param norm_IncrocioInput
     */
    public void setNorm_IncrocioInput(e_SOAPDispenser.Normalizzatore.Norm_IncrocioInput norm_IncrocioInput) {
        this.norm_IncrocioInput = norm_IncrocioInput;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_IncrocioSoapInElement)) return false;
        Norm_IncrocioSoapInElement other = (Norm_IncrocioSoapInElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_IncrocioInput==null && other.getNorm_IncrocioInput()==null) || 
             (this.norm_IncrocioInput!=null &&
              this.norm_IncrocioInput.equals(other.getNorm_IncrocioInput())));
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
        if (getNorm_IncrocioInput() != null) {
            _hashCode += getNorm_IncrocioInput().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_IncrocioSoapInElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_IncrocioSoapInElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_IncrocioInput");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IncrocioInput"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IncrocioInput"));
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
