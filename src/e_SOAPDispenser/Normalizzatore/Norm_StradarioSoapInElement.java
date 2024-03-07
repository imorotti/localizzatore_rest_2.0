/**
 * Norm_StradarioSoapInElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_StradarioSoapInElement  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_StradarioInput norm_StradarioInput;

    public Norm_StradarioSoapInElement() {
    }

    public Norm_StradarioSoapInElement(
           e_SOAPDispenser.Normalizzatore.Norm_StradarioInput norm_StradarioInput) {
           this.norm_StradarioInput = norm_StradarioInput;
    }


    /**
     * Gets the norm_StradarioInput value for this Norm_StradarioSoapInElement.
     * 
     * @return norm_StradarioInput
     */
    public e_SOAPDispenser.Normalizzatore.Norm_StradarioInput getNorm_StradarioInput() {
        return norm_StradarioInput;
    }


    /**
     * Sets the norm_StradarioInput value for this Norm_StradarioSoapInElement.
     * 
     * @param norm_StradarioInput
     */
    public void setNorm_StradarioInput(e_SOAPDispenser.Normalizzatore.Norm_StradarioInput norm_StradarioInput) {
        this.norm_StradarioInput = norm_StradarioInput;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_StradarioSoapInElement)) return false;
        Norm_StradarioSoapInElement other = (Norm_StradarioSoapInElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_StradarioInput==null && other.getNorm_StradarioInput()==null) || 
             (this.norm_StradarioInput!=null &&
              this.norm_StradarioInput.equals(other.getNorm_StradarioInput())));
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
        if (getNorm_StradarioInput() != null) {
            _hashCode += getNorm_StradarioInput().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_StradarioSoapInElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_StradarioSoapInElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_StradarioInput");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_StradarioInput"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_StradarioInput"));
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
