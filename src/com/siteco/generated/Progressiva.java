/**
 * Progressiva.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package com.siteco.generated;

public class Progressiva  implements java.io.Serializable {
    private double XPro;
    private double YPro;
    private double m;
    private double offset;
    private java.lang.String road_id;

    public Progressiva() {
    }

    public Progressiva(
           double XPro,
           double YPro,
           double m,
           double offset,
           java.lang.String road_id) {
           this.XPro = XPro;
           this.YPro = YPro;
           this.m = m;
           this.offset = offset;
           this.road_id = road_id;
    }


    /**
     * Gets the XPro value for this Progressiva.
     * 
     * @return XPro
     */
    public double getXPro() {
        return XPro;
    }


    /**
     * Sets the XPro value for this Progressiva.
     * 
     * @param XPro
     */
    public void setXPro(double XPro) {
        this.XPro = XPro;
    }


    /**
     * Gets the YPro value for this Progressiva.
     * 
     * @return YPro
     */
    public double getYPro() {
        return YPro;
    }


    /**
     * Sets the YPro value for this Progressiva.
     * 
     * @param YPro
     */
    public void setYPro(double YPro) {
        this.YPro = YPro;
    }


    /**
     * Gets the m value for this Progressiva.
     * 
     * @return m
     */
    public double getM() {
        return m;
    }


    /**
     * Sets the m value for this Progressiva.
     * 
     * @param m
     */
    public void setM(double m) {
        this.m = m;
    }


    /**
     * Gets the offset value for this Progressiva.
     * 
     * @return offset
     */
    public double getOffset() {
        return offset;
    }


    /**
     * Sets the offset value for this Progressiva.
     * 
     * @param offset
     */
    public void setOffset(double offset) {
        this.offset = offset;
    }


    /**
     * Gets the road_id value for this Progressiva.
     * 
     * @return road_id
     */
    public java.lang.String getRoad_id() {
        return road_id;
    }


    /**
     * Sets the road_id value for this Progressiva.
     * 
     * @param road_id
     */
    public void setRoad_id(java.lang.String road_id) {
        this.road_id = road_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Progressiva)) return false;
        Progressiva other = (Progressiva) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.XPro == other.getXPro() &&
            this.YPro == other.getYPro() &&
            this.m == other.getM() &&
            this.offset == other.getOffset() &&
            ((this.road_id==null && other.getRoad_id()==null) || 
             (this.road_id!=null &&
              this.road_id.equals(other.getRoad_id())));
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
        _hashCode += new Double(getXPro()).hashCode();
        _hashCode += new Double(getYPro()).hashCode();
        _hashCode += new Double(getM()).hashCode();
        _hashCode += new Double(getOffset()).hashCode();
        if (getRoad_id() != null) {
            _hashCode += getRoad_id().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Progressiva.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://siteco.com", "Progressiva"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("XPro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "XPro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("YPro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "YPro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "m"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("offset");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "offset"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("road_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "road_id"));
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
