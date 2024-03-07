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

public class ArrayOfArrayOfString {
    private ArrayOfString[] objs;

    public ArrayOfArrayOfString() {
    }

    public ArrayOfArrayOfString(ArrayOfString[] objs) {
        this.objs = objs;
    }
    
    @XmlElement(namespace="http://www.sitecoinf.it/records")
    @XmlElementWrapper(name = "objs") 
    public ArrayOfString[] getObjs() {
       return this.objs;
    }

    public void setObjs(ArrayOfString[] objs) {
        this.objs = objs;
    }

    public ArrayOfString getObjs(int i) {
        return this.objs[i];
    }

    public void setObjs(int i, ArrayOfString obj) {
        this.objs[i] = obj;
    }
}
