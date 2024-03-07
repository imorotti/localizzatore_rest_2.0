/**
 * Norm_Luoghi_NotevoliOutput.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_Luoghi_NotevoliOutput  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliOutputParams norm_Luoghi_NotevoliOutputParams;
    private e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo;
    private e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliOutputRecordsetArray norm_Luoghi_NotevoliOutputRecordsetArray;

    public Norm_Luoghi_NotevoliOutput() {
    }

    public Norm_Luoghi_NotevoliOutput(
           e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliOutputParams norm_Luoghi_NotevoliOutputParams,
           e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo,
           e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliOutputRecordsetArray norm_Luoghi_NotevoliOutputRecordsetArray) {
           this.norm_Luoghi_NotevoliOutputParams = norm_Luoghi_NotevoliOutputParams;
           this.outputInfo = outputInfo;
           this.norm_Luoghi_NotevoliOutputRecordsetArray = norm_Luoghi_NotevoliOutputRecordsetArray;
    }


    /**
     * Gets the norm_Luoghi_NotevoliOutputParams value for this Norm_Luoghi_NotevoliOutput.
     * 
     * @return norm_Luoghi_NotevoliOutputParams
     */
    public e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliOutputParams getNorm_Luoghi_NotevoliOutputParams() {
        return norm_Luoghi_NotevoliOutputParams;
    }


    /**
     * Sets the norm_Luoghi_NotevoliOutputParams value for this Norm_Luoghi_NotevoliOutput.
     * 
     * @param norm_Luoghi_NotevoliOutputParams
     */
    public void setNorm_Luoghi_NotevoliOutputParams(e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliOutputParams norm_Luoghi_NotevoliOutputParams) {
        this.norm_Luoghi_NotevoliOutputParams = norm_Luoghi_NotevoliOutputParams;
    }


    /**
     * Gets the outputInfo value for this Norm_Luoghi_NotevoliOutput.
     * 
     * @return outputInfo
     */
    public e_SOAPDispenser.Normalizzatore.OutputInfo getOutputInfo() {
        return outputInfo;
    }


    /**
     * Sets the outputInfo value for this Norm_Luoghi_NotevoliOutput.
     * 
     * @param outputInfo
     */
    public void setOutputInfo(e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo) {
        this.outputInfo = outputInfo;
    }


    /**
     * Gets the norm_Luoghi_NotevoliOutputRecordsetArray value for this Norm_Luoghi_NotevoliOutput.
     * 
     * @return norm_Luoghi_NotevoliOutputRecordsetArray
     */
    public e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliOutputRecordsetArray getNorm_Luoghi_NotevoliOutputRecordsetArray() {
        return norm_Luoghi_NotevoliOutputRecordsetArray;
    }


    /**
     * Sets the norm_Luoghi_NotevoliOutputRecordsetArray value for this Norm_Luoghi_NotevoliOutput.
     * 
     * @param norm_Luoghi_NotevoliOutputRecordsetArray
     */
    public void setNorm_Luoghi_NotevoliOutputRecordsetArray(e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliOutputRecordsetArray norm_Luoghi_NotevoliOutputRecordsetArray) {
        this.norm_Luoghi_NotevoliOutputRecordsetArray = norm_Luoghi_NotevoliOutputRecordsetArray;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_Luoghi_NotevoliOutput)) return false;
        Norm_Luoghi_NotevoliOutput other = (Norm_Luoghi_NotevoliOutput) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_Luoghi_NotevoliOutputParams==null && other.getNorm_Luoghi_NotevoliOutputParams()==null) || 
             (this.norm_Luoghi_NotevoliOutputParams!=null &&
              this.norm_Luoghi_NotevoliOutputParams.equals(other.getNorm_Luoghi_NotevoliOutputParams()))) &&
            ((this.outputInfo==null && other.getOutputInfo()==null) || 
             (this.outputInfo!=null &&
              this.outputInfo.equals(other.getOutputInfo()))) &&
            ((this.norm_Luoghi_NotevoliOutputRecordsetArray==null && other.getNorm_Luoghi_NotevoliOutputRecordsetArray()==null) || 
             (this.norm_Luoghi_NotevoliOutputRecordsetArray!=null &&
              this.norm_Luoghi_NotevoliOutputRecordsetArray.equals(other.getNorm_Luoghi_NotevoliOutputRecordsetArray())));
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
        if (getNorm_Luoghi_NotevoliOutputParams() != null) {
            _hashCode += getNorm_Luoghi_NotevoliOutputParams().hashCode();
        }
        if (getOutputInfo() != null) {
            _hashCode += getOutputInfo().hashCode();
        }
        if (getNorm_Luoghi_NotevoliOutputRecordsetArray() != null) {
            _hashCode += getNorm_Luoghi_NotevoliOutputRecordsetArray().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_Luoghi_NotevoliOutput.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Luoghi_NotevoliOutput"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_Luoghi_NotevoliOutputParams");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Luoghi_NotevoliOutputParams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Luoghi_NotevoliOutputParams"));
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
        elemField.setFieldName("norm_Luoghi_NotevoliOutputRecordsetArray");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Luoghi_NotevoliOutputRecordsetArray"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Luoghi_NotevoliOutputRecordsetArray"));
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
