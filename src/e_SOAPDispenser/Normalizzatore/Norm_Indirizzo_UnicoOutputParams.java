/**
 * Norm_Indirizzo_UnicoOutputParams.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_Indirizzo_UnicoOutputParams  implements java.io.Serializable {
    private java.lang.Long p_Result_code;

    public Norm_Indirizzo_UnicoOutputParams() {
    }

    public Norm_Indirizzo_UnicoOutputParams(
           java.lang.Long p_Result_code) {
           this.p_Result_code = p_Result_code;
    }


    /**
     * Gets the p_Result_code value for this Norm_Indirizzo_UnicoOutputParams.
     * 
     * @return p_Result_code
     */
    public java.lang.Long getP_Result_code() {
        return p_Result_code;
    }


    /**
     * Sets the p_Result_code value for this Norm_Indirizzo_UnicoOutputParams.
     * 
     * @param p_Result_code
     */
    public void setP_Result_code(java.lang.Long p_Result_code) {
        this.p_Result_code = p_Result_code;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_Indirizzo_UnicoOutputParams)) return false;
        Norm_Indirizzo_UnicoOutputParams other = (Norm_Indirizzo_UnicoOutputParams) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.p_Result_code==null && other.getP_Result_code()==null) || 
             (this.p_Result_code!=null &&
              this.p_Result_code.equals(other.getP_Result_code())));
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
        if (getP_Result_code() != null) {
            _hashCode += getP_Result_code().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_Indirizzo_UnicoOutputParams.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_UnicoOutputParams"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_Result_code");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_Result_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
