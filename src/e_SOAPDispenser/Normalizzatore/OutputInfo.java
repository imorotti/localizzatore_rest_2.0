/**
 * OutputInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class OutputInfo  implements java.io.Serializable {
    private java.lang.Integer affectedRows;
    private java.lang.Integer startRecord;
    private java.lang.Integer endRecord;
    private java.lang.Integer totalRecords;

    public OutputInfo() {
    }

    public OutputInfo(
           java.lang.Integer affectedRows,
           java.lang.Integer startRecord,
           java.lang.Integer endRecord,
           java.lang.Integer totalRecords) {
           this.affectedRows = affectedRows;
           this.startRecord = startRecord;
           this.endRecord = endRecord;
           this.totalRecords = totalRecords;
    }


    /**
     * Gets the affectedRows value for this OutputInfo.
     * 
     * @return affectedRows
     */
    public java.lang.Integer getAffectedRows() {
        return affectedRows;
    }


    /**
     * Sets the affectedRows value for this OutputInfo.
     * 
     * @param affectedRows
     */
    public void setAffectedRows(java.lang.Integer affectedRows) {
        this.affectedRows = affectedRows;
    }


    /**
     * Gets the startRecord value for this OutputInfo.
     * 
     * @return startRecord
     */
    public java.lang.Integer getStartRecord() {
        return startRecord;
    }


    /**
     * Sets the startRecord value for this OutputInfo.
     * 
     * @param startRecord
     */
    public void setStartRecord(java.lang.Integer startRecord) {
        this.startRecord = startRecord;
    }


    /**
     * Gets the endRecord value for this OutputInfo.
     * 
     * @return endRecord
     */
    public java.lang.Integer getEndRecord() {
        return endRecord;
    }


    /**
     * Sets the endRecord value for this OutputInfo.
     * 
     * @param endRecord
     */
    public void setEndRecord(java.lang.Integer endRecord) {
        this.endRecord = endRecord;
    }


    /**
     * Gets the totalRecords value for this OutputInfo.
     * 
     * @return totalRecords
     */
    public java.lang.Integer getTotalRecords() {
        return totalRecords;
    }


    /**
     * Sets the totalRecords value for this OutputInfo.
     * 
     * @param totalRecords
     */
    public void setTotalRecords(java.lang.Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OutputInfo)) return false;
        OutputInfo other = (OutputInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.affectedRows==null && other.getAffectedRows()==null) || 
             (this.affectedRows!=null &&
              this.affectedRows.equals(other.getAffectedRows()))) &&
            ((this.startRecord==null && other.getStartRecord()==null) || 
             (this.startRecord!=null &&
              this.startRecord.equals(other.getStartRecord()))) &&
            ((this.endRecord==null && other.getEndRecord()==null) || 
             (this.endRecord!=null &&
              this.endRecord.equals(other.getEndRecord()))) &&
            ((this.totalRecords==null && other.getTotalRecords()==null) || 
             (this.totalRecords!=null &&
              this.totalRecords.equals(other.getTotalRecords())));
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
        if (getAffectedRows() != null) {
            _hashCode += getAffectedRows().hashCode();
        }
        if (getStartRecord() != null) {
            _hashCode += getStartRecord().hashCode();
        }
        if (getEndRecord() != null) {
            _hashCode += getEndRecord().hashCode();
        }
        if (getTotalRecords() != null) {
            _hashCode += getTotalRecords().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OutputInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "OutputInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("affectedRows");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "affectedRows"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("totalRecords");
        elemField.setXmlName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "totalRecords"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
