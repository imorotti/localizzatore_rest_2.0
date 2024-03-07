/**
 * Norm_ProvinciaOutputRecordsetArray.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_ProvinciaOutputRecordsetArray  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_ProvinciaOutputRecordset[] norm_ProvinciaOutputRecordset;

    public Norm_ProvinciaOutputRecordsetArray() {
    }

    public Norm_ProvinciaOutputRecordsetArray(
           e_SOAPDispenser.Normalizzatore.Norm_ProvinciaOutputRecordset[] norm_ProvinciaOutputRecordset) {
           this.norm_ProvinciaOutputRecordset = norm_ProvinciaOutputRecordset;
    }


    /**
     * Gets the norm_ProvinciaOutputRecordset value for this Norm_ProvinciaOutputRecordsetArray.
     * 
     * @return norm_ProvinciaOutputRecordset
     */
    public e_SOAPDispenser.Normalizzatore.Norm_ProvinciaOutputRecordset[] getNorm_ProvinciaOutputRecordset() {
        return norm_ProvinciaOutputRecordset;
    }


    /**
     * Sets the norm_ProvinciaOutputRecordset value for this Norm_ProvinciaOutputRecordsetArray.
     * 
     * @param norm_ProvinciaOutputRecordset
     */
    public void setNorm_ProvinciaOutputRecordset(e_SOAPDispenser.Normalizzatore.Norm_ProvinciaOutputRecordset[] norm_ProvinciaOutputRecordset) {
        this.norm_ProvinciaOutputRecordset = norm_ProvinciaOutputRecordset;
    }

    public e_SOAPDispenser.Normalizzatore.Norm_ProvinciaOutputRecordset getNorm_ProvinciaOutputRecordset(int i) {
        return this.norm_ProvinciaOutputRecordset[i];
    }

    public void setNorm_ProvinciaOutputRecordset(int i, e_SOAPDispenser.Normalizzatore.Norm_ProvinciaOutputRecordset _value) {
        this.norm_ProvinciaOutputRecordset[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_ProvinciaOutputRecordsetArray)) return false;
        Norm_ProvinciaOutputRecordsetArray other = (Norm_ProvinciaOutputRecordsetArray) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_ProvinciaOutputRecordset==null && other.getNorm_ProvinciaOutputRecordset()==null) || 
             (this.norm_ProvinciaOutputRecordset!=null &&
              java.util.Arrays.equals(this.norm_ProvinciaOutputRecordset, other.getNorm_ProvinciaOutputRecordset())));
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
        if (getNorm_ProvinciaOutputRecordset() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNorm_ProvinciaOutputRecordset());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNorm_ProvinciaOutputRecordset(), i);
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
        new org.apache.axis.description.TypeDesc(Norm_ProvinciaOutputRecordsetArray.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_ProvinciaOutputRecordsetArray"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_ProvinciaOutputRecordset");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_ProvinciaOutputRecordset"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_ProvinciaOutputRecordset"));
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
