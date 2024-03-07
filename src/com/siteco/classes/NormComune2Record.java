package com.siteco.classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class NormComune2Record {
    private java.lang.String CAP;
    private java.lang.String COD_CAT;
    private java.lang.String COD_ISTAT;
    private java.lang.String COD_NAZIONALE;
    private java.lang.Long COMUNE_ID;
    private java.lang.String DENOMINAZIONE;
    private java.lang.String FLG_CESSATO;
    private java.math.BigDecimal GR_AFFIDABILITA;
    private java.lang.Long NUMERO_RIGA;
    private java.lang.Long NUMERO_RIGHE;


    /**
     * Gets the CAP value for this Norm_Comune2OutputRecordset.
     *
     * @return CAP
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.lang.String getCAP() {
        return CAP;
    }


    /**
     * Sets the CAP value for this Norm_Comune2OutputRecordset.
     *
     * @param CAP
     */
    public void setCAP(java.lang.String CAP) {
        this.CAP = CAP;
    }


    /**
     * Gets the COD_CAT value for this Norm_Comune2OutputRecordset.
     *
     * @return COD_CAT
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.lang.String getCOD_CAT() {
        return COD_CAT;
    }


    /**
     * Sets the COD_CAT value for this Norm_Comune2OutputRecordset.
     *
     * @param COD_CAT
     */
    public void setCOD_CAT(java.lang.String COD_CAT) {
        this.COD_CAT = COD_CAT;
    }


    /**
     * Gets the COD_ISTAT value for this Norm_Comune2OutputRecordset.
     *
     * @return COD_ISTAT
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.lang.String getCOD_ISTAT() {
        return COD_ISTAT;
    }


    /**
     * Sets the COD_ISTAT value for this Norm_Comune2OutputRecordset.
     *
     * @param COD_ISTAT
     */
    public void setCOD_ISTAT(java.lang.String COD_ISTAT) {
        this.COD_ISTAT = COD_ISTAT;
    }


    /**
     * Gets the COD_NAZIONALE value for this Norm_Comune2OutputRecordset.
     *
     * @return COD_NAZIONALE
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.lang.String getCOD_NAZIONALE() {
        return COD_NAZIONALE;
    }


    /**
     * Sets the COD_NAZIONALE value for this Norm_Comune2OutputRecordset.
     *
     * @param COD_NAZIONALE
     */
    public void setCOD_NAZIONALE(java.lang.String COD_NAZIONALE) {
        this.COD_NAZIONALE = COD_NAZIONALE;
    }


    /**
     * Gets the COMUNE_ID value for this Norm_Comune2OutputRecordset.
     *
     * @return COMUNE_ID
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.lang.Long getCOMUNE_ID() {
        return COMUNE_ID;
    }


    /**
     * Sets the COMUNE_ID value for this Norm_Comune2OutputRecordset.
     *
     * @param COMUNE_ID
     */
    public void setCOMUNE_ID(java.lang.Long COMUNE_ID) {
        this.COMUNE_ID = COMUNE_ID;
    }


    /**
     * Gets the DENOMINAZIONE value for this Norm_Comune2OutputRecordset.
     *
     * @return DENOMINAZIONE
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.lang.String getDENOMINAZIONE() {
        return DENOMINAZIONE;
    }


    /**
     * Sets the DENOMINAZIONE value for this Norm_Comune2OutputRecordset.
     *
     * @param DENOMINAZIONE
     */
    public void setDENOMINAZIONE(java.lang.String DENOMINAZIONE) {
        this.DENOMINAZIONE = DENOMINAZIONE;
    }


    /**
     * Gets the FLG_CESSATO value for this Norm_Comune2OutputRecordset.
     *
     * @return FLG_CESSATO
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.lang.String getFLG_CESSATO() {
        return FLG_CESSATO;
    }


    /**
     * Sets the FLG_CESSATO value for this Norm_Comune2OutputRecordset.
     *
     * @param FLG_CESSATO
     */
    public void setFLG_CESSATO(java.lang.String FLG_CESSATO) {
        this.FLG_CESSATO = FLG_CESSATO;
    }


    /**
     * Gets the GR_AFFIDABILITA value for this Norm_Comune2OutputRecordset.
     *
     * @return GR_AFFIDABILITA
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.math.BigDecimal getGR_AFFIDABILITA() {
        return GR_AFFIDABILITA;
    }


    /**
     * Sets the GR_AFFIDABILITA value for this Norm_Comune2OutputRecordset.
     *
     * @param GR_AFFIDABILITA
     */
    public void setGR_AFFIDABILITA(java.math.BigDecimal GR_AFFIDABILITA) {
        this.GR_AFFIDABILITA = GR_AFFIDABILITA;
    }


    /**
     * Gets the NUMERO_RIGA value for this Norm_Comune2OutputRecordset.
     *
     * @return NUMERO_RIGA
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.lang.Long getNUMERO_RIGA() {
        return NUMERO_RIGA;
    }


    /**
     * Sets the NUMERO_RIGA value for this Norm_Comune2OutputRecordset.
     *
     * @param NUMERO_RIGA
     */
    public void setNUMERO_RIGA(java.lang.Long NUMERO_RIGA) {
        this.NUMERO_RIGA = NUMERO_RIGA;
    }


    /**
     * Gets the NUMERO_RIGHE value for this Norm_Comune2OutputRecordset.
     *
     * @return NUMERO_RIGHE
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.lang.Long getNUMERO_RIGHE() {
        return NUMERO_RIGHE;
    }


    /**
     * Sets the NUMERO_RIGHE value for this Norm_Comune2OutputRecordset.
     *
     * @param NUMERO_RIGHE
     */
    public void setNUMERO_RIGHE(java.lang.Long NUMERO_RIGHE) {
        this.NUMERO_RIGHE = NUMERO_RIGHE;
    }
}
