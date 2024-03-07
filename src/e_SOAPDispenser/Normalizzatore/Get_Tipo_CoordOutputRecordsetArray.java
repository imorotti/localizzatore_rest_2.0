/**
 * Get_Tipo_CoordOutputRecordsetArray.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class Get_Tipo_CoordOutputRecordsetArray  implements java.io.Serializable {
    private e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordOutputRecordset[] get_Tipo_CoordOutputRecordset;

    public Get_Tipo_CoordOutputRecordsetArray() {
    }

    public Get_Tipo_CoordOutputRecordsetArray(
           e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordOutputRecordset[] get_Tipo_CoordOutputRecordset) {
           this.get_Tipo_CoordOutputRecordset = get_Tipo_CoordOutputRecordset;
    }


    /**
     * Gets the get_Tipo_CoordOutputRecordset value for this Get_Tipo_CoordOutputRecordsetArray.
     * 
     * @return get_Tipo_CoordOutputRecordset
     */
    public e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordOutputRecordset[] getGet_Tipo_CoordOutputRecordset() {
        return get_Tipo_CoordOutputRecordset;
    }


    /**
     * Sets the get_Tipo_CoordOutputRecordset value for this Get_Tipo_CoordOutputRecordsetArray.
     * 
     * @param get_Tipo_CoordOutputRecordset
     */
    public void setGet_Tipo_CoordOutputRecordset(e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordOutputRecordset[] get_Tipo_CoordOutputRecordset) {
        this.get_Tipo_CoordOutputRecordset = get_Tipo_CoordOutputRecordset;
    }

    public e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordOutputRecordset getGet_Tipo_CoordOutputRecordset(int i) {
        return this.get_Tipo_CoordOutputRecordset[i];
    }

    public void setGet_Tipo_CoordOutputRecordset(int i, e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordOutputRecordset _value) {
        this.get_Tipo_CoordOutputRecordset[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Get_Tipo_CoordOutputRecordsetArray)) return false;
        Get_Tipo_CoordOutputRecordsetArray other = (Get_Tipo_CoordOutputRecordsetArray) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.get_Tipo_CoordOutputRecordset==null && other.getGet_Tipo_CoordOutputRecordset()==null) || 
             (this.get_Tipo_CoordOutputRecordset!=null &&
              java.util.Arrays.equals(this.get_Tipo_CoordOutputRecordset, other.getGet_Tipo_CoordOutputRecordset())));
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
        if (getGet_Tipo_CoordOutputRecordset() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGet_Tipo_CoordOutputRecordset());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGet_Tipo_CoordOutputRecordset(), i);
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
        new org.apache.axis.description.TypeDesc(Get_Tipo_CoordOutputRecordsetArray.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Tipo_CoordOutputRecordsetArray"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("get_Tipo_CoordOutputRecordset");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Tipo_CoordOutputRecordset"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Tipo_CoordOutputRecordset"));
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
