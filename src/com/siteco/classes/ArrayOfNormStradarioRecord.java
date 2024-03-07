package com.siteco.classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class ArrayOfNormStradarioRecord {
    private NormStradarioRecord[] records;

    public ArrayOfNormStradarioRecord() {
    }

    public ArrayOfNormStradarioRecord(NormStradarioRecord[] rs) {
        this.records = rs;
    }
    
    @XmlElement(namespace="http://www.sitecoinf.it/records")
    @XmlElementWrapper(name = "records") 
    public NormStradarioRecord[] getRecords() {
        return this.records;
    }

    public void setRecords(NormStradarioRecord[] rs) {
        this.records = rs;
    }

    public NormStradarioRecord getRecords(int i) {
       return this.records[i];
    }

    public void setRecords(int i, NormStradarioRecord r) {
        this.records[i] = r;
    }
}
