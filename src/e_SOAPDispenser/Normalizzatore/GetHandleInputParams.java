/**
 * GetHandleInputParams.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class GetHandleInputParams  implements java.io.Serializable {
    private java.lang.String p_Userpassword;
    private java.lang.String p_Username;

    public GetHandleInputParams() {
    }

    public GetHandleInputParams(
           java.lang.String p_Userpassword,
           java.lang.String p_Username) {
           this.p_Userpassword = p_Userpassword;
           this.p_Username = p_Username;
    }


    /**
     * Gets the p_Userpassword value for this GetHandleInputParams.
     * 
     * @return p_Userpassword
     */
    public java.lang.String getP_Userpassword() {
        return p_Userpassword;
    }


    /**
     * Sets the p_Userpassword value for this GetHandleInputParams.
     * 
     * @param p_Userpassword
     */
    public void setP_Userpassword(java.lang.String p_Userpassword) {
        this.p_Userpassword = p_Userpassword;
    }


    /**
     * Gets the p_Username value for this GetHandleInputParams.
     * 
     * @return p_Username
     */
    public java.lang.String getP_Username() {
        return p_Username;
    }


    /**
     * Sets the p_Username value for this GetHandleInputParams.
     * 
     * @param p_Username
     */
    public void setP_Username(java.lang.String p_Username) {
        this.p_Username = p_Username;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetHandleInputParams)) return false;
        GetHandleInputParams other = (GetHandleInputParams) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.p_Userpassword==null && other.getP_Userpassword()==null) || 
             (this.p_Userpassword!=null &&
              this.p_Userpassword.equals(other.getP_Userpassword()))) &&
            ((this.p_Username==null && other.getP_Username()==null) || 
             (this.p_Username!=null &&
              this.p_Username.equals(other.getP_Username())));
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
        if (getP_Userpassword() != null) {
            _hashCode += getP_Userpassword().hashCode();
        }
        if (getP_Username() != null) {
            _hashCode += getP_Username().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetHandleInputParams.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "GetHandleInputParams"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_Userpassword");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_Userpassword"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_Username");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_Username"));
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
