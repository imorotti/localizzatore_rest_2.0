package com.siteco.classes;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement

public class NormLuoghiNotevoliRecord  implements java.io.Serializable {
    private java.lang.String STRADARIO_ID;
    private java.lang.String ENTITA_ID;
    private java.lang.String DUG;
    private java.lang.String DENOMINAZIONE;
    private java.lang.String TIPO_STRADA;
    private java.lang.String COMUNE;
    private java.lang.String PROVINCIA;
    private java.lang.String REGIONE;
    private java.lang.String TIPO_COORD;
    private java.lang.String DESCRIZ_UFF;
    private java.math.BigDecimal MIN_X;
    private java.math.BigDecimal MIN_Y;
    private java.math.BigDecimal MAX_X;
    private java.math.BigDecimal MAX_Y;
    private java.math.BigDecimal CENTR_X;
    private java.math.BigDecimal CENTR_Y;
    private java.math.BigDecimal GR_AFFIDABILITA;
    private java.lang.Long NUMERO_RIGHE;
    private java.lang.Long NUMERO_RIGA;

    public NormLuoghiNotevoliRecord() {
    }

    public NormLuoghiNotevoliRecord(
           java.lang.String STRADARIO_ID,
           java.lang.String ENTITA_ID,
           java.lang.String DUG,
           java.lang.String DENOMINAZIONE,
           java.lang.String TIPO_STRADA,
           java.lang.String COMUNE,
           java.lang.String PROVINCIA,
           java.lang.String REGIONE,
           java.lang.String TIPO_COORD,
           java.lang.String DESCRIZ_UFF,
           java.math.BigDecimal MIN_X,
           java.math.BigDecimal MIN_Y,
           java.math.BigDecimal MAX_X,
           java.math.BigDecimal MAX_Y,
           java.math.BigDecimal CENTR_X,
           java.math.BigDecimal CENTR_Y,
           java.math.BigDecimal GR_AFFIDABILITA,
           java.lang.Long NUMERO_RIGHE,
           java.lang.Long NUMERO_RIGA) {
           this.STRADARIO_ID = STRADARIO_ID;
           this.ENTITA_ID = ENTITA_ID;
           this.DUG = DUG;
           this.DENOMINAZIONE = DENOMINAZIONE;
           this.TIPO_STRADA = TIPO_STRADA;
           this.COMUNE = COMUNE;
           this.PROVINCIA = PROVINCIA;
           this.REGIONE = REGIONE;
           this.TIPO_COORD = TIPO_COORD;
           this.DESCRIZ_UFF = DESCRIZ_UFF;
           this.MIN_X = MIN_X;
           this.MIN_Y = MIN_Y;
           this.MAX_X = MAX_X;
           this.MAX_Y = MAX_Y;
           this.CENTR_X = CENTR_X;
           this.CENTR_Y = CENTR_Y;
           this.GR_AFFIDABILITA = GR_AFFIDABILITA;
           this.NUMERO_RIGHE = NUMERO_RIGHE;
           this.NUMERO_RIGA = NUMERO_RIGA;
    }


    /**
     * Gets the STRADARIO_ID value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @return STRADARIO_ID
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.lang.String getSTRADARIO_ID() {
        return STRADARIO_ID;
    }


    /**
     * Sets the STRADARIO_ID value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @param STRADARIO_ID
     */
    public void setSTRADARIO_ID(java.lang.String STRADARIO_ID) {
        this.STRADARIO_ID = STRADARIO_ID;
    }


    /**
     * Gets the ENTITA_ID value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @return ENTITA_ID
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.lang.String getENTITA_ID() {
        return ENTITA_ID;
    }


    /**
     * Sets the ENTITA_ID value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @param ENTITA_ID
     */
    public void setENTITA_ID(java.lang.String ENTITA_ID) {
        this.ENTITA_ID = ENTITA_ID;
    }


    /**
     * Gets the DUG value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @return DUG
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.lang.String getDUG() {
        return DUG;
    }


    /**
     * Sets the DUG value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @param DUG
     */
    public void setDUG(java.lang.String DUG) {
        this.DUG = DUG;
    }


    /**
     * Gets the DENOMINAZIONE value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @return DENOMINAZIONE
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.lang.String getDENOMINAZIONE() {
        return DENOMINAZIONE;
    }


    /**
     * Sets the DENOMINAZIONE value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @param DENOMINAZIONE
     */
    public void setDENOMINAZIONE(java.lang.String DENOMINAZIONE) {
        this.DENOMINAZIONE = DENOMINAZIONE;
    }


    /**
     * Gets the TIPO_STRADA value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @return TIPO_STRADA
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.lang.String getTIPO_STRADA() {
        return TIPO_STRADA;
    }


    /**
     * Sets the TIPO_STRADA value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @param TIPO_STRADA
     */
    public void setTIPO_STRADA(java.lang.String TIPO_STRADA) {
        this.TIPO_STRADA = TIPO_STRADA;
    }


    /**
     * Gets the COMUNE value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @return COMUNE
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.lang.String getCOMUNE() {
        return COMUNE;
    }


    /**
     * Sets the COMUNE value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @param COMUNE
     */
    public void setCOMUNE(java.lang.String COMUNE) {
        this.COMUNE = COMUNE;
    }


