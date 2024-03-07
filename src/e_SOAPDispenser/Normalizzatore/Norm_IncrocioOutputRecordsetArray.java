/**
 * Norm_IncrocioOutputRecordsetArray.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_IncrocioOutputRecordsetArray  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_IncrocioOutputRecordset[] norm_IncrocioOutputRecordset;

    public Norm_IncrocioOutputRecordsetArray() {
    }

    public Norm_IncrocioOutputRecordsetArray(
           e_SOAPDispenser.Normalizzatore.Norm_IncrocioOutputRecordset[] norm_IncrocioOutputRecordset) {
           this.norm_IncrocioOutputRecordset = norm_IncrocioOutputRecordset;
    }


    /**
     * Gets the norm_IncrocioOutputRecordset value for this Norm_IncrocioOutputRecordsetArray.
     * 
     * @return norm_IncrocioOutputRecordset
     */
    public e_SOAPDispenser.Normalizzatore.Norm_IncrocioOutputRecordset[] getNorm_IncrocioOutputRecordset() {
        return norm_IncrocioOutputRecordset;
    }


    /**
     * Sets the norm_IncrocioOutputRecordset value for this Norm_IncrocioOutputRecordsetArray.
     * 
     * @param norm_IncrocioOutputRecordset
     */
    public void setNorm_IncrocioOutputRecordset(e_SOAPDispenser.Normalizzatore.Norm_IncrocioOutputRecordset[] norm_IncrocioOutputRecordset) {
        this.norm_IncrocioOutputRecordset = norm_IncrocioOutputRecordset;
    }

    public e_SOAPDispenser.Normalizzatore.Norm_IncrocioOutputRecordset getNorm_IncrocioOutputRecordset(int i) {
        return this.norm_IncrocioOutputRecordset[i];
    }

    public void setNorm_IncrocioOutputRecordset(int i, e_SOAPDispenser.Normalizzatore.Norm_IncrocioOutputRecordset _value) {
        this.norm_IncrocioOutputRecordset[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_IncrocioOutputRecordsetArray)) return false;
        Norm_IncrocioOutputRecordsetArray other = (Norm_IncrocioOutputRecordsetArray) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_IncrocioOutputRecordset==null && other.getNorm_IncrocioOutputRecordset()==null) || 
             (this.norm_IncrocioOutputRecordset!=null &&
              java.util.Arrays.equals(this.norm_IncrocioOutputRecordset, other.getNorm_IncrocioOutputRecordset())));
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
        if (getNorm_IncrocioOutputRecordset() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNorm_IncrocioOutputRecordset());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNorm_IncrocioOutputRecordset(), i);
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
        new org.apache.axis.description.TypeDesc(Norm_IncrocioOutputRecordsetArray.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IncrocioOutputRecordsetArray"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_IncrocioOutputRecordset");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IncrocioOutputRecordset"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IncrocioOutputRecordset"));
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
