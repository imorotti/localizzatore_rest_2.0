/**
 * Norm_Indirizzo1SoapOutElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_Indirizzo1SoapOutElement  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1Output norm_Indirizzo1Output;

    public Norm_Indirizzo1SoapOutElement() {
    }

    public Norm_Indirizzo1SoapOutElement(
           e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1Output norm_Indirizzo1Output) {
           this.norm_Indirizzo1Output = norm_Indirizzo1Output;
    }


    /**
     * Gets the norm_Indirizzo1Output value for this Norm_Indirizzo1SoapOutElement.
     * 
     * @return norm_Indirizzo1Output
     */
    public e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1Output getNorm_Indirizzo1Output() {
        return norm_Indirizzo1Output;
    }


    /**
     * Sets the norm_Indirizzo1Output value for this Norm_Indirizzo1SoapOutElement.
     * 
     * @param norm_Indirizzo1Output
     */
    public void setNorm_Indirizzo1Output(e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1Output norm_Indirizzo1Output) {
        this.norm_Indirizzo1Output = norm_Indirizzo1Output;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_Indirizzo1SoapOutElement)) return false;
        Norm_Indirizzo1SoapOutElement other = (Norm_Indirizzo1SoapOutElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_Indirizzo1Output==null && other.getNorm_Indirizzo1Output()==null) || 
             (this.norm_Indirizzo1Output!=null &&
              this.norm_Indirizzo1Output.equals(other.getNorm_Indirizzo1Output())));
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
        if (getNorm_Indirizzo1Output() != null) {
            _hashCode += getNorm_Indirizzo1Output().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_Indirizzo1SoapOutElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Indirizzo1SoapOutElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_Indirizzo1Output");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo1Output"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo1Output"));
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
