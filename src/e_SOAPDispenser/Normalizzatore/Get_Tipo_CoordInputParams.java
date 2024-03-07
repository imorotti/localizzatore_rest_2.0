/**
 * Get_Tipo_CoordInputParams.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Get_Tipo_CoordInputParams  implements java.io.Serializable {
    private java.lang.String p_HANDLE;

    public Get_Tipo_CoordInputParams() {
    }

    public Get_Tipo_CoordInputParams(
           java.lang.String p_HANDLE) {
           this.p_HANDLE = p_HANDLE;
    }


    /**
     * Gets the p_HANDLE value for this Get_Tipo_CoordInputParams.
     * 
     * @return p_HANDLE
     */
    public java.lang.String getP_HANDLE() {
        return p_HANDLE;
    }


    /**
     * Sets the p_HANDLE value for this Get_Tipo_CoordInputParams.
     * 
     * @param p_HANDLE
     */
    public void setP_HANDLE(java.lang.String p_HANDLE) {
        this.p_HANDLE = p_HANDLE;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Get_Tipo_CoordInputParams)) return false;
        Get_Tipo_CoordInputParams other = (Get_Tipo_CoordInputParams) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.p_HANDLE==null && other.getP_HANDLE()==null) || 
             (this.p_HANDLE!=null &&
              this.p_HANDLE.equals(other.getP_HANDLE())));
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
        if (getP_HANDLE() != null) {
            _hashCode += getP_HANDLE().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Get_Tipo_CoordInputParams.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Tipo_CoordInputParams"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_HANDLE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_HANDLE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
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
