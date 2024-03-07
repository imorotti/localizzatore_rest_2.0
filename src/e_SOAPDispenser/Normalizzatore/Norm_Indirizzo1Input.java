/**
 * Norm_Indirizzo1Input.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_Indirizzo1Input  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1InputParams norm_Indirizzo1InputParams;
    private e_SOAPDispenser.Normalizzatore.InputFilter inputFilter;

    public Norm_Indirizzo1Input() {
    }

    public Norm_Indirizzo1Input(
           e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1InputParams norm_Indirizzo1InputParams,
           e_SOAPDispenser.Normalizzatore.InputFilter inputFilter) {
           this.norm_Indirizzo1InputParams = norm_Indirizzo1InputParams;
           this.inputFilter = inputFilter;
    }


    /**
     * Gets the norm_Indirizzo1InputParams value for this Norm_Indirizzo1Input.
     * 
     * @return norm_Indirizzo1InputParams
     */
    public e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1InputParams getNorm_Indirizzo1InputParams() {
        return norm_Indirizzo1InputParams;
    }


    /**
     * Sets the norm_Indirizzo1InputParams value for this Norm_Indirizzo1Input.
     * 
     * @param norm_Indirizzo1InputParams
     */
    public void setNorm_Indirizzo1InputParams(e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1InputParams norm_Indirizzo1InputParams) {
        this.norm_Indirizzo1InputParams = norm_Indirizzo1InputParams;
    }


    /**
     * Gets the inputFilter value for this Norm_Indirizzo1Input.
     * 
     * @return inputFilter
     */
    public e_SOAPDispenser.Normalizzatore.InputFilter getInputFilter() {
        return inputFilter;
    }


    /**
     * Sets the inputFilter value for this Norm_Indirizzo1Input.
     * 
     * @param inputFilter
     */
    public void setInputFilter(e_SOAPDispenser.Normalizzatore.InputFilter inputFilter) {
        this.inputFilter = inputFilter;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_Indirizzo1Input)) return false;
        Norm_Indirizzo1Input other = (Norm_Indirizzo1Input) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_Indirizzo1InputParams==null && other.getNorm_Indirizzo1InputParams()==null) || 
             (this.norm_Indirizzo1InputParams!=null &&
              this.norm_Indirizzo1InputParams.equals(other.getNorm_Indirizzo1InputParams()))) &&
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
        if (getNorm_Indirizzo1InputParams() != null) {
            _hashCode += getNorm_Indirizzo1InputParams().hashCode();
        }
        if (getInputFilter() != null) {
            _hashCode += getInputFilter().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_Indirizzo1Input.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo1Input"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_Indirizzo1InputParams");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo1InputParams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo1InputParams"));
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
