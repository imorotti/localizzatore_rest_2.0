/**
 * Get_Str_GeomOutputParams.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Get_Str_GeomOutputParams  implements java.io.Serializable {
    private java.lang.Long p_RESULT_CODE;
    private java.math.BigDecimal p_MAX_Y;
    private java.math.BigDecimal p_MAX_X;
    private java.math.BigDecimal p_MIN_Y;
    private java.math.BigDecimal p_MIN_X;
    private java.math.BigDecimal p_CENTR_Y;
    private java.math.BigDecimal p_CENTR_X;

    public Get_Str_GeomOutputParams() {
    }

    public Get_Str_GeomOutputParams(
           java.lang.Long p_RESULT_CODE,
           java.math.BigDecimal p_MAX_Y,
           java.math.BigDecimal p_MAX_X,
           java.math.BigDecimal p_MIN_Y,
           java.math.BigDecimal p_MIN_X,
           java.math.BigDecimal p_CENTR_Y,
           java.math.BigDecimal p_CENTR_X) {
           this.p_RESULT_CODE = p_RESULT_CODE;
           this.p_MAX_Y = p_MAX_Y;
           this.p_MAX_X = p_MAX_X;
           this.p_MIN_Y = p_MIN_Y;
           this.p_MIN_X = p_MIN_X;
           this.p_CENTR_Y = p_CENTR_Y;
           this.p_CENTR_X = p_CENTR_X;
    }


    /**
     * Gets the p_RESULT_CODE value for this Get_Str_GeomOutputParams.
     * 
     * @return p_RESULT_CODE
     */
    public java.lang.Long getP_RESULT_CODE() {
        return p_RESULT_CODE;
    }


    /**
     * Sets the p_RESULT_CODE value for this Get_Str_GeomOutputParams.
     * 
     * @param p_RESULT_CODE
     */
    public void setP_RESULT_CODE(java.lang.Long p_RESULT_CODE) {
        this.p_RESULT_CODE = p_RESULT_CODE;
    }


    /**
     * Gets the p_MAX_Y value for this Get_Str_GeomOutputParams.
     * 
     * @return p_MAX_Y
     */
    public java.math.BigDecimal getP_MAX_Y() {
        return p_MAX_Y;
    }


    /**
     * Sets the p_MAX_Y value for this Get_Str_GeomOutputParams.
     * 
     * @param p_MAX_Y
     */
    public void setP_MAX_Y(java.math.BigDecimal p_MAX_Y) {
        this.p_MAX_Y = p_MAX_Y;
    }


    /**
     * Gets the p_MAX_X value for this Get_Str_GeomOutputParams.
     * 
     * @return p_MAX_X
     */
    public java.math.BigDecimal getP_MAX_X() {
        return p_MAX_X;
    }


    /**
     * Sets the p_MAX_X value for this Get_Str_GeomOutputParams.
     * 
     * @param p_MAX_X
     */
    public void setP_MAX_X(java.math.BigDecimal p_MAX_X) {
        this.p_MAX_X = p_MAX_X;
    }


    /**
     * Gets the p_MIN_Y value for this Get_Str_GeomOutputParams.
     * 
     * @return p_MIN_Y
     */
    public java.math.BigDecimal getP_MIN_Y() {
        return p_MIN_Y;
    }


    /**
     * Sets the p_MIN_Y value for this Get_Str_GeomOutputParams.
     * 
     * @param p_MIN_Y
     */
    public void setP_MIN_Y(java.math.BigDecimal p_MIN_Y) {
        this.p_MIN_Y = p_MIN_Y;
    }


    /**
     * Gets the p_MIN_X value for this Get_Str_GeomOutputParams.
     * 
     * @return p_MIN_X
     */
    public java.math.BigDecimal getP_MIN_X() {
        return p_MIN_X;
    }


    /**
     * Sets the p_MIN_X value for this Get_Str_GeomOutputParams.
     * 
     * @param p_MIN_X
     */
    public void setP_MIN_X(java.math.BigDecimal p_MIN_X) {
        this.p_MIN_X = p_MIN_X;
    }


    /**
     * Gets the p_CENTR_Y value for this Get_Str_GeomOutputParams.
     * 
     * @return p_CENTR_Y
     */
    public java.math.BigDecimal getP_CENTR_Y() {
        return p_CENTR_Y;
    }


    /**
     * Sets the p_CENTR_Y value for this Get_Str_GeomOutputParams.
     * 
     * @param p_CENTR_Y
     */
    public void setP_CENTR_Y(java.math.BigDecimal p_CENTR_Y) {
        this.p_CENTR_Y = p_CENTR_Y;
    }


    /**
     * Gets the p_CENTR_X value for this Get_Str_GeomOutputParams.
     * 
     * @return p_CENTR_X
     */
    public java.math.BigDecimal getP_CENTR_X() {
        return p_CENTR_X;
    }


    /**
     * Sets the p_CENTR_X value for this Get_Str_GeomOutputParams.
     * 
     * @param p_CENTR_X
     */
    public void setP_CENTR_X(java.math.BigDecimal p_CENTR_X) {
        this.p_CENTR_X = p_CENTR_X;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Get_Str_GeomOutputParams)) return false;
        Get_Str_GeomOutputParams other = (Get_Str_GeomOutputParams) obj;
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
            ((this.p_MAX_Y==null && other.getP_MAX_Y()==null) || 
             (this.p_MAX_Y!=null &&
              this.p_MAX_Y.equals(other.getP_MAX_Y()))) &&
            ((this.p_MAX_X==null && other.getP_MAX_X()==null) || 
             (this.p_MAX_X!=null &&
              this.p_MAX_X.equals(other.getP_MAX_X()))) &&
            ((this.p_MIN_Y==null && other.getP_MIN_Y()==null) || 
             (this.p_MIN_Y!=null &&
              this.p_MIN_Y.equals(other.getP_MIN_Y()))) &&
            ((this.p_MIN_X==null && other.getP_MIN_X()==null) || 
             (this.p_MIN_X!=null &&
              this.p_MIN_X.equals(other.getP_MIN_X()))) &&
            ((this.p_CENTR_Y==null && other.getP_CENTR_Y()==null) || 
             (this.p_CENTR_Y!=null &&
              this.p_CENTR_Y.equals(other.getP_CENTR_Y()))) &&
            ((this.p_CENTR_X==null && other.getP_CENTR_X()==null) || 
             (this.p_CENTR_X!=null &&
              this.p_CENTR_X.equals(other.getP_CENTR_X())));
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
        if (getP_MAX_Y() != null) {
            _hashCode += getP_MAX_Y().hashCode();
        }
        if (getP_MAX_X() != null) {
            _hashCode += getP_MAX_X().hashCode();
        }
        if (getP_MIN_Y() != null) {
            _hashCode += getP_MIN_Y().hashCode();
        }
        if (getP_MIN_X() != null) {
            _hashCode += getP_MIN_X().hashCode();
        }
        if (getP_CENTR_Y() != null) {
            _hashCode += getP_CENTR_Y().hashCode();
        }
        if (getP_CENTR_X() != null) {
            _hashCode += getP_CENTR_X().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Get_Str_GeomOutputParams.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Str_GeomOutputParams"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_RESULT_CODE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_RESULT_CODE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_MAX_Y");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_MAX_Y"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_MAX_X");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_MAX_X"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_MIN_Y");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_MIN_Y"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_MIN_X");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_MIN_X"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_CENTR_Y");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_CENTR_Y"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_CENTR_X");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_CENTR_X"));
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
