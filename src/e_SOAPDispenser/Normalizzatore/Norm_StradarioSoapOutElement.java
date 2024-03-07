/**
 * Norm_StradarioSoapOutElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_StradarioSoapOutElement  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_StradarioOutput norm_StradarioOutput;

    public Norm_StradarioSoapOutElement() {
    }

    public Norm_StradarioSoapOutElement(
           e_SOAPDispenser.Normalizzatore.Norm_StradarioOutput norm_StradarioOutput) {
           this.norm_StradarioOutput = norm_StradarioOutput;
    }


    /**
     * Gets the norm_StradarioOutput value for this Norm_StradarioSoapOutElement.
     * 
     * @return norm_StradarioOutput
     */
    public e_SOAPDispenser.Normalizzatore.Norm_StradarioOutput getNorm_StradarioOutput() {
        return norm_StradarioOutput;
    }


    /**
     * Sets the norm_StradarioOutput value for this Norm_StradarioSoapOutElement.
     * 
     * @param norm_StradarioOutput
     */
    public void setNorm_StradarioOutput(e_SOAPDispenser.Normalizzatore.Norm_StradarioOutput norm_StradarioOutput) {
        this.norm_StradarioOutput = norm_StradarioOutput;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_StradarioSoapOutElement)) return false;
        Norm_StradarioSoapOutElement other = (Norm_StradarioSoapOutElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_StradarioOutput==null && other.getNorm_StradarioOutput()==null) || 
             (this.norm_StradarioOutput!=null &&
              this.norm_StradarioOutput.equals(other.getNorm_StradarioOutput())));
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
        if (getNorm_StradarioOutput() != null) {
            _hashCode += getNorm_StradarioOutput().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_StradarioSoapOutElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_StradarioSoapOutElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_StradarioOutput");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_StradarioOutput"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_StradarioOutput"));
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
