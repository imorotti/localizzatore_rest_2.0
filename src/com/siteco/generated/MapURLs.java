/**
 * MapURLs.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package com.siteco.generated;

public class MapURLs  implements java.io.Serializable {
    private java.lang.String URLOverview;
    private java.lang.String errore;
    private java.lang.String urlLegend;
    private java.lang.String urlMap;
    private java.lang.String urlOverview;

    public MapURLs() {
    }

    public MapURLs(
           java.lang.String URLOverview,
           java.lang.String errore,
           java.lang.String urlLegend,
           java.lang.String urlMap,
           java.lang.String urlOverview) {
           this.URLOverview = URLOverview;
           this.errore = errore;
           this.urlLegend = urlLegend;
           this.urlMap = urlMap;
           this.urlOverview = urlOverview;
    }


    /**
     * Gets the URLOverview value for this MapURLs.
     * 
     * @return URLOverview
     */
    public java.lang.String getURLOverview() {
        return URLOverview;
    }


    /**
     * Sets the URLOverview value for this MapURLs.
     * 
     * @param URLOverview
     */
    public void setURLOverview(java.lang.String URLOverview) {
        this.URLOverview = URLOverview;
    }


    /**
     * Gets the errore value for this MapURLs.
     * 
     * @return errore
     */
    public java.lang.String getErrore() {
        return errore;
    }


    /**
     * Sets the errore value for this MapURLs.
     * 
     * @param errore
     */
    public void setErrore(java.lang.String errore) {
        this.errore = errore;
    }


    /**
     * Gets the urlLegend value for this MapURLs.
     * 
     * @return urlLegend
     */
    public java.lang.String getUrlLegend() {
        return urlLegend;
    }


    /**
     * Sets the urlLegend value for this MapURLs.
     * 
     * @param urlLegend
     */
    public void setUrlLegend(java.lang.String urlLegend) {
        this.urlLegend = urlLegend;
    }


    /**
     * Gets the urlMap value for this MapURLs.
     * 
     * @return urlMap
     */
    public java.lang.String getUrlMap() {
        return urlMap;
    }


    /**
     * Sets the urlMap value for this MapURLs.
     * 
     * @param urlMap
     */
    public void setUrlMap(java.lang.String urlMap) {
        this.urlMap = urlMap;
    }


    /**
     * Gets the urlOverview value for this MapURLs.
     * 
     * @return urlOverview
     */
    public java.lang.String getUrlOverview() {
        return urlOverview;
    }


    /**
     * Sets the urlOverview value for this MapURLs.
     * 
     * @param urlOverview
     */
    public void setUrlOverview(java.lang.String urlOverview) {
        this.urlOverview = urlOverview;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MapURLs)) return false;
        MapURLs other = (MapURLs) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.URLOverview==null && other.getURLOverview()==null) || 
             (this.URLOverview!=null &&
              this.URLOverview.equals(other.getURLOverview()))) &&
            ((this.errore==null && other.getErrore()==null) || 
             (this.errore!=null &&
              this.errore.equals(other.getErrore()))) &&
            ((this.urlLegend==null && other.getUrlLegend()==null) || 
             (this.urlLegend!=null &&
              this.urlLegend.equals(other.getUrlLegend()))) &&
            ((this.urlMap==null && other.getUrlMap()==null) || 
             (this.urlMap!=null &&
              this.urlMap.equals(other.getUrlMap()))) &&
            ((this.urlOverview==null && other.getUrlOverview()==null) || 
             (this.urlOverview!=null &&
              this.urlOverview.equals(other.getUrlOverview())));
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
        if (getURLOverview() != null) {
            _hashCode += getURLOverview().hashCode();
        }
        if (getErrore() != null) {
            _hashCode += getErrore().hashCode();
        }
        if (getUrlLegend() != null) {
            _hashCode += getUrlLegend().hashCode();
        }
        if (getUrlMap() != null) {
            _hashCode += getUrlMap().hashCode();
        }
        if (getUrlOverview() != null) {
            _hashCode += getUrlOverview().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MapURLs.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://siteco.com", "MapURLs"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("URLOverview");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "URLOverview"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errore");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "errore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("urlLegend");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "urlLegend"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("urlMap");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "urlMap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("urlOverview");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "urlOverview"));
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
