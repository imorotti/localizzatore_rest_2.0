/**
 * Norm_Luoghi_NotevoliOutputRecordsetArray.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_Luoghi_NotevoliOutputRecordsetArray  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliOutputRecordset[] norm_Luoghi_NotevoliOutputRecordset;

    public Norm_Luoghi_NotevoliOutputRecordsetArray() {
    }

    public Norm_Luoghi_NotevoliOutputRecordsetArray(
           e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliOutputRecordset[] norm_Luoghi_NotevoliOutputRecordset) {
           this.norm_Luoghi_NotevoliOutputRecordset = norm_Luoghi_NotevoliOutputRecordset;
    }


    /**
     * Gets the norm_Luoghi_NotevoliOutputRecordset value for this Norm_Luoghi_NotevoliOutputRecordsetArray.
     * 
     * @return norm_Luoghi_NotevoliOutputRecordset
     */
    public e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliOutputRecordset[] getNorm_Luoghi_NotevoliOutputRecordset() {
        return norm_Luoghi_NotevoliOutputRecordset;
    }


    /**
     * Sets the norm_Luoghi_NotevoliOutputRecordset value for this Norm_Luoghi_NotevoliOutputRecordsetArray.
     * 
     * @param norm_Luoghi_NotevoliOutputRecordset
     */
    public void setNorm_Luoghi_NotevoliOutputRecordset(e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliOutputRecordset[] norm_Luoghi_NotevoliOutputRecordset) {
        this.norm_Luoghi_NotevoliOutputRecordset = norm_Luoghi_NotevoliOutputRecordset;
    }

    public e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliOutputRecordset getNorm_Luoghi_NotevoliOutputRecordset(int i) {
        return this.norm_Luoghi_NotevoliOutputRecordset[i];
    }

    public void setNorm_Luoghi_NotevoliOutputRecordset(int i, e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliOutputRecordset _value) {
        this.norm_Luoghi_NotevoliOutputRecordset[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_Luoghi_NotevoliOutputRecordsetArray)) return false;
        Norm_Luoghi_NotevoliOutputRecordsetArray other = (Norm_Luoghi_NotevoliOutputRecordsetArray) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_Luoghi_NotevoliOutputRecordset==null && other.getNorm_Luoghi_NotevoliOutputRecordset()==null) || 
             (this.norm_Luoghi_NotevoliOutputRecordset!=null &&
              java.util.Arrays.equals(this.norm_Luoghi_NotevoliOutputRecordset, other.getNorm_Luoghi_NotevoliOutputRecordset())));
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
        if (getNorm_Luoghi_NotevoliOutputRecordset() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNorm_Luoghi_NotevoliOutputRecordset());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNorm_Luoghi_NotevoliOutputRecordset(), i);
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
        new org.apache.axis.description.TypeDesc(Norm_Luoghi_NotevoliOutputRecordsetArray.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Luoghi_NotevoliOutputRecordsetArray"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_Luoghi_NotevoliOutputRecordset");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Luoghi_NotevoliOutputRecordset"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Luoghi_NotevoliOutputRecordset"));
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
