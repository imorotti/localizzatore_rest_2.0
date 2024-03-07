package com.siteco.classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class NormProvinciaRecord {
    private java.lang.String COD_ISTAT;
    private java.lang.String COD_NAZIONALE;
    private java.lang.String DENOMINAZIONE;
    private java.math.BigDecimal GR_AFFIDABILITA;
    private java.lang.Long NUMERO_RIGA;
    private java.lang.Long NUMERO_RIGHE;
    private java.lang.Long PROVINCIA_ID;
    private java.lang.String SIGLA;

    /**
     * Gets the COD_ISTAT value for this Norm_ProvinciaOutputRecordset.
     *
     * @return COD_ISTAT
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.lang.String getCOD_ISTAT() {
        return COD_ISTAT;
    }


    /**
     * Sets the COD_ISTAT value for this Norm_ProvinciaOutputRecordset.
     *
     * @param COD_ISTAT
     */
    public void setCOD_ISTAT(java.lang.String COD_ISTAT) {
        this.COD_ISTAT = COD_ISTAT;
    }


    /**
     * Gets the COD_NAZIONALE value for this Norm_ProvinciaOutputRecordset.
     *
     * @return COD_NAZIONALE
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.lang.String getCOD_NAZIONALE() {
        return COD_NAZIONALE;
    }


    /**
     * Sets the COD_NAZIONALE value for this Norm_ProvinciaOutputRecordset.
     *
     * @param COD_NAZIONALE
     */
    public void setCOD_NAZIONALE(java.lang.String COD_NAZIONALE) {
        this.COD_NAZIONALE = COD_NAZIONALE;
    }


    /**
     * Gets the DENOMINAZIONE value for this Norm_ProvinciaOutputRecordset.
     *
     * @return DENOMINAZIONE
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.lang.String getDENOMINAZIONE() {
        return DENOMINAZIONE;
    }


    /**
     * Sets the DENOMINAZIONE value for this Norm_ProvinciaOutputRecordset.
     *
     * @param DENOMINAZIONE
     */
    public void setDENOMINAZIONE(java.lang.String DENOMINAZIONE) {
        this.DENOMINAZIONE = DENOMINAZIONE;
    }


    /**
     * Gets the GR_AFFIDABILITA value for this Norm_ProvinciaOutputRecordset.
     *
     * @return GR_AFFIDABILITA
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.math.BigDecimal getGR_AFFIDABILITA() {
        return GR_AFFIDABILITA;
    }


    /**
     * Sets the GR_AFFIDABILITA value for this Norm_ProvinciaOutputRecordset.
     *
     * @param GR_AFFIDABILITA
     */
    public void setGR_AFFIDABILITA(java.math.BigDecimal GR_AFFIDABILITA) {
        this.GR_AFFIDABILITA = GR_AFFIDABILITA;
    }


    /**
     * Gets the NUMERO_RIGA value for this Norm_ProvinciaOutputRecordset.
     *
     * @return NUMERO_RIGA
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.lang.Long getNUMERO_RIGA() {
        return NUMERO_RIGA;
    }


    /**
     * Sets the NUMERO_RIGA value for this Norm_ProvinciaOutputRecordset.
     *
     * @param NUMERO_RIGA
     */
    public void setNUMERO_RIGA(java.lang.Long NUMERO_RIGA) {
        this.NUMERO_RIGA = NUMERO_RIGA;
    }


    /**
     * Gets the NUMERO_RIGHE value for this Norm_ProvinciaOutputRecordset.
     *
     * @return NUMERO_RIGHE
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.lang.Long getNUMERO_RIGHE() {
        return NUMERO_RIGHE;
    }


    /**
     * Sets the NUMERO_RIGHE value for this Norm_ProvinciaOutputRecordset.
     *
     * @param NUMERO_RIGHE
     */
    public void setNUMERO_RIGHE(java.lang.Long NUMERO_RIGHE) {
        this.NUMERO_RIGHE = NUMERO_RIGHE;
    }


    /**
     * Gets the PROVINCIA_ID value for this Norm_ProvinciaOutputRecordset.
     *
     * @return PROVINCIA_ID
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.lang.Long getPROVINCIA_ID() {
        return PROVINCIA_ID;
    }


    /**
     * Sets the PROVINCIA_ID value for this Norm_ProvinciaOutputRecordset.
     *
     * @param PROVINCIA_ID
     */
    public void setPROVINCIA_ID(java.lang.Long PROVINCIA_ID) {
        this.PROVINCIA_ID = PROVINCIA_ID;
    }


    /**
     * Gets the SIGLA value for this Norm_ProvinciaOutputRecordset.
     *
     * @return SIGLA
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.lang.String getSIGLA() {
        return SIGLA;
    }


    /**
     * Sets the SIGLA value for this Norm_ProvinciaOutputRecordset.
     *
     * @param SIGLA
     */
    public void setSIGLA(java.lang.String SIGLA) {
        this.SIGLA = SIGLA;
    }
}
