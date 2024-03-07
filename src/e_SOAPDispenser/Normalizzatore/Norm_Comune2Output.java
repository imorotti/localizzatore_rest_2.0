/**
 * Norm_Comune2Output.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_Comune2Output  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_Comune2OutputParams norm_Comune2OutputParams;
    private e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo;
    private e_SOAPDispenser.Normalizzatore.Norm_Comune2OutputRecordsetArray norm_Comune2OutputRecordsetArray;

    public Norm_Comune2Output() {
    }

    public Norm_Comune2Output(
           e_SOAPDispenser.Normalizzatore.Norm_Comune2OutputParams norm_Comune2OutputParams,
           e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo,
           e_SOAPDispenser.Normalizzatore.Norm_Comune2OutputRecordsetArray norm_Comune2OutputRecordsetArray) {
           this.norm_Comune2OutputParams = norm_Comune2OutputParams;
           this.outputInfo = outputInfo;
           this.norm_Comune2OutputRecordsetArray = norm_Comune2OutputRecordsetArray;
    }


    /**
     * Gets the norm_Comune2OutputParams value for this Norm_Comune2Output.
     * 
     * @return norm_Comune2OutputParams
     */
    public e_SOAPDispenser.Normalizzatore.Norm_Comune2OutputParams getNorm_Comune2OutputParams() {
        return norm_Comune2OutputParams;
    }


    /**
     * Sets the norm_Comune2OutputParams value for this Norm_Comune2Output.
     * 
     * @param norm_Comune2OutputParams
     */
    public void setNorm_Comune2OutputParams(e_SOAPDispenser.Normalizzatore.Norm_Comune2OutputParams norm_Comune2OutputParams) {
        this.norm_Comune2OutputParams = norm_Comune2OutputParams;
    }


    /**
     * Gets the outputInfo value for this Norm_Comune2Output.
     * 
     * @return outputInfo
     */
    public e_SOAPDispenser.Normalizzatore.OutputInfo getOutputInfo() {
        return outputInfo;
    }


    /**
     * Sets the outputInfo value for this Norm_Comune2Output.
     * 
     * @param outputInfo
     */
    public void setOutputInfo(e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo) {
        this.outputInfo = outputInfo;
    }


    /**
     * Gets the norm_Comune2OutputRecordsetArray value for this Norm_Comune2Output.
     * 
     * @return norm_Comune2OutputRecordsetArray
     */
    public e_SOAPDispenser.Normalizzatore.Norm_Comune2OutputRecordsetArray getNorm_Comune2OutputRecordsetArray() {
        return norm_Comune2OutputRecordsetArray;
    }


    /**
     * Sets the norm_Comune2OutputRecordsetArray value for this Norm_Comune2Output.
     * 
     * @param norm_Comune2OutputRecordsetArray
     */
    public void setNorm_Comune2OutputRecordsetArray(e_SOAPDispenser.Normalizzatore.Norm_Comune2OutputRecordsetArray norm_Comune2OutputRecordsetArray) {
        this.norm_Comune2OutputRecordsetArray = norm_Comune2OutputRecordsetArray;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_Comune2Output)) return false;
        Norm_Comune2Output other = (Norm_Comune2Output) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_Comune2OutputParams==null && other.getNorm_Comune2OutputParams()==null) || 
             (this.norm_Comune2OutputParams!=null &&
              this.norm_Comune2OutputParams.equals(other.getNorm_Comune2OutputParams()))) &&
            ((this.outputInfo==null && other.getOutputInfo()==null) || 
             (this.outputInfo!=null &&
              this.outputInfo.equals(other.getOutputInfo()))) &&
            ((this.norm_Comune2OutputRecordsetArray==null && other.getNorm_Comune2OutputRecordsetArray()==null) || 
             (this.norm_Comune2OutputRecordsetArray!=null &&
              this.norm_Comune2OutputRecordsetArray.equals(other.getNorm_Comune2OutputRecordsetArray())));
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
        if (getNorm_Comune2OutputParams() != null) {
            _hashCode += getNorm_Comune2OutputParams().hashCode();
        }
        if (getOutputInfo() != null) {
            _hashCode += getOutputInfo().hashCode();
        }
        if (getNorm_Comune2OutputRecordsetArray() != null) {
            _hashCode += getNorm_Comune2OutputRecordsetArray().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_Comune2Output.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Comune2Output"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_Comune2OutputParams");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Comune2OutputParams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Comune2OutputParams"));
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
        elemField.setFieldName("norm_Comune2OutputRecordsetArray");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Comune2OutputRecordsetArray"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Comune2OutputRecordsetArray"));
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
