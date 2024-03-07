/**
 * ObjsInLayer.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package com.siteco.generated;

public class ObjsInLayer  implements java.io.Serializable {
    private java.lang.String mtag;
    private java.lang.String name;
    private int[] objs;

    public ObjsInLayer() {
    }

    public ObjsInLayer(
           java.lang.String mtag,
           java.lang.String name,
           int[] objs) {
           this.mtag = mtag;
           this.name = name;
           this.objs = objs;
    }


    /**
     * Gets the mtag value for this ObjsInLayer.
     * 
     * @return mtag
     */
    public java.lang.String getMtag() {
        return mtag;
    }


    /**
     * Sets the mtag value for this ObjsInLayer.
     * 
     * @param mtag
     */
    public void setMtag(java.lang.String mtag) {
        this.mtag = mtag;
    }


    /**
     * Gets the name value for this ObjsInLayer.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this ObjsInLayer.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the objs value for this ObjsInLayer.
     * 
     * @return objs
     */
    public int[] getObjs() {
        return objs;
    }


    /**
     * Sets the objs value for this ObjsInLayer.
     * 
     * @param objs
     */
    public void setObjs(int[] objs) {
        this.objs = objs;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObjsInLayer)) return false;
        ObjsInLayer other = (ObjsInLayer) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.mtag==null && other.getMtag()==null) || 
             (this.mtag!=null &&
              this.mtag.equals(other.getMtag()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.objs==null && other.getObjs()==null) || 
             (this.objs!=null &&
              java.util.Arrays.equals(this.objs, other.getObjs())));
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
        if (getMtag() != null) {
            _hashCode += getMtag().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getObjs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getObjs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getObjs(), i);
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
        new org.apache.axis.description.TypeDesc(ObjsInLayer.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://siteco.com", "ObjsInLayer"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("objs");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "objs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
