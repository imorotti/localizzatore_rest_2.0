/**
 * Get_Civ_geomInput.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Get_Civ_geomInput  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Get_Civ_geomInputParams get_Civ_geomInputParams;
    private e_SOAPDispenser.Normalizzatore.InputFilter inputFilter;

    public Get_Civ_geomInput() {
    }

    public Get_Civ_geomInput(
           e_SOAPDispenser.Normalizzatore.Get_Civ_geomInputParams get_Civ_geomInputParams,
           e_SOAPDispenser.Normalizzatore.InputFilter inputFilter) {
           this.get_Civ_geomInputParams = get_Civ_geomInputParams;
           this.inputFilter = inputFilter;
    }


    /**
     * Gets the get_Civ_geomInputParams value for this Get_Civ_geomInput.
     * 
     * @return get_Civ_geomInputParams
     */
    public e_SOAPDispenser.Normalizzatore.Get_Civ_geomInputParams getGet_Civ_geomInputParams() {
        return get_Civ_geomInputParams;
    }


    /**
     * Sets the get_Civ_geomInputParams value for this Get_Civ_geomInput.
     * 
     * @param get_Civ_geomInputParams
     */
    public void setGet_Civ_geomInputParams(e_SOAPDispenser.Normalizzatore.Get_Civ_geomInputParams get_Civ_geomInputParams) {
        this.get_Civ_geomInputParams = get_Civ_geomInputParams;
    }


    /**
     * Gets the inputFilter value for this Get_Civ_geomInput.
     * 
     * @return inputFilter
     */
    public e_SOAPDispenser.Normalizzatore.InputFilter getInputFilter() {
        return inputFilter;
    }


    /**
     * Sets the inputFilter value for this Get_Civ_geomInput.
     * 
     * @param inputFilter
     */
    public void setInputFilter(e_SOAPDispenser.Normalizzatore.InputFilter inputFilter) {
        this.inputFilter = inputFilter;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Get_Civ_geomInput)) return false;
        Get_Civ_geomInput other = (Get_Civ_geomInput) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.get_Civ_geomInputParams==null && other.getGet_Civ_geomInputParams()==null) || 
             (this.get_Civ_geomInputParams!=null &&
              this.get_Civ_geomInputParams.equals(other.getGet_Civ_geomInputParams()))) &&
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
        if (getGet_Civ_geomInputParams() != null) {
            _hashCode += getGet_Civ_geomInputParams().hashCode();
        }
        if (getInputFilter() != null) {
            _hashCode += getInputFilter().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Get_Civ_geomInput.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Civ_geomInput"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("get_Civ_geomInputParams");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Civ_geomInputParams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Civ_geomInputParams"));
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
