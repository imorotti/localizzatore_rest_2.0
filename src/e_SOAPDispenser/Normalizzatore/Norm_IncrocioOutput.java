/**
 * Norm_IncrocioOutput.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_IncrocioOutput  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_IncrocioOutputParams norm_IncrocioOutputParams;
    private e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo;
    private e_SOAPDispenser.Normalizzatore.Norm_IncrocioOutputRecordsetArray norm_IncrocioOutputRecordsetArray;

    public Norm_IncrocioOutput() {
    }

    public Norm_IncrocioOutput(
           e_SOAPDispenser.Normalizzatore.Norm_IncrocioOutputParams norm_IncrocioOutputParams,
           e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo,
           e_SOAPDispenser.Normalizzatore.Norm_IncrocioOutputRecordsetArray norm_IncrocioOutputRecordsetArray) {
           this.norm_IncrocioOutputParams = norm_IncrocioOutputParams;
           this.outputInfo = outputInfo;
           this.norm_IncrocioOutputRecordsetArray = norm_IncrocioOutputRecordsetArray;
    }


    /**
     * Gets the norm_IncrocioOutputParams value for this Norm_IncrocioOutput.
     * 
     * @return norm_IncrocioOutputParams
     */
    public e_SOAPDispenser.Normalizzatore.Norm_IncrocioOutputParams getNorm_IncrocioOutputParams() {
        return norm_IncrocioOutputParams;
    }


    /**
     * Sets the norm_IncrocioOutputParams value for this Norm_IncrocioOutput.
     * 
     * @param norm_IncrocioOutputParams
     */
    public void setNorm_IncrocioOutputParams(e_SOAPDispenser.Normalizzatore.Norm_IncrocioOutputParams norm_IncrocioOutputParams) {
        this.norm_IncrocioOutputParams = norm_IncrocioOutputParams;
    }


    /**
     * Gets the outputInfo value for this Norm_IncrocioOutput.
     * 
     * @return outputInfo
     */
    public e_SOAPDispenser.Normalizzatore.OutputInfo getOutputInfo() {
        return outputInfo;
    }


    /**
     * Sets the outputInfo value for this Norm_IncrocioOutput.
     * 
     * @param outputInfo
     */
    public void setOutputInfo(e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo) {
        this.outputInfo = outputInfo;
    }


    /**
     * Gets the norm_IncrocioOutputRecordsetArray value for this Norm_IncrocioOutput.
     * 
     * @return norm_IncrocioOutputRecordsetArray
     */
    public e_SOAPDispenser.Normalizzatore.Norm_IncrocioOutputRecordsetArray getNorm_IncrocioOutputRecordsetArray() {
        return norm_IncrocioOutputRecordsetArray;
    }


    /**
     * Sets the norm_IncrocioOutputRecordsetArray value for this Norm_IncrocioOutput.
     * 
     * @param norm_IncrocioOutputRecordsetArray
     */
    public void setNorm_IncrocioOutputRecordsetArray(e_SOAPDispenser.Normalizzatore.Norm_IncrocioOutputRecordsetArray norm_IncrocioOutputRecordsetArray) {
        this.norm_IncrocioOutputRecordsetArray = norm_IncrocioOutputRecordsetArray;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_IncrocioOutput)) return false;
        Norm_IncrocioOutput other = (Norm_IncrocioOutput) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_IncrocioOutputParams==null && other.getNorm_IncrocioOutputParams()==null) || 
             (this.norm_IncrocioOutputParams!=null &&
              this.norm_IncrocioOutputParams.equals(other.getNorm_IncrocioOutputParams()))) &&
            ((this.outputInfo==null && other.getOutputInfo()==null) || 
             (this.outputInfo!=null &&
              this.outputInfo.equals(other.getOutputInfo()))) &&
            ((this.norm_IncrocioOutputRecordsetArray==null && other.getNorm_IncrocioOutputRecordsetArray()==null) || 
             (this.norm_IncrocioOutputRecordsetArray!=null &&
              this.norm_IncrocioOutputRecordsetArray.equals(other.getNorm_IncrocioOutputRecordsetArray())));
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
        if (getNorm_IncrocioOutputParams() != null) {
            _hashCode += getNorm_IncrocioOutputParams().hashCode();
        }
        if (getOutputInfo() != null) {
            _hashCode += getOutputInfo().hashCode();
        }
        if (getNorm_IncrocioOutputRecordsetArray() != null) {
            _hashCode += getNorm_IncrocioOutputRecordsetArray().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_IncrocioOutput.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IncrocioOutput"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_IncrocioOutputParams");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IncrocioOutputParams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IncrocioOutputParams"));
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
        elemField.setFieldName("norm_IncrocioOutputRecordsetArray");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IncrocioOutputRecordsetArray"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IncrocioOutputRecordsetArray"));
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
