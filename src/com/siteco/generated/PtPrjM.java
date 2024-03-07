/**
 * PtPrjM.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package com.siteco.generated;

public class PtPrjM  implements java.io.Serializable {
    private double XPro;
    private double YPro;
    private long id;
    private double m;
    private double offset;
    private double x;
    private double y;
    private int srid;
    private int dim;

    public PtPrjM() {
    }

    public PtPrjM(
           double XPro,
           double YPro,
           long id,
           double m,
           double offset,
           double x,
           double y,
           int srid,
           int dim) {
           this.XPro = XPro;
           this.YPro = YPro;
           this.id = id;
           this.m = m;
           this.offset = offset;
           this.x = x;
           this.y = y;
           this.srid = srid;
           this.dim = dim;
    }


    /**
     * Gets the XPro value for this PtPrjM.
     * 
     * @return XPro
     */
    public double getXPro() {
        return XPro;
    }


    /**
     * Sets the XPro value for this PtPrjM.
     * 
     * @param XPro
     */
    public void setXPro(double XPro) {
        this.XPro = XPro;
    }


    /**
     * Gets the YPro value for this PtPrjM.
     * 
     * @return YPro
     */
    public double getYPro() {
        return YPro;
    }


    /**
     * Sets the YPro value for this PtPrjM.
     * 
     * @param YPro
     */
    public void setYPro(double YPro) {
        this.YPro = YPro;
    }


    /**
     * Gets the id value for this PtPrjM.
     * 
     * @return id
     */
    public long getId() {
        return id;
    }


    /**
     * Sets the id value for this PtPrjM.
     * 
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }


    /**
     * Gets the m value for this PtPrjM.
     * 
     * @return m
     */
    public double getM() {
        return m;
    }


    /**
     * Sets the m value for this PtPrjM.
     * 
     * @param m
     */
    public void setM(double m) {
        this.m = m;
    }


    /**
     * Gets the offset value for this PtPrjM.
     * 
     * @return offset
     */
    public double getOffset() {
        return offset;
    }


    /**
     * Sets the offset value for this PtPrjM.
     * 
     * @param offset
     */
    public void setOffset(double offset) {
        this.offset = offset;
    }


    /**
     * Gets the x value for this PtPrjM.
     * 
     * @return x
     */
    public double getX() {
        return x;
    }


    /**
     * Sets the x value for this PtPrjM.
     * 
     * @param x
     */
    public void setX(double x) {
        this.x = x;
    }


    /**
     * Gets the y value for this PtPrjM.
     * 
     * @return y
     */
    public double getY() {
        return y;
    }


    /**
     * Sets the y value for this PtPrjM.
     * 
     * @param y
     */
    public void setY(double y) {
        this.y = y;
    }


    /**
     * Gets the srid value for this PtPrjM.
     * 
     * @return srid
     */
    public int getSrid() {
        return srid;
    }


    /**
     * Sets the srid value for this PtPrjM.
     * 
     * @param srid
     */
    public void setSrid(int srid) {
        this.srid = srid;
    }


    /**
     * Gets the dim value for this PtPrjM.
     * 
     * @return dim
     */
    public int getDim() {
        return dim;
    }


    /**
     * Sets the dim value for this PtPrjM.
     * 
     * @param dim
     */
    public void setDim(int dim) {
        this.dim = dim;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PtPrjM)) return false;
        PtPrjM other = (PtPrjM) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.XPro == other.getXPro() &&
            this.YPro == other.getYPro() &&
            this.id == other.getId() &&
            this.m == other.getM() &&
            this.offset == other.getOffset() &&
            this.x == other.getX() &&
            this.y == other.getY() &&
            this.srid == other.getSrid() &&
            this.dim == other.getDim();
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
        _hashCode += new Double(getXPro()).hashCode();
        _hashCode += new Double(getYPro()).hashCode();
        _hashCode += new Long(getId()).hashCode();
        _hashCode += new Double(getM()).hashCode();
        _hashCode += new Double(getOffset()).hashCode();
        _hashCode += new Double(getX()).hashCode();
        _hashCode += new Double(getY()).hashCode();
        _hashCode += getSrid();
        _hashCode += getDim();
        __hashCodeCalc = false;
        return _hashCode;
    }

}
