/**
 * Norm_Comune2SoapOutElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_Comune2SoapOutElement  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_Comune2Output norm_Comune2Output;

    public Norm_Comune2SoapOutElement() {
    }

    public Norm_Comune2SoapOutElement(
           e_SOAPDispenser.Normalizzatore.Norm_Comune2Output norm_Comune2Output) {
           this.norm_Comune2Output = norm_Comune2Output;
    }


    /**
     * Gets the norm_Comune2Output value for this Norm_Comune2SoapOutElement.
     * 
     * @return norm_Comune2Output
     */
    public e_SOAPDispenser.Normalizzatore.Norm_Comune2Output getNorm_Comune2Output() {
        return norm_Comune2Output;
    }


    /**
     * Sets the norm_Comune2Output value for this Norm_Comune2SoapOutElement.
     * 
     * @param norm_Comune2Output
     */
    public void setNorm_Comune2Output(e_SOAPDispenser.Normalizzatore.Norm_Comune2Output norm_Comune2Output) {
        this.norm_Comune2Output = norm_Comune2Output;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_Comune2SoapOutElement)) return false;
        Norm_Comune2SoapOutElement other = (Norm_Comune2SoapOutElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_Comune2Output==null && other.getNorm_Comune2Output()==null) || 
             (this.norm_Comune2Output!=null &&
              this.norm_Comune2Output.equals(other.getNorm_Comune2Output())));
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
        if (getNorm_Comune2Output() != null) {
            _hashCode += getNorm_Comune2Output().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_Comune2SoapOutElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Comune2SoapOutElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_Comune2Output");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Comune2Output"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Comune2Output"));
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
