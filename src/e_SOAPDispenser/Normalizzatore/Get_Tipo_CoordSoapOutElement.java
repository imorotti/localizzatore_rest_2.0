/**
 * Get_Tipo_CoordSoapOutElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Get_Tipo_CoordSoapOutElement  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordOutput get_Tipo_CoordOutput;

    public Get_Tipo_CoordSoapOutElement() {
    }

    public Get_Tipo_CoordSoapOutElement(
           e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordOutput get_Tipo_CoordOutput) {
           this.get_Tipo_CoordOutput = get_Tipo_CoordOutput;
    }


    /**
     * Gets the get_Tipo_CoordOutput value for this Get_Tipo_CoordSoapOutElement.
     * 
     * @return get_Tipo_CoordOutput
     */
    public e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordOutput getGet_Tipo_CoordOutput() {
        return get_Tipo_CoordOutput;
    }


    /**
     * Sets the get_Tipo_CoordOutput value for this Get_Tipo_CoordSoapOutElement.
     * 
     * @param get_Tipo_CoordOutput
     */
    public void setGet_Tipo_CoordOutput(e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordOutput get_Tipo_CoordOutput) {
        this.get_Tipo_CoordOutput = get_Tipo_CoordOutput;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Get_Tipo_CoordSoapOutElement)) return false;
        Get_Tipo_CoordSoapOutElement other = (Get_Tipo_CoordSoapOutElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.get_Tipo_CoordOutput==null && other.getGet_Tipo_CoordOutput()==null) || 
             (this.get_Tipo_CoordOutput!=null &&
              this.get_Tipo_CoordOutput.equals(other.getGet_Tipo_CoordOutput())));
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
        if (getGet_Tipo_CoordOutput() != null) {
            _hashCode += getGet_Tipo_CoordOutput().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Get_Tipo_CoordSoapOutElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Get_Tipo_CoordSoapOutElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("get_Tipo_CoordOutput");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Tipo_CoordOutput"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Tipo_CoordOutput"));
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
