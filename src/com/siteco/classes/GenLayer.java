package com.siteco.classes;

/**
 *
 * <p>Classe che identifica un layer generico della mappa.</p>
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
public class GenLayer {
    private String mtag = "mtag";
    private String name = "nome";
    private String symbol = "simbolo";
    private String type = "tipo";
    private double minscale = 0.0;
    private double maxscale = 0.0;
    private Simbologia simbologia = null;
    private boolean visible = true;

    /**
     * Restituisce il nome del layer.
     * @return String il nome del layer.
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public String getName() {
        return name;
    }

    /**
     * Setta il nome del layer.
     * @param name String il nome del layer.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Restituisce la scala minima di visualizzazione del layer.
     * @return double scala minima di visualizzazione del layer.
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public double getMinScale() {
        return minscale;
    }

    /**
     * Setta la scala minima di visualizzazione.
     * @param sc double scala minima di visualizzazione.
     */
    public void setMinScale(double sc) {
        this.minscale = sc;
    }

    /**
     * Restituisce la scala massima di visualizzazione del layer.
     * @return double scala massima di visualizzazione del layer.
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public double getMaxScale() {
        return maxscale;
    }

    /**
     * Setta la scala massima di visualizzazione.
     * @param sc double scala massima di visualizzazione.
     */
    public void setMaxScale(double sc) {
        this.maxscale = sc;
    }

    /**
     * Restituisce la simbologia. Il campo � valorizzato quando il map server
     * � ArcIms e si accede a un servizio basato su Arcmap Image Service.
     * @return {@link Simbologia} associata al layer.
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public Simbologia getSimbologia() {
        return simbologia;
    }

    /**
     * Setta la simbologia.
     * @param simb {@link ArrayOfSimbologia}.
     */
    public void setSimbologia(Simbologia simb) {
        this.simbologia = simb;
    }

    /**
     * Restituisce il tag associato al layer. Generalmente � un identificativo
     * numerico.
     * @return String Il tag associato al layer.
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public String getMtag() {
          return mtag;
      }

      /**
       * Setta il tag del layer.
       * @param tag String Il tag del layer da settare.
       */
      public void setMtag(String t) {
          this.mtag = t;
      }


    /**
     * Restituisce il simbolo associato al layer.
     * @return String il simbolo associato al layer.
     */
      @XmlElement(namespace="http://www.sitecoinf.it/values")
    public String getSymbol() {
        return symbol;
    }

    /**
     * Setta il simbolo associato al layer.
     * @param symbol String Il simbolo da associare al layer.
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Restiruisce il tipo del layer.
     * @return int Il tipo del layer: 1=puntuale; 2=lineare; 3= poligonale; 4= raster; 0= non inizializzato; -1= valore errato.
     */
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public String getType() {
        return type;
    }

    /**
     * Setta il tipo del layer: 1=puntuale; 2=lineare; 3= poligonale; 4= raster; -1 se inserito un valore errato.
     * @param type int Il tipo del layer: 1=puntuale; 2=lineare; 3= poligonale; 4= raster; -1 se inserito un valore errato.
     */
    public void setType(String type) {
        //if (type < 1 || type > 4) type = -1;
        //else this.type = type;
        this.type = type;
    }

    
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    /**
     * Verifica se il layer � visibile o meno.
     * @return boolean true se il layer � visibile, false altrimenti.
     */
    public boolean getVisible() {
        return visible;
    }
    /**
     * Setta la visibilit� del layer.
     * @param boolean true per rendere il layer visibile, false altrimenti.
     */
    public void setVisible(boolean isVisible) {
        visible = isVisible;
    }

    
}
