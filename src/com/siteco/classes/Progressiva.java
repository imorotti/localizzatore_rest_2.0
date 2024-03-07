package com.siteco.classes;

/**
 * <p>Classe che identifica una prograssiva tramite l'identificatore
 * del percorso (road_id), la misura sul percorso (m), le coordinate
 * corrispondenti alla misura (xPro e yPro) di un punto e l'offset
 * di quest'ultimo nel caso non si trovi esattamente sul percorso.</p>
 *
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company: Siteco Informatica s.r.l.</p>
 *
 * @author Fabio Adani, Ivan Morotti, Maurizio Musarella
 * @version 1.0
 */

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement
public class Progressiva {
    private double xPro = 0;
    private double yPro = 0;
    private double offset = 0;
    private double m = 0;
    private double mMin = 1000000;
    private double mMax = -1000000;
    private String road_id = "";
    private String denominazione = "";
    private String sigla = "";
    
    
    /**
     * Ritorna la x proiettata sul percorso.
     * @return double la x proiettata sul percorso.
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public double getXPro() {
        return xPro;
    }
    /**
     * Setta la x proiettata sul percorso.
     * @param xPro double x proiettata sul percorso.
     */
    public void setXPro(double xPro) {
        this.xPro = xPro;
    }
    
    
    /**
     * Ritorna la y proiettata sul percorso.
     * @return double la y proiettata sul percorso.
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public double getYPro() {
        return yPro;
    }
    /**
     * Setta la y proiettata sul percorso.
     * @param yPro double y proiettata sul percorso.
     */
    public void setYPro(double yPro) {
        this.yPro = yPro;
    }
    
    
    /**
     * Ritorna l'offset del punto proiettato sul percorso.
     * @return double l'offset del punto proiettato sul percorso.
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public double getOffset() {
        return offset;
    }
    /**
     * Setta l'offset del punto da proiettare sul percorso.
     * @param offset double offset del punto da proiettare sul percorso.
     */
    public void setOffset(double offset) {
        this.offset = offset;
    }
    
    
    /**
     * Ritorna la misura m della proiezione di un punto sul percorso.
     * @return double la misura m della proiezione di un punto sul percorso.
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public double getM() {
        return m;
    }
    /**
     * Setta la misura m.
     * @param m double misura m.
     */
    public void setM(double m) {
        this.m = m;
    }
    
    
    /**
     * Ritorna la misura minima del percorso.
     * @return double la misura minima del percorso.
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public double getMMin() {
        return mMin;
    }
    /**
     * Setta la misura minima.
     * @param m double misura m.
     */
    public void setMMin(double m) {
        this.mMin = m;
    }
    
    

    /**
     * Ritorna l'identificatore della strada.
     * @return String l'identificatore della strada.
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public String getRoad_id() {
        return road_id;
    }
    /**
      * Setta l'identificativo della strada.
      * @param road_id String Identificativo della strada.
      */
     public void setRoad_id(String road_id) {
         this.road_id = road_id;
     }
     
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public String getDenominazione() {
        return denominazione;
    }
   
    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }
    
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public String getSigla() {
        return sigla;
    }
   
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    
    
    
    /**
     * Ritorna la misura massima del percorso.
     * @return double la misura massima del percorso.
     */
     @XmlElement(namespace="http://www.sitecoinf.it/values")
    public double getMMax() {
        return mMax;
    }
    
    /**
     * Setta la misura minima.
     * @param m double misura m.
     */
    public void setMMax(double m) {
        this.mMax = m;
    }
}
