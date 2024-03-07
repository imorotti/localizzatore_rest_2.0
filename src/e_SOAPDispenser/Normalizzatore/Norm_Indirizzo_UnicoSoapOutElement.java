/**
 * Norm_Indirizzo_UnicoSoapOutElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_Indirizzo_UnicoSoapOutElement  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoOutput norm_Indirizzo_UnicoOutput;

    public Norm_Indirizzo_UnicoSoapOutElement() {
    }

    public Norm_Indirizzo_UnicoSoapOutElement(
           e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoOutput norm_Indirizzo_UnicoOutput) {
           this.norm_Indirizzo_UnicoOutput = norm_Indirizzo_UnicoOutput;
    }


    /**
     * Gets the norm_Indirizzo_UnicoOutput value for this Norm_Indirizzo_UnicoSoapOutElement.
     * 
     * @return norm_Indirizzo_UnicoOutput
     */
    public e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoOutput getNorm_Indirizzo_UnicoOutput() {
        return norm_Indirizzo_UnicoOutput;
    }


    /**
     * Sets the norm_Indirizzo_UnicoOutput value for this Norm_Indirizzo_UnicoSoapOutElement.
     * 
     * @param norm_Indirizzo_UnicoOutput
     */
    public void setNorm_Indirizzo_UnicoOutput(e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoOutput norm_Indirizzo_UnicoOutput) {
        this.norm_Indirizzo_UnicoOutput = norm_Indirizzo_UnicoOutput;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_Indirizzo_UnicoSoapOutElement)) return false;
        Norm_Indirizzo_UnicoSoapOutElement other = (Norm_Indirizzo_UnicoSoapOutElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_Indirizzo_UnicoOutput==null && other.getNorm_Indirizzo_UnicoOutput()==null) || 
             (this.norm_Indirizzo_UnicoOutput!=null &&
              this.norm_Indirizzo_UnicoOutput.equals(other.getNorm_Indirizzo_UnicoOutput())));
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
        if (getNorm_Indirizzo_UnicoOutput() != null) {
            _hashCode += getNorm_Indirizzo_UnicoOutput().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_Indirizzo_UnicoSoapOutElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Indirizzo_UnicoSoapOutElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_Indirizzo_UnicoOutput");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_UnicoOutput"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_UnicoOutput"));
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
