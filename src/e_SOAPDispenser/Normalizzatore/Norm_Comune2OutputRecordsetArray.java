/**
 * Norm_Comune2OutputRecordsetArray.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Norm_Comune2OutputRecordsetArray  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Norm_Comune2OutputRecordset[] norm_Comune2OutputRecordset;

    public Norm_Comune2OutputRecordsetArray() {
    }

    public Norm_Comune2OutputRecordsetArray(
           e_SOAPDispenser.Normalizzatore.Norm_Comune2OutputRecordset[] norm_Comune2OutputRecordset) {
           this.norm_Comune2OutputRecordset = norm_Comune2OutputRecordset;
    }


    /**
     * Gets the norm_Comune2OutputRecordset value for this Norm_Comune2OutputRecordsetArray.
     * 
     * @return norm_Comune2OutputRecordset
     */
    public e_SOAPDispenser.Normalizzatore.Norm_Comune2OutputRecordset[] getNorm_Comune2OutputRecordset() {
        return norm_Comune2OutputRecordset;
    }


    /**
     * Sets the norm_Comune2OutputRecordset value for this Norm_Comune2OutputRecordsetArray.
     * 
     * @param norm_Comune2OutputRecordset
     */
    public void setNorm_Comune2OutputRecordset(e_SOAPDispenser.Normalizzatore.Norm_Comune2OutputRecordset[] norm_Comune2OutputRecordset) {
        this.norm_Comune2OutputRecordset = norm_Comune2OutputRecordset;
    }

    public e_SOAPDispenser.Normalizzatore.Norm_Comune2OutputRecordset getNorm_Comune2OutputRecordset(int i) {
        return this.norm_Comune2OutputRecordset[i];
    }

    public void setNorm_Comune2OutputRecordset(int i, e_SOAPDispenser.Normalizzatore.Norm_Comune2OutputRecordset _value) {
        this.norm_Comune2OutputRecordset[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Norm_Comune2OutputRecordsetArray)) return false;
        Norm_Comune2OutputRecordsetArray other = (Norm_Comune2OutputRecordsetArray) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.norm_Comune2OutputRecordset==null && other.getNorm_Comune2OutputRecordset()==null) || 
             (this.norm_Comune2OutputRecordset!=null &&
              java.util.Arrays.equals(this.norm_Comune2OutputRecordset, other.getNorm_Comune2OutputRecordset())));
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
        if (getNorm_Comune2OutputRecordset() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNorm_Comune2OutputRecordset());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNorm_Comune2OutputRecordset(), i);
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
        new org.apache.axis.description.TypeDesc(Norm_Comune2OutputRecordsetArray.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Comune2OutputRecordsetArray"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norm_Comune2OutputRecordset");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Comune2OutputRecordset"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Comune2OutputRecordset"));
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
