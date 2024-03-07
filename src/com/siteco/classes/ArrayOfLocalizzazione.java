package com.siteco.classes;

/**
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company: Siteco Informatica s.r.l.</p>
 *
 * @author Fabio Adani, Ivan Morotti, Maurizio Musarella
 * @version 1.0
 */
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class ArrayOfLocalizzazione {
    private com.siteco.classes.Localizzazione[] localizzazioni;

    public ArrayOfLocalizzazione() {
    }

    public ArrayOfLocalizzazione(com.siteco.classes.Localizzazione[] loc) {
        this.localizzazioni = loc;
    }

    public com.siteco.classes.Localizzazione[] getLocalizzazioni() {
       return localizzazioni;
    }

    public void setLocalizzazioni(com.siteco.classes.Localizzazione[] l) {
        this.localizzazioni = l;
    }

    public com.siteco.classes.Localizzazione getLocalizzazioni(int i) {
        return this.localizzazioni[i];
    }

    public void setLocalizzazioni(int i, com.siteco.classes.Localizzazione u) {
        this.localizzazioni[i] = u;
    }
}
