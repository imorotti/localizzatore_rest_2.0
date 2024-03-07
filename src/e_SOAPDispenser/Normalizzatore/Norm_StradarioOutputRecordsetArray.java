/**
 * Norm_StradarioOutputRecordsetArray.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_StradarioOutputRecordsetArray  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_StradarioOutputRecordset[] norm_StradarioOutputRecordset;

    public Norm_StradarioOutputRecordsetArray() {
    }

    public Norm_StradarioOutputRecordsetArray(
           e_SOAPDispenser.Normalizzatore.Norm_StradarioOutputRecordset[] norm_StradarioOutputRecordset) {
           this.norm_StradarioOutputRecordset = norm_StradarioOutputRecordset;
    }


    /**
     * Gets the norm_StradarioOutputRecordset value for this Norm_StradarioOutputRecordsetArray.
     * 
     * @return norm_StradarioOutputRecordset
     */
    public e_SOAPDispenser.Normalizzatore.Norm_StradarioOutputRecordset[] getNorm_StradarioOutputRecordset() {
        return norm_StradarioOutputRecordset;
    }


    /**
     * Sets the norm_StradarioOutputRecordset value for this Norm_StradarioOutputRecordsetArray.
     * 
     * @param norm_StradarioOutputRecordset
     */
    public void setNorm_StradarioOutputRecordset(e_SOAPDispenser.Normalizzatore.Norm_StradarioOutputRecordset[] norm_StradarioOutputRecordset) {
        this.norm_StradarioOutputRecordset = norm_StradarioOutputRecordset;
    }

    public e_SOAPDispenser.Normalizzatore.Norm_StradarioOutputRecordset getNorm_StradarioOutputRecordset(int i) {
        return this.norm_StradarioOutputRecordset[i];
    }

    public void setNorm_StradarioOutputRecordset(int i, e_SOAPDispenser.Normalizzatore.Norm_StradarioOutputRecordset _value) {
        this.norm_StradarioOutputRecordset[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_StradarioOutputRecordsetArray)) return false;
        Norm_StradarioOutputRecordsetArray other = (Norm_StradarioOutputRecordsetArray) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_StradarioOutputRecordset==null && other.getNorm_StradarioOutputRecordset()==null) || 
             (this.norm_StradarioOutputRecordset!=null &&
              java.util.Arrays.equals(this.norm_StradarioOutputRecordset, other.getNorm_StradarioOutputRecordset())));
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
        if (getNorm_StradarioOutputRecordset() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNorm_StradarioOutputRecordset());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNorm_StradarioOutputRecordset(), i);
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
