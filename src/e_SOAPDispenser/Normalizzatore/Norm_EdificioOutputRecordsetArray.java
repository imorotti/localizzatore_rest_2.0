/**
 * Norm_EdificioOutputRecordsetArray.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_EdificioOutputRecordsetArray  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_EdificioOutputRecordset[] norm_EdificioOutputRecordset;

    public Norm_EdificioOutputRecordsetArray() {
    }

    public Norm_EdificioOutputRecordsetArray(
           e_SOAPDispenser.Normalizzatore.Norm_EdificioOutputRecordset[] norm_EdificioOutputRecordset) {
           this.norm_EdificioOutputRecordset = norm_EdificioOutputRecordset;
    }


    /**
     * Gets the norm_EdificioOutputRecordset value for this Norm_EdificioOutputRecordsetArray.
     * 
     * @return norm_EdificioOutputRecordset
     */
    public e_SOAPDispenser.Normalizzatore.Norm_EdificioOutputRecordset[] getNorm_EdificioOutputRecordset() {
        return norm_EdificioOutputRecordset;
    }


    /**
     * Sets the norm_EdificioOutputRecordset value for this Norm_EdificioOutputRecordsetArray.
     * 
     * @param norm_EdificioOutputRecordset
     */
    public void setNorm_EdificioOutputRecordset(e_SOAPDispenser.Normalizzatore.Norm_EdificioOutputRecordset[] norm_EdificioOutputRecordset) {
        this.norm_EdificioOutputRecordset = norm_EdificioOutputRecordset;
    }

    public e_SOAPDispenser.Normalizzatore.Norm_EdificioOutputRecordset getNorm_EdificioOutputRecordset(int i) {
        return this.norm_EdificioOutputRecordset[i];
    }

    public void setNorm_EdificioOutputRecordset(int i, e_SOAPDispenser.Normalizzatore.Norm_EdificioOutputRecordset _value) {
        this.norm_EdificioOutputRecordset[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_EdificioOutputRecordsetArray)) return false;
        Norm_EdificioOutputRecordsetArray other = (Norm_EdificioOutputRecordsetArray) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_EdificioOutputRecordset==null && other.getNorm_EdificioOutputRecordset()==null) || 
             (this.norm_EdificioOutputRecordset!=null &&
              java.util.Arrays.equals(this.norm_EdificioOutputRecordset, other.getNorm_EdificioOutputRecordset())));
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
        if (getNorm_EdificioOutputRecordset() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNorm_EdificioOutputRecordset());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNorm_EdificioOutputRecordset(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Norm_EdificioOutputRecordsetArray.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_EdificioOutputRecordsetArray"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_EdificioOutputRecordset");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_EdificioOutputRecordset"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_EdificioOutputRecordset"));
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
