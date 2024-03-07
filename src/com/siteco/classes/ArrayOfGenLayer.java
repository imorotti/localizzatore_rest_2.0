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
public class ArrayOfGenLayer {
    private com.siteco.classes.GenLayer[] gl;

    public ArrayOfGenLayer() {
    }

    public ArrayOfGenLayer(com.siteco.classes.GenLayer[] layers) {
        this.gl = layers;
    }
    
    @XmlElement(namespace="http://www.sitecoinf.it/records")
    @XmlElementWrapper(name = "gl") 
    public com.siteco.classes.GenLayer[] getGl() {
       return gl;
    }

    public void setGl(com.siteco.classes.GenLayer[] l) {
        this.gl = l;
    }

    public com.siteco.classes.GenLayer getGl(int i) {
        return this.gl[i];
    }

    public void setGl(int i, com.siteco.classes.GenLayer u) {
        this.gl[i] = u;
    }
}
