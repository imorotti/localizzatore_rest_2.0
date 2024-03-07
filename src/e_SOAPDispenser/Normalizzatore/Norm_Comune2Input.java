/**
 * Norm_Comune2Input.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_Comune2Input  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_Comune2InputParams norm_Comune2InputParams;
    private e_SOAPDispenser.Normalizzatore.InputFilter inputFilter;

    public Norm_Comune2Input() {
    }

    public Norm_Comune2Input(
           e_SOAPDispenser.Normalizzatore.Norm_Comune2InputParams norm_Comune2InputParams,
           e_SOAPDispenser.Normalizzatore.InputFilter inputFilter) {
           this.norm_Comune2InputParams = norm_Comune2InputParams;
           this.inputFilter = inputFilter;
    }


    /**
     * Gets the norm_Comune2InputParams value for this Norm_Comune2Input.
     * 
     * @return norm_Comune2InputParams
     */
    public e_SOAPDispenser.Normalizzatore.Norm_Comune2InputParams getNorm_Comune2InputParams() {
        return norm_Comune2InputParams;
    }


    /**
     * Sets the norm_Comune2InputParams value for this Norm_Comune2Input.
     * 
     * @param norm_Comune2InputParams
     */
    public void setNorm_Comune2InputParams(e_SOAPDispenser.Normalizzatore.Norm_Comune2InputParams norm_Comune2InputParams) {
        this.norm_Comune2InputParams = norm_Comune2InputParams;
    }


    /**
     * Gets the inputFilter value for this Norm_Comune2Input.
     * 
     * @return inputFilter
     */
    public e_SOAPDispenser.Normalizzatore.InputFilter getInputFilter() {
        return inputFilter;
    }


    /**
     * Sets the inputFilter value for this Norm_Comune2Input.
     * 
     * @param inputFilter
     */
    public void setInputFilter(e_SOAPDispenser.Normalizzatore.InputFilter inputFilter) {
        this.inputFilter = inputFilter;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_Comune2Input)) return false;
        Norm_Comune2Input other = (Norm_Comune2Input) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_Comune2InputParams==null && other.getNorm_Comune2InputParams()==null) || 
             (this.norm_Comune2InputParams!=null &&
              this.norm_Comune2InputParams.equals(other.getNorm_Comune2InputParams()))) &&
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
        if (getNorm_Comune2InputParams() != null) {
            _hashCode += getNorm_Comune2InputParams().hashCode();
        }
        if (getInputFilter() != null) {
            _hashCode += getInputFilter().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_Comune2Input.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Comune2Input"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_Comune2InputParams");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Comune2InputParams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Comune2InputParams"));
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
