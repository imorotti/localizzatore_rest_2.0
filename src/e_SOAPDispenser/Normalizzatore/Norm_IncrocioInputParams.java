/**
 * Norm_IncrocioInputParams.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_IncrocioInputParams  implements java.io.Serializable {
    private java.lang.String p_Comune1;
    private java.lang.String p_Toponimo1;
    private java.lang.String p_Provincia2;
    private java.lang.String p_Comune2;
    private java.lang.String p_Toponimo2;
    private java.lang.String p_Provincia1;
    private java.lang.String p_Handle;
    private java.lang.String p_Tipo_Coord;

    public Norm_IncrocioInputParams() {
    }

    public Norm_IncrocioInputParams(
           java.lang.String p_Comune1,
           java.lang.String p_Toponimo1,
           java.lang.String p_Provincia2,
           java.lang.String p_Comune2,
           java.lang.String p_Toponimo2,
           java.lang.String p_Provincia1,
           java.lang.String p_Handle,
           java.lang.String p_Tipo_Coord) {
           this.p_Comune1 = p_Comune1;
           this.p_Toponimo1 = p_Toponimo1;
           this.p_Provincia2 = p_Provincia2;
           this.p_Comune2 = p_Comune2;
           this.p_Toponimo2 = p_Toponimo2;
           this.p_Provincia1 = p_Provincia1;
           this.p_Handle = p_Handle;
           this.p_Tipo_Coord = p_Tipo_Coord;
    }


    /**
     * Gets the p_Comune1 value for this Norm_IncrocioInputParams.
     * 
     * @return p_Comune1
     */
    public java.lang.String getP_Comune1() {
        return p_Comune1;
    }


    /**
     * Sets the p_Comune1 value for this Norm_IncrocioInputParams.
     * 
     * @param p_Comune1
     */
    public void setP_Comune1(java.lang.String p_Comune1) {
        this.p_Comune1 = p_Comune1;
    }


    /**
     * Gets the p_Toponimo1 value for this Norm_IncrocioInputParams.
     * 
     * @return p_Toponimo1
     */
    public java.lang.String getP_Toponimo1() {
        return p_Toponimo1;
    }


    /**
     * Sets the p_Toponimo1 value for this Norm_IncrocioInputParams.
     * 
     * @param p_Toponimo1
     */
    public void setP_Toponimo1(java.lang.String p_Toponimo1) {
        this.p_Toponimo1 = p_Toponimo1;
    }


    /**
     * Gets the p_Provincia2 value for this Norm_IncrocioInputParams.
     * 
     * @return p_Provincia2
     */
    public java.lang.String getP_Provincia2() {
        return p_Provincia2;
    }


    /**
     * Sets the p_Provincia2 value for this Norm_IncrocioInputParams.
     * 
     * @param p_Provincia2
     */
    public void setP_Provincia2(java.lang.String p_Provincia2) {
        this.p_Provincia2 = p_Provincia2;
    }


    /**
     * Gets the p_Comune2 value for this Norm_IncrocioInputParams.
     * 
     * @return p_Comune2
     */
    public java.lang.String getP_Comune2() {
        return p_Comune2;
    }


    /**
     * Sets the p_Comune2 value for this Norm_IncrocioInputParams.
     * 
     * @param p_Comune2
     */
    public void setP_Comune2(java.lang.String p_Comune2) {
        this.p_Comune2 = p_Comune2;
    }


    /**
     * Gets the p_Toponimo2 value for this Norm_IncrocioInputParams.
     * 
     * @return p_Toponimo2
     */
    public java.lang.String getP_Toponimo2() {
        return p_Toponimo2;
    }


    /**
     * Sets the p_Toponimo2 value for this Norm_IncrocioInputParams.
     * 
     * @param p_Toponimo2
     */
    public void setP_Toponimo2(java.lang.String p_Toponimo2) {
        this.p_Toponimo2 = p_Toponimo2;
    }


    /**
     * Gets the p_Provincia1 value for this Norm_IncrocioInputParams.
     * 
     * @return p_Provincia1
     */
    public java.lang.String getP_Provincia1() {
        return p_Provincia1;
    }


    /**
     * Sets the p_Provincia1 value for this Norm_IncrocioInputParams.
     * 
     * @param p_Provincia1
     */
    public void setP_Provincia1(java.lang.String p_Provincia1) {
        this.p_Provincia1 = p_Provincia1;
    }


    /**
     * Gets the p_Handle value for this Norm_IncrocioInputParams.
     * 
     * @return p_Handle
     */
    public java.lang.String getP_Handle() {
        return p_Handle;
    }


    /**
     * Sets the p_Handle value for this Norm_IncrocioInputParams.
     * 
     * @param p_Handle
     */
    public void setP_Handle(java.lang.String p_Handle) {
        this.p_Handle = p_Handle;
    }


    /**
     * Gets the p_Tipo_Coord value for this Norm_IncrocioInputParams.
     * 
     * @return p_Tipo_Coord
     */
    public java.lang.String getP_Tipo_Coord() {
        return p_Tipo_Coord;
    }


    /**
     * Sets the p_Tipo_Coord value for this Norm_IncrocioInputParams.
     * 
     * @param p_Tipo_Coord
     */
    public void setP_Tipo_Coord(java.lang.String p_Tipo_Coord) {
        this.p_Tipo_Coord = p_Tipo_Coord;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_IncrocioInputParams)) return false;
        Norm_IncrocioInputParams other = (Norm_IncrocioInputParams) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.p_Comune1==null && other.getP_Comune1()==null) || 
             (this.p_Comune1!=null &&
              this.p_Comune1.equals(other.getP_Comune1()))) &&
            ((this.p_Toponimo1==null && other.getP_Toponimo1()==null) || 
             (this.p_Toponimo1!=null &&
              this.p_Toponimo1.equals(other.getP_Toponimo1()))) &&
            ((this.p_Provincia2==null && other.getP_Provincia2()==null) || 
             (this.p_Provincia2!=null &&
              this.p_Provincia2.equals(other.getP_Provincia2()))) &&
            ((this.p_Comune2==null && other.getP_Comune2()==null) || 
             (this.p_Comune2!=null &&
              this.p_Comune2.equals(other.getP_Comune2()))) &&
            ((this.p_Toponimo2==null && other.getP_Toponimo2()==null) || 
             (this.p_Toponimo2!=null &&
              this.p_Toponimo2.equals(other.getP_Toponimo2()))) &&
            ((this.p_Provincia1==null && other.getP_Provincia1()==null) || 
             (this.p_Provincia1!=null &&
              this.p_Provincia1.equals(other.getP_Provincia1()))) &&
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
        if (getP_Comune1() != null) {
            _hashCode += getP_Comune1().hashCode();
        }
        if (getP_Toponimo1() != null) {
            _hashCode += getP_Toponimo1().hashCode();
        }
        if (getP_Provincia2() != null) {
            _hashCode += getP_Provincia2().hashCode();
        }
        if (getP_Comune2() != null) {
            _hashCode += getP_Comune2().hashCode();
        }
        if (getP_Toponimo2() != null) {
            _hashCode += getP_Toponimo2().hashCode();
        }
        if (getP_Provincia1() != null) {
            _hashCode += getP_Provincia1().hashCode();
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
        new org.apache.axis.description.TypeDesc(Norm_IncrocioInputParams.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IncrocioInputParams"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_Comune1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_Comune1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_Toponimo1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_Toponimo1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_Provincia2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_Provincia2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_Comune2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_Comune2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_Toponimo2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_Toponimo2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_Provincia1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "p_Provincia1"));
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
