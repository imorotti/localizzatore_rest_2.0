/**
 * Norm_Indirizzo2Output.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_Indirizzo2Output  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_Indirizzo2OutputParams norm_Indirizzo2OutputParams;
    private e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo;
    private e_SOAPDispenser.Normalizzatore.Norm_Indirizzo2OutputRecordsetArray norm_Indirizzo2OutputRecordsetArray;

    public Norm_Indirizzo2Output() {
    }

    public Norm_Indirizzo2Output(
           e_SOAPDispenser.Normalizzatore.Norm_Indirizzo2OutputParams norm_Indirizzo2OutputParams,
           e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo,
           e_SOAPDispenser.Normalizzatore.Norm_Indirizzo2OutputRecordsetArray norm_Indirizzo2OutputRecordsetArray) {
           this.norm_Indirizzo2OutputParams = norm_Indirizzo2OutputParams;
           this.outputInfo = outputInfo;
           this.norm_Indirizzo2OutputRecordsetArray = norm_Indirizzo2OutputRecordsetArray;
    }


    /**
     * Gets the norm_Indirizzo2OutputParams value for this Norm_Indirizzo2Output.
     * 
     * @return norm_Indirizzo2OutputParams
     */
    public e_SOAPDispenser.Normalizzatore.Norm_Indirizzo2OutputParams getNorm_Indirizzo2OutputParams() {
        return norm_Indirizzo2OutputParams;
    }


    /**
     * Sets the norm_Indirizzo2OutputParams value for this Norm_Indirizzo2Output.
     * 
     * @param norm_Indirizzo2OutputParams
     */
    public void setNorm_Indirizzo2OutputParams(e_SOAPDispenser.Normalizzatore.Norm_Indirizzo2OutputParams norm_Indirizzo2OutputParams) {
        this.norm_Indirizzo2OutputParams = norm_Indirizzo2OutputParams;
    }


    /**
     * Gets the outputInfo value for this Norm_Indirizzo2Output.
     * 
     * @return outputInfo
     */
    public e_SOAPDispenser.Normalizzatore.OutputInfo getOutputInfo() {
        return outputInfo;
    }


    /**
     * Sets the outputInfo value for this Norm_Indirizzo2Output.
     * 
     * @param outputInfo
     */
    public void setOutputInfo(e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo) {
        this.outputInfo = outputInfo;
    }


    /**
     * Gets the norm_Indirizzo2OutputRecordsetArray value for this Norm_Indirizzo2Output.
     * 
     * @return norm_Indirizzo2OutputRecordsetArray
     */
    public e_SOAPDispenser.Normalizzatore.Norm_Indirizzo2OutputRecordsetArray getNorm_Indirizzo2OutputRecordsetArray() {
        return norm_Indirizzo2OutputRecordsetArray;
    }


    /**
     * Sets the norm_Indirizzo2OutputRecordsetArray value for this Norm_Indirizzo2Output.
     * 
     * @param norm_Indirizzo2OutputRecordsetArray
     */
    public void setNorm_Indirizzo2OutputRecordsetArray(e_SOAPDispenser.Normalizzatore.Norm_Indirizzo2OutputRecordsetArray norm_Indirizzo2OutputRecordsetArray) {
        this.norm_Indirizzo2OutputRecordsetArray = norm_Indirizzo2OutputRecordsetArray;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_Indirizzo2Output)) return false;
        Norm_Indirizzo2Output other = (Norm_Indirizzo2Output) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_Indirizzo2OutputParams==null && other.getNorm_Indirizzo2OutputParams()==null) || 
             (this.norm_Indirizzo2OutputParams!=null &&
              this.norm_Indirizzo2OutputParams.equals(other.getNorm_Indirizzo2OutputParams()))) &&
            ((this.outputInfo==null && other.getOutputInfo()==null) || 
             (this.outputInfo!=null &&
              this.outputInfo.equals(other.getOutputInfo()))) &&
            ((this.norm_Indirizzo2OutputRecordsetArray==null && other.getNorm_Indirizzo2OutputRecordsetArray()==null) || 
             (this.norm_Indirizzo2OutputRecordsetArray!=null &&
              this.norm_Indirizzo2OutputRecordsetArray.equals(other.getNorm_Indirizzo2OutputRecordsetArray())));
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
        if (getNorm_Indirizzo2OutputParams() != null) {
            _hashCode += getNorm_Indirizzo2OutputParams().hashCode();
        }
        if (getOutputInfo() != null) {
            _hashCode += getOutputInfo().hashCode();
        }
        if (getNorm_Indirizzo2OutputRecordsetArray() != null) {
            _hashCode += getNorm_Indirizzo2OutputRecordsetArray().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_Indirizzo2Output.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo2Output"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_Indirizzo2OutputParams");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo2OutputParams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo2OutputParams"));
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
        elemField.setFieldName("norm_Indirizzo2OutputRecordsetArray");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo2OutputRecordsetArray"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo2OutputRecordsetArray"));
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
