/**
 * Norm_Indirizzo1OutputRecordsetArray.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_Indirizzo1OutputRecordsetArray  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1OutputRecordset[] norm_Indirizzo1OutputRecordset;

    public Norm_Indirizzo1OutputRecordsetArray() {
    }

    public Norm_Indirizzo1OutputRecordsetArray(
           e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1OutputRecordset[] norm_Indirizzo1OutputRecordset) {
           this.norm_Indirizzo1OutputRecordset = norm_Indirizzo1OutputRecordset;
    }


    /**
     * Gets the norm_Indirizzo1OutputRecordset value for this Norm_Indirizzo1OutputRecordsetArray.
     * 
     * @return norm_Indirizzo1OutputRecordset
     */
    public e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1OutputRecordset[] getNorm_Indirizzo1OutputRecordset() {
        return norm_Indirizzo1OutputRecordset;
    }


    /**
     * Sets the norm_Indirizzo1OutputRecordset value for this Norm_Indirizzo1OutputRecordsetArray.
     * 
     * @param norm_Indirizzo1OutputRecordset
     */
    public void setNorm_Indirizzo1OutputRecordset(e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1OutputRecordset[] norm_Indirizzo1OutputRecordset) {
        this.norm_Indirizzo1OutputRecordset = norm_Indirizzo1OutputRecordset;
    }

    public e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1OutputRecordset getNorm_Indirizzo1OutputRecordset(int i) {
        return this.norm_Indirizzo1OutputRecordset[i];
    }

    public void setNorm_Indirizzo1OutputRecordset(int i, e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1OutputRecordset _value) {
        this.norm_Indirizzo1OutputRecordset[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_Indirizzo1OutputRecordsetArray)) return false;
        Norm_Indirizzo1OutputRecordsetArray other = (Norm_Indirizzo1OutputRecordsetArray) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_Indirizzo1OutputRecordset==null && other.getNorm_Indirizzo1OutputRecordset()==null) || 
             (this.norm_Indirizzo1OutputRecordset!=null &&
              java.util.Arrays.equals(this.norm_Indirizzo1OutputRecordset, other.getNorm_Indirizzo1OutputRecordset())));
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
        if (getNorm_Indirizzo1OutputRecordset() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNorm_Indirizzo1OutputRecordset());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNorm_Indirizzo1OutputRecordset(), i);
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
        new org.apache.axis.description.TypeDesc(Norm_Indirizzo1OutputRecordsetArray.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo1OutputRecordsetArray"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_Indirizzo1OutputRecordset");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo1OutputRecordset"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo1OutputRecordset"));
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
