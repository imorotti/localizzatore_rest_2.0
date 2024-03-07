package com.siteco.classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ArrayOfNormComune2Record {
    private NormComune2Record[] records;

    public ArrayOfNormComune2Record() {
    }

    public ArrayOfNormComune2Record(NormComune2Record[] rs) {
        this.records = rs;
    }
    
    @XmlElement(namespace="http://www.sitecoinf.it/records")
    @XmlElementWrapper(name = "records") 
    public NormComune2Record[] getRecords() {
        return this.records;
    }

    public void setRecords(NormComune2Record[] rs) {
        this.records = rs;
    }

    public NormComune2Record getRecords(int i) {
       return this.records[i];
    }

    public void setRecords(int i, NormComune2Record r) {
        this.records[i] = r;
    }
}
