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

public class ArrayOfInt {
    private int[] objs;

    public ArrayOfInt() {
    }

    public ArrayOfInt(int[] objs) {
        this.objs = objs;
    }
    
    @XmlElement(namespace="http://www.sitecoinf.it/records")
    @XmlElementWrapper(name = "objs") 
    public int[] getObjs() {
       return this.objs;
    }

    public void setObjs(int[] objs) {
        this.objs = objs;
    }

    public int getObjs(int i) {
        return this.objs[i];
    }

    public void setObjs(int i, int obj) {
        this.objs[i] = obj;
    }
}
