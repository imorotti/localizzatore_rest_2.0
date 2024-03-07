package com.siteco.classes;

/**
 *
 * <p>Classe che memorizza gli Url da cui recuperare le immagini della mappa generate.
 * Viene richiamato dal metodo refreshMap della classe {@link SiteoWS}.</p>
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

public class MapURLs {
    private String urlMap, urlLegend, urlOverview = null;
    private String errore = "ok";
    
    
    /**
     * Ritorna l'URL dell'immagine della mappa.
     * @return String l'URL dell'immagine della mappa.
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public String getUrlMap() {
       return urlMap;
    }
    /**
     * Setta l'URL dell'immagine della mappa.
     * @param urlMap String
     */
    public void setUrlMap(String urlMap) {
        this.urlMap = urlMap;
    }
    
    /**
     * Ritorna l'URL dell'immagine della legenda.
     * @return String l'URL dell'immagine della legenda.
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public String getUrlLegend() {
       return urlLegend;
   }
    /**
     * Setta l'URL dell'immagine della legenda.
     * @param urlLegend String URL dell'immagine della legenda.
     */
    public void setUrlLegend(String urlLegend) {
        this.urlLegend = urlLegend;
    }
    
    /**
     * Ritorna l'URL dell'immagine di overview.
     * @return String l'URL dell'immagine di overview.
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public String getUrlOverview() {
       return urlOverview;
   }
    /**
     * Setta l'URL dell'immagine di overview.
     * @param urlOverview String URL dell'immagine di overview.
     */
    public void setURLOverview(String urlOverview) {
        this.urlOverview = urlOverview;
    }

    

   


  

   /**
     * Ritorna l'eventuale errore associato alla mappa, "ok" altrimenti.
     * @return String Lo stato della mappa; se non si verificano errori
     * durante l'elaborazione ritorna "ok"
     */
    public String getErrore() {
       return errore;
   }


   /**
     * Setta l'eventuale errore associato alla mappa, "ok" altrimenti.
     * @return String L'eventuale errore associato alla mappa, "ok" altrimenti.
     */
    public void setErrore(String errore) {
        this.errore = errore;
   }
}
