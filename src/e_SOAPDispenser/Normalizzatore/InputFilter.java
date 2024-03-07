/**
 * InputFilter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class InputFilter  implements java.io.Serializable {
    private java.lang.Integer startRecord;
    private java.lang.Integer endRecord;
    private java.lang.String whereClause;

    public InputFilter() {
    }

    public InputFilter(
           java.lang.Integer startRecord,
           java.lang.Integer endRecord,
           java.lang.String whereClause) {
           this.startRecord = startRecord;
           this.endRecord = endRecord;
           this.whereClause = whereClause;
    }


    /**
     * Gets the startRecord value for this InputFilter.
     * 
     * @return startRecord
     */
    public java.lang.Integer getStartRecord() {
        return startRecord;
    }


    /**
     * Sets the startRecord value for this InputFilter.
     * 
     * @param startRecord
     */
    public void setStartRecord(java.lang.Integer startRecord) {
        this.startRecord = startRecord;
    }


    /**
     * Gets the endRecord value for this InputFilter.
     * 
     * @return endRecord
     */
    public java.lang.Integer getEndRecord() {
        return endRecord;
    }


    /**
     * Sets the endRecord value for this InputFilter.
     * 
     * @param endRecord
     */
    public void setEndRecord(java.lang.Integer endRecord) {
        this.endRecord = endRecord;
    }


    /**
     * Gets the whereClause value for this InputFilter.
     * 
     * @return whereClause
     */
    public java.lang.String getWhereClause() {
        return whereClause;
    }


    /**
     * Sets the whereClause value for this InputFilter.
     * 
     * @param whereClause
     */
    public void setWhereClause(java.lang.String whereClause) {
        this.whereClause = whereClause;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InputFilter)) return false;
        InputFilter other = (InputFilter) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.startRecord==null && other.getStartRecord()==null) || 
             (this.startRecord!=null &&
              this.startRecord.equals(other.getStartRecord()))) &&
            ((this.endRecord==null && other.getEndRecord()==null) || 
             (this.endRecord!=null &&
              this.endRecord.equals(other.getEndRecord()))) &&
            ((this.whereClause==null && other.getWhereClause()==null) || 
             (this.whereClause!=null &&
              this.whereClause.equals(other.getWhereClause())));
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
        if (getStartRecord() != null) {
            _hashCode += getStartRecord().hashCode();
        }
        if (getEndRecord() != null) {
            _hashCode += getEndRecord().hashCode();
        }
        if (getWhereClause() != null) {
            _hashCode += getWhereClause().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InputFilter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "InputFilter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startRecord");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "startRecord"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endRecord");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "endRecord"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("whereClause");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "whereClause"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
