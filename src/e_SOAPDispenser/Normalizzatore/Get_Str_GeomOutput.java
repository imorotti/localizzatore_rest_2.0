/**
 * Get_Str_GeomOutput.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Get_Str_GeomOutput  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Get_Str_GeomOutputParams get_Str_GeomOutputParams;
    private e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo;

    public Get_Str_GeomOutput() {
    }

    public Get_Str_GeomOutput(
           e_SOAPDispenser.Normalizzatore.Get_Str_GeomOutputParams get_Str_GeomOutputParams,
           e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo) {
           this.get_Str_GeomOutputParams = get_Str_GeomOutputParams;
           this.outputInfo = outputInfo;
    }


    /**
     * Gets the get_Str_GeomOutputParams value for this Get_Str_GeomOutput.
     * 
     * @return get_Str_GeomOutputParams
     */
    public e_SOAPDispenser.Normalizzatore.Get_Str_GeomOutputParams getGet_Str_GeomOutputParams() {
        return get_Str_GeomOutputParams;
    }


    /**
     * Sets the get_Str_GeomOutputParams value for this Get_Str_GeomOutput.
     * 
     * @param get_Str_GeomOutputParams
     */
    public void setGet_Str_GeomOutputParams(e_SOAPDispenser.Normalizzatore.Get_Str_GeomOutputParams get_Str_GeomOutputParams) {
        this.get_Str_GeomOutputParams = get_Str_GeomOutputParams;
    }


    /**
     * Gets the outputInfo value for this Get_Str_GeomOutput.
     * 
     * @return outputInfo
     */
    public e_SOAPDispenser.Normalizzatore.OutputInfo getOutputInfo() {
        return outputInfo;
    }


    /**
     * Sets the outputInfo value for this Get_Str_GeomOutput.
     * 
     * @param outputInfo
     */
    public void setOutputInfo(e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo) {
        this.outputInfo = outputInfo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Get_Str_GeomOutput)) return false;
        Get_Str_GeomOutput other = (Get_Str_GeomOutput) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.get_Str_GeomOutputParams==null && other.getGet_Str_GeomOutputParams()==null) || 
             (this.get_Str_GeomOutputParams!=null &&
              this.get_Str_GeomOutputParams.equals(other.getGet_Str_GeomOutputParams()))) &&
            ((this.outputInfo==null && other.getOutputInfo()==null) || 
             (this.outputInfo!=null &&
              this.outputInfo.equals(other.getOutputInfo())));
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
        if (getGet_Str_GeomOutputParams() != null) {
            _hashCode += getGet_Str_GeomOutputParams().hashCode();
        }
        if (getOutputInfo() != null) {
            _hashCode += getOutputInfo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Get_Str_GeomOutput.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Str_GeomOutput"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("get_Str_GeomOutputParams");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Str_GeomOutputParams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Str_GeomOutputParams"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("outputInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "OutputInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "OutputInfo"));
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
