package com.siteco.classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ArrayOfNormProvinciaRecord {
    private NormProvinciaRecord[] records;

    public ArrayOfNormProvinciaRecord() {
    }

    public ArrayOfNormProvinciaRecord(NormProvinciaRecord[] rs) {
        this.records = rs;
    }
    
    @XmlElement(namespace="http://www.sitecoinf.it/records")
    @XmlElementWrapper(name = "records") 
    public NormProvinciaRecord[] getRecords() {
        return this.records;
    }

    public void setRecords(NormProvinciaRecord[] rs) {
        this.records = rs;
    }

    public NormProvinciaRecord getRecords(int i) {
       return this.records[i];
    }

    public void setRecords(int i, NormProvinciaRecord r) {
        this.records[i] = r;
    }
}
