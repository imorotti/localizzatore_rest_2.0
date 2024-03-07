/**
 * Norm_EdificioInput.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_EdificioInput  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_EdificioInputParams norm_EdificioInputParams;
    private e_SOAPDispenser.Normalizzatore.InputFilter inputFilter;

    public Norm_EdificioInput() {
    }

    public Norm_EdificioInput(
           e_SOAPDispenser.Normalizzatore.Norm_EdificioInputParams norm_EdificioInputParams,
           e_SOAPDispenser.Normalizzatore.InputFilter inputFilter) {
           this.norm_EdificioInputParams = norm_EdificioInputParams;
           this.inputFilter = inputFilter;
    }


    /**
     * Gets the norm_EdificioInputParams value for this Norm_EdificioInput.
     * 
     * @return norm_EdificioInputParams
     */
    public e_SOAPDispenser.Normalizzatore.Norm_EdificioInputParams getNorm_EdificioInputParams() {
        return norm_EdificioInputParams;
    }


    /**
     * Sets the norm_EdificioInputParams value for this Norm_EdificioInput.
     * 
     * @param norm_EdificioInputParams
     */
    public void setNorm_EdificioInputParams(e_SOAPDispenser.Normalizzatore.Norm_EdificioInputParams norm_EdificioInputParams) {
        this.norm_EdificioInputParams = norm_EdificioInputParams;
    }


    /**
     * Gets the inputFilter value for this Norm_EdificioInput.
     * 
     * @return inputFilter
     */
    public e_SOAPDispenser.Normalizzatore.InputFilter getInputFilter() {
        return inputFilter;
    }


    /**
     * Sets the inputFilter value for this Norm_EdificioInput.
     * 
     * @param inputFilter
     */
    public void setInputFilter(e_SOAPDispenser.Normalizzatore.InputFilter inputFilter) {
        this.inputFilter = inputFilter;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_EdificioInput)) return false;
        Norm_EdificioInput other = (Norm_EdificioInput) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_EdificioInputParams==null && other.getNorm_EdificioInputParams()==null) || 
             (this.norm_EdificioInputParams!=null &&
              this.norm_EdificioInputParams.equals(other.getNorm_EdificioInputParams()))) &&
            ((this.inputFilter==null && other.getInputFilter()==null) || 
             (this.inputFilter!=null &&
              this.inputFilter.equals(other.getInputFilter())));
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
        if (getNorm_EdificioInputParams() != null) {
            _hashCode += getNorm_EdificioInputParams().hashCode();
        }
        if (getInputFilter() != null) {
            _hashCode += getInputFilter().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_EdificioInput.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_EdificioInput"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_EdificioInputParams");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_EdificioInputParams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_EdificioInputParams"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inputFilter");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "InputFilter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "InputFilter"));
        elemField.setMinOccurs(0);
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
