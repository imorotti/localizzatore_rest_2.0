/**
 * Norm_ProvinciaOutputRecordset.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_ProvinciaOutputRecordset  implements java.io.Serializable {
    private java.lang.Long PROVINCIA_ID;
    private java.lang.String DENOMINAZIONE;
    private java.lang.String SIGLA;
    private java.lang.String COD_ISTAT;
    private java.lang.String COD_NAZIONALE;
    private java.math.BigDecimal GR_AFFIDABILITA;
    private java.lang.Long NUMERO_RIGHE;
    private java.lang.Long NUMERO_RIGA;

    public Norm_ProvinciaOutputRecordset() {
    }

    public Norm_ProvinciaOutputRecordset(
           java.lang.Long PROVINCIA_ID,
           java.lang.String DENOMINAZIONE,
           java.lang.String SIGLA,
           java.lang.String COD_ISTAT,
           java.lang.String COD_NAZIONALE,
           java.math.BigDecimal GR_AFFIDABILITA,
           java.lang.Long NUMERO_RIGHE,
           java.lang.Long NUMERO_RIGA) {
           this.PROVINCIA_ID = PROVINCIA_ID;
           this.DENOMINAZIONE = DENOMINAZIONE;
           this.SIGLA = SIGLA;
           this.COD_ISTAT = COD_ISTAT;
           this.COD_NAZIONALE = COD_NAZIONALE;
           this.GR_AFFIDABILITA = GR_AFFIDABILITA;
           this.NUMERO_RIGHE = NUMERO_RIGHE;
           this.NUMERO_RIGA = NUMERO_RIGA;
    }


    /**
     * Gets the PROVINCIA_ID value for this Norm_ProvinciaOutputRecordset.
     * 
     * @return PROVINCIA_ID
     */
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
     * Gets the DENOMINAZIONE value for this Norm_ProvinciaOutputRecordset.
     * 
     * @return DENOMINAZIONE
     */
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
     * Gets the SIGLA value for this Norm_ProvinciaOutputRecordset.
     * 
     * @return SIGLA
     */
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


    /**
     * Gets the COD_ISTAT value for this Norm_ProvinciaOutputRecordset.
     * 
     * @return COD_ISTAT
     */
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
     * Gets the GR_AFFIDABILITA value for this Norm_ProvinciaOutputRecordset.
     * 
     * @return GR_AFFIDABILITA
     */
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
     * Gets the NUMERO_RIGHE value for this Norm_ProvinciaOutputRecordset.
     * 
     * @return NUMERO_RIGHE
     */
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
     * Gets the NUMERO_RIGA value for this Norm_ProvinciaOutputRecordset.
     * 
     * @return NUMERO_RIGA
     */
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

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_ProvinciaOutputRecordset)) return false;
        Norm_ProvinciaOutputRecordset other = (Norm_ProvinciaOutputRecordset) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.PROVINCIA_ID==null && other.getPROVINCIA_ID()==null) || 
             (this.PROVINCIA_ID!=null &&
              this.PROVINCIA_ID.equals(other.getPROVINCIA_ID()))) &&
            ((this.DENOMINAZIONE==null && other.getDENOMINAZIONE()==null) || 
             (this.DENOMINAZIONE!=null &&
              this.DENOMINAZIONE.equals(other.getDENOMINAZIONE()))) &&
            ((this.SIGLA==null && other.getSIGLA()==null) || 
             (this.SIGLA!=null &&
              this.SIGLA.equals(other.getSIGLA()))) &&
            ((this.COD_ISTAT==null && other.getCOD_ISTAT()==null) || 
             (this.COD_ISTAT!=null &&
              this.COD_ISTAT.equals(other.getCOD_ISTAT()))) &&
            ((this.COD_NAZIONALE==null && other.getCOD_NAZIONALE()==null) || 
             (this.COD_NAZIONALE!=null &&
              this.COD_NAZIONALE.equals(other.getCOD_NAZIONALE()))) &&
            ((this.GR_AFFIDABILITA==null && other.getGR_AFFIDABILITA()==null) || 
             (this.GR_AFFIDABILITA!=null &&
              this.GR_AFFIDABILITA.equals(other.getGR_AFFIDABILITA()))) &&
            ((this.NUMERO_RIGHE==null && other.getNUMERO_RIGHE()==null) || 
             (this.NUMERO_RIGHE!=null &&
              this.NUMERO_RIGHE.equals(other.getNUMERO_RIGHE()))) &&
            ((this.NUMERO_RIGA==null && other.getNUMERO_RIGA()==null) || 
             (this.NUMERO_RIGA!=null &&
              this.NUMERO_RIGA.equals(other.getNUMERO_RIGA())));
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
        if (getPROVINCIA_ID() != null) {
            _hashCode += getPROVINCIA_ID().hashCode();
        }
        if (getDENOMINAZIONE() != null) {
            _hashCode += getDENOMINAZIONE().hashCode();
        }
        if (getSIGLA() != null) {
            _hashCode += getSIGLA().hashCode();
        }
        if (getCOD_ISTAT() != null) {
            _hashCode += getCOD_ISTAT().hashCode();
        }
        if (getCOD_NAZIONALE() != null) {
            _hashCode += getCOD_NAZIONALE().hashCode();
        }
        if (getGR_AFFIDABILITA() != null) {
            _hashCode += getGR_AFFIDABILITA().hashCode();
        }
        if (getNUMERO_RIGHE() != null) {
            _hashCode += getNUMERO_RIGHE().hashCode();
        }
        if (getNUMERO_RIGA() != null) {
            _hashCode += getNUMERO_RIGA().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_ProvinciaOutputRecordset.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_ProvinciaOutputRecordset"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PROVINCIA_ID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "PROVINCIA_ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DENOMINAZIONE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "DENOMINAZIONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SIGLA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "SIGLA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("COD_ISTAT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "COD_ISTAT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("COD_NAZIONALE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "COD_NAZIONALE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GR_AFFIDABILITA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "GR_AFFIDABILITA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NUMERO_RIGHE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "NUMERO_RIGHE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NUMERO_RIGA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "NUMERO_RIGA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
