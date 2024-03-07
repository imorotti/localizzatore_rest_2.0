/**
 * Norm_IncrocioSoapOutElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_IncrocioSoapOutElement  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_IncrocioOutput norm_IncrocioOutput;

    public Norm_IncrocioSoapOutElement() {
    }

    public Norm_IncrocioSoapOutElement(
           e_SOAPDispenser.Normalizzatore.Norm_IncrocioOutput norm_IncrocioOutput) {
           this.norm_IncrocioOutput = norm_IncrocioOutput;
    }


    /**
     * Gets the norm_IncrocioOutput value for this Norm_IncrocioSoapOutElement.
     * 
     * @return norm_IncrocioOutput
     */
    public e_SOAPDispenser.Normalizzatore.Norm_IncrocioOutput getNorm_IncrocioOutput() {
        return norm_IncrocioOutput;
    }


    /**
     * Sets the norm_IncrocioOutput value for this Norm_IncrocioSoapOutElement.
     * 
     * @param norm_IncrocioOutput
     */
    public void setNorm_IncrocioOutput(e_SOAPDispenser.Normalizzatore.Norm_IncrocioOutput norm_IncrocioOutput) {
        this.norm_IncrocioOutput = norm_IncrocioOutput;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_IncrocioSoapOutElement)) return false;
        Norm_IncrocioSoapOutElement other = (Norm_IncrocioSoapOutElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_IncrocioOutput==null && other.getNorm_IncrocioOutput()==null) || 
             (this.norm_IncrocioOutput!=null &&
              this.norm_IncrocioOutput.equals(other.getNorm_IncrocioOutput())));
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
        if (getNorm_IncrocioOutput() != null) {
            _hashCode += getNorm_IncrocioOutput().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_IncrocioSoapOutElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_IncrocioSoapOutElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_IncrocioOutput");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IncrocioOutput"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IncrocioOutput"));
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
