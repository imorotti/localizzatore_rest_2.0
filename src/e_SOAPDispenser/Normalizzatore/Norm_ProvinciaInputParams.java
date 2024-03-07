/**
 * Norm_ProvinciaInputParams.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_ProvinciaInputParams  implements java.io.Serializable {
    private java.lang.String p_Cod_Nazionale;
    private java.lang.String p_Provincia;
    private java.lang.String p_Handle;
    private java.lang.String p_Cod_Istat;

    public Norm_ProvinciaInputParams() {
    }

    public Norm_ProvinciaInputParams(
           java.lang.String p_Cod_Nazionale,
           java.lang.String p_Provincia,
           java.lang.String p_Handle,
           java.lang.String p_Cod_Istat) {
           this.p_Cod_Nazionale = p_Cod_Nazionale;
           this.p_Provincia = p_Provincia;
           this.p_Handle = p_Handle;
           this.p_Cod_Istat = p_Cod_Istat;
    }


    /**
     * Gets the p_Cod_Nazionale value for this Norm_ProvinciaInputParams.
     * 
     * @return p_Cod_Nazionale
     */
    public java.lang.String getP_Cod_Nazionale() {
        return p_Cod_Nazionale;
    }


    /**
     * Sets the p_Cod_Nazionale value for this Norm_ProvinciaInputParams.
     * 
     * @param p_Cod_Nazionale
     */
    public void setP_Cod_Nazionale(java.lang.String p_Cod_Nazionale) {
        this.p_Cod_Nazionale = p_Cod_Nazionale;
    }


    /**
     * Gets the p_Provincia value for this Norm_ProvinciaInputParams.
     * 
     * @return p_Provincia
     */
    public java.lang.String getP_Provincia() {
        return p_Provincia;
    }


    /**
     * Sets the p_Provincia value for this Norm_ProvinciaInputParams.
     * 
     * @param p_Provincia
     */
    public void setP_Provincia(java.lang.String p_Provincia) {
        this.p_Provincia = p_Provincia;
    }


    /**
     * Gets the p_Handle value for this Norm_ProvinciaInputParams.
     * 
     * @return p_Handle
     */
    public java.lang.String getP_Handle() {
        return p_Handle;
    }


    /**
     * Sets the p_Handle value for this Norm_ProvinciaInputParams.
     * 
     * @param p_Handle
     */
    public void setP_Handle(java.lang.String p_Handle) {
        this.p_Handle = p_Handle;
    }


    /**
     * Gets the p_Cod_Istat value for this Norm_ProvinciaInputParams.
     * 
     * @return p_Cod_Istat
     */
    public java.lang.String getP_Cod_Istat() {
        return p_Cod_Istat;
    }


    /**
     * Sets the p_Cod_Istat value for this Norm_ProvinciaInputParams.
     * 
     * @param p_Cod_Istat
     */
    public void setP_Cod_Istat(java.lang.String p_Cod_Istat) {
        this.p_Cod_Istat = p_Cod_Istat;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_ProvinciaInputParams)) return false;
        Norm_ProvinciaInputParams other = (Norm_ProvinciaInputParams) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.p_Cod_Nazionale==null && other.getP_Cod_Nazionale()==null) || 
             (this.p_Cod_Nazionale!=null &&
              this.p_Cod_Nazionale.equals(other.getP_Cod_Nazionale()))) &&
            ((this.p_Provincia==null && other.getP_Provincia()==null) || 
             (this.p_Provincia!=null &&
              this.p_Provincia.equals(other.getP_Provincia()))) &&
            ((this.p_Handle==null && other.getP_Handle()==null) || 
             (this.p_Handle!=null &&
              this.p_Handle.equals(other.getP_Handle()))) &&
            ((this.p_Cod_Istat==null && other.getP_Cod_Istat()==null) || 
             (this.p_Cod_Istat!=null &&
              this.p_Cod_Istat.equals(other.getP_Cod_Istat())));
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
        if (getP_Cod_Nazionale() != null) {
            _hashCode += getP_Cod_Nazionale().hashCode();
        }
        if (getP_Provincia() != null) {
            _hashCode += getP_Provincia().hashCode();
        }
        if (getP_Handle() != null) {
            _hashCode += getP_Handle().hashCode();
        }
        if (getP_Cod_Istat() != null) {
            _hashCode += getP_Cod_Istat().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_ProvinciaInputParams.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_ProvinciaInputParams"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_Cod_Nazionale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_Cod_Nazionale"));
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
        elemField.setFieldName("p_Cod_Istat");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_Cod_Istat"));
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
