/**
 * Norm_EdificioSoapOutElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_EdificioSoapOutElement  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_EdificioOutput norm_EdificioOutput;

    public Norm_EdificioSoapOutElement() {
    }

    public Norm_EdificioSoapOutElement(
           e_SOAPDispenser.Normalizzatore.Norm_EdificioOutput norm_EdificioOutput) {
           this.norm_EdificioOutput = norm_EdificioOutput;
    }


    /**
     * Gets the norm_EdificioOutput value for this Norm_EdificioSoapOutElement.
     * 
     * @return norm_EdificioOutput
     */
    public e_SOAPDispenser.Normalizzatore.Norm_EdificioOutput getNorm_EdificioOutput() {
        return norm_EdificioOutput;
    }


    /**
     * Sets the norm_EdificioOutput value for this Norm_EdificioSoapOutElement.
     * 
     * @param norm_EdificioOutput
     */
    public void setNorm_EdificioOutput(e_SOAPDispenser.Normalizzatore.Norm_EdificioOutput norm_EdificioOutput) {
        this.norm_EdificioOutput = norm_EdificioOutput;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_EdificioSoapOutElement)) return false;
        Norm_EdificioSoapOutElement other = (Norm_EdificioSoapOutElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_EdificioOutput==null && other.getNorm_EdificioOutput()==null) || 
             (this.norm_EdificioOutput!=null &&
              this.norm_EdificioOutput.equals(other.getNorm_EdificioOutput())));
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
        if (getNorm_EdificioOutput() != null) {
            _hashCode += getNorm_EdificioOutput().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_EdificioSoapOutElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_EdificioSoapOutElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_EdificioOutput");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_EdificioOutput"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_EdificioOutput"));
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
