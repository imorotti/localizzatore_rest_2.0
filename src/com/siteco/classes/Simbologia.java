package com.siteco.classes;

/**
 * <p>Classe che identifica un insieme di {@link Simbolo} associati ad un {@link GenLayer}
 * nel caso sia presente una particolare tematizzazione. Questa classe viene
 * valorizzata nel caso si utilizzi come map server ArcIms e la tipologia
 * del map server pubblicato sia ArcMap Image Service.</p>
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

public class Simbologia {
    private String heading = "";
    private ArrayOfSimbolo simboli = null;
    private String parentLayerId = null;
    private boolean isGroupLayer = false;

    /**
     * Verifica se il layer � un group layer.
     * @return boolean true se il layer � un group layer, false altrimenti.
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public boolean getIsGroupLayer() {
        return isGroupLayer;
    }
    /**
     * Setta se il layer � un group layer.
     * @param isGroupLayer boolean true se il layer � un group layer, false altrimenti.
     */
    public void setIsGroupLayer(boolean isGroupLayer) {
        this.isGroupLayer = isGroupLayer;
    }

    /**
     * Restituisce l'eventuale id del layer padre.
     * @return String l'eventuale id del layer padre.
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public String getParentLayerId() {
        return parentLayerId;
    }
    /**
     * Setta l'eventuale id del layer padre.
     * @param parentLayerId String l'eventuale id del layer padre.
     */
    public void setParentLayerId(String parentLayerId) {
        this.parentLayerId = parentLayerId;
    }

    /**
     * Restituisce il valore dell'heading della toc.
     * @return String il valore dell'heading della toc.
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public String getHeading() {
        return heading;
    }
    /**
     * Setta il nome dell'heading della toc.
     * @param heading String il nome dell'heading della toc.
     */
    public void setHeading(String heading) {
        this.heading = heading;
    }

    /**
     * Restituisce l'array dei simboli.
     * @return {@link ArrayOfSimbolo} l'array dei simboli.
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public ArrayOfSimbolo getSimboli() {
        return simboli;
    }

    /**
     * Setta l'array dei simboli.
     * @param simboli {@link ArrayOfSimbolo} l'array dei simboli.
     */
    public void setSimboli(ArrayOfSimbolo simboli) {
        this.simboli = simboli;
    }
}
