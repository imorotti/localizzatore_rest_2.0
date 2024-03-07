/**
 * Norm_EdificioOutput.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_EdificioOutput  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_EdificioOutputParams norm_EdificioOutputParams;
    private e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo;
    private e_SOAPDispenser.Normalizzatore.Norm_EdificioOutputRecordsetArray norm_EdificioOutputRecordsetArray;

    public Norm_EdificioOutput() {
    }

    public Norm_EdificioOutput(
           e_SOAPDispenser.Normalizzatore.Norm_EdificioOutputParams norm_EdificioOutputParams,
           e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo,
           e_SOAPDispenser.Normalizzatore.Norm_EdificioOutputRecordsetArray norm_EdificioOutputRecordsetArray) {
           this.norm_EdificioOutputParams = norm_EdificioOutputParams;
           this.outputInfo = outputInfo;
           this.norm_EdificioOutputRecordsetArray = norm_EdificioOutputRecordsetArray;
    }


    /**
     * Gets the norm_EdificioOutputParams value for this Norm_EdificioOutput.
     * 
     * @return norm_EdificioOutputParams
     */
    public e_SOAPDispenser.Normalizzatore.Norm_EdificioOutputParams getNorm_EdificioOutputParams() {
        return norm_EdificioOutputParams;
    }


    /**
     * Sets the norm_EdificioOutputParams value for this Norm_EdificioOutput.
     * 
     * @param norm_EdificioOutputParams
     */
    public void setNorm_EdificioOutputParams(e_SOAPDispenser.Normalizzatore.Norm_EdificioOutputParams norm_EdificioOutputParams) {
        this.norm_EdificioOutputParams = norm_EdificioOutputParams;
    }


    /**
     * Gets the outputInfo value for this Norm_EdificioOutput.
     * 
     * @return outputInfo
     */
    public e_SOAPDispenser.Normalizzatore.OutputInfo getOutputInfo() {
        return outputInfo;
    }


    /**
     * Sets the outputInfo value for this Norm_EdificioOutput.
     * 
     * @param outputInfo
     */
    public void setOutputInfo(e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo) {
        this.outputInfo = outputInfo;
    }


    /**
     * Gets the norm_EdificioOutputRecordsetArray value for this Norm_EdificioOutput.
     * 
     * @return norm_EdificioOutputRecordsetArray
     */
    public e_SOAPDispenser.Normalizzatore.Norm_EdificioOutputRecordsetArray getNorm_EdificioOutputRecordsetArray() {
        return norm_EdificioOutputRecordsetArray;
    }


    /**
     * Sets the norm_EdificioOutputRecordsetArray value for this Norm_EdificioOutput.
     * 
     * @param norm_EdificioOutputRecordsetArray
     */
    public void setNorm_EdificioOutputRecordsetArray(e_SOAPDispenser.Normalizzatore.Norm_EdificioOutputRecordsetArray norm_EdificioOutputRecordsetArray) {
        this.norm_EdificioOutputRecordsetArray = norm_EdificioOutputRecordsetArray;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_EdificioOutput)) return false;
        Norm_EdificioOutput other = (Norm_EdificioOutput) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_EdificioOutputParams==null && other.getNorm_EdificioOutputParams()==null) || 
             (this.norm_EdificioOutputParams!=null &&
              this.norm_EdificioOutputParams.equals(other.getNorm_EdificioOutputParams()))) &&
            ((this.outputInfo==null && other.getOutputInfo()==null) || 
             (this.outputInfo!=null &&
              this.outputInfo.equals(other.getOutputInfo()))) &&
            ((this.norm_EdificioOutputRecordsetArray==null && other.getNorm_EdificioOutputRecordsetArray()==null) || 
             (this.norm_EdificioOutputRecordsetArray!=null &&
              this.norm_EdificioOutputRecordsetArray.equals(other.getNorm_EdificioOutputRecordsetArray())));
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
        if (getNorm_EdificioOutputParams() != null) {
            _hashCode += getNorm_EdificioOutputParams().hashCode();
        }
        if (getOutputInfo() != null) {
            _hashCode += getOutputInfo().hashCode();
        }
        if (getNorm_EdificioOutputRecordsetArray() != null) {
            _hashCode += getNorm_EdificioOutputRecordsetArray().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_EdificioOutput.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_EdificioOutput"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_EdificioOutputParams");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_EdificioOutputParams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_EdificioOutputParams"));
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
        elemField.setFieldName("norm_EdificioOutputRecordsetArray");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_EdificioOutputRecordsetArray"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_EdificioOutputRecordsetArray"));
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
