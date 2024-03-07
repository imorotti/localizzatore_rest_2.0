/**
 * Get_Tipo_CoordOutputRecordset.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Get_Tipo_CoordOutputRecordset  implements java.io.Serializable {
    private java.lang.String TIPO_COORD_COD;
    private java.lang.String TIPO_COORD_DES;

    public Get_Tipo_CoordOutputRecordset() {
    }

    public Get_Tipo_CoordOutputRecordset(
           java.lang.String TIPO_COORD_COD,
           java.lang.String TIPO_COORD_DES) {
           this.TIPO_COORD_COD = TIPO_COORD_COD;
           this.TIPO_COORD_DES = TIPO_COORD_DES;
    }


    /**
     * Gets the TIPO_COORD_COD value for this Get_Tipo_CoordOutputRecordset.
     * 
     * @return TIPO_COORD_COD
     */
    public java.lang.String getTIPO_COORD_COD() {
        return TIPO_COORD_COD;
    }


    /**
     * Sets the TIPO_COORD_COD value for this Get_Tipo_CoordOutputRecordset.
     * 
     * @param TIPO_COORD_COD
     */
    public void setTIPO_COORD_COD(java.lang.String TIPO_COORD_COD) {
        this.TIPO_COORD_COD = TIPO_COORD_COD;
    }


    /**
     * Gets the TIPO_COORD_DES value for this Get_Tipo_CoordOutputRecordset.
     * 
     * @return TIPO_COORD_DES
     */
    public java.lang.String getTIPO_COORD_DES() {
        return TIPO_COORD_DES;
    }


    /**
     * Sets the TIPO_COORD_DES value for this Get_Tipo_CoordOutputRecordset.
     * 
     * @param TIPO_COORD_DES
     */
    public void setTIPO_COORD_DES(java.lang.String TIPO_COORD_DES) {
        this.TIPO_COORD_DES = TIPO_COORD_DES;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Get_Tipo_CoordOutputRecordset)) return false;
        Get_Tipo_CoordOutputRecordset other = (Get_Tipo_CoordOutputRecordset) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.TIPO_COORD_COD==null && other.getTIPO_COORD_COD()==null) || 
             (this.TIPO_COORD_COD!=null &&
              this.TIPO_COORD_COD.equals(other.getTIPO_COORD_COD()))) &&
            ((this.TIPO_COORD_DES==null && other.getTIPO_COORD_DES()==null) || 
             (this.TIPO_COORD_DES!=null &&
              this.TIPO_COORD_DES.equals(other.getTIPO_COORD_DES())));
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
        if (getTIPO_COORD_COD() != null) {
            _hashCode += getTIPO_COORD_COD().hashCode();
        }
        if (getTIPO_COORD_DES() != null) {
            _hashCode += getTIPO_COORD_DES().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Get_Tipo_CoordOutputRecordset.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Tipo_CoordOutputRecordset"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TIPO_COORD_COD");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "TIPO_COORD_COD"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TIPO_COORD_DES");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "TIPO_COORD_DES"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
