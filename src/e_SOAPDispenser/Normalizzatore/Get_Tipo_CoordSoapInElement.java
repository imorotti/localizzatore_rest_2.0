/**
 * Get_Tipo_CoordSoapInElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Get_Tipo_CoordSoapInElement  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordInput get_Tipo_CoordInput;

    public Get_Tipo_CoordSoapInElement() {
    }

    public Get_Tipo_CoordSoapInElement(
           e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordInput get_Tipo_CoordInput) {
           this.get_Tipo_CoordInput = get_Tipo_CoordInput;
    }


    /**
     * Gets the get_Tipo_CoordInput value for this Get_Tipo_CoordSoapInElement.
     * 
     * @return get_Tipo_CoordInput
     */
    public e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordInput getGet_Tipo_CoordInput() {
        return get_Tipo_CoordInput;
    }


    /**
     * Sets the get_Tipo_CoordInput value for this Get_Tipo_CoordSoapInElement.
     * 
     * @param get_Tipo_CoordInput
     */
    public void setGet_Tipo_CoordInput(e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordInput get_Tipo_CoordInput) {
        this.get_Tipo_CoordInput = get_Tipo_CoordInput;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Get_Tipo_CoordSoapInElement)) return false;
        Get_Tipo_CoordSoapInElement other = (Get_Tipo_CoordSoapInElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.get_Tipo_CoordInput==null && other.getGet_Tipo_CoordInput()==null) || 
             (this.get_Tipo_CoordInput!=null &&
              this.get_Tipo_CoordInput.equals(other.getGet_Tipo_CoordInput())));
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
        if (getGet_Tipo_CoordInput() != null) {
            _hashCode += getGet_Tipo_CoordInput().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Get_Tipo_CoordSoapInElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Get_Tipo_CoordSoapInElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("get_Tipo_CoordInput");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Tipo_CoordInput"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Tipo_CoordInput"));
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
