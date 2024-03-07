/**
 * Norm_Luoghi_NotevoliInputParams.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_Luoghi_NotevoliInputParams  implements java.io.Serializable {
    private java.lang.String p_Comune;
    private java.lang.String p_Luogo;
    private java.lang.String p_Cod_Catastale;
    private java.lang.String p_Cod_Nazionale;
    private java.lang.String p_Cod_Istat;
    private java.lang.String p_Provincia;
    private java.lang.String p_Handle;
    private java.lang.String p_Tipo_Coord;

    public Norm_Luoghi_NotevoliInputParams() {
    }

    public Norm_Luoghi_NotevoliInputParams(
           java.lang.String p_Comune,
           java.lang.String p_Luogo,
           java.lang.String p_Cod_Catastale,
           java.lang.String p_Cod_Nazionale,
           java.lang.String p_Cod_Istat,
           java.lang.String p_Provincia,
           java.lang.String p_Handle,
           java.lang.String p_Tipo_Coord) {
           this.p_Comune = p_Comune;
           this.p_Luogo = p_Luogo;
           this.p_Cod_Catastale = p_Cod_Catastale;
           this.p_Cod_Nazionale = p_Cod_Nazionale;
           this.p_Cod_Istat = p_Cod_Istat;
           this.p_Provincia = p_Provincia;
           this.p_Handle = p_Handle;
           this.p_Tipo_Coord = p_Tipo_Coord;
    }


    /**
     * Gets the p_Comune value for this Norm_Luoghi_NotevoliInputParams.
     * 
     * @return p_Comune
     */
    public java.lang.String getP_Comune() {
        return p_Comune;
    }


    /**
     * Sets the p_Comune value for this Norm_Luoghi_NotevoliInputParams.
     * 
     * @param p_Comune
     */
    public void setP_Comune(java.lang.String p_Comune) {
        this.p_Comune = p_Comune;
    }


    /**
     * Gets the p_Luogo value for this Norm_Luoghi_NotevoliInputParams.
     * 
     * @return p_Luogo
     */
    public java.lang.String getP_Luogo() {
        return p_Luogo;
    }


    /**
     * Sets the p_Luogo value for this Norm_Luoghi_NotevoliInputParams.
     * 
     * @param p_Luogo
     */
    public void setP_Luogo(java.lang.String p_Luogo) {
        this.p_Luogo = p_Luogo;
    }


    /**
     * Gets the p_Cod_Catastale value for this Norm_Luoghi_NotevoliInputParams.
     * 
     * @return p_Cod_Catastale
     */
    public java.lang.String getP_Cod_Catastale() {
        return p_Cod_Catastale;
    }


    /**
     * Sets the p_Cod_Catastale value for this Norm_Luoghi_NotevoliInputParams.
     * 
     * @param p_Cod_Catastale
     */
    public void setP_Cod_Catastale(java.lang.String p_Cod_Catastale) {
        this.p_Cod_Catastale = p_Cod_Catastale;
    }


    /**
     * Gets the p_Cod_Nazionale value for this Norm_Luoghi_NotevoliInputParams.
     * 
     * @return p_Cod_Nazionale
     */
    public java.lang.String getP_Cod_Nazionale() {
        return p_Cod_Nazionale;
    }


    /**
     * Sets the p_Cod_Nazionale value for this Norm_Luoghi_NotevoliInputParams.
     * 
     * @param p_Cod_Nazionale
     */
    public void setP_Cod_Nazionale(java.lang.String p_Cod_Nazionale) {
        this.p_Cod_Nazionale = p_Cod_Nazionale;
    }


    /**
     * Gets the p_Cod_Istat value for this Norm_Luoghi_NotevoliInputParams.
     * 
     * @return p_Cod_Istat
     */
    public java.lang.String getP_Cod_Istat() {
        return p_Cod_Istat;
    }


    /**
     * Sets the p_Cod_Istat value for this Norm_Luoghi_NotevoliInputParams.
     * 
     * @param p_Cod_Istat
     */
    public void setP_Cod_Istat(java.lang.String p_Cod_Istat) {
        this.p_Cod_Istat = p_Cod_Istat;
    }


    /**
     * Gets the p_Provincia value for this Norm_Luoghi_NotevoliInputParams.
     * 
     * @return p_Provincia
     */
    public java.lang.String getP_Provincia() {
        return p_Provincia;
    }


    /**
     * Sets the p_Provincia value for this Norm_Luoghi_NotevoliInputParams.
     * 
     * @param p_Provincia
     */
    public void setP_Provincia(java.lang.String p_Provincia) {
        this.p_Provincia = p_Provincia;
    }


    /**
     * Gets the p_Handle value for this Norm_Luoghi_NotevoliInputParams.
     * 
     * @return p_Handle
     */
    public java.lang.String getP_Handle() {
        return p_Handle;
    }


    /**
     * Sets the p_Handle value for this Norm_Luoghi_NotevoliInputParams.
     * 
     * @param p_Handle
     */
    public void setP_Handle(java.lang.String p_Handle) {
        this.p_Handle = p_Handle;
    }


    /**
     * Gets the p_Tipo_Coord value for this Norm_Luoghi_NotevoliInputParams.
     * 
     * @return p_Tipo_Coord
     */
    public java.lang.String getP_Tipo_Coord() {
        return p_Tipo_Coord;
    }


    /**
     * Sets the p_Tipo_Coord value for this Norm_Luoghi_NotevoliInputParams.
     * 
     * @param p_Tipo_Coord
     */
    public void setP_Tipo_Coord(java.lang.String p_Tipo_Coord) {
        this.p_Tipo_Coord = p_Tipo_Coord;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_Luoghi_NotevoliInputParams)) return false;
        Norm_Luoghi_NotevoliInputParams other = (Norm_Luoghi_NotevoliInputParams) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.p_Comune==null && other.getP_Comune()==null) || 
             (this.p_Comune!=null &&
              this.p_Comune.equals(other.getP_Comune()))) &&
            ((this.p_Luogo==null && other.getP_Luogo()==null) || 
             (this.p_Luogo!=null &&
              this.p_Luogo.equals(other.getP_Luogo()))) &&
            ((this.p_Cod_Catastale==null && other.getP_Cod_Catastale()==null) || 
             (this.p_Cod_Catastale!=null &&
              this.p_Cod_Catastale.equals(other.getP_Cod_Catastale()))) &&
            ((this.p_Cod_Nazionale==null && other.getP_Cod_Nazionale()==null) || 
             (this.p_Cod_Nazionale!=null &&
              this.p_Cod_Nazionale.equals(other.getP_Cod_Nazionale()))) &&
            ((this.p_Cod_Istat==null && other.getP_Cod_Istat()==null) || 
             (this.p_Cod_Istat!=null &&
              this.p_Cod_Istat.equals(other.getP_Cod_Istat()))) &&
            ((this.p_Provincia==null && other.getP_Provincia()==null) || 
             (this.p_Provincia!=null &&
              this.p_Provincia.equals(other.getP_Provincia()))) &&
            ((this.p_Handle==null && other.getP_Handle()==null) || 
             (this.p_Handle!=null &&
              this.p_Handle.equals(other.getP_Handle()))) &&
            ((this.p_Tipo_Coord==null && other.getP_Tipo_Coord()==null) || 
             (this.p_Tipo_Coord!=null &&
              this.p_Tipo_Coord.equals(other.getP_Tipo_Coord())));
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
        if (getP_Comune() != null) {
            _hashCode += getP_Comune().hashCode();
        }
        if (getP_Luogo() != null) {
            _hashCode += getP_Luogo().hashCode();
        }
        if (getP_Cod_Catastale() != null) {
            _hashCode += getP_Cod_Catastale().hashCode();
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
        if (getP_Handle() != null) {
            _hashCode += getP_Handle().hashCode();
        }
        if (getP_Tipo_Coord() != null) {
            _hashCode += getP_Tipo_Coord().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_Luoghi_NotevoliInputParams.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Luoghi_NotevoliInputParams"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_Comune");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_Comune"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_Luogo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_Luogo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_Cod_Catastale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_Cod_Catastale"));
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
        elemField.setFieldName("p_Handle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_Handle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_Tipo_Coord");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_Tipo_Coord"));
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
