/**
 * Norm_Indirizzo_UnicoInputParams.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_Indirizzo_UnicoInputParams  implements java.io.Serializable {
    private java.lang.String p_Tipo_Coord;
    private byte[] p_Indirizzo;
    private java.lang.String p_Fonte_Cod;
    private java.lang.String p_Rif_Geo_Civ;

    public Norm_Indirizzo_UnicoInputParams() {
    }

    public Norm_Indirizzo_UnicoInputParams(
           java.lang.String p_Tipo_Coord,
           byte[] p_Indirizzo,
           java.lang.String p_Fonte_Cod,
           java.lang.String p_Rif_Geo_Civ) {
           this.p_Tipo_Coord = p_Tipo_Coord;
           this.p_Indirizzo = p_Indirizzo;
           this.p_Fonte_Cod = p_Fonte_Cod;
           this.p_Rif_Geo_Civ = p_Rif_Geo_Civ;
    }


    /**
     * Gets the p_Tipo_Coord value for this Norm_Indirizzo_UnicoInputParams.
     * 
     * @return p_Tipo_Coord
     */
    public java.lang.String getP_Tipo_Coord() {
        return p_Tipo_Coord;
    }


    /**
     * Sets the p_Tipo_Coord value for this Norm_Indirizzo_UnicoInputParams.
     * 
     * @param p_Tipo_Coord
     */
    public void setP_Tipo_Coord(java.lang.String p_Tipo_Coord) {
        this.p_Tipo_Coord = p_Tipo_Coord;
    }


    /**
     * Gets the p_Indirizzo value for this Norm_Indirizzo_UnicoInputParams.
     * 
     * @return p_Indirizzo
     */
    public byte[] getP_Indirizzo() {
        return p_Indirizzo;
    }


    /**
     * Sets the p_Indirizzo value for this Norm_Indirizzo_UnicoInputParams.
     * 
     * @param p_Indirizzo
     */
    public void setP_Indirizzo(byte[] p_Indirizzo) {
        this.p_Indirizzo = p_Indirizzo;
    }


    /**
     * Gets the p_Fonte_Cod value for this Norm_Indirizzo_UnicoInputParams.
     * 
     * @return p_Fonte_Cod
     */
    public java.lang.String getP_Fonte_Cod() {
        return p_Fonte_Cod;
    }


    /**
     * Sets the p_Fonte_Cod value for this Norm_Indirizzo_UnicoInputParams.
     * 
     * @param p_Fonte_Cod
     */
    public void setP_Fonte_Cod(java.lang.String p_Fonte_Cod) {
        this.p_Fonte_Cod = p_Fonte_Cod;
    }


    /**
     * Gets the p_Rif_Geo_Civ value for this Norm_Indirizzo_UnicoInputParams.
     * 
     * @return p_Rif_Geo_Civ
     */
    public java.lang.String getP_Rif_Geo_Civ() {
        return p_Rif_Geo_Civ;
    }


    /**
     * Sets the p_Rif_Geo_Civ value for this Norm_Indirizzo_UnicoInputParams.
     * 
     * @param p_Rif_Geo_Civ
     */
    public void setP_Rif_Geo_Civ(java.lang.String p_Rif_Geo_Civ) {
        this.p_Rif_Geo_Civ = p_Rif_Geo_Civ;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_Indirizzo_UnicoInputParams)) return false;
        Norm_Indirizzo_UnicoInputParams other = (Norm_Indirizzo_UnicoInputParams) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.p_Tipo_Coord==null && other.getP_Tipo_Coord()==null) || 
             (this.p_Tipo_Coord!=null &&
              this.p_Tipo_Coord.equals(other.getP_Tipo_Coord()))) &&
            ((this.p_Indirizzo==null && other.getP_Indirizzo()==null) || 
             (this.p_Indirizzo!=null &&
              java.util.Arrays.equals(this.p_Indirizzo, other.getP_Indirizzo()))) &&
            ((this.p_Fonte_Cod==null && other.getP_Fonte_Cod()==null) || 
             (this.p_Fonte_Cod!=null &&
              this.p_Fonte_Cod.equals(other.getP_Fonte_Cod()))) &&
            ((this.p_Rif_Geo_Civ==null && other.getP_Rif_Geo_Civ()==null) || 
             (this.p_Rif_Geo_Civ!=null &&
              this.p_Rif_Geo_Civ.equals(other.getP_Rif_Geo_Civ())));
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
        if (getP_Tipo_Coord() != null) {
            _hashCode += getP_Tipo_Coord().hashCode();
        }
        if (getP_Indirizzo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getP_Indirizzo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getP_Indirizzo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getP_Fonte_Cod() != null) {
            _hashCode += getP_Fonte_Cod().hashCode();
        }
        if (getP_Rif_Geo_Civ() != null) {
            _hashCode += getP_Rif_Geo_Civ().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_Indirizzo_UnicoInputParams.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_UnicoInputParams"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_Tipo_Coord");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_Tipo_Coord"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_Indirizzo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_Indirizzo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_Fonte_Cod");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_Fonte_Cod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_Rif_Geo_Civ");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_Rif_Geo_Civ"));
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
