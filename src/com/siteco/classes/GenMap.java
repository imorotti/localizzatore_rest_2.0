package com.siteco.classes;

/**
 *
 * <p>Classe che identifica una mappa generica con attributi indipendenti dal map server.</p>
 *
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company: Siteco Informatica s.r.l.</p>
 *
 * @author Fabio Adani, Ivan Morotti, Maurizio Musarella
 * @version 1.0
 */
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class GenMap{
    private int mapServerType = -1;
    private String connString = null;
    private String service = null;
    private String IpPubblico = "213.209.218.214";
    private String DirVirtualeLegenda = "http://192.168.7.101:8081/SitecoWS3/img/";
    private String PathFisicoDirVirtuale = "U:/Programmi/GeoIn/Demo/map";
    private int xLeg = -1;
    private int yLeg = -1;
    private GenEnvelope originalEnvelope;
    public boolean queryDone;




        /**
         * Setta il tipo di map server a cui la mappa � associata.
         * @param mapServerType int
         */
        public void setMapServerType (int mapServerType) {
                this.mapServerType = mapServerType;
        }
        /**
         * Setta l'ip da dove andare a recuperare la mappa (serve nel caso il map server sia Geoin).
         * @param string IP o nomemacchina pubblica.
         */
        public void setIpPubblico (String IP) {
                this.IpPubblico = IP;
        }

        /**
         * Setta l'Url da dove recuperare le eventuali immagini generate dal map server.
         * @param dv String l'Url da dove recuperare le eventuali immagini generate dal map server.
         */
        public void  setDirVirtualeLegenda (String dv) {
            DirVirtualeLegenda = dv;
        }

        /**
         * Setta il percorso fisico dove verranno salvate le eventuali immagini generate dal map server.
         * @param Pt String  Il percorso fisico dove verranno salvate le eventuali immagini generate dal map server.
         */
        public void setPathFisicoDirVirtuale (String Pt) {
                this.PathFisicoDirVirtuale = Pt;
        }
          /**
         * Setta la stringa di connessione al map server.
         * @param connString String Stringa di connessione al map server.
         */
        public void setConnString (String connString) {
                this.connString = connString;
        }

        /**
         * Setta l'eventuale nome del servizio associato alla mappa.
         * @param service String L'eventuale nome del servizio associato alla mappa.
         */
        public void setService (String service) {
                this.service = service;
        }

         /**
         * Restiruisce il tipo di map server associato alla mappa.
         * @return int Il tipo di map server associato alla mappa:  1=ArcIMS; 2=GeoIn; 3=Abaco; 4=WMS; 5=Map Server.
         */
        public int getMapServerType () {
                return mapServerType;
        }

        /**
         * Restiruisce il l'IP del server delle mappe GEOIN.
         * @return String l'IP del server delle mappe GEOIN.
         */

        public String  getIpPubblico () {
                return IpPubblico;
       }

       /**
        * Restituisce l'Url da dove recuperare le eventuali immagini generate dal map server.
        * @return String Url da dove recuperare le eventuali immagini generate dal map server.
        */
       public String  getDirVirtualeLegenda () {
               return DirVirtualeLegenda;
      }

      /**
       * Restituisce il percorso fisico dove verranno salvate le eventuali immagini generate dal map server.
       * @return String Il percorso fisico dove verranno salvate le eventuali immagini generate dal map server.
       */
      public String  getPathFisicoDirVirtuale () {
               return PathFisicoDirVirtuale;
      }

        /**
         * Restiruisce la stringa di connessione alla mappa.
         * @return String La stringa di connessione alla mappa.
         */
        public String getConnString () {
                return connString;
        }

        /**
         * Restiruisce il nome del servizio associato alla mappa.
         * @return String Il nome del servizio associato alla mappa.
         */
        public String getService () {
                return service;
        }

        /**
         * @deprecated
         * @return int La larghezza dell'immagine della legenda.
         */
        public int getxLeg() {
            return xLeg;
        }

        /**
         * @deprecated
         * @param x int Setta la larghezza dell'immagine della legenda.
         */
        public void setxLeg(int x) {
            xLeg = x;
        }

        /**
         * @deprecated
         * @return int L'altezza dell'immagine della legenda.
         */

        public int getyLeg() {
            return yLeg;
        }

        /**
         * Setta l'altezza dell'immagine della legenda.
         * @param y int
         */
        public void setyLeg(int y) {
            yLeg = y;
        }

        /**
         * Restituisce l'envelope iniziale della mappa.
         * @return {@link GenEnvelope} iniziale della mappa.
         */
        public GenEnvelope getOriginalEnvelope() {
            return originalEnvelope;
        }

        /**
         * Setta l'envelope iniziale della mappa.
         * @param origEnv {@link GenEnvelope} GenEnvelope iniziale della mappa.
         */
        public void setOriginalEnvelope(GenEnvelope origEnv) {
            this.originalEnvelope = origEnv;
        }
}
