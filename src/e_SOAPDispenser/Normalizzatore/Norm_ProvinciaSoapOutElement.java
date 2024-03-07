/**
 * Norm_ProvinciaSoapOutElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_ProvinciaSoapOutElement  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_ProvinciaOutput norm_ProvinciaOutput;

    public Norm_ProvinciaSoapOutElement() {
    }

    public Norm_ProvinciaSoapOutElement(
           e_SOAPDispenser.Normalizzatore.Norm_ProvinciaOutput norm_ProvinciaOutput) {
           this.norm_ProvinciaOutput = norm_ProvinciaOutput;
    }


    /**
     * Gets the norm_ProvinciaOutput value for this Norm_ProvinciaSoapOutElement.
     * 
     * @return norm_ProvinciaOutput
     */
    public e_SOAPDispenser.Normalizzatore.Norm_ProvinciaOutput getNorm_ProvinciaOutput() {
        return norm_ProvinciaOutput;
    }


    /**
     * Sets the norm_ProvinciaOutput value for this Norm_ProvinciaSoapOutElement.
     * 
     * @param norm_ProvinciaOutput
     */
    public void setNorm_ProvinciaOutput(e_SOAPDispenser.Normalizzatore.Norm_ProvinciaOutput norm_ProvinciaOutput) {
        this.norm_ProvinciaOutput = norm_ProvinciaOutput;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_ProvinciaSoapOutElement)) return false;
        Norm_ProvinciaSoapOutElement other = (Norm_ProvinciaSoapOutElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_ProvinciaOutput==null && other.getNorm_ProvinciaOutput()==null) || 
             (this.norm_ProvinciaOutput!=null &&
              this.norm_ProvinciaOutput.equals(other.getNorm_ProvinciaOutput())));
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
        if (getNorm_ProvinciaOutput() != null) {
            _hashCode += getNorm_ProvinciaOutput().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_ProvinciaSoapOutElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_ProvinciaSoapOutElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_ProvinciaOutput");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_ProvinciaOutput"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_ProvinciaOutput"));
        elemField.setNillable(false);
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
