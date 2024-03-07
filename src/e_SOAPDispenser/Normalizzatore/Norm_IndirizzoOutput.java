/**
 * Norm_IndirizzoOutput.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_IndirizzoOutput  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_IndirizzoOutputParams norm_IndirizzoOutputParams;
    private e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo;
    private e_SOAPDispenser.Normalizzatore.Norm_IndirizzoOutputRecordsetArray norm_IndirizzoOutputRecordsetArray;

    public Norm_IndirizzoOutput() {
    }

    public Norm_IndirizzoOutput(
           e_SOAPDispenser.Normalizzatore.Norm_IndirizzoOutputParams norm_IndirizzoOutputParams,
           e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo,
           e_SOAPDispenser.Normalizzatore.Norm_IndirizzoOutputRecordsetArray norm_IndirizzoOutputRecordsetArray) {
           this.norm_IndirizzoOutputParams = norm_IndirizzoOutputParams;
           this.outputInfo = outputInfo;
           this.norm_IndirizzoOutputRecordsetArray = norm_IndirizzoOutputRecordsetArray;
    }


    /**
     * Gets the norm_IndirizzoOutputParams value for this Norm_IndirizzoOutput.
     * 
     * @return norm_IndirizzoOutputParams
     */
    public e_SOAPDispenser.Normalizzatore.Norm_IndirizzoOutputParams getNorm_IndirizzoOutputParams() {
        return norm_IndirizzoOutputParams;
    }


    /**
     * Sets the norm_IndirizzoOutputParams value for this Norm_IndirizzoOutput.
     * 
     * @param norm_IndirizzoOutputParams
     */
    public void setNorm_IndirizzoOutputParams(e_SOAPDispenser.Normalizzatore.Norm_IndirizzoOutputParams norm_IndirizzoOutputParams) {
        this.norm_IndirizzoOutputParams = norm_IndirizzoOutputParams;
    }


    /**
     * Gets the outputInfo value for this Norm_IndirizzoOutput.
     * 
     * @return outputInfo
     */
    public e_SOAPDispenser.Normalizzatore.OutputInfo getOutputInfo() {
        return outputInfo;
    }


    /**
     * Sets the outputInfo value for this Norm_IndirizzoOutput.
     * 
     * @param outputInfo
     */
    public void setOutputInfo(e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo) {
        this.outputInfo = outputInfo;
    }


    /**
     * Gets the norm_IndirizzoOutputRecordsetArray value for this Norm_IndirizzoOutput.
     * 
     * @return norm_IndirizzoOutputRecordsetArray
     */
    public e_SOAPDispenser.Normalizzatore.Norm_IndirizzoOutputRecordsetArray getNorm_IndirizzoOutputRecordsetArray() {
        return norm_IndirizzoOutputRecordsetArray;
    }


    /**
     * Sets the norm_IndirizzoOutputRecordsetArray value for this Norm_IndirizzoOutput.
     * 
     * @param norm_IndirizzoOutputRecordsetArray
     */
    public void setNorm_IndirizzoOutputRecordsetArray(e_SOAPDispenser.Normalizzatore.Norm_IndirizzoOutputRecordsetArray norm_IndirizzoOutputRecordsetArray) {
        this.norm_IndirizzoOutputRecordsetArray = norm_IndirizzoOutputRecordsetArray;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_IndirizzoOutput)) return false;
        Norm_IndirizzoOutput other = (Norm_IndirizzoOutput) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_IndirizzoOutputParams==null && other.getNorm_IndirizzoOutputParams()==null) || 
             (this.norm_IndirizzoOutputParams!=null &&
              this.norm_IndirizzoOutputParams.equals(other.getNorm_IndirizzoOutputParams()))) &&
            ((this.outputInfo==null && other.getOutputInfo()==null) || 
             (this.outputInfo!=null &&
              this.outputInfo.equals(other.getOutputInfo()))) &&
            ((this.norm_IndirizzoOutputRecordsetArray==null && other.getNorm_IndirizzoOutputRecordsetArray()==null) || 
             (this.norm_IndirizzoOutputRecordsetArray!=null &&
              this.norm_IndirizzoOutputRecordsetArray.equals(other.getNorm_IndirizzoOutputRecordsetArray())));
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
        if (getNorm_IndirizzoOutputParams() != null) {
            _hashCode += getNorm_IndirizzoOutputParams().hashCode();
        }
        if (getOutputInfo() != null) {
            _hashCode += getOutputInfo().hashCode();
        }
        if (getNorm_IndirizzoOutputRecordsetArray() != null) {
            _hashCode += getNorm_IndirizzoOutputRecordsetArray().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_IndirizzoOutput.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IndirizzoOutput"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_IndirizzoOutputParams");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IndirizzoOutputParams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IndirizzoOutputParams"));
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
        elemField.setFieldName("norm_IndirizzoOutputRecordsetArray");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IndirizzoOutputRecordsetArray"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IndirizzoOutputRecordsetArray"));
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