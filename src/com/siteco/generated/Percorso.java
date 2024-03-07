/**
 * Percorso.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package com.siteco.generated;

public class Percorso  implements java.io.Serializable {
    private java.lang.String denominazione;
    private java.lang.String nome;
    private double prg_Fin;
    private double prg_Ini;
    private java.lang.String road_Id;
    private java.lang.String roadg_Id;
    private java.lang.String sigla;

    public Percorso() {
    }

    public Percorso(
           java.lang.String denominazione,
           java.lang.String nome,
           double prg_Fin,
           double prg_Ini,
           java.lang.String road_Id,
           java.lang.String roadg_Id,
           java.lang.String sigla) {
           this.denominazione = denominazione;
           this.nome = nome;
           this.prg_Fin = prg_Fin;
           this.prg_Ini = prg_Ini;
           this.road_Id = road_Id;
           this.roadg_Id = roadg_Id;
           this.sigla = sigla;
    }


    /**
     * Gets the denominazione value for this Percorso.
     * 
     * @return denominazione
     */
    public java.lang.String getDenominazione() {
        return denominazione;
    }


    /**
     * Sets the denominazione value for this Percorso.
     * 
     * @param denominazione
     */
    public void setDenominazione(java.lang.String denominazione) {
        this.denominazione = denominazione;
    }


    /**
     * Gets the nome value for this Percorso.
     * 
     * @return nome
     */
    public java.lang.String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this Percorso.
     * 
     * @param nome
     */
    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }


    /**
     * Gets the prg_Fin value for this Percorso.
     * 
     * @return prg_Fin
     */
    public double getPrg_Fin() {
        return prg_Fin;
    }


    /**
     * Sets the prg_Fin value for this Percorso.
     * 
     * @param prg_Fin
     */
    public void setPrg_Fin(double prg_Fin) {
        this.prg_Fin = prg_Fin;
    }


    /**
     * Gets the prg_Ini value for this Percorso.
     * 
     * @return prg_Ini
     */
    public double getPrg_Ini() {
        return prg_Ini;
    }


    /**
     * Sets the prg_Ini value for this Percorso.
     * 
     * @param prg_Ini
     */
    public void setPrg_Ini(double prg_Ini) {
        this.prg_Ini = prg_Ini;
    }


    /**
     * Gets the road_Id value for this Percorso.
     * 
     * @return road_Id
     */
    public java.lang.String getRoad_Id() {
        return road_Id;
    }


    /**
     * Sets the road_Id value for this Percorso.
     * 
     * @param road_Id
     */
    public void setRoad_Id(java.lang.String road_Id) {
        this.road_Id = road_Id;
    }


    /**
     * Gets the roadg_Id value for this Percorso.
     * 
     * @return roadg_Id
     */
    public java.lang.String getRoadg_Id() {
        return roadg_Id;
    }


    /**
     * Sets the roadg_Id value for this Percorso.
     * 
     * @param roadg_Id
     */
    public void setRoadg_Id(java.lang.String roadg_Id) {
        this.roadg_Id = roadg_Id;
    }


    /**
     * Gets the sigla value for this Percorso.
     * 
     * @return sigla
     */
    public java.lang.String getSigla() {
        return sigla;
    }


    /**
     * Sets the sigla value for this Percorso.
     * 
     * @param sigla
     */
    public void setSigla(java.lang.String sigla) {
        this.sigla = sigla;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Percorso)) return false;
        Percorso other = (Percorso) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.denominazione==null && other.getDenominazione()==null) || 
             (this.denominazione!=null &&
              this.denominazione.equals(other.getDenominazione()))) &&
            ((this.nome==null && other.getNome()==null) || 
             (this.nome!=null &&
              this.nome.equals(other.getNome()))) &&
            this.prg_Fin == other.getPrg_Fin() &&
            this.prg_Ini == other.getPrg_Ini() &&
            ((this.road_Id==null && other.getRoad_Id()==null) || 
             (this.road_Id!=null &&
              this.road_Id.equals(other.getRoad_Id()))) &&
            ((this.roadg_Id==null && other.getRoadg_Id()==null) || 
             (this.roadg_Id!=null &&
              this.roadg_Id.equals(other.getRoadg_Id()))) &&
            ((this.sigla==null && other.getSigla()==null) || 
             (this.sigla!=null &&
              this.sigla.equals(other.getSigla())));
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
        if (getDenominazione() != null) {
            _hashCode += getDenominazione().hashCode();
        }
        if (getNome() != null) {
            _hashCode += getNome().hashCode();
        }
        _hashCode += new Double(getPrg_Fin()).hashCode();
        _hashCode += new Double(getPrg_Ini()).hashCode();
        if (getRoad_Id() != null) {
            _hashCode += getRoad_Id().hashCode();
        }
        if (getRoadg_Id() != null) {
            _hashCode += getRoadg_Id().hashCode();
        }
        if (getSigla() != null) {
            _hashCode += getSigla().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Percorso.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://siteco.com", "Percorso"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("denominazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "denominazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nome");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "nome"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prg_Fin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "prg_Fin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prg_Ini");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "prg_Ini"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("road_Id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "road_Id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("roadg_Id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "roadg_Id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sigla");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siteco.com", "sigla"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
