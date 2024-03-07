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
public class ArrayOfNormIndirizzo2Record {
    private NormIndirizzo2Record[] records;

    public ArrayOfNormIndirizzo2Record() {
    }

    public ArrayOfNormIndirizzo2Record(NormIndirizzo2Record[] rs) {
        this.records = rs;
    }
    
    @XmlElement(namespace="http://www.sitecoinf.it/records")
    @XmlElementWrapper(name = "records") 
    public NormIndirizzo2Record[] getRecords() {
        return this.records;
    }

    public void setRecords(NormIndirizzo2Record[] rs) {
        this.records = rs;
    }

    public NormIndirizzo2Record getRecords(int i) {
       return this.records[i];
    }

    public void setRecords(int i, NormIndirizzo2Record r) {
        this.records[i] = r;
    }
}
