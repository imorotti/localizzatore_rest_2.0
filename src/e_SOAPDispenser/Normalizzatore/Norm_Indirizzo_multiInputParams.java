/**
 * Norm_Indirizzo_multiInputParams.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_Indirizzo_multiInputParams  implements java.io.Serializable {
    private java.lang.String p_Sep_Ind_Char;
    private byte[] p_Indirizzi;
    private java.lang.String p_Handle;
    private java.lang.String p_Sep_Param_Char;

    public Norm_Indirizzo_multiInputParams() {
    }

    public Norm_Indirizzo_multiInputParams(
           java.lang.String p_Sep_Ind_Char,
           byte[] p_Indirizzi,
           java.lang.String p_Handle,
           java.lang.String p_Sep_Param_Char) {
           this.p_Sep_Ind_Char = p_Sep_Ind_Char;
           this.p_Indirizzi = p_Indirizzi;
           this.p_Handle = p_Handle;
           this.p_Sep_Param_Char = p_Sep_Param_Char;
    }


    /**
     * Gets the p_Sep_Ind_Char value for this Norm_Indirizzo_multiInputParams.
     * 
     * @return p_Sep_Ind_Char
     */
    public java.lang.String getP_Sep_Ind_Char() {
        return p_Sep_Ind_Char;
    }


    /**
     * Sets the p_Sep_Ind_Char value for this Norm_Indirizzo_multiInputParams.
     * 
     * @param p_Sep_Ind_Char
     */
    public void setP_Sep_Ind_Char(java.lang.String p_Sep_Ind_Char) {
        this.p_Sep_Ind_Char = p_Sep_Ind_Char;
    }


    /**
     * Gets the p_Indirizzi value for this Norm_Indirizzo_multiInputParams.
     * 
     * @return p_Indirizzi
     */
    public byte[] getP_Indirizzi() {
        return p_Indirizzi;
    }


    /**
     * Sets the p_Indirizzi value for this Norm_Indirizzo_multiInputParams.
     * 
     * @param p_Indirizzi
     */
    public void setP_Indirizzi(byte[] p_Indirizzi) {
        this.p_Indirizzi = p_Indirizzi;
    }


    /**
     * Gets the p_Handle value for this Norm_Indirizzo_multiInputParams.
     * 
     * @return p_Handle
     */
    public java.lang.String getP_Handle() {
        return p_Handle;
    }


    /**
     * Sets the p_Handle value for this Norm_Indirizzo_multiInputParams.
     * 
     * @param p_Handle
     */
    public void setP_Handle(java.lang.String p_Handle) {
        this.p_Handle = p_Handle;
    }


    /**
     * Gets the p_Sep_Param_Char value for this Norm_Indirizzo_multiInputParams.
     * 
     * @return p_Sep_Param_Char
     */
    public java.lang.String getP_Sep_Param_Char() {
        return p_Sep_Param_Char;
    }


    /**
     * Sets the p_Sep_Param_Char value for this Norm_Indirizzo_multiInputParams.
     * 
     * @param p_Sep_Param_Char
     */
    public void setP_Sep_Param_Char(java.lang.String p_Sep_Param_Char) {
        this.p_Sep_Param_Char = p_Sep_Param_Char;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_Indirizzo_multiInputParams)) return false;
        Norm_Indirizzo_multiInputParams other = (Norm_Indirizzo_multiInputParams) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.p_Sep_Ind_Char==null && other.getP_Sep_Ind_Char()==null) || 
             (this.p_Sep_Ind_Char!=null &&
              this.p_Sep_Ind_Char.equals(other.getP_Sep_Ind_Char()))) &&
            ((this.p_Indirizzi==null && other.getP_Indirizzi()==null) || 
             (this.p_Indirizzi!=null &&
              java.util.Arrays.equals(this.p_Indirizzi, other.getP_Indirizzi()))) &&
            ((this.p_Handle==null && other.getP_Handle()==null) || 
             (this.p_Handle!=null &&
              this.p_Handle.equals(other.getP_Handle()))) &&
            ((this.p_Sep_Param_Char==null && other.getP_Sep_Param_Char()==null) || 
             (this.p_Sep_Param_Char!=null &&
              this.p_Sep_Param_Char.equals(other.getP_Sep_Param_Char())));
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
        if (getP_Sep_Ind_Char() != null) {
            _hashCode += getP_Sep_Ind_Char().hashCode();
        }
        if (getP_Indirizzi() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getP_Indirizzi());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getP_Indirizzi(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getP_Handle() != null) {
            _hashCode += getP_Handle().hashCode();
        }
        if (getP_Sep_Param_Char() != null) {
            _hashCode += getP_Sep_Param_Char().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_Indirizzo_multiInputParams.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_multiInputParams"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_Sep_Ind_Char");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_Sep_Ind_Char"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_Indirizzi");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_Indirizzi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_Handle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_Handle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_Sep_Param_Char");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_Sep_Param_Char"));
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