    /**
     * Gets the PROVINCIA value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @return PROVINCIA
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.lang.String getPROVINCIA() {
        return PROVINCIA;
    }


    /**
     * Sets the PROVINCIA value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @param PROVINCIA
     */
    public void setPROVINCIA(java.lang.String PROVINCIA) {
        this.PROVINCIA = PROVINCIA;
    }


    /**
     * Gets the REGIONE value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @return REGIONE
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.lang.String getREGIONE() {
        return REGIONE;
    }


    /**
     * Sets the REGIONE value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @param REGIONE
     */
    public void setREGIONE(java.lang.String REGIONE) {
        this.REGIONE = REGIONE;
    }


    /**
     * Gets the TIPO_COORD value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @return TIPO_COORD
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.lang.String getTIPO_COORD() {
        return TIPO_COORD;
    }


    /**
     * Sets the TIPO_COORD value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @param TIPO_COORD
     */
    public void setTIPO_COORD(java.lang.String TIPO_COORD) {
        this.TIPO_COORD = TIPO_COORD;
    }


    /**
     * Gets the DESCRIZ_UFF value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @return DESCRIZ_UFF
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.lang.String getDESCRIZ_UFF() {
        return DESCRIZ_UFF;
    }


    /**
     * Sets the DESCRIZ_UFF value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @param DESCRIZ_UFF
     */
    public void setDESCRIZ_UFF(java.lang.String DESCRIZ_UFF) {
        this.DESCRIZ_UFF = DESCRIZ_UFF;
    }


    /**
     * Gets the MIN_X value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @return MIN_X
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.math.BigDecimal getMIN_X() {
        return MIN_X;
    }


    /**
     * Sets the MIN_X value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @param MIN_X
     */
    public void setMIN_X(java.math.BigDecimal MIN_X) {
        this.MIN_X = MIN_X;
    }


    /**
     * Gets the MIN_Y value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @return MIN_Y
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.math.BigDecimal getMIN_Y() {
        return MIN_Y;
    }


    /**
     * Sets the MIN_Y value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @param MIN_Y
     */
    public void setMIN_Y(java.math.BigDecimal MIN_Y) {
        this.MIN_Y = MIN_Y;
    }


    /**
     * Gets the MAX_X value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @return MAX_X
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.math.BigDecimal getMAX_X() {
        return MAX_X;
    }


    /**
     * Sets the MAX_X value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @param MAX_X
     */
    public void setMAX_X(java.math.BigDecimal MAX_X) {
        this.MAX_X = MAX_X;
    }


    /**
     * Gets the MAX_Y value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @return MAX_Y
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.math.BigDecimal getMAX_Y() {
        return MAX_Y;
    }


    /**
     * Sets the MAX_Y value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @param MAX_Y
     */
    public void setMAX_Y(java.math.BigDecimal MAX_Y) {
        this.MAX_Y = MAX_Y;
    }


    /**
     * Gets the CENTR_X value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @return CENTR_X
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.math.BigDecimal getCENTR_X() {
        return CENTR_X;
    }


    /**
     * Sets the CENTR_X value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @param CENTR_X
     */
    public void setCENTR_X(java.math.BigDecimal CENTR_X) {
        this.CENTR_X = CENTR_X;
    }


    /**
     * Gets the CENTR_Y value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @return CENTR_Y
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.math.BigDecimal getCENTR_Y() {
        return CENTR_Y;
    }


    /**
     * Sets the CENTR_Y value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @param CENTR_Y
     */
    public void setCENTR_Y(java.math.BigDecimal CENTR_Y) {
        this.CENTR_Y = CENTR_Y;
    }


    /**
     * Gets the GR_AFFIDABILITA value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @return GR_AFFIDABILITA
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.math.BigDecimal getGR_AFFIDABILITA() {
        return GR_AFFIDABILITA;
    }


    /**
     * Sets the GR_AFFIDABILITA value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @param GR_AFFIDABILITA
     */
    public void setGR_AFFIDABILITA(java.math.BigDecimal GR_AFFIDABILITA) {
        this.GR_AFFIDABILITA = GR_AFFIDABILITA;
    }


    /**
     * Gets the NUMERO_RIGHE value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @return NUMERO_RIGHE
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.lang.Long getNUMERO_RIGHE() {
        return NUMERO_RIGHE;
    }


    /**
     * Sets the NUMERO_RIGHE value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @param NUMERO_RIGHE
     */
    public void setNUMERO_RIGHE(java.lang.Long NUMERO_RIGHE) {
        this.NUMERO_RIGHE = NUMERO_RIGHE;
    }


    /**
     * Gets the NUMERO_RIGA value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @return NUMERO_RIGA
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public java.lang.Long getNUMERO_RIGA() {
        return NUMERO_RIGA;
    }


    /**
     * Sets the NUMERO_RIGA value for this Norm_Luoghi_NotevoliOutputRecordset.
     * 
     * @param NUMERO_RIGA
     */
    public void setNUMERO_RIGA(java.lang.Long NUMERO_RIGA) {
        this.NUMERO_RIGA = NUMERO_RIGA;
    }
}
