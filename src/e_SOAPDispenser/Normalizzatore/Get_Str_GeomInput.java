/**
 * Get_Str_GeomInput.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Get_Str_GeomInput  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Get_Str_GeomInputParams get_Str_GeomInputParams;
    private e_SOAPDispenser.Normalizzatore.InputFilter inputFilter;

    public Get_Str_GeomInput() {
    }

    public Get_Str_GeomInput(
           e_SOAPDispenser.Normalizzatore.Get_Str_GeomInputParams get_Str_GeomInputParams,
           e_SOAPDispenser.Normalizzatore.InputFilter inputFilter) {
           this.get_Str_GeomInputParams = get_Str_GeomInputParams;
           this.inputFilter = inputFilter;
    }


    /**
     * Gets the get_Str_GeomInputParams value for this Get_Str_GeomInput.
     * 
     * @return get_Str_GeomInputParams
     */
    public e_SOAPDispenser.Normalizzatore.Get_Str_GeomInputParams getGet_Str_GeomInputParams() {
        return get_Str_GeomInputParams;
    }


    /**
     * Sets the get_Str_GeomInputParams value for this Get_Str_GeomInput.
     * 
     * @param get_Str_GeomInputParams
     */
    public void setGet_Str_GeomInputParams(e_SOAPDispenser.Normalizzatore.Get_Str_GeomInputParams get_Str_GeomInputParams) {
        this.get_Str_GeomInputParams = get_Str_GeomInputParams;
    }


    /**
     * Gets the inputFilter value for this Get_Str_GeomInput.
     * 
     * @return inputFilter
     */
    public e_SOAPDispenser.Normalizzatore.InputFilter getInputFilter() {
        return inputFilter;
    }


    /**
     * Sets the inputFilter value for this Get_Str_GeomInput.
     * 
     * @param inputFilter
     */
    public void setInputFilter(e_SOAPDispenser.Normalizzatore.InputFilter inputFilter) {
        this.inputFilter = inputFilter;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Get_Str_GeomInput)) return false;
        Get_Str_GeomInput other = (Get_Str_GeomInput) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.get_Str_GeomInputParams==null && other.getGet_Str_GeomInputParams()==null) || 
             (this.get_Str_GeomInputParams!=null &&
              this.get_Str_GeomInputParams.equals(other.getGet_Str_GeomInputParams()))) &&
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
        if (getGet_Str_GeomInputParams() != null) {
            _hashCode += getGet_Str_GeomInputParams().hashCode();
        }
        if (getInputFilter() != null) {
            _hashCode += getInputFilter().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Get_Str_GeomInput.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Str_GeomInput"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("get_Str_GeomInputParams");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Str_GeomInputParams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Str_GeomInputParams"));
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
