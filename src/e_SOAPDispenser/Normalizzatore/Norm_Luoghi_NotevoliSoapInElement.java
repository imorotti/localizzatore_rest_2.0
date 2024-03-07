/**
 * Norm_Luoghi_NotevoliSoapInElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_Luoghi_NotevoliSoapInElement  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliInput norm_Luoghi_NotevoliInput;

    public Norm_Luoghi_NotevoliSoapInElement() {
    }

    public Norm_Luoghi_NotevoliSoapInElement(
           e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliInput norm_Luoghi_NotevoliInput) {
           this.norm_Luoghi_NotevoliInput = norm_Luoghi_NotevoliInput;
    }


    /**
     * Gets the norm_Luoghi_NotevoliInput value for this Norm_Luoghi_NotevoliSoapInElement.
     * 
     * @return norm_Luoghi_NotevoliInput
     */
    public e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliInput getNorm_Luoghi_NotevoliInput() {
        return norm_Luoghi_NotevoliInput;
    }


    /**
     * Sets the norm_Luoghi_NotevoliInput value for this Norm_Luoghi_NotevoliSoapInElement.
     * 
     * @param norm_Luoghi_NotevoliInput
     */
    public void setNorm_Luoghi_NotevoliInput(e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliInput norm_Luoghi_NotevoliInput) {
        this.norm_Luoghi_NotevoliInput = norm_Luoghi_NotevoliInput;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_Luoghi_NotevoliSoapInElement)) return false;
        Norm_Luoghi_NotevoliSoapInElement other = (Norm_Luoghi_NotevoliSoapInElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_Luoghi_NotevoliInput==null && other.getNorm_Luoghi_NotevoliInput()==null) || 
             (this.norm_Luoghi_NotevoliInput!=null &&
              this.norm_Luoghi_NotevoliInput.equals(other.getNorm_Luoghi_NotevoliInput())));
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
        if (getNorm_Luoghi_NotevoliInput() != null) {
            _hashCode += getNorm_Luoghi_NotevoliInput().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_Luoghi_NotevoliSoapInElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Luoghi_NotevoliSoapInElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_Luoghi_NotevoliInput");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Luoghi_NotevoliInput"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Luoghi_NotevoliInput"));
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
