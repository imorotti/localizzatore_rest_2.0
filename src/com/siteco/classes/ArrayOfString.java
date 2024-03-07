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

public class ArrayOfString {
    private String[] objs;

    public ArrayOfString() {
    }

    public ArrayOfString(String[] objs) {
        this.objs = objs;
    }
    
    @XmlElement(namespace="http://www.sitecoinf.it/records")
    @XmlElementWrapper(name = "objs") 
    public String[] getObjs() {
       return this.objs;
    }

    public void setObjs(String[] objs) {
        this.objs = objs;
    }

    public String getObjs(int i) {
        return this.objs[i];
    }

    public void setObjs(int i, String obj) {
        this.objs[i] = obj;
    }
}
