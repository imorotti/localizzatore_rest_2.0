/**
 * Norm_ProvinciaInput.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_ProvinciaInput  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_ProvinciaInputParams norm_ProvinciaInputParams;
    private e_SOAPDispenser.Normalizzatore.InputFilter inputFilter;

    public Norm_ProvinciaInput() {
    }

    public Norm_ProvinciaInput(
           e_SOAPDispenser.Normalizzatore.Norm_ProvinciaInputParams norm_ProvinciaInputParams,
           e_SOAPDispenser.Normalizzatore.InputFilter inputFilter) {
           this.norm_ProvinciaInputParams = norm_ProvinciaInputParams;
           this.inputFilter = inputFilter;
    }


    /**
     * Gets the norm_ProvinciaInputParams value for this Norm_ProvinciaInput.
     * 
     * @return norm_ProvinciaInputParams
     */
    public e_SOAPDispenser.Normalizzatore.Norm_ProvinciaInputParams getNorm_ProvinciaInputParams() {
        return norm_ProvinciaInputParams;
    }


    /**
     * Sets the norm_ProvinciaInputParams value for this Norm_ProvinciaInput.
     * 
     * @param norm_ProvinciaInputParams
     */
    public void setNorm_ProvinciaInputParams(e_SOAPDispenser.Normalizzatore.Norm_ProvinciaInputParams norm_ProvinciaInputParams) {
        this.norm_ProvinciaInputParams = norm_ProvinciaInputParams;
    }


    /**
     * Gets the inputFilter value for this Norm_ProvinciaInput.
     * 
     * @return inputFilter
     */
    public e_SOAPDispenser.Normalizzatore.InputFilter getInputFilter() {
        return inputFilter;
    }


    /**
     * Sets the inputFilter value for this Norm_ProvinciaInput.
     * 
     * @param inputFilter
     */
    public void setInputFilter(e_SOAPDispenser.Normalizzatore.InputFilter inputFilter) {
        this.inputFilter = inputFilter;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_ProvinciaInput)) return false;
        Norm_ProvinciaInput other = (Norm_ProvinciaInput) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_ProvinciaInputParams==null && other.getNorm_ProvinciaInputParams()==null) || 
             (this.norm_ProvinciaInputParams!=null &&
              this.norm_ProvinciaInputParams.equals(other.getNorm_ProvinciaInputParams()))) &&
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
        if (getNorm_ProvinciaInputParams() != null) {
            _hashCode += getNorm_ProvinciaInputParams().hashCode();
        }
        if (getInputFilter() != null) {
            _hashCode += getInputFilter().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_ProvinciaInput.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_ProvinciaInput"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_ProvinciaInputParams");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_ProvinciaInputParams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_ProvinciaInputParams"));
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
