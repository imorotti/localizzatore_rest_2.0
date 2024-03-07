/**
 * GenEnvelope.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package com.siteco.generated;

public class GenEnvelope  implements java.io.Serializable {
    private double maxX;
    private double maxY;
    private double minX;
    private double minY;

    public GenEnvelope() {
    }

    public GenEnvelope(
           double maxX,
           double maxY,
           double minX,
           double minY) {
           this.maxX = maxX;
           this.maxY = maxY;
           this.minX = minX;
           this.minY = minY;
    }


    /**
     * Gets the maxX value for this GenEnvelope.
     * 
     * @return maxX
     */
    public double getMaxX() {
        return maxX;
    }


    /**
     * Sets the maxX value for this GenEnvelope.
     * 
     * @param maxX
     */
    public void setMaxX(double maxX) {
        this.maxX = maxX;
    }


    /**
     * Gets the maxY value for this GenEnvelope.
     * 
     * @return maxY
     */
    public double getMaxY() {
        return maxY;
    }


    /**
     * Sets the maxY value for this GenEnvelope.
     * 
     * @param maxY
     */
    public void setMaxY(double maxY) {
        this.maxY = maxY;
    }


    /**
     * Gets the minX value for this GenEnvelope.
     * 
     * @return minX
     */
    public double getMinX() {
        return minX;
    }


    /**
     * Sets the minX value for this GenEnvelope.
     * 
     * @param minX
     */
    public void setMinX(double minX) {
        this.minX = minX;
    }


    /**
     * Gets the minY value for this GenEnvelope.
     * 
     * @return minY
     */
    public double getMinY() {
        return minY;
    }


    /**
     * Sets the minY value for this GenEnvelope.
     * 
     * @param minY
     */
    public void setMinY(double minY) {
        this.minY = minY;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GenEnvelope)) return false;
        GenEnvelope other = (GenEnvelope) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.maxX == other.getMaxX() &&
            this.maxY == other.getMaxY() &&
            this.minX == other.getMinX() &&
            this.minY == other.getMinY();
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
        _hashCode += new Double(getMaxX()).hashCode();
        _hashCode += new Double(getMaxY()).hashCode();
        _hashCode += new Double(getMinX()).hashCode();
        _hashCode += new Double(getMinY()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GenEnvelope.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://siteco.com", "GenEnvelope"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxX");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "maxX"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxY");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "maxY"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("minX");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "minX"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("minY");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "minY"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
