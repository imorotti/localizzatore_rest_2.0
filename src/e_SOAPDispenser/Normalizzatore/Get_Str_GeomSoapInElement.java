/**
 * Get_Str_GeomSoapInElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Get_Str_GeomSoapInElement  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Get_Str_GeomInput get_Str_GeomInput;

    public Get_Str_GeomSoapInElement() {
    }

    public Get_Str_GeomSoapInElement(
           e_SOAPDispenser.Normalizzatore.Get_Str_GeomInput get_Str_GeomInput) {
           this.get_Str_GeomInput = get_Str_GeomInput;
    }


    /**
     * Gets the get_Str_GeomInput value for this Get_Str_GeomSoapInElement.
     * 
     * @return get_Str_GeomInput
     */
    public e_SOAPDispenser.Normalizzatore.Get_Str_GeomInput getGet_Str_GeomInput() {
        return get_Str_GeomInput;
    }


    /**
     * Sets the get_Str_GeomInput value for this Get_Str_GeomSoapInElement.
     * 
     * @param get_Str_GeomInput
     */
    public void setGet_Str_GeomInput(e_SOAPDispenser.Normalizzatore.Get_Str_GeomInput get_Str_GeomInput) {
        this.get_Str_GeomInput = get_Str_GeomInput;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Get_Str_GeomSoapInElement)) return false;
        Get_Str_GeomSoapInElement other = (Get_Str_GeomSoapInElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.get_Str_GeomInput==null && other.getGet_Str_GeomInput()==null) || 
             (this.get_Str_GeomInput!=null &&
              this.get_Str_GeomInput.equals(other.getGet_Str_GeomInput())));
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
        if (getGet_Str_GeomInput() != null) {
            _hashCode += getGet_Str_GeomInput().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Get_Str_GeomSoapInElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Get_Str_GeomSoapInElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("get_Str_GeomInput");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Str_GeomInput"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Str_GeomInput"));
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
