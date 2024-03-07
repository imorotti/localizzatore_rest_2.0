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

public class ArrayOfSimbolo {

    private com.siteco.classes.Simbolo[] sim;

    public ArrayOfSimbolo() {
    }

    public ArrayOfSimbolo(com.siteco.classes.Simbolo[] simboli) {
        this.sim = simboli;
    }
    
    @XmlElement(namespace="http://www.sitecoinf.it/records")
    @XmlElementWrapper(name = "sim") 
    public com.siteco.classes.Simbolo[] getSim() {
       return sim;
    }

    public void setSim(com.siteco.classes.Simbolo[] l) {
        this.sim = l;
    }

    public com.siteco.classes.Simbolo getSim(int i) {
        return this.sim[i];
    }

    public void setSim(int i, com.siteco.classes.Simbolo u) {
        this.sim[i] = u;
    }
}
