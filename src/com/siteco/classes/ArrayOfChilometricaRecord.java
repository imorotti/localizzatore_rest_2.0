/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siteco.classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class ArrayOfChilometricaRecord {
    private ChilometricaRecord[] records;

    public ArrayOfChilometricaRecord() {
    }

    public ArrayOfChilometricaRecord(ChilometricaRecord[] rs) {
        this.records = rs;
    }
    
    @XmlElement(namespace="http://www.sitecoinf.it/records")
    @XmlElementWrapper(name = "records") 
    public ChilometricaRecord[] getRecords() {
        return this.records;
    }

    public void setRecords(ChilometricaRecord[] rs) {
        this.records = rs;
    }
    
    public ChilometricaRecord getRecords(int i) {
       return this.records[i];
    }

    public void setRecords(int i, ChilometricaRecord r) {
        this.records[i] = r;
    }
}