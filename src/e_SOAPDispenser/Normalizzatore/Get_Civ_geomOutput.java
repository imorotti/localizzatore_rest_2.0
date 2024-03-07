/**
 * Get_Civ_geomOutput.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Get_Civ_geomOutput  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Get_Civ_geomOutputParams get_Civ_geomOutputParams;
    private e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo;

    public Get_Civ_geomOutput() {
    }

    public Get_Civ_geomOutput(
           e_SOAPDispenser.Normalizzatore.Get_Civ_geomOutputParams get_Civ_geomOutputParams,
           e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo) {
           this.get_Civ_geomOutputParams = get_Civ_geomOutputParams;
           this.outputInfo = outputInfo;
    }


    /**
     * Gets the get_Civ_geomOutputParams value for this Get_Civ_geomOutput.
     * 
     * @return get_Civ_geomOutputParams
     */
    public e_SOAPDispenser.Normalizzatore.Get_Civ_geomOutputParams getGet_Civ_geomOutputParams() {
        return get_Civ_geomOutputParams;
    }


    /**
     * Sets the get_Civ_geomOutputParams value for this Get_Civ_geomOutput.
     * 
     * @param get_Civ_geomOutputParams
     */
    public void setGet_Civ_geomOutputParams(e_SOAPDispenser.Normalizzatore.Get_Civ_geomOutputParams get_Civ_geomOutputParams) {
        this.get_Civ_geomOutputParams = get_Civ_geomOutputParams;
    }


    /**
     * Gets the outputInfo value for this Get_Civ_geomOutput.
     * 
     * @return outputInfo
     */
    public e_SOAPDispenser.Normalizzatore.OutputInfo getOutputInfo() {
        return outputInfo;
    }


    /**
     * Sets the outputInfo value for this Get_Civ_geomOutput.
     * 
     * @param outputInfo
     */
    public void setOutputInfo(e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo) {
        this.outputInfo = outputInfo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Get_Civ_geomOutput)) return false;
        Get_Civ_geomOutput other = (Get_Civ_geomOutput) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.get_Civ_geomOutputParams==null && other.getGet_Civ_geomOutputParams()==null) || 
             (this.get_Civ_geomOutputParams!=null &&
              this.get_Civ_geomOutputParams.equals(other.getGet_Civ_geomOutputParams()))) &&
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
        if (getGet_Civ_geomOutputParams() != null) {
            _hashCode += getGet_Civ_geomOutputParams().hashCode();
        }
        if (getOutputInfo() != null) {
            _hashCode += getOutputInfo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Get_Civ_geomOutput.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Civ_geomOutput"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("get_Civ_geomOutputParams");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Civ_geomOutputParams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Civ_geomOutputParams"));
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
