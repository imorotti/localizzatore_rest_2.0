package com.siteco.classes;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlRootElement

public class ArrayOfNormIndirizzoRecord {
    private NormIndirizzoRecord[] records;

    public ArrayOfNormIndirizzoRecord() {
    }

    public ArrayOfNormIndirizzoRecord(NormIndirizzoRecord[] rs) {
        this.records = rs;
    }
    
    @XmlElement(namespace="http://www.sitecoinf.it/records")
    @XmlElementWrapper(name = "records") 
    public NormIndirizzoRecord[] getRecords() {
        return this.records;
    }

    public void setRecords(NormIndirizzoRecord[] rs) {
        this.records = rs;
    }
    
    public NormIndirizzoRecord getRecords(int i) {
       return this.records[i];
    }

    public void setRecords(int i, NormIndirizzoRecord r) {
        this.records[i] = r;
    }
}
