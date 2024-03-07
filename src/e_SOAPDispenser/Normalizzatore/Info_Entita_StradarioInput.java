/**
 * Info_Entita_StradarioInput.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Info_Entita_StradarioInput  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Info_Entita_StradarioInputParams info_Entita_StradarioInputParams;
    private e_SOAPDispenser.Normalizzatore.InputFilter inputFilter;

    public Info_Entita_StradarioInput() {
    }

    public Info_Entita_StradarioInput(
           e_SOAPDispenser.Normalizzatore.Info_Entita_StradarioInputParams info_Entita_StradarioInputParams,
           e_SOAPDispenser.Normalizzatore.InputFilter inputFilter) {
           this.info_Entita_StradarioInputParams = info_Entita_StradarioInputParams;
           this.inputFilter = inputFilter;
    }


    /**
     * Gets the info_Entita_StradarioInputParams value for this Info_Entita_StradarioInput.
     * 
     * @return info_Entita_StradarioInputParams
     */
    public e_SOAPDispenser.Normalizzatore.Info_Entita_StradarioInputParams getInfo_Entita_StradarioInputParams() {
        return info_Entita_StradarioInputParams;
    }


    /**
     * Sets the info_Entita_StradarioInputParams value for this Info_Entita_StradarioInput.
     * 
     * @param info_Entita_StradarioInputParams
     */
    public void setInfo_Entita_StradarioInputParams(e_SOAPDispenser.Normalizzatore.Info_Entita_StradarioInputParams info_Entita_StradarioInputParams) {
        this.info_Entita_StradarioInputParams = info_Entita_StradarioInputParams;
    }


    /**
     * Gets the inputFilter value for this Info_Entita_StradarioInput.
     * 
     * @return inputFilter
     */
    public e_SOAPDispenser.Normalizzatore.InputFilter getInputFilter() {
        return inputFilter;
    }


    /**
     * Sets the inputFilter value for this Info_Entita_StradarioInput.
     * 
     * @param inputFilter
     */
    public void setInputFilter(e_SOAPDispenser.Normalizzatore.InputFilter inputFilter) {
        this.inputFilter = inputFilter;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Info_Entita_StradarioInput)) return false;
        Info_Entita_StradarioInput other = (Info_Entita_StradarioInput) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.info_Entita_StradarioInputParams==null && other.getInfo_Entita_StradarioInputParams()==null) || 
             (this.info_Entita_StradarioInputParams!=null &&
              this.info_Entita_StradarioInputParams.equals(other.getInfo_Entita_StradarioInputParams()))) &&
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
        if (getInfo_Entita_StradarioInputParams() != null) {
            _hashCode += getInfo_Entita_StradarioInputParams().hashCode();
        }
        if (getInputFilter() != null) {
            _hashCode += getInputFilter().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Info_Entita_StradarioInput.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Info_Entita_StradarioInput"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("info_Entita_StradarioInputParams");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Info_Entita_StradarioInputParams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Info_Entita_StradarioInputParams"));
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
