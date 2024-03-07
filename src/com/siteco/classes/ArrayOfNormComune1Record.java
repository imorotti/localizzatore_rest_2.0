package com.siteco.classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ArrayOfNormComune1Record {
    private NormComune1Record[] records;

    public ArrayOfNormComune1Record() {
    }

    public ArrayOfNormComune1Record(NormComune1Record[] rs) {
        this.records = rs;
    }
    
    @XmlElement(namespace="http://www.sitecoinf.it/records")
    @XmlElementWrapper(name = "records") 
    public NormComune1Record[] getRecords() {
        return this.records;
    }

    public void setRecords(NormComune1Record[] rs) {
        this.records = rs;
    }

    public NormComune1Record getRecords(int i) {
       return this.records[i];
    }

    public void setRecords(int i, NormComune1Record r) {
        this.records[i] = r;
    }
}
