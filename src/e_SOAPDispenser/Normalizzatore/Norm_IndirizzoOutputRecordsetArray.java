/**
 * Norm_IndirizzoOutputRecordsetArray.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_IndirizzoOutputRecordsetArray  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_IndirizzoOutputRecordset[] norm_IndirizzoOutputRecordset;

    public Norm_IndirizzoOutputRecordsetArray() {
    }

    public Norm_IndirizzoOutputRecordsetArray(
           e_SOAPDispenser.Normalizzatore.Norm_IndirizzoOutputRecordset[] norm_IndirizzoOutputRecordset) {
           this.norm_IndirizzoOutputRecordset = norm_IndirizzoOutputRecordset;
    }


    /**
     * Gets the norm_IndirizzoOutputRecordset value for this Norm_IndirizzoOutputRecordsetArray.
     * 
     * @return norm_IndirizzoOutputRecordset
     */
    public e_SOAPDispenser.Normalizzatore.Norm_IndirizzoOutputRecordset[] getNorm_IndirizzoOutputRecordset() {
        return norm_IndirizzoOutputRecordset;
    }


    /**
     * Sets the norm_IndirizzoOutputRecordset value for this Norm_IndirizzoOutputRecordsetArray.
     * 
     * @param norm_IndirizzoOutputRecordset
     */
    public void setNorm_IndirizzoOutputRecordset(e_SOAPDispenser.Normalizzatore.Norm_IndirizzoOutputRecordset[] norm_IndirizzoOutputRecordset) {
        this.norm_IndirizzoOutputRecordset = norm_IndirizzoOutputRecordset;
    }

    public e_SOAPDispenser.Normalizzatore.Norm_IndirizzoOutputRecordset getNorm_IndirizzoOutputRecordset(int i) {
        return this.norm_IndirizzoOutputRecordset[i];
    }

    public void setNorm_IndirizzoOutputRecordset(int i, e_SOAPDispenser.Normalizzatore.Norm_IndirizzoOutputRecordset _value) {
        this.norm_IndirizzoOutputRecordset[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_IndirizzoOutputRecordsetArray)) return false;
        Norm_IndirizzoOutputRecordsetArray other = (Norm_IndirizzoOutputRecordsetArray) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_IndirizzoOutputRecordset==null && other.getNorm_IndirizzoOutputRecordset()==null) || 
             (this.norm_IndirizzoOutputRecordset!=null &&
              java.util.Arrays.equals(this.norm_IndirizzoOutputRecordset, other.getNorm_IndirizzoOutputRecordset())));
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
        if (getNorm_IndirizzoOutputRecordset() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNorm_IndirizzoOutputRecordset());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNorm_IndirizzoOutputRecordset(), i);
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
        new org.apache.axis.description.TypeDesc(Norm_IndirizzoOutputRecordsetArray.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IndirizzoOutputRecordsetArray"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_IndirizzoOutputRecordset");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IndirizzoOutputRecordset"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IndirizzoOutputRecordset"));
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
