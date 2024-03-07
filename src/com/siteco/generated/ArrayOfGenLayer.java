/**
 * ArrayOfGenLayer.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package com.siteco.generated;

public class ArrayOfGenLayer  implements java.io.Serializable {
    private com.siteco.generated.ArrayOfGenLayer genLayers;
    private com.siteco.generated.GenLayer[] ut;

    public ArrayOfGenLayer() {
    }

    public ArrayOfGenLayer(
           com.siteco.generated.ArrayOfGenLayer genLayers,
           com.siteco.generated.GenLayer[] ut) {
           this.genLayers = genLayers;
           this.ut = ut;
    }


    /**
     * Gets the genLayers value for this ArrayOfGenLayer.
     * 
     * @return genLayers
     */
    public com.siteco.generated.ArrayOfGenLayer getGenLayers() {
        return genLayers;
    }


    /**
     * Sets the genLayers value for this ArrayOfGenLayer.
     * 
     * @param genLayers
     */
    public void setGenLayers(com.siteco.generated.ArrayOfGenLayer genLayers) {
        this.genLayers = genLayers;
    }


    /**
     * Gets the ut value for this ArrayOfGenLayer.
     * 
     * @return ut
     */
    public com.siteco.generated.GenLayer[] getUt() {
        return ut;
    }


    /**
     * Sets the ut value for this ArrayOfGenLayer.
     * 
     * @param ut
     */
    public void setUt(com.siteco.generated.GenLayer[] ut) {
        this.ut = ut;
    }

    public com.siteco.generated.GenLayer getUt(int i) {
        return this.ut[i];
    }

    public void setUt(int i, com.siteco.generated.GenLayer _value) {
        this.ut[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfGenLayer)) return false;
        ArrayOfGenLayer other = (ArrayOfGenLayer) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.genLayers==null && other.getGenLayers()==null) || 
             (this.genLayers!=null &&
              this.genLayers.equals(other.getGenLayers()))) &&
            ((this.ut==null && other.getUt()==null) || 
             (this.ut!=null &&
              java.util.Arrays.equals(this.ut, other.getUt())));
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
        if (getGenLayers() != null) {
            _hashCode += getGenLayers().hashCode();
        }
        if (getUt() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUt());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUt(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
