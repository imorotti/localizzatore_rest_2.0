/**
 * Norm_Indirizzo1Output.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_Indirizzo1Output  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1OutputParams norm_Indirizzo1OutputParams;
    private e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo;
    private e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1OutputRecordsetArray norm_Indirizzo1OutputRecordsetArray;

    public Norm_Indirizzo1Output() {
    }

    public Norm_Indirizzo1Output(
           e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1OutputParams norm_Indirizzo1OutputParams,
           e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo,
           e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1OutputRecordsetArray norm_Indirizzo1OutputRecordsetArray) {
           this.norm_Indirizzo1OutputParams = norm_Indirizzo1OutputParams;
           this.outputInfo = outputInfo;
           this.norm_Indirizzo1OutputRecordsetArray = norm_Indirizzo1OutputRecordsetArray;
    }


    /**
     * Gets the norm_Indirizzo1OutputParams value for this Norm_Indirizzo1Output.
     * 
     * @return norm_Indirizzo1OutputParams
     */
    public e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1OutputParams getNorm_Indirizzo1OutputParams() {
        return norm_Indirizzo1OutputParams;
    }


    /**
     * Sets the norm_Indirizzo1OutputParams value for this Norm_Indirizzo1Output.
     * 
     * @param norm_Indirizzo1OutputParams
     */
    public void setNorm_Indirizzo1OutputParams(e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1OutputParams norm_Indirizzo1OutputParams) {
        this.norm_Indirizzo1OutputParams = norm_Indirizzo1OutputParams;
    }


    /**
     * Gets the outputInfo value for this Norm_Indirizzo1Output.
     * 
     * @return outputInfo
     */
    public e_SOAPDispenser.Normalizzatore.OutputInfo getOutputInfo() {
        return outputInfo;
    }


    /**
     * Sets the outputInfo value for this Norm_Indirizzo1Output.
     * 
     * @param outputInfo
     */
    public void setOutputInfo(e_SOAPDispenser.Normalizzatore.OutputInfo outputInfo) {
        this.outputInfo = outputInfo;
    }


    /**
     * Gets the norm_Indirizzo1OutputRecordsetArray value for this Norm_Indirizzo1Output.
     * 
     * @return norm_Indirizzo1OutputRecordsetArray
     */
    public e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1OutputRecordsetArray getNorm_Indirizzo1OutputRecordsetArray() {
        return norm_Indirizzo1OutputRecordsetArray;
    }


    /**
     * Sets the norm_Indirizzo1OutputRecordsetArray value for this Norm_Indirizzo1Output.
     * 
     * @param norm_Indirizzo1OutputRecordsetArray
     */
    public void setNorm_Indirizzo1OutputRecordsetArray(e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1OutputRecordsetArray norm_Indirizzo1OutputRecordsetArray) {
        this.norm_Indirizzo1OutputRecordsetArray = norm_Indirizzo1OutputRecordsetArray;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_Indirizzo1Output)) return false;
        Norm_Indirizzo1Output other = (Norm_Indirizzo1Output) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_Indirizzo1OutputParams==null && other.getNorm_Indirizzo1OutputParams()==null) || 
             (this.norm_Indirizzo1OutputParams!=null &&
              this.norm_Indirizzo1OutputParams.equals(other.getNorm_Indirizzo1OutputParams()))) &&
            ((this.outputInfo==null && other.getOutputInfo()==null) || 
             (this.outputInfo!=null &&
              this.outputInfo.equals(other.getOutputInfo()))) &&
            ((this.norm_Indirizzo1OutputRecordsetArray==null && other.getNorm_Indirizzo1OutputRecordsetArray()==null) || 
             (this.norm_Indirizzo1OutputRecordsetArray!=null &&
              this.norm_Indirizzo1OutputRecordsetArray.equals(other.getNorm_Indirizzo1OutputRecordsetArray())));
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
        if (getNorm_Indirizzo1OutputParams() != null) {
            _hashCode += getNorm_Indirizzo1OutputParams().hashCode();
        }
        if (getOutputInfo() != null) {
            _hashCode += getOutputInfo().hashCode();
        }
        if (getNorm_Indirizzo1OutputRecordsetArray() != null) {
            _hashCode += getNorm_Indirizzo1OutputRecordsetArray().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_Indirizzo1Output.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo1Output"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_Indirizzo1OutputParams");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo1OutputParams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo1OutputParams"));
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
        elemField.setFieldName("norm_Indirizzo1OutputRecordsetArray");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo1OutputRecordsetArray"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo1OutputRecordsetArray"));
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
