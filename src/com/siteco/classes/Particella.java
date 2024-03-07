package com.siteco.classes;

/**
 * <p>Classe che identifica un insieme di oggetti di un {@link GenLayer}
 * memorizzati in un {@link ArrayOfInt}. Il layer � caratterrizzato dal nome e/o
 * dal tag.</p>
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

public class Particella {
    private String comune = null;
    private String foglio = null;
    private String mappale = null;
    
    /**
     * Ritorna l'identificativo del comune.
     * @return String l'identificativo del comune.
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public String getComune() {
        return comune;
    }
    /**
     * Setta l'identificativo del comune.
     * @param comune String identificativo del comune.
     */
    public void setComune(String comune) {
        this.comune = comune;
    }
    
    /**
     * Ritorna l'identificativo del foglio.
     * @return String l'identificativo del foglio.
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public String getFoglio() {
        return foglio;
    }
    /**
     * Setta l'identificativo del foglio.
     * @param foglio String identificativo del foglio.
     */
    public void setFoglio(String foglio) {
        this.foglio = foglio;
    }
    
    /**
     * Ritorna l'identificativo del mappale.
     * @return String l'identificativo del mappale.
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public String getMappale() {
        return mappale;
    }
    /**
     * Setta l'identificativo del mappale.
     * @param mappale String.
     */
    public void setMappale(String mappale) {
        this.mappale = mappale;
    }   
}
