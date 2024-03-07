/**
 * GetHandleSoapInElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class GetHandleSoapInElement  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.GetHandleInput getHandleInput;

    public GetHandleSoapInElement() {
    }

    public GetHandleSoapInElement(
           e_SOAPDispenser.Normalizzatore.GetHandleInput getHandleInput) {
           this.getHandleInput = getHandleInput;
    }


    /**
     * Gets the getHandleInput value for this GetHandleSoapInElement.
     * 
     * @return getHandleInput
     */
    public e_SOAPDispenser.Normalizzatore.GetHandleInput getGetHandleInput() {
        return getHandleInput;
    }


    /**
     * Sets the getHandleInput value for this GetHandleSoapInElement.
     * 
     * @param getHandleInput
     */
    public void setGetHandleInput(e_SOAPDispenser.Normalizzatore.GetHandleInput getHandleInput) {
        this.getHandleInput = getHandleInput;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetHandleSoapInElement)) return false;
        GetHandleSoapInElement other = (GetHandleSoapInElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getHandleInput==null && other.getGetHandleInput()==null) || 
             (this.getHandleInput!=null &&
              this.getHandleInput.equals(other.getGetHandleInput())));
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
        if (getGetHandleInput() != null) {
            _hashCode += getGetHandleInput().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetHandleSoapInElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">GetHandleSoapInElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getHandleInput");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "GetHandleInput"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "GetHandleInput"));
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
