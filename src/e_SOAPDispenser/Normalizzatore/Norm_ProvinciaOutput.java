/**
 * Norm_ProvinciaOutput.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_ProvinciaOutput  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_ProvinciaOutputParams norm_ProvinciaOutputParams;
    private e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo;
    private e_SOAPDispenser.Normalizzatore.Norm_ProvinciaOutputRecordsetArray norm_ProvinciaOutputRecordsetArray;

    public Norm_ProvinciaOutput() {
    }

    public Norm_ProvinciaOutput(
           e_SOAPDispenser.Normalizzatore.Norm_ProvinciaOutputParams norm_ProvinciaOutputParams,
           e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo,
           e_SOAPDispenser.Normalizzatore.Norm_ProvinciaOutputRecordsetArray norm_ProvinciaOutputRecordsetArray) {
           this.norm_ProvinciaOutputParams = norm_ProvinciaOutputParams;
           this.outputInfo = outputInfo;
           this.norm_ProvinciaOutputRecordsetArray = norm_ProvinciaOutputRecordsetArray;
    }


    /**
     * Gets the norm_ProvinciaOutputParams value for this Norm_ProvinciaOutput.
     * 
     * @return norm_ProvinciaOutputParams
     */
    public e_SOAPDispenser.Normalizzatore.Norm_ProvinciaOutputParams getNorm_ProvinciaOutputParams() {
        return norm_ProvinciaOutputParams;
    }


    /**
     * Sets the norm_ProvinciaOutputParams value for this Norm_ProvinciaOutput.
     * 
     * @param norm_ProvinciaOutputParams
     */
    public void setNorm_ProvinciaOutputParams(e_SOAPDispenser.Normalizzatore.Norm_ProvinciaOutputParams norm_ProvinciaOutputParams) {
        this.norm_ProvinciaOutputParams = norm_ProvinciaOutputParams;
    }


    /**
     * Gets the outputInfo value for this Norm_ProvinciaOutput.
     * 
     * @return outputInfo
     */
    public e_SOAPDispenser.Normalizzatore.OutputInfo getOutputInfo() {
        return outputInfo;
    }


    /**
     * Sets the outputInfo value for this Norm_ProvinciaOutput.
     * 
     * @param outputInfo
     */
    public void setOutputInfo(e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo) {
        this.outputInfo = outputInfo;
    }


    /**
     * Gets the norm_ProvinciaOutputRecordsetArray value for this Norm_ProvinciaOutput.
     * 
     * @return norm_ProvinciaOutputRecordsetArray
     */
    public e_SOAPDispenser.Normalizzatore.Norm_ProvinciaOutputRecordsetArray getNorm_ProvinciaOutputRecordsetArray() {
        return norm_ProvinciaOutputRecordsetArray;
    }


    /**
     * Sets the norm_ProvinciaOutputRecordsetArray value for this Norm_ProvinciaOutput.
     * 
     * @param norm_ProvinciaOutputRecordsetArray
     */
    public void setNorm_ProvinciaOutputRecordsetArray(e_SOAPDispenser.Normalizzatore.Norm_ProvinciaOutputRecordsetArray norm_ProvinciaOutputRecordsetArray) {
        this.norm_ProvinciaOutputRecordsetArray = norm_ProvinciaOutputRecordsetArray;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_ProvinciaOutput)) return false;
        Norm_ProvinciaOutput other = (Norm_ProvinciaOutput) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_ProvinciaOutputParams==null && other.getNorm_ProvinciaOutputParams()==null) || 
             (this.norm_ProvinciaOutputParams!=null &&
              this.norm_ProvinciaOutputParams.equals(other.getNorm_ProvinciaOutputParams()))) &&
            ((this.outputInfo==null && other.getOutputInfo()==null) || 
             (this.outputInfo!=null &&
              this.outputInfo.equals(other.getOutputInfo()))) &&
            ((this.norm_ProvinciaOutputRecordsetArray==null && other.getNorm_ProvinciaOutputRecordsetArray()==null) || 
             (this.norm_ProvinciaOutputRecordsetArray!=null &&
              this.norm_ProvinciaOutputRecordsetArray.equals(other.getNorm_ProvinciaOutputRecordsetArray())));
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
        if (getNorm_ProvinciaOutputParams() != null) {
            _hashCode += getNorm_ProvinciaOutputParams().hashCode();
        }
        if (getOutputInfo() != null) {
            _hashCode += getOutputInfo().hashCode();
        }
        if (getNorm_ProvinciaOutputRecordsetArray() != null) {
            _hashCode += getNorm_ProvinciaOutputRecordsetArray().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_ProvinciaOutput.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_ProvinciaOutput"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_ProvinciaOutputParams");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_ProvinciaOutputParams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_ProvinciaOutputParams"));
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
        elemField.setFieldName("norm_ProvinciaOutputRecordsetArray");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_ProvinciaOutputRecordsetArray"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_ProvinciaOutputRecordsetArray"));
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
