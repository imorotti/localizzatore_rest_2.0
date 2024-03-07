/**
 * Get_Str_GeomSoapOutElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Get_Str_GeomSoapOutElement  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Get_Str_GeomOutput get_Str_GeomOutput;

    public Get_Str_GeomSoapOutElement() {
    }

    public Get_Str_GeomSoapOutElement(
           e_SOAPDispenser.Normalizzatore.Get_Str_GeomOutput get_Str_GeomOutput) {
           this.get_Str_GeomOutput = get_Str_GeomOutput;
    }


    /**
     * Gets the get_Str_GeomOutput value for this Get_Str_GeomSoapOutElement.
     * 
     * @return get_Str_GeomOutput
     */
    public e_SOAPDispenser.Normalizzatore.Get_Str_GeomOutput getGet_Str_GeomOutput() {
        return get_Str_GeomOutput;
    }


    /**
     * Sets the get_Str_GeomOutput value for this Get_Str_GeomSoapOutElement.
     * 
     * @param get_Str_GeomOutput
     */
    public void setGet_Str_GeomOutput(e_SOAPDispenser.Normalizzatore.Get_Str_GeomOutput get_Str_GeomOutput) {
        this.get_Str_GeomOutput = get_Str_GeomOutput;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Get_Str_GeomSoapOutElement)) return false;
        Get_Str_GeomSoapOutElement other = (Get_Str_GeomSoapOutElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.get_Str_GeomOutput==null && other.getGet_Str_GeomOutput()==null) || 
             (this.get_Str_GeomOutput!=null &&
              this.get_Str_GeomOutput.equals(other.getGet_Str_GeomOutput())));
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
        if (getGet_Str_GeomOutput() != null) {
            _hashCode += getGet_Str_GeomOutput().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Get_Str_GeomSoapOutElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Get_Str_GeomSoapOutElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("get_Str_GeomOutput");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Str_GeomOutput"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Str_GeomOutput"));
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
