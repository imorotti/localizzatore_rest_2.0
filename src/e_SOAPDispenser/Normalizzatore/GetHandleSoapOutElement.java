/**
 * GetHandleSoapOutElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class GetHandleSoapOutElement  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.GetHandleOutput getHandleOutput;

    public GetHandleSoapOutElement() {
    }

    public GetHandleSoapOutElement(
           e_SOAPDispenser.Normalizzatore.GetHandleOutput getHandleOutput) {
           this.getHandleOutput = getHandleOutput;
    }


    /**
     * Gets the getHandleOutput value for this GetHandleSoapOutElement.
     * 
     * @return getHandleOutput
     */
    public e_SOAPDispenser.Normalizzatore.GetHandleOutput getGetHandleOutput() {
        return getHandleOutput;
    }


    /**
     * Sets the getHandleOutput value for this GetHandleSoapOutElement.
     * 
     * @param getHandleOutput
     */
    public void setGetHandleOutput(e_SOAPDispenser.Normalizzatore.GetHandleOutput getHandleOutput) {
        this.getHandleOutput = getHandleOutput;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetHandleSoapOutElement)) return false;
        GetHandleSoapOutElement other = (GetHandleSoapOutElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getHandleOutput==null && other.getGetHandleOutput()==null) || 
             (this.getHandleOutput!=null &&
              this.getHandleOutput.equals(other.getGetHandleOutput())));
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
        if (getGetHandleOutput() != null) {
            _hashCode += getGetHandleOutput().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetHandleSoapOutElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">GetHandleSoapOutElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getHandleOutput");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "GetHandleOutput"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "GetHandleOutput"));
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
