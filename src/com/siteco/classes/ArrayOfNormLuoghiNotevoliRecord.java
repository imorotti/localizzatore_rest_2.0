package com.siteco.classes;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlRootElement

public class ArrayOfNormLuoghiNotevoliRecord {
    private NormLuoghiNotevoliRecord[] records;

    public ArrayOfNormLuoghiNotevoliRecord() {
    }

    public ArrayOfNormLuoghiNotevoliRecord(NormLuoghiNotevoliRecord[] rs) {
        this.records = rs;
    }
    
    @XmlElement(namespace="http://www.sitecoinf.it/records")
    @XmlElementWrapper(name = "records") 
    public NormLuoghiNotevoliRecord[] getRecords() {
        return this.records;
    }

    public void setRecords(NormLuoghiNotevoliRecord[] rs) {
        this.records = rs;
    }
    
    public NormLuoghiNotevoliRecord getRecords(int i) {
       return this.records[i];
    }

    public void setRecords(int i, NormLuoghiNotevoliRecord r) {
        this.records[i] = r;
    }
}
