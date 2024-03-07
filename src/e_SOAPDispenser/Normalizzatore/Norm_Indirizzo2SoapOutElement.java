/**
 * Norm_Indirizzo2SoapOutElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_Indirizzo2SoapOutElement  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_Indirizzo2Output norm_Indirizzo2Output;

    public Norm_Indirizzo2SoapOutElement() {
    }

    public Norm_Indirizzo2SoapOutElement(
           e_SOAPDispenser.Normalizzatore.Norm_Indirizzo2Output norm_Indirizzo2Output) {
           this.norm_Indirizzo2Output = norm_Indirizzo2Output;
    }


    /**
     * Gets the norm_Indirizzo2Output value for this Norm_Indirizzo2SoapOutElement.
     * 
     * @return norm_Indirizzo2Output
     */
    public e_SOAPDispenser.Normalizzatore.Norm_Indirizzo2Output getNorm_Indirizzo2Output() {
        return norm_Indirizzo2Output;
    }


    /**
     * Sets the norm_Indirizzo2Output value for this Norm_Indirizzo2SoapOutElement.
     * 
     * @param norm_Indirizzo2Output
     */
    public void setNorm_Indirizzo2Output(e_SOAPDispenser.Normalizzatore.Norm_Indirizzo2Output norm_Indirizzo2Output) {
        this.norm_Indirizzo2Output = norm_Indirizzo2Output;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_Indirizzo2SoapOutElement)) return false;
        Norm_Indirizzo2SoapOutElement other = (Norm_Indirizzo2SoapOutElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_Indirizzo2Output==null && other.getNorm_Indirizzo2Output()==null) || 
             (this.norm_Indirizzo2Output!=null &&
              this.norm_Indirizzo2Output.equals(other.getNorm_Indirizzo2Output())));
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
        if (getNorm_Indirizzo2Output() != null) {
            _hashCode += getNorm_Indirizzo2Output().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_Indirizzo2SoapOutElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Indirizzo2SoapOutElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_Indirizzo2Output");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo2Output"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo2Output"));
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
