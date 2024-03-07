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
public class ArrayOfPercorso {

    private com.siteco.classes.Percorso[] percorsi;

    public ArrayOfPercorso() {
    }

    public ArrayOfPercorso(com.siteco.classes.Percorso[] percorsi) {
        this.percorsi = percorsi;
    }

    public com.siteco.classes.Percorso[] getPercorsi() {
       return percorsi;
    }

    public void setPercorsi(com.siteco.classes.Percorso[] percorsi) {
        this.percorsi = percorsi;
    }

    public com.siteco.classes.Percorso getPercorsi(int i) {
        return this.percorsi[i];
    }

    public void setPercorsi(int i, com.siteco.classes.Percorso percorso) {
        this.percorsi[i] = percorso;
    }
}
