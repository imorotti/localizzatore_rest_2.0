/**
 * GenMap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package com.siteco.generated;

public class GenMap  implements java.io.Serializable {
    private java.lang.String connString;
    private java.lang.String dirVirtualeLegenda;
    private java.lang.String ipPubblico;
    private int mapServerType;
    private com.siteco.generated.GenEnvelope originalEnvelope;
    private java.lang.String pathFisicoDirVirtuale;
    private java.lang.String service;
    private int xLeg;
    private int yLeg;
    private boolean queryDone;

    public GenMap() {
    }

    public GenMap(
           java.lang.String connString,
           java.lang.String dirVirtualeLegenda,
           java.lang.String ipPubblico,
           int mapServerType,
           com.siteco.generated.GenEnvelope originalEnvelope,
           java.lang.String pathFisicoDirVirtuale,
           java.lang.String service,
           int xLeg,
           int yLeg,
           boolean queryDone) {
           this.connString = connString;
           this.dirVirtualeLegenda = dirVirtualeLegenda;
           this.ipPubblico = ipPubblico;
           this.mapServerType = mapServerType;
           this.originalEnvelope = originalEnvelope;
           this.pathFisicoDirVirtuale = pathFisicoDirVirtuale;
           this.service = service;
           this.xLeg = xLeg;
           this.yLeg = yLeg;
           this.queryDone = queryDone;
    }


    /**
     * Gets the connString value for this GenMap.
     * 
     * @return connString
     */
    public java.lang.String getConnString() {
        return connString;
    }


    /**
     * Sets the connString value for this GenMap.
     * 
     * @param connString
     */
    public void setConnString(java.lang.String connString) {
        this.connString = connString;
    }


    /**
     * Gets the dirVirtualeLegenda value for this GenMap.
     * 
     * @return dirVirtualeLegenda
     */
    public java.lang.String getDirVirtualeLegenda() {
        return dirVirtualeLegenda;
    }


    /**
     * Sets the dirVirtualeLegenda value for this GenMap.
     * 
     * @param dirVirtualeLegenda
     */
    public void setDirVirtualeLegenda(java.lang.String dirVirtualeLegenda) {
        this.dirVirtualeLegenda = dirVirtualeLegenda;
    }


    /**
     * Gets the ipPubblico value for this GenMap.
     * 
     * @return ipPubblico
     */
    public java.lang.String getIpPubblico() {
        return ipPubblico;
    }


    /**
     * Sets the ipPubblico value for this GenMap.
     * 
     * @param ipPubblico
     */
    public void setIpPubblico(java.lang.String ipPubblico) {
        this.ipPubblico = ipPubblico;
    }


    /**
     * Gets the mapServerType value for this GenMap.
     * 
     * @return mapServerType
     */
    public int getMapServerType() {
        return mapServerType;
    }


    /**
     * Sets the mapServerType value for this GenMap.
     * 
     * @param mapServerType
     */
    public void setMapServerType(int mapServerType) {
        this.mapServerType = mapServerType;
    }


    /**
     * Gets the originalEnvelope value for this GenMap.
     * 
     * @return originalEnvelope
     */
    public com.siteco.generated.GenEnvelope getOriginalEnvelope() {
        return originalEnvelope;
    }


    /**
     * Sets the originalEnvelope value for this GenMap.
     * 
     * @param originalEnvelope
     */
    public void setOriginalEnvelope(com.siteco.generated.GenEnvelope originalEnvelope) {
        this.originalEnvelope = originalEnvelope;
    }


    /**
     * Gets the pathFisicoDirVirtuale value for this GenMap.
     * 
     * @return pathFisicoDirVirtuale
     */
    public java.lang.String getPathFisicoDirVirtuale() {
        return pathFisicoDirVirtuale;
    }


    /**
     * Sets the pathFisicoDirVirtuale value for this GenMap.
     * 
     * @param pathFisicoDirVirtuale
     */
    public void setPathFisicoDirVirtuale(java.lang.String pathFisicoDirVirtuale) {
        this.pathFisicoDirVirtuale = pathFisicoDirVirtuale;
    }


    /**
     * Gets the service value for this GenMap.
     * 
     * @return service
     */
    public java.lang.String getService() {
        return service;
    }


    /**
     * Sets the service value for this GenMap.
     * 
     * @param service
     */
    public void setService(java.lang.String service) {
        this.service = service;
    }


    /**
     * Gets the xLeg value for this GenMap.
     * 
     * @return xLeg
     */
    public int getXLeg() {
        return xLeg;
    }


    /**
     * Sets the xLeg value for this GenMap.
     * 
     * @param xLeg
     */
    public void setXLeg(int xLeg) {
        this.xLeg = xLeg;
    }


    /**
     * Gets the yLeg value for this GenMap.
     * 
     * @return yLeg
     */
    public int getYLeg() {
        return yLeg;
    }


    /**
     * Sets the yLeg value for this GenMap.
     * 
     * @param yLeg
     */
    public void setYLeg(int yLeg) {
        this.yLeg = yLeg;
    }


    /**
     * Gets the queryDone value for this GenMap.
     * 
     * @return queryDone
     */
    public boolean isQueryDone() {
        return queryDone;
    }


    /**
     * Sets the queryDone value for this GenMap.
     * 
     * @param queryDone
     */
    public void setQueryDone(boolean queryDone) {
        this.queryDone = queryDone;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GenMap)) return false;
        GenMap other = (GenMap) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.connString==null && other.getConnString()==null) || 
             (this.connString!=null &&
              this.connString.equals(other.getConnString()))) &&
            ((this.dirVirtualeLegenda==null && other.getDirVirtualeLegenda()==null) || 
             (this.dirVirtualeLegenda!=null &&
              this.dirVirtualeLegenda.equals(other.getDirVirtualeLegenda()))) &&
            ((this.ipPubblico==null && other.getIpPubblico()==null) || 
             (this.ipPubblico!=null &&
              this.ipPubblico.equals(other.getIpPubblico()))) &&
            this.mapServerType == other.getMapServerType() &&
            ((this.originalEnvelope==null && other.getOriginalEnvelope()==null) || 
             (this.originalEnvelope!=null &&
              this.originalEnvelope.equals(other.getOriginalEnvelope()))) &&
            ((this.pathFisicoDirVirtuale==null && other.getPathFisicoDirVirtuale()==null) || 
             (this.pathFisicoDirVirtuale!=null &&
              this.pathFisicoDirVirtuale.equals(other.getPathFisicoDirVirtuale()))) &&
            ((this.service==null && other.getService()==null) || 
             (this.service!=null &&
              this.service.equals(other.getService()))) &&
            this.xLeg == other.getXLeg() &&
            this.yLeg == other.getYLeg() &&
            this.queryDone == other.isQueryDone();
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
        if (getConnString() != null) {
            _hashCode += getConnString().hashCode();
        }
        if (getDirVirtualeLegenda() != null) {
            _hashCode += getDirVirtualeLegenda().hashCode();
        }
        if (getIpPubblico() != null) {
            _hashCode += getIpPubblico().hashCode();
        }
        _hashCode += getMapServerType();
        if (getOriginalEnvelope() != null) {
            _hashCode += getOriginalEnvelope().hashCode();
        }
        if (getPathFisicoDirVirtuale() != null) {
            _hashCode += getPathFisicoDirVirtuale().hashCode();
        }
        if (getService() != null) {
            _hashCode += getService().hashCode();
        }
        _hashCode += getXLeg();
        _hashCode += getYLeg();
        _hashCode += (isQueryDone() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GenMap.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://siteco.com", "GenMap"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("connString");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "connString"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dirVirtualeLegenda");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "dirVirtualeLegenda"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ipPubblico");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "ipPubblico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mapServerType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "mapServerType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originalEnvelope");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "originalEnvelope"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://siteco.com", "GenEnvelope"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pathFisicoDirVirtuale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "pathFisicoDirVirtuale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("service");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "service"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("XLeg");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "xLeg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("YLeg");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "yLeg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("queryDone");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "queryDone"));
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
