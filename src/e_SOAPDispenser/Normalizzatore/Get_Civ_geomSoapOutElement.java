/**
 * Get_Civ_geomSoapOutElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Get_Civ_geomSoapOutElement  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Get_Civ_geomOutput get_Civ_geomOutput;

    public Get_Civ_geomSoapOutElement() {
    }

    public Get_Civ_geomSoapOutElement(
           e_SOAPDispenser.Normalizzatore.Get_Civ_geomOutput get_Civ_geomOutput) {
           this.get_Civ_geomOutput = get_Civ_geomOutput;
    }


    /**
     * Gets the get_Civ_geomOutput value for this Get_Civ_geomSoapOutElement.
     * 
     * @return get_Civ_geomOutput
     */
    public e_SOAPDispenser.Normalizzatore.Get_Civ_geomOutput getGet_Civ_geomOutput() {
        return get_Civ_geomOutput;
    }


    /**
     * Sets the get_Civ_geomOutput value for this Get_Civ_geomSoapOutElement.
     * 
     * @param get_Civ_geomOutput
     */
    public void setGet_Civ_geomOutput(e_SOAPDispenser.Normalizzatore.Get_Civ_geomOutput get_Civ_geomOutput) {
        this.get_Civ_geomOutput = get_Civ_geomOutput;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Get_Civ_geomSoapOutElement)) return false;
        Get_Civ_geomSoapOutElement other = (Get_Civ_geomSoapOutElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.get_Civ_geomOutput==null && other.getGet_Civ_geomOutput()==null) || 
             (this.get_Civ_geomOutput!=null &&
              this.get_Civ_geomOutput.equals(other.getGet_Civ_geomOutput())));
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
        if (getGet_Civ_geomOutput() != null) {
            _hashCode += getGet_Civ_geomOutput().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Get_Civ_geomSoapOutElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Get_Civ_geomSoapOutElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("get_Civ_geomOutput");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Civ_geomOutput"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Civ_geomOutput"));
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
