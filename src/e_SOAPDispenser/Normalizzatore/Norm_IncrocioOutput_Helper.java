/**
 * Norm_IncrocioOutput_Helper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_IncrocioOutput_Helper {
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
