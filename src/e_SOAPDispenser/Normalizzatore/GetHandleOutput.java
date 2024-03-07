/**
 * GetHandleOutput.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class GetHandleOutput  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.GetHandleOutputParams getHandleOutputParams;
    private e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo;

    public GetHandleOutput() {
    }

    public GetHandleOutput(
           e_SOAPDispenser.Normalizzatore.GetHandleOutputParams getHandleOutputParams,
           e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo) {
           this.getHandleOutputParams = getHandleOutputParams;
           this.outputInfo = outputInfo;
    }


    /**
     * Gets the getHandleOutputParams value for this GetHandleOutput.
     * 
     * @return getHandleOutputParams
     */
    public e_SOAPDispenser.Normalizzatore.GetHandleOutputParams getGetHandleOutputParams() {
        return getHandleOutputParams;
    }


    /**
     * Sets the getHandleOutputParams value for this GetHandleOutput.
     * 
     * @param getHandleOutputParams
     */
    public void setGetHandleOutputParams(e_SOAPDispenser.Normalizzatore.GetHandleOutputParams getHandleOutputParams) {
        this.getHandleOutputParams = getHandleOutputParams;
    }


    /**
     * Gets the outputInfo value for this GetHandleOutput.
     * 
     * @return outputInfo
     */
    public e_SOAPDispenser.Normalizzatore.OutputInfo getOutputInfo() {
        return outputInfo;
    }


    /**
     * Sets the outputInfo value for this GetHandleOutput.
     * 
     * @param outputInfo
     */
    public void setOutputInfo(e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo) {
        this.outputInfo = outputInfo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetHandleOutput)) return false;
        GetHandleOutput other = (GetHandleOutput) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getHandleOutputParams==null && other.getGetHandleOutputParams()==null) || 
             (this.getHandleOutputParams!=null &&
              this.getHandleOutputParams.equals(other.getGetHandleOutputParams()))) &&
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
        if (getGetHandleOutputParams() != null) {
            _hashCode += getGetHandleOutputParams().hashCode();
        }
        if (getOutputInfo() != null) {
            _hashCode += getOutputInfo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetHandleOutput.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "GetHandleOutput"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getHandleOutputParams");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "GetHandleOutputParams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "GetHandleOutputParams"));
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
