/**
 * Particella.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package com.siteco.generated;

public class Particella  implements java.io.Serializable {
    private java.lang.String comune;
    private java.lang.String foglio;
    private java.lang.String mappale;

    public Particella() {
    }

    public Particella(
           java.lang.String comune,
           java.lang.String foglio,
           java.lang.String mappale) {
           this.comune = comune;
           this.foglio = foglio;
           this.mappale = mappale;
    }


    /**
     * Gets the comune value for this Particella.
     * 
     * @return comune
     */
    public java.lang.String getComune() {
        return comune;
    }


    /**
     * Sets the comune value for this Particella.
     * 
     * @param comune
     */
    public void setComune(java.lang.String comune) {
        this.comune = comune;
    }


    /**
     * Gets the foglio value for this Particella.
     * 
     * @return foglio
     */
    public java.lang.String getFoglio() {
        return foglio;
    }


    /**
     * Sets the foglio value for this Particella.
     * 
     * @param foglio
     */
    public void setFoglio(java.lang.String foglio) {
        this.foglio = foglio;
    }


    /**
     * Gets the mappale value for this Particella.
     * 
     * @return mappale
     */
    public java.lang.String getMappale() {
        return mappale;
    }


    /**
     * Sets the mappale value for this Particella.
     * 
     * @param mappale
     */
    public void setMappale(java.lang.String mappale) {
        this.mappale = mappale;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Particella)) return false;
        Particella other = (Particella) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.comune==null && other.getComune()==null) || 
             (this.comune!=null &&
              this.comune.equals(other.getComune()))) &&
            ((this.foglio==null && other.getFoglio()==null) || 
             (this.foglio!=null &&
              this.foglio.equals(other.getFoglio()))) &&
            ((this.mappale==null && other.getMappale()==null) || 
             (this.mappale!=null &&
              this.mappale.equals(other.getMappale())));
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
        if (getComune() != null) {
            _hashCode += getComune().hashCode();
        }
        if (getFoglio() != null) {
            _hashCode += getFoglio().hashCode();
        }
        if (getMappale() != null) {
            _hashCode += getMappale().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Particella.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://siteco.com", "Particella"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comune");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "comune"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("foglio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "foglio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mappale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "mappale"));
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
