/**
 * Get_Str_GeomInputParams.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Get_Str_GeomInputParams  implements java.io.Serializable {
    private java.lang.String p_HANDLE;
    private java.lang.String p_TIPO_COORD;
    private java.lang.String p_ENTITA_ID;

    public Get_Str_GeomInputParams() {
    }

    public Get_Str_GeomInputParams(
           java.lang.String p_HANDLE,
           java.lang.String p_TIPO_COORD,
           java.lang.String p_ENTITA_ID) {
           this.p_HANDLE = p_HANDLE;
           this.p_TIPO_COORD = p_TIPO_COORD;
           this.p_ENTITA_ID = p_ENTITA_ID;
    }


    /**
     * Gets the p_HANDLE value for this Get_Str_GeomInputParams.
     * 
     * @return p_HANDLE
     */
    public java.lang.String getP_HANDLE() {
        return p_HANDLE;
    }


    /**
     * Sets the p_HANDLE value for this Get_Str_GeomInputParams.
     * 
     * @param p_HANDLE
     */
    public void setP_HANDLE(java.lang.String p_HANDLE) {
        this.p_HANDLE = p_HANDLE;
    }


    /**
     * Gets the p_TIPO_COORD value for this Get_Str_GeomInputParams.
     * 
     * @return p_TIPO_COORD
     */
    public java.lang.String getP_TIPO_COORD() {
        return p_TIPO_COORD;
    }


    /**
     * Sets the p_TIPO_COORD value for this Get_Str_GeomInputParams.
     * 
     * @param p_TIPO_COORD
     */
    public void setP_TIPO_COORD(java.lang.String p_TIPO_COORD) {
        this.p_TIPO_COORD = p_TIPO_COORD;
    }


    /**
     * Gets the p_ENTITA_ID value for this Get_Str_GeomInputParams.
     * 
     * @return p_ENTITA_ID
     */
    public java.lang.String getP_ENTITA_ID() {
        return p_ENTITA_ID;
    }


    /**
     * Sets the p_ENTITA_ID value for this Get_Str_GeomInputParams.
     * 
     * @param p_ENTITA_ID
     */
    public void setP_ENTITA_ID(java.lang.String p_ENTITA_ID) {
        this.p_ENTITA_ID = p_ENTITA_ID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Get_Str_GeomInputParams)) return false;
        Get_Str_GeomInputParams other = (Get_Str_GeomInputParams) obj;
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
              this.p_HANDLE.equals(other.getP_HANDLE()))) &&
            ((this.p_TIPO_COORD==null && other.getP_TIPO_COORD()==null) || 
             (this.p_TIPO_COORD!=null &&
              this.p_TIPO_COORD.equals(other.getP_TIPO_COORD()))) &&
            ((this.p_ENTITA_ID==null && other.getP_ENTITA_ID()==null) || 
             (this.p_ENTITA_ID!=null &&
              this.p_ENTITA_ID.equals(other.getP_ENTITA_ID())));
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
        if (getP_TIPO_COORD() != null) {
            _hashCode += getP_TIPO_COORD().hashCode();
        }
        if (getP_ENTITA_ID() != null) {
            _hashCode += getP_ENTITA_ID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Get_Str_GeomInputParams.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Str_GeomInputParams"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_HANDLE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_HANDLE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_TIPO_COORD");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_TIPO_COORD"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_ENTITA_ID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_ENTITA_ID"));
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
