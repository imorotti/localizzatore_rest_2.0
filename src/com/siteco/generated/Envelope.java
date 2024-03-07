/**
 * Envelope.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package com.siteco.generated;

public class Envelope  implements java.io.Serializable {
    private double maxX;
    private double maxY;
    private double minX;
    private double minY;

    public Envelope() {
    }

    public Envelope(
           double maxX,
           double maxY,
           double minX,
           double minY) {
           this.maxX = maxX;
           this.maxY = maxY;
           this.minX = minX;
           this.minY = minY;
    }


    /**
     * Gets the maxX value for this Envelope.
     * 
     * @return maxX
     */
    public double getMaxX() {
        return maxX;
    }


    /**
     * Sets the maxX value for this Envelope.
     * 
     * @param maxX
     */
    public void setMaxX(double maxX) {
        this.maxX = maxX;
    }


    /**
     * Gets the maxY value for this Envelope.
     * 
     * @return maxY
     */
    public double getMaxY() {
        return maxY;
    }


    /**
     * Sets the maxY value for this Envelope.
     * 
     * @param maxY
     */
    public void setMaxY(double maxY) {
        this.maxY = maxY;
    }


    /**
     * Gets the minX value for this Envelope.
     * 
     * @return minX
     */
    public double getMinX() {
        return minX;
    }


    /**
     * Sets the minX value for this Envelope.
     * 
     * @param minX
     */
    public void setMinX(double minX) {
        this.minX = minX;
    }


    /**
     * Gets the minY value for this Envelope.
     * 
     * @return minY
     */
    public double getMinY() {
        return minY;
    }


    /**
     * Sets the minY value for this Envelope.
     * 
     * @param minY
     */
    public void setMinY(double minY) {
        this.minY = minY;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Envelope)) return false;
        Envelope other = (Envelope) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.maxX == other.getMaxX() &&
            this.maxY == other.getMaxY() &&
            this.minX == other.getMinX() &&
            this.minY == other.getMinY();
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
        _hashCode += new Double(getMaxX()).hashCode();
        _hashCode += new Double(getMaxY()).hashCode();
        _hashCode += new Double(getMinX()).hashCode();
        _hashCode += new Double(getMinY()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

}
