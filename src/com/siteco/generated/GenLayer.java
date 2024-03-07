/**
 * GenLayer.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package com.siteco.generated;

public class GenLayer  implements java.io.Serializable {
    private double maxScale;
    private double minScale;
    private java.lang.String mtag;
    private java.lang.String name;
    private com.siteco.generated.Simbologia simbologia;
    private java.lang.String symbol;
    private java.lang.String type;
    private boolean visible;

    public GenLayer() {
    }

    public GenLayer(
           double maxScale,
           double minScale,
           java.lang.String mtag,
           java.lang.String name,
           com.siteco.generated.Simbologia simbologia,
           java.lang.String symbol,
           java.lang.String type,
           boolean visible) {
           this.maxScale = maxScale;
           this.minScale = minScale;
           this.mtag = mtag;
           this.name = name;
           this.simbologia = simbologia;
           this.symbol = symbol;
           this.type = type;
           this.visible = visible;
    }


    /**
     * Gets the maxScale value for this GenLayer.
     * 
     * @return maxScale
     */
    public double getMaxScale() {
        return maxScale;
    }


    /**
     * Sets the maxScale value for this GenLayer.
     * 
     * @param maxScale
     */
    public void setMaxScale(double maxScale) {
        this.maxScale = maxScale;
    }


    /**
     * Gets the minScale value for this GenLayer.
     * 
     * @return minScale
     */
    public double getMinScale() {
        return minScale;
    }


    /**
     * Sets the minScale value for this GenLayer.
     * 
     * @param minScale
     */
    public void setMinScale(double minScale) {
        this.minScale = minScale;
    }


    /**
     * Gets the mtag value for this GenLayer.
     * 
     * @return mtag
     */
    public java.lang.String getMtag() {
        return mtag;
    }


    /**
     * Sets the mtag value for this GenLayer.
     * 
     * @param mtag
     */
    public void setMtag(java.lang.String mtag) {
        this.mtag = mtag;
    }


    /**
     * Gets the name value for this GenLayer.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this GenLayer.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the simbologia value for this GenLayer.
     * 
     * @return simbologia
     */
    public com.siteco.generated.Simbologia getSimbologia() {
        return simbologia;
    }


    /**
     * Sets the simbologia value for this GenLayer.
     * 
     * @param simbologia
     */
    public void setSimbologia(com.siteco.generated.Simbologia simbologia) {
        this.simbologia = simbologia;
    }


    /**
     * Gets the symbol value for this GenLayer.
     * 
     * @return symbol
     */
    public java.lang.String getSymbol() {
        return symbol;
    }


    /**
     * Sets the symbol value for this GenLayer.
     * 
     * @param symbol
     */
    public void setSymbol(java.lang.String symbol) {
        this.symbol = symbol;
    }


    /**
     * Gets the type value for this GenLayer.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this GenLayer.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }


    /**
     * Gets the visible value for this GenLayer.
     * 
     * @return visible
     */
    public boolean isVisible() {
        return visible;
    }


    /**
     * Sets the visible value for this GenLayer.
     * 
     * @param visible
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GenLayer)) return false;
        GenLayer other = (GenLayer) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.maxScale == other.getMaxScale() &&
            this.minScale == other.getMinScale() &&
            ((this.mtag==null && other.getMtag()==null) || 
             (this.mtag!=null &&
              this.mtag.equals(other.getMtag()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.simbologia==null && other.getSimbologia()==null) || 
             (this.simbologia!=null &&
              this.simbologia.equals(other.getSimbologia()))) &&
            ((this.symbol==null && other.getSymbol()==null) || 
             (this.symbol!=null &&
              this.symbol.equals(other.getSymbol()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            this.visible == other.isVisible();
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
        _hashCode += new Double(getMaxScale()).hashCode();
        _hashCode += new Double(getMinScale()).hashCode();
        if (getMtag() != null) {
            _hashCode += getMtag().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getSimbologia() != null) {
            _hashCode += getSimbologia().hashCode();
        }
        if (getSymbol() != null) {
            _hashCode += getSymbol().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        _hashCode += (isVisible() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GenLayer.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://siteco.com", "GenLayer"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxScale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "maxScale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("minScale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "minScale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mtag");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "mtag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("simbologia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "simbologia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://siteco.com", "Simbologia"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("symbol");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "symbol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("visible");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "visible"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
