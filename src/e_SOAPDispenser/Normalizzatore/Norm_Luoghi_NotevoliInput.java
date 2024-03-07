/**
 * Norm_Luoghi_NotevoliInput.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_Luoghi_NotevoliInput  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliInputParams norm_Luoghi_NotevoliInputParams;
    private e_SOAPDispenser.Normalizzatore.InputFilter inputFilter;

    public Norm_Luoghi_NotevoliInput() {
    }

    public Norm_Luoghi_NotevoliInput(
           e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliInputParams norm_Luoghi_NotevoliInputParams,
           e_SOAPDispenser.Normalizzatore.InputFilter inputFilter) {
           this.norm_Luoghi_NotevoliInputParams = norm_Luoghi_NotevoliInputParams;
           this.inputFilter = inputFilter;
    }


    /**
     * Gets the norm_Luoghi_NotevoliInputParams value for this Norm_Luoghi_NotevoliInput.
     * 
     * @return norm_Luoghi_NotevoliInputParams
     */
    public e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliInputParams getNorm_Luoghi_NotevoliInputParams() {
        return norm_Luoghi_NotevoliInputParams;
    }


    /**
     * Sets the norm_Luoghi_NotevoliInputParams value for this Norm_Luoghi_NotevoliInput.
     * 
     * @param norm_Luoghi_NotevoliInputParams
     */
    public void setNorm_Luoghi_NotevoliInputParams(e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliInputParams norm_Luoghi_NotevoliInputParams) {
        this.norm_Luoghi_NotevoliInputParams = norm_Luoghi_NotevoliInputParams;
    }


    /**
     * Gets the inputFilter value for this Norm_Luoghi_NotevoliInput.
     * 
     * @return inputFilter
     */
    public e_SOAPDispenser.Normalizzatore.InputFilter getInputFilter() {
        return inputFilter;
    }


    /**
     * Sets the inputFilter value for this Norm_Luoghi_NotevoliInput.
     * 
     * @param inputFilter
     */
    public void setInputFilter(e_SOAPDispenser.Normalizzatore.InputFilter inputFilter) {
        this.inputFilter = inputFilter;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_Luoghi_NotevoliInput)) return false;
        Norm_Luoghi_NotevoliInput other = (Norm_Luoghi_NotevoliInput) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_Luoghi_NotevoliInputParams==null && other.getNorm_Luoghi_NotevoliInputParams()==null) || 
             (this.norm_Luoghi_NotevoliInputParams!=null &&
              this.norm_Luoghi_NotevoliInputParams.equals(other.getNorm_Luoghi_NotevoliInputParams()))) &&
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
        if (getNorm_Luoghi_NotevoliInputParams() != null) {
            _hashCode += getNorm_Luoghi_NotevoliInputParams().hashCode();
        }
        if (getInputFilter() != null) {
            _hashCode += getInputFilter().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_Luoghi_NotevoliInput.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Luoghi_NotevoliInput"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_Luoghi_NotevoliInputParams");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Luoghi_NotevoliInputParams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Luoghi_NotevoliInputParams"));
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
