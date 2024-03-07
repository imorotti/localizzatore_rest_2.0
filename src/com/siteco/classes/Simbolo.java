package com.siteco.classes;

/**
 * <p>Classe che identifica un simbolo associato ad un {@link GenLayer}.</p>
 *
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company: Siteco Informatica s.r.l.</p>
 *
 * @author Fabio Adani, Ivan Morotti, Maurizio Musarella
 * @version 1.0
 */
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class Simbolo {
    private String descrizione = "";
    private String urlSymbol = "";

    /**
     * Restituisce la descrizione associata al simbolo.
     * @return String la descrizione associata al simbolo.
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * Setta la descrizione associata al simbolo.
     * @param descrizione String la descrizione associata al simbolo.
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }


    /**
     * Restituisce l'url dell'immagine del simbolo.
     * @return String l'url dell'immagine del simbolo.
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public String getUrlSymbol() {
        return urlSymbol;
    }

    /**
     * Setta l'url dell'immagine del simbolo.
     * @param urlSymbol String l'url dell'immagine del simbolo.
     */
    public void setUrlSymbol(String urlSymbol) {
        this.urlSymbol = urlSymbol;
    }

}
