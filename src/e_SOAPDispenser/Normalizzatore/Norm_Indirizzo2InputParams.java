/**
 * Norm_Indirizzo2InputParams.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_Indirizzo2InputParams  implements java.io.Serializable {
    private java.lang.String p_Civico;
    private java.lang.String p_Toponimo;
    private java.lang.String p_Cod_Nazionale;
    private java.lang.String p_Cod_Istat;
    private java.lang.String p_Provincia;
    private java.lang.String p_Comune;
    private java.lang.String p_Handle;
    private java.lang.String p_Cod_Catastale;

    public Norm_Indirizzo2InputParams() {
    }

    public Norm_Indirizzo2InputParams(
           java.lang.String p_Civico,
           java.lang.String p_Toponimo,
           java.lang.String p_Cod_Nazionale,
           java.lang.String p_Cod_Istat,
           java.lang.String p_Provincia,
           java.lang.String p_Comune,
           java.lang.String p_Handle,
           java.lang.String p_Cod_Catastale) {
           this.p_Civico = p_Civico;
           this.p_Toponimo = p_Toponimo;
           this.p_Cod_Nazionale = p_Cod_Nazionale;
           this.p_Cod_Istat = p_Cod_Istat;
           this.p_Provincia = p_Provincia;
           this.p_Comune = p_Comune;
           this.p_Handle = p_Handle;
           this.p_Cod_Catastale = p_Cod_Catastale;
    }


    /**
     * Gets the p_Civico value for this Norm_Indirizzo2InputParams.
     * 
     * @return p_Civico
     */
    public java.lang.String getP_Civico() {
        return p_Civico;
    }


    /**
     * Sets the p_Civico value for this Norm_Indirizzo2InputParams.
     * 
     * @param p_Civico
     */
    public void setP_Civico(java.lang.String p_Civico) {
        this.p_Civico = p_Civico;
    }


    /**
     * Gets the p_Toponimo value for this Norm_Indirizzo2InputParams.
     * 
     * @return p_Toponimo
     */
    public java.lang.String getP_Toponimo() {
        return p_Toponimo;
    }


    /**
     * Sets the p_Toponimo value for this Norm_Indirizzo2InputParams.
     * 
     * @param p_Toponimo
     */
    public void setP_Toponimo(java.lang.String p_Toponimo) {
        this.p_Toponimo = p_Toponimo;
    }


    /**
     * Gets the p_Cod_Nazionale value for this Norm_Indirizzo2InputParams.
     * 
     * @return p_Cod_Nazionale
     */
    public java.lang.String getP_Cod_Nazionale() {
        return p_Cod_Nazionale;
    }


    /**
     * Sets the p_Cod_Nazionale value for this Norm_Indirizzo2InputParams.
     * 
     * @param p_Cod_Nazionale
     */
    public void setP_Cod_Nazionale(java.lang.String p_Cod_Nazionale) {
        this.p_Cod_Nazionale = p_Cod_Nazionale;
    }


    /**
     * Gets the p_Cod_Istat value for this Norm_Indirizzo2InputParams.
     * 
     * @return p_Cod_Istat
     */
    public java.lang.String getP_Cod_Istat() {
        return p_Cod_Istat;
    }


    /**
     * Sets the p_Cod_Istat value for this Norm_Indirizzo2InputParams.
     * 
     * @param p_Cod_Istat
     */
    public void setP_Cod_Istat(java.lang.String p_Cod_Istat) {
        this.p_Cod_Istat = p_Cod_Istat;
    }


    /**
     * Gets the p_Provincia value for this Norm_Indirizzo2InputParams.
     * 
     * @return p_Provincia
     */
    public java.lang.String getP_Provincia() {
        return p_Provincia;
    }


    /**
     * Sets the p_Provincia value for this Norm_Indirizzo2InputParams.
     * 
     * @param p_Provincia
     */
    public void setP_Provincia(java.lang.String p_Provincia) {
        this.p_Provincia = p_Provincia;
    }


    /**
     * Gets the p_Comune value for this Norm_Indirizzo2InputParams.
     * 
     * @return p_Comune
     */
    public java.lang.String getP_Comune() {
        return p_Comune;
    }


    /**
     * Sets the p_Comune value for this Norm_Indirizzo2InputParams.
     * 
     * @param p_Comune
     */
    public void setP_Comune(java.lang.String p_Comune) {
        this.p_Comune = p_Comune;
    }


    /**
     * Gets the p_Handle value for this Norm_Indirizzo2InputParams.
     * 
     * @return p_Handle
     */
    public java.lang.String getP_Handle() {
        return p_Handle;
    }


    /**
     * Sets the p_Handle value for this Norm_Indirizzo2InputParams.
     * 
     * @param p_Handle
     */
    public void setP_Handle(java.lang.String p_Handle) {
        this.p_Handle = p_Handle;
    }


    /**
     * Gets the p_Cod_Catastale value for this Norm_Indirizzo2InputParams.
     * 
     * @return p_Cod_Catastale
     */
    public java.lang.String getP_Cod_Catastale() {
        return p_Cod_Catastale;
    }


    /**
     * Sets the p_Cod_Catastale value for this Norm_Indirizzo2InputParams.
     * 
     * @param p_Cod_Catastale
     */
    public void setP_Cod_Catastale(java.lang.String p_Cod_Catastale) {
        this.p_Cod_Catastale = p_Cod_Catastale;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_Indirizzo2InputParams)) return false;
        Norm_Indirizzo2InputParams other = (Norm_Indirizzo2InputParams) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.p_Civico==null && other.getP_Civico()==null) || 
             (this.p_Civico!=null &&
              this.p_Civico.equals(other.getP_Civico()))) &&
            ((this.p_Toponimo==null && other.getP_Toponimo()==null) || 
             (this.p_Toponimo!=null &&
              this.p_Toponimo.equals(other.getP_Toponimo()))) &&
            ((this.p_Cod_Nazionale==null && other.getP_Cod_Nazionale()==null) || 
             (this.p_Cod_Nazionale!=null &&
              this.p_Cod_Nazionale.equals(other.getP_Cod_Nazionale()))) &&
            ((this.p_Cod_Istat==null && other.getP_Cod_Istat()==null) || 
             (this.p_Cod_Istat!=null &&
              this.p_Cod_Istat.equals(other.getP_Cod_Istat()))) &&
            ((this.p_Provincia==null && other.getP_Provincia()==null) || 
             (this.p_Provincia!=null &&
              this.p_Provincia.equals(other.getP_Provincia()))) &&
            ((this.p_Comune==null && other.getP_Comune()==null) || 
             (this.p_Comune!=null &&
              this.p_Comune.equals(other.getP_Comune()))) &&
            ((this.p_Handle==null && other.getP_Handle()==null) || 
             (this.p_Handle!=null &&
              this.p_Handle.equals(other.getP_Handle()))) &&
            ((this.p_Cod_Catastale==null && other.getP_Cod_Catastale()==null) || 
             (this.p_Cod_Catastale!=null &&
              this.p_Cod_Catastale.equals(other.getP_Cod_Catastale())));
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
        if (getP_Civico() != null) {
            _hashCode += getP_Civico().hashCode();
        }
        if (getP_Toponimo() != null) {
            _hashCode += getP_Toponimo().hashCode();
        }
        if (getP_Cod_Nazionale() != null) {
            _hashCode += getP_Cod_Nazionale().hashCode();
        }
        if (getP_Cod_Istat() != null) {
            _hashCode += getP_Cod_Istat().hashCode();
        }
        if (getP_Provincia() != null) {
            _hashCode += getP_Provincia().hashCode();
        }
        if (getP_Comune() != null) {
            _hashCode += getP_Comune().hashCode();
        }
        if (getP_Handle() != null) {
            _hashCode += getP_Handle().hashCode();
        }
        if (getP_Cod_Catastale() != null) {
            _hashCode += getP_Cod_Catastale().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_Indirizzo2InputParams.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo2InputParams"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_Civico");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_Civico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_Toponimo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_Toponimo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_Cod_Nazionale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_Cod_Nazionale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_Cod_Istat");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_Cod_Istat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_Provincia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_Provincia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_Comune");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_Comune"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_Handle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_Handle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_Cod_Catastale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_Cod_Catastale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
