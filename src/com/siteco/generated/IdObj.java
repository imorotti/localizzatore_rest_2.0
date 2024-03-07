/**
 * IdObj.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package com.siteco.generated;

public class IdObj  implements java.io.Serializable {
    private long id;
    private java.lang.String layer;

    public IdObj() {
    }

    public IdObj(
           long id,
           java.lang.String layer) {
           this.id = id;
           this.layer = layer;
    }


    /**
     * Gets the id value for this IdObj.
     * 
     * @return id
     */
    public long getId() {
        return id;
    }


    /**
     * Sets the id value for this IdObj.
     * 
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }


    /**
     * Gets the layer value for this IdObj.
     * 
     * @return layer
     */
    public java.lang.String getLayer() {
        return layer;
    }


    /**
     * Sets the layer value for this IdObj.
     * 
     * @param layer
     */
    public void setLayer(java.lang.String layer) {
        this.layer = layer;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IdObj)) return false;
        IdObj other = (IdObj) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.id == other.getId() &&
            ((this.layer==null && other.getLayer()==null) || 
             (this.layer!=null &&
              this.layer.equals(other.getLayer())));
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
        _hashCode += new Long(getId()).hashCode();
        if (getLayer() != null) {
            _hashCode += getLayer().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
