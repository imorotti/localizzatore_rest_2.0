/**
 * Norm_StradarioOutputRecordsetArray_Helper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_StradarioOutputRecordsetArray_Helper {
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_StradarioOutputRecordsetArray.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_StradarioOutputRecordsetArray"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_StradarioOutputRecordset");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_StradarioOutputRecordset"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_StradarioOutputRecordset"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
