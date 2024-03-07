/**
 * Norm_Indirizzo_multiOutput.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_Indirizzo_multiOutput  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiOutputParams norm_Indirizzo_multiOutputParams;
    private e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo;
    private e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiOutputRecordsetArray norm_Indirizzo_multiOutputRecordsetArray;

    public Norm_Indirizzo_multiOutput() {
    }

    public Norm_Indirizzo_multiOutput(
           e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiOutputParams norm_Indirizzo_multiOutputParams,
           e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo,
           e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiOutputRecordsetArray norm_Indirizzo_multiOutputRecordsetArray) {
           this.norm_Indirizzo_multiOutputParams = norm_Indirizzo_multiOutputParams;
           this.outputInfo = outputInfo;
           this.norm_Indirizzo_multiOutputRecordsetArray = norm_Indirizzo_multiOutputRecordsetArray;
    }


    /**
     * Gets the norm_Indirizzo_multiOutputParams value for this Norm_Indirizzo_multiOutput.
     * 
     * @return norm_Indirizzo_multiOutputParams
     */
    public e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiOutputParams getNorm_Indirizzo_multiOutputParams() {
        return norm_Indirizzo_multiOutputParams;
    }


    /**
     * Sets the norm_Indirizzo_multiOutputParams value for this Norm_Indirizzo_multiOutput.
     * 
     * @param norm_Indirizzo_multiOutputParams
     */
    public void setNorm_Indirizzo_multiOutputParams(e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiOutputParams norm_Indirizzo_multiOutputParams) {
        this.norm_Indirizzo_multiOutputParams = norm_Indirizzo_multiOutputParams;
    }


    /**
     * Gets the outputInfo value for this Norm_Indirizzo_multiOutput.
     * 
     * @return outputInfo
     */
    public e_SOAPDispenser.Normalizzatore.OutputInfo getOutputInfo() {
        return outputInfo;
    }


    /**
     * Sets the outputInfo value for this Norm_Indirizzo_multiOutput.
     * 
     * @param outputInfo
     */
    public void setOutputInfo(e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo) {
        this.outputInfo = outputInfo;
    }


    /**
     * Gets the norm_Indirizzo_multiOutputRecordsetArray value for this Norm_Indirizzo_multiOutput.
     * 
     * @return norm_Indirizzo_multiOutputRecordsetArray
     */
    public e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiOutputRecordsetArray getNorm_Indirizzo_multiOutputRecordsetArray() {
        return norm_Indirizzo_multiOutputRecordsetArray;
    }


    /**
     * Sets the norm_Indirizzo_multiOutputRecordsetArray value for this Norm_Indirizzo_multiOutput.
     * 
     * @param norm_Indirizzo_multiOutputRecordsetArray
     */
    public void setNorm_Indirizzo_multiOutputRecordsetArray(e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiOutputRecordsetArray norm_Indirizzo_multiOutputRecordsetArray) {
        this.norm_Indirizzo_multiOutputRecordsetArray = norm_Indirizzo_multiOutputRecordsetArray;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_Indirizzo_multiOutput)) return false;
        Norm_Indirizzo_multiOutput other = (Norm_Indirizzo_multiOutput) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_Indirizzo_multiOutputParams==null && other.getNorm_Indirizzo_multiOutputParams()==null) || 
             (this.norm_Indirizzo_multiOutputParams!=null &&
              this.norm_Indirizzo_multiOutputParams.equals(other.getNorm_Indirizzo_multiOutputParams()))) &&
            ((this.outputInfo==null && other.getOutputInfo()==null) || 
             (this.outputInfo!=null &&
              this.outputInfo.equals(other.getOutputInfo()))) &&
            ((this.norm_Indirizzo_multiOutputRecordsetArray==null && other.getNorm_Indirizzo_multiOutputRecordsetArray()==null) || 
             (this.norm_Indirizzo_multiOutputRecordsetArray!=null &&
              this.norm_Indirizzo_multiOutputRecordsetArray.equals(other.getNorm_Indirizzo_multiOutputRecordsetArray())));
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
        if (getNorm_Indirizzo_multiOutputParams() != null) {
            _hashCode += getNorm_Indirizzo_multiOutputParams().hashCode();
        }
        if (getOutputInfo() != null) {
            _hashCode += getOutputInfo().hashCode();
        }
        if (getNorm_Indirizzo_multiOutputRecordsetArray() != null) {
            _hashCode += getNorm_Indirizzo_multiOutputRecordsetArray().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_Indirizzo_multiOutput.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_multiOutput"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_Indirizzo_multiOutputParams");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_multiOutputParams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_multiOutputParams"));
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
        elemField.setFieldName("norm_Indirizzo_multiOutputRecordsetArray");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_multiOutputRecordsetArray"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_multiOutputRecordsetArray"));
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
