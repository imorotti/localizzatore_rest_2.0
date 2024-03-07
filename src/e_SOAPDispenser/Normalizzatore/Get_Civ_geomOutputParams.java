/**
 * Get_Civ_geomOutputParams.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Get_Civ_geomOutputParams  implements java.io.Serializable {
    private java.lang.Long p_RESULT_CODE;
    private java.math.BigDecimal p_CIVICO_Y;
    private java.math.BigDecimal p_CIVICO_X;

    public Get_Civ_geomOutputParams() {
    }

    public Get_Civ_geomOutputParams(
           java.lang.Long p_RESULT_CODE,
           java.math.BigDecimal p_CIVICO_Y,
           java.math.BigDecimal p_CIVICO_X) {
           this.p_RESULT_CODE = p_RESULT_CODE;
           this.p_CIVICO_Y = p_CIVICO_Y;
           this.p_CIVICO_X = p_CIVICO_X;
    }


    /**
     * Gets the p_RESULT_CODE value for this Get_Civ_geomOutputParams.
     * 
     * @return p_RESULT_CODE
     */
    public java.lang.Long getP_RESULT_CODE() {
        return p_RESULT_CODE;
    }


    /**
     * Sets the p_RESULT_CODE value for this Get_Civ_geomOutputParams.
     * 
     * @param p_RESULT_CODE
     */
    public void setP_RESULT_CODE(java.lang.Long p_RESULT_CODE) {
        this.p_RESULT_CODE = p_RESULT_CODE;
    }


    /**
     * Gets the p_CIVICO_Y value for this Get_Civ_geomOutputParams.
     * 
     * @return p_CIVICO_Y
     */
    public java.math.BigDecimal getP_CIVICO_Y() {
        return p_CIVICO_Y;
    }


    /**
     * Sets the p_CIVICO_Y value for this Get_Civ_geomOutputParams.
     * 
     * @param p_CIVICO_Y
     */
    public void setP_CIVICO_Y(java.math.BigDecimal p_CIVICO_Y) {
        this.p_CIVICO_Y = p_CIVICO_Y;
    }


    /**
     * Gets the p_CIVICO_X value for this Get_Civ_geomOutputParams.
     * 
     * @return p_CIVICO_X
     */
    public java.math.BigDecimal getP_CIVICO_X() {
        return p_CIVICO_X;
    }


    /**
     * Sets the p_CIVICO_X value for this Get_Civ_geomOutputParams.
     * 
     * @param p_CIVICO_X
     */
    public void setP_CIVICO_X(java.math.BigDecimal p_CIVICO_X) {
        this.p_CIVICO_X = p_CIVICO_X;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Get_Civ_geomOutputParams)) return false;
        Get_Civ_geomOutputParams other = (Get_Civ_geomOutputParams) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.p_RESULT_CODE==null && other.getP_RESULT_CODE()==null) || 
             (this.p_RESULT_CODE!=null &&
              this.p_RESULT_CODE.equals(other.getP_RESULT_CODE()))) &&
            ((this.p_CIVICO_Y==null && other.getP_CIVICO_Y()==null) || 
             (this.p_CIVICO_Y!=null &&
              this.p_CIVICO_Y.equals(other.getP_CIVICO_Y()))) &&
            ((this.p_CIVICO_X==null && other.getP_CIVICO_X()==null) || 
             (this.p_CIVICO_X!=null &&
              this.p_CIVICO_X.equals(other.getP_CIVICO_X())));
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
        if (getP_RESULT_CODE() != null) {
            _hashCode += getP_RESULT_CODE().hashCode();
        }
        if (getP_CIVICO_Y() != null) {
            _hashCode += getP_CIVICO_Y().hashCode();
        }
        if (getP_CIVICO_X() != null) {
            _hashCode += getP_CIVICO_X().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Get_Civ_geomOutputParams.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Civ_geomOutputParams"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_RESULT_CODE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_RESULT_CODE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_CIVICO_Y");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_CIVICO_Y"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_CIVICO_X");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_CIVICO_X"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
