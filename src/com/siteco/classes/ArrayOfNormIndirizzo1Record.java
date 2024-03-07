package com.siteco.classes;
/**
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company: Siteco Informatica s.r.l.</p>
 *
 * @author Fabio Adani, Ivan Morotti, Maurizio Musarella
 * @version 1.0
 */

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ArrayOfNormIndirizzo1Record {
    private NormIndirizzo1Record[] records;

    public ArrayOfNormIndirizzo1Record() {
    }

    public ArrayOfNormIndirizzo1Record(NormIndirizzo1Record[] rs) {
        this.records = rs;
    }
    
    @XmlElement(namespace="http://www.sitecoinf.it/records")
    @XmlElementWrapper(name = "records") 
    public NormIndirizzo1Record[] getRecords() {
        return this.records;
    }

    public void setRecords(NormIndirizzo1Record[] rs) {
        this.records = rs;
    }

    public NormIndirizzo1Record getRecords(int i) {
       return this.records[i];
    }

    public void setRecords(int i, NormIndirizzo1Record r) {
        this.records[i] = r;
    }
}
