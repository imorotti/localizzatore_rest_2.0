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

public class ArrayOfObjsInLayer3 {
    private com.siteco.classes.ObjsInLayer3[] oil;

    public ArrayOfObjsInLayer3() {
    }

    public ArrayOfObjsInLayer3(com.siteco.classes.ObjsInLayer3[] oil) {
        this.oil = oil;
    }
    
    @XmlElement(namespace="http://www.sitecoinf.it/records")
    @XmlElementWrapper(name = "oil") 
    public com.siteco.classes.ObjsInLayer3[] getOil() {
       return this.oil;
    }

    public void setOil(com.siteco.classes.ObjsInLayer3[] oil) {
        this.oil = oil;
    }

    public com.siteco.classes.ObjsInLayer3 getOil(int i) {
        return this.oil[i];
    }

    public void setOil(int i, com.siteco.classes.ObjsInLayer3 u) {
        this.oil[i] = u;
    }
}
