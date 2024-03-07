/**
 * Get_Tipo_CoordInput.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Get_Tipo_CoordInput  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordInputParams get_Tipo_CoordInputParams;
    private e_SOAPDispenser.Normalizzatore.InputFilter inputFilter;

    public Get_Tipo_CoordInput() {
    }

    public Get_Tipo_CoordInput(
           e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordInputParams get_Tipo_CoordInputParams,
           e_SOAPDispenser.Normalizzatore.InputFilter inputFilter) {
           this.get_Tipo_CoordInputParams = get_Tipo_CoordInputParams;
           this.inputFilter = inputFilter;
    }


    /**
     * Gets the get_Tipo_CoordInputParams value for this Get_Tipo_CoordInput.
     * 
     * @return get_Tipo_CoordInputParams
     */
    public e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordInputParams getGet_Tipo_CoordInputParams() {
        return get_Tipo_CoordInputParams;
    }


    /**
     * Sets the get_Tipo_CoordInputParams value for this Get_Tipo_CoordInput.
     * 
     * @param get_Tipo_CoordInputParams
     */
    public void setGet_Tipo_CoordInputParams(e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordInputParams get_Tipo_CoordInputParams) {
        this.get_Tipo_CoordInputParams = get_Tipo_CoordInputParams;
    }


    /**
     * Gets the inputFilter value for this Get_Tipo_CoordInput.
     * 
     * @return inputFilter
     */
    public e_SOAPDispenser.Normalizzatore.InputFilter getInputFilter() {
        return inputFilter;
    }


    /**
     * Sets the inputFilter value for this Get_Tipo_CoordInput.
     * 
     * @param inputFilter
     */
    public void setInputFilter(e_SOAPDispenser.Normalizzatore.InputFilter inputFilter) {
        this.inputFilter = inputFilter;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Get_Tipo_CoordInput)) return false;
        Get_Tipo_CoordInput other = (Get_Tipo_CoordInput) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.get_Tipo_CoordInputParams==null && other.getGet_Tipo_CoordInputParams()==null) || 
             (this.get_Tipo_CoordInputParams!=null &&
              this.get_Tipo_CoordInputParams.equals(other.getGet_Tipo_CoordInputParams()))) &&
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
        if (getGet_Tipo_CoordInputParams() != null) {
            _hashCode += getGet_Tipo_CoordInputParams().hashCode();
        }
        if (getInputFilter() != null) {
            _hashCode += getInputFilter().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Get_Tipo_CoordInput.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Tipo_CoordInput"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("get_Tipo_CoordInputParams");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Tipo_CoordInputParams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Tipo_CoordInputParams"));
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
