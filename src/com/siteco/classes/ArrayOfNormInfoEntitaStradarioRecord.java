package com.siteco.classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ArrayOfNormInfoEntitaStradarioRecord {
    private NormInfoEntitaStradarioRecord[] records;

    public ArrayOfNormInfoEntitaStradarioRecord() {
    }

    public ArrayOfNormInfoEntitaStradarioRecord(NormInfoEntitaStradarioRecord[] rs) {
        this.records = rs;
    }
    
    @XmlElement(namespace="http://www.sitecoinf.it/records")
    @XmlElementWrapper(name = "records") 
    public NormInfoEntitaStradarioRecord[] getRecords() {
        return this.records;
    }

    public void setRecords(NormInfoEntitaStradarioRecord[] rs) {
        this.records = rs;
    }

    public NormInfoEntitaStradarioRecord getRecords(int i) {
       return this.records[i];
    }

    public void setRecords(int i, NormInfoEntitaStradarioRecord r) {
        this.records[i] = r;
    }
}
