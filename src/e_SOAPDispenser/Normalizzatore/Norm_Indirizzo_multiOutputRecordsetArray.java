/**
 * Norm_Indirizzo_multiOutputRecordsetArray.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_Indirizzo_multiOutputRecordsetArray  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiOutputRecordset[] norm_Indirizzo_multiOutputRecordset;

    public Norm_Indirizzo_multiOutputRecordsetArray() {
    }

    public Norm_Indirizzo_multiOutputRecordsetArray(
           e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiOutputRecordset[] norm_Indirizzo_multiOutputRecordset) {
           this.norm_Indirizzo_multiOutputRecordset = norm_Indirizzo_multiOutputRecordset;
    }


    /**
     * Gets the norm_Indirizzo_multiOutputRecordset value for this Norm_Indirizzo_multiOutputRecordsetArray.
     * 
     * @return norm_Indirizzo_multiOutputRecordset
     */
    public e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiOutputRecordset[] getNorm_Indirizzo_multiOutputRecordset() {
        return norm_Indirizzo_multiOutputRecordset;
    }


    /**
     * Sets the norm_Indirizzo_multiOutputRecordset value for this Norm_Indirizzo_multiOutputRecordsetArray.
     * 
     * @param norm_Indirizzo_multiOutputRecordset
     */
    public void setNorm_Indirizzo_multiOutputRecordset(e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiOutputRecordset[] norm_Indirizzo_multiOutputRecordset) {
        this.norm_Indirizzo_multiOutputRecordset = norm_Indirizzo_multiOutputRecordset;
    }

    public e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiOutputRecordset getNorm_Indirizzo_multiOutputRecordset(int i) {
        return this.norm_Indirizzo_multiOutputRecordset[i];
    }

    public void setNorm_Indirizzo_multiOutputRecordset(int i, e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiOutputRecordset _value) {
        this.norm_Indirizzo_multiOutputRecordset[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_Indirizzo_multiOutputRecordsetArray)) return false;
        Norm_Indirizzo_multiOutputRecordsetArray other = (Norm_Indirizzo_multiOutputRecordsetArray) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_Indirizzo_multiOutputRecordset==null && other.getNorm_Indirizzo_multiOutputRecordset()==null) || 
             (this.norm_Indirizzo_multiOutputRecordset!=null &&
              java.util.Arrays.equals(this.norm_Indirizzo_multiOutputRecordset, other.getNorm_Indirizzo_multiOutputRecordset())));
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
        if (getNorm_Indirizzo_multiOutputRecordset() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNorm_Indirizzo_multiOutputRecordset());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNorm_Indirizzo_multiOutputRecordset(), i);
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
        new org.apache.axis.description.TypeDesc(Norm_Indirizzo_multiOutputRecordsetArray.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_multiOutputRecordsetArray"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_Indirizzo_multiOutputRecordset");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_multiOutputRecordset"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_multiOutputRecordset"));
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
