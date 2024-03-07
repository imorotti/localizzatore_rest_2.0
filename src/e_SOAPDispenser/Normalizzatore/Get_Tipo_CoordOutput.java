/**
 * Get_Tipo_CoordOutput.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Get_Tipo_CoordOutput  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordOutputParams get_Tipo_CoordOutputParams;
    private e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo;
    private e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordOutputRecordsetArray get_Tipo_CoordOutputRecordsetArray;

    public Get_Tipo_CoordOutput() {
    }

    public Get_Tipo_CoordOutput(
           e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordOutputParams get_Tipo_CoordOutputParams,
           e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo,
           e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordOutputRecordsetArray get_Tipo_CoordOutputRecordsetArray) {
           this.get_Tipo_CoordOutputParams = get_Tipo_CoordOutputParams;
           this.outputInfo = outputInfo;
           this.get_Tipo_CoordOutputRecordsetArray = get_Tipo_CoordOutputRecordsetArray;
    }


    /**
     * Gets the get_Tipo_CoordOutputParams value for this Get_Tipo_CoordOutput.
     * 
     * @return get_Tipo_CoordOutputParams
     */
    public e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordOutputParams getGet_Tipo_CoordOutputParams() {
        return get_Tipo_CoordOutputParams;
    }


    /**
     * Sets the get_Tipo_CoordOutputParams value for this Get_Tipo_CoordOutput.
     * 
     * @param get_Tipo_CoordOutputParams
     */
    public void setGet_Tipo_CoordOutputParams(e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordOutputParams get_Tipo_CoordOutputParams) {
        this.get_Tipo_CoordOutputParams = get_Tipo_CoordOutputParams;
    }


    /**
     * Gets the outputInfo value for this Get_Tipo_CoordOutput.
     * 
     * @return outputInfo
     */
    public e_SOAPDispenser.Normalizzatore.OutputInfo getOutputInfo() {
        return outputInfo;
    }


    /**
     * Sets the outputInfo value for this Get_Tipo_CoordOutput.
     * 
     * @param outputInfo
     */
    public void setOutputInfo(e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo) {
        this.outputInfo = outputInfo;
    }


    /**
     * Gets the get_Tipo_CoordOutputRecordsetArray value for this Get_Tipo_CoordOutput.
     * 
     * @return get_Tipo_CoordOutputRecordsetArray
     */
    public e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordOutputRecordsetArray getGet_Tipo_CoordOutputRecordsetArray() {
        return get_Tipo_CoordOutputRecordsetArray;
    }


    /**
     * Sets the get_Tipo_CoordOutputRecordsetArray value for this Get_Tipo_CoordOutput.
     * 
     * @param get_Tipo_CoordOutputRecordsetArray
     */
    public void setGet_Tipo_CoordOutputRecordsetArray(e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordOutputRecordsetArray get_Tipo_CoordOutputRecordsetArray) {
        this.get_Tipo_CoordOutputRecordsetArray = get_Tipo_CoordOutputRecordsetArray;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Get_Tipo_CoordOutput)) return false;
        Get_Tipo_CoordOutput other = (Get_Tipo_CoordOutput) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.get_Tipo_CoordOutputParams==null && other.getGet_Tipo_CoordOutputParams()==null) || 
             (this.get_Tipo_CoordOutputParams!=null &&
              this.get_Tipo_CoordOutputParams.equals(other.getGet_Tipo_CoordOutputParams()))) &&
            ((this.outputInfo==null && other.getOutputInfo()==null) || 
             (this.outputInfo!=null &&
              this.outputInfo.equals(other.getOutputInfo()))) &&
            ((this.get_Tipo_CoordOutputRecordsetArray==null && other.getGet_Tipo_CoordOutputRecordsetArray()==null) || 
             (this.get_Tipo_CoordOutputRecordsetArray!=null &&
              this.get_Tipo_CoordOutputRecordsetArray.equals(other.getGet_Tipo_CoordOutputRecordsetArray())));
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
        if (getGet_Tipo_CoordOutputParams() != null) {
            _hashCode += getGet_Tipo_CoordOutputParams().hashCode();
        }
        if (getOutputInfo() != null) {
            _hashCode += getOutputInfo().hashCode();
        }
        if (getGet_Tipo_CoordOutputRecordsetArray() != null) {
            _hashCode += getGet_Tipo_CoordOutputRecordsetArray().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Get_Tipo_CoordOutput.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Tipo_CoordOutput"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("get_Tipo_CoordOutputParams");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Tipo_CoordOutputParams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Tipo_CoordOutputParams"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("get_Tipo_CoordOutputRecordsetArray");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Tipo_CoordOutputRecordsetArray"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Tipo_CoordOutputRecordsetArray"));
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
