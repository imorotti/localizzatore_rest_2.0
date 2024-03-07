/**
 * Localizzazione.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package com.siteco.generated;

public class Localizzazione  implements java.io.Serializable {
    private java.lang.String esito;
    private double m;
    private java.lang.String n_civico;
    private boolean riuscita;
    private java.lang.String road_id1;
    private java.lang.String road_id2;
    private int tipoLocalizzazione;
    private double x;
    private double y;

    public Localizzazione() {
    }

    public Localizzazione(
           java.lang.String esito,
           double m,
           java.lang.String n_civico,
           boolean riuscita,
           java.lang.String road_id1,
           java.lang.String road_id2,
           int tipoLocalizzazione,
           double x,
           double y) {
           this.esito = esito;
           this.m = m;
           this.n_civico = n_civico;
           this.riuscita = riuscita;
           this.road_id1 = road_id1;
           this.road_id2 = road_id2;
           this.tipoLocalizzazione = tipoLocalizzazione;
           this.x = x;
           this.y = y;
    }


    /**
     * Gets the esito value for this Localizzazione.
     * 
     * @return esito
     */
    public java.lang.String getEsito() {
        return esito;
    }


    /**
     * Sets the esito value for this Localizzazione.
     * 
     * @param esito
     */
    public void setEsito(java.lang.String esito) {
        this.esito = esito;
    }


    /**
     * Gets the m value for this Localizzazione.
     * 
     * @return m
     */
    public double getM() {
        return m;
    }


    /**
     * Sets the m value for this Localizzazione.
     * 
     * @param m
     */
    public void setM(double m) {
        this.m = m;
    }


    /**
     * Gets the n_civico value for this Localizzazione.
     * 
     * @return n_civico
     */
    public java.lang.String getN_civico() {
        return n_civico;
    }


    /**
     * Sets the n_civico value for this Localizzazione.
     * 
     * @param n_civico
     */
    public void setN_civico(java.lang.String n_civico) {
        this.n_civico = n_civico;
    }


    /**
     * Gets the riuscita value for this Localizzazione.
     * 
     * @return riuscita
     */
    public boolean isRiuscita() {
        return riuscita;
    }


    /**
     * Sets the riuscita value for this Localizzazione.
     * 
     * @param riuscita
     */
    public void setRiuscita(boolean riuscita) {
        this.riuscita = riuscita;
    }


    /**
     * Gets the road_id1 value for this Localizzazione.
     * 
     * @return road_id1
     */
    public java.lang.String getRoad_id1() {
        return road_id1;
    }


    /**
     * Sets the road_id1 value for this Localizzazione.
     * 
     * @param road_id1
     */
    public void setRoad_id1(java.lang.String road_id1) {
        this.road_id1 = road_id1;
    }


    /**
     * Gets the road_id2 value for this Localizzazione.
     * 
     * @return road_id2
     */
    public java.lang.String getRoad_id2() {
        return road_id2;
    }


    /**
     * Sets the road_id2 value for this Localizzazione.
     * 
     * @param road_id2
     */
    public void setRoad_id2(java.lang.String road_id2) {
        this.road_id2 = road_id2;
    }


    /**
     * Gets the tipoLocalizzazione value for this Localizzazione.
     * 
     * @return tipoLocalizzazione
     */
    public int getTipoLocalizzazione() {
        return tipoLocalizzazione;
    }


    /**
     * Sets the tipoLocalizzazione value for this Localizzazione.
     * 
     * @param tipoLocalizzazione
     */
    public void setTipoLocalizzazione(int tipoLocalizzazione) {
        this.tipoLocalizzazione = tipoLocalizzazione;
    }


    /**
     * Gets the x value for this Localizzazione.
     * 
     * @return x
     */
    public double getX() {
        return x;
    }


    /**
     * Sets the x value for this Localizzazione.
     * 
     * @param x
     */
    public void setX(double x) {
        this.x = x;
    }


    /**
     * Gets the y value for this Localizzazione.
     * 
     * @return y
     */
    public double getY() {
        return y;
    }


    /**
     * Sets the y value for this Localizzazione.
     * 
     * @param y
     */
    public void setY(double y) {
        this.y = y;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Localizzazione)) return false;
        Localizzazione other = (Localizzazione) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.esito==null && other.getEsito()==null) || 
             (this.esito!=null &&
              this.esito.equals(other.getEsito()))) &&
            this.m == other.getM() &&
            ((this.n_civico==null && other.getN_civico()==null) || 
             (this.n_civico!=null &&
              this.n_civico.equals(other.getN_civico()))) &&
            this.riuscita == other.isRiuscita() &&
            ((this.road_id1==null && other.getRoad_id1()==null) || 
             (this.road_id1!=null &&
              this.road_id1.equals(other.getRoad_id1()))) &&
            ((this.road_id2==null && other.getRoad_id2()==null) || 
             (this.road_id2!=null &&
              this.road_id2.equals(other.getRoad_id2()))) &&
            this.tipoLocalizzazione == other.getTipoLocalizzazione() &&
            this.x == other.getX() &&
            this.y == other.getY();
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
        if (getEsito() != null) {
            _hashCode += getEsito().hashCode();
        }
        _hashCode += new Double(getM()).hashCode();
        if (getN_civico() != null) {
            _hashCode += getN_civico().hashCode();
        }
        _hashCode += (isRiuscita() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getRoad_id1() != null) {
            _hashCode += getRoad_id1().hashCode();
        }
        if (getRoad_id2() != null) {
            _hashCode += getRoad_id2().hashCode();
        }
        _hashCode += getTipoLocalizzazione();
        _hashCode += new Double(getX()).hashCode();
        _hashCode += new Double(getY()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

}
