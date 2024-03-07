/**
 * Norm_Luoghi_NotevoliSoapOutElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_Luoghi_NotevoliSoapOutElement  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliOutput norm_Luoghi_NotevoliOutput;

    public Norm_Luoghi_NotevoliSoapOutElement() {
    }

    public Norm_Luoghi_NotevoliSoapOutElement(
           e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliOutput norm_Luoghi_NotevoliOutput) {
           this.norm_Luoghi_NotevoliOutput = norm_Luoghi_NotevoliOutput;
    }


    /**
     * Gets the norm_Luoghi_NotevoliOutput value for this Norm_Luoghi_NotevoliSoapOutElement.
     * 
     * @return norm_Luoghi_NotevoliOutput
     */
    public e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliOutput getNorm_Luoghi_NotevoliOutput() {
        return norm_Luoghi_NotevoliOutput;
    }


    /**
     * Sets the norm_Luoghi_NotevoliOutput value for this Norm_Luoghi_NotevoliSoapOutElement.
     * 
     * @param norm_Luoghi_NotevoliOutput
     */
    public void setNorm_Luoghi_NotevoliOutput(e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliOutput norm_Luoghi_NotevoliOutput) {
        this.norm_Luoghi_NotevoliOutput = norm_Luoghi_NotevoliOutput;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_Luoghi_NotevoliSoapOutElement)) return false;
        Norm_Luoghi_NotevoliSoapOutElement other = (Norm_Luoghi_NotevoliSoapOutElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_Luoghi_NotevoliOutput==null && other.getNorm_Luoghi_NotevoliOutput()==null) || 
             (this.norm_Luoghi_NotevoliOutput!=null &&
              this.norm_Luoghi_NotevoliOutput.equals(other.getNorm_Luoghi_NotevoliOutput())));
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
        if (getNorm_Luoghi_NotevoliOutput() != null) {
            _hashCode += getNorm_Luoghi_NotevoliOutput().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_Luoghi_NotevoliSoapOutElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Luoghi_NotevoliSoapOutElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_Luoghi_NotevoliOutput");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Luoghi_NotevoliOutput"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Luoghi_NotevoliOutput"));
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
