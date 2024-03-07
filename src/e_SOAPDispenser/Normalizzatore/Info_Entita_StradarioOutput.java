/**
 * Info_Entita_StradarioOutput.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Info_Entita_StradarioOutput  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Info_Entita_StradarioOutputParams info_Entita_StradarioOutputParams;
    private e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo;
    private e_SOAPDispenser.Normalizzatore.Info_Entita_StradarioOutputRecordsetArray info_Entita_StradarioOutputRecordsetArray;

    public Info_Entita_StradarioOutput() {
    }

    public Info_Entita_StradarioOutput(
           e_SOAPDispenser.Normalizzatore.Info_Entita_StradarioOutputParams info_Entita_StradarioOutputParams,
           e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo,
           e_SOAPDispenser.Normalizzatore.Info_Entita_StradarioOutputRecordsetArray info_Entita_StradarioOutputRecordsetArray) {
           this.info_Entita_StradarioOutputParams = info_Entita_StradarioOutputParams;
           this.outputInfo = outputInfo;
           this.info_Entita_StradarioOutputRecordsetArray = info_Entita_StradarioOutputRecordsetArray;
    }


    /**
     * Gets the info_Entita_StradarioOutputParams value for this Info_Entita_StradarioOutput.
     * 
     * @return info_Entita_StradarioOutputParams
     */
    public e_SOAPDispenser.Normalizzatore.Info_Entita_StradarioOutputParams getInfo_Entita_StradarioOutputParams() {
        return info_Entita_StradarioOutputParams;
    }


    /**
     * Sets the info_Entita_StradarioOutputParams value for this Info_Entita_StradarioOutput.
     * 
     * @param info_Entita_StradarioOutputParams
     */
    public void setInfo_Entita_StradarioOutputParams(e_SOAPDispenser.Normalizzatore.Info_Entita_StradarioOutputParams info_Entita_StradarioOutputParams) {
        this.info_Entita_StradarioOutputParams = info_Entita_StradarioOutputParams;
    }


    /**
     * Gets the outputInfo value for this Info_Entita_StradarioOutput.
     * 
     * @return outputInfo
     */
    public e_SOAPDispenser.Normalizzatore.OutputInfo getOutputInfo() {
        return outputInfo;
    }


    /**
     * Sets the outputInfo value for this Info_Entita_StradarioOutput.
     * 
     * @param outputInfo
     */
    public void setOutputInfo(e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo) {
        this.outputInfo = outputInfo;
    }


    /**
     * Gets the info_Entita_StradarioOutputRecordsetArray value for this Info_Entita_StradarioOutput.
     * 
     * @return info_Entita_StradarioOutputRecordsetArray
     */
    public e_SOAPDispenser.Normalizzatore.Info_Entita_StradarioOutputRecordsetArray getInfo_Entita_StradarioOutputRecordsetArray() {
        return info_Entita_StradarioOutputRecordsetArray;
    }


    /**
     * Sets the info_Entita_StradarioOutputRecordsetArray value for this Info_Entita_StradarioOutput.
     * 
     * @param info_Entita_StradarioOutputRecordsetArray
     */
    public void setInfo_Entita_StradarioOutputRecordsetArray(e_SOAPDispenser.Normalizzatore.Info_Entita_StradarioOutputRecordsetArray info_Entita_StradarioOutputRecordsetArray) {
        this.info_Entita_StradarioOutputRecordsetArray = info_Entita_StradarioOutputRecordsetArray;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Info_Entita_StradarioOutput)) return false;
        Info_Entita_StradarioOutput other = (Info_Entita_StradarioOutput) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.info_Entita_StradarioOutputParams==null && other.getInfo_Entita_StradarioOutputParams()==null) || 
             (this.info_Entita_StradarioOutputParams!=null &&
              this.info_Entita_StradarioOutputParams.equals(other.getInfo_Entita_StradarioOutputParams()))) &&
            ((this.outputInfo==null && other.getOutputInfo()==null) || 
             (this.outputInfo!=null &&
              this.outputInfo.equals(other.getOutputInfo()))) &&
            ((this.info_Entita_StradarioOutputRecordsetArray==null && other.getInfo_Entita_StradarioOutputRecordsetArray()==null) || 
             (this.info_Entita_StradarioOutputRecordsetArray!=null &&
              this.info_Entita_StradarioOutputRecordsetArray.equals(other.getInfo_Entita_StradarioOutputRecordsetArray())));
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
        if (getInfo_Entita_StradarioOutputParams() != null) {
            _hashCode += getInfo_Entita_StradarioOutputParams().hashCode();
        }
        if (getOutputInfo() != null) {
            _hashCode += getOutputInfo().hashCode();
        }
        if (getInfo_Entita_StradarioOutputRecordsetArray() != null) {
            _hashCode += getInfo_Entita_StradarioOutputRecordsetArray().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Info_Entita_StradarioOutput.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Info_Entita_StradarioOutput"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("info_Entita_StradarioOutputParams");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Info_Entita_StradarioOutputParams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Info_Entita_StradarioOutputParams"));
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
        elemField.setFieldName("info_Entita_StradarioOutputRecordsetArray");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Info_Entita_StradarioOutputRecordsetArray"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Info_Entita_StradarioOutputRecordsetArray"));
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
