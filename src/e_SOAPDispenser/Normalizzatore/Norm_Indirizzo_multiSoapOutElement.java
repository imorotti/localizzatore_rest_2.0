/**
 * Norm_Indirizzo_multiSoapOutElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_Indirizzo_multiSoapOutElement  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiOutput norm_Indirizzo_multiOutput;

    public Norm_Indirizzo_multiSoapOutElement() {
    }

    public Norm_Indirizzo_multiSoapOutElement(
           e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiOutput norm_Indirizzo_multiOutput) {
           this.norm_Indirizzo_multiOutput = norm_Indirizzo_multiOutput;
    }


    /**
     * Gets the norm_Indirizzo_multiOutput value for this Norm_Indirizzo_multiSoapOutElement.
     * 
     * @return norm_Indirizzo_multiOutput
     */
    public e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiOutput getNorm_Indirizzo_multiOutput() {
        return norm_Indirizzo_multiOutput;
    }


    /**
     * Sets the norm_Indirizzo_multiOutput value for this Norm_Indirizzo_multiSoapOutElement.
     * 
     * @param norm_Indirizzo_multiOutput
     */
    public void setNorm_Indirizzo_multiOutput(e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiOutput norm_Indirizzo_multiOutput) {
        this.norm_Indirizzo_multiOutput = norm_Indirizzo_multiOutput;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_Indirizzo_multiSoapOutElement)) return false;
        Norm_Indirizzo_multiSoapOutElement other = (Norm_Indirizzo_multiSoapOutElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_Indirizzo_multiOutput==null && other.getNorm_Indirizzo_multiOutput()==null) || 
             (this.norm_Indirizzo_multiOutput!=null &&
              this.norm_Indirizzo_multiOutput.equals(other.getNorm_Indirizzo_multiOutput())));
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
        if (getNorm_Indirizzo_multiOutput() != null) {
            _hashCode += getNorm_Indirizzo_multiOutput().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_Indirizzo_multiSoapOutElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Indirizzo_multiSoapOutElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_Indirizzo_multiOutput");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_multiOutput"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_multiOutput"));
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
