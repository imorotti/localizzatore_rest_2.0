package com.siteco.classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement

public class ArrayOfNormIncrocioRecord {
    private NormIncrocioRecord[] records;

    public ArrayOfNormIncrocioRecord() {
    }

    public ArrayOfNormIncrocioRecord(NormIncrocioRecord[] rs) {
        this.records = rs;
    }
    
    @XmlElement(namespace="http://www.sitecoinf.it/records")
    @XmlElementWrapper(name = "records") 
    public NormIncrocioRecord[] getRecords() {
        return this.records;
    }

    public void setRecords(NormIncrocioRecord[] rs) {
        this.records = rs;
    }

    public NormIncrocioRecord getRecords(int i) {
       return this.records[i];
    }

    public void setRecords(int i, NormIncrocioRecord r) {
        this.records[i] = r;
    }
}
