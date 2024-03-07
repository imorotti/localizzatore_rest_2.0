/**
 * Simbologia.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package com.siteco.generated;

public class Simbologia  implements java.io.Serializable {
    private java.lang.String heading;
    private boolean isGroupLayer;
    private java.lang.String parentLayerId;
    private com.siteco.generated.Simbolo[] simboli;

    public Simbologia() {
    }

    public Simbologia(
           java.lang.String heading,
           boolean isGroupLayer,
           java.lang.String parentLayerId,
           com.siteco.generated.Simbolo[] simboli) {
           this.heading = heading;
           this.isGroupLayer = isGroupLayer;
           this.parentLayerId = parentLayerId;
           this.simboli = simboli;
    }


    /**
     * Gets the heading value for this Simbologia.
     * 
     * @return heading
     */
    public java.lang.String getHeading() {
        return heading;
    }


    /**
     * Sets the heading value for this Simbologia.
     * 
     * @param heading
     */
    public void setHeading(java.lang.String heading) {
        this.heading = heading;
    }


    /**
     * Gets the isGroupLayer value for this Simbologia.
     * 
     * @return isGroupLayer
     */
    public boolean isIsGroupLayer() {
        return isGroupLayer;
    }


    /**
     * Sets the isGroupLayer value for this Simbologia.
     * 
     * @param isGroupLayer
     */
    public void setIsGroupLayer(boolean isGroupLayer) {
        this.isGroupLayer = isGroupLayer;
    }


    /**
     * Gets the parentLayerId value for this Simbologia.
     * 
     * @return parentLayerId
     */
    public java.lang.String getParentLayerId() {
        return parentLayerId;
    }


    /**
     * Sets the parentLayerId value for this Simbologia.
     * 
     * @param parentLayerId
     */
    public void setParentLayerId(java.lang.String parentLayerId) {
        this.parentLayerId = parentLayerId;
    }


    /**
     * Gets the simboli value for this Simbologia.
     * 
     * @return simboli
     */
    public com.siteco.generated.Simbolo[] getSimboli() {
        return simboli;
    }


    /**
     * Sets the simboli value for this Simbologia.
     * 
     * @param simboli
     */
    public void setSimboli(com.siteco.generated.Simbolo[] simboli) {
        this.simboli = simboli;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Simbologia)) return false;
        Simbologia other = (Simbologia) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.heading==null && other.getHeading()==null) || 
             (this.heading!=null &&
              this.heading.equals(other.getHeading()))) &&
            this.isGroupLayer == other.isIsGroupLayer() &&
            ((this.parentLayerId==null && other.getParentLayerId()==null) || 
             (this.parentLayerId!=null &&
              this.parentLayerId.equals(other.getParentLayerId()))) &&
            ((this.simboli==null && other.getSimboli()==null) || 
             (this.simboli!=null &&
              java.util.Arrays.equals(this.simboli, other.getSimboli())));
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
        if (getHeading() != null) {
            _hashCode += getHeading().hashCode();
        }
        _hashCode += (isIsGroupLayer() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getParentLayerId() != null) {
            _hashCode += getParentLayerId().hashCode();
        }
        if (getSimboli() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSimboli());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSimboli(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Simbologia.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://siteco.com", "Simbologia"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("heading");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "heading"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isGroupLayer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "isGroupLayer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parentLayerId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "parentLayerId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("simboli");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "simboli"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://siteco.com", "Simbolo"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://siteco.com", "sim"));
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
