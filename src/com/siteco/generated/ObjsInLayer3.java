/**
 * ObjsInLayer3.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package com.siteco.generated;

public class ObjsInLayer3  implements java.io.Serializable {
    private java.lang.String[] fields;
    private java.lang.String mtag;
    private java.lang.String name;
    private java.lang.String[][] values;

    public ObjsInLayer3() {
    }

    public ObjsInLayer3(
           java.lang.String[] fields,
           java.lang.String mtag,
           java.lang.String name,
           java.lang.String[][] values) {
           this.fields = fields;
           this.mtag = mtag;
           this.name = name;
           this.values = values;
    }


    /**
     * Gets the fields value for this ObjsInLayer3.
     * 
     * @return fields
     */
    public java.lang.String[] getFields() {
        return fields;
    }


    /**
     * Sets the fields value for this ObjsInLayer3.
     * 
     * @param fields
     */
    public void setFields(java.lang.String[] fields) {
        this.fields = fields;
    }


    /**
     * Gets the mtag value for this ObjsInLayer3.
     * 
     * @return mtag
     */
    public java.lang.String getMtag() {
        return mtag;
    }


    /**
     * Sets the mtag value for this ObjsInLayer3.
     * 
     * @param mtag
     */
    public void setMtag(java.lang.String mtag) {
        this.mtag = mtag;
    }


    /**
     * Gets the name value for this ObjsInLayer3.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this ObjsInLayer3.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the values value for this ObjsInLayer3.
     * 
     * @return values
     */
    public java.lang.String[][] getValues() {
        return values;
    }


    /**
     * Sets the values value for this ObjsInLayer3.
     * 
     * @param values
     */
    public void setValues(java.lang.String[][] values) {
        this.values = values;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObjsInLayer3)) return false;
        ObjsInLayer3 other = (ObjsInLayer3) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fields==null && other.getFields()==null) || 
             (this.fields!=null &&
              java.util.Arrays.equals(this.fields, other.getFields()))) &&
            ((this.mtag==null && other.getMtag()==null) || 
             (this.mtag!=null &&
              this.mtag.equals(other.getMtag()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.values==null && other.getValues()==null) || 
             (this.values!=null &&
              java.util.Arrays.equals(this.values, other.getValues())));
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
        if (getFields() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFields());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFields(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMtag() != null) {
            _hashCode += getMtag().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getValues() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getValues());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getValues(), i);
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
        new org.apache.axis.description.TypeDesc(ObjsInLayer3.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://siteco.com", "ObjsInLayer3"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fields");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "fields"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://siteco.com", "objs"));
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
        elemField.setFieldName("values");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "values"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://siteco.com", "ArrayOfString"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://siteco.com", "objs"));
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
