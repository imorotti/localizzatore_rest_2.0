/**
 * Norm_StradarioOutput.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_StradarioOutput  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_StradarioOutputParams norm_StradarioOutputParams;
    private e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo;
    private e_SOAPDispenser.Normalizzatore.Norm_StradarioOutputRecordsetArray norm_StradarioOutputRecordsetArray;

    public Norm_StradarioOutput() {
    }

    public Norm_StradarioOutput(
           e_SOAPDispenser.Normalizzatore.Norm_StradarioOutputParams norm_StradarioOutputParams,
           e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo,
           e_SOAPDispenser.Normalizzatore.Norm_StradarioOutputRecordsetArray norm_StradarioOutputRecordsetArray) {
           this.norm_StradarioOutputParams = norm_StradarioOutputParams;
           this.outputInfo = outputInfo;
           this.norm_StradarioOutputRecordsetArray = norm_StradarioOutputRecordsetArray;
    }


    /**
     * Gets the norm_StradarioOutputParams value for this Norm_StradarioOutput.
     * 
     * @return norm_StradarioOutputParams
     */
    public e_SOAPDispenser.Normalizzatore.Norm_StradarioOutputParams getNorm_StradarioOutputParams() {
        return norm_StradarioOutputParams;
    }


    /**
     * Sets the norm_StradarioOutputParams value for this Norm_StradarioOutput.
     * 
     * @param norm_StradarioOutputParams
     */
    public void setNorm_StradarioOutputParams(e_SOAPDispenser.Normalizzatore.Norm_StradarioOutputParams norm_StradarioOutputParams) {
        this.norm_StradarioOutputParams = norm_StradarioOutputParams;
    }


    /**
     * Gets the outputInfo value for this Norm_StradarioOutput.
     * 
     * @return outputInfo
     */
    public e_SOAPDispenser.Normalizzatore.OutputInfo getOutputInfo() {
        return outputInfo;
    }


    /**
     * Sets the outputInfo value for this Norm_StradarioOutput.
     * 
     * @param outputInfo
     */
    public void setOutputInfo(e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo) {
        this.outputInfo = outputInfo;
    }


    /**
     * Gets the norm_StradarioOutputRecordsetArray value for this Norm_StradarioOutput.
     * 
     * @return norm_StradarioOutputRecordsetArray
     */
    public e_SOAPDispenser.Normalizzatore.Norm_StradarioOutputRecordsetArray getNorm_StradarioOutputRecordsetArray() {
        return norm_StradarioOutputRecordsetArray;
    }


    /**
     * Sets the norm_StradarioOutputRecordsetArray value for this Norm_StradarioOutput.
     * 
     * @param norm_StradarioOutputRecordsetArray
     */
    public void setNorm_StradarioOutputRecordsetArray(e_SOAPDispenser.Normalizzatore.Norm_StradarioOutputRecordsetArray norm_StradarioOutputRecordsetArray) {
        this.norm_StradarioOutputRecordsetArray = norm_StradarioOutputRecordsetArray;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_StradarioOutput)) return false;
        Norm_StradarioOutput other = (Norm_StradarioOutput) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_StradarioOutputParams==null && other.getNorm_StradarioOutputParams()==null) || 
             (this.norm_StradarioOutputParams!=null &&
              this.norm_StradarioOutputParams.equals(other.getNorm_StradarioOutputParams()))) &&
            ((this.outputInfo==null && other.getOutputInfo()==null) || 
             (this.outputInfo!=null &&
              this.outputInfo.equals(other.getOutputInfo()))) &&
            ((this.norm_StradarioOutputRecordsetArray==null && other.getNorm_StradarioOutputRecordsetArray()==null) || 
             (this.norm_StradarioOutputRecordsetArray!=null &&
              this.norm_StradarioOutputRecordsetArray.equals(other.getNorm_StradarioOutputRecordsetArray())));
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
        if (getNorm_StradarioOutputParams() != null) {
            _hashCode += getNorm_StradarioOutputParams().hashCode();
        }
        if (getOutputInfo() != null) {
            _hashCode += getOutputInfo().hashCode();
        }
        if (getNorm_StradarioOutputRecordsetArray() != null) {
            _hashCode += getNorm_StradarioOutputRecordsetArray().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_StradarioOutput.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_StradarioOutput"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_StradarioOutputParams");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_StradarioOutputParams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_StradarioOutputParams"));
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
        elemField.setFieldName("norm_StradarioOutputRecordsetArray");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_StradarioOutputRecordsetArray"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_StradarioOutputRecordsetArray"));
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
