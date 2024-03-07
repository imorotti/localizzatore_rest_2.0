/**
 * Norm_Indirizzo_UnicoOutputRecordsetArray.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_Indirizzo_UnicoOutputRecordsetArray  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoOutputRecordset[] norm_Indirizzo_UnicoOutputRecordset;

    public Norm_Indirizzo_UnicoOutputRecordsetArray() {
    }

    public Norm_Indirizzo_UnicoOutputRecordsetArray(
           e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoOutputRecordset[] norm_Indirizzo_UnicoOutputRecordset) {
           this.norm_Indirizzo_UnicoOutputRecordset = norm_Indirizzo_UnicoOutputRecordset;
    }


    /**
     * Gets the norm_Indirizzo_UnicoOutputRecordset value for this Norm_Indirizzo_UnicoOutputRecordsetArray.
     * 
     * @return norm_Indirizzo_UnicoOutputRecordset
     */
    public e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoOutputRecordset[] getNorm_Indirizzo_UnicoOutputRecordset() {
        return norm_Indirizzo_UnicoOutputRecordset;
    }


    /**
     * Sets the norm_Indirizzo_UnicoOutputRecordset value for this Norm_Indirizzo_UnicoOutputRecordsetArray.
     * 
     * @param norm_Indirizzo_UnicoOutputRecordset
     */
    public void setNorm_Indirizzo_UnicoOutputRecordset(e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoOutputRecordset[] norm_Indirizzo_UnicoOutputRecordset) {
        this.norm_Indirizzo_UnicoOutputRecordset = norm_Indirizzo_UnicoOutputRecordset;
    }

    public e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoOutputRecordset getNorm_Indirizzo_UnicoOutputRecordset(int i) {
        return this.norm_Indirizzo_UnicoOutputRecordset[i];
    }

    public void setNorm_Indirizzo_UnicoOutputRecordset(int i, e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoOutputRecordset _value) {
        this.norm_Indirizzo_UnicoOutputRecordset[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_Indirizzo_UnicoOutputRecordsetArray)) return false;
        Norm_Indirizzo_UnicoOutputRecordsetArray other = (Norm_Indirizzo_UnicoOutputRecordsetArray) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_Indirizzo_UnicoOutputRecordset==null && other.getNorm_Indirizzo_UnicoOutputRecordset()==null) || 
             (this.norm_Indirizzo_UnicoOutputRecordset!=null &&
              java.util.Arrays.equals(this.norm_Indirizzo_UnicoOutputRecordset, other.getNorm_Indirizzo_UnicoOutputRecordset())));
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
        if (getNorm_Indirizzo_UnicoOutputRecordset() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNorm_Indirizzo_UnicoOutputRecordset());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNorm_Indirizzo_UnicoOutputRecordset(), i);
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
        new org.apache.axis.description.TypeDesc(Norm_Indirizzo_UnicoOutputRecordsetArray.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_UnicoOutputRecordsetArray"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_Indirizzo_UnicoOutputRecordset");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_UnicoOutputRecordset"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_UnicoOutputRecordset"));
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
