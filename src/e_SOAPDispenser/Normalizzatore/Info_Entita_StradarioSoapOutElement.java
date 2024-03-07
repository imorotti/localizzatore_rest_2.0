/**
 * Info_Entita_StradarioSoapOutElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Info_Entita_StradarioSoapOutElement  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Info_Entita_StradarioOutput info_Entita_StradarioOutput;

    public Info_Entita_StradarioSoapOutElement() {
    }

    public Info_Entita_StradarioSoapOutElement(
           e_SOAPDispenser.Normalizzatore.Info_Entita_StradarioOutput info_Entita_StradarioOutput) {
           this.info_Entita_StradarioOutput = info_Entita_StradarioOutput;
    }


    /**
     * Gets the info_Entita_StradarioOutput value for this Info_Entita_StradarioSoapOutElement.
     * 
     * @return info_Entita_StradarioOutput
     */
    public e_SOAPDispenser.Normalizzatore.Info_Entita_StradarioOutput getInfo_Entita_StradarioOutput() {
        return info_Entita_StradarioOutput;
    }


    /**
     * Sets the info_Entita_StradarioOutput value for this Info_Entita_StradarioSoapOutElement.
     * 
     * @param info_Entita_StradarioOutput
     */
    public void setInfo_Entita_StradarioOutput(e_SOAPDispenser.Normalizzatore.Info_Entita_StradarioOutput info_Entita_StradarioOutput) {
        this.info_Entita_StradarioOutput = info_Entita_StradarioOutput;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Info_Entita_StradarioSoapOutElement)) return false;
        Info_Entita_StradarioSoapOutElement other = (Info_Entita_StradarioSoapOutElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.info_Entita_StradarioOutput==null && other.getInfo_Entita_StradarioOutput()==null) || 
             (this.info_Entita_StradarioOutput!=null &&
              this.info_Entita_StradarioOutput.equals(other.getInfo_Entita_StradarioOutput())));
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
        if (getInfo_Entita_StradarioOutput() != null) {
            _hashCode += getInfo_Entita_StradarioOutput().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Info_Entita_StradarioSoapOutElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Info_Entita_StradarioSoapOutElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("info_Entita_StradarioOutput");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Info_Entita_StradarioOutput"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Info_Entita_StradarioOutput"));
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
