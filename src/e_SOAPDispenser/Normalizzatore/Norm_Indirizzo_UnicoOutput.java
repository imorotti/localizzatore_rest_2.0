/**
 * Norm_Indirizzo_UnicoOutput.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_Indirizzo_UnicoOutput  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoOutputParams norm_Indirizzo_UnicoOutputParams;
    private e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo;
    private e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoOutputRecordsetArray norm_Indirizzo_UnicoOutputRecordsetArray;

    public Norm_Indirizzo_UnicoOutput() {
    }

    public Norm_Indirizzo_UnicoOutput(
           e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoOutputParams norm_Indirizzo_UnicoOutputParams,
           e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo,
           e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoOutputRecordsetArray norm_Indirizzo_UnicoOutputRecordsetArray) {
           this.norm_Indirizzo_UnicoOutputParams = norm_Indirizzo_UnicoOutputParams;
           this.outputInfo = outputInfo;
           this.norm_Indirizzo_UnicoOutputRecordsetArray = norm_Indirizzo_UnicoOutputRecordsetArray;
    }


    /**
     * Gets the norm_Indirizzo_UnicoOutputParams value for this Norm_Indirizzo_UnicoOutput.
     * 
     * @return norm_Indirizzo_UnicoOutputParams
     */
    public e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoOutputParams getNorm_Indirizzo_UnicoOutputParams() {
        return norm_Indirizzo_UnicoOutputParams;
    }


    /**
     * Sets the norm_Indirizzo_UnicoOutputParams value for this Norm_Indirizzo_UnicoOutput.
     * 
     * @param norm_Indirizzo_UnicoOutputParams
     */
    public void setNorm_Indirizzo_UnicoOutputParams(e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoOutputParams norm_Indirizzo_UnicoOutputParams) {
        this.norm_Indirizzo_UnicoOutputParams = norm_Indirizzo_UnicoOutputParams;
    }


    /**
     * Gets the outputInfo value for this Norm_Indirizzo_UnicoOutput.
     * 
     * @return outputInfo
     */
    public e_SOAPDispenser.Normalizzatore.OutputInfo getOutputInfo() {
        return outputInfo;
    }


    /**
     * Sets the outputInfo value for this Norm_Indirizzo_UnicoOutput.
     * 
     * @param outputInfo
     */
    public void setOutputInfo(e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo) {
        this.outputInfo = outputInfo;
    }


    /**
     * Gets the norm_Indirizzo_UnicoOutputRecordsetArray value for this Norm_Indirizzo_UnicoOutput.
     * 
     * @return norm_Indirizzo_UnicoOutputRecordsetArray
     */
    public e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoOutputRecordsetArray getNorm_Indirizzo_UnicoOutputRecordsetArray() {
        return norm_Indirizzo_UnicoOutputRecordsetArray;
    }


    /**
     * Sets the norm_Indirizzo_UnicoOutputRecordsetArray value for this Norm_Indirizzo_UnicoOutput.
     * 
     * @param norm_Indirizzo_UnicoOutputRecordsetArray
     */
    public void setNorm_Indirizzo_UnicoOutputRecordsetArray(e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoOutputRecordsetArray norm_Indirizzo_UnicoOutputRecordsetArray) {
        this.norm_Indirizzo_UnicoOutputRecordsetArray = norm_Indirizzo_UnicoOutputRecordsetArray;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_Indirizzo_UnicoOutput)) return false;
        Norm_Indirizzo_UnicoOutput other = (Norm_Indirizzo_UnicoOutput) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_Indirizzo_UnicoOutputParams==null && other.getNorm_Indirizzo_UnicoOutputParams()==null) || 
             (this.norm_Indirizzo_UnicoOutputParams!=null &&
              this.norm_Indirizzo_UnicoOutputParams.equals(other.getNorm_Indirizzo_UnicoOutputParams()))) &&
            ((this.outputInfo==null && other.getOutputInfo()==null) || 
             (this.outputInfo!=null &&
              this.outputInfo.equals(other.getOutputInfo()))) &&
            ((this.norm_Indirizzo_UnicoOutputRecordsetArray==null && other.getNorm_Indirizzo_UnicoOutputRecordsetArray()==null) || 
             (this.norm_Indirizzo_UnicoOutputRecordsetArray!=null &&
              this.norm_Indirizzo_UnicoOutputRecordsetArray.equals(other.getNorm_Indirizzo_UnicoOutputRecordsetArray())));
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
        if (getNorm_Indirizzo_UnicoOutputParams() != null) {
            _hashCode += getNorm_Indirizzo_UnicoOutputParams().hashCode();
        }
        if (getOutputInfo() != null) {
            _hashCode += getOutputInfo().hashCode();
        }
        if (getNorm_Indirizzo_UnicoOutputRecordsetArray() != null) {
            _hashCode += getNorm_Indirizzo_UnicoOutputRecordsetArray().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_Indirizzo_UnicoOutput.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_UnicoOutput"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_Indirizzo_UnicoOutputParams");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_UnicoOutputParams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_UnicoOutputParams"));
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
        elemField.setFieldName("norm_Indirizzo_UnicoOutputRecordsetArray");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_UnicoOutputRecordsetArray"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_UnicoOutputRecordsetArray"));
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
