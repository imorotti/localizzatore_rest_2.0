/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siteco;

/*import com.siteco.classes.ObjsInLayer2;
import com.siteco.classes.MapURLs;
import com.siteco.classes.ArrayOfNormIndirizzo1Record;
import com.siteco.classes.NormIndirizzo1Record;

import com.siteco.classes.NormIncrocioRecord;
import com.siteco.classes.ArrayOfSimbolo;
import com.siteco.classes.NormComune2Record;
import com.siteco.classes.ObjsInLayer3;
import com.siteco.classes.Coord;
import com.siteco.classes.ArrayOfNormProvinciaRecord;
import com.siteco.classes.GenEnvelope;
import com.siteco.classes.NormStradarioRecord;
import com.siteco.classes.Simbolo;
import com.siteco.classes.ArrayOfString;
import com.siteco.classes.Simbologia;
import com.siteco.classes.ArrayOfNormIndirizzo2Record;
import com.siteco.classes.ObjsInLayer;
import com.siteco.classes.ArrayOfArrayOfString;
import com.siteco.classes.NormIndirizzo2Record;
import com.siteco.classes.ArrayOfNormIndirizzoRecord;
import com.siteco.classes.PtPrjM;
import com.siteco.classes.NormIndirizzoRecord;
import com.siteco.classes.ArrayOfNormStradarioRecord;
import com.siteco.classes.Particella;
import com.siteco.classes.ArrayOfNormInfoEntitaStradarioRecord;
import com.siteco.classes.NormComune1Record;
import com.siteco.classes.ArrayOfNormComune1Record;
import com.siteco.classes.NormInfoEntitaStradarioRecord;
import com.siteco.classes.ArrayOfInt;
import com.siteco.classes.ArrayOfNormComune2Record;
import com.siteco.classes.NormProvinciaRecord;
import com.siteco.classes.GenLayer;
import com.siteco.classes.Progressiva;
import com.siteco.classes.ArrayOfNormIncrocioRecord;
import com.siteco.classes.ArrayOfNormLuoghiNotevoliRecord;*/
import com.siteco.classes.*;
import com.esri.arcgisws.*;
import com.esri.sde.sdk.client.*;
import com.siteco.JRs40DynSeg.*;
import com.siteco.classes.NormLuoghiNotevoliRecord;
import e_SOAPDispenser.Normalizzatore.*;
import java.io.*;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import javax.naming.InitialContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleResultSet;
import org.apache.log4j.Logger;
import javax.servlet.*;

import java.util.Set;
import java.util.HashSet;
import org.apache.log4j.xml.DOMConfigurator;

import org.json.*;

/**
 * REST Web Service
 *
 * @author ivan
 */
@Path("/")
public class Localizzatore_Rest extends Application{
    private static String versione = "RoadSit Web Service (Localizzatore Rest), versione 1.2, build 20141712";
    //private static String normAddress =  "/eSoapDispenser/eGeoCoding?serviceType=DBServices&serviceName=Normalizzatore";
    private static String normAddress =  "/eGeoCoding?serviceType=DBServices&serviceName=Normalizzatore";
    
    static private HashMap hm = new HashMap();
    static private HashMap conn_RoadLayer = new HashMap();
    static private HashMap conn_IdCol = new HashMap();
    static private HashMap conn_GeometryCol = new HashMap();
    
    static private DynSeg percorsiM = new DynSeg();
    
    static private Logger logger;
    //@Context
    //private UriInfo context;
    
    static {
        try {         
            // returns the Class object associated with this class
            Class cls = Class.forName("com.siteco.Localizzatore_Rest");
            // returns the ClassLoader object associated with this Class.
            ClassLoader cLoader = cls.getClassLoader();

            if (cLoader == null) {
                System.out.println("The default system class was used.");
            } else {
                String tempFolderPath = System.getProperty("jboss.server.temp.dir");
                if (tempFolderPath == null)
                    tempFolderPath = System.getProperty("java.io.tmpdir");
                // returns the class loader             
                String idConn = "percorsim";
                DynSeg DynS = new DynSeg();
                InputStream isShp = cLoader.getResourceAsStream("pc/percorsim.shp");
                InputStream isShx = cLoader.getResourceAsStream("pc/percorsim.shx");
                InputStream isDbf = cLoader.getResourceAsStream("pc/percorsim.dbf");
                
                java.net.URL url = cLoader.getResource("pc/percorsim.shp");
                byte[] buffer = new byte[isShp.available()];
                isShp.read(buffer);
                File targetFile = new File(tempFolderPath + "/percorsim.shp");
                OutputStream outStream = new FileOutputStream(targetFile);
                outStream.write(buffer);
                outStream.flush();
                outStream.close();
                isShp.close();
                
                url = cLoader.getResource("pc/percorsim.shx");
                buffer = new byte[isShx.available()];
                isShx.read(buffer);
                targetFile = new File(tempFolderPath + "/percorsim.shx");
                outStream = new FileOutputStream(targetFile);
                outStream.write(buffer);
                outStream.flush();
                outStream.close();
                isShx.close();
                
                url = cLoader.getResource("pc/percorsim.dbf");
                buffer = new byte[isDbf.available()];
                isDbf.read(buffer);
                targetFile = new File(tempFolderPath + "/percorsim.dbf");
                outStream = new FileOutputStream(targetFile);
                outStream.write(buffer);
                outStream.flush();
                outStream.close();
                isDbf.close();
         
                String connString = tempFolderPath + "/percorsim.shp";
                int res = DynS.DSSetShapefile(connString, "ID_ENTITA");
                if (res == 0) {
                    //idConn = this.makeID();
                    setConnection(idConn, DynS, "", "", "ID_ENTITA");
                } else {
                    idConn = "Errore nell'apertura del layer dei percorsi calibrati: res = " + res + "; " + connString;
                }    
            }         
            
        }
        catch (Exception e) {
            //scriviLog(e);
        }
    }

    /** Creates a new instance of SitecoWSResource */
    public Localizzatore_Rest() {
        
    }
   
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        // register resources
        classes.add(Localizzatore_Rest.class);
        return classes;
    }

    @Path("/getVersion")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
    public String getVersion()
    {
        return this.versione;
    }

    /**
     * Disegna un marker sulla mappa ed eventualmente effettua lo zoom sulle coordinate specificate.
     * @param xCoord double Coordinata x del marker.
     * @param yCoord double Coordinata y del marker.
     * @param pan boolean Se true effettua lo zoom sul marker.
     * @param symbol String Simbolo con cui rappresentare il marker.
     * @param testo String Testo da associare al Marker.
     * @param toll int Parametro in metri che definisce l'envelope su cui effettuare l'eventuale zoom.
     * @param idMap String Identificatore della connessione al map server.
     * @return N.B. L'oggetto {@link MapURLs} ritornato non contiene i riferimenti all'immagine della mappa aggiornata, ma
     * � mantenuto solo per compatibilit� con versioni precedenti del software. Richiamare il metodo {@link #refreshMap refreshMap} per
     * ottenere un oggetto {@link MapURLs} con i riferimenti all'immagine della mappa aggiornata.
     *
     */

    @Path("/drawMarker")
	@GET
	@Produces({ MediaType.APPLICATION_XML })

    public MapURLs drawMarker(@QueryParam("xCoord") double xCoord, 
                              @QueryParam("yCoord") double yCoord,
                              @QueryParam("pan") boolean pan,
                              @QueryParam("symbol") String symbol,
                              @QueryParam("testo") String testo,
                              @QueryParam("toll") int toll,
                              @QueryParam("idMap") String idMap) {
        scriviLog("Invocata drawMarker(" + xCoord + "," + yCoord + "," + pan + "," + symbol + "," + "testo" + "," + toll + "," + idMap + ")");
        MapURLs mu = new MapURLs();
        try {
            MapDescription mDesc = (MapDescription) this.readDB("MAPDESCRIPTION", idMap);
            //definisco il punto
            com.esri.arcgisws.PointN point = new com.esri.arcgisws.PointN();
            point.setX(xCoord);
            point.setY(yCoord);
            point.setSpatialReference(mDesc.getSpatialReference());
            //definisco il colore
            RgbColor color = new RgbColor();
            color.setRed((short) 255);
            color.setGreen((short) 255);
            color.setBlue((short) 0);

            //definisco il simbolo grafico
            com.esri.arcgisws.SimpleMarkerSymbol simpleMarkerSymbol =
                    new com.esri.arcgisws.SimpleMarkerSymbol();
            simpleMarkerSymbol.setSize(10);
            simpleMarkerSymbol.setColor(color);

            MarkerElement markerElement = new MarkerElement();
            markerElement.setPoint(point);
            markerElement.setSymbol(simpleMarkerSymbol);

            //definisco il testo
            com.esri.arcgisws.TextSymbol textSymbol = new com.esri.arcgisws.TextSymbol();
            textSymbol.setColor(color);
            textSymbol.setText(testo);
            TextElement textElement = new TextElement();
            textElement.setSymbol(textSymbol);
            textElement.setTextGeometry(point);

            GraphicElement[] ge = new GraphicElement[2];
            //aggiungo i graficiscmi creati
            ge[0] = markerElement;
            ge[1] = textElement;

            mDesc.setCustomGraphics(ge);
            this.updateDB(idMap, "MAPDESCRIPTION", mDesc);
            if (pan)
            {
                GenEnvelope genEnv = new GenEnvelope();
                genEnv.setMinX(xCoord - toll);
                genEnv.setMinY(yCoord - toll);
                genEnv.setMaxX(xCoord + toll);
                genEnv.setMaxY(yCoord + toll);
                this.zoomToEnvelope(xCoord - toll, yCoord - toll, xCoord + toll, yCoord + toll, idMap);
            }
            return mu;
        } catch (Exception exc) {
            scriviLog("drawMarker: errore!", exc);
            mu.setErrore(exc.getMessage());
            return mu;
        }
    }


    /**
     * Elimina il marker dalla mappa; se idMarker = "-1" verranno cancellati tutti i marker.
     * @param idMarker String Identificatore del marker.
     * @param idMap String Identificatore della connessione al map server.
     * @return N.B. L'oggetto {@link MapURLs} ritornato non contiene i riferimenti all'immagine della mappa aggiornata, ma
     * � mantenuto solo per compatibilit� con versioni precedenti del software. Richiamare il metodo {@link #refreshMap refreshMap} per
     * ottenere un oggetto {@link MapURLs} con i riferimenti all'immagine della mappa aggiornata.
     */

    @Path("/deleteMarker")
	@GET
	@Produces({ MediaType.APPLICATION_XML })
    public MapURLs deleteMarker(@QueryParam("idMarker") String idMarker,
                                @QueryParam("idMap") String idMap) {
        scriviLog("Invocata deleteMarker(" + idMarker + "," + idMap + ")");
        MapURLs mu = new MapURLs();
        try {
            MapDescription mDesc = (MapDescription) this.readDB("MAPDESCRIPTION", idMap);
            mDesc.setCustomGraphics(null);
            LayerDescription[] lDescs = mDesc.getLayerDescriptions();
            for (int i = 0; i < lDescs.length; i++) {
                lDescs[i].setSelectionFeatures(null);
            }
            mDesc.setCustomGraphics(null);
            this.updateDB(idMap, "MAPDESCRIPTION", mDesc);
            return mu;
        } catch (Exception e) {
            scriviLog("deleteMarker: errore!", e);
            mu.setErrore(e.getMessage());
            return mu;
        }
    }

    /**
     * Restituisce un {@link ArrayOfGenLayer} che descrive i layer disponibili nel servizio.
     * @param idMap String Identificatore della connessione al map server.
     * @return {@link ArrayOfGenLayer} che descrive i layer disponibili nel servizio.
     */
    @Path("/getMapLayersDefinitions")
	@GET
	@Produces(MediaType.APPLICATION_XML)
    public com.siteco.classes.ArrayOfGenLayer getMapLayersDefinitions(@QueryParam("idMap") String idMap) {
        //se il map server � ArcIMS
        GenLayer[] Ris = null;
        try {
            String mapName = this.readDB("MAPNAME", idMap).toString();
            MapServerBindingStub mapServer = new MapServerBindingStub(this.readDB("CONNSTRING", idMap).toString());
            MapDescription mDesc = (MapDescription) this.readDB("MAPDESCRIPTION", idMap);
            MapLayerInfo[] lInfos = mapServer.getServerInfo(mapName).getMapLayerInfos();
            LayerDescription[] lDescs = mDesc.getLayerDescriptions();
            HashMap symbols = this.salvaTocArcgisServer(idMap);
            Ris = new GenLayer[lInfos.length];
            for (int i = 0; i < lInfos.length; i++)
            {
                Ris[i] = new GenLayer();
                Ris[i].setMinScale(lInfos[i].getMinScale());
                Ris[i].setMaxScale(lInfos[i].getMaxScale());
                Ris[i].setMtag(Integer.toString(lInfos[i].getLayerID()));
                Ris[i].setName(lInfos[i].getName());
                Ris[i].setType(lInfos[i].getLayerType());
                for (int j = 0; j < lDescs.length; j++)
                {
                    Ris[i].setVisible(true);
                    Ris[i].setSimbologia(null);
                    if (lDescs[j].getLayerID() == lInfos[i].getLayerID())
                    {
                        Ris[i].setVisible(lDescs[j].isVisible());
                        Ris[i].setSimbologia((Simbologia) symbols.get(Ris[i].getMtag()));
                        break;
                    }
                }
            }
            GenLayer[] Ris2 = new GenLayer[Ris.length];
            for (int i = 0; i < Ris.length; i++) {
                Ris2[Ris.length - i - 1] = Ris[i];
            }
            return new com.siteco.classes.ArrayOfGenLayer(Ris2);
        }
        catch (Exception exc)
        {
            scriviLog(exc);
            return null;
        }
    }


    /**
     * Restituisce un {@link ArrayOfGenLayer} che descrive l'insieme di layer visibili.
     * @param idMap String Identificatore della connessione al map server.
     * @return {@link ArrayOfGenLayer} che descrive l'insieme di layer visibili.
     */
    @Path("/getMapLayersVisible")
	@GET
	@Produces(MediaType.APPLICATION_XML)
    public com.siteco.classes.ArrayOfGenLayer getMapLayersVisible(@QueryParam("idMap") String idMap) {
        //se il map server � ArcIMS
        GenLayer[] Ris = null;
         try {
             int visibleLayers = 0;
             String mapName = this.readDB("MAPNAME", idMap).toString();
             MapServerBindingStub mapServer = new MapServerBindingStub(this.readDB("CONNSTRING", idMap).toString());
             MapDescription mDesc = (MapDescription) this.readDB("MAPDESCRIPTION", idMap);

             MapLayerInfo[] lInfos = mapServer.getServerInfo(mapName).getMapLayerInfos();
             LayerDescription[] lDescs = mDesc.getLayerDescriptions();
             Ris = new GenLayer[lInfos.length];
             for (int i = 0; i < lDescs.length; i++)
             {
                 if (lDescs[i].isVisible())
                     visibleLayers++;
             }
             Ris = new GenLayer[visibleLayers];
             int cont = 0;
             for (int i = 0; i < lDescs.length; i++)
             {
                 if (lDescs[i].isVisible())
                 {
                     Ris[cont] = new GenLayer();
                     for (int k = 0; k < lInfos.length; k++)
                     {
                         if (lInfos[k].getLayerID() == lDescs[i].getLayerID())
                         {
                             Ris[cont].setMinScale(lInfos[i].getMinScale());
                             Ris[cont].setMaxScale(lInfos[i].getMaxScale());
                             Ris[cont].setMtag(Integer.toString(lInfos[i].getLayerID()));
                             Ris[cont].setName(lInfos[i].getName());
                             Ris[cont].setType(lInfos[i].getLayerType());
                             Ris[cont].setVisible(true);
                             cont++;
                         }
                     }
                 }
             }
             return new com.siteco.classes.ArrayOfGenLayer(Ris);
         }
         catch (Exception exc)
         {
             scriviLog(exc);
             return null;
         }

    }

    /**
     * Setta visibili i layers presenti nella lista indicata.
     * @param visibleLayers List<String> Insieme di layer visibili.
     * @param idMap String Identificatore della connessione al map server.
     * @return N.B. L'oggetto {@link MapURLs} ritornato non contiene i riferimenti all'immagine della mappa aggiornata, ma
     * � mantenuto solo per compatibilit� con versioni precedenti del software. Richiamare il metodo {@link #refreshMap refreshMap} per
     * ottenere un oggetto {@link MapURLs} con i riferimenti all'immagine della mappa aggiornata.
     */

    @Path("/setMapLayersVisible")
	@GET
	@Produces({ MediaType.APPLICATION_XML })
    public MapURLs setMapLayersVisible(@QueryParam("visibleLayers") List<String> visibleLayers,
                                       @QueryParam("idMap") String idMap) {
        MapURLs mu = new MapURLs();

        try {
            String mapName = this.readDB("MAPNAME", idMap).toString();
            MapServerBindingStub mapServer = new MapServerBindingStub(this.readDB("CONNSTRING", idMap).toString());
            MapDescription mDesc = (MapDescription) this.readDB("MAPDESCRIPTION", idMap);

            MapLayerInfo[] lInfos = mapServer.getServerInfo(mapName).getMapLayerInfos();
            LayerDescription[] lDescs = mDesc.getLayerDescriptions();
            Vector ids = new Vector();
            for (int i = 0; i < lInfos.length; i++)
            {
                for (int j = 0; j < visibleLayers.size(); j++)
                {
                    if (lInfos[i].getName().equalsIgnoreCase(visibleLayers.get(j)))
                    {
                        ids.add(lInfos[i].getLayerID());
                        break;
                    }
                }
            }
            for (int i = 0; i < lDescs.length; i++)
            {
                lDescs[i].setVisible(false);
                if (ids.contains(lDescs[i].getLayerID()))
                {
                    lDescs[i].setVisible(true);
                }
            }
            this.updateDB(idMap, "MAPDESCRIPTION", mDesc);
            return mu;
        }
        catch (Exception exc)
        {
            scriviLog("setMapLayersVisible: errore!", exc);
            mu.setErrore(exc.getMessage());
            return mu;
        }
    }


    /**
     * Setta il layer indentificato da TagLayer visibile/invisibile
     *
     * @param nomeLayer String.
     * @param visible boolean.
     * @param idMap String Identificatore della connessione al map server.
     * @return N.B. L'oggetto {@link MapURLs} ritornato non contiene i riferimenti all'immagine della mappa aggiornata, ma
     * � mantenuto solo per compatibilit� con versioni precedenti del software. Richiamare il metodo {@link #refreshMap refreshMap} per
     * ottenere un oggetto {@link MapURLs} con i riferimenti all'immagine della mappa aggiornata.
     */
    @Path("/setLayerVisible")
	@GET
	@Produces({ MediaType.APPLICATION_XML })
    public MapURLs setLayerVisible(@QueryParam("nomeLayer") String nomeLayer,
                                   @QueryParam("visible") boolean visible,
                                   @QueryParam("idMap") String idMap) {
        scriviLog("Invocata setLayerVisible(" + nomeLayer + "," + visible + "," + idMap + ")");
        MapURLs mu = new MapURLs();
        try {
            String mapName = this.readDB("MAPNAME", idMap).toString();
            MapServerBindingStub mapServer = new MapServerBindingStub(this.readDB("CONNSTRING", idMap).toString());
            MapDescription mDesc = (MapDescription) this.readDB("MAPDESCRIPTION", idMap);
            MapLayerInfo[] lInfos = mapServer.getServerInfo(mapName).getMapLayerInfos();
            LayerDescription[] lDescs = mDesc.getLayerDescriptions();
            int numLayers = lInfos.length;
            for (int i = 0; i < numLayers; i++) {
                if (lInfos[i].getName().equalsIgnoreCase(nomeLayer)) {
                    lDescs[i].setVisible(visible);
                    break;
                }
            }
            this.updateDB(idMap, "MAPDESCRIPTION", mDesc);
            return mu;
        }
        catch (Exception exc)
        {
            scriviLog("setLayerVisible: errore!", exc);
            mu.setErrore(exc.getMessage());
            return mu;
        }
    }


    /**
     * Restituisce il {@link GenEnvelope} attuale della mappa/sevizio.
     * @param idMap String Identificatore della connessione al map server.
     * @return {@link GenEnvelope} attuale della mappa/sevizio.
     */
    @Path("/getMapEnvelope")
	@GET
	@Produces(MediaType.APPLICATION_XML)
    public GenEnvelope getMapEnvelope(@QueryParam("idMap") String idMap) {
        scriviLog("Invocata getMapEnvelope(" + idMap + ")");
        GenEnvelope env = new GenEnvelope();
        try {
            MapDescription mDesc = (MapDescription) this.readDB("MAPDESCRIPTION", idMap);
            com.esri.arcgisws.EnvelopeN newEnvelope = new com.esri.arcgisws.EnvelopeN();
            newEnvelope = (com.esri.arcgisws.EnvelopeN) mDesc.getMapArea().getExtent();
            env.setMinX(newEnvelope.getXMin());
            env.setMaxX(newEnvelope.getXMax());
            env.setMinY(newEnvelope.getYMin());
            env.setMaxY(newEnvelope.getYMax());
            return env;
        } catch (Exception exc) {
            scriviLog(exc);
            return env;
        }
    }


    private NormalizzatoreSoapPort getNormalizzatoreSoapPort(String handle) {
        try {
            NormalizzatoreLocator locator = new NormalizzatoreLocator();
            String[] param = this.readDBNorm(handle);
            String address = param[0];
            String user = param[1];
            String password = param[2];
            if (address.endsWith("/"))
                address = address.substring(0, address.length() - 1);
            locator.setNormalizzatoreSoapPortEndpointAddress(address +
                    normAddress);
            NormalizzatoreSoapPort port = locator.getNormalizzatoreSoapPort();
            return port;
        }
        catch (Exception exc)
        {
            this.scriviLog("Errore nella connessione al normalizzatore: " + exc.getMessage() + "\n");
            return null;
        }

    }
    
    /**
     * Metodo per ottenere l'handle del normalizzatore a partire da un identificatore che permette di recuperare id e pwd associati.
     * @param id String valore dell'identificatore
     * @param callback String indica una chiamata jsonp
     * @return Handle utilizzato per nelle chiamate ai metodi di normalizzazione;
     * in caso di errore verr� restituita una stringa del tipo:
     * "Errore nella connessione al normalizzatore: " + messaggio di errore
     */
    @Path("/initNormalizzatoreWithIdJson")
    @GET
    @Produces({"application/javascript"})
    public String initNormalizzatoreWithIdJson(@QueryParam("id") String id,
            @QueryParam("callback") String callback)
    {
        scriviLog("Invocata initNormalizzatoreWithId(" + id + ")");
        Connection conn = this.getDSConn();
        if (conn != null) {          
            String sql = "SELECT INDIRIZZO, UTENTE, PWD FROM NORMALIZZATORE_ID ";
            sql += "WHERE ID = '" + id + "'";
            try {
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                String[] result = new String[3];
                while (rs.next()) {
                    result[0] = rs.getString("INDIRIZZO");
                    result[1] = rs.getString("UTENTE");
                    result[2] = rs.getString("PWD");
                }
                rs.close();
                st.close();
                conn.close();
                return initNormalizzatoreJson(result[0], result[1], result[2], callback);
            }
            catch (Exception exc)
            {
                this.scriviLog("Errore nella connessione al normalizzatore con id " + id + " : " + exc.getMessage() + "\n");                    
                JSONObject res = new JSONObject();
                res.put("handle", "Errore nella connessione al normalizzatore con id " + id + " : " + exc.getMessage() + "\n");
                if (callback != null && callback.length() > 0)
                    return callback + "(" + res.toString() + ")";
                else
                    return res.toString();
            }           
        }
        else
        {
            JSONObject res = new JSONObject();
            res.put("handle", "Errore nella connessione al normalizzatore con id " + id + "\n");
            if (callback != null && callback.length() > 0)
                return callback + "(" + res.toString() + ")";
            else
                return res.toString();
        }
    }
    
    @Path("/initNormalizzatoreWithId")
    @GET
    @Produces({"text/plain"})
    public String initNormalizzatoreWithId(@QueryParam("id") String id) {
        scriviLog("Invocata initNormalizzatoreWithId(" + id + ")");
        Connection conn = getDSConn();
        if (conn != null) {
            String sql = "SELECT INDIRIZZO, UTENTE, PWD FROM NORMALIZZATORE_ID ";
            sql = sql + "WHERE ID = '" + id + "'";
            try {
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                String[] result = new String[3];
                while (rs.next()) {
                    result[0] = rs.getString("INDIRIZZO");
                    result[1] = rs.getString("UTENTE");
                    result[2] = rs.getString("PWD");
                }
                rs.close();
                st.close();
                conn.close();
                return initNormalizzatore(result[0], result[1], result[2]);
            } catch (Exception exc) {
                scriviLog("Errore nella connessione al normalizzatore con id " + id + " : " + exc.getMessage() + "\n");
                return "Errore nella connessione al normalizzatore con id " + id + " : " + exc.getMessage() + "\n";
            }
        }
        return "Errore nella connessione al normalizzatore con id " + id + " : id inesistente\n";
    }
   
    /**
     * Metodo per ottenere l'handle del normalizzatore.
     * @param address String Indirizzo del web service normalizzatore; deve essere nella forma
     * http://192.168.7.201:8080
     * @param user String Utente utilizzato per il rilascio dell'handle
     * @param password String Password dell'utente utilizzato per il rilascio dell'handle
     * @param callback String indica una chiamata jsonp
     * @return Handle utilizzato per nelle chiamate ai metodi di normalizzazione;
     * in caso di errore verr� restituita una stringa del tipo:
     * "Errore nella connessione al normalizzatore: " + messaggio di errore
     */
    @Path("/initNormalizzatoreJson")
	@GET
	@Produces({"application/javascript"})
    public String initNormalizzatoreJson(@QueryParam("address") String address,
                                     @QueryParam("user") String user,
                                     @QueryParam("password") String password,
                                     @QueryParam("callback") String callback)
    {
        scriviLog("Invocata initNormalizzatore(" + address + "," + user + "," + password + ")");
        try {
            NormalizzatoreLocator locator = new NormalizzatoreLocator();
            //address = "http://10.22.1.50:8080/SoapDispenser/";
            if (address.endsWith("/"))
                address = address.substring(0, address.length() - 1);
            locator.setNormalizzatoreSoapPortEndpointAddress(address +
                    normAddress);
            //locator.setNormalizzatoreSoapPortEndpointAddress(address);
            NormalizzatoreSoapPort port = locator.getNormalizzatoreSoapPort();
            GetHandleSoapInElement in = new GetHandleSoapInElement();
            GetHandleInput input = new GetHandleInput();
            GetHandleInputParams param = new GetHandleInputParams(password, user);
            input.setGetHandleInputParams(param);
            in.setGetHandleInput(input);
            GetHandleSoapOutElement out =  port.getHandle(in);
            String handle = out.getGetHandleOutput().getGetHandleOutputParams().getP_Handle();
            scriviLog("handle: " + handle);
            System.out.println();
            if (handle == null || handle.length() == 0)
                handle = "Errore nella connessione al normalizzatore: handle restituito nullo o di lunghezza = 0\n";
            Calendar currenttime = Calendar.getInstance();
            java.sql.Date sqldate = new java.sql.Date((currenttime.getTime()).getTime());
            this.writeDBNorm(handle, sqldate, address, user, password);

            JSONObject res = new JSONObject();
            res.put("handle", handle);
            if (callback != null && callback.length() > 0)
                return callback + "(" + res.toString() + ")";
            else
                return res.toString();
        }
        catch (Exception exc)
        {
            this.scriviLog("Errore nella connessione al normalizzatore: " + exc.getMessage() + "\n");
            JSONObject res = new JSONObject();
            res.put("handle", "Errore nella connessione al normalizzatore: " + exc.getMessage() + "\n");
            if (callback != null && callback.length() > 0)
                return callback + "(" + res.toString() + ")";
            else
                return res.toString();
        }
    }
    
    @Path("/initNormalizzatore")
    @GET
    @Produces({"text/plain"})
    public String initNormalizzatore(@QueryParam("address") String address, @QueryParam("user") String user, @QueryParam("password") String password) {
        scriviLog("Invocata initNormalizzatore(" + address + "," + user + "," + password + ")");
        try {
            NormalizzatoreLocator locator = new NormalizzatoreLocator();
            if (address.endsWith("/")) {
                address = address.substring(0, address.length() - 1);
            }
            locator.setNormalizzatoreSoapPortEndpointAddress(address + normAddress);

            NormalizzatoreSoapPort port = locator.getNormalizzatoreSoapPort();
            GetHandleSoapInElement in = new GetHandleSoapInElement();
            GetHandleInput input = new GetHandleInput();
            GetHandleInputParams param = new GetHandleInputParams(password, user);
            input.setGetHandleInputParams(param);
            in.setGetHandleInput(input);
            GetHandleSoapOutElement out = port.getHandle(in);
            String handle = out.getGetHandleOutput().getGetHandleOutputParams().getP_Handle();
            scriviLog("handle: " + handle);
            System.out.println();
            if ((handle == null) || (handle.length() == 0)) {
                return "Errore nella connessione al normalizzatore: handle restituito nullo o di lunghezza = 0\n";
            }
            Calendar currenttime = Calendar.getInstance();
            java.sql.Date sqldate = new java.sql.Date(currenttime.getTime().getTime());
            writeDBNorm(handle, sqldate, address, user, password);
            return handle;
        } catch (Exception exc) {
            scriviLog("Errore nella connessione al normalizzatore: " + exc.getMessage() + "\n");
            return "Errore nella connessione al normalizzatore: " + exc.getMessage() + "\n";
        }
    }
    /**
     * Metodo per ottenere l'handle di default del normalizzatore utilizzando l'utente di default. 
     * I parametri di connessione sono presenti nel file di configurazione config.properties
     * @param callback String indica una chiamata jsonp
     * @return Handle utilizzato per nelle chiamate ai metodi di normalizzazione;
     * in caso di errore verra restituita una stringa del tipo:
     * "Errore nella connessione al normalizzatore: " + messaggio di errore
     */
    @Path("/initNormalizzatoreDefaultJson")
	@GET
	@Produces({"application/javascript"})
    public String initNormalizzatoreDefaultJson(@QueryParam("callback") String callback)
    {
        scriviLog("Invocata initNormalizzatoreDefault()");
        try {
            NormalizzatoreLocator locator = new NormalizzatoreLocator();
            //address = "http://10.22.1.50:8080/SoapDispenser/";
            Config config = new Config();
            String user = config.getData("Normalizzatore-User");
            String password = config.getData("Normalizzatore-Pwd");
            String address = config.getData("Normalizzatore-Address");
            if (address.endsWith("/"))
                address = address.substring(0, address.length() - 1);
            locator.setNormalizzatoreSoapPortEndpointAddress(address + normAddress);
            //locator.setNormalizzatoreSoapPortEndpointAddress(address);
            NormalizzatoreSoapPort port = locator.getNormalizzatoreSoapPort();
            GetHandleSoapInElement in = new GetHandleSoapInElement();
            GetHandleInput input = new GetHandleInput();
            GetHandleInputParams param = new GetHandleInputParams(password, user);
            input.setGetHandleInputParams(param);
            in.setGetHandleInput(input);
            GetHandleSoapOutElement out =  port.getHandle(in);
            String handle = out.getGetHandleOutput().getGetHandleOutputParams().getP_Handle();
            scriviLog("handle: " + handle);
            System.out.println();
            if (handle == null || handle.length() == 0)
                handle = "Errore nella connessione al normalizzatore: handle restituito nullo o di lunghezza = 0\n";
            Calendar currenttime = Calendar.getInstance();
            java.sql.Date sqldate = new java.sql.Date((currenttime.getTime()).getTime());
            this.writeDBNorm(handle, sqldate, address, user, password);
            JSONObject res = new JSONObject();
            res.put("handle", handle);
            if (callback != null && callback.length() > 0)
                return callback + "(" + res.toString() + ")";
            else
                return res.toString();
        }
        catch (Exception exc)
        {
            this.scriviLog("Errore nella connessione al normalizzatore: " + exc.getMessage() + "\n");
            JSONObject res = new JSONObject();
            res.put("handle", "Errore nella connessione al normalizzatore: " + exc.getMessage() + "\n");
            if (callback != null && callback.length() > 0)
                return callback + "(" + res.toString() + ")";
            else
                return res.toString();
        }
    }    
    
    @Path("/initNormalizzatoreDefault")
    @GET
    @Produces({"text/plain"})
    public String initNormalizzatoreDefault() {
        scriviLog("Invocata initNormalizzatoreDefault()");
        try {
            NormalizzatoreLocator locator = new NormalizzatoreLocator();

            Config config = new Config();
            String user = config.getData("Normalizzatore-User");
            String password = config.getData("Normalizzatore-Pwd");
            String address = config.getData("Normalizzatore-Address");
            if (address.endsWith("/")) {
                address = address.substring(0, address.length() - 1);
            }
            locator.setNormalizzatoreSoapPortEndpointAddress(address + normAddress);

            NormalizzatoreSoapPort port = locator.getNormalizzatoreSoapPort();
            GetHandleSoapInElement in = new GetHandleSoapInElement();
            GetHandleInput input = new GetHandleInput();
            GetHandleInputParams param = new GetHandleInputParams(password, user);
            input.setGetHandleInputParams(param);
            in.setGetHandleInput(input);
            GetHandleSoapOutElement out = port.getHandle(in);
            String handle = out.getGetHandleOutput().getGetHandleOutputParams().getP_Handle();
            scriviLog("handle: " + handle);
            System.out.println();
            if ((handle == null) || (handle.length() == 0)) {
                return "Errore nella connessione al normalizzatore: handle restituito nullo o di lunghezza = 0\n";
            }
            Calendar currenttime = Calendar.getInstance();
            java.sql.Date sqldate = new java.sql.Date(currenttime.getTime().getTime());
            writeDBNorm(handle, sqldate, address, user, password);
            return handle;
        } catch (Exception exc) {
            scriviLog("Errore nella connessione al normalizzatore: " + exc.getMessage() + "\n");
            return "Errore nella connessione al normalizzatore: " + exc.getMessage() + "\n";
        }
    }
  
    private void writeDBNorm(String handle, java.sql.Date data, String indirizzo, String utente, String pwd) {
        Connection conn = this.getDSConn();
        if (conn != null) {
            String sql = "INSERT INTO NORMALIZZATORE_SESSION (HANDLE, DATA, INDIRIZZO, UTENTE, PWD) ";
            sql += "VALUES (?,?,?,?,?)";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, handle);
                ps.setDate(2, data);
                ps.setString(3, indirizzo);
                ps.setString(4, utente);
                ps.setString(5, pwd);
                ps.execute();
                ps.close();
                conn.commit();
                conn.close();
            }
            catch (Exception e) {
                this.scriviLog("Errore durante la scrittura nel db", e);
            }
        }
    }

    private void writeDBSDE(String idLRS, java.sql.Date data, String utente, String pwd, String connString, String roadLayer, String geometryCol, String idCol) {
        Connection conn = this.getDSConn();
        if (conn != null) {
            String sql = "INSERT INTO SDE_SESSION (IDLRS, DATA, UTENTE, PWD, CONNSTRING, ROADLAYER, GEOMETRYCOL, IDCOL) ";
            sql += "VALUES (?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, idLRS);
                ps.setDate(2, data);
                ps.setString(3, utente);
                ps.setString(4, pwd);
                ps.setString(5, connString);
                ps.setString(6, roadLayer);
                ps.setString(7, geometryCol);
                ps.setString(8, idCol);
                ps.execute();
                ps.close();
                conn.commit();
                conn.close();
            }
            catch (Exception e) {
                this.scriviLog("Errore durante la scrittura nel db", e);
            }
        }
    }


    private String[] readDBNorm(String handle) {
        Connection conn = this.getDSConn();
        if (conn != null) {
            String sql = "SELECT INDIRIZZO, UTENTE, PWD FROM NORMALIZZATORE_SESSION ";
            sql += "WHERE HANDLE = '" + handle + "'";
            try {
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                String[] result = new String[3];
                while (rs.next()) {
                    result[0] = rs.getString("INDIRIZZO");
                    result[1] = rs.getString("UTENTE");
                    result[2] = rs.getString("PWD");
                }
                rs.close();
                st.close();
                conn.close();
                return result;
            }
            catch (Exception e)
            {
                scriviLog("Errore durante la lettura del db", e);
                return null;
            }
        }
        else
            return null;
    }

    private SeConnection getSDEConn(String idLRS) {
        SeConnection sdeConn = null;
        Connection conn = this.getDSConn();
        if (conn != null) {
            String sql = "SELECT UTENTE, PWD, CONNSTRING FROM SDE_SESSION ";
            sql += "WHERE IDLRS = '" + idLRS + "'";
            try {
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                String utente = null;
                String pwd = null;
                String connString = null;
                while (rs.next()) {
                    utente = rs.getString("UTENTE");
                    pwd = rs.getString("PWD");
                    connString = rs.getString("CONNSTRING");
                }
                rs.close();
                st.close();
                conn.close();
                
                StringTokenizer stk = new StringTokenizer(connString, ";");
                try {
                    String server = stk.nextToken();
                    int instance = Integer.parseInt(stk.nextToken());
                    String database = "";
                    if (stk.hasMoreElements())
                        database = stk.nextToken();
                    sdeConn = new SeConnection(server, instance, database, utente, pwd);
                }
                //formato direct connection
                catch (Exception e) {
                    /*String server = "NB-I17R\\SQLEXPRESS01";
                    String instance = "sde:sqlserver:NB-I17R\\SQLEXPRESS01";
                    String database = "PMS_7";
                    String user = "PMS_7";
                    String password = "PMS_7";

                    sdeConn = new SeConnection(server, instance, database, user, password);*/
                    String instance = stk.nextToken();
                    String tns = stk.nextToken();
                    //sdeConn = new SeConnection("none", "sde:oracle11g:geobase_tns", "none", "{my-user}", "{my-password}@geobase_tns");
                    sdeConn = new SeConnection("none", instance, "none", utente, pwd + "@" + tns);
                }
                
                return sdeConn;
            } catch (Exception e) {
                scriviLog("Errore durante la lettura del db", e);
                return null;
            }
        }
        else {
            return null;
        }
    }



    /**
     * La normInfoEntitaStradario restituisce le informazione relative all'entita
     * richiesta
     * @param p_entita String identificativo dell'entit�
     * @param p_tipo_coord String tipo di coordinate (UTMA o WGS84) che si vuole
     * vengano restituite
     * @param handle String handle di connessione al normalizzatore
     * @return ArrayOfNormInfoEntitaStradarioRecord Array di rowset contenenti i risultati ottenuti
     * dal processo di normalizzazione.
     */
    @Path("/normInfoEntitaStradario")
	@GET
	@Produces({ MediaType.APPLICATION_XML })
    public ArrayOfNormInfoEntitaStradarioRecord normInfoEntitaStradario(@QueryParam("p_entita") String p_entita,
                                                                        @QueryParam("p_tipo_coord") String p_tipo_coord,
                                                                        @QueryParam("handle") String handle) {
        scriviLog("Invocata normInfoEntitaStradario(" + p_entita + "," + p_tipo_coord + "," + handle);
        try {
            NormalizzatoreSoapPort norm = this.getNormalizzatoreSoapPort(handle);
            Info_Entita_StradarioInputParams iesip = new Info_Entita_StradarioInputParams();
            if (!emptyString(handle))
                iesip.setP_HANDLE(handle);
            if (!emptyString(p_entita))
                iesip.setP_ENTITA_ID(p_entita);
            if (!emptyString(p_tipo_coord))
                iesip.setP_TIPO_COORD(p_tipo_coord);
            Info_Entita_StradarioInput iesi = new Info_Entita_StradarioInput(iesip, null);
            Info_Entita_StradarioSoapInElement iessie = new Info_Entita_StradarioSoapInElement(iesi);
            Info_Entita_StradarioSoapOutElement iessoe = norm.info_Entita_Stradario(iessie);
            Info_Entita_StradarioOutputRecordsetArray iesora = iessoe.getInfo_Entita_StradarioOutput().getInfo_Entita_StradarioOutputRecordsetArray();
            NormInfoEntitaStradarioRecord[] records = new NormInfoEntitaStradarioRecord[iesora.getInfo_Entita_StradarioOutputRecordset().length];

            for (int i = 0; i < records.length; i++) {
                NormInfoEntitaStradarioRecord r = new NormInfoEntitaStradarioRecord();
                r.setCENTR_X(iesora.getInfo_Entita_StradarioOutputRecordset(i).getCENTR_X());
                r.setCENTR_Y(iesora.getInfo_Entita_StradarioOutputRecordset(i).getCENTR_Y());
                r.setCOMUNE(iesora.getInfo_Entita_StradarioOutputRecordset(i).getCOMUNE());
                r.setDENOMINAZIONE(iesora.getInfo_Entita_StradarioOutputRecordset(i).getDENOMINAZIONE());
                r.setDESCRIZ_UFF(iesora.getInfo_Entita_StradarioOutputRecordset(i).getDESCRIZ_UFF());
                r.setDUG(iesora.getInfo_Entita_StradarioOutputRecordset(i).getDUG());
                r.setENTITA_ID(iesora.getInfo_Entita_StradarioOutputRecordset(i).getENTITA_ID());
                r.setMAX_X(iesora.getInfo_Entita_StradarioOutputRecordset(i).getMAX_X());
                r.setMAX_Y(iesora.getInfo_Entita_StradarioOutputRecordset(i).getMAX_Y());
                r.setMIN_X(iesora.getInfo_Entita_StradarioOutputRecordset(i).getMIN_X());
                r.setMIN_Y(iesora.getInfo_Entita_StradarioOutputRecordset(i).getMIN_Y());
                r.setPROVINCIA(iesora.getInfo_Entita_StradarioOutputRecordset(i).getPROVINCIA());
                r.setREGIONE(iesora.getInfo_Entita_StradarioOutputRecordset(i).getREGIONE());
                r.setSTRADARIO_ID(iesora.getInfo_Entita_StradarioOutputRecordset(i).getSTRADARIO_ID());
                r.setTIPO_COORD(iesora.getInfo_Entita_StradarioOutputRecordset(i).getTIPO_COORD());
                r.setTIPO_STRADA(iesora.getInfo_Entita_StradarioOutputRecordset(i).getTIPO_STRADA());
                records[i] = r;
            }
            ArrayOfNormInfoEntitaStradarioRecord recordSet = new ArrayOfNormInfoEntitaStradarioRecord(records);
            return recordSet;
        }
        catch (Exception exc)
        {
            this.scriviLog("Errore nella normalizzazione dell'incrocio (normIncrocio): " + exc.getMessage() + "\n");
            return null;
        }
    }
    
    @Path("/normChilometricaJson")
	@GET
	@Produces({"application/javascript"})
    public String normChilometricaJson(@QueryParam("p_toponimo") String p_toponimo,
                                                    @QueryParam("p_km") String p_km,
                                                    @QueryParam("p_comune") String p_comune,
                                                    @QueryParam("p_provincia") String p_provincia,
                                                    @QueryParam("p_tipo_coord") String p_tipo_coord,
                                                    @QueryParam("p_tipo_strada") String p_tipo_strada,
                                                    @QueryParam("handle") String handle,
                                                    @QueryParam("idlrs") String idlrs,
                                                    @QueryParam("callback") String callback)
    {
        scriviLog("Invocata normChilometricaJson(" + p_toponimo + "," + p_km + " ," + p_comune + "," + p_provincia + "," + p_tipo_coord + "," + p_tipo_strada + "," + handle + "," + idlrs + ")");
        try {
            String sNormStradario = normStradarioJson(p_toponimo, p_comune, p_provincia, "", "", "", "S", p_tipo_coord, p_tipo_strada, handle, "");
            JSONObject resNormStradario = new JSONObject(sNormStradario);
            ChilometricaRecord[] records = new ChilometricaRecord[0];
            if (resNormStradario.keys().hasNext())
            {
                JSONArray results = resNormStradario.getJSONArray("records");
                if (results != null && results.length() > 0)
                {
                    records = new ChilometricaRecord[results.length()];
                    for (int i = 0; i < results.length(); i++) 
                    {
                        ChilometricaRecord kmRecord = new ChilometricaRecord();
                        double x = 0.0;
                        double y = 0.0;
                        double mmin = 0.0;
                        double mmax = 0.0;
                        JSONObject record = results.getJSONObject(i);
                        String provincia = record.getString("PROVINCIA");
                        String entita_id = record.getString("ENTITA_ID");
                        String denominazione = record.getString("DENOMINAZIONE");
                        String tipo_strada = record.getString("TIPO_STRADA");
                        kmRecord.setPROVINCIA(provincia);
                        kmRecord.setCOMUNE(p_comune);
                        kmRecord.setDENOMINAZIONE(denominazione);      
                        kmRecord.setENTITA_ID(entita_id);
                        
                        if (entita_id.toUpperCase().endsWith("RT"))
                        {
                            double km = Double.parseDouble(p_km);
                            //if (provincia.equalsIgnoreCase("BOLOGNA"))
                            //    km = km / 1000;              
                            kmRecord.setKM(BigDecimal.valueOf(km));                       
                            String sQueryXY = queryXYJson(entita_id, km, "", idlrs, "");
                            JSONObject resQueryXY = new JSONObject(sQueryXY);
                            if (resQueryXY.keys().hasNext())
                            {
                                x = resQueryXY.getDouble("x");
                                y = resQueryXY.getDouble("y");
                                kmRecord.setKM_X(BigDecimal.valueOf(x));
                                kmRecord.setKM_Y(BigDecimal.valueOf(y));
                            }
                            
                            String sQueryProg = queryProgJson(x, y, "ID_ENTITA='" + entita_id + "'", idlrs, "");                     
                            if (sQueryProg != null && !sQueryProg.isEmpty())
                            {
                                JSONObject resQueryProg = new JSONObject(sQueryProg);
                                if (resQueryProg.keys().hasNext())
                                {
                                    mmin = resQueryProg.getDouble("MMin");
                                    mmax = resQueryProg.getDouble("MMax");
                                    kmRecord.setKM_MIN(BigDecimal.valueOf(mmin));
                                    kmRecord.setKM_MAX(BigDecimal.valueOf(mmax));
                                }
                            }
                        }
                         //strada sprovvista di calibrazione
                        else
                        {
                            String sNormIndirizzo = normIndirizzoJson(denominazione, p_comune, "", p_provincia, "", "", "", p_tipo_coord, "PCIV", handle, "");
                            JSONObject resNormIndirizzo = new JSONObject(sNormIndirizzo);
                            if (resNormIndirizzo.keys().hasNext())
                            {
                                JSONArray normIndirizzoRecords = resNormIndirizzo.getJSONArray("records");
                                for (int k = 0; k < normIndirizzoRecords.length(); k++)
                                {
                                    JSONObject currIndirizzo = normIndirizzoRecords.getJSONObject(k);
                                    if (currIndirizzo.getString("ENTITA_ID").equalsIgnoreCase(entita_id))
                                    {
                                        kmRecord.setMIN_X(BigDecimal.valueOf(currIndirizzo.getDouble("MIN_X")));
                                        kmRecord.setMIN_Y(BigDecimal.valueOf(currIndirizzo.getDouble("MIN_Y")));
                                        kmRecord.setMAX_X(BigDecimal.valueOf(currIndirizzo.getDouble("MAX_X")));
                                        kmRecord.setMAX_Y(BigDecimal.valueOf(currIndirizzo.getDouble("MAX_Y")));
                                        kmRecord.setCENTR_X(BigDecimal.valueOf(currIndirizzo.getDouble("CENTR_X")));
                                        kmRecord.setCENTR_Y(BigDecimal.valueOf(currIndirizzo.getDouble("CENTR_Y")));
                                        break;
                                    }
                                }
                            }
                        }
                        records[i] = kmRecord;
                    }
                }
            }
            
            ArrayOfChilometricaRecord recordSet = new ArrayOfChilometricaRecord(records);
            JSONObject res = new JSONObject(recordSet);
            if (callback != null && callback.length() > 0)
               return callback + "(" + res.toString() + ")";
            else
                return res.toString();
        }
        catch (Exception exc)
        {
            this.scriviLog("Errore nella normalizzazione della chilometrica (normChilometrica): " + exc.getMessage() + "\n");
            JSONObject res = new JSONObject();
            if (callback != null && callback.length() > 0)
               return callback + "(" + res.toString() + ")";
            else
                return res.toString();
        }
    }
    
    /**
     *
     * @param p_toponimo String
     * @param p_comune String
     * @param p_provincia String
     * @param p_cod_istat String
     * @param p_cod_cat String
     * @param p_cod_naz String
     * @param p_desc_uff String
     * @param p_tipo_coord String
     * @param p_tipo_strada String
     * @param handle String
     * @param callback String indica una chiamata jsonp
     * @return ArrayOfNormStradarioRecord
     */
    @Path("/normStradarioJson")
	@GET
	@Produces({"application/javascript"})
    public String normStradarioJson(@QueryParam("p_toponimo") String p_toponimo,
                                                    @QueryParam("p_comune") String p_comune,
                                                    @QueryParam("p_provincia") String p_provincia,
                                                    @QueryParam("p_cod_istat") String p_cod_istat,
                                                    @QueryParam("p_cod_cat") String p_cod_cat,
                                                    @QueryParam("p_cod_naz") String p_cod_naz,
                                                    @QueryParam("p_desc_uff") String p_desc_uff,
                                                    @QueryParam("p_tipo_coord") String p_tipo_coord,
                                                    @QueryParam("p_tipo_strada") String p_tipo_strada,
                                                    @QueryParam("handle") String handle,
                                                    @QueryParam("callback") String callback)
    {
        scriviLog("Invocata normStradario(" +p_toponimo + "," + p_comune + "," + p_provincia + "," + p_cod_istat + "," + p_cod_cat + "," + p_cod_naz + "," + p_desc_uff + "," + p_tipo_coord + "," + p_tipo_strada + "," + handle + ")");
        try {
            NormalizzatoreSoapPort norm = this.getNormalizzatoreSoapPort(handle);
            Norm_StradarioInputParams iesip = new Norm_StradarioInputParams();
            if (!emptyString(handle))
                iesip.setP_Handle(handle);
            if (!emptyString(p_toponimo))
                iesip.setP_Toponimo(p_toponimo);
            if (!emptyString(p_comune))
                iesip.setP_Comune(p_comune);
            if (!emptyString(p_provincia))
                iesip.setP_Provincia(p_provincia);
            if (!emptyString(p_cod_istat))
                iesip.setP_Cod_Istat(p_cod_istat);
            if (!emptyString(p_cod_cat))
                iesip.setP_Cod_Catastale(p_cod_cat);
            if (!emptyString(p_cod_naz))
                iesip.setP_Cod_Nazionale(p_cod_naz);
            if (!emptyString(p_desc_uff))
                iesip.setP_Descrizione_Uff(p_desc_uff);
            if (!emptyString(p_tipo_coord))
                iesip.setP_Tipo_Coord(p_tipo_coord);
            if (!emptyString(p_tipo_strada))
                iesip.setP_Tipo_Strada(p_tipo_strada);
            Norm_StradarioInput iesi = new Norm_StradarioInput(iesip, null);
            Norm_StradarioSoapInElement iessie = new Norm_StradarioSoapInElement(iesi);
            Norm_StradarioSoapOutElement iessoe = norm.norm_Stradario(iessie);
            Norm_StradarioOutputRecordsetArray iesora = iessoe.getNorm_StradarioOutput().getNorm_StradarioOutputRecordsetArray();
            NormStradarioRecord[] records = new NormStradarioRecord[iesora.getNorm_StradarioOutputRecordset().length];

            for (int i = 0; i < records.length; i++) {
                NormStradarioRecord r = new NormStradarioRecord();
                r.setCENTR_X(iesora.getNorm_StradarioOutputRecordset(i).getCENTR_X());
                r.setCENTR_Y(iesora.getNorm_StradarioOutputRecordset(i).getCENTR_Y());
                r.setCOMUNE(iesora.getNorm_StradarioOutputRecordset(i).getCOMUNE());
                r.setDENOMINAZIONE(iesora.getNorm_StradarioOutputRecordset(i).getDENOMINAZIONE());
                r.setDESCRIZ_UFF(iesora.getNorm_StradarioOutputRecordset(i).getDESCRIZ_UFF());
                r.setDUG(iesora.getNorm_StradarioOutputRecordset(i).getDUG());
                r.setENTITA_ID(iesora.getNorm_StradarioOutputRecordset(i).getENTITA_ID());
                r.setGR_AFFIDABILITA(iesora.getNorm_StradarioOutputRecordset(i).getGR_AFFIDABILITA());
                r.setMAX_X(iesora.getNorm_StradarioOutputRecordset(i).getMAX_X());
                r.setMAX_Y(iesora.getNorm_StradarioOutputRecordset(i).getMAX_Y());
                r.setMIN_X(iesora.getNorm_StradarioOutputRecordset(i).getMIN_X());
                r.setMIN_Y(iesora.getNorm_StradarioOutputRecordset(i).getMIN_Y());
                r.setNUMERO_RIGA(iesora.getNorm_StradarioOutputRecordset(i).getNUMERO_RIGA());
                r.setNUMERO_RIGHE(iesora.getNorm_StradarioOutputRecordset(i).getNUMERO_RIGHE());
                r.setPROVINCIA(iesora.getNorm_StradarioOutputRecordset(i).getPROVINCIA());
                r.setREGIONE(iesora.getNorm_StradarioOutputRecordset(i).getREGIONE());
                r.setSTRADARIO_ID(iesora.getNorm_StradarioOutputRecordset(i).getSTRADARIO_ID());
                r.setTIPO_COORD(iesora.getNorm_StradarioOutputRecordset(i).getTIPO_COORD());
                r.setTIPO_STRADA(iesora.getNorm_StradarioOutputRecordset(i).getTIPO_STRADA());
                records[i] = r;
            }
            ArrayOfNormStradarioRecord recordSet = new ArrayOfNormStradarioRecord(records);
            
            JSONObject res = new JSONObject(recordSet);
             if (callback != null && callback.length() > 0)
                return callback + "(" + res.toString() + ")";
             else
                 return res.toString();
        }
        catch (Exception exc)
        {
            this.scriviLog("Errore nella normalizzazione della strada (normStradario): " + exc.getMessage() + "\n");
            JSONObject res = new JSONObject();
             if (callback != null && callback.length() > 0)
                return callback + "(" + res.toString() + ")";
             else
                 return res.toString();
        }
    }

    @Path("/normStradario")
    @GET
    @Produces({"application/xml"})
    public ArrayOfNormStradarioRecord normStradario(@QueryParam("p_toponimo") String p_toponimo, @QueryParam("p_comune") String p_comune, @QueryParam("p_provincia") String p_provincia, @QueryParam("p_cod_istat") String p_cod_istat, @QueryParam("p_cod_cat") String p_cod_cat, @QueryParam("p_cod_naz") String p_cod_naz, @QueryParam("p_desc_uff") String p_desc_uff, @QueryParam("p_tipo_coord") String p_tipo_coord, @QueryParam("p_tipo_strada") String p_tipo_strada, @QueryParam("handle") String handle) {
        scriviLog("Invocata normStradario(" + p_toponimo + "," + p_comune + "," + p_provincia + "," + p_cod_istat + "," + p_cod_cat + "," + p_cod_naz + "," + p_desc_uff + "," + p_tipo_coord + "," + p_tipo_strada + "," + handle + ")");
        try {
            NormalizzatoreSoapPort norm = getNormalizzatoreSoapPort(handle);
            Norm_StradarioInputParams iesip = new Norm_StradarioInputParams();
            if (!emptyString(handle)) {
                iesip.setP_Handle(handle);
            }
            if (!emptyString(p_toponimo)) {
                iesip.setP_Toponimo(p_toponimo);
            }
            if (!emptyString(p_comune)) {
                iesip.setP_Comune(p_comune);
            }
            if (!emptyString(p_provincia)) {
                iesip.setP_Provincia(p_provincia);
            }
            if (!emptyString(p_cod_istat)) {
                iesip.setP_Cod_Istat(p_cod_istat);
            }
            if (!emptyString(p_cod_cat)) {
                iesip.setP_Cod_Catastale(p_cod_cat);
            }
            if (!emptyString(p_cod_naz)) {
                iesip.setP_Cod_Nazionale(p_cod_naz);
            }
            if (!emptyString(p_desc_uff)) {
                iesip.setP_Descrizione_Uff(p_desc_uff);
            }
            if (!emptyString(p_tipo_coord)) {
                iesip.setP_Tipo_Coord(p_tipo_coord);
            }
            if (!emptyString(p_tipo_strada)) {
                iesip.setP_Tipo_Strada(p_tipo_strada);
            }
            Norm_StradarioInput iesi = new Norm_StradarioInput(iesip, null);
            Norm_StradarioSoapInElement iessie = new Norm_StradarioSoapInElement(iesi);
            Norm_StradarioSoapOutElement iessoe = norm.norm_Stradario(iessie);
            Norm_StradarioOutputRecordsetArray iesora = iessoe.getNorm_StradarioOutput().getNorm_StradarioOutputRecordsetArray();
            NormStradarioRecord[] records = new NormStradarioRecord[iesora.getNorm_StradarioOutputRecordset().length];
            for (int i = 0; i < records.length; i++) {
                NormStradarioRecord r = new NormStradarioRecord();
                r.setCENTR_X(iesora.getNorm_StradarioOutputRecordset(i).getCENTR_X());
                r.setCENTR_Y(iesora.getNorm_StradarioOutputRecordset(i).getCENTR_Y());
                r.setCOMUNE(iesora.getNorm_StradarioOutputRecordset(i).getCOMUNE());
                r.setDENOMINAZIONE(iesora.getNorm_StradarioOutputRecordset(i).getDENOMINAZIONE());
                r.setDESCRIZ_UFF(iesora.getNorm_StradarioOutputRecordset(i).getDESCRIZ_UFF());
                r.setDUG(iesora.getNorm_StradarioOutputRecordset(i).getDUG());
                r.setENTITA_ID(iesora.getNorm_StradarioOutputRecordset(i).getENTITA_ID());
                r.setGR_AFFIDABILITA(iesora.getNorm_StradarioOutputRecordset(i).getGR_AFFIDABILITA());
                r.setMAX_X(iesora.getNorm_StradarioOutputRecordset(i).getMAX_X());
                r.setMAX_Y(iesora.getNorm_StradarioOutputRecordset(i).getMAX_Y());
                r.setMIN_X(iesora.getNorm_StradarioOutputRecordset(i).getMIN_X());
                r.setMIN_Y(iesora.getNorm_StradarioOutputRecordset(i).getMIN_Y());
                r.setNUMERO_RIGA(iesora.getNorm_StradarioOutputRecordset(i).getNUMERO_RIGA());
                r.setNUMERO_RIGHE(iesora.getNorm_StradarioOutputRecordset(i).getNUMERO_RIGHE());
                r.setPROVINCIA(iesora.getNorm_StradarioOutputRecordset(i).getPROVINCIA());
                r.setREGIONE(iesora.getNorm_StradarioOutputRecordset(i).getREGIONE());
                r.setSTRADARIO_ID(iesora.getNorm_StradarioOutputRecordset(i).getSTRADARIO_ID());
                r.setTIPO_COORD(iesora.getNorm_StradarioOutputRecordset(i).getTIPO_COORD());
                r.setTIPO_STRADA(iesora.getNorm_StradarioOutputRecordset(i).getTIPO_STRADA());
                records[i] = r;
            }
            return new ArrayOfNormStradarioRecord(records);
        } catch (Exception exc) {
            scriviLog("Errore nella normalizzazione dell'incrocio (normIncrocio): " + exc.getMessage() + "\n");
        }
        return null;
    }
    
    private String getProvincia(String codpro)
    {
        String res = "";
        if (codpro.equalsIgnoreCase("033"))
            res = "Piacenza";
        else if (codpro.equalsIgnoreCase("034"))
            res = "Parma";
        else if (codpro.equalsIgnoreCase("035"))
            res = "Reggio Emilia";
        else if (codpro.equalsIgnoreCase("036"))
            res = "Modena";
        else if (codpro.equalsIgnoreCase("037"))
            res = "Bologna";
        else if (codpro.equalsIgnoreCase("038"))
            res = "Ferrara";
        else if (codpro.equalsIgnoreCase("039"))
            res = "Ravenna";
        else if (codpro.equalsIgnoreCase("040"))
            res = "Forlì";
        else if (codpro.equalsIgnoreCase("099"))
            res = "Rimini";
        return res;
    }
    /**
     * 
     * @param p_tipo_loc
     * @param p_check_comune
     * @param p_x
     * @param p_y
     * @param p_tipo_coord
     * @param p_rif_geo_civ
     * @param p_handle
     * @param callback
     * @return 
     */
    @Path("/geolocInversaJson")
	@GET
	@Produces({"application/javascript"})
    public String geolocInversaJson(
            @QueryParam("p_tipo_loc") String p_tipo_loc,
            @QueryParam("p_check_comune") boolean p_check_comune,
            @QueryParam("p_x") double p_x,
            @QueryParam("p_y") double p_y,
            @QueryParam("p_tipo_coord") String p_tipo_coord,
            @QueryParam("p_rif_geo_civ") String p_rif_geo_civ,
            @QueryParam("p_handle") String p_handle,
            @QueryParam("p_idMap") String p_idMap,
            @QueryParam("p_idLrs") String p_idLrs,
            @QueryParam("callback") String callback)
    {
        scriviLog("Invocata geolocInversaJson(" + p_tipo_loc + ", " + p_check_comune + "," + 
                p_x + "," + p_y + "," +
                p_tipo_coord + "," + p_rif_geo_civ + ", " + p_handle + ", " + p_idMap + "," + p_idLrs + ", " + callback + ")"); 
        try {
            if (p_tipo_loc.equalsIgnoreCase("Civici"))
            {
                ArrayList<String> layers = new ArrayList<String>();
                layers.add("Civici");
                String resQueryRect = queryRect4Json(p_x - 2, p_y - 2, p_x + 2, p_y + 2, layers, 1, p_idMap, null);
                JSONObject resQueryRectJson = new JSONObject(resQueryRect);
                if (resQueryRectJson.keys().hasNext())
                {
                    JSONArray results = resQueryRectJson.getJSONArray("oil");
                    if (results != null && results.length() > 0)
                    {
                        JSONObject values = results.getJSONObject(0);
                        JSONArray fields = values.getJSONObject("fields").getJSONArray("objs");
                        int indexComune = -1;
                        int indexProvincia = -1;
                        int indexIndirizzo = -1;
                        for (int k = 0; k < fields.length(); k++)
                        {
                            if(fields.getString(k).equalsIgnoreCase("NOME_C"))
                                indexComune = k;
                            if(fields.getString(k).equalsIgnoreCase("NM_PRV"))
                                indexProvincia = k;
                            if(fields.getString(k).equalsIgnoreCase("INDIRIZZO"))
                                indexIndirizzo = k;
                        }
                        String comune = values.getJSONObject("values").getJSONArray("objs").getJSONObject(0).getJSONArray("objs").getString(indexComune);
                        String provincia = values.getJSONObject("values").getJSONArray("objs").getJSONObject(0).getJSONArray("objs").getString(indexProvincia);
                        String indirizzo = values.getJSONObject("values").getJSONArray("objs").getJSONObject(0).getJSONArray("objs").getString(indexIndirizzo);
                        return normIndirizzoJson(indirizzo, comune, "", provincia, "", "", "", p_tipo_coord, p_rif_geo_civ, p_handle, callback);
                    }
                    else
                    {
                        JSONObject res = new JSONObject();
                        if (callback != null && callback.length() > 0)
                            return callback + "(" + res.toString() + ")";
                        else
                        return res.toString();
                    }
                }
                else
                {
                    JSONObject res = new JSONObject();
                    if (callback != null && callback.length() > 0)
                        return callback + "(" + res.toString() + ")";
                    else
                    return res.toString();
                }
            }
            else if (p_tipo_loc.equalsIgnoreCase("Incrocio"))
            {
                ArrayList<String> layers = new ArrayList<String>();
                layers.add("Toponimi_strade");
                String resQueryRect = queryRect4Json(p_x - 5, p_y - 5, p_x + 5, p_y + 5, layers, 5, p_idMap, null);
                JSONObject resQueryRectJson = new JSONObject(resQueryRect);
                if (resQueryRectJson.keys().hasNext())
                {
                    JSONArray results = resQueryRectJson.getJSONArray("oil");
                    if (results != null && results.length() > 0)
                    {
                        JSONObject values = results.getJSONObject(0);
                        
                        JSONArray fields = values.getJSONObject("fields").getJSONArray("objs");
                        int indexComune = -1;
                        int indexIndirizzo = -1;
                        for (int k = 0; k < fields.length(); k++)
                        {
                            if(fields.getString(k).equalsIgnoreCase("CODCOM"))
                                indexComune = k;
                            if(fields.getString(k).equalsIgnoreCase("TP_NOME"))
                                indexIndirizzo = k;
                        }
                        
                        JSONArray records = values.getJSONObject("values").getJSONArray("objs");
                        if (records.length() > 2)
                        {
                            for (int i = 0; i < records.length() - 1; i++)
                            {
                                String via1 = records.getJSONObject(0).getJSONArray("objs").getString(indexIndirizzo);
                                String codcom1 = records.getJSONObject(0).getJSONArray("objs").getString(indexComune);
                                String via2 = records.getJSONObject(i + 1).getJSONArray("objs").getString(indexIndirizzo);
                                String codcom2 = records.getJSONObject(i + 1).getJSONArray("objs").getString(indexComune);

                                String sNormComune1 = normComune2Json("", "", "", codcom1, "", "", p_handle, "");
                                JSONObject sNormComune1Json = new JSONObject(sNormComune1); 
                                String comune1 = "";
                                if (sNormComune1Json.keys().hasNext())
                                {
                                    comune1 = sNormComune1Json.getJSONArray("records").getJSONObject(0).getString("DENOMINAZIONE");
                                }

                                String provincia1 = getProvincia(codcom1.substring(0, 3));
                               
                                String sNormComune2 = normComune2Json("", "", "", codcom2, "", "", p_handle, "");
                                JSONObject sNormComune2Json = new JSONObject(sNormComune2);
                                String comune2 = "";
                                if (sNormComune2Json.keys().hasNext())
                                {
                                    comune2 = sNormComune2Json.getJSONArray("records").getJSONObject(0).getString("DENOMINAZIONE");
                                }

                                String provincia2 = getProvincia(codcom2.substring(0, 3));
                                
                                String resNormIncrocio = normIncrocioJson(via1, comune1, provincia1, via2, comune2, provincia2, p_tipo_coord, p_handle, "");
                                if (!resNormIncrocio.equals("{}")) 
                                    return normIncrocioJson(via1, comune1, provincia1, via2, comune2, provincia2, p_tipo_coord, p_handle, callback);                         
                            }
                            JSONObject res = new JSONObject();
                            if (callback != null && callback.length() > 0)
                                return callback + "(" + res.toString() + ")";
                            else
                            return res.toString();
                        }
                        if (records.length() == 2)
                        {
                            
                            String via1 = records.getJSONObject(0).getJSONArray("objs").getString(indexIndirizzo);
                            String codcom1 = records.getJSONObject(0).getJSONArray("objs").getString(indexComune);
                            String via2 = records.getJSONObject(1).getJSONArray("objs").getString(indexIndirizzo);
                            String codcom2 = records.getJSONObject(1).getJSONArray("objs").getString(indexComune);

                            String sNormComune1 = normComune2Json("", "", "", codcom1, "", "", p_handle, "");
                            JSONObject sNormComune1Json = new JSONObject(sNormComune1); 
                            String comune1 = "";
                            if (sNormComune1Json.keys().hasNext())
                            {
                                comune1 = sNormComune1Json.getJSONArray("records").getJSONObject(0).getString("DENOMINAZIONE");
                            }

                            String provincia1 = getProvincia(codcom1.substring(0, 3));
                            
                            String sNormComune2 = normComune2Json("", "", "", codcom2, "", "", p_handle, "");
                            JSONObject sNormComune2Json = new JSONObject(sNormComune2);
                            String comune2 = "";
                            if (sNormComune2Json.keys().hasNext())
                            {
                                comune2 = sNormComune2Json.getJSONArray("records").getJSONObject(0).getString("DENOMINAZIONE");
                            }

                            String provincia2 = getProvincia(codcom2.substring(0, 3));
                            return normIncrocioJson(via1, comune1, provincia1, via2, comune2, provincia2, p_tipo_coord, p_handle, callback);
                        }
                        else
                        {
                            JSONObject res = new JSONObject();
                            if (callback != null && callback.length() > 0)
                                return callback + "(" + res.toString() + ")";
                            else
                            return res.toString();
                        }
                    }
                    else
                    {
                        JSONObject res = new JSONObject();
                        if (callback != null && callback.length() > 0)
                            return callback + "(" + res.toString() + ")";
                        else
                        return res.toString();
                    }
                }
                else
                {
                    JSONObject res = new JSONObject();
                    if (callback != null && callback.length() > 0)
                        return callback + "(" + res.toString() + ")";
                    else
                    return res.toString();
                }
            }
            else if (p_tipo_loc.equalsIgnoreCase("Chilometrica"))
            {
                ArrayList<String> layers = new ArrayList<String>();
                layers.add("PERCORSIM");
                String resQueryRect = queryRect4Json(p_x - 5, p_y - 5, p_x + 5, p_y + 5, layers, 1, p_idMap, null);
                JSONObject resQueryRectJson = new JSONObject(resQueryRect);
                if (resQueryRectJson.keys().hasNext())
                {
                    JSONArray results = resQueryRectJson.getJSONArray("oil");
                    if (results != null && results.length() > 0)
                    {
                        JSONObject values = results.getJSONObject(0);
                        
                        int idx_enominazione = -1;
                        int idx_entita_id = -1;
                        int idx_st_amm = -1;
                        int idx_st_num = -1;
                        int idx_st_samm = -1;
                        int idx_codpro = -1;
                        int idx_min_x = -1;
                        int idx_min_y = -1;
                        int idx_max_x = -1;
                        int idx_max_y = -1;
                        int idx_centr_x = -1;
                        int idx_centr_y = -1;
                        
                        JSONArray fields = values.getJSONObject("fields").getJSONArray("objs");
                        
                        for (int k = 0; k < fields.length(); k++)
                        {
                            if(fields.getString(k).equalsIgnoreCase("DENOMINAZI"))
                                idx_enominazione = k;
                            if(fields.getString(k).equalsIgnoreCase("ID_ENTITA"))
                                idx_entita_id = k;
                            if(fields.getString(k).equalsIgnoreCase("ST_AMM"))
                                idx_st_amm = k;
                            if(fields.getString(k).equalsIgnoreCase("ST_NUM"))
                                idx_st_num = k;
                            if(fields.getString(k).equalsIgnoreCase("ST_SAMM"))
                                idx_st_samm = k;
                            if(fields.getString(k).equalsIgnoreCase("ST_SAMM"))
                                idx_st_samm = k;
                            if(fields.getString(k).equalsIgnoreCase("CODPRO"))
                                idx_codpro = k;
                            if(fields.getString(k).equalsIgnoreCase("CODPRO"))
                                idx_codpro = k;
                            if(fields.getString(k).equalsIgnoreCase("MIN_X"))
                                idx_min_x = k;
                            if(fields.getString(k).equalsIgnoreCase("MIN_Y"))
                                idx_min_y = k;
                            if(fields.getString(k).equalsIgnoreCase("MAX_X"))
                                idx_max_x = k;
                            if(fields.getString(k).equalsIgnoreCase("MAX_Y"))
                                idx_max_y = k;
                            if(fields.getString(k).equalsIgnoreCase("CENTR_X"))
                                idx_centr_x = k;
                            if(fields.getString(k).equalsIgnoreCase("CENTR_y"))
                                idx_centr_y = k;
                        }
                                              
                        String denominazione = values.getJSONObject("values").getJSONArray("objs").getJSONObject(0).getJSONArray("objs").getString(idx_enominazione);
                        String entita_id = values.getJSONObject("values").getJSONArray("objs").getJSONObject(0).getJSONArray("objs").getString(idx_entita_id);
                        String st_amm = values.getJSONObject("values").getJSONArray("objs").getJSONObject(0).getJSONArray("objs").getString(idx_st_amm);
                        String st_num = values.getJSONObject("values").getJSONArray("objs").getJSONObject(0).getJSONArray("objs").getString(idx_st_num);
                        String st_samm = values.getJSONObject("values").getJSONArray("objs").getJSONObject(0).getJSONArray("objs").getString(idx_st_samm);
                        String codpro = values.getJSONObject("values").getJSONArray("objs").getJSONObject(0).getJSONArray("objs").getString(idx_codpro);
                        double min_x = values.getJSONObject("values").getJSONArray("objs").getJSONObject(0).getJSONArray("objs").getDouble(idx_min_x);
                        double min_y = values.getJSONObject("values").getJSONArray("objs").getJSONObject(0).getJSONArray("objs").getDouble(idx_min_y);
                        double max_x = values.getJSONObject("values").getJSONArray("objs").getJSONObject(0).getJSONArray("objs").getDouble(idx_max_x);
                        double max_y = values.getJSONObject("values").getJSONArray("objs").getJSONObject(0).getJSONArray("objs").getDouble(idx_max_y);
                        double centr_x = values.getJSONObject("values").getJSONArray("objs").getJSONObject(0).getJSONArray("objs").getDouble(idx_centr_x);
                        double centr_y = values.getJSONObject("values").getJSONArray("objs").getJSONObject(0).getJSONArray("objs").getDouble(idx_centr_y);
                        String sigla = "";
                        if (st_amm != null && !st_amm.isEmpty())
                            sigla += st_amm.trim().toUpperCase();
                        if (st_num != null && !st_num.isEmpty())
                            sigla += st_num.trim().substring(0, st_num.trim().length() - 2).toUpperCase();
                        if (st_samm != null && !st_samm.isEmpty())
                            sigla += st_samm.trim().toUpperCase();
                    
                        String provincia = getProvincia(codpro);
                        
                        String resQueryProg = queryProgJson(p_x, p_y, "ID_ENTITA='" + entita_id + "'", p_idLrs, "");
                        JSONObject resQueryProgJson = new JSONObject(resQueryProg);
                        double kmMin;
                        double kmMax;
                        double km;
                        kmMin = resQueryProgJson.getDouble("MMin");
                        kmMax = resQueryProgJson.getDouble("MMax");
                        km = resQueryProgJson.getDouble("m");
                        
                        /*if (codpro.equals("037"))
                        {
                            kmMin *= 1000;
                            kmMax *= 1000;
                            km += 1000;
                        }*/
                        
                        if (sigla.trim().length() > 0)
                            denominazione = sigla + ' ' + denominazione;
                        /*pointMinx = record.MIN_X;
                        pointMiny = record.MIN_Y;
                        pointMaxx = record.MAX_X;
                        pointMaxy = record.MAX_Y;
                        pointCentrx = record.CENTR_X;
                        pointCentry = record.CENTR_Y;
                        //strada e km
                        provincia = record.PROVINCIA;
                        comune = record.COMUNE;
                        denominazione = record.DENOMINAZIONE;
                        entitaId = '' + record.ENTITA_ID;
                        this.geocodingObject.sEntitaId = entitaId;

                        var link = document.createElement('a');
                        var indirizzo = "";
                        if (denominazione != null)
                            indirizzo = indirizzo + " " + denominazione.trim();
                        if (this.geocodingObject.sKm != null && entitaId.lastIndexOf('RT') + 2 == entitaId.length)
                            indirizzo = indirizzo + ', ' + this.geocodingObject.sKm;
                        link.href = '#';
                        link.innerHTML = indirizzo;*/
                        
                        
                        
                        ChilometricaRecord kmRecord = new ChilometricaRecord();
                        /*kmRecord.setMIN_X(BigDecimal.valueOf(min_x));
                        kmRecord.setMIN_Y(BigDecimal.valueOf(min_y));
                        kmRecord.setMAX_X(BigDecimal.valueOf(max_x));
                        kmRecord.setMAX_Y(BigDecimal.valueOf(max_y));
                        kmRecord.setCENTR_X(BigDecimal.valueOf(centr_x));
                        kmRecord.setCENTR_Y(BigDecimal.valueOf(centr_y));*/
                        kmRecord.setDENOMINAZIONE(denominazione);
                        kmRecord.setKM_MIN(BigDecimal.valueOf(kmMin));
                        kmRecord.setKM_MAX(BigDecimal.valueOf(kmMax));
                        kmRecord.setKM(BigDecimal.valueOf(km));
                        kmRecord.setPROVINCIA(provincia.toUpperCase());
                        kmRecord.setCOMUNE("Comune Generico");
                        kmRecord.setENTITA_ID(entita_id);
                        
                        //ricavo x e y
                        if (kmMin <= km && km <= kmMax) 
                        {
                            String sQueryXY = queryXYJson(entita_id, km, "", p_idLrs, "");
                            JSONObject resQueryXYJson = new JSONObject(sQueryXY);
                            if (resQueryXYJson.keys().hasNext())
                            {
                                kmRecord.setKM_X(BigDecimal.valueOf(resQueryXYJson.getDouble("x")));
                                kmRecord.setKM_Y(BigDecimal.valueOf(resQueryXYJson.getDouble("y")));
                            }
                        }
                        
                        ChilometricaRecord[] records = new ChilometricaRecord[1];
                        records[0] = kmRecord;
                        
                        ArrayOfChilometricaRecord recordSet = new ArrayOfChilometricaRecord(records);
                        
                        JSONObject res = new JSONObject(recordSet);
                        if (callback != null && callback.length() > 0)
                            return callback + "(" + res.toString() + ")";
                        else
                            return res.toString();
                    }
                    else
                    {
                        JSONObject res = new JSONObject();
                        if (callback != null && callback.length() > 0)
                            return callback + "(" + res.toString() + ")";
                        else
                        return res.toString();
                    }
                }
                else
                {
                    JSONObject res = new JSONObject();
                    if (callback != null && callback.length() > 0)
                        return callback + "(" + res.toString() + ")";
                    else
                    return res.toString();
                }
            }
            else if (p_tipo_loc.equalsIgnoreCase("Coordinate"))
            {
                if (p_check_comune)
                {
                    ArrayList<String> layers = new ArrayList<String>();
                    layers.add("COMUNI");
                    return queryRect4Json(p_x - 1, p_y - 1, p_x + 1, p_y + 1, layers, 5, p_idMap, callback);
                }
            }
            
            JSONObject res = new JSONObject();
            if (callback != null && callback.length() > 0)
                return callback + "(" + res.toString() + ")";
            else
                return res.toString();
        }
        catch (Exception exc)
        {
            this.scriviLog("Errore nella geolocInversa: " + exc.getMessage() + "\n");
            JSONObject res = new JSONObject();
            if (callback != null && callback.length() > 0)
                return callback + "(" + res.toString() + ")";
            else
                return res.toString();
        }
    }
    
    /**
     * La Norm_Incrocio richiede il toponimo, la provincia e  il comune delle
     * due strade di cui si vuole verificare un eventuale incrocio.
     * La procedura individuer� prima i due toponimi corrispondenti,
     * poi proceder� a trovare gli incroci corrispondenti ai toponimi
     * individuati.
     * @param p_toponimo1 String nome della strada della prima strada
     * @param p_comune1 String nome del comune della prima strada
     * @param p_provincia1 String nome o sigla  della provincia della prima strada
     * @param p_toponimo2 String nome della strada della seconda strada
     * @param p_comune2 String nome del comune della seconda strada
     * @param p_provincia2 String nome o sigla  della provincia della seconda strada
     * @param p_tipo_coord String Tipo di coordinata che si vuole venga restitutita (UTMA,WGS84,�)
     * @param handle String handle di connessione al normalizzatore
     * @param callback indica una chiamata jsonp
     * @return ArrayOfNormIncrocioRecord Array di rowset contenenti i risultati ottenuti
     * dal processo di normalizzazione. Se l'incrocio viene identificato univocamente,
     * il cursore conterr� solo l'incrocio individuato. Altrimenti verranno
     * restituiti pi� incroci, con associati il grado di affidabilit� del
     * risultato (0 = via identificata con certezza, > 0 incerto).
     * Le righe del cursore ritornato sono ordinate per livelli di
     * affidabilit� decrescenti.
     */
    @Path("/normIncrocioJson")
	@GET
	@Produces({"application/javascript"})
    public String normIncrocioJson(@QueryParam("p_toponimo1") String p_toponimo1,
                                                  @QueryParam("p_comune1") String p_comune1,
                                                  @QueryParam("p_provincia1") String p_provincia1,
                                                  @QueryParam("p_toponimo2") String p_toponimo2,
                                                  @QueryParam("p_comune2") String p_comune2,
                                                  @QueryParam("p_provincia2") String p_provincia2,
                                                  @QueryParam("p_tipo_coord") String p_tipo_coord,
                                                  @QueryParam("handle") String handle,
                                                  @QueryParam("callback") String callback)
    {
        scriviLog("Invocata normIncrocio(" + p_toponimo1 + "," + p_comune1 + "," + p_provincia1 + "," + p_toponimo2 + "," + p_comune2 + "," + p_provincia2 + "," + p_tipo_coord + "," + handle + ")");
        try {
            NormalizzatoreSoapPort norm = this.getNormalizzatoreSoapPort(handle);
            Norm_IncrocioInputParams i1ip = new Norm_IncrocioInputParams();
            if (!emptyString(handle))
                i1ip.setP_Handle(handle);
            if (!emptyString(p_toponimo1))
                i1ip.setP_Toponimo1(p_toponimo1);
            if (!emptyString(p_toponimo2))
                i1ip.setP_Toponimo2(p_toponimo2);
            if (!emptyString(p_comune1))
                i1ip.setP_Comune1(p_comune1);
            if (!emptyString(p_comune2))
                i1ip.setP_Comune2(p_comune2);
            if (!emptyString(p_provincia1))
                i1ip.setP_Provincia1(p_provincia1);
            if (!emptyString(p_provincia2))
                i1ip.setP_Provincia2(p_provincia2);
            if (!emptyString(p_tipo_coord))
                i1ip.setP_Tipo_Coord(p_tipo_coord);
            Norm_IncrocioInput i1i = new Norm_IncrocioInput(i1ip, null);
            Norm_IncrocioSoapInElement isie = new
                                                 Norm_IncrocioSoapInElement(i1i);
            Norm_IncrocioSoapOutElement isoe = norm.norm_Incrocio(isie);
            Norm_IncrocioOutputRecordsetArray iora = isoe.getNorm_IncrocioOutput().getNorm_IncrocioOutputRecordsetArray();
            NormIncrocioRecord[] records = new NormIncrocioRecord[iora.getNorm_IncrocioOutputRecordset().length];

            for (int i = 0; i < iora.getNorm_IncrocioOutputRecordset().length; i++) {
                NormIncrocioRecord r = new NormIncrocioRecord();
                r.setCOMUNE1(iora.getNorm_IncrocioOutputRecordset(i).getCOMUNE1());
                r.setCOMUNE2(iora.getNorm_IncrocioOutputRecordset(i).getCOMUNE2());
                r.setDENOMINAZIONE1(iora.getNorm_IncrocioOutputRecordset(i).getDENOMINAZIONE1());
                r.setDENOMINAZIONE2(iora.getNorm_IncrocioOutputRecordset(i).getDENOMINAZIONE2());
                r.setDUG1(iora.getNorm_IncrocioOutputRecordset(i).getDUG1());
                r.setDUG2(iora.getNorm_IncrocioOutputRecordset(i).getDUG2());
                r.setENTITA_ID1(iora.getNorm_IncrocioOutputRecordset(i).getENTITA_ID1());
                r.setENTITA_ID2(iora.getNorm_IncrocioOutputRecordset(i).getENTITA_ID2());
                r.setGR_AFFIDABILITA(iora.getNorm_IncrocioOutputRecordset(i).getGR_AFFIDABILITA());
                r.setGR_AFFIDABILITA1(iora.getNorm_IncrocioOutputRecordset(i).getGR_AFFIDABILITA1());
                r.setGR_AFFIDABILITA2(iora.getNorm_IncrocioOutputRecordset(i).getGR_AFFIDABILITA2());
                r.setINC_X(iora.getNorm_IncrocioOutputRecordset(i).getINC_X());
                r.setINC_Y(iora.getNorm_IncrocioOutputRecordset(i).getINC_Y());
                r.setINCROCIO_ID(iora.getNorm_IncrocioOutputRecordset(i).getINCROCIO_ID());
                r.setNODO_ID(iora.getNorm_IncrocioOutputRecordset(i).getNODO_ID());
                r.setNUMERO_RIGA(iora.getNorm_IncrocioOutputRecordset(i).getNUMERO_RIGA());
                r.setNUMERO_RIGHE(iora.getNorm_IncrocioOutputRecordset(i).getNUMERO_RIGHE());
                r.setPROVINCIA1(iora.getNorm_IncrocioOutputRecordset(i).getPROVINCIA1());
                r.setPROVINCIA2(iora.getNorm_IncrocioOutputRecordset(i).getPROVINCIA2());
                r.setREGIONE1(iora.getNorm_IncrocioOutputRecordset(i).getREGIONE1());
                r.setREGIONE2(iora.getNorm_IncrocioOutputRecordset(i).getREGIONE2());
                r.setTIPO_COORD(iora.getNorm_IncrocioOutputRecordset(i).getTIPO_COORD());
                records[i] = r;
            }
            ArrayOfNormIncrocioRecord recordSet = new ArrayOfNormIncrocioRecord(records);
            
            JSONObject res = new JSONObject(recordSet);
            if (callback != null && callback.length() > 0)
                return callback + "(" + res.toString() + ")";
            else
                return res.toString();
        }
        catch (Exception exc)
        {
            this.scriviLog("Errore nella normalizzazione dell'incrocio (normIncrocio): " + exc.getMessage() + "\n");
            JSONObject res = new JSONObject();
            if (callback != null && callback.length() > 0)
                return callback + "(" + res.toString() + ")";
            else
                return res.toString();
        }
    }

    @Path("/normIncrocio")
    @GET
    @Produces({"application/xml"})
    public ArrayOfNormIncrocioRecord normIncrocio(@QueryParam("p_toponimo1") String p_toponimo1, @QueryParam("p_comune1") String p_comune1, @QueryParam("p_provincia1") String p_provincia1, @QueryParam("p_toponimo2") String p_toponimo2, @QueryParam("p_comune2") String p_comune2, @QueryParam("p_provincia2") String p_provincia2, @QueryParam("p_tipo_coord") String p_tipo_coord, @QueryParam("handle") String handle) {
        scriviLog("Invocata normIncrocio(" + p_toponimo1 + "," + p_comune1 + "," + p_provincia1 + "," + p_toponimo2 + "," + p_comune2 + "," + p_provincia2 + "," + p_tipo_coord + "," + handle + ")");
        try {
            NormalizzatoreSoapPort norm = getNormalizzatoreSoapPort(handle);
            Norm_IncrocioInputParams i1ip = new Norm_IncrocioInputParams();
            if (!emptyString(handle)) {
                i1ip.setP_Handle(handle);
            }
            if (!emptyString(p_toponimo1)) {
                i1ip.setP_Toponimo1(p_toponimo1);
            }
            if (!emptyString(p_toponimo2)) {
                i1ip.setP_Toponimo2(p_toponimo2);
            }
            if (!emptyString(p_comune1)) {
                i1ip.setP_Comune1(p_comune1);
            }
            if (!emptyString(p_comune2)) {
                i1ip.setP_Comune2(p_comune2);
            }
            if (!emptyString(p_provincia1)) {
                i1ip.setP_Provincia1(p_provincia1);
            }
            if (!emptyString(p_provincia2)) {
                i1ip.setP_Provincia2(p_provincia2);
            }
            if (!emptyString(p_tipo_coord)) {
                i1ip.setP_Tipo_Coord(p_tipo_coord);
            }
            Norm_IncrocioInput i1i = new Norm_IncrocioInput(i1ip, null);
            Norm_IncrocioSoapInElement isie = new Norm_IncrocioSoapInElement(i1i);

            Norm_IncrocioSoapOutElement isoe = norm.norm_Incrocio(isie);
            Norm_IncrocioOutputRecordsetArray iora = isoe.getNorm_IncrocioOutput().getNorm_IncrocioOutputRecordsetArray();
            NormIncrocioRecord[] records = new NormIncrocioRecord[iora.getNorm_IncrocioOutputRecordset().length];
            for (int i = 0; i < iora.getNorm_IncrocioOutputRecordset().length; i++) {
                NormIncrocioRecord r = new NormIncrocioRecord();
                r.setCOMUNE1(iora.getNorm_IncrocioOutputRecordset(i).getCOMUNE1());
                r.setCOMUNE2(iora.getNorm_IncrocioOutputRecordset(i).getCOMUNE2());
                r.setDENOMINAZIONE1(iora.getNorm_IncrocioOutputRecordset(i).getDENOMINAZIONE1());
                r.setDENOMINAZIONE2(iora.getNorm_IncrocioOutputRecordset(i).getDENOMINAZIONE2());
                r.setDUG1(iora.getNorm_IncrocioOutputRecordset(i).getDUG1());
                r.setDUG2(iora.getNorm_IncrocioOutputRecordset(i).getDUG2());
                r.setENTITA_ID1(iora.getNorm_IncrocioOutputRecordset(i).getENTITA_ID1());
                r.setENTITA_ID2(iora.getNorm_IncrocioOutputRecordset(i).getENTITA_ID2());
                r.setGR_AFFIDABILITA(iora.getNorm_IncrocioOutputRecordset(i).getGR_AFFIDABILITA());
                r.setGR_AFFIDABILITA1(iora.getNorm_IncrocioOutputRecordset(i).getGR_AFFIDABILITA1());
                r.setGR_AFFIDABILITA2(iora.getNorm_IncrocioOutputRecordset(i).getGR_AFFIDABILITA2());
                r.setINC_X(iora.getNorm_IncrocioOutputRecordset(i).getINC_X());
                r.setINC_Y(iora.getNorm_IncrocioOutputRecordset(i).getINC_Y());
                r.setINCROCIO_ID(iora.getNorm_IncrocioOutputRecordset(i).getINCROCIO_ID());
                r.setNODO_ID(iora.getNorm_IncrocioOutputRecordset(i).getNODO_ID());
                r.setNUMERO_RIGA(iora.getNorm_IncrocioOutputRecordset(i).getNUMERO_RIGA());
                r.setNUMERO_RIGHE(iora.getNorm_IncrocioOutputRecordset(i).getNUMERO_RIGHE());
                r.setPROVINCIA1(iora.getNorm_IncrocioOutputRecordset(i).getPROVINCIA1());
                r.setPROVINCIA2(iora.getNorm_IncrocioOutputRecordset(i).getPROVINCIA2());
                r.setREGIONE1(iora.getNorm_IncrocioOutputRecordset(i).getREGIONE1());
                r.setREGIONE2(iora.getNorm_IncrocioOutputRecordset(i).getREGIONE2());
                r.setTIPO_COORD(iora.getNorm_IncrocioOutputRecordset(i).getTIPO_COORD());
                records[i] = r;
            }
            return new ArrayOfNormIncrocioRecord(records);
        } catch (Exception exc) {
            scriviLog("Errore nella normalizzazione dell'incrocio (normIncrocio): " + exc.getMessage() + "\n");
        }
        return null;
    }
  
    /**
     * La Get_Str_Geom consente di ottenere la coordinata di una strada
     * e il tipo di coordinata
     * @param p_entita_id String codice entita della strada
     * @param p_tipo_coord String tipo di coordinata che si vuole venga restitutita (UTMA,WGS84,�)
     * @param handle String handle di connessione al normalizzatore
     * @return Get_Str_GeomOutput
     */
    /*private GetStrGeomOutput get_Str_Geom(String p_entita_id, String p_tipo_coord, String handle)
    {
        try {
            //e_soapdispenser.normalizzatore.NormalizzatoreSoapPort norm = (e_soapdispenser.normalizzatore.NormalizzatoreSoapPort)
            //                                 WSSession.getNormalizzatore(handle);
            Normalizzatore normalizzatore = new Normalizzatore();
            NormalizzatoreSoapPort norm  = normalizzatore.getNormalizzatoreSoapPort();

            GetStrGeomInputParams i1ip = new GetStrGeomInputParams();
            if (!emptyString(handle))
                i1ip.setPHANDLE(handle);
            if (!emptyString(p_tipo_coord))
                i1ip.setPTIPOCOORD(p_tipo_coord);
            if (!emptyString(p_entita_id))
                i1ip.setPENTITAID(p_entita_id);
            GetStrGeomInput i1i = new GetStrGeomInput();
            i1i.setGetStrGeomInputParams(i1ip);
            GetStrGeomSoapInElement isie = new GetStrGeomSoapInElement();
            isie.setGetStrGeomInput(i1i);

            //return isoe.getGet_Str_GeomOutput();
            return null;
        }
        catch (Exception exc)
        {
            this.scriviLog("Errore nella richiesta della geometria della strada (Get_Str_Geom): " + exc.getMessage() + "\n");
            return null;
        }

    }*/


    /**
     * La Get_Civ_Geom consente di ottenere la coordinata di un civico e il tipo di coordinata eventuale incrocio.
     * @param p_entita_id String codice entita della strada
     * @param p_rif_geo_civ String
     * @param p_tipo_coord String tipo di coordinata che si vuole venga restitutita (UTMA,WGS84,�)
     * @param handle String handle di connessione al normalizzatore
     * @return Get_Civ_geomOutput
     */
    /*private GetCivGeomOutput get_Civ_Geom(String p_entita_id, String p_rif_geo_civ, String p_tipo_coord, String handle)
    {
        try {
            NormalizzatoreSoapPort norm = (NormalizzatoreSoapPort)
                                             WSSession.getNormalizzatore(handle);
            Get_Civ_geomInputParams i1ip = new Get_Civ_geomInputParams();
            if (!emptyString(handle))
                i1ip.setP_HANDLE(handle);
            if (!emptyString(p_entita_id))
                i1ip.setP_ENTITA_ID(p_entita_id);
            if (!emptyString(p_rif_geo_civ))
                i1ip.setP_RIF_GEO_CIV(p_rif_geo_civ);
            if (!emptyString(p_tipo_coord))
                i1ip.setP_TIPO_COORD(p_tipo_coord);
            Get_Civ_geomInput i1i = new Get_Civ_geomInput(i1ip, null);
            Get_Civ_geomSoapInElement isie = new Get_Civ_geomSoapInElement(i1i);
            Get_Civ_geomSoapOutElement isoe = norm.get_Civ_geom(isie);
            return isoe.getGet_Civ_geomOutput();
            return null;
        }
        catch (Exception exc)
        {
            this.scriviLog("Errore nella richiesta della geometria del civico (Get_Civ_geom): " + exc.getMessage() + "\n");
            return null;
        }

    }*/
    
     @Path("/normLuoghiNotevoli")
	@GET
	@Produces({ MediaType.APPLICATION_XML })
    public ArrayOfNormLuoghiNotevoliRecord normLuoghiNotevoli(@QueryParam("p_luogo") String p_luogo,
                                                    @QueryParam("p_comune") String p_comune,
                                                    @QueryParam("p_provincia") String p_provincia,
                                                    @QueryParam("p_cod_istat") String p_cod_istat,
                                                    @QueryParam("p_cod_nazionale") String p_cod_nazionale,
                                                    @QueryParam("p_cod_catastale") String p_cod_catastale,
                                                    @QueryParam("p_tipo_coord") String p_tipo_coord,
                                                    @QueryParam("handle") String handle)
    {
        scriviLog("Invocata normLuoghiNotevoli(" + p_luogo + "," + p_comune + "," + p_provincia + "," + p_cod_istat + "," + p_cod_nazionale + "," + p_cod_catastale + "," + p_tipo_coord + "," + handle + ")");
        try {
            NormalizzatoreSoapPort norm = this.getNormalizzatoreSoapPort(handle);
            Norm_Luoghi_NotevoliInputParams i1ip = new Norm_Luoghi_NotevoliInputParams();
            if (!emptyString(handle))
                i1ip.setP_Handle(handle);
            if (!emptyString(p_luogo))
                i1ip.setP_Luogo(p_luogo);
            if (!emptyString(p_comune))
                i1ip.setP_Comune(p_comune);
            if (!emptyString(p_provincia))
                i1ip.setP_Provincia(p_provincia);
            if (!emptyString(p_cod_istat))
                i1ip.setP_Cod_Istat(p_cod_istat);
            if (!emptyString(p_cod_nazionale))
                i1ip.setP_Cod_Nazionale(p_cod_nazionale);
            if (!emptyString(p_cod_catastale))
                i1ip.setP_Cod_Catastale(p_cod_catastale);
            if (!emptyString(p_tipo_coord))
                i1ip.setP_Tipo_Coord(p_tipo_coord);
            Norm_Luoghi_NotevoliInput i1i = new Norm_Luoghi_NotevoliInput(i1ip, null);
            Norm_Luoghi_NotevoliSoapInElement i1sie = new
                                                 Norm_Luoghi_NotevoliSoapInElement(
                    i1i);
            Norm_Luoghi_NotevoliSoapOutElement i1soe = norm.norm_Luoghi_Notevoli(i1sie);
            Norm_Luoghi_NotevoliOutputRecordsetArray i1ora = i1soe.getNorm_Luoghi_NotevoliOutput().getNorm_Luoghi_NotevoliOutputRecordsetArray();
            NormLuoghiNotevoliRecord[] records = new NormLuoghiNotevoliRecord[i1ora.getNorm_Luoghi_NotevoliOutputRecordset().length];

             for (int i = 0; i < i1ora.getNorm_Luoghi_NotevoliOutputRecordset().length; i++) {
                 NormLuoghiNotevoliRecord r = new NormLuoghiNotevoliRecord();
                 r.setCENTR_X(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getCENTR_X());
                 r.setDESCRIZ_UFF(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getDESCRIZ_UFF());
                 r.setCENTR_Y(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getCENTR_Y());
                 r.setCOMUNE(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getCOMUNE());
                 r.setDENOMINAZIONE(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getDENOMINAZIONE());
                 r.setDUG(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getDUG());
                 r.setENTITA_ID(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getENTITA_ID());
                 r.setGR_AFFIDABILITA(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getGR_AFFIDABILITA());
                 r.setMAX_X(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getMAX_X());
                 r.setMAX_Y(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getMAX_Y());
                 r.setMIN_X(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getMIN_X());
                 r.setMIN_Y(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getMIN_Y());
                 r.setNUMERO_RIGA(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getNUMERO_RIGA());
                 r.setNUMERO_RIGHE(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getNUMERO_RIGHE());
                 r.setPROVINCIA(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getPROVINCIA());
                 r.setREGIONE(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getREGIONE());
                 r.setSTRADARIO_ID(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getSTRADARIO_ID());
                 r.setTIPO_COORD(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getTIPO_COORD());
                 r.setTIPO_STRADA(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getTIPO_STRADA());
                 records[i] = r;
             }
             ArrayOfNormLuoghiNotevoliRecord recordSet = new ArrayOfNormLuoghiNotevoliRecord(records);
             return recordSet;
        }
        catch (Exception exc)
        {
            this.scriviLog("Errore nella normalizzazione dell'indirizzo (normIndirizzo): " + exc.getMessage() + "\n");
            return null;
        }
    }
    
    @Path("/normLuoghiNotevoliJson")
	@GET
	@Produces({"application/javascript"})
    public String normLuoghiNotevoliJson(@QueryParam("p_luogo") String p_luogo,
                                                    @QueryParam("p_comune") String p_comune,
                                                    @QueryParam("p_provincia") String p_provincia,
                                                    @QueryParam("p_cod_istat") String p_cod_istat,
                                                    @QueryParam("p_cod_nazionale") String p_cod_nazionale,
                                                    @QueryParam("p_cod_catastale") String p_cod_catastale,
                                                    @QueryParam("p_tipo_coord") String p_tipo_coord,
                                                    @QueryParam("handle") String handle,
                                                    @QueryParam("callback") String callback)
    {
        scriviLog("Invocata normLuoghiNotevoliJson(" + p_luogo + "," + p_comune + "," + p_provincia + "," + p_cod_istat + "," + p_cod_nazionale + "," + p_cod_catastale + "," + p_tipo_coord + "," + handle + ")");
        try {
            NormalizzatoreSoapPort norm = this.getNormalizzatoreSoapPort(handle);
            Norm_Luoghi_NotevoliInputParams i1ip = new Norm_Luoghi_NotevoliInputParams();
            if (!emptyString(handle))
                i1ip.setP_Handle(handle);
            if (!emptyString(p_luogo))
                i1ip.setP_Luogo(p_luogo);
            if (!emptyString(p_comune))
                i1ip.setP_Comune(p_comune);
            if (!emptyString(p_provincia))
                i1ip.setP_Provincia(p_provincia);
            if (!emptyString(p_cod_istat))
                i1ip.setP_Cod_Istat(p_cod_istat);
            if (!emptyString(p_cod_nazionale))
                i1ip.setP_Cod_Nazionale(p_cod_nazionale);
            if (!emptyString(p_cod_catastale))
                i1ip.setP_Cod_Catastale(p_cod_catastale);
            if (!emptyString(p_tipo_coord))
                i1ip.setP_Tipo_Coord(p_tipo_coord);
            Norm_Luoghi_NotevoliInput i1i = new Norm_Luoghi_NotevoliInput(i1ip, null);
            Norm_Luoghi_NotevoliSoapInElement i1sie = new
                                                 Norm_Luoghi_NotevoliSoapInElement(
                    i1i);
            Norm_Luoghi_NotevoliSoapOutElement i1soe = norm.norm_Luoghi_Notevoli(i1sie);
            Norm_Luoghi_NotevoliOutputRecordsetArray i1ora = i1soe.getNorm_Luoghi_NotevoliOutput().getNorm_Luoghi_NotevoliOutputRecordsetArray();
            NormLuoghiNotevoliRecord[] records = new NormLuoghiNotevoliRecord[i1ora.getNorm_Luoghi_NotevoliOutputRecordset().length];

             for (int i = 0; i < i1ora.getNorm_Luoghi_NotevoliOutputRecordset().length; i++) {
                 NormLuoghiNotevoliRecord r = new NormLuoghiNotevoliRecord();
                 r.setCENTR_X(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getCENTR_X());
                 r.setDESCRIZ_UFF(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getDESCRIZ_UFF());
                 r.setCENTR_Y(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getCENTR_Y());
                 r.setCOMUNE(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getCOMUNE());
                 r.setDENOMINAZIONE(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getDENOMINAZIONE());
                 r.setDUG(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getDUG());
                 r.setENTITA_ID(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getENTITA_ID());
                 r.setGR_AFFIDABILITA(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getGR_AFFIDABILITA());
                 r.setMAX_X(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getMAX_X());
                 r.setMAX_Y(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getMAX_Y());
                 r.setMIN_X(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getMIN_X());
                 r.setMIN_Y(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getMIN_Y());
                 r.setNUMERO_RIGA(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getNUMERO_RIGA());
                 r.setNUMERO_RIGHE(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getNUMERO_RIGHE());
                 r.setPROVINCIA(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getPROVINCIA());
                 r.setREGIONE(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getREGIONE());
                 r.setSTRADARIO_ID(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getSTRADARIO_ID());
                 r.setTIPO_COORD(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getTIPO_COORD());
                 r.setTIPO_STRADA(i1ora.getNorm_Luoghi_NotevoliOutputRecordset(i).getTIPO_STRADA());
                 records[i] = r;
             }
             ArrayOfNormLuoghiNotevoliRecord recordSet = new ArrayOfNormLuoghiNotevoliRecord(records);
             
             JSONObject res = new JSONObject(recordSet);
             if (callback != null && callback.length() > 0)
                return callback + "(" + res.toString() + ")";
             else
                 return res.toString();
        }
        catch (Exception exc)
        {
            this.scriviLog("Errore nella normalizzazione del luogo notevole (normLuoghiNotevoli): " + exc.getMessage() + "\n");
            JSONObject res = new JSONObject();
            if (callback != null && callback.length() > 0)
                return callback + "(" + res.toString() + ")";
            else
                return res.toString();
        }
    }
    

    /**
     * La Norm_Indirizzo richiede il toponimo della strada separato dal numero
     * civico (con eventuale suffisso). Alla funzione verranno inoltre forniti:
     * il nome del comune e/o nome/sigla della provincia oppure il codice
     * istat del comune o il codice nazionale o quello catastale
     * @param p_luogo String nome della strada. Come ultimo elemento deve contenere un civico con eventuale suffisso
     * @param p_comune String eventuale nome del comune
     * @param p_civico String eventuale numero civico
     * @param p_provincia String eventuale nome o alla sigla della provincia
     * @param p_cod_istat String eventuale Codice ISTAT del Comune
     * @param p_cod_nazionale String eventuale Codice nazionale del comune (agenzia del territorio)
     * @param p_cod_catastale String eventuale Codice catastale del comune (agenzia del territorio)
     * @param p_tipo_coord String tipo di coordinata che si vuole venga restitutita (UTMA,WGS84,�)nc1i
     * @param p_rif_geo_civ String tipo di coordinata del civico che si vuole venga restitutita (ECIV,PCIV,�)
     * @param handle String handle di connessione al normalizzatore
     * @param callback String indica una chiamata jsonp
     * @return ArrayOfNormIndirizzoRecord Array di rowset contenenti i risultati ottenuti
     * dal processo di normalizzazione. Un rowset conterr� gli indirizzi ottenuti
     * tramite gli algoritmi di ricerca. Se l'indirizzo viene identificato
     * univocamente, il cursore conterr� solo l'indirizzo individuato.
     * Altrimenti verranno restituiti pi� indirizzi, con associati il grado di
     * affidabilit� del risultato (0 = via identificata con certezza,
     * > 0 incerto). Le righe del cursore ritornato sono ordinati per livelli
     * di affidabilit� decrescenti. Il grado di affidabilit� non � direttamente
     * influenzato dal numero civico: per sapere se il civico � stato
     * identificato o no si deve guardare il campo CIVICO_ID, che sar� a NULL
     * in caso in cui la ricerca fallisca e verificare il grado di affidabilit�
     * del civico. Il suffisso viene individuato tramite una funzione apposita,
     * separatamente quindi dal civico, in modo da poter identificare civici
     * anche se hanno il suffisso sbagliato. Nel caso di ricerca di un civico
     * di una localit�, se non viene trovato, verr� riportato (se inserito in
     * tabella dalla procedura di aggiornamento della GEO_T_CIVICI) il civico
     * numero 0, che rappresenta il punto centrale della localit�.
     */
    @Path("/normIndirizzoJson")
	@GET
	@Produces({"application/javascript"})
    //public ArrayOfNormIndirizzoRecord normIndirizzo(@QueryParam("p_toponimo") String p_toponimo,
    public String normIndirizzoJson(@QueryParam("p_toponimo") String p_toponimo,
                                                    @QueryParam("p_comune") String p_comune,
                                                    @QueryParam("p_civico") String p_civico,
                                                    @QueryParam("p_provincia") String p_provincia,
                                                    @QueryParam("p_cod_istat") String p_cod_istat,
                                                    @QueryParam("p_cod_nazionale") String p_cod_nazionale,
                                                    @QueryParam("p_cod_catastale") String p_cod_catastale,
                                                    @QueryParam("p_tipo_coord") String p_tipo_coord,
                                                    @QueryParam("p_rif_geo_civ") String p_rif_geo_civ,
                                                    @QueryParam("handle") String handle,
                                                    @QueryParam("callback") String callback)
    {
        scriviLog("Invocata normIndirizzo(" + p_toponimo + "," + p_comune + "," + p_civico + "," + p_provincia + "," + p_cod_istat + "," + p_cod_nazionale + "," + p_cod_catastale + "," + p_tipo_coord + "," + p_rif_geo_civ + "," + handle + ")");
        try {
            NormalizzatoreSoapPort norm = this.getNormalizzatoreSoapPort(handle);
            Norm_IndirizzoInputParams i1ip = new Norm_IndirizzoInputParams();
            if (!emptyString(handle))
                i1ip.setP_Handle(handle);
            if (!emptyString(p_toponimo))
                i1ip.setP_Toponimo(p_toponimo);
            if (!emptyString(p_comune))
                i1ip.setP_Comune(p_comune);
            if (!emptyString(p_civico))
                i1ip.setP_Civico(p_civico);
            if (!emptyString(p_provincia))
                i1ip.setP_Provincia(p_provincia);
            if (!emptyString(p_cod_istat))
                i1ip.setP_Cod_Istat(p_cod_istat);
            if (!emptyString(p_cod_nazionale))
                i1ip.setP_Cod_Nazionale(p_cod_nazionale);
            if (!emptyString(p_cod_catastale))
                i1ip.setP_Cod_Catastale(p_cod_catastale);
            if (!emptyString(p_tipo_coord))
                i1ip.setP_Tipo_Coord(p_tipo_coord);
            if (!emptyString(p_rif_geo_civ))
                i1ip.setP_Rif_Geo_Civ(p_rif_geo_civ);
            Norm_IndirizzoInput i1i = new Norm_IndirizzoInput(i1ip, null);
            Norm_IndirizzoSoapInElement i1sie = new
                                                 Norm_IndirizzoSoapInElement(
                    i1i);
            Norm_IndirizzoSoapOutElement i1soe = norm.norm_Indirizzo(i1sie);
            Norm_IndirizzoOutputRecordsetArray i1ora = i1soe.getNorm_IndirizzoOutput().getNorm_IndirizzoOutputRecordsetArray();
            NormIndirizzoRecord[] records = new NormIndirizzoRecord[i1ora.getNorm_IndirizzoOutputRecordset().length];

             for (int i = 0; i < i1ora.getNorm_IndirizzoOutputRecordset().length; i++) {
                 NormIndirizzoRecord r = new NormIndirizzoRecord();
                 r.setCENTR_X(i1ora.getNorm_IndirizzoOutputRecordset(i).getCENTR_X());
                 r.setCENTR_Y(i1ora.getNorm_IndirizzoOutputRecordset(i).getCENTR_Y());
                 r.setCIVICO_ARCO_ID(i1ora.getNorm_IndirizzoOutputRecordset(i).getCIVICO_ARCO_ID());
                 r.setCIVICO_ID(i1ora.getNorm_IndirizzoOutputRecordset(i).getCIVICO_ID());
                 r.setCIVICO_X(i1ora.getNorm_IndirizzoOutputRecordset(i).getCIVICO_X());
                 r.setCIVICO_Y(i1ora.getNorm_IndirizzoOutputRecordset(i).getCIVICO_Y());
                 r.setCOMUNE(i1ora.getNorm_IndirizzoOutputRecordset(i).getCOMUNE());
                 r.setDENOMINAZIONE(i1ora.getNorm_IndirizzoOutputRecordset(i).getDENOMINAZIONE());
                 r.setDESCRIZIONE_CIVICO(i1ora.getNorm_IndirizzoOutputRecordset(i).getDESCRIZIONE_CIVICO());
                 r.setDUG(i1ora.getNorm_IndirizzoOutputRecordset(i).getDUG());
                 r.setENTITA_CIVICO_ID(i1ora.getNorm_IndirizzoOutputRecordset(i).getENTITA_CIVICO_ID());
                 r.setENTITA_ID(i1ora.getNorm_IndirizzoOutputRecordset(i).getENTITA_ID());
                 r.setGR_AFFIDABILITA(i1ora.getNorm_IndirizzoOutputRecordset(i).getGR_AFFIDABILITA());
                 r.setGR_AFFIDABILITA_CIV(i1ora.getNorm_IndirizzoOutputRecordset(i).getGR_AFFIDABILITA_CIV());
                 r.setMAX_X(i1ora.getNorm_IndirizzoOutputRecordset(i).getMAX_X());
                 r.setMAX_Y(i1ora.getNorm_IndirizzoOutputRecordset(i).getMAX_Y());
                 r.setMIN_X(i1ora.getNorm_IndirizzoOutputRecordset(i).getMIN_X());
                 r.setMIN_Y(i1ora.getNorm_IndirizzoOutputRecordset(i).getMIN_Y());
                 r.setNUM_CIVICO(i1ora.getNorm_IndirizzoOutputRecordset(i).getNUM_CIVICO());
                 r.setNUMERO_RIGA(i1ora.getNorm_IndirizzoOutputRecordset(i).getNUMERO_RIGA());
                 r.setNUMERO_RIGHE(i1ora.getNorm_IndirizzoOutputRecordset(i).getNUMERO_RIGHE());
                 r.setPROVINCIA(i1ora.getNorm_IndirizzoOutputRecordset(i).getPROVINCIA());
                 r.setREGIONE(i1ora.getNorm_IndirizzoOutputRecordset(i).getREGIONE());
                 r.setRIF_GEO_CIV(i1ora.getNorm_IndirizzoOutputRecordset(i).getRIF_GEO_CIV());
                 r.setSTRADARIO_ID(i1ora.getNorm_IndirizzoOutputRecordset(i).getSTRADARIO_ID());
                 r.setSUFFISSO_CIVICO(i1ora.getNorm_IndirizzoOutputRecordset(i).getSUFFISSO_CIVICO());
                 r.setTIPO_COORD(i1ora.getNorm_IndirizzoOutputRecordset(i).getTIPO_COORD());
                 r.setTIPO_STRADA(i1ora.getNorm_IndirizzoOutputRecordset(i).getTIPO_STRADA());
                 records[i] = r;
             }
             ArrayOfNormIndirizzoRecord recordSet = new ArrayOfNormIndirizzoRecord(records);
             
             JSONObject res = new JSONObject(recordSet);
             if (callback != null && callback.length() > 0)
                return callback + "(" + res.toString() + ")";
             else
                 return res.toString();
        }
        catch (Exception exc)
        {
            this.scriviLog("Errore nella normalizzazione dell'indirizzo (normIndirizzo): " + exc.getMessage() + "\n");
            JSONObject res = new JSONObject();
            if (callback != null && callback.length() > 0)
                return callback + "(" + res.toString() + ")";
            else
                return res.toString();
        }
    }
    
    @Path("/normIndirizzo")
    @GET
    @Produces({"application/xml"})
    public ArrayOfNormIndirizzoRecord normIndirizzo(@QueryParam("p_toponimo") String p_toponimo, @QueryParam("p_comune") String p_comune, @QueryParam("p_civico") String p_civico, @QueryParam("p_provincia") String p_provincia, @QueryParam("p_cod_istat") String p_cod_istat, @QueryParam("p_cod_nazionale") String p_cod_nazionale, @QueryParam("p_cod_catastale") String p_cod_catastale, @QueryParam("p_tipo_coord") String p_tipo_coord, @QueryParam("p_rif_geo_civ") String p_rif_geo_civ, @QueryParam("handle") String handle) {
        scriviLog("Invocata normIndirizzo(" + p_toponimo + "," + p_comune + "," + p_civico + "," + p_provincia + "," + p_cod_istat + "," + p_cod_nazionale + "," + p_cod_catastale + "," + p_tipo_coord + "," + p_rif_geo_civ + "," + handle + ")");
        try {
            NormalizzatoreSoapPort norm = getNormalizzatoreSoapPort(handle);
            Norm_IndirizzoInputParams i1ip = new Norm_IndirizzoInputParams();
            if (!emptyString(handle)) {
                i1ip.setP_Handle(handle);
            }
            if (!emptyString(p_toponimo)) {
                i1ip.setP_Toponimo(p_toponimo);
            }
            if (!emptyString(p_comune)) {
                i1ip.setP_Comune(p_comune);
            }
            if (!emptyString(p_civico)) {
                i1ip.setP_Civico(p_civico);
            }
            if (!emptyString(p_provincia)) {
                i1ip.setP_Provincia(p_provincia);
            }
            if (!emptyString(p_cod_istat)) {
                i1ip.setP_Cod_Istat(p_cod_istat);
            }
            if (!emptyString(p_cod_nazionale)) {
                i1ip.setP_Cod_Nazionale(p_cod_nazionale);
            }
            if (!emptyString(p_cod_catastale)) {
                i1ip.setP_Cod_Catastale(p_cod_catastale);
            }
            if (!emptyString(p_tipo_coord)) {
                i1ip.setP_Tipo_Coord(p_tipo_coord);
            }
            if (!emptyString(p_rif_geo_civ)) {
                i1ip.setP_Rif_Geo_Civ(p_rif_geo_civ);
            }
            Norm_IndirizzoInput i1i = new Norm_IndirizzoInput(i1ip, null);
            Norm_IndirizzoSoapInElement i1sie = new Norm_IndirizzoSoapInElement(i1i);

            Norm_IndirizzoSoapOutElement i1soe = norm.norm_Indirizzo(i1sie);
            Norm_IndirizzoOutputRecordsetArray i1ora = i1soe.getNorm_IndirizzoOutput().getNorm_IndirizzoOutputRecordsetArray();
            NormIndirizzoRecord[] records = new NormIndirizzoRecord[i1ora.getNorm_IndirizzoOutputRecordset().length];
            for (int i = 0; i < i1ora.getNorm_IndirizzoOutputRecordset().length; i++) {
                NormIndirizzoRecord r = new NormIndirizzoRecord();
                r.setCENTR_X(i1ora.getNorm_IndirizzoOutputRecordset(i).getCENTR_X());
                r.setCENTR_Y(i1ora.getNorm_IndirizzoOutputRecordset(i).getCENTR_Y());
                r.setCIVICO_ARCO_ID(i1ora.getNorm_IndirizzoOutputRecordset(i).getCIVICO_ARCO_ID());
                r.setCIVICO_ID(i1ora.getNorm_IndirizzoOutputRecordset(i).getCIVICO_ID());
                r.setCIVICO_X(i1ora.getNorm_IndirizzoOutputRecordset(i).getCIVICO_X());
                r.setCIVICO_Y(i1ora.getNorm_IndirizzoOutputRecordset(i).getCIVICO_Y());
                r.setCOMUNE(i1ora.getNorm_IndirizzoOutputRecordset(i).getCOMUNE());
                r.setDENOMINAZIONE(i1ora.getNorm_IndirizzoOutputRecordset(i).getDENOMINAZIONE());
                r.setDESCRIZIONE_CIVICO(i1ora.getNorm_IndirizzoOutputRecordset(i).getDESCRIZIONE_CIVICO());
                r.setDUG(i1ora.getNorm_IndirizzoOutputRecordset(i).getDUG());
                r.setENTITA_CIVICO_ID(i1ora.getNorm_IndirizzoOutputRecordset(i).getENTITA_CIVICO_ID());
                r.setENTITA_ID(i1ora.getNorm_IndirizzoOutputRecordset(i).getENTITA_ID());
                r.setGR_AFFIDABILITA(i1ora.getNorm_IndirizzoOutputRecordset(i).getGR_AFFIDABILITA());
                r.setGR_AFFIDABILITA_CIV(i1ora.getNorm_IndirizzoOutputRecordset(i).getGR_AFFIDABILITA_CIV());
                r.setMAX_X(i1ora.getNorm_IndirizzoOutputRecordset(i).getMAX_X());
                r.setMAX_Y(i1ora.getNorm_IndirizzoOutputRecordset(i).getMAX_Y());
                r.setMIN_X(i1ora.getNorm_IndirizzoOutputRecordset(i).getMIN_X());
                r.setMIN_Y(i1ora.getNorm_IndirizzoOutputRecordset(i).getMIN_Y());
                r.setNUM_CIVICO(i1ora.getNorm_IndirizzoOutputRecordset(i).getNUM_CIVICO());
                r.setNUMERO_RIGA(i1ora.getNorm_IndirizzoOutputRecordset(i).getNUMERO_RIGA());
                r.setNUMERO_RIGHE(i1ora.getNorm_IndirizzoOutputRecordset(i).getNUMERO_RIGHE());
                r.setPROVINCIA(i1ora.getNorm_IndirizzoOutputRecordset(i).getPROVINCIA());
                r.setREGIONE(i1ora.getNorm_IndirizzoOutputRecordset(i).getREGIONE());
                r.setRIF_GEO_CIV(i1ora.getNorm_IndirizzoOutputRecordset(i).getRIF_GEO_CIV());
                r.setSTRADARIO_ID(i1ora.getNorm_IndirizzoOutputRecordset(i).getSTRADARIO_ID());
                r.setSUFFISSO_CIVICO(i1ora.getNorm_IndirizzoOutputRecordset(i).getSUFFISSO_CIVICO());
                r.setTIPO_COORD(i1ora.getNorm_IndirizzoOutputRecordset(i).getTIPO_COORD());
                r.setTIPO_STRADA(i1ora.getNorm_IndirizzoOutputRecordset(i).getTIPO_STRADA());
                records[i] = r;
            }
            return new ArrayOfNormIndirizzoRecord(records);
        } catch (Exception exc) {
            scriviLog("Errore nella normalizzazione dell'indirizzo (normIndirizzo): " + exc.getMessage() + "\n");
        }
        return null;
    }
  
    /**
     * La norm_Indirizzo1 consente di passare come parametro il toponimo della strada unito al numero
     * civico (con eventuale suffisso). Il numero civico deve esserci, e deve essere scritto nella parte
     * terminale della stringa. Alla funzione verranno inoltre forniti il nome del comune e/o nome/sigla della provincia
     * oppure il codice istat del comune o il codice nazionale o quello catastale
     * @param p_toponimo String nome della strada. Come ultimo elemento deve contenere un civico con eventuale suffisso
     * @param p_comune String eventuale nome del comune
     * @param p_provincia String eventuale nome o alla sigla della provincia
     * @param p_cod_istat String eventuale Codice ISTAT del Comune
     * @param p_cod_nazionale String eventuale Codice nazionale del comune (agenzia del territorio)
     * @param p_cod_catastale String eventuale Codice catastale del comune (agenzia del territorio)
     * @param handle String handle di connessione al normalizzatore
     * @param callback String indica una chiamata jsonp
     * @return ArrayOfNormIndirizzo1Record Array di rowset contenenti i risultati ottenuti
     * dal processo di normalizzazione. Un rowset conterr� gli indirizzi ottenuti tramite gli algoritmi di ricerca.
     * Se l'indirizzo viene identificato univocamente, il cursore conterr� solo l'indirizzo individuato.
     * Altrimenti verranno restituiti pi� indirizzi, con associati il grado di affidabilit� del risultato
     * (0 = via identificata con certezza, > 0 incerto). Le righe del cursore ritornato sono ordinate
     * per livelli di affidabilit� decrescenti. Il grado di affidabilit� non � direttamente influenzato
     * dal numero civico: per sapere se il civico � stato identificato o no si deve guardare
     * il campo CIVICO_ID, che sar� a NULL in caso in cui la ricerca fallisca e verificare
     * il grado di affidabilit� del civico. Il suffisso viene individuato tramite
     * una funzione apposita, separatamente quindi dal civico, in modo da poter
     * identificare civici anche se hanno il suffisso sbagliato. Nel caso di ricerca
     * di un civico di una localit�, se non viene trovato, verr� riportato
     * (se inserito in tabella dalla procedura di aggiornamento della GEO_T_CIVICI) il
     * civico numero 0, che rappresenta il punto centrale della localit�.
     */
    @Path("/normIndirizzo1Json")
	@GET
	@Produces({"application/javascript"})
    public String normIndirizzo1Json(@QueryParam("p_toponimo") String p_toponimo,
                                                      @QueryParam("p_comune") String p_comune,
                                                      @QueryParam("p_provincia") String p_provincia,
                                                      @QueryParam("p_cod_istat") String p_cod_istat,
                                                      @QueryParam("p_cod_nazionale") String p_cod_nazionale,
                                                      @QueryParam("p_cod_catastale") String p_cod_catastale,
                                                      @QueryParam("handle") String handle,
                                                      @QueryParam("callback") String callback)
    {
        scriviLog("Invocata normIndirizzo1(" + p_toponimo + "," + p_comune + "," + p_provincia + "," + p_cod_istat + "," + p_cod_nazionale + "," + p_cod_catastale + "," + handle + ")");
        try {
            NormalizzatoreSoapPort norm = this.getNormalizzatoreSoapPort(handle);
            Norm_Indirizzo1InputParams i1ip = new Norm_Indirizzo1InputParams();
            if (!emptyString(handle))
                i1ip.setP_Handle(handle);
            if (!emptyString(p_toponimo))
                i1ip.setP_Toponimo(p_toponimo);
            if (!emptyString(p_comune))
                i1ip.setP_Comune(p_comune);
            if (!emptyString(p_provincia))
                i1ip.setP_Provincia(p_provincia);
            if (!emptyString(p_cod_istat))
                i1ip.setP_Cod_Istat(p_cod_istat);
            if (!emptyString(p_cod_nazionale))
                i1ip.setP_Cod_Nazionale(p_cod_nazionale);
            if (!emptyString(p_cod_catastale))
                i1ip.setP_Cod_Catastale(p_cod_catastale);
            Norm_Indirizzo1Input i1i = new Norm_Indirizzo1Input(i1ip, null);
            Norm_Indirizzo1SoapInElement i1sie = new
                                                 Norm_Indirizzo1SoapInElement(
                    i1i);
            Norm_Indirizzo1SoapOutElement i1soe = norm.norm_Indirizzo1(i1sie);
            Norm_Indirizzo1OutputRecordsetArray i1ora = i1soe.getNorm_Indirizzo1Output().getNorm_Indirizzo1OutputRecordsetArray();
            NormIndirizzo1Record[] records = new NormIndirizzo1Record[i1ora.getNorm_Indirizzo1OutputRecordset().length];

            for (int i = 0; i < i1ora.getNorm_Indirizzo1OutputRecordset().length; i++) {
                NormIndirizzo1Record r = new NormIndirizzo1Record();
                r.setCivico_Arco_Id(i1ora.getNorm_Indirizzo1OutputRecordset(i).getCivico_Arco_Id());
                r.setCIVICO_ID(i1ora.getNorm_Indirizzo1OutputRecordset(i).getCIVICO_ID());
                r.setCivico_Lat_Wgs84(i1ora.getNorm_Indirizzo1OutputRecordset(i).getCivico_Lat_Wgs84());
                r.setCivico_Lng_Wgs84(i1ora.getNorm_Indirizzo1OutputRecordset(i).getCivico_Lng_Wgs84());
                r.setCivico_x_Utma(i1ora.getNorm_Indirizzo1OutputRecordset(i).getCivico_x_Utma());
                r.setCivico_y_Utma(i1ora.getNorm_Indirizzo1OutputRecordset(i).getCivico_y_Utma());
                r.setCOMUNE(i1ora.getNorm_Indirizzo1OutputRecordset(i).getCOMUNE());
                r.setDENOMINAZIONE(i1ora.getNorm_Indirizzo1OutputRecordset(i).getDENOMINAZIONE());
                r.setDUG(i1ora.getNorm_Indirizzo1OutputRecordset(i).getDUG());
                r.setGR_AFFIDABILITA(i1ora.getNorm_Indirizzo1OutputRecordset(i).getGR_AFFIDABILITA());
                r.setGR_AFFIDABILITA_CIV(i1ora.getNorm_Indirizzo1OutputRecordset(i).getGR_AFFIDABILITA_CIV());
                r.setMax_Lat_Wgs84(i1ora.getNorm_Indirizzo1OutputRecordset(i).getMax_Lat_Wgs84());
                r.setMax_Lng_Wgs84(i1ora.getNorm_Indirizzo1OutputRecordset(i).getMax_Lng_Wgs84());
                r.setMax_x_Utma(i1ora.getNorm_Indirizzo1OutputRecordset(i).getMax_x_Utma());
                r.setMax_y_Utma(i1ora.getNorm_Indirizzo1OutputRecordset(i).getMax_y_Utma());
                r.setMin_Lat_Wgs84(i1ora.getNorm_Indirizzo1OutputRecordset(i).getMin_Lat_Wgs84());
                r.setMin_Lng_Wgs84(i1ora.getNorm_Indirizzo1OutputRecordset(i).getMin_Lng_Wgs84());
                r.setMin_x_Utma(i1ora.getNorm_Indirizzo1OutputRecordset(i).getMin_x_Utma());
                r.setMin_y_Utma(i1ora.getNorm_Indirizzo1OutputRecordset(i).getMin_y_Utma());
                r.setNUM_CIVICO(i1ora.getNorm_Indirizzo1OutputRecordset(i).getNUM_CIVICO());
                r.setNUMERO_RIGA(i1ora.getNorm_Indirizzo1OutputRecordset(i).getNUMERO_RIGA());
                r.setNUMERO_RIGHE(i1ora.getNorm_Indirizzo1OutputRecordset(i).getNUMERO_RIGHE());
                r.setNUMERO_STRADA(i1ora.getNorm_Indirizzo1OutputRecordset(i).getNUMERO_STRADA());
                r.setPROVINCIA(i1ora.getNorm_Indirizzo1OutputRecordset(i).getPROVINCIA());
                r.setREGIONE(i1ora.getNorm_Indirizzo1OutputRecordset(i).getREGIONE());
                r.setSTRADARIO_ID(i1ora.getNorm_Indirizzo1OutputRecordset(i).getSTRADARIO_ID());
                r.setSUFFISSO_CIVICO(i1ora.getNorm_Indirizzo1OutputRecordset(i).getSUFFISSO_CIVICO());
                records[i] = r;
            }
            ArrayOfNormIndirizzo1Record recordSet = new ArrayOfNormIndirizzo1Record(records);
            
            JSONObject res = new JSONObject(recordSet);
             if (callback != null && callback.length() > 0)
                return callback + "(" + res.toString() + ")";
             else
                 return res.toString();
        }
        catch (Exception exc)
        {
            this.scriviLog("Errore nella normalizzazione dell'indirizzo (normIndirizzo1): " + exc.getMessage() + "\n");
            return null;
        }
    }
    
    @Path("/normIndirizzo1")
    @GET
    @Produces({"application/xml"})
    public ArrayOfNormIndirizzo1Record normIndirizzo1(@QueryParam("p_toponimo") String p_toponimo, @QueryParam("p_comune") String p_comune, @QueryParam("p_provincia") String p_provincia, @QueryParam("p_cod_istat") String p_cod_istat, @QueryParam("p_cod_nazionale") String p_cod_nazionale, @QueryParam("p_cod_catastale") String p_cod_catastale, @QueryParam("handle") String handle) {
        scriviLog("Invocata normIndirizzo1(" + p_toponimo + "," + p_comune + "," + p_provincia + "," + p_cod_istat + "," + p_cod_nazionale + "," + p_cod_catastale + "," + handle + ")");
        try {
            NormalizzatoreSoapPort norm = getNormalizzatoreSoapPort(handle);
            Norm_Indirizzo1InputParams i1ip = new Norm_Indirizzo1InputParams();
            if (!emptyString(handle)) {
                i1ip.setP_Handle(handle);
            }
            if (!emptyString(p_toponimo)) {
                i1ip.setP_Toponimo(p_toponimo);
            }
            if (!emptyString(p_comune)) {
                i1ip.setP_Comune(p_comune);
            }
            if (!emptyString(p_provincia)) {
                i1ip.setP_Provincia(p_provincia);
            }
            if (!emptyString(p_cod_istat)) {
                i1ip.setP_Cod_Istat(p_cod_istat);
            }
            if (!emptyString(p_cod_nazionale)) {
                i1ip.setP_Cod_Nazionale(p_cod_nazionale);
            }
            if (!emptyString(p_cod_catastale)) {
                i1ip.setP_Cod_Catastale(p_cod_catastale);
            }
            Norm_Indirizzo1Input i1i = new Norm_Indirizzo1Input(i1ip, null);
            Norm_Indirizzo1SoapInElement i1sie = new Norm_Indirizzo1SoapInElement(i1i);

            Norm_Indirizzo1SoapOutElement i1soe = norm.norm_Indirizzo1(i1sie);
            Norm_Indirizzo1OutputRecordsetArray i1ora = i1soe.getNorm_Indirizzo1Output().getNorm_Indirizzo1OutputRecordsetArray();
            NormIndirizzo1Record[] records = new NormIndirizzo1Record[i1ora.getNorm_Indirizzo1OutputRecordset().length];
            for (int i = 0; i < i1ora.getNorm_Indirizzo1OutputRecordset().length; i++) {
                NormIndirizzo1Record r = new NormIndirizzo1Record();
                r.setCivico_Arco_Id(i1ora.getNorm_Indirizzo1OutputRecordset(i).getCivico_Arco_Id());
                r.setCIVICO_ID(i1ora.getNorm_Indirizzo1OutputRecordset(i).getCIVICO_ID());
                r.setCivico_Lat_Wgs84(i1ora.getNorm_Indirizzo1OutputRecordset(i).getCivico_Lat_Wgs84());
                r.setCivico_Lng_Wgs84(i1ora.getNorm_Indirizzo1OutputRecordset(i).getCivico_Lng_Wgs84());
                r.setCivico_x_Utma(i1ora.getNorm_Indirizzo1OutputRecordset(i).getCivico_x_Utma());
                r.setCivico_y_Utma(i1ora.getNorm_Indirizzo1OutputRecordset(i).getCivico_y_Utma());
                r.setCOMUNE(i1ora.getNorm_Indirizzo1OutputRecordset(i).getCOMUNE());
                r.setDENOMINAZIONE(i1ora.getNorm_Indirizzo1OutputRecordset(i).getDENOMINAZIONE());
                r.setDUG(i1ora.getNorm_Indirizzo1OutputRecordset(i).getDUG());
                r.setGR_AFFIDABILITA(i1ora.getNorm_Indirizzo1OutputRecordset(i).getGR_AFFIDABILITA());
                r.setGR_AFFIDABILITA_CIV(i1ora.getNorm_Indirizzo1OutputRecordset(i).getGR_AFFIDABILITA_CIV());
                r.setMax_Lat_Wgs84(i1ora.getNorm_Indirizzo1OutputRecordset(i).getMax_Lat_Wgs84());
                r.setMax_Lng_Wgs84(i1ora.getNorm_Indirizzo1OutputRecordset(i).getMax_Lng_Wgs84());
                r.setMax_x_Utma(i1ora.getNorm_Indirizzo1OutputRecordset(i).getMax_x_Utma());
                r.setMax_y_Utma(i1ora.getNorm_Indirizzo1OutputRecordset(i).getMax_y_Utma());
                r.setMin_Lat_Wgs84(i1ora.getNorm_Indirizzo1OutputRecordset(i).getMin_Lat_Wgs84());
                r.setMin_Lng_Wgs84(i1ora.getNorm_Indirizzo1OutputRecordset(i).getMin_Lng_Wgs84());
                r.setMin_x_Utma(i1ora.getNorm_Indirizzo1OutputRecordset(i).getMin_x_Utma());
                r.setMin_y_Utma(i1ora.getNorm_Indirizzo1OutputRecordset(i).getMin_y_Utma());
                r.setNUM_CIVICO(i1ora.getNorm_Indirizzo1OutputRecordset(i).getNUM_CIVICO());
                r.setNUMERO_RIGA(i1ora.getNorm_Indirizzo1OutputRecordset(i).getNUMERO_RIGA());
                r.setNUMERO_RIGHE(i1ora.getNorm_Indirizzo1OutputRecordset(i).getNUMERO_RIGHE());
                r.setNUMERO_STRADA(i1ora.getNorm_Indirizzo1OutputRecordset(i).getNUMERO_STRADA());
                r.setPROVINCIA(i1ora.getNorm_Indirizzo1OutputRecordset(i).getPROVINCIA());
                r.setREGIONE(i1ora.getNorm_Indirizzo1OutputRecordset(i).getREGIONE());
                r.setSTRADARIO_ID(i1ora.getNorm_Indirizzo1OutputRecordset(i).getSTRADARIO_ID());
                r.setSUFFISSO_CIVICO(i1ora.getNorm_Indirizzo1OutputRecordset(i).getSUFFISSO_CIVICO());
                records[i] = r;
            }
            return new ArrayOfNormIndirizzo1Record(records);
        } catch (Exception exc) {
            scriviLog("Errore nella normalizzazione dell'indirizzo (normIndirizzo1): " + exc.getMessage() + "\n");
        }
        return null;
    }

    private boolean emptyString(String string)
    {
        if (string != null && string.trim().length() == 0)
            return true;
        else
            return false;
    }
    /**
     * La Norm_Indirizzo2 richiede il toponimo della strada separato dal numero civico
     * (con eventuale suffisso). Alla funzione verranno inoltre forniti:
     * il nome del comune e/o nome/sigla della provincia oppure
     *  il codice istat del comune o il codice nazionale o quello catastale
     * @param p_toponimo String nome della strada. La stringa non deve contenere un numero civico
     * @param p_civico String eventuale numero del civico della strada
     * @param p_comune String eventuale nome del comune
     * @param p_provincia String eventuale nome o alla sigla della provincia
     * @param p_cod_istat String eventuale Codice ISTAT del Comune
     * @param p_cod_nazionale String eventuale Codice nazionale del comune (agenzia del territorio)
     * @param p_cod_catastale String eventuale Codice catastale del comune (agenzia del territorio)
     * @param handle String handle di connessione al normalizzatore
     * @param callback String indica una chiamata jsonp
     * @return ArrayOfNormIndirizzo2Record Array di rowset contenenti i risultati ottenuti
     * dal processo di normalizzazione. Un rowset conterr� gli indirizzi ottenuti tramite gli algoritmi di ricerca.
     * Se l'indirizzo viene identificato univocamente, il cursore conterr� solo l'indirizzo individuato.
     * Altrimenti verranno restituiti pi� indirizzi, con associati il grado di affidabilit� del risultato
     * (0 = via identificata con certezza, > 0 incerto). Le righe del cursore ritornato sono ordinate
     * per livelli di affidabilit� decrescenti. Il grado di affidabilit� non � direttamente influenzato
     * dal numero civico: per sapere se il civico � stato identificato o no si deve guardare
     * il campo CIVICO_ID, che sar� a NULL in caso in cui la ricerca fallisca e verificare
     * il grado di affidabilit� del civico. Il suffisso viene individuato tramite
     * una funzione apposita, separatamente quindi dal civico, in modo da poter
     * identificare civici anche se hanno il suffisso sbagliato. Nel caso di ricerca
     * di un civico di una localit�, se non viene trovato, verr� riportato
     * (se inserito in tabella dalla procedura di aggiornamento della GEO_T_CIVICI) il
     * civico numero 0, che rappresenta il punto centrale della localit�.
     */
    @Path("/normIndirizzo2Json")
	@GET
	@Produces({"application/javascript"})
    public String normIndirizzo2Json(@QueryParam("p_toponimo") String p_toponimo,
                                                      @QueryParam("p_civico") String p_civico,
                                                      @QueryParam("p_comune") String p_comune,
                                                      @QueryParam("p_provincia") String p_provincia,
                                                      @QueryParam("p_cod_istat") String p_cod_istat,
                                                      @QueryParam("p_cod_nazionale") String p_cod_nazionale,
                                                      @QueryParam("p_cod_catastale") String p_cod_catastale,
                                                      @QueryParam("handle") String handle,
                                                      @QueryParam("callback") String callback)
    {
        try {
            NormalizzatoreSoapPort norm = this.getNormalizzatoreSoapPort(handle);
            Norm_Indirizzo2InputParams i2ip = new Norm_Indirizzo2InputParams();
            if (!emptyString(p_toponimo))
               i2ip.setP_Toponimo(p_toponimo);
            if (!emptyString(p_civico))
                i2ip.setP_Civico(p_civico);
            if (!emptyString(p_comune))
                i2ip.setP_Comune(p_comune);
            if (!emptyString(p_provincia))
                i2ip.setP_Provincia(p_provincia);
            if (!emptyString(p_cod_istat))
                i2ip.setP_Cod_Istat(p_cod_istat);
            if (!emptyString(p_cod_nazionale))
                i2ip.setP_Cod_Nazionale(p_cod_nazionale);
            if (!emptyString(p_cod_catastale))
                i2ip.setP_Cod_Catastale(p_cod_catastale);
            if (!emptyString(handle))
                i2ip.setP_Handle(handle);

            Norm_Indirizzo2Input i2i = new Norm_Indirizzo2Input();
            i2i.setNorm_Indirizzo2InputParams(i2ip);
            Norm_Indirizzo2SoapInElement i2sie = new
                                                 Norm_Indirizzo2SoapInElement(
                    i2i);
            Norm_Indirizzo2SoapOutElement i2soe = norm.norm_Indirizzo2(i2sie);
            Norm_Indirizzo2OutputRecordsetArray i2ora = i2soe.getNorm_Indirizzo2Output().getNorm_Indirizzo2OutputRecordsetArray();
            NormIndirizzo2Record[] records = new NormIndirizzo2Record[i2ora.getNorm_Indirizzo2OutputRecordset().length];

            for (int i = 0; i < i2ora.getNorm_Indirizzo2OutputRecordset().length; i++) {
                NormIndirizzo2Record r = new NormIndirizzo2Record();
                r.setCivico_Arco_Id(i2ora.getNorm_Indirizzo2OutputRecordset(i).getCivico_Arco_Id());
                r.setCIVICO_ID(i2ora.getNorm_Indirizzo2OutputRecordset(i).getCIVICO_ID());
                r.setCivico_Lat_Wgs84(i2ora.getNorm_Indirizzo2OutputRecordset(i).getCivico_Lat_Wgs84());
                r.setCivico_Lng_Wgs84(i2ora.getNorm_Indirizzo2OutputRecordset(i).getCivico_Lng_Wgs84());
                r.setCivico_x_Utma(i2ora.getNorm_Indirizzo2OutputRecordset(i).getCivico_x_Utma());
                r.setCivico_y_Utma(i2ora.getNorm_Indirizzo2OutputRecordset(i).getCivico_y_Utma());
                r.setCOMUNE(i2ora.getNorm_Indirizzo2OutputRecordset(i).getCOMUNE());
                r.setDENOMINAZIONE(i2ora.getNorm_Indirizzo2OutputRecordset(i).getDENOMINAZIONE());
                r.setDUG(i2ora.getNorm_Indirizzo2OutputRecordset(i).getDUG());
                r.setGR_AFFIDABILITA(i2ora.getNorm_Indirizzo2OutputRecordset(i).getGR_AFFIDABILITA());
                r.setGR_AFFIDABILITA_CIV(i2ora.getNorm_Indirizzo2OutputRecordset(i).getGR_AFFIDABILITA_CIV());
                r.setMax_Lat_Wgs84(i2ora.getNorm_Indirizzo2OutputRecordset(i).getMax_Lat_Wgs84());
                r.setMax_Lng_Wgs84(i2ora.getNorm_Indirizzo2OutputRecordset(i).getMax_Lng_Wgs84());
                r.setMax_x_Utma(i2ora.getNorm_Indirizzo2OutputRecordset(i).getMax_x_Utma());
                r.setMax_y_Utma(i2ora.getNorm_Indirizzo2OutputRecordset(i).getMax_y_Utma());
                r.setMin_Lat_Wgs84(i2ora.getNorm_Indirizzo2OutputRecordset(i).getMin_Lat_Wgs84());
                r.setMin_Lng_Wgs84(i2ora.getNorm_Indirizzo2OutputRecordset(i).getMin_Lng_Wgs84());
                r.setMin_x_Utma(i2ora.getNorm_Indirizzo2OutputRecordset(i).getMin_x_Utma());
                r.setMin_y_Utma(i2ora.getNorm_Indirizzo2OutputRecordset(i).getMin_y_Utma());
                r.setNUM_CIVICO(i2ora.getNorm_Indirizzo2OutputRecordset(i).getNUM_CIVICO());
                r.setNUMERO_RIGA(i2ora.getNorm_Indirizzo2OutputRecordset(i).getNUMERO_RIGA());
                r.setNUMERO_RIGHE(i2ora.getNorm_Indirizzo2OutputRecordset(i).getNUMERO_RIGHE());
                r.setNUMERO_STRADA(i2ora.getNorm_Indirizzo2OutputRecordset(i).getNUMERO_STRADA());
                r.setPROVINCIA(i2ora.getNorm_Indirizzo2OutputRecordset(i).getPROVINCIA());
                r.setREGIONE(i2ora.getNorm_Indirizzo2OutputRecordset(i).getREGIONE());
                r.setSTRADARIO_ID(i2ora.getNorm_Indirizzo2OutputRecordset(i).getSTRADARIO_ID());
                r.setSUFFISSO_CIVICO(i2ora.getNorm_Indirizzo2OutputRecordset(i).getSUFFISSO_CIVICO());
                records[i] = r;
            }
            ArrayOfNormIndirizzo2Record recordSet = new ArrayOfNormIndirizzo2Record(records);
            
            JSONObject res = new JSONObject(recordSet);
             if (callback != null && callback.length() > 0)
                return callback + "(" + res.toString() + ")";
             else
                 return res.toString();
        }
        catch (Exception exc)
        {
            this.scriviLog("Errore nella normalizzazione dell'indirizzo (normIndirizzo2): " + exc.getMessage() + "\n");
            return null;
        }
    }

    @Path("/normIndirizzo2")
    @GET
    @Produces({"application/xml"})
    public ArrayOfNormIndirizzo2Record normIndirizzo2(@QueryParam("p_toponimo") String p_toponimo, @QueryParam("p_civico") String p_civico, @QueryParam("p_comune") String p_comune, @QueryParam("p_provincia") String p_provincia, @QueryParam("p_cod_istat") String p_cod_istat, @QueryParam("p_cod_nazionale") String p_cod_nazionale, @QueryParam("p_cod_catastale") String p_cod_catastale, @QueryParam("handle") String handle) {
        try {
            NormalizzatoreSoapPort norm = getNormalizzatoreSoapPort(handle);
            Norm_Indirizzo2InputParams i2ip = new Norm_Indirizzo2InputParams();
            if (!emptyString(p_toponimo)) {
                i2ip.setP_Toponimo(p_toponimo);
            }
            if (!emptyString(p_civico)) {
                i2ip.setP_Civico(p_civico);
            }
            if (!emptyString(p_comune)) {
                i2ip.setP_Comune(p_comune);
            }
            if (!emptyString(p_provincia)) {
                i2ip.setP_Provincia(p_provincia);
            }
            if (!emptyString(p_cod_istat)) {
                i2ip.setP_Cod_Istat(p_cod_istat);
            }
            if (!emptyString(p_cod_nazionale)) {
                i2ip.setP_Cod_Nazionale(p_cod_nazionale);
            }
            if (!emptyString(p_cod_catastale)) {
                i2ip.setP_Cod_Catastale(p_cod_catastale);
            }
            if (!emptyString(handle)) {
                i2ip.setP_Handle(handle);
            }
            Norm_Indirizzo2Input i2i = new Norm_Indirizzo2Input();
            i2i.setNorm_Indirizzo2InputParams(i2ip);
            Norm_Indirizzo2SoapInElement i2sie = new Norm_Indirizzo2SoapInElement(i2i);

            Norm_Indirizzo2SoapOutElement i2soe = norm.norm_Indirizzo2(i2sie);
            Norm_Indirizzo2OutputRecordsetArray i2ora = i2soe.getNorm_Indirizzo2Output().getNorm_Indirizzo2OutputRecordsetArray();
            NormIndirizzo2Record[] records = new NormIndirizzo2Record[i2ora.getNorm_Indirizzo2OutputRecordset().length];
            for (int i = 0; i < i2ora.getNorm_Indirizzo2OutputRecordset().length; i++) {
                NormIndirizzo2Record r = new NormIndirizzo2Record();
                r.setCivico_Arco_Id(i2ora.getNorm_Indirizzo2OutputRecordset(i).getCivico_Arco_Id());
                r.setCIVICO_ID(i2ora.getNorm_Indirizzo2OutputRecordset(i).getCIVICO_ID());
                r.setCivico_Lat_Wgs84(i2ora.getNorm_Indirizzo2OutputRecordset(i).getCivico_Lat_Wgs84());
                r.setCivico_Lng_Wgs84(i2ora.getNorm_Indirizzo2OutputRecordset(i).getCivico_Lng_Wgs84());
                r.setCivico_x_Utma(i2ora.getNorm_Indirizzo2OutputRecordset(i).getCivico_x_Utma());
                r.setCivico_y_Utma(i2ora.getNorm_Indirizzo2OutputRecordset(i).getCivico_y_Utma());
                r.setCOMUNE(i2ora.getNorm_Indirizzo2OutputRecordset(i).getCOMUNE());
                r.setDENOMINAZIONE(i2ora.getNorm_Indirizzo2OutputRecordset(i).getDENOMINAZIONE());
                r.setDUG(i2ora.getNorm_Indirizzo2OutputRecordset(i).getDUG());
                r.setGR_AFFIDABILITA(i2ora.getNorm_Indirizzo2OutputRecordset(i).getGR_AFFIDABILITA());
                r.setGR_AFFIDABILITA_CIV(i2ora.getNorm_Indirizzo2OutputRecordset(i).getGR_AFFIDABILITA_CIV());
                r.setMax_Lat_Wgs84(i2ora.getNorm_Indirizzo2OutputRecordset(i).getMax_Lat_Wgs84());
                r.setMax_Lng_Wgs84(i2ora.getNorm_Indirizzo2OutputRecordset(i).getMax_Lng_Wgs84());
                r.setMax_x_Utma(i2ora.getNorm_Indirizzo2OutputRecordset(i).getMax_x_Utma());
                r.setMax_y_Utma(i2ora.getNorm_Indirizzo2OutputRecordset(i).getMax_y_Utma());
                r.setMin_Lat_Wgs84(i2ora.getNorm_Indirizzo2OutputRecordset(i).getMin_Lat_Wgs84());
                r.setMin_Lng_Wgs84(i2ora.getNorm_Indirizzo2OutputRecordset(i).getMin_Lng_Wgs84());
                r.setMin_x_Utma(i2ora.getNorm_Indirizzo2OutputRecordset(i).getMin_x_Utma());
                r.setMin_y_Utma(i2ora.getNorm_Indirizzo2OutputRecordset(i).getMin_y_Utma());
                r.setNUM_CIVICO(i2ora.getNorm_Indirizzo2OutputRecordset(i).getNUM_CIVICO());
                r.setNUMERO_RIGA(i2ora.getNorm_Indirizzo2OutputRecordset(i).getNUMERO_RIGA());
                r.setNUMERO_RIGHE(i2ora.getNorm_Indirizzo2OutputRecordset(i).getNUMERO_RIGHE());
                r.setNUMERO_STRADA(i2ora.getNorm_Indirizzo2OutputRecordset(i).getNUMERO_STRADA());
                r.setPROVINCIA(i2ora.getNorm_Indirizzo2OutputRecordset(i).getPROVINCIA());
                r.setREGIONE(i2ora.getNorm_Indirizzo2OutputRecordset(i).getREGIONE());
                r.setSTRADARIO_ID(i2ora.getNorm_Indirizzo2OutputRecordset(i).getSTRADARIO_ID());
                r.setSUFFISSO_CIVICO(i2ora.getNorm_Indirizzo2OutputRecordset(i).getSUFFISSO_CIVICO());
                records[i] = r;
            }
            return new ArrayOfNormIndirizzo2Record(records);
        } catch (Exception exc) {
            scriviLog("Errore nella normalizzazione dell'indirizzo (normIndirizzo2): " + exc.getMessage() + "\n");
        }
        return null;
    }

    
    @Path("/normComune1Json")
    @GET
    @Produces({"application/javascript"})
    public String normComune1Json(@QueryParam("p_toponimo") String p_toponimo,
        @QueryParam("handle") String handle,
        @QueryParam("callback") String callback)
    {
        scriviLog("Invocata normComune1Json(" + p_toponimo + "," + handle + ", " + callback + ")");
        try {
            NormalizzatoreSoapPort norm = this.getNormalizzatoreSoapPort(handle);
            Norm_Comune1InputParams c1ip = new Norm_Comune1InputParams();
            if (!emptyString(handle))
                c1ip.setP_Handle(handle);
            if (!emptyString(p_toponimo))
                c1ip.setP_Toponimo(p_toponimo);
            Norm_Comune1Input c1i = new Norm_Comune1Input(c1ip, null);
            Norm_Comune1SoapInElement c1sie = new Norm_Comune1SoapInElement(c1i);
            Norm_Comune1SoapOutElement c1soe = norm.norm_Comune1(c1sie);
            Norm_Comune1OutputRecordsetArray c1ora = c1soe.getNorm_Comune1Output().getNorm_Comune1OutputRecordsetArray();
            NormComune1Record[] records = new NormComune1Record[c1ora.getNorm_Comune1OutputRecordset().length];

            for (int i = 0; i < c1ora.getNorm_Comune1OutputRecordset().length; i++) {
                NormComune1Record r = new NormComune1Record();
                r.setCAP(c1ora.getNorm_Comune1OutputRecordset(i).getCAP());
                r.setCOD_CAT(c1ora.getNorm_Comune1OutputRecordset(i).getCOD_CAT());
                r.setCOD_ISTAT(c1ora.getNorm_Comune1OutputRecordset(i).getCOD_ISTAT());
                r.setCOD_NAZIONALE(c1ora.getNorm_Comune1OutputRecordset(i).getCOD_NAZIONALE());
                r.setCOMUNE_ID(c1ora.getNorm_Comune1OutputRecordset(i).getCOMUNE_ID());
                r.setDENOMINAZIONE(c1ora.getNorm_Comune1OutputRecordset(i).getDENOMINAZIONE());
                r.setFLG_CESSATO(c1ora.getNorm_Comune1OutputRecordset(i).getFLG_CESSATO());
                r.setGR_AFFIDABILITA(c1ora.getNorm_Comune1OutputRecordset(i).getGR_AFFIDABILITA());
                r.setNUMERO_RIGA(c1ora.getNorm_Comune1OutputRecordset(i).getNUMERO_RIGA());
                r.setNUMERO_RIGHE(c1ora.getNorm_Comune1OutputRecordset(i).getNUMERO_RIGHE());
                records[i] = r;
            }
            
            ArrayOfNormComune1Record recordSet = new ArrayOfNormComune1Record(records);
            JSONObject res = new JSONObject(recordSet);
            if (callback != null && callback.length() > 0)
                return callback + "(" + res.toString() + ")";
            else
                return res.toString();
        }
        catch (Exception exc)
        {
            this.scriviLog("Errore nella normalizzazione del comune (normComune1): " + exc.getMessage() + "\n");
            JSONObject res = new JSONObject();
            if (callback != null && callback.length() > 0)
                return callback + "(" + res.toString() + ")";
            else
                return res.toString();
        }
    }
    /**
     * La Norm_Comune1 consente di effettuare la ricerca del comune passando un'unica stringa che pu�
     * contenere un Cap, la descrizione del comune e la provincia (sigla o descrizione).
     * La descrizione del comune e la provincia sono obbligatori e devono essere scritti in sequenza
     * (prima il comune, poi la provincia).
     * @param p_toponimo String nome del comune. La stringa potr� contenere
     * eventualmente un cap (5 cifre), la descrizione del comune,
     * eventualmente la sigla o la descrizione della provincia
     * @param handle String handle di connessione al normalizzatore
     * @return ArrayOfNormComune1Record Array di rowset contenenti i risultati ottenuti
     * dal processo di normalizzazione
     */
    @Path("/normComune1")
	@GET
	@Produces({ MediaType.APPLICATION_XML })
    public ArrayOfNormComune1Record normComune1(@QueryParam("p_toponimo") String p_toponimo,
                                                @QueryParam("handle") String handle)
    {
        try {
            NormalizzatoreSoapPort norm = this.getNormalizzatoreSoapPort(handle);
            Norm_Comune1InputParams c1ip = new Norm_Comune1InputParams();
            if (!emptyString(handle))
                c1ip.setP_Handle(handle);
            if (!emptyString(p_toponimo))
                c1ip.setP_Toponimo(p_toponimo);
            Norm_Comune1Input c1i = new Norm_Comune1Input(c1ip, null);
            Norm_Comune1SoapInElement c1sie = new Norm_Comune1SoapInElement(c1i);
            Norm_Comune1SoapOutElement c1soe = norm.norm_Comune1(c1sie);
            Norm_Comune1OutputRecordsetArray c1ora = c1soe.getNorm_Comune1Output().getNorm_Comune1OutputRecordsetArray();
            NormComune1Record[] records = new NormComune1Record[c1ora.getNorm_Comune1OutputRecordset().length];

            for (int i = 0; i < c1ora.getNorm_Comune1OutputRecordset().length; i++) {
                NormComune1Record r = new NormComune1Record();
                r.setCAP(c1ora.getNorm_Comune1OutputRecordset(i).getCAP());
                r.setCOD_CAT(c1ora.getNorm_Comune1OutputRecordset(i).getCOD_CAT());
                r.setCOD_ISTAT(c1ora.getNorm_Comune1OutputRecordset(i).getCOD_ISTAT());
                r.setCOD_NAZIONALE(c1ora.getNorm_Comune1OutputRecordset(i).getCOD_NAZIONALE());
                r.setCOMUNE_ID(c1ora.getNorm_Comune1OutputRecordset(i).getCOMUNE_ID());
                r.setDENOMINAZIONE(c1ora.getNorm_Comune1OutputRecordset(i).getDENOMINAZIONE());
                r.setFLG_CESSATO(c1ora.getNorm_Comune1OutputRecordset(i).getFLG_CESSATO());
                r.setGR_AFFIDABILITA(c1ora.getNorm_Comune1OutputRecordset(i).getGR_AFFIDABILITA());
                r.setNUMERO_RIGA(c1ora.getNorm_Comune1OutputRecordset(i).getNUMERO_RIGA());
                r.setNUMERO_RIGHE(c1ora.getNorm_Comune1OutputRecordset(i).getNUMERO_RIGHE());
                records[i] = r;
            }
            ArrayOfNormComune1Record recordSet = new ArrayOfNormComune1Record(records);
            return recordSet;
        }
        catch (Exception exc)
        {
            this.scriviLog("Errore nella normalizzazione del comune (normComune1): " + exc.getMessage() + "\n");
            return null;
        }

    }


    /**
     * La Norm Comune2 richiede la descrizione del comune, il cap e la provincia
     * come parametri distinti, in pi� consente la ricerca per codice istat, nazionale o catastale.
     * @param p_toponimo String nome del comune. La stringa dovr� contenere solo
     * ladescrizione del comune.
     * @param p_cap String eventuale Codice di avviamento postale
     * @param p_provincia String eventuale nome o alla sigla della provincia
     * @param p_cod_istat String eventuale Codice ISTAT del Comune
     * @param p_cod_nazionale String eventuale Codice nazionale del comune
     * (agenzia del territorio)
     * @param p_cod_catastale String eventuale Codice catastale del comune
     * (agenzia del territorio)
     * @param handle String handle di connessione al normalizzatore
     * @return ArrayOfNormComune2Record Array di rowset contenenti i risultati ottenuti
     * dal processo di normalizzazione
     */
    @Path("/normComune2")
	@GET
	@Produces({ MediaType.APPLICATION_XML })
    public ArrayOfNormComune2Record normComune2(@QueryParam("p_toponimo") String p_toponimo,
                                                @QueryParam("p_cap") String p_cap,
                                                @QueryParam("p_provincia") String p_provincia,
                                                @QueryParam("p_cod_istat") String p_cod_istat,
                                                @QueryParam("p_cod_nazionale") String p_cod_nazionale,
                                                @QueryParam("p_cod_catastale") String p_cod_catastale,
                                                @QueryParam("handle") String handle)
    {
        scriviLog("Invocata normComune2(" + p_toponimo + "," + p_cap + "," + p_provincia + "," + p_cod_istat + "," + p_cod_nazionale + "," + p_cod_catastale + "," + handle + ")");
        try {
            NormalizzatoreSoapPort norm = this.getNormalizzatoreSoapPort(handle);
            Norm_Comune2InputParams c2ip = new Norm_Comune2InputParams();
            if (!emptyString(handle))
                c2ip.setP_Handle(handle);
            if (!emptyString(p_toponimo))
                c2ip.setP_Toponimo(p_toponimo);
            if (!emptyString(p_cap))
                c2ip.setP_Cap(p_cap);
            if (!emptyString(p_provincia))
                c2ip.setP_Provincia(p_provincia);
            if (!emptyString(p_cod_istat))
                c2ip.setP_Cod_Istat(p_cod_istat);
            if (!emptyString(p_cod_nazionale))
                c2ip.setP_Cod_Nazionale(p_cod_nazionale);
            if (!emptyString(p_cod_catastale))
                c2ip.setP_Cod_Catastale(p_cod_catastale);
            Norm_Comune2Input c2i = new Norm_Comune2Input(c2ip, null);
            Norm_Comune2SoapInElement c2sie = new Norm_Comune2SoapInElement(c2i);
            Norm_Comune2SoapOutElement c2soe = norm.norm_Comune2(c2sie);
            Norm_Comune2OutputRecordsetArray c2ora = c2soe.getNorm_Comune2Output().getNorm_Comune2OutputRecordsetArray();
            NormComune2Record[] records = new NormComune2Record[c2ora.getNorm_Comune2OutputRecordset().length];

            for (int i = 0; i < c2ora.getNorm_Comune2OutputRecordset().length; i++) {
                NormComune2Record r = new NormComune2Record();
                r.setCAP(c2ora.getNorm_Comune2OutputRecordset(i).getCAP());
                r.setCOD_CAT(c2ora.getNorm_Comune2OutputRecordset(i).getCOD_CAT());
                r.setCOD_ISTAT(c2ora.getNorm_Comune2OutputRecordset(i).getCOD_ISTAT());
                r.setCOD_NAZIONALE(c2ora.getNorm_Comune2OutputRecordset(i).getCOD_NAZIONALE());
                r.setCOMUNE_ID(c2ora.getNorm_Comune2OutputRecordset(i).getCOMUNE_ID());
                r.setDENOMINAZIONE(c2ora.getNorm_Comune2OutputRecordset(i).getDENOMINAZIONE());
                r.setFLG_CESSATO(c2ora.getNorm_Comune2OutputRecordset(i).getFLG_CESSATO());
                r.setGR_AFFIDABILITA(c2ora.getNorm_Comune2OutputRecordset(i).getGR_AFFIDABILITA());
                r.setNUMERO_RIGA(c2ora.getNorm_Comune2OutputRecordset(i).getNUMERO_RIGA());
                r.setNUMERO_RIGHE(c2ora.getNorm_Comune2OutputRecordset(i).getNUMERO_RIGHE());
                records[i] = r;
            }
            ArrayOfNormComune2Record recordSet = new ArrayOfNormComune2Record(records);
            return recordSet;
        }
        catch (Exception exc)
        {
            this.scriviLog("Errore nella normalizzazione del comune (normComune2): " + exc.getMessage() + "\n");
            return null;
        }

    }
    
    @Path("/normComune2Json")
    @GET
    @Produces({"application/javascript"})
    public String normComune2Json(@QueryParam("p_toponimo") String p_toponimo,
                                                @QueryParam("p_cap") String p_cap,
                                                @QueryParam("p_provincia") String p_provincia,
                                                @QueryParam("p_cod_istat") String p_cod_istat,
                                                @QueryParam("p_cod_nazionale") String p_cod_nazionale,
                                                @QueryParam("p_cod_catastale") String p_cod_catastale,
                                                @QueryParam("handle") String handle, 
                                                @QueryParam("callback") String callback)
    {
        scriviLog("Invocata normComune2Json(" + p_toponimo + "," + p_cap + "," + p_provincia + "," + p_cod_istat + "," + p_cod_nazionale + "," + p_cod_catastale + "," + handle + "," + callback + ")");
        try {
            NormalizzatoreSoapPort norm = this.getNormalizzatoreSoapPort(handle);
            Norm_Comune2InputParams c2ip = new Norm_Comune2InputParams();
            if (!emptyString(handle))
                c2ip.setP_Handle(handle);
            if (!emptyString(p_toponimo))
                c2ip.setP_Toponimo(p_toponimo);
            if (!emptyString(p_cap))
                c2ip.setP_Cap(p_cap);
            if (!emptyString(p_provincia))
                c2ip.setP_Provincia(p_provincia);
            if (!emptyString(p_cod_istat))
                c2ip.setP_Cod_Istat(p_cod_istat);
            if (!emptyString(p_cod_nazionale))
                c2ip.setP_Cod_Nazionale(p_cod_nazionale);
            if (!emptyString(p_cod_catastale))
                c2ip.setP_Cod_Catastale(p_cod_catastale);
            Norm_Comune2Input c2i = new Norm_Comune2Input(c2ip, null);
            Norm_Comune2SoapInElement c2sie = new Norm_Comune2SoapInElement(c2i);
            Norm_Comune2SoapOutElement c2soe = norm.norm_Comune2(c2sie);
            Norm_Comune2OutputRecordsetArray c2ora = c2soe.getNorm_Comune2Output().getNorm_Comune2OutputRecordsetArray();
            NormComune2Record[] records = new NormComune2Record[c2ora.getNorm_Comune2OutputRecordset().length];

            for (int i = 0; i < c2ora.getNorm_Comune2OutputRecordset().length; i++) {
                NormComune2Record r = new NormComune2Record();
                r.setCAP(c2ora.getNorm_Comune2OutputRecordset(i).getCAP());
                r.setCOD_CAT(c2ora.getNorm_Comune2OutputRecordset(i).getCOD_CAT());
                r.setCOD_ISTAT(c2ora.getNorm_Comune2OutputRecordset(i).getCOD_ISTAT());
                r.setCOD_NAZIONALE(c2ora.getNorm_Comune2OutputRecordset(i).getCOD_NAZIONALE());
                r.setCOMUNE_ID(c2ora.getNorm_Comune2OutputRecordset(i).getCOMUNE_ID());
                r.setDENOMINAZIONE(c2ora.getNorm_Comune2OutputRecordset(i).getDENOMINAZIONE());
                r.setFLG_CESSATO(c2ora.getNorm_Comune2OutputRecordset(i).getFLG_CESSATO());
                r.setGR_AFFIDABILITA(c2ora.getNorm_Comune2OutputRecordset(i).getGR_AFFIDABILITA());
                r.setNUMERO_RIGA(c2ora.getNorm_Comune2OutputRecordset(i).getNUMERO_RIGA());
                r.setNUMERO_RIGHE(c2ora.getNorm_Comune2OutputRecordset(i).getNUMERO_RIGHE());
                records[i] = r;
            }
            ArrayOfNormComune2Record recordSet = new ArrayOfNormComune2Record(records);
            
            JSONObject res = new JSONObject(recordSet);
            if (callback != null && callback.length() > 0)
                return callback + "(" + res.toString() + ")";
            else
                return res.toString();
        }
        catch (Exception exc)
        {
            this.scriviLog("Errore nella normalizzazione del comune (normComune2): " + exc.getMessage() + "\n");
            JSONObject res = new JSONObject();
            if (callback != null && callback.length() > 0)
                return callback + "(" + res.toString() + ")";
            else
                return res.toString();
        }
    }


    /**
     * La funzione Norm_Provincia consente la ricerca in base alla descrizione o alla sigla
     * della provincia e in base al codice istat o nazionale.
     * @param p_provincia String nome o sigla della provincia
     * @param p_cod_istat String eventuale Codice ISTAT della provincia
     * @param p_cod_nazionale String eventuale Codice nazionale della provincia
     * (agenzia del territorio)
     * @param handle String handle di connessione al normalizzatore
     * @return ArrayOfNormProvinciaRecord Restituisce un array contenente
     *  le province pi� simili ottenute tramite un algoritmo di ricerca.
     * Se la provincia viene identificata univocamente l'array conterr� solo la
     * provincia individuata. Altrimenti verranno restituite pi� province
     * associate ad un grado di affidabilit� del risultato (0 l'indirizzo � esatto,
     * > 0 differisce dai parametri di input). Tutti i parametri passati in input verranno
     * aggiunti come filtro per l'estrazione.
     */
    @Path("/normProvincia")
	@GET
	@Produces({ MediaType.APPLICATION_XML })
    public ArrayOfNormProvinciaRecord normProvincia(@QueryParam("p_provincia") String p_provincia,
                                                    @QueryParam("p_cod_istat") String p_cod_istat,
                                                    @QueryParam("p_cod_nazionale") String p_cod_nazionale,
                                                    @QueryParam("handle") String handle)
    {
        scriviLog("Invocata normProvincia(" + p_provincia + "," + p_cod_istat + "," + p_cod_nazionale + "," + handle + ")");
        try {
            NormalizzatoreSoapPort norm = this.getNormalizzatoreSoapPort(handle);
            Norm_ProvinciaInputParams pip = new Norm_ProvinciaInputParams(handle, p_cod_istat, p_cod_nazionale, p_provincia);
            Norm_ProvinciaInput pi = new Norm_ProvinciaInput(pip, null);
            if (!emptyString(handle))
                pip.setP_Handle(handle);
            if (!emptyString(p_cod_istat))
                pip.setP_Cod_Istat(p_cod_istat);
            if (!emptyString(p_cod_nazionale))
                pip.setP_Cod_Nazionale(p_cod_nazionale);
            if (!emptyString(p_provincia))
                pip.setP_Provincia(p_provincia);

            Norm_ProvinciaSoapInElement psie = new Norm_ProvinciaSoapInElement(pi);
            Norm_ProvinciaSoapOutElement psoe = norm.norm_Provincia(psie);
            Norm_ProvinciaOutputRecordsetArray pora = psoe.getNorm_ProvinciaOutput().getNorm_ProvinciaOutputRecordsetArray();
            NormProvinciaRecord[] records = new NormProvinciaRecord[pora.getNorm_ProvinciaOutputRecordset().length];

            for (int i = 0; i < pora.getNorm_ProvinciaOutputRecordset().length; i++) {
                NormProvinciaRecord r = new NormProvinciaRecord();
                r.setCOD_ISTAT(pora.getNorm_ProvinciaOutputRecordset(i).getCOD_ISTAT());
                r.setCOD_NAZIONALE(pora.getNorm_ProvinciaOutputRecordset(i).getCOD_NAZIONALE());
                r.setDENOMINAZIONE(pora.getNorm_ProvinciaOutputRecordset(i).getDENOMINAZIONE());
                r.setGR_AFFIDABILITA(pora.getNorm_ProvinciaOutputRecordset(i).getGR_AFFIDABILITA());
                r.setNUMERO_RIGA(pora.getNorm_ProvinciaOutputRecordset(i).getNUMERO_RIGA());
                r.setNUMERO_RIGHE(pora.getNorm_ProvinciaOutputRecordset(i).getNUMERO_RIGHE());
                r.setPROVINCIA_ID(pora.getNorm_ProvinciaOutputRecordset(i).getPROVINCIA_ID());
                r.setSIGLA(pora.getNorm_ProvinciaOutputRecordset(i).getSIGLA());
                records[i] = r;
            }
            ArrayOfNormProvinciaRecord recordSet = new ArrayOfNormProvinciaRecord(records);
            return recordSet;

        }
        catch (Exception exc)
        {
            this.scriviLog("Errore nella normalizzazione della provincia (normProvincia): " + exc.getMessage() + "\n");
            return null;
        }
    }
    
    @Path("/normProvinciaJson")
	@GET
	@Produces({"application/javascript"})
    public String normProvinciaJson(@QueryParam("p_provincia") String p_provincia,
                                                    @QueryParam("p_cod_istat") String p_cod_istat,
                                                    @QueryParam("p_cod_nazionale") String p_cod_nazionale,
                                                    @QueryParam("handle") String handle, 
                                                    @QueryParam("callback") String callback)
    {
        scriviLog("Invocata normProvinciaJson(" + p_provincia + "," + p_cod_istat + "," + p_cod_nazionale + "," + handle + ", " + callback + ")");
        try {
            NormalizzatoreSoapPort norm = this.getNormalizzatoreSoapPort(handle);
            Norm_ProvinciaInputParams pip = new Norm_ProvinciaInputParams(handle, p_cod_istat, p_cod_nazionale, p_provincia);
            Norm_ProvinciaInput pi = new Norm_ProvinciaInput(pip, null);
            if (!emptyString(handle))
                pip.setP_Handle(handle);
            if (!emptyString(p_cod_istat))
                pip.setP_Cod_Istat(p_cod_istat);
            if (!emptyString(p_cod_nazionale))
                pip.setP_Cod_Nazionale(p_cod_nazionale);
            if (!emptyString(p_provincia))
                pip.setP_Provincia(p_provincia);

            Norm_ProvinciaSoapInElement psie = new Norm_ProvinciaSoapInElement(pi);
            Norm_ProvinciaSoapOutElement psoe = norm.norm_Provincia(psie);
            Norm_ProvinciaOutputRecordsetArray pora = psoe.getNorm_ProvinciaOutput().getNorm_ProvinciaOutputRecordsetArray();
            NormProvinciaRecord[] records = new NormProvinciaRecord[pora.getNorm_ProvinciaOutputRecordset().length];

            for (int i = 0; i < pora.getNorm_ProvinciaOutputRecordset().length; i++) {
                NormProvinciaRecord r = new NormProvinciaRecord();
                r.setCOD_ISTAT(pora.getNorm_ProvinciaOutputRecordset(i).getCOD_ISTAT());
                r.setCOD_NAZIONALE(pora.getNorm_ProvinciaOutputRecordset(i).getCOD_NAZIONALE());
                r.setDENOMINAZIONE(pora.getNorm_ProvinciaOutputRecordset(i).getDENOMINAZIONE());
                r.setGR_AFFIDABILITA(pora.getNorm_ProvinciaOutputRecordset(i).getGR_AFFIDABILITA());
                r.setNUMERO_RIGA(pora.getNorm_ProvinciaOutputRecordset(i).getNUMERO_RIGA());
                r.setNUMERO_RIGHE(pora.getNorm_ProvinciaOutputRecordset(i).getNUMERO_RIGHE());
                r.setPROVINCIA_ID(pora.getNorm_ProvinciaOutputRecordset(i).getPROVINCIA_ID());
                r.setSIGLA(pora.getNorm_ProvinciaOutputRecordset(i).getSIGLA());
                records[i] = r;
            }
            ArrayOfNormProvinciaRecord recordSet = new ArrayOfNormProvinciaRecord(records);
            JSONObject res = new JSONObject(recordSet);
            if (callback != null && callback.length() > 0)
                return callback + "(" + res.toString() + ")";
            else
                return res.toString();

        }
        catch (Exception exc)
        {
            this.scriviLog("Errore nella normalizzazione della provincia (normProvinciaJson): " + exc.getMessage() + "\n");
            JSONObject res = new JSONObject();
            if (callback != null && callback.length() > 0)
                return callback + "(" + res.toString() + ")";
            else
                return res.toString();
        }

    }
    
    /**
     * Genera un identificatore utilizzato da un client per richiamare successivamente.
     * metodi che agiscono sulla stessa mappa.
     * @return String l'idMap associato alla mappa.
     * @throws NoSuchAlgorithmException.
     * @throws UnsupportedEncodingException.
     */

    private static String makeID() throws java.
            security.NoSuchAlgorithmException,
            java.io.UnsupportedEncodingException
    {
        String digest;
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(java.util.Calendar.getInstance().toString().getBytes());
        digest = URLEncoder.encode(new String(md.digest()),"UTF-8");
        String id = digest.replace("%","");
        return id;
    }


    /**
     * Inizializza la connessione al map server restituitendo l'identificatore della connessione che
     * dovr� essere utilizzato nelle successive invocazioni ai metodi esposti dal Web Service.
     * @param mapServerType int Tipologia di map server: 1=ArcIMS; 2=GeoIn; 3=Abaco; 4=WMS; 5=Map Server; 6=Arcgis Server.
     * @param connString String Stringa di connessione che varia a seconda del map server.
     * 1) ArcIms: � nella forma "tipoConnessione;host;porta", ad esempio tcp;192.168.7.205;5300
     * oppure http;http://192.168.7.205;80, dove
     * "host" � l'indirizzo ip (nel caso di connessione tcp) o l'url (nel caso di connessione http)
     * del server su cui � installato ArcIms e "porta" � la porta su cui ArcIms ascolta le chiamate.
     * 2) GeoIn: � nella forma "host;porta;OracleServiceName", ad esempio 192.168.7.203;6000;ASTA_EST dove
     * "host" � l'indirizzo ip del server su cui � installato GeoIn, "porta" � la porta su cui
     * GeoIn ascolta le chiamate e "OracleServiceName" � il Service Name al database Oracle presente
     * nel file tnsnames.ora di Oracle.
     * 3) Abaco: � l'URL o il percorso fisico accessibile dal server su cui � installato il Web Service
     * che fa riferimento al file di progetto xml del servizio abaco, ad esempio
     * http://192.168.7.203:8998/DbMAP_ASJ_servlet/dbmap_cscve.xml oppure
     * C:\\dbmap_project\\dbmap_cscve.xml (da notare il doppio "\" nel caso il sistema operativo sia Windows)
     * 4) WMS: � l'URL di connessione al server WMS senza specificare il nome del servizio, ad esempio
     * http://192.168.7.205/wmsconnector/com.esri.wms.Esrimap?version=1.1.1.
     * 5) Map Server: � l'URL o il percorso fisico accessibile dal server su cui � installato il Web Service
     * che fa riferimento al file di progetto .map del servizio Map Server, ad esempio
     * http://192.168.7.203:8080/SitecoWS/cscve.map oppure
     * C:\\mapserver_project\\dbmap_cscve.map (da notare il doppio "\" nel caso il sistema operativo sia Windows).
     * 6) ArcGis Server: � nella forma "dominio;utente;pwd;host"
     * @param service String Eventuale nome del servizio/mappa, anche in questo caso dipendente dal tipo di map server.
     * 1) ArcIms: nome del servizio ArcIms pubblicato a cui si vuole accedere.
     * 2) GeoIn: nome del servizio GeoIn a cui si vuole accedere.
     * 3) Abaco: stringa vuota.
     * 4) WMS: nome del servizio WMS a cui si vuole accedere.
     * 5) Map server: stringa vuota.
     * 6) ArcGis Server: nome del servizio
     * @return String Restituisce l'identificatore di connessione se la connessione � avvenuta con successo; "Errore di Connessione al Map Server! " in caso
     * di errore di connessione; "Map server non riconosciuto" se il tipo di map server indicato non � tra quelli disponibili.
     * La stringa idMap dovr� essere utilizzata nelle successive invocazioni ai metodi esposti dal Web Service.
     */

    @Path("/initMapServer")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
    public String initMapServer(@QueryParam("mapServerType") int mapServerType,
                                @QueryParam("connString") String connString,
                                @QueryParam("service") String service) {
        scriviLog("Invocata initMapServer(" + mapServerType + "," + connString + "," + service + ")");
        scriviLog("Versione localizzatore_rest: ");
        String idMap = null;
        if (mapServerType == 6) {
             try {
                 MapServerBindingStub mapServer = new  MapServerBindingStub(connString);
                 String mapName = mapServer.getDefaultMapName();
                 com.esri.arcgisws.MapServerInfo serverInfo = mapServer.
                         getServerInfo(mapName);
                 MapDescription mDesc = serverInfo.getDefaultMapDescription();
                 ImageDisplay idisp = new ImageDisplay();
                 idisp.setImageHeight(500);
                 idisp.setImageWidth(500);
                 idisp.setImageDPI(96);

                 Calendar currenttime = Calendar.getInstance();
                 java.sql.Date sqldate = new java.sql.Date((currenttime.getTime()).getTime());
                 idMap = this.makeID();
                 this.writeDB(idMap, sqldate, connString, mapName, mDesc, idisp);
                 return idMap;
             }
             catch (Exception ex) {
                 scriviLog("Errore nell'inizializzazione della mappa!", ex);
                 return null;
             }
         }

        else {
            return "Map server non riconosciuto";
        }
    }

    //connessione al datasource
    private java.sql.Connection getDSConn() {
        Config config = new Config();
        boolean debug = Boolean.parseBoolean(config.getData("Debug"));
        if (debug) {
            try {
                String jdbcURL = "jdbc:oracle:thin:@192.168.7.209:1521:ora11e";
                Connection conn = null;
                String user ="LOCALIZZATORE" ;
                String passwd ="LOCALIZZATORE";
                /*String jdbcURL = "jdbc:oracle:thin:@vm114srv:1521:SIGT01";
                Connection conn = null;
                String user ="SITECOWS" ;
                String passwd ="R4WVxXAUTCX8sCr";*/
                Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
                conn = DriverManager.getConnection(jdbcURL,user,passwd);
                return conn;
            } catch (Exception e) {
                this.scriviLog(
                        "Errore durante la connessione al DB", e);
                return null;
            }
        }
        else {
            String datasource = config.getData("DataSource");
            try {
                //per tomcat
                javax.naming.Context initContext = new InitialContext();
                javax.naming.Context envContext = (javax.naming.Context) initContext.lookup("java:/comp/env");
                javax.sql.DataSource ds = (javax.sql.DataSource) envContext.lookup(datasource);
                Connection conn = ds.getConnection();
                conn.setAutoCommit(false);
                return conn;
            } catch (Exception e) {
                Hashtable ht = new Hashtable();
                try 
                {
                    //per jboss
                    javax.naming.Context initCtx = new javax.naming.InitialContext(ht);
                    javax.sql.DataSource ds = (javax.sql.DataSource) initCtx.lookup(datasource);
                    Connection conn = ds.getConnection();
                    conn.setAutoCommit(false);
                    return conn;
                }
                catch (Exception exc)
                {
                    this.scriviLog("Errore durante la connessione al DataSource", e);
                    return null;
                }
            }
        }
    }


    private void writeDB(String idMap, java.sql.Date data, String connString, String mapName, Object mapDesc, Object iDisp) {
        Connection conn = this.getDSConn();
        if (conn != null) {
            String sql = "INSERT INTO LOCALIZZATORE_SESSION (IDMAP, DATA, CONNSTRING, MAPNAME, MAPDESCRIPTION, IMAGEDISPLAY) ";
            sql += "VALUES (?,?,?,?,?,?)";
            try {
                ByteArrayOutputStream baosMapDesc = new ByteArrayOutputStream();
                ObjectOutputStream outMapDesc = new ObjectOutputStream(baosMapDesc);
                outMapDesc.writeObject(mapDesc);
                outMapDesc.close();

                ByteArrayOutputStream baosIDisp = new ByteArrayOutputStream();
                ObjectOutputStream oIDisp = new ObjectOutputStream(baosIDisp);
                oIDisp.writeObject(iDisp);
                oIDisp.close();

                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, idMap);
                ps.setDate(2, data);
                ps.setString(3, connString);
                ps.setString(4, mapName);
                ps.setBytes(5, baosMapDesc.toByteArray());
                ps.setBytes(6, baosIDisp.toByteArray());
                ps.execute();
                ps.close();
                conn.commit();
                conn.close();
            }
            catch (Exception e) {
                this.scriviLog("Errore durante la scrittura nel db", e);
            }
        }
    }

    private void updateDB(String idMap, String nomeColonna, Object obj) {
        Connection conn = this.getDSConn();
        if (conn != null) {
            String sql = "UPDATE LOCALIZZATORE_SESSION SET " + nomeColonna + " = ? ";
            sql += "WHERE IDMAP = '" + idMap + "'";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                if (nomeColonna.equalsIgnoreCase("MAPDESCRIPTION"))
                {
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ObjectOutputStream outMapDesc = new ObjectOutputStream(baos);
                    outMapDesc.writeObject((MapDescription) obj);
                    outMapDesc.close();
                    ps.setBytes(1, baos.toByteArray());
                }
                else if (nomeColonna.equalsIgnoreCase("IMAGEDISPLAY"))
                {
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ObjectOutputStream outMapDesc = new ObjectOutputStream(baos);
                    outMapDesc.writeObject((ImageDisplay) obj);
                    outMapDesc.close();
                    ps.setBytes(1, baos.toByteArray());

                }
                else if (nomeColonna.equalsIgnoreCase("DATA")) {
                    ps.setDate(1, (java.sql.Date) obj);
                }
                else {
                    ps.setString(1, obj.toString());
                }
                ps.execute();
                ps.close();
                conn.commit();
                conn.close();
            }
            catch (Exception e) {
                this.scriviLog("Errore durante l'update del db", e);
            }
        }
    }

    private Object readDB(String nomeColonna, String idMap) {
        Connection conn = this.getDSConn();
        if (conn != null) {
            String sql = "SELECT " + nomeColonna + " FROM LOCALIZZATORE_SESSION ";
            sql += "WHERE IDMAP = '" + idMap + "'";
            try {
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                Object result = null;
                while (rs.next()) {
                    if (!nomeColonna.equalsIgnoreCase("MAPDESCRIPTION") &&
                            !nomeColonna.equalsIgnoreCase("IMAGEDISPLAY")){
                        result = rs.getObject(nomeColonna);
                    }
                    else {
                        byte[] buf = rs.getBytes(nomeColonna);
                        if (buf != null) {
                            ObjectInputStream objectIn = new ObjectInputStream(
                                        new ByteArrayInputStream(buf));
                            result = objectIn.readObject();
                        }
                    }
                }
                rs.close();
                st.close();
                conn.close();
                return result;
            }
            catch (Exception e)
            {
                scriviLog("Errore durante la lettura del db", e);
                return null;
            }
        }
        else
            return null;
    }

    private String readDBSDE(String nomeColonna, String idLRS) {
        Connection conn = this.getDSConn();
        if (conn != null) {
            String sql = "SELECT " + nomeColonna + " FROM SDE_SESSION ";
            sql += "WHERE IDLRS = '" + idLRS + "'";
            try {
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                String result = null;
                while (rs.next()) {
                    result = rs.getString(nomeColonna);
                }
                rs.close();
                st.close();
                conn.close();
                return result;
            }
            catch (Exception e)
            {
                scriviLog("Errore durante la lettura del db", e);
                return null;
            }
        }
        else
            return null;
    }



    /**
     * Chiude la connessione al map server e cancella le immagini prodotte durante l'ulilizzo
     * dell'identificativo di connessione indicato.
     * @param idMap String Identificatore della connessione al map server.
     * @return boolean True se l'operazione � andata a buon fine, false altrimenti.
     */

    @Path("/closeMapServer")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
    public boolean closeMapServerJson(@QueryParam("idMap") String idMap) {
        scriviLog("Invocata closeMapServer("+ idMap + ")");
        try {
            System.gc();
            return true;
        }
        catch (Exception e) {
            scriviLog(e);
            System.gc();
            return false;
        }
    }
    
    @GET
    @Path("/saveCoord")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response saveCoord(@QueryParam("text") String text) {
        BufferedWriter writer = null;
        try 
        {
            String tempFolderPath = System.getProperty("jboss.server.temp.dir"); 
            if (tempFolderPath == null)
                tempFolderPath = System.getProperty("java.io.tmpdir");
            File file = new File(tempFolderPath + "\\coord.txt");
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(text);
            writer.flush();
            writer.close();
            ResponseBuilder response = Response.ok((Object) file);
            response.header("Content-Disposition",
                "attachment; filename=coord.txt");
            return response.build();
        }
        catch (Exception exc) {
            scriviLog("saveCoord: errore!", exc);
            return null;
        }
    };
    
    /**
     * Restituisce le coordinate della mappa nel punto specificato dell'immagine.
     * @param xImage int Coordinata x dell'immagine.
     * @param yImage int Coordinata y dell'immagine.
     * @param idMap String Identificatore della connessione al map server.
     * @return {@link Coord} Restituisce le coordinate della mappa nel punto specificato dell'immagine.
     */
    @Path("/mapCoord")
	@GET
	@Produces(MediaType.APPLICATION_XML)
    public Coord mapCoord(@QueryParam("xImage") int xImage,
                          @QueryParam("yImage") int yImage,
                          @QueryParam("idMap") String idMap) {
        scriviLog("Invocata mapCoord(" + xImage + "," + yImage + "," + idMap + ")");
        Coord coord = null;
        MapServerBindingStub mapServer = new MapServerBindingStub(this.readDB("CONNSTRING", idMap).toString());
        MapDescription mDesc = (MapDescription) this.readDB("MAPDESCRIPTION", idMap);
        ImageDisplay idisp = (ImageDisplay) this.readDB("IMAGEDISPLAY", idMap);
        try {
            coord = new Coord();
            ImageType it = new ImageType();
            it.setImageFormat(EsriImageFormat.esriImageJPG);
            it.setImageReturnType(EsriImageReturnType.esriImageReturnURL);
            int[] xImg = new int[1];
            int[] yImg = new int[1];
            xImg[0] = xImage;
            yImg[0] = yImage;
            MultipointN mp = (MultipointN) mapServer.toMapPoints(mDesc, idisp, xImg, yImg);
            coord.setX(((PointN)mp.getPointArray()[0]).getX());
            coord.setY(((PointN)mp.getPointArray()[0]).getY());
        } catch (Exception exc) {
            scriviLog("mapCoord: errore!", exc);
        }

        return coord;
    }


    /**
     * Restituisce la scala della mappa correntemente memorizzata.
     * @param idMap String Identificatore della connessione al map server.
     * @return double Restituisce la scala della mappa correntemente memorizzata.
     */
    @Path("/getScale")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })

    public double GetScale(@QueryParam("idMap") String idMap) {
        scriviLog("Invocata getScale(" + idMap + ")");
        double scale = 0.0;
        try {
            MapServerBindingStub mapServer = new MapServerBindingStub(this.readDB("CONNSTRING", idMap).toString());
            MapDescription mDesc = (MapDescription) this.readDB("MAPDESCRIPTION", idMap);
            ImageDisplay idisp = (ImageDisplay) this.readDB("IMAGEDISPLAY", idMap);
            scale = mapServer.computeScale(mDesc, idisp);
        } catch (Exception exc) {
            scriviLog("getScale: errore!", exc);
        }
        return scale;
    }


    /**
     * Evidenzia la primitiva ID_Feature del layer specificato ed eventualmente ci zoomma su
     * @param layerName String
     * @param id_feature String
     * @param makeZoom boolean
     * @param idMap String
     */
    @Path("/markerFeature")
	@GET
	@Produces({ MediaType.APPLICATION_XML })
    public MapURLs markerFeature(@QueryParam("layerName") String layerName,
                                 @QueryParam("where") String where,
                                 @QueryParam("makeZoom") boolean makeZoom,
                                 @QueryParam("idMap") String idMap) {
        scriviLog ("Invocata markerFeature(" + layerName + "," + where + "," + makeZoom + "," + idMap + ")");
        MapURLs mu = new MapURLs();
        try {
            MapServerBindingStub mapServer = new MapServerBindingStub(this.readDB("CONNSTRING", idMap).toString());
            MapDescription mDesc = (MapDescription) this.readDB("MAPDESCRIPTION", idMap);
            String mapName = this.readDB("MAPNAME", idMap).toString();

            QueryFilter filter = null;
            LayerDescription[] layerDescriptions = mDesc.getLayerDescriptions();
            MapLayerInfo[] layerInfos = mapServer.getServerInfo(mapName).getMapLayerInfos();
            int numLayers = layerInfos.length;

            for (int i = 0; i < numLayers; i++) {
                if (layerInfos[i].getName().equalsIgnoreCase(
                        layerName)) {
                    LayerDescription mapLayer = null;
                    if (layerInfos[i].getSubLayerIDs() != null
                        ||
                        !layerInfos[i].getLayerType().
                        equalsIgnoreCase("Feature Layer")) {
                        break;
                    }
                    for (int j = 0; j < layerDescriptions.length; j++) {
                        if (layerDescriptions[j].getLayerID() ==
                            layerInfos[i].getLayerID()) {
                            mapLayer = layerDescriptions[j];
                            break;
                        }
                    }
                    if (mapLayer.isVisible() == false)
                        break;

                    filter = new QueryFilter();
                    filter.setWhereClause(where);

                    FIDSet ids = mapServer.queryFeatureIDs(mapName, mapLayer.getLayerID(),
                            filter);
                    if (ids != null)
                        mapLayer.setSelectionFeatures(ids.getFIDArray());

                    com.esri.arcgisws.RecordSet recordset = mapServer.queryFeatureData(mapName, mapLayer.getLayerID(),
                            filter);
                    com.esri.arcgisws.EnvelopeN env = null;

                    if (recordset != null && recordset.getRecords().length > 0) {
                        double xMin = Double.MAX_VALUE;
                        double xMax = Double.MIN_VALUE;
                        double yMin = Double.MAX_VALUE;
                        double yMax = Double.MIN_VALUE;

                        for (int t = 0; t < recordset.getRecords().length; t++) {
                            com.esri.arcgisws.Record record = recordset.getRecords()[t];
                            for (int j = 0; j < recordset.getFields().getFieldArray().length; j++) {
                                com.esri.arcgisws.Field field = recordset.getFields().getFieldArray()[j];
                                if (field.getType() == EsriFieldType.esriFieldTypeGeometry) {
                                    java.lang.Object o = record.getValues()[j];
                                    if (o instanceof com.esri.arcgisws.PointN) {
                                        PointN p = (PointN) o;
                                        env = new EnvelopeN();
                                        env.setXMin(p.getX() - 1);
                                        env.setYMax(p.getX() + 1);
                                        env.setYMin(p.getX() - 1);
                                        env.setYMax(p.getX() + 1);
                                    }
                                    else if (o instanceof com.esri.arcgisws.MultipointN) {
                                        MultipointN p = (MultipointN) o;
                                        env = (EnvelopeN) p.getExtent();
                                    }
                                    else if (o instanceof com.esri.arcgisws.PolylineN) {
                                        PolylineN p = (PolylineN) o;
                                        env = (EnvelopeN) p.getExtent();
                                    }
                                    else if (o instanceof com.esri.arcgisws.PolygonN) {
                                        PolygonN p = (PolygonN) o;
                                        env = (EnvelopeN) p.getExtent();
                                    }
                                    if (env != null) {
                                        if (env.getXMin() < xMin)
                                            xMin = env.getXMin();
                                        if (env.getYMin() < yMin)
                                            yMin = env.getYMin();
                                        if (env.getXMax() > xMax)
                                            xMax = env.getXMax();
                                        if (env.getYMax() > yMax)
                                            yMax = env.getYMax();
                                    }
                                    if (xMin < Double.MAX_VALUE &&
                                        xMax > Double.MIN_VALUE &&
                                        yMin < Double.MAX_VALUE &&
                                        yMax > Double.MIN_VALUE) {
                                        MapExtent extent = new MapExtent();
                                        EnvelopeN envelope = new EnvelopeN();
                                        envelope.setXMin(xMin);
                                        envelope.setYMin(yMin);
                                        envelope.setXMax(xMax);
                                        envelope.setYMax(yMax);
                                        extent.setExtent(envelope);
                                        mDesc.setMapArea(extent);
                                    }
                                    break;
                                }
                            }
                        }
                    }
                    this.updateDB(idMap, "MAPDESCRIPTION", mDesc);
                    this.zoomScale((int)this.GetScale(idMap), idMap);
                }
            }
            return mu;
        } catch (Exception exc) {
            scriviLog("markerFeature: errore!", exc);
            mu.setErrore(exc.getMessage());
            return mu;
        }
    }


    /**
     * Esegue il pan sulla mappa a partire dal delta in pixel sull'immagine.
     * @param int dx Spostamento in pixel dell'immagine sull'asse delle X.
     * @param int dy Spostamento in pixel dell'immagine sull'asse delle Y.
     * @param idMap String Identificatore della connessione al map server.
     * @return MapURLs N.B. L'oggetto {@link MapURLs} ritornato non contiene i riferimenti all'immagine della mappa aggiornata, ma
     * � mantenuto solo per compatibilit� con versioni precedenti del software. Richiamare il metodo {@link #refreshMap refreshMap} per
     * ottenere un oggetto {@link MapURLs} con i riferimenti all'immagine della mappa aggiornata.
     */
    @Path("/panImg")
	@GET
	@Produces({ MediaType.APPLICATION_XML })
    public MapURLs panImg(@QueryParam("dx") int dx,
                          @QueryParam("dy")int dy,
                          @QueryParam("idMap") String idMap) {
        MapURLs mu = new MapURLs();
        try {
            MapDescription mDesc = (MapDescription) this.readDB("MAPDESCRIPTION", idMap);
            ImageDisplay idisp = (ImageDisplay) this.readDB("IMAGEDISPLAY", idMap);
            ImageType it = new ImageType();
            it.setImageFormat(EsriImageFormat.esriImageJPG);
            it.setImageReturnType(EsriImageReturnType.esriImageReturnURL);
            Coord max = mapCoord(idisp.getImageWidth() + dx, idisp.getImageHeight() + dy, idMap);
            Coord min = mapCoord((int) dx, (int) dy, idMap);
            MapExtent extent = new MapExtent();
            EnvelopeN envelope = new EnvelopeN();
            envelope.setXMin(Math.min(max.getX(), min.getX()));
            envelope.setXMax(Math.max(max.getX(), min.getX()));
            envelope.setYMin(Math.min(max.getY(), min.getY()));
            envelope.setYMax(Math.max(max.getY(), min.getY()));
            extent.setExtent(envelope);
            mDesc.setMapArea(extent);
            this.updateDB(idMap, "MAPDESCRIPTION", mDesc);
            return mu;
        } catch (Exception exc) {
            scriviLog("panImg: errore!", exc);
            mu.setErrore(exc.getMessage());
            return mu;
        }
    }


    /**
     * Esegue il pan sulla mappa a partire dal delta indicato.
     * @param dx double Spostamento nell'unit� di misura della mappa sull'asse delle X.
     * @param dy double Spostamento nell'unit� di misura della mappa sull'asse delle Y.
     * @param idMap String Identificatore della connessione al map server.
     * @return MapURLs N.B. L'oggetto {@link MapURLs} ritornato non contiene i riferimenti all'immagine della mappa aggiornata, ma
     * � mantenuto solo per compatibilit� con versioni precedenti del software. Richiamare il metodo {@link #refreshMap refreshMap} per
     * ottenere un oggetto {@link MapURLs} con i riferimenti all'immagine della mappa aggiornata.
     */
    @Path("/panMap")
	@GET
	@Produces({ MediaType.APPLICATION_XML })
    public MapURLs panMap(@QueryParam("dx") double dx,
                          @QueryParam("dy") double dy,
                          @QueryParam("idMap") String idMap) {
        MapURLs mu = new MapURLs();
        try {
            GenEnvelope envelope = getMapEnvelope(idMap);
            zoomToEnvelope(envelope.getMaxX() + dx, envelope.getMaxY() + dy,
                           envelope.getMinX() + dx, envelope.getMinY() + dy, idMap);
            return mu;
        } catch (Exception exc) {
            scriviLog(exc);
            mu.setErrore(exc.getMessage());
            return mu;
        }
    }

    /**
     * Interrogga il layer dei fogli catastali nel punto X,Y e restituisce la particella
     * @param x double
     * @param y double
     * @param parcelLayer String nome del layer delle particelle catastali
     * @param idMap String
     * @return Particella la particella catastale
     */
    @Path("/queryParcel")
	@GET
	@Produces({ MediaType.APPLICATION_XML })
    public Particella queryParcel(@QueryParam("x") double x,
                                  @QueryParam("y") double y,
                                  @QueryParam("parcelLayer") String parcelLayer,
                                  @QueryParam("idMap") String idMap) {
        Particella particella = new Particella();

        /*if (WSSession.getConnection(idConn) instanceof oracle.jdbc.
            OracleConnection) {
            //apro una connessione dal pool
            OracleConnection conn = (OracleConnection)
                                    WSSession.getConnection(idConn);
        }

        else if (WSSession.getConnection(idConn) instanceof
                 com.esri.sde.sdk.client.SeConnection) {
            SeConnection conn = (SeConnection) WSSession.getConnection(idConn);
            SeLayer layer = null;
            String comune = null;
            String mappale = null;
            String foglio = null;
            try {
                layer = new SeLayer(conn, parcelLayer, shapeCol);
                if (layer == null) {
                    return null;
                }

                SeTable table = new SeTable(conn, parcelLayer);
                SeCoordinateReference coordref = layer.getCoordRef();
                SeShape point = null;
                point = new SeShape(coordref);
                SDEPoint[] ptArray = new SDEPoint[1];
                ptArray[0] = new SDEPoint(x, y);
                point.generatePoint(1, ptArray);
                ((SDEPoint[]) point.getPoints(SeShape.TURN_DEFAULT, 1).get(0))[
                        0].setX(x);
                ((SDEPoint[]) point.getPoints(SeShape.TURN_DEFAULT, 1).get(0))[
                        0].setY(y);

                SeShapeFilter[] filters = new SeShapeFilter[1];
                SeShapeFilter filter = new SeShapeFilter(parcelLayer, shapeCol,
                        point, SeFilter.METHOD_AI, true);
                filters[0] = filter;

                SeColumnDefinition[] tableDef = table.describe();
                String[] cols = new String[tableDef.length];
                for (int i = 0; i < tableDef.length; i++) {
                    cols[i] = tableDef[i].getName();
                }
                SeQuery spatialQuery = null;
                SeSqlConstruct sqlCons = new SeSqlConstruct(parcelLayer);
                spatialQuery = new SeQuery(conn, cols, sqlCons);
                spatialQuery.prepareQuery();

                spatialQuery.setSpatialConstraints(SeQuery.SE_OPTIMIZE, false,
                        filters);
                spatialQuery.execute();
                // Only retrieves shapes...
                SeRow row = spatialQuery.fetch();
                SeColumnDefinition colDef = new SeColumnDefinition();
                int numCols = 0;
                try {
                    if (row != null)
                        numCols = row.getNumColumns();
                } catch (NullPointerException ne) {
                    spatialQuery.close();
                    return null;
                }

                while (row != null) {
                    for (int i = 0; i < numCols; i++) {
                        if (row.getColumns()[i].getName().toLowerCase().equals(
                                comuneCol.toLowerCase())) {
                            comune = row.getString(i);
                        } else if (row.getColumns()[i].getName().toLowerCase().
                                   equals(foglioCol.toLowerCase())) {
                            foglio = row.getString(i);
                        } else if (row.getColumns()[i].getName().toLowerCase().
                                   equals(mappaleCol.toLowerCase())) {
                            mappale = row.getString(i);
                        }
                    } // End for
                    row = spatialQuery.fetch();
                } // End while
                spatialQuery.close();
                particella = new Particella();
                particella.setComune(comune);
                particella.setFoglio(foglio);
                particella.setMappale(mappale);

                table = new SeTable(conn, "CATASTO.CT_COD_COMUNE");
                tableDef = table.describe();
                cols = new String[tableDef.length];
                for (int i = 0; i < tableDef.length; i++) {
                    cols[i] = tableDef[i].getName();
                }
                spatialQuery = null;
                sqlCons = new SeSqlConstruct("CATASTO.CT_COD_COMUNE");
                sqlCons.setWhere("CODICE = '" + particella.getComune() + "'");
                spatialQuery = new SeQuery(conn, cols, sqlCons);
                spatialQuery.prepareQuery();
                spatialQuery.execute();
                row = spatialQuery.fetch();
                colDef = new SeColumnDefinition();
                numCols = 0;
                try {
                    if (row != null)
                        numCols = row.getNumColumns();
                } catch (NullPointerException ne) {
                    spatialQuery.close();
                    return null;
                }

                while (row != null) {
                    for (int i = 0; i < numCols; i++) {
                        if (row.getColumns()[i].getName().toLowerCase().equals(
                                "descrizione")) {
                            particella.setComune(row.getString(i).trim());
                        }
                    } // End for
                    row = spatialQuery.fetch();
                } // End while

            } catch (Exception e) {
                scriviLog(e);
                System.out.println(e.getMessage());
            }
        }

        //shapefile
        else if (WSSession.getConnection(idConn) instanceof com.siteco.
                 JRs40DynSeg.DynSeg) {
            try {
            } catch (Exception e) {
                scriviLog(e);
            }
        }

        //abaco
        else if (WSSession.getConnection(idConn) instanceof com.siteco.
                 JRs40DynSeg.DynSegDB) {
            try {
            } catch (Exception e) {
                scriviLog(e);
            }
        }*/

        return particella;
    }

    /**
     *
     * @param String comune.
     * @param String foglio.
     * @param String mappale.
     * @param idMap String Identificativo di connessione al mapserver.
     */
    @Path("/zoomToParcel")
	@GET
	@Produces({ MediaType.APPLICATION_XML })
    public MapURLs zoomToParcel(@QueryParam("comune") String comune,
                                @QueryParam("foglio") String foglio,
                                @QueryParam("mappale") String mappale,
                                @QueryParam("idMap") String idMap) {
        return new MapURLs();
    }

    /**
     * Restituisce la {@link Progressiva} ricavata dal punto di coordinate x e y
     * @param x double
     * @param y double
     * @param asta String Eventuale condizione di ricerca per limitare le strade da considerare.
     * @param idConn String Identificativo di connessione al motore LRS (Linear Referencing System).
     * @param callback String indica una chiamata jsonp
     * @return {@link Progressiva} ricavata dal punto di coordinate x e y.
     */
    @Path("/queryProgJson")
    @GET
    @Produces({"application/javascript"})
    public String queryProgJson(@QueryParam("x") double x,
            @QueryParam("y") double y,
            @QueryParam("asta") String asta,
            @QueryParam("idConn") String idConn,
            @QueryParam("callback") String callback) {
        scriviLog("Invocata queryProg(" + x + "," + y + "," + asta + "," + idConn + ")");
        Progressiva prog = new Progressiva();

        //se sono connesso ad oracle
        /*if (WSSession.getConnection(idConn) instanceof oracle.jdbc.
            OracleConnection) {
            //apro una connessione dal pool
            OracleConnection conn = (OracleConnection)
                                    WSSession.getConnection(idConn);

            //campi del layer delle progressive
            prog.setRoad_id("-2");
            String roadId = null;
            String geomCol = null;
            //id della strada pi� vicina al punto da proiettare
            long idStrada = -1;
            //geometria della strada pi� vicina al punto da proiettare
            oracle.spatial.geometry.JGeometry stradaGeom = null;
            //geometria del punto proiettato
            oracle.spatial.geometry.JGeometry projPoint = null;
            //offset del punto proiettato
            double offset = Double.NaN;
            double xp = Double.NaN, yp = Double.NaN;
            try {
                PtPrjM res = this.projPT(x, y, WSSession.ROADIDCOL,
                                         WSSession.GEOMCOL, WSSession.ROADTABLE,
                                         conn, asta);
                roadId = WSSession.ROADIDCOL;
                geomCol = WSSession.GEOMCOL;

                oracle.sql.STRUCT dbObject = null;

                String query = "";
                PreparedStatement ps = null;
                OracleResultSet ors = null;

                //
                res.dim = 4;
                //
                double[] v = new double[res.dim];
                v[0] = res.getX();
                v[1] = res.getY();
                if (res.dim == 4) {
                    v[2] = 0;
                    v[3] = 0;
                }
                if (res.dim == 3) {
                    v[2] = 0;
                }
                projPoint = oracle.spatial.geometry.JGeometry.createLRSPoint(v,
                        res.dim - 1, res.srid);
                try {
                    //calcolo la progressiva; inizio con l'offset
                    query = "SELECT SDO_LRS.FIND_OFFSET(" + geomCol +
                            ",?,0.0001) FROM " + asta + "." +
                            WSSession.ROADTABLE + " WHERE " + roadId +
                            " =?" +
                            " AND DATAFINE = 20991231";
                    ps = conn.prepareStatement(query);
                    dbObject = oracle.spatial.geometry.JGeometry.store(
                            projPoint, conn);

                    ps.setObject(1, dbObject);
                    ps.setLong(2, res.getId());
                    ors = (OracleResultSet) ps.executeQuery();
                    while (ors.next()) {
                        prog.setOffset(ors.getDouble(1));
                    }
                    ps.close();
                    ors.close();

                } catch (Exception qqq) {
                    query = "SELECT SDO_LRS.FIND_OFFSET(" + geomCol +
                            ",?,0.0001) FROM " + asta + "." +
                            WSSession.ROADTABLE + " WHERE " + roadId +
                            " =?";
                    ps = conn.prepareStatement(query);
                    dbObject = oracle.spatial.geometry.JGeometry.store(
                            projPoint, conn);

                    ps.setObject(1, dbObject);
                    ps.setLong(2, res.getId());
                    ors = (OracleResultSet) ps.executeQuery();
                    while (ors.next()) {
                        prog.setOffset(ors.getDouble(1));
                    }
                    ps.close();
                    ors.close();
                }
                prog.setRoad_id(Long.toString(res.getId()));
                prog.setM(res.getM());
                prog.setXPro(res.getXPro());
                prog.setYPro(res.getYPro());
                if (WSSession.VERSION.compareToIgnoreCase("SISASPI_1.0") == 0)
                    conn.close();
            } catch (Exception e) {
                scriviLog(e);
                e.getMessage();
            }
        }

        else */
        //if (getConnection(idConn) instanceof
        //         com.esri.sde.sdk.client.SeConnection) {
        if (
                getConnection("percorsim") != null &&
                getConnection("percorsim") instanceof com.siteco.JRs40DynSeg.DynSeg) {
            try {
                DynSeg dynSeg = (DynSeg) getConnection("percorsim");
                SHPPoint pt = new SHPPoint(x, y);
                SHPprjptm prjptm = dynSeg.DSGetMeasure(pt, "");
                prog.setM(prjptm.mval);
                prog.setXPro(prjptm.ptprj.x);
                prog.setYPro(prjptm.ptprj.y);
                prog.setRoad_id(prjptm.route);
                prog.setOffset(prjptm.Offset);
                
                int rowId = dynSeg.getRecordIndexFromId(prjptm.route);
                String denominazione = dynSeg.getFieldValue(rowId, "DENOMINAZI");
                String sigla = dynSeg.getFieldValue(rowId, "SIGLA");
                prog.setDenominazione(denominazione);
                prog.setSigla(sigla);
            }
            catch (Exception e) {
                scriviLog(e);
            }
            
            JSONObject res = new JSONObject(prog);
            if (callback != null && callback.length() > 0) {
                return callback + "(" + res.toString() + ")";
            } else {
                return res.toString();
            }
        }
        
        
        
        try {
            SeConnection conn = this.getSDEConn(idConn);
            String roadLayer = this.readDBSDE("ROADLAYER", idConn);
            SeLayer layer = null;
            if (!conn.isClosed()) {
                Vector layers = conn.getLayers();
                for (int i = 0; i < layers.size(); i++) {
                    if (((SeLayer) layers.get(i)).getName().equalsIgnoreCase(roadLayer)
                            || ((SeLayer) layers.get(i)).getName().equalsIgnoreCase(roadLayer.replace("SIG_ADM.", ""))) {
                        layer = (SeLayer) layers.get(i);
                        break;
                    }
                }
                //layer = new SeLayer(conn, roadLayer, idCol);
            }
            if (layer == null) {
                JSONObject res = new JSONObject();
                if (callback != null && callback.length() > 0) {
                    return callback + "(" + res.toString() + ")";
                } else {
                    return res.toString();
                }
            }


            /*Vector tabls = conn.getTables(SeDefs.SE_SELECT_PRIVILEGE);
                SeTable table1 = null;
                for (int i = 0; i < tabls.size(); i++) {
                    if (((SeTable) tabls.get(i)).getQualifiedName().matches(
                            WSSession.getRoadLayer(idConn).toString())) {
                        table1 = (SeTable) tabls.get(i);
                        break;
                    }
                }
                //table1 = new SeTable(conn, WSSession.getRoadLayer(idConn).toString());

                if (table1 == null) {
                    return null;
                }*/
            SeSqlConstruct sqlConstruct = new SeSqlConstruct(layer.getQualifiedName());
            if (asta != null && asta.trim().length() > 0) {
                sqlConstruct.setWhere(asta);
            }
            /*SeColumnDefinition[] tableDef = table1.describe();
                String[] cols = new String[tableDef.length];

                int geomIndex = -1;
                int colIdIndex = -1;

                for (int i = 0; i < tableDef.length; i++) {
                    cols[i] = tableDef[i].getName();
                    if (layer.getSpatialColumn().matches(tableDef[i].getName())) {
                        geomIndex = i;
                    }
                    if (tableDef[i].getName().matches(WSSession.getIdCol(idConn).
                                                      toString())) {
                        colIdIndex = i;
                    }
                }

                if (geomIndex == -1 || colIdIndex == -1) {
                    return null;
                }*/
            String[] cols = new String[2];
            cols[0] = this.readDBSDE("IDCOL", idConn);
            cols[1] = layer.getSpatialColumn();
            SeQuery query = new SeQuery(conn, cols, sqlConstruct);

            query.prepareQuery();
            query.execute();
            ArrayList CollObjs = new ArrayList();
            ArrayList Ids = new ArrayList();

            SeRow row = query.fetch();
            int count = 0;

            while (row != null) {
                try {
                    SeColumnDefinition[] colDefs = row.getColumns();
                    SeShape shp = null;
                    for (int colNum = 0; colNum < 2; colNum++) {
                        int dataType = colDefs[colNum].getType();
                        // Assuming that the columns we retrieve are either string or shape data type
                        // Add more case statements to retrieve all possible SDE data types.
                        // ( See Working with Layers Example )
                        switch (dataType) {
                            case SeColumnDefinition.TYPE_SHAPE:
                                shp = row.getShape(colNum);

                                // Call a function to retrieve the shape attributes
                                break;
                            default:
                                Ids.add(row.getObject(colNum));
                        }
                    }

                    //SeShape shp = row.getShape(geomIndex);
                    //Ids.add(row.getObject(colIdIndex));
                    SHPObject obj = new SHPObject();
                    obj.nSHPType = 23;
                    obj.nParts = shp.getNumParts();
                    obj.nVertices = shp.getNumOfPoints();
                    obj.nShapeId = count++;
                    obj.IsShapeNull = false;

                    SHPPoly pol;
                    SHPPoint pt;

                    for (int k = 1; k < shp.getNumParts() + 1; k++) {
                        pol = new SHPPoly();
                        ArrayList list = shp.getPoints(SeShape.TURN_DEFAULT,
                                k);
                        SDEPoint[] pointsPerPart = (SDEPoint[]) list.get(0);
                        for (int t = 0; t < pointsPerPart.length; t++) {
                            pt = new SHPPoint(pointsPerPart[t].getX(),
                                    pointsPerPart[t].getY());
                            if (shp.is3D()) {
                                pt.z = pointsPerPart[t].getZ();
                            }
                            if (shp.isMeasured()) {
                                pt.m = pointsPerPart[t].getM();
                                if (pt.m < prog.getMMin()) {
                                    prog.setMMin(pt.m);
                                }
                                if (pt.m > prog.getMMax()) {
                                    prog.setMMax(pt.m);
                                }
                            }
                            pol.SHPAddPoint(pt);
                        }
                        obj.AddPoly(pol);
                    }
                    obj.SHPCalBox();
                    obj.SHPCalLenght();

                    CollObjs.add(obj);
                    row = query.fetch();
                } catch (Exception exc) {
                    System.out.println(exc.getMessage());
                    query.close();
                }
                //row = query.fetch();
            }

            query.close();
            conn.close();

            SHPPoint pt = new SHPPoint(x, y);
            double dst = Double.NaN;
            double dmin = Double.MAX_VALUE;
            double xPro = Double.NaN;
            double yPro = Double.NaN;
            String route = null;
            double measuremin = Double.NaN;
            boolean find = false;

            SHPprjptm prjptm = new SHPprjptm();
            for (int i = 0; i < CollObjs.size(); i++) {
                SHPObject shpobj = (SHPObject) CollObjs.get(i);
                if (shpobj == null
                        || shpobj.nSHPType == tipo_shpobj.NULLSHAPE
                        || shpobj.vpolilinee == null) {
                    continue;
                }
                int nparti = shpobj.vpolilinee.size();
                for (int j = 0; j < nparti; j++) {
                    SHPPoly pol = (SHPPoly) (shpobj.vpolilinee.get(j));
                    //prjptm = new SHPprjptm();
                    prjptm.pto = pt;
                    //prjptm.ptprj = ptprj;
                    int nint = pol.SHPprjptm(prjptm);
                    if (nint != 1) {
                        continue;
                    }
                    dst = pt.SHPdstpt(prjptm.ptprj);
                    if (dst < dmin) {
                        dmin = dst;
                        measuremin = prjptm.mval;
                        if (Ids.get(i) instanceof Integer) {
                            prjptm.route = route = Integer.toString(Integer.parseInt(
                                    Ids.get(i).toString()));
                        } else if (Ids.get(i) instanceof Long) {
                            prjptm.route = route = Long.toString(Long.parseLong(Ids.get(
                                    i).toString()));
                        } else if (Ids.get(i) instanceof Double) {
                            DecimalFormat df = new DecimalFormat(
                                    "##########.##########");
                            prjptm.route = route = df.format(Double.
                                    parseDouble(Ids.get(i).toString()));
                        } else if (Ids.get(i) instanceof Float) {
                            DecimalFormat df = new DecimalFormat(
                                    "##########.##########");
                            prjptm.route = route = df.format(Float.
                                    parseFloat(Ids.get(i).toString()));
                        } else {
                            prjptm.route = route = Ids.get(i).toString();
                        }
                        xPro = prjptm.ptprj.x;
                        yPro = prjptm.ptprj.y;
                        //route = Ids.get(i).toString();
                        find = true;
                    }
                }
            }
            /*System.out.println("dmin " + dmin);
                System.out.println("measuremin " + measuremin);
                System.out.println("x: " + prjptm.ptprj.x);
                System.out.println("y: " + prjptm.ptprj.y);
                System.out.println("measuremin " + measuremin);*/

            prog.setM(measuremin);
            int k = route.lastIndexOf('.');
            if (k != -1) {
                route = route.substring(0, k);
            }
            prog.setRoad_id(route);
            prog.setOffset(dmin);
            prog.setXPro(xPro);
            prog.setYPro(yPro);

            /*prog.setM(prjptm.mval);
                prog.setRoad_id(Long.parseLong(prjptm.route));
                prog.setOffset(prjptm.Offset);
                prog.setXPro(prjptm.ptprj.x);
                prog.setYPro(prjptm.ptprj.y);*/
            if (!find) {
                JSONObject res = new JSONObject();
                if (callback != null && callback.length() > 0) {
                    return callback + "(" + res.toString() + ")";
                } else {
                    return res.toString();
                }
            }
        } catch (Exception e) {
            scriviLog(e);
            System.out.println(e.getMessage());
        }
        /*}

        //shapefile
        else if (getConnection(idConn) instanceof com.siteco.JRs40DynSeg.DynSeg) {
            try {
                DynSeg dynSeg = (DynSeg) getConnection(idConn);
                SHPPoint pt = new SHPPoint(x, y);
                SHPprjptm prjptm = dynSeg.DSGetMeasure(pt, "");
                prog.setM(prjptm.mval);
                prog.setXPro(prjptm.ptprj.x);
                prog.setYPro(prjptm.ptprj.y);
                prog.setRoad_id(prjptm.route);
                prog.setOffset(prjptm.Offset);
            }
            catch (Exception e) {
                scriviLog(e);
            }
        }

        //abaco
        /*else if (WSSession.getConnection(idConn) instanceof com.siteco.JRs40DynSeg.DynSegDB) {
            try {
                DynSegDB dynSeg = (DynSegDB) WSSession.getConnection(idConn);
                SHPPoint pt = new SHPPoint(x, y);
                SHPprjptm prjptm = dynSeg.DSGetMeasure(pt, "");
                prog.setM(prjptm.mval);
                prog.setXPro(prjptm.ptprj.x);
                prog.setYPro(prjptm.ptprj.y);
                //prog.setRoad_id(Long.parseLong(prjptm.route));
                prog.setRoad_id(prjptm.route);
                prog.setOffset(prjptm.Offset);
            }
            catch (Exception e) {
                scriviLog(e);
            }
        }*/
        JSONObject res = new JSONObject(prog);
        if (callback != null && callback.length() > 0) {
            return callback + "(" + res.toString() + ")";
        } else {
            return res.toString();
        }
    }

    @Path("/queryProg")
    @GET
    @Produces({"application/xml"})
    public Progressiva queryProg(@QueryParam("x") double x, @QueryParam("y") double y, @QueryParam("asta") String asta, @QueryParam("idConn") String idConn) {
        scriviLog("Invocata queryProg(" + x + "," + y + "," + asta + "," + idConn + ")");
        Progressiva prog = new Progressiva();
        if (((getConnection(idConn) instanceof SeConnection))
                || (getConnection(idConn) == null)) {
            try {
                SeConnection conn = getSDEConn(idConn);
                String roadLayer = readDBSDE("ROADLAYER", idConn);
                SeLayer layer = null;
                if (!conn.isClosed()) {
                    Vector layers = conn.getLayers();
                    for (int i = 0; i < layers.size(); i++) {
                        if ((((SeLayer) layers.get(i)).getName().equalsIgnoreCase(roadLayer))
                                || (((SeLayer) layers.get(i)).getName().equalsIgnoreCase(roadLayer.replace("SIG_ADM.", "")))) {
                            layer = (SeLayer) layers.get(i);
                            break;
                        }
                    }
                }
                if (layer == null) {
                    return null;
                }
                SeSqlConstruct sqlConstruct = new SeSqlConstruct(layer.getQualifiedName());
                if ((asta != null) && (asta.trim().length() > 0)) {
                    sqlConstruct.setWhere(asta);
                }
                String[] cols = new String[2];
                cols[0] = readDBSDE("IDCOL", idConn);
                cols[1] = layer.getSpatialColumn();
                SeQuery query = new SeQuery(conn, cols, sqlConstruct);

                query.prepareQuery();
                query.execute();
                ArrayList CollObjs = new ArrayList();
                ArrayList Ids = new ArrayList();

                SeRow row = query.fetch();
                int count = 0;
                while (row != null) {
                    try {
                        SeColumnDefinition[] colDefs = row.getColumns();
                        SeShape shp = null;
                        for (int colNum = 0; colNum < 2; colNum++) {
                            int dataType = colDefs[colNum].getType();
                            switch (dataType) {
                                case 8:
                                    shp = row.getShape(colNum);

                                    break;
                                default:
                                    Ids.add(row.getObject(colNum));
                            }
                        }
                        SHPObject obj = new SHPObject();
                        obj.nSHPType = 23;
                        obj.nParts = shp.getNumParts();
                        obj.nVertices = shp.getNumOfPoints();
                        obj.nShapeId = (count++);
                        obj.IsShapeNull = false;
                        for (int k = 1; k < shp.getNumParts() + 1; k++) {
                            SHPPoly pol = new SHPPoly();
                            ArrayList list = shp.getPoints(0, k);

                            SDEPoint[] pointsPerPart = (SDEPoint[]) list.get(0);
                            for (int t = 0; t < pointsPerPart.length; t++) {
                                SHPPoint pt = new SHPPoint(pointsPerPart[t].getX(), pointsPerPart[t].getY());
                                if (shp.is3D()) {
                                    pt.z = pointsPerPart[t].getZ();
                                }
                                if (shp.isMeasured()) {
                                    pt.m = pointsPerPart[t].getM();
                                    if (pt.m < prog.getMMin()) {
                                        prog.setMMin(pt.m);
                                    }
                                    if (pt.m > prog.getMMax()) {
                                        prog.setMMax(pt.m);
                                    }
                                }
                                pol.SHPAddPoint(pt);
                            }
                            obj.AddPoly(pol);
                        }
                        obj.SHPCalBox();
                        obj.SHPCalLenght();

                        CollObjs.add(obj);
                        row = query.fetch();
                    } catch (Exception exc) {
                        System.out.println(exc.getMessage());
                        query.close();
                    }
                }
                query.close();
                conn.close();

                SHPPoint pt = new SHPPoint(x, y);
                double dst = (0.0D / 0.0D);
                double dmin = 1.7976931348623157E+308D;
                double xPro = (0.0D / 0.0D);
                double yPro = (0.0D / 0.0D);
                String route = null;
                double measuremin = (0.0D / 0.0D);
                boolean find = false;

                SHPprjptm prjptm = new SHPprjptm();
                for (int i = 0; i < CollObjs.size(); i++) {
                    SHPObject shpobj = (SHPObject) CollObjs.get(i);
                    if ((shpobj != null) && (shpobj.nSHPType != tipo_shpobj.NULLSHAPE) && (shpobj.vpolilinee != null)) {
                        int nparti = shpobj.vpolilinee.size();
                        for (int j = 0; j < nparti; j++) {
                            SHPPoly pol = (SHPPoly) shpobj.vpolilinee.get(j);

                            prjptm.pto = pt;

                            int nint = pol.SHPprjptm(prjptm);
                            if (nint == 1) {
                                dst = pt.SHPdstpt(prjptm.ptprj);
                                if (dst < dmin) {
                                    dmin = dst;
                                    measuremin = prjptm.mval;
                                    if ((Ids.get(i) instanceof Integer)) {
                                        prjptm.route = (route = Integer.toString(Integer.parseInt(Ids
                                                .get(i).toString())));
                                    } else if ((Ids.get(i) instanceof Long)) {
                                        prjptm.route = (route = Long.toString(Long.parseLong(Ids.get(i)
                                                .toString())));
                                    } else if ((Ids.get(i) instanceof Double)) {
                                        DecimalFormat df = new DecimalFormat("##########.##########");

                                        prjptm.route = (route = df.format(
                                                Double.parseDouble(Ids.get(i).toString())));
                                    } else if ((Ids.get(i) instanceof Float)) {
                                        DecimalFormat df = new DecimalFormat("##########.##########");

                                        prjptm.route = (route = df.format(
                                                Float.parseFloat(Ids.get(i).toString())));
                                    } else {
                                        prjptm.route = (route = Ids.get(i).toString());
                                    }
                                    xPro = prjptm.ptprj.x;
                                    yPro = prjptm.ptprj.y;

                                    find = true;
                                }
                            }
                        }
                    }
                }
                prog.setM(measuremin);
                int k = route.lastIndexOf('.');
                if (k != -1) {
                    route = route.substring(0, k);
                }
                prog.setRoad_id(route);
                prog.setOffset(dmin);
                prog.setXPro(xPro);
                prog.setYPro(yPro);
                if (!find) {
                    return null;
                }
            } catch (Exception e) {
                scriviLog(e);
                System.out.println(e.getMessage());
            }
        } else if ((getConnection(idConn) instanceof DynSeg)) {
            try {
                DynSeg dynSeg = (DynSeg) getConnection(idConn);
                SHPPoint pt = new SHPPoint(x, y);
                SHPprjptm prjptm = dynSeg.DSGetMeasure(pt, "");
                prog.setM(prjptm.mval);
                prog.setXPro(prjptm.ptprj.x);
                prog.setYPro(prjptm.ptprj.y);
                prog.setRoad_id(prjptm.route);
                prog.setOffset(prjptm.Offset);
            } catch (Exception e) {
                scriviLog(e);
            }
        }
        return prog;
    }
    /**
     * projPT
     *
     * @param x double
     * @param y double
     * @param colID String
     * @param colGeom String
     * @param table String
     * @param conn OracleConnection
     * @param asta String
     * @return PtPrjM
     */
    private PtPrjM projPT(double x, double y, String colID, String colGeom,
                          String table, OracleConnection conn, String asta) {
        PtPrjM ptj = new PtPrjM(x, y);
        //id della strada pi� vicina al punto da proiettare
        oracle.spatial.geometry.JGeometry ptProj = null;
        ptj.setId(Long.MIN_VALUE);
        //geometria della strada pi� vicina al punto da proiettare
        oracle.spatial.geometry.JGeometry stradaGeom = null;
        //geometria del punto proiettato
        ptProj = null;
        //offset del punto proiettato
        ptj.setOffset(Double.NaN);

        try {
            int srid = 0;
            int dim = 0;

            oracle.sql.STRUCT dbObject = null;

            //ricavo la dimensione, la dimensione della misura, e il sistema di riferimento della tabella dei percorsi
            String query = "SELECT " + colGeom + " FROM " + asta + "." + table +
                           " R WHERE ROWNUM = 1";
            PreparedStatement ps = conn.prepareStatement(query);
            OracleResultSet ors = (OracleResultSet) ps.executeQuery();
            while (ors.next()) {
                dbObject = (oracle.sql.STRUCT) ors.getObject(1);
                stradaGeom = oracle.spatial.geometry.JGeometry.load(dbObject);
                srid = stradaGeom.getSRID();
                dim = stradaGeom.getDimensions();
                ptj.dim = dim;
                ptj.srid = srid;
            }

            //coordinate del punto da proiettare
            double[] coord;
            if (dim == 2) {
                //coordinate del punto da proiettare
                coord = new double[2];
                coord[0] = x;
                coord[1] = y;
            } else if (dim == 3) {
                //coordinate del punto da proiettare
                //coord = new double[3];
                coord = new double[2];
                coord[0] = x;
                coord[1] = y;
               // coord[2] = 0;
            } else if (dim == 4) {
                //coordinate del punto da proiettare
                //coord = new double[4];
                coord = new double[2];
                coord[0] = x;
                coord[1] = y;
                //coord[2] = 0;
                //coord[3] = 0;
            } else {
                ptj.setId( -1);
                return ptj;
            }

            //punto da proiettare
            //oracle.spatial.geometry.JGeometry jPoint = oracle.spatial.geometry.
            //        JGeometry.createPoint(coord, dim, srid);
            oracle.spatial.geometry.JGeometry jPoint = oracle.spatial.geometry.
                    JGeometry.createPoint(coord, 2, srid);
            //ricavo l'id della strada pi� vicina al punto e la geometria associata
            dbObject = oracle.spatial.geometry.JGeometry.store(jPoint, conn);


            //verifico che se ci sono i campi data
            try
            {
                query = "SELECT " + colID + "," + colGeom +
                        " ,sdo_nn_distance (1) distMM FROM " + asta + "." +
                        table +
                        " R WHERE SDO_NN(R." + colGeom +
                        ",?,'sdo_num_res=4',1) = 'TRUE' " +
                        "AND DATAFINE = 20991231 order by distMM";
                ps = conn.prepareStatement(query);
                ps.setObject(1, dbObject);
                ors = (OracleResultSet) ps.executeQuery();
                while (ors.next()) {
                    ptj.setId(ors.getLong(1)); // Long.parseLong(ors.getObject(1).toString());
                    dbObject = (oracle.sql.STRUCT) ors.getObject(2);
                    stradaGeom = oracle.spatial.geometry.JGeometry.load(
                            dbObject);
                    break;
                }
                if (ptj.getId() == Long.MIN_VALUE) {
                    ptj.setId( -2);
                    return ptj;
                }
            }
            catch (Exception exc)
            {
                query = "SELECT " + colID + "," + colGeom +
                        " ,sdo_nn_distance (1) distMM FROM " + asta + "." +
                        table +
                        " R WHERE SDO_NN(R." + colGeom +
                        ",?,'sdo_num_res=4',1) = 'TRUE' order by distMM";
                ps = conn.prepareStatement(query);
                ps.setObject(1, dbObject);
                ors = (OracleResultSet) ps.executeQuery();
                while (ors.next()) {
                    ptj.setId(ors.getLong(1)); // Long.parseLong(ors.getObject(1).toString());
                    dbObject = (oracle.sql.STRUCT) ors.getObject(2);
                    stradaGeom = oracle.spatial.geometry.JGeometry.load(
                            dbObject);
                    break;
                }
                if (ptj.getId() == Long.MIN_VALUE) {
                    ptj.setId( -2);
                    return ptj;
                }
            }

            try
            {
                //calcolo la progressiva; calcolo il punto proiettato e la sua misura
                if (oraVersion.startsWith("10")) {
                    query = "SELECT SDO_LRS.PROJECT_PT(" + colGeom +
                            ",?,0.0001) FROM " +
                            asta + "." + table + " WHERE " + colID + " =?" +
                            " AND DATAFINE = 20991231";
                } else {
                    query = "SELECT SDO_LRS.PROJECT_PT(" + colGeom +
                            ",?) FROM " +
                            asta + "." + table + " WHERE " + colID + " =?" +
                            " AND DATAFINE = 20991231";
                }
                ps = conn.prepareStatement(query);
                dbObject = oracle.spatial.geometry.JGeometry.store(jPoint, conn);
                ps.setObject(1, dbObject);
                ps.setLong(2, ptj.getId());
                ors = (OracleResultSet) ps.executeQuery();
                while (ors.next()) {
                    dbObject = (oracle.sql.STRUCT) ors.getObject(1);
                    ptProj = oracle.spatial.geometry.JGeometry.load(dbObject);
                    double[] pp = ptProj.getFirstPoint();
                    ptj.setXPro(pp[0]);
                    ptj.setYPro(pp[1]);
                    ptj.setM(pp[dim - 1]);
                }
                ps.close();

            }
            catch (Exception e)
            {
                //calcolo la progressiva; calcolo il punto proiettato e la sua misura
                if (oraVersion.startsWith("10")) {
                    query = "SELECT SDO_LRS.PROJECT_PT(" + colGeom +
                            ",?,0.0001) FROM " +
                            asta + "." + table + " WHERE " + colID + " =?";
                } else {
                    query = "SELECT SDO_LRS.PROJECT_PT(" + colGeom +
                            ",?) FROM " +
                            asta + "." + table + " WHERE " + colID + " =?";
                }
                ps = conn.prepareStatement(query);
                dbObject = oracle.spatial.geometry.JGeometry.store(jPoint, conn);
                ps.setObject(1, dbObject);
                ps.setLong(2, ptj.getId());
                ors = (OracleResultSet) ps.executeQuery();
                while (ors.next()) {
                    dbObject = (oracle.sql.STRUCT) ors.getObject(1);
                    ptProj = oracle.spatial.geometry.JGeometry.load(dbObject);
                    double[] pp = ptProj.getFirstPoint();
                    ptj.setXPro(pp[0]);
                    ptj.setYPro(pp[1]);
                    ptj.setM(pp[dim - 1]);
                }
                ps.close();
            }
            try {
                ptj.setOffset((Math.sqrt(Math.pow(ptj.getX() - ptj.getXPro(),
                                                  2.0) +
                                         Math.pow(ptj.getY() - ptj.getYPro(),
                                                  2.0))));
            } catch (Exception qqq) {
                scriviLog(qqq);
                ptj.setOffset(Double.NaN);
            }

        } catch (Exception e) {
            scriviLog(e);
            e.getMessage();
        }

        return ptj;
    }


    /**
     * Restituisce la {@link Coord} relativa alla progressiva data.
     * @param road_id String.
     * @param m double.
     * @param asta String Da valorizzare solo in caso si utilizzi Oracle SDO come
     * motore per la gestione della segmentazione dinamica. Indica lo schema su cui
     * � presente la tabella con le geometrie delle strade. Questo parametro � ancora
     * presente per compatibilit� con vecchie versioni di software client che accedono
     * al Web Service.
     * @param idConn String Identificativo di connessione al motore LRS (Linear Referencing System).
     * @param callback String indica una chiamata jsonp
     * @return {@link Coord} relativa alla progressiva data.
     */
    @Path("/queryXYJson")
	@GET
	@Produces({"application/javascript"})
    public String queryXYJson(@QueryParam("road_id") String road_id,
                         @QueryParam("m") double m,
                         @QueryParam("asta") String asta,
                         @QueryParam("idConn") String idConn,
                         @QueryParam("callback") String callback)
    {
        scriviLog("Invocata queryXY(" + road_id + "," + m + "," + asta + "," + idConn + ")");
        Coord coord = new Coord();
        /*if (WSSession.getConnection(idConn) instanceof oracle.jdbc.OracleConnection) {
            //campi del layer delle progressive
            String roadId = WSSession.ROADIDCOL;
            String geomCol = WSSession.GEOMCOL;
            String roadTable = WSSession.ROADTABLE;
            oracle.spatial.geometry.JGeometry stradaGeom = null;

            try {
                OracleConnection conn = null;
                if (WSSession.VERSION.compareToIgnoreCase("SISASPI_1.0") == 0)
                    conn = this.initLRSPool();
                else
                    conn = (OracleConnection) WSSession.getConnection(idConn);

                oracle.sql.STRUCT dbObject = null;
                double min = Double.NaN;
                double max = Double.NaN;
                String query = "";

                //ricavo la dimensione, la dimensione della misura, e il sistema di riferimento della tabella dei percorsi;
                //ricavo inoltre la geometria associata al roadId della progressiva

                //verifico che la progressiva data sia nel range consentito
                try
                {
                    query = "SELECT  SDO_LRS.GEOM_SEGMENT_START_MEASURE(" + geomCol +
                                   ") " +
                                   "FROM " + asta + "." + roadTable + " WHERE " +
                                   roadId + " = ? " +
                                   " AND DATAFINE = 20991231";
                    PreparedStatement ps = conn.prepareStatement(query);
                    ps.setLong(1, Long.parseLong(prog.getRoad_id()));
                    OracleResultSet ors = (OracleResultSet) ps.executeQuery();
                    while (ors.next()) {
                        min = ors.getDouble(1);
                        break;
                    }
                    ors.close();
                    ps.close();

                    //verifico che la progressiva data sia nel range consentito
                    query = "SELECT  SDO_LRS.GEOM_SEGMENT_END_MEASURE(" + geomCol + ") " +
                            "FROM " + asta + "." + roadTable + " WHERE " +
                            roadId + " = ? " +
                            " AND DATAFINE = 20991231";
                    ps = conn.prepareStatement(query);
                    ps.setLong(1, Long.parseLong(prog.getRoad_id()));
                    ors = (OracleResultSet) ps.executeQuery();
                    while (ors.next()) {
                        max = ors.getDouble(1);
                        break;
                    }
                    ors.close();
                    ps.close();

                }
                catch (Exception e) {
                    query = "SELECT  SDO_LRS.GEOM_SEGMENT_START_MEASURE(" + geomCol +
                                   ") " +
                                   "FROM " + asta + "." + roadTable + " WHERE " +
                                   roadId + " = ?";
                    PreparedStatement ps = conn.prepareStatement(query);
                    ps.setLong(1, Long.parseLong(prog.getRoad_id()));
                    OracleResultSet ors = (OracleResultSet) ps.executeQuery();
                    while (ors.next()) {
                        min = ors.getDouble(1);
                        break;
                    }
                    ors.close();
                    ps.close();

                    //verifico che la progressiva data sia nel range consentito
                    query = "SELECT  SDO_LRS.GEOM_SEGMENT_END_MEASURE(" + geomCol + ") " +
                            "FROM " + asta + "." + roadTable + " WHERE " +
                            roadId + " = ?";
                    ps = conn.prepareStatement(query);
                    ps.setLong(1, Long.parseLong(prog.getRoad_id()));
                    ors = (OracleResultSet) ps.executeQuery();
                    while (ors.next()) {
                        max = ors.getDouble(1);
                        break;
                    }
                    ors.close();
                    ps.close();
                }

                if (prog.getM() <= min)
                    prog.setM(min + 0.5);
                else if (prog.getM() >= max)
                    prog.setM(max - 0.5);

                //calcolo il punto associato alla misura
                try {
                    query = "SELECT SDO_LRS.LOCATE_PT(" + geomCol +
                            ",?,?) FROM " + asta + "." + roadTable + " WHERE " +
                            roadId + " = ?" +
                            " AND DATAFINE = 20991231";
                    PreparedStatement ps = conn.prepareStatement(query);
                    //dbObject = oracle.spatial.geometry.JGeometry.store(stradaGeom, conn);
                    ps.setDouble(1, prog.getM());
                    ps.setDouble(2, prog.getOffset());
                    ps.setLong(3, Long.parseLong(prog.getRoad_id()));
                    OracleResultSet ors = (OracleResultSet) ps.executeQuery();
                    coord = new Coord();
                    while (ors.next()) {
                        dbObject = (oracle.sql.STRUCT) ors.getObject(1);

                        stradaGeom = oracle.spatial.geometry.JGeometry.load(
                                dbObject);
                        coord.setX(stradaGeom.getOrdinatesArray()[0]);
                        coord.setY(stradaGeom.getOrdinatesArray()[1]);
                        break;
                    }
                    if (WSSession.VERSION.compareToIgnoreCase("SISASPI_1.0") ==
                        0)
                        conn.close();
                    ps.close();
                    ors.close();

                }
                catch (Exception e)
                {
                    query = "SELECT SDO_LRS.LOCATE_PT(" + geomCol +
                            ",?,?) FROM " + asta + "." + roadTable + " WHERE " +
                            roadId +
                            " = ?";
                    PreparedStatement ps = conn.prepareStatement(query);
                    //dbObject = oracle.spatial.geometry.JGeometry.store(stradaGeom, conn);
                    ps.setDouble(1, prog.getM());
                    ps.setDouble(2, prog.getOffset());
                    ps.setLong(3, Long.parseLong(prog.getRoad_id()));
                    OracleResultSet ors = (OracleResultSet) ps.executeQuery();
                    coord = new Coord();
                    while (ors.next()) {
                        dbObject = (oracle.sql.STRUCT) ors.getObject(1);

                        stradaGeom = oracle.spatial.geometry.JGeometry.load(
                                dbObject);
                        coord.setX(stradaGeom.getOrdinatesArray()[0]);
                        coord.setY(stradaGeom.getOrdinatesArray()[1]);
                        break;
                    }
                    if (WSSession.VERSION.compareToIgnoreCase("SISASPI_1.0") ==
                        0)
                        conn.close();
                    ps.close();
                    ors.close();
                }
            } catch (Exception e) {
                scriviLog(e);
            }
        }*/ 
        //if (getConnection(idConn) instanceof com.esri.sde.sdk.
        //           client.SeConnection) {
            if (
                    getConnection("percorsim") != null &&
                    getConnection("percorsim") instanceof com.siteco.JRs40DynSeg.DynSeg) {
                try {
                    Progressiva prog = new Progressiva();
                    prog.setRoad_id(road_id);
                    prog.setM(m);
                    DynSeg dynSeg = (DynSeg) getConnection("percorsim");
                    SHPPoint[] points = dynSeg.DSGetPoint(prog.getRoad_id(),prog.getM(), 0);
                    coord = new Coord();
                    coord.setX(points[0].x);
                    coord.setY(points[0].y);
                }
                catch (Exception e) {
                    scriviLog(e);
                }
                JSONObject res = new JSONObject(coord);
                if (callback != null && callback.length() > 0)
                   return callback + "(" + res.toString() + ")";
                else
                    return res.toString();
            }
        
        
        
            try {
                SeConnection conn = this.getSDEConn(idConn);
                String roadLayer = this.readDBSDE("ROADLAYER", idConn);
                String idCol = this.readDBSDE("IDCOL", idConn);
                SeLayer layer = null;
                if (!conn.isClosed()) {
                    Vector layers = conn.getLayers();
                    for (int i = 0; i < layers.size(); i++) {
                        if (((SeLayer)layers.get(i)).getName().equalsIgnoreCase(roadLayer) ||
                               ((SeLayer)layers.get(i)).getName().equalsIgnoreCase(roadLayer.replace("SIG_ADM.", "")) ) {
                            layer = (SeLayer)layers.get(i);
                            break;
                        }
                    }
                    //layer = new SeLayer(conn, roadLayer, idCol);
                }
                if (layer == null) {
                    scriviLog("layer non trovato");
                    //return null;
                }

                SeTable table1 = null;
                table1 = new SeTable(conn, roadLayer);

                if (table1 == null) {
                    scriviLog("tabella non trovata");
                    return null;
                }

                SeColumnDefinition[] tableDef = table1.describe();
                String[] cols = new String[tableDef.length];

                int geomIndex = -1;
                int colIdIndex = -1;
                int dataFineIndex = -1;

                for (int i = 0; i < tableDef.length; i++) {
                    cols[i] = tableDef[i].getName();
                    if (layer.getSpatialColumn().matches(tableDef[i].getName())) {
                        geomIndex = i;
                    }
                    if (tableDef[i].getName().matches(idCol)) {
                        colIdIndex = i;
                    }
                    if (tableDef[i].getName().toUpperCase().matches("DATAFINE")) {
                        dataFineIndex = i;
                    }
                }

                if (geomIndex == -1 || colIdIndex == -1) {
                    scriviLog("colonna gemetria o identificativa non trovata");
                    return null;
                }

                SeQuery query = null;
                boolean queryOk = false;
                String where = "";
                try {
                    SeSqlConstruct sqlConstruct = new SeSqlConstruct(table1.
                            getQualifiedName());
                    if (tableDef[colIdIndex].getType() == tableDef[colIdIndex].TYPE_STRING ||
                            tableDef[colIdIndex].getType() == tableDef[colIdIndex].TYPE_NSTRING)
                        where = idCol + "='" + road_id + "'";
                    else
                        where = idCol + " = " + road_id;
                    sqlConstruct.setWhere(where);

                    query = new SeQuery(conn, cols, sqlConstruct);

                    query.prepareQuery();
                    query.execute();
                    queryOk = true;
                } catch (Exception ee) {
                    queryOk = false;
                    scriviLog(ee);
                }

                /*try {
                    SeSqlConstruct sqlConstruct = new SeSqlConstruct(table1.
                            getQualifiedName());

                    sqlConstruct.setWhere(WSSession.getIdCol(idConn).toString() +
                                          " = " +
                                          prog.getRoad_id());

                    query = new SeQuery(conn, cols, sqlConstruct);

                    query.prepareQuery();
                    query.execute();
                    queryOk = true;
                } catch (Exception ee) {
                    SeSqlConstruct sqlConstruct = new SeSqlConstruct(table1.
                            getQualifiedName());
                    sqlConstruct.setWhere(WSSession.getIdCol(idConn).toString() +
                                          "='" +
                                          prog.getRoad_id() + "'");

                    query = new SeQuery(conn, cols, sqlConstruct);

                    query.prepareQuery();
                    query.execute();
                    queryOk = true;
                }*/

                if (!queryOk) {
                    scriviLog("query non ok trovato");
                    return null;
                }
                SeRow row = query.fetch();
                while (row != null) {
                    int dataFine = 0;
                    int annoFine = 0;
                    if (dataFineIndex != -1)
                    {
                        dataFine = row.getInteger(dataFineIndex);
                        String sDataFine = Integer.toString(dataFine);
                        if (sDataFine.length() >= 4)
                            annoFine = Integer.parseInt(sDataFine.substring(0,4));
                        if (annoFine < Calendar.getInstance().get(Calendar.YEAR))
                        {
                            row = query.fetch();
                            continue;
                        }
                    }

                    SeShape shp = row.getShape(geomIndex);

                    SeShape[] shps = null;
                    if (m < shp.getMRange()[0])
                            shps = shp.findAlong(shp.getMRange()[0]);
                    else if (m > shp.getMRange()[1])
                        shps = shp.findAlong(shp.getMRange()[1]);
                    else
                        shps = shp.findAlong(m);
                    //if (shp.getMinMValue() != shp.getMaxMValue())
                    //{
                        /*if (prog.getM() < shp.getMinMValue())
                            shps = shp.findAlong(shp.getMinMValue());
                        else if (prog.getM() > shp.getMaxMValue())
                            shps = shp.findAlong(shp.getMaxMValue());
                        else*/

                    //}
                    //else
                    //    shps = shp.findAlong(prog.getM());
                    ArrayList list = shps[0].getPoints(SeShape.TURN_DEFAULT, 1);
                    SDEPoint[] pointsPerPart = (SDEPoint[]) list.get(0);
                    SDEPoint point = pointsPerPart[0];
                    coord = new Coord();
                    coord.setX(point.getX());
                    coord.setY(point.getY());
                    row = query.fetch();
                }
                query.close();
                conn.close();
            } catch (Exception e) {
                scriviLog(e);
            }
        //}

        /*shapefile
        else if (getConnection(idConn) instanceof com.siteco.JRs40DynSeg.DynSeg) {
            try {
                Progressiva prog = new Progressiva();
                prog.setRoad_id(road_id);
                prog.setM(m);
                DynSeg dynSeg = (DynSeg) getConnection(idConn);
                SHPPoint[] points = dynSeg.DSGetPoint(prog.getRoad_id(),prog.getM(), 0);
                coord = new Coord();
                coord.setX(points[0].x);
                coord.setY(points[0].y);
            }
            catch (Exception e) {
                scriviLog(e);
            }
        }

        //abaco
        /*else if (WSSession.getConnection(idConn) instanceof com.siteco.JRs40DynSeg.DynSegDB) {
            try {
                DynSegDB dynSeg = (DynSegDB) WSSession.getConnection(idConn);
                SHPPoint[] points = dynSeg.DSGetPoint(prog.getRoad_id(),prog.getM(), 0);
                coord = new Coord();
                coord.setX(points[0].x);
                coord.setY(points[0].y);
            }
            catch (Exception e) {
                scriviLog(e);
            }
        }*/
        JSONObject res = new JSONObject(coord);
        if (callback != null && callback.length() > 0)
           return callback + "(" + res.toString() + ")";
        else
            return res.toString();
    }

    @Path("/queryXY")
    @GET
    @Produces({"application/xml"})
    public Coord queryXY(@QueryParam("road_id") String road_id, @QueryParam("m") double m, @QueryParam("asta") String asta, @QueryParam("idConn") String idConn) {
        scriviLog("Invocata queryXY(" + road_id + "," + m + "," + asta + "," + idConn + ")");
        Coord coord = new Coord();
        //if (((getConnection(idConn) instanceof SeConnection))
           //     || (getConnection(idConn) == null)) {
            try {
                SeConnection conn = getSDEConn(idConn);
                String roadLayer = readDBSDE("ROADLAYER", idConn);
                String idCol = readDBSDE("IDCOL", idConn);
                SeLayer layer = null;
                if (!conn.isClosed()) {
                    Vector layers = conn.getLayers();
                    for (int i = 0; i < layers.size(); i++) {
                        if ((((SeLayer) layers.get(i)).getName().equalsIgnoreCase(roadLayer))
                                || (((SeLayer) layers.get(i)).getName().equalsIgnoreCase(roadLayer.replace("SIG_ADM.", "")))) {
                            layer = (SeLayer) layers.get(i);
                            break;
                        }
                    }
                }
                if (layer == null) {
                    scriviLog("layer non trovato");
                }
                SeTable table1 = null;
                table1 = new SeTable(conn, roadLayer);
                if (table1 == null) {
                    scriviLog("tabella non trovata");
                    return null;
                }
                SeColumnDefinition[] tableDef = table1.describe();
                String[] cols = new String[tableDef.length];

                int geomIndex = -1;
                int colIdIndex = -1;
                int dataFineIndex = -1;
                for (int i = 0; i < tableDef.length; i++) {
                    cols[i] = tableDef[i].getName();
                    if (layer.getSpatialColumn().matches(tableDef[i].getName())) {
                        geomIndex = i;
                    }
                    if (tableDef[i].getName().matches(idCol)) {
                        colIdIndex = i;
                    }
                    if (tableDef[i].getName().toUpperCase().matches("DATAFINE")) {
                        dataFineIndex = i;
                    }
                }
                if ((geomIndex == -1) || (colIdIndex == -1)) {
                    scriviLog("colonna gemetria o identificativa non trovata");
                    return null;
                }
                SeQuery query = null;
                boolean queryOk = false;
                String where = "";
                try {
                    SeSqlConstruct sqlConstruct = new SeSqlConstruct(table1.getQualifiedName());
                    if (tableDef[colIdIndex].getType() == tableDef[colIdIndex].TYPE_STRING ||
                            tableDef[colIdIndex].getType() == tableDef[colIdIndex].TYPE_NSTRING)
                        where = idCol + "='" + road_id + "'";
                    else
                        where = idCol + " = " + road_id;
                    sqlConstruct.setWhere(where);

                    query = new SeQuery(conn, cols, sqlConstruct);

                    query.prepareQuery();
                    query.execute();
                    queryOk = true;
                } catch (Exception ee) {
                    queryOk = false;
                    scriviLog(ee);
                }
                if (!queryOk) {
                    scriviLog("query non ok trovato");
                    return null;
                }
                SeRow row = query.fetch();
                while (row != null) {
                    int dataFine = 0;
                    int annoFine = 0;
                    if (dataFineIndex != -1) {
                        dataFine = row.getInteger(dataFineIndex).intValue();
                        String sDataFine = Integer.toString(dataFine);
                        if (sDataFine.length() >= 4) {
                            annoFine = Integer.parseInt(sDataFine.substring(0, 4));
                        }
                        if (annoFine < Calendar.getInstance().get(1)) {
                            row = query.fetch();
                            continue;
                        }
                    }
                    SeShape shp = row.getShape(geomIndex);

                    SeShape[] shps = null;
                    if (m < shp.getMRange()[0]) {
                        shps = shp.findAlong(shp.getMRange()[0]);
                    } else if (m > shp.getMRange()[1]) {
                        shps = shp.findAlong(shp.getMRange()[1]);
                    } else {
                        shps = shp.findAlong(m);
                    }
                    ArrayList list = shps[0].getPoints(0, 1);
                    SDEPoint[] pointsPerPart = (SDEPoint[]) list.get(0);
                    SDEPoint point = pointsPerPart[0];
                    coord = new Coord();
                    coord.setX(point.getX());
                    coord.setY(point.getY());
                    row = query.fetch();
                }
                query.close();
                conn.close();
            } catch (Exception e) {
                scriviLog(e);
            }
        //} 
        /*shapefile
        else if ((getConnection(idConn) instanceof DynSeg)) {
            try {
                Progressiva prog = new Progressiva();
                prog.setRoad_id(road_id);
                prog.setM(m);
                DynSeg dynSeg = (DynSeg) getConnection(idConn);
                SHPPoint[] points = dynSeg.DSGetPoint(prog.getRoad_id(), prog.getM(), 0.0D);
                coord = new Coord();
                coord.setX(points[0].x);
                coord.setY(points[0].y);
            } catch (Exception e) {
                scriviLog(e);
            }
        }*/
        return coord;
    }
    /**
     * Dato una coppia di coordinate e un percorso restitusce la progressiva pi� vicina sul percorso stesso.
     * NB: questo metodo � utilizzabile solo se si � scelto Oracle SDO come motore LRS.
     * @param x double
     * @param y double
     * @param idRoad long Identificato del percorso
     * @param asta String Indica lo schema su cui
     * � presente la tabella con le geometrie delle strade. Questo parametro � ancora
     * presente per compatibilit� con vecchie versioni di software client che accedono
     * al Web Service.
     * @return {@link Progressiva} pi� vicina alla coppia di coordinate sul percorso indicato.
     */
    /** @todo sde, abaco, shapefile */
    @Path("/queryProgPerc")
	@GET
	@Produces({ MediaType.APPLICATION_XML })
    public Progressiva queryProgPerc(@QueryParam("x") double x,
                                     @QueryParam("y") double y,
                                     @QueryParam("idRoad") long idRoad,
                                     @QueryParam("asta") String asta,
                                     @QueryParam("idConn") String idConn) {

        Progressiva prog = new Progressiva();

        /*if (WSSession.getConnection(idConn) instanceof oracle.jdbc.OracleConnection) {
            OracleConnection conn = (OracleConnection) WSSession.getConnection(idConn);
            if (idRoad == -1) {
                return queryProg(x, y, asta, idConn);
            }
            prog = new Progressiva();

            //tabelle delle strade e delle particelle
            String roadTable = WSSession.ROADTABLE;

            //campi del layer delle progressive
            String roadId = WSSession.ROADIDCOL;
            String geomCol = WSSession.GEOMCOL;
            //id della strada pi� vicina al punto da proiettare
            //geometria della strada pi� vicina al punto da proiettare
            oracle.spatial.geometry.JGeometry stradaGeom = null;
            //geometria del punto proiettato
            oracle.spatial.geometry.JGeometry projPoint = null;
            //offset del punto proiettato
            double offset = -1;

            try {
                int srid = 0;
                int dim = 0;

                oracle.sql.STRUCT dbObject = null;

                //ricavo la dimensione, la dimensione della misura, e il sistema di riferimento della tabella dei percorsi
                String query = "SELECT " + geomCol + " FROM " + asta + "." +
                               roadTable +
                               " R WHERE ROWNUM = 1";
                PreparedStatement ps = conn.prepareStatement(query);
                OracleResultSet ors = (OracleResultSet) ps.executeQuery();
                while (ors.next()) {
                    dbObject = (oracle.sql.STRUCT) ors.getObject(1);
                    stradaGeom = oracle.spatial.geometry.JGeometry.load(dbObject);
                    srid = stradaGeom.getSRID();
                    dim = stradaGeom.getDimensions();
                }

                //coordinate del punto da proiettare
                double[] coord;
                if (dim == 2) {
                    //coordinate del punto da proiettare
                    coord = new double[2];
                    coord[0] = x;
                    coord[1] = y;
                } else if (dim == 3) {
                    //coordinate del punto da proiettare
                    coord = new double[3];
                    coord[0] = x;
                    coord[1] = y;
                    coord[2] = 0;
                } else if (dim == 4) {
                    //coordinate del punto da proiettare
                    coord = new double[4];
                    coord[0] = x;
                    coord[1] = y;
                    coord[2] = 0;
                    coord[3] = 0;
                } else {
                    return prog;
                }

                //punto da proiettare
                oracle.spatial.geometry.JGeometry jPoint = oracle.spatial.geometry.
                        JGeometry.createPoint(coord, dim, srid);
                //jPoint.setSRID(82088);
                //jPoint.setSRID(999999);

                //calcolo la progressiva; calcolo il punto proiettato e la sua misura
                if (oraVersion.startsWith("10")) {
                    query = "SELECT SDO_LRS.PROJECT_PT(" + geomCol +
                            ",?,0.0001) FROM " +
                            asta + "." + roadTable + " WHERE " + roadId + " =?";
                } else {
                    query = "SELECT SDO_LRS.PROJECT_PT(" + geomCol + ",?) FROM " +
                            asta + "." + roadTable + " WHERE " + roadId + " =?";
                }
                ps = conn.prepareStatement(query);
                dbObject = oracle.spatial.geometry.JGeometry.store(jPoint, conn);
                ps.setObject(1, dbObject);
                ps.setLong(2, idRoad);
                ors = (OracleResultSet) ps.executeQuery();
                while (ors.next()) {
                    dbObject = (oracle.sql.STRUCT) ors.getObject(1);
                    projPoint = oracle.spatial.geometry.JGeometry.load(dbObject);
                }
                ps.close();
                try {
                    //calcolo la progressiva;  con l'offset in 9.2 va in abort
                    query = "SELECT SDO_LRS.FIND_OFFSET(" + geomCol +
                            ",?,0.0001) FROM " + asta + "." + roadTable + " WHERE " +
                            roadId +
                            " =?";
                    ps = conn.prepareStatement(query);
                    dbObject = oracle.spatial.geometry.JGeometry.store(jPoint, conn);

                    ps.setObject(1, dbObject);
                    ps.setLong(2, idRoad);
                    ors = (OracleResultSet) ps.executeQuery();
                    while (ors.next()) {
                        offset = ors.getDouble(1);
                    }
                    ps.close();
                    conn.close();
                } catch (Exception qqq) {
                    scriviLog(qqq);
                    if (conn != null && !conn.isClosed()) {
                        conn.close();
                    }
                    if (ps != null) {
                        ps.close();
                    }
                    offset = 0.0;
                }

                prog.setRoad_id(Long.toString(idRoad));
                prog.setXPro(projPoint.getFirstPoint()[0]);
                prog.setYPro(projPoint.getFirstPoint()[1]);
                prog.setM(projPoint.getFirstPoint()[dim - 1]);
                prog.setOffset(offset);
                conn.close();

            } catch (Exception e) {
                scriviLog(e);
                e.getMessage();
            }
        }*/
        return prog;

    }

    /**
     * Imposta le dimensioni dell'immagine della mappa.
     * @param xImage int Larghezza dell'immagine della mappa.
     * @param yImage int Altezza dell'immagine della mappa.
     * @param xImmLeg int Larghezza dell'immagine della legenda. Ancora presente
     * per compatilit� con vecchie versioni di client che accedono al Web Service,
     * ma non pi� utilizzato.
     * @param yImmLeg int Altezza dell'immagine della legenda. Ancora presente
     * per compatilit� con vecchie versioni di client che accedono al Web Service,
     * ma non pi� utilizzato.
     * @param xImmOv int Larghezza dell'immagine di overview. Ancora presente
     * per compatilit� con vecchie versioni di client che accedono al Web Service,
     * ma non pi� utilizzato.
     * @param yImmOv int Altezza dell'immagine di overview. Ancora presente
     * per compatilit� con vecchie versioni di client che accedono al Web Service,
     * ma non pi� utilizzato.
     * @param idMap String Identificatore della connessione al map server.
     */
    @Path("/setImageSize")
	@GET
	@Produces({ MediaType.APPLICATION_XML })
    public MapURLs setImageSize(@QueryParam("xImage") int xImage,
                             @QueryParam("yImage") int yImage,
                             @QueryParam("xImmLeg") int xImmLeg,
                             @QueryParam("yImmLeg") int yImmLeg,
                             @QueryParam("xImmOv") int xImmOv,
                             @QueryParam("yImmOv") int yImmOv,
                             @QueryParam("idMap") String idMap) {
        scriviLog("Invocata setImageSize(" + xImage + "," + yImage + "," + idMap + ")");
        MapURLs mu = new MapURLs();
        try {
            ImageDisplay imageDisplay = (ImageDisplay) this.readDB("IMAGEDISPLAY", idMap);
            imageDisplay.setImageWidth(xImage);
            imageDisplay.setImageHeight(yImage);
            this.updateDB(idMap, "IMAGEDISPLAY", imageDisplay);
            return mu;
        }
        catch (Exception exc)
        {
            scriviLog("setImageSize: errore!", exc);
            mu.setErrore(exc.getMessage());
            return mu;
        }
    }


    /**
     * Accende tutti i layer disponibili.
     * @param idMap String Identificatore della connessione al map server.
     * @return MapURLs N.B. L'oggetto {@link MapURLs} ritornato non contiene i riferimenti all'immagine della mappa aggiornata, ma
     * � mantenuto solo per compatibilit� con versioni precedenti del software. Richiamare il metodo {@link #refreshMap refreshMap} per
     * ottenere un oggetto {@link MapURLs} con i riferimenti all'immagine della mappa aggiornata.
     */
    @Path("/setAllLayersOn")
	@GET
	@Produces({ MediaType.APPLICATION_XML })
    public MapURLs setAllLayersOn (@QueryParam("idMap") String idMap)
    {
        MapURLs mu = new MapURLs();
        try {
            String mapName = this.readDB("MAPNAME", idMap).toString();
            MapServerBindingStub mapServer = new MapServerBindingStub(this.readDB("CONNSTRING", idMap).toString());
            MapDescription mDesc = (MapDescription) this.readDB("MAPDESCRIPTION", idMap);
            MapLayerInfo[] lInfos = mapServer.getServerInfo(mapName).getMapLayerInfos();
            LayerDescription[] lDescs = mDesc.getLayerDescriptions();
            for (int i = 0; i < lDescs.length; i++)
            {
                lDescs[i].setVisible(true);
            }
            this.updateDB(idMap, "MAPDESCRIPTION", mDesc);
            return mu;
        }
        catch (Exception exc)
        {
            scriviLog(exc);
            mu.setErrore(exc.getMessage());
            return mu;
        }
    }



    /**
     * Spegne tutti i layer disponibili.
     * @param idMap String Identificatore della connessione al map server.
     * @return MapURLs N.B. L'oggetto {@link MapURLs} ritornato non contiene i riferimenti all'immagine della mappa aggiornata, ma
     * � mantenuto solo per compatibilit� con versioni precedenti del software. Richiamare il metodo {@link #refreshMap refreshMap} per
     * ottenere un oggetto {@link MapURLs} con i riferimenti all'immagine della mappa aggiornata.
     */
    @Path("/setAllLayersOff")
	@GET
	@Produces({ MediaType.APPLICATION_XML })
    public MapURLs setAllLayersOff (@QueryParam("idMap") String idMap)
    {
        MapURLs mu = new MapURLs();
        try {
            String mapName = this.readDB("MAPNAME", idMap).toString();
            MapServerBindingStub mapServer = new MapServerBindingStub(this.readDB("CONNSTRING", idMap).toString());
            MapDescription mDesc = (MapDescription) this.readDB("MAPDESCRIPTION", idMap);
            MapLayerInfo[] lInfos = mapServer.getServerInfo(mapName).getMapLayerInfos();
            LayerDescription[] lDescs = mDesc.getLayerDescriptions();
            for (int i = 0; i < lDescs.length; i++)
            {
                lDescs[i].setVisible(false);
            }
            this.updateDB(idMap, "MAPDESCRIPTION", mDesc);
            return mu;
        }
        catch (Exception exc)
        {
            scriviLog(exc);
            mu.setErrore(exc.getMessage());
            return mu;
        }
    }

    /**
     * Esegue lo zoom alla massima estensione della mappa.
     * @param idMap String Identificatore della connessione al map server.
     * @return MapURLs N.B. L'oggetto {@link MapURLs} ritornato non contiene i riferimenti all'immagine della mappa aggiornata, ma
     * � mantenuto solo per compatibilit� con versioni precedenti del software. Richiamare il metodo {@link #refreshMap refreshMap} per
     * ottenere un oggetto {@link MapURLs} con i riferimenti all'immagine della mappa aggiornata.
     */
    @Path("/zoomMaxEnvelope")
	@GET
	@Produces({ MediaType.APPLICATION_XML })
    public MapURLs zoomMaxEnvelope(@QueryParam("idMap") String idMap) {
        MapURLs mu = new MapURLs();
        try {
            MapServerBindingStub mapServer = new MapServerBindingStub(this.readDB("CONNSTRING", idMap).toString());
            MapDescription mDesc = (MapDescription) this.readDB("MAPDESCRIPTION", idMap);
            String mapName = this.readDB("MAPNAME", idMap).toString();
            mapServer.getServerInfo(mapName).getFullExtent();
            MapExtent extent = new MapExtent();
            extent.setExtent(mapServer.getServerInfo(mapName).getFullExtent());
            mDesc.setMapArea(extent);
            this.updateDB(idMap, "MAPDESCRIPTION", mDesc);
            return mu;
        } catch (Exception exc) {
            scriviLog("zoomMaxEnvelope: errore!", exc);
            mu.setErrore(exc.getMessage());
            return mu;
        }
    }

    /**
     * Esegue lo zoom alla scala indicata.
     * @param zoom int La scala a cui si vuole effettuare lo zoom.
     * @param idMap String Identificatore della connessione al map server.
     * @return MapURLs N.B. L'oggetto {@link MapURLs} ritornato non contiene i riferimenti all'immagine della mappa aggiornata, ma
     * � mantenuto solo per compatibilit� con versioni precedenti del software. Richiamare il metodo {@link #refreshMap refreshMap} per
     * ottenere un oggetto {@link MapURLs} con i riferimenti all'immagine della mappa aggiornata.
     */
    @Path("/zoomScale")
	@GET
	@Produces({ MediaType.APPLICATION_XML })
    public MapURLs zoomScale(@QueryParam("zoom") int zoom,
                             @QueryParam("idMap") String idMap) {
        scriviLog("Invocata zoomScale(" + zoom + ")");
        MapURLs mu = new MapURLs();
        try {
            MapServerBindingStub mapServer = new MapServerBindingStub(this.readDB("CONNSTRING", idMap).toString());
            MapDescription mDesc = (MapDescription) this.readDB("MAPDESCRIPTION", idMap);
            ImageDisplay imageDisplay = (ImageDisplay) this.readDB("IMAGEDISPLAY", idMap);

            ImageType it = new ImageType();
            it.setImageFormat(EsriImageFormat.esriImageJPG);
            it.setImageReturnType(EsriImageReturnType.esriImageReturnURL);
            ImageDescription pID = new ImageDescription();
            pID.setImageDisplay(imageDisplay);
            pID.setImageType(it);
            MapImage pMI = (MapImage) mapServer.exportMapImage(mDesc, pID);

            CenterAndScale centerAndScale = new CenterAndScale();
            centerAndScale.setScale(zoom);
            EnvelopeN env= (EnvelopeN) pMI.getExtent();
            double x = (env.getXMin() + env.getXMax())/2;
            double y = (env.getYMin() + env.getYMax())/2;
            PointN point = new PointN();
            point.setSpatialReference(mDesc.getSpatialReference());
            point.setX(x);
            point.setY(y);
            centerAndScale.setCenter(point);
            mDesc.setMapArea(centerAndScale);
            pMI = (MapImage) mapServer.exportMapImage(mDesc, pID);
            MapExtent extent = new MapExtent();
            extent.setExtent(pMI.getExtent());
            mDesc.setMapArea(extent);
            this.updateDB(idMap, "MAPDESCRIPTION", mDesc);
            return mu;
        } catch (Exception exc) {
            scriviLog("zoomScale: errore!", exc);
            mu.setErrore(exc.getMessage());
            return mu;
        }
    }


    /**
     * Esegue uno zoom + con un fattore del 25%.
     * @param idMap String Identificatore della connessione al map server.
     * @return MapURLs N.B. L'oggetto {@link MapURLs} ritornato non contiene i riferimenti all'immagine della mappa aggiornata, ma
     * � mantenuto solo per compatibilit� con versioni precedenti del software. Richiamare il metodo {@link #refreshMap refreshMap} per
     * ottenere un oggetto {@link MapURLs} con i riferimenti all'immagine della mappa aggiornata.
     */
    @Path("/zoomPiu")
	@GET
	@Produces({ MediaType.APPLICATION_XML })
    public MapURLs zoomPiu(@QueryParam("idMap") String idMap) {
        scriviLog("Invocata zoomPiu(" + idMap + ")");
        MapURLs mu = new MapURLs();
        try {
            GenEnvelope genEnv = this.getMapEnvelope(idMap);
            double w = genEnv.getMaxX() - genEnv.getMinX();
            double h = genEnv.getMaxY() - genEnv.getMinY();
            w = w / 4.0;
            h = h / 4.0;
            zoomToEnvelope(genEnv.getMinX() + w, genEnv.getMinY() + h, genEnv.getMaxX() - w, genEnv.getMaxY() - h, idMap);
            return mu;
        } catch (Exception e) {
            scriviLog(e);
            mu.setErrore(e.getMessage());
            return mu;
        }
    }

    /**
     * Esegue uno zoom - con un fattore del 25%.
     * @param idMap String Identificatore della connessione al map server.
     * @return MapURLs N.B. L'oggetto {@link MapURLs} ritornato non contiene i riferimenti all'immagine della mappa aggiornata, ma
     * � mantenuto solo per compatibilit� con versioni precedenti del software. Richiamare il metodo {@link #refreshMap refreshMap} per
     * ottenere un oggetto {@link MapURLs} con i riferimenti all'immagine della mappa aggiornata.
     */
    @Path("/zoomMeno")
	@GET
	@Produces({ MediaType.APPLICATION_XML })
    public MapURLs zoomMeno(@QueryParam("idMap") String idMap) {
        scriviLog("Invocata zoomMeno(" + idMap + ")");
        MapURLs mu = new MapURLs();
        try {
            GenEnvelope genEnv = this.getMapEnvelope(idMap);
            double w = genEnv.getMaxX() - genEnv.getMinX();
            double h = genEnv.getMaxY() - genEnv.getMinY();
            w = w / 4.0;
            h = h / 4.0;
            zoomToEnvelope(genEnv.getMinX() - w, genEnv.getMinY() - h, genEnv.getMaxX() + w, genEnv.getMaxY() + h, idMap);
            return mu;
        } catch (Exception e) {
            scriviLog(e);
            mu.setErrore(e.getMessage());
            return mu;
        }
    }


    /**
     * Esegue il refresh della mappa. Necessario ogni volta che si desidera la generazione
     * dell'immagine della mappa aggiornata alla situazione corrente memorizzata.
     * @param idMap String Identificatore della connessione al map server.
     * @return {@link MapURLs} con i riferimenti all'URL dell'immagine aggiornata della mappa prodotta.
     */
    @Path("/refreshMap")
	@GET
	@Produces({ MediaType.APPLICATION_XML })
    public MapURLs refreshMap(@QueryParam("idMap") String idMap)
    {
        scriviLog("Invocata refeshMap(" + idMap + ")");
        MapURLs mu = new MapURLs();
        try {
            MapServerBindingStub mapServer = new MapServerBindingStub(this.readDB("CONNSTRING", idMap).toString());
            MapDescription mDesc = (MapDescription) this.readDB("MAPDESCRIPTION", idMap);
            ImageDisplay imageDisplay = (ImageDisplay) this.readDB("IMAGEDISPLAY", idMap);

            ImageType it = new ImageType();
            it.setImageFormat(EsriImageFormat.esriImageJPG);
            it.setImageReturnType(EsriImageReturnType.esriImageReturnURL);
            ImageDescription pID = new ImageDescription();
            pID.setImageDisplay(imageDisplay);
            pID.setImageType(it);
            MapImage pMI = (MapImage) mapServer.exportMapImage(mDesc, pID);
            mu.setUrlMap(pMI.getImageURL());
            this.updateDB(idMap, "MAPDESCRIPTION", mDesc);
        } catch (Exception exc) {
            scriviLog("refreshMap: errore!", exc);
            mu.setErrore(exc.getMessage());
            return mu;
        }
        return mu;
    }



    /**
     * Esegue lo zoom sull'envelope indicato.
     * @param xMin double.
     * @param yMin double.
     * @param xMax double.
     * @param yMax double.
     * @param idMap String Identificatore della connessione al map server.
     * @return MapURLs N.B. L'oggetto {@link MapURLs} ritornato non contiene i riferimenti all'immagine della mappa aggiornata, ma
     * � mantenuto solo per compatibilit� con versioni precedenti del software. Richiamare il metodo {@link #refreshMap refreshMap} per
     * ottenere un oggetto {@link MapURLs} con i riferimenti all'immagine della mappa aggiornata.
     */

    @Path("/zoomToEnvelope")
	@GET
    @Produces(MediaType.APPLICATION_XML)
	//@Produces({ MediaType.APPLICATION_XML })
    //public MapURLs zoomToEnvelope(@QueryParam("genEnv") GenEnvelope genEnv,
    //                              @QueryParam("idMap") String idMap) {
    public MapURLs zoomToEnvelope(@QueryParam("xMin") double xMin,
                                  @QueryParam("yMin") double yMin,
                                  @QueryParam("xMax") double xMax,
                                  @QueryParam("yMax") double yMax,
                                  @QueryParam("idMap") String idMap) {
        MapURLs mu = new MapURLs();
        try {
            MapDescription mDesc = (MapDescription) this.readDB("MAPDESCRIPTION", idMap);

            MapExtent extent = new MapExtent();
            EnvelopeN envelope = new EnvelopeN();
            envelope.setSpatialReference(mDesc.getSpatialReference());
            envelope.setXMin(xMin);
            envelope.setXMax(xMax);
            envelope.setYMin(yMin);
            envelope.setYMax(yMax);
            extent.setExtent(envelope);
            mDesc.setMapArea(extent);
            this.updateDB(idMap, "MAPDESCRIPTION", mDesc);
            this.zoomScale((int)this.GetScale(idMap), idMap);
            return mu;
        } catch (Exception exc) {
            scriviLog("zoomToEnvelope: errore!", exc);
            mu.setErrore(exc.getMessage());
            return mu;
        }
    }


    /**
     * Esegue lo zoom sull'oggetto indicato, prima verificando se sono fornite
     * le coordinate, poi l'id dell'oggetto con l'eventuale layer ed infine
     * le progressive.
     * @param isPuntuale boolean true se l'oggetto � puntuale, false se � lineare.
     * @param x1 double x del primo punto dell'oggetto.
     * @param y1 double y del primo punto dell'oggetto.
     * @param x2 double x del secondo punto dell'oggetto (se lineare).
     * @param y2 double y del secondo punto dell'oggetto (se lineare).
     * @param testo String Eventuale testo da visualizzare.
     * @param id_ev long Eventuale identificativo dell'oggetto.
     * @param tagLayer String Eventuale identificativo del layer a cui appartiene l'oggetto.
     * @param p1 {@link Progressiva} del primo punto dell'oggetto.
     * @param p2 {@link Progressiva} del secondo punto dell'oggetto.
     * @param tol int Valore in unit� di misura della mappa del buffer che verr� aggiunto attorno all'oggetto
     * durante la costruzione della finestra di zoom.
     * @param idMap String Identificatore della connessione al map server.
     * @param idConn String Eventuale identificativo di connessione al motore LRS (Linear Referencing System).
     * @return MapURLs N.B. L'oggetto {@link MapURLs} ritornato non contiene i riferimenti all'immagine della mappa aggiornata, ma
     * � mantenuto solo per compatibilit� con versioni precedenti del software. Richiamare il metodo {@link #refreshMap refreshMap} per
     * ottenere un oggetto {@link MapURLs} con i riferimenti all'immagine della mappa aggiornata.
     */
    /*public MapURLs zoomToEvent(boolean isPuntuale, double x1, double y1,
                               double x2, double y2,
                               String testo, long id_ev, String tagLayer,
                               Progressiva p1, Progressiva p2, int tol,
                               String idMap, String idConn) {
        MapURLs mu = new MapURLs();
        try {
            MapServerBindingStub mapServer = new MapServerBindingStub(this.readDB("CONNSTRING", idMap).toString());
            MapDescription mDesc = (MapDescription) this.readDB("MAPDESCRIPTION", idMap);
            String mapName = this.readDB("MAPNAME", idMap).toString();

            LayerDescription[] layerDescriptions = mDesc.getLayerDescriptions();
            MapLayerInfo[] layerInfos = mapServer.getServerInfo(mapName).getMapLayerInfos();
            int numLayers = layerInfos.length;
            boolean featureFound = false;

            for (int i = 0; i < numLayers; i++) {
                boolean found = false;
                if (layerInfos[i].getName().equalsIgnoreCase(tagLayer)) {
                    LayerDescription mapLayer = null;
                    for (int j = 0; j < layerDescriptions.length; j++) {
                            if (layerDescriptions[j].getLayerID() ==
                                layerInfos[i].getLayerID()) {
                                mapLayer = layerDescriptions[j];
                                break;
                            }
                    }
                    if (mapLayer != null) {
                        LayerResultOptions lyrRsltOpt = new LayerResultOptions();
                        GeometryResultOptions geomRsltOpt = new GeometryResultOptions();
                        geomRsltOpt.setDensifyGeometries(true);
                        geomRsltOpt.setMaximumDeviation(0d);
                        geomRsltOpt.setMaximumSegmentLength(-1d);
                        lyrRsltOpt.setGeometryResultOptions(geomRsltOpt);
                        mapLayer.setLayerResultOptions(lyrRsltOpt);

                        found = true;
                        String where = "";
                        if (WSSession.VERSION.compareToIgnoreCase("ROADSIT_SDE_3.3") == 0)
                            where = "ID_EVE = " + id_ev;
                        else
                            where = "EVE_ID = " + id_ev;
                        QueryFilter filter = new QueryFilter();
                        filter.setWhereClause(where);
                        filter.setSubFields("SHAPE");
                        QueryResultOptions queryresultoptions = new QueryResultOptions();
                        queryresultoptions.setFormat(EsriQueryResultFormat.esriQueryResultRecordSetAsObject);
                        QueryResult result = mapServer.queryFeatureData2(mapName, mapLayer, filter, queryresultoptions);
                        RecordSet recordSet = (RecordSet) result.getObject();
                        EnvelopeN env =  null;
                        if (recordSet != null && recordSet.getRecords().length == 1) {
                           featureFound = true;
                           java.lang.Object shape = recordSet.getRecords()[0].getValues()[1];
                           if(shape instanceof PolylineN) {
                               env = (EnvelopeN)((PolylineN) shape).getExtent();
                           }
                           else if (shape instanceof PointN) {
                               double x = ((PointN) shape).getX();
                               double y = ((PointN) shape).getY();
                               env = new EnvelopeN();
                               env.setXMin(x - tol);
                               env.setYMin(y - tol);
                               env.setXMax(x + tol);
                               env.setYMax(y + tol);
                           }
                           else if (shape instanceof MultipointN) {
                               if (((MultipointN) shape).getPointArray().length == 1) {
                                   double x = ((PointN)((MultipointN) shape).getPointArray()[0]).getX();
                                   double y = ((PointN)((MultipointN) shape).getPointArray()[0]).getY();
                                   env = new EnvelopeN();
                                   env.setXMin(x - tol);
                                   env.setYMin(y - tol);
                                   env.setXMax(x + tol);
                                   env.setYMax(y + tol);
                               }
                               else {
                                   env = (EnvelopeN)((MultipointN) shape).getExtent();
                               }
                           }
                           else if (shape instanceof PolygonN) {
                               env = (EnvelopeN)((PolygonN) shape).getExtent();
                           }
                           if (env != null) {
                               MapExtent extent = new MapExtent();
                               extent.setExtent(env);
                               mDesc.setMapArea(extent);
                           }
                           FIDSet fIdSet = mapServer.queryFeatureIDs(mapName, mapLayer.getLayerID(), filter);
                           if (this.GetScale(idMap) < 1000)
                            this.zoomScale(1000, idMap);
                        }
                    }
                }
            }
            if (!featureFound) {
                if (isPuntuale) {
                    if (!Double.isNaN(x1) && !Double.isNaN(y1)) {
                        GenEnvelope env = new GenEnvelope();
                        env.setMinX(x1 - tol);
                        env.setMinY(y1 - tol);
                        env.setMaxX(x1 + tol);
                        env.setMaxY(y1 + tol);
                        this.zoomToEnvelope(env, idMap);
                        if (this.GetScale(idMap) < 1000)
                            this.zoomScale(1000, idMap);
                    }

                    //se non ho trovato il layer ultima chance: mi hanno
                    //fornito le progressive
                    else {
                        if (p1 != null) {
                            Coord coord = this.queryXY(p1, "", idConn);
                            if (coord != null) {
                                x1 = coord.getX();
                                y1 = coord.getY();
                                GenEnvelope env = new GenEnvelope();
                                env.setMinX(x1 - tol);
                                env.setMinY(y1 - tol);
                                env.setMaxX(x1 + tol);
                                env.setMaxY(y1 + tol);
                                this.zoomToEnvelope(env, idMap);
                                if (this.GetScale(idMap) < 1000)
                                    this.zoomScale(1000, idMap);
                            }
                        }
                    }
                }
                else {
                    if (!Double.isNaN(x1) && !Double.isNaN(y1)
                        && !Double.isNaN(x2) && !Double.isNaN(y2)) {
                        GenEnvelope env = new GenEnvelope();
                        env.setMinX(Math.min(x1, x2) - tol);
                        env.setMinY(Math.min(y1, y2) - tol);
                        env.setMaxX(Math.max(x1, x2) + tol);
                        env.setMaxY(Math.max(y1, y2) + tol);
                        this.zoomToEnvelope(env, idMap);
                        if (this.GetScale(idMap) < 1000)
                            this.zoomScale(1000, idMap);
                    }

                    //se non ho trovato il layer ultima chance: mi hanno
                    //fornito le progressive
                    else {
                        if (p1 != null && p2 != null) {
                            Coord c1 = this.queryXY(p1, "", idConn);
                            Coord c2 = this.queryXY(p2, "", idConn);
                            GenEnvelope env = new GenEnvelope();
                            env.setMinX(Math.min(c1.getX(), c2.getX()) - tol);
                            env.setMinY(Math.min(c1.getY(), c2.getY()) - tol);
                            env.setMaxX(Math.max(c1.getX(), c2.getX()) + tol);
                            env.setMaxY(Math.max(c1.getY(), c2.getY()) + tol);
                            this.zoomToEnvelope(env, idMap);
                            if (this.GetScale(idMap) < 1000)
                                this.zoomScale(1000, idMap);
                        }
                    }
                }
            }
            return mu;
        }
        catch (Exception exc) {
            scriviLog("zoomToEvent: errore!", exc);
            return null;
        }
        return mu;
    }*/

    /**
     * Esegue lo zoom alla progressiva indicata.
     * @param road_id String.
     * @param m double.
     * @param zoom int Scala a cui effettuare lo zoom.
     * @param asta String Da valorizzare solo in caso si utilizzi Oracle SDO come
      * motore per la gestione della segmentazione dinamica. Indica lo schema su cui
      * � presente la tabella con le geometrie delle strade. Questo parametro � ancora
      * presente per compatibilit� con vecchie versioni di software client che accedono
      * al Web Service.
     * @param idMap String Identificatore della connessione al map server.
     * @param idConn String Identificativo di connessione al motore LRS (Linear Referencing System).
     * @return MapURLs N.B. L'oggetto {@link MapURLs} ritornato non contiene i riferimenti all'immagine della mappa aggiornata, ma
     * � mantenuto solo per compatibilit� con versioni precedenti del software. Richiamare il metodo {@link #refreshMap refreshMap} per
     * ottenere un oggetto {@link MapURLs} con i riferimenti all'immagine della mappa aggiornata.
     */
    @Path("/zoomToProg")
    @GET
    @Produces({MediaType.APPLICATION_XML})
    public MapURLs zoomToProg(@QueryParam("road_id") String road_id, @QueryParam("m") double m, @QueryParam("zoom") int zoom, @QueryParam("asta") String asta, @QueryParam("idConn") String idConn, @QueryParam("idMap") String idMap) {
        MapURLs mu = new MapURLs();
        try {
            Coord cc = queryXY(road_id, m, asta, idConn);
            return zoomToXYMap(cc.getX(), cc.getY(), zoom, idMap);
        } catch (Exception e) {
            scriviLog(e);
            mu.setErrore(e.getMessage());
        }
        return mu;
    }

    /**
     * Esegue lo zoom sulla coordinata dell'immagine indicata.
     * @param x int Valore in pixel della x dell'immagine.
     * @param y int Valore in pixel della y dell'immagine.
     * @param zoom int Fattore di scala a cui effettuare lo zoom.
     * @param idMap String Identificatore della connessione al map server.
     * @return MapURLs N.B. L'oggetto {@link MapURLs} ritornato non contiene i riferimenti all'immagine della mappa aggiornata, ma
     * � mantenuto solo per compatibilit� con versioni precedenti del software. Richiamare il metodo {@link #refreshMap refreshMap} per
     * ottenere un oggetto {@link MapURLs} con i riferimenti all'immagine della mappa aggiornata.
     */
    @Path("/zoomToXYImg")
	@GET
	@Produces({ MediaType.APPLICATION_XML })
    public MapURLs zoomToXYImg(@QueryParam("x") int x,
                               @QueryParam("y") int y,
                               @QueryParam("zoom") int zoom,
                               @QueryParam("idMap") String idMap) {
        MapURLs mu = new MapURLs();
        try {
            MapServerBindingStub mapServer = new MapServerBindingStub(this.readDB("CONNSTRING", idMap).toString());
            MapDescription mDesc = (MapDescription) this.readDB("MAPDESCRIPTION", idMap);
            ImageDisplay imageDisplay = (ImageDisplay) this.readDB("IMAGEDISPLAY", idMap);

            ImageType it = new ImageType();
            it.setImageFormat(EsriImageFormat.esriImageJPG);
            it.setImageReturnType(EsriImageReturnType.esriImageReturnURL);
            ImageDescription pID = new ImageDescription();
            pID.setImageDisplay(imageDisplay);
            pID.setImageType(it);
            MapImage pMI = (MapImage) mapServer.exportMapImage(mDesc, pID);

            CenterAndScale centerAndScale = new CenterAndScale();
            centerAndScale.setScale(zoom);
            PointN point = new PointN();
            point.setSpatialReference(mDesc.getSpatialReference());
            Coord c = this.mapCoord(x, y, idMap);
            point.setX(c.getX());
            point.setY(c.getY());
            centerAndScale.setCenter(point);
            mDesc.setMapArea(centerAndScale);
            pMI = (MapImage) mapServer.exportMapImage(mDesc, pID);
            MapExtent extent = new MapExtent();
            extent.setExtent(pMI.getExtent());
            mDesc.setMapArea(extent);
            this.updateDB(idMap, "MAPDESCRIPTION", mDesc);
            return mu;
        } catch (Exception exc) {
            scriviLog("zoomToXYImg: errore!", exc);
            mu.setErrore(exc.getMessage());
            return mu;
        }
    }


    /**
     * Esegue lo zoom sulla coordinata della mappa indicata.
     * @param x double Valore della x dell'immagine.
     * @param y double Valore della y dell'immagine.
     * @param zoom int Fattore di scala a cui effettuare lo zoom.
     * @param idMap String Identificatore della connessione al map server.
     * @return MapURLs N.B. L'oggetto {@link MapURLs} ritornato non contiene i riferimenti all'immagine della mappa aggiornata, ma
      * � mantenuto solo per compatibilit� con versioni precedenti del software. Richiamare il metodo {@link #refreshMap refreshMap} per
      * ottenere un oggetto {@link MapURLs} con i riferimenti all'immagine della mappa aggiornata.
     */
    @Path("/zoomToXYMap")
	@GET
	@Produces({ MediaType.APPLICATION_XML })
    public MapURLs zoomToXYMap(@QueryParam("x") double x,
                               @QueryParam("y") double y,
                               @QueryParam("zoom") int zoom,
                               @QueryParam("idMap") String idMap) {
        scriviLog("Invocata zoomToXYMap(" + x + "," + y + "," + zoom + "," + idMap + ")");
        MapURLs mu = new MapURLs();
        try {
            MapDescription mDesc = (MapDescription) this.readDB("MAPDESCRIPTION", idMap);

            MapExtent extent = new MapExtent();
            EnvelopeN envelope = new EnvelopeN();
            envelope.setXMin(x - 100);
            envelope.setYMin(y - 100);
            envelope.setXMax(x + 100);
            envelope.setYMax(y + 100);
            extent.setExtent(envelope);
            mDesc.setMapArea(extent);
            this.updateDB(idMap, "MAPDESCRIPTION", mDesc);
            this.zoomScale(zoom, idMap);
            return mu;
        } catch (Exception exc) {
            scriviLog("zoomToXYMap: errore!", exc);
            mu.setErrore(exc.getMessage());
            return mu;
        }
    }

    public String oraVersion = "";

    /**
     * Esegue la connessione al motore LRS (Linear Referencing System). E' necessario
     * effettuare questo tipo di connessione se si desidera utilizzare metodi che fanno uso
     * di oggetti di tipo {@link Progressiva}, ovvero che utilizzano un route system nella gestione
     * dei percorsi. Attualmente i motori gestiti sono Oracle SDO, Esri ArcSDE, 3=ShapeFile, 4=Abaco.
     * @param tipoLRS String Tipologia del motore LRS: 1=Oracle SDO, 2=Esri ArcSDE, 3=ShapeFile, 4=Abaco.
     * @param user String Eventuale nome utente del DB/schema; vuoto nel caso si utilizzi lo ShapeFile.
     * @param pwd String Eventuale password di accesso dell'utente del DB/schema; vuoto nel caso si utilizzi lo ShapeFile.
     * @param connString String Stringa di connessione al DB o percorso fisico dello shapefile rispetto alla macchina dove risiede il web service.
     * La stringa di connessione � diversa a seconda del motore utilizzato:
     * 1)Oracle SDO: � nella forma "host:port:SID", ad esempio 192.168.7.103:1521:ORA10E2;
     * 2)Esri ArcSDE: � nella forma "host;port;", ad esempio 192.168.7.203;5151; NB: ricordarsi il ";" dopo la porta;
     * 3)ShapeFile: � il percorso fisico dello shapefile rispetto alla macchina
     * dove risiede il Web Service, ad esempio C:\\Tomcat5520\\shp_mo\\RDSROAD.shp NB:
     * nel caso il sistema operativo sia Windows utilizzare il doppio "\".
     * 4)Abaco: � nella forma jdbc:jtds:sqlserver://host:port/dbname, ad esempio
     * jdbc:jtds:sqlserver://192.168.7.250:1433/cscm
     * @param roadLayer String Nome della tabella dove risiedono le geometrie dei percorsi;
     * vuoto nel caso si utilizzi lo ShapeFile.
     * @param geometryCol String Nome della colonna dove sono memorizzate le geometrie dei percorsi;
     * vuoto nel caso si utilizzi lo ShapeFile.
     * @param idCol String Nome della colonna che contiene gli identificatori dei percorsi.
     * @return String Identificativo di connessione al motore LRS (Linear Referencing System),
     * un messaggio di errore altrimenti.
     */
    @Path("/initLRS")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
    public String initLRS(@QueryParam("tipoLRS") int tipoLRS,
                          @QueryParam("user") String user,
                          @QueryParam("pwd") String pwd,
                          @QueryParam("connString") String connString,
                          @QueryParam("roadLayer") String roadLayer,
                          @QueryParam("geometryCol") String geometryCol,
                          @QueryParam("idCol") String idCol) {
        scriviLog("Invocata initLRS(" + tipoLRS + "," + user + "," + pwd + "," + connString + "," + roadLayer + "," + geometryCol + "," + idCol + ")");
        /*if (tipoLRS == 1) {
            try {
                DriverManager.registerDriver(new oracle.jdbc.driver.
                                             OracleDriver());
                String connStr = "jdbc:oracle:thin:@" + connString;
                Connection conn = (Connection) DriverManager.
                                  getConnection(connStr, user, pwd);
                String idConn = WSSession.makeIDConn().replace("%","");
                WSSession.setConnection(idConn, conn, roadLayer,
                                        geometryCol, idCol);
                String versionSQL =
                        "select * from V$VERSION where banner like 'CORE%'";

                PreparedStatement ps = conn.prepareStatement(versionSQL);
                OracleResultSet ors = (OracleResultSet) ps.executeQuery();
                String ver = "";
                while (ors.next()) {
                    ver = ors.getString(1);
                    ver = ver.substring(5);
                }
                oraVersion = ver;
                //roadTable = roadLayer;
                //parcelTable = parcelLayer;
                return idConn;
            } catch (Exception e) {
                scriviLog(e);
                return "Errore nella connessione ad Oracle " + e.getMessage();
            }
        }

        //connessione ad SDE
        if (tipoLRS == 2) {*/
            try {
                String idLRS = this.makeID();
                Calendar currenttime = Calendar.getInstance();
                java.sql.Date sqldate = new java.sql.Date((currenttime.getTime()).
                        getTime());
                this.writeDBSDE(idLRS, sqldate, user, pwd, connString, roadLayer,
                                geometryCol, idCol);
                return idLRS;
            }
            catch (Exception e) {
                scriviLog("initLRS: errore!", e);
                return null;
            }
        //}

        //connessione a shapefile
        /*else if (tipoLRS == 3) {
            int res = -1;
            try {
                if (getConnection(user) != null)
                    return user;
                else
                {
                    String idConn;
                    DynSeg DynS = new DynSeg();
                    res = DynS.DSSetShapefile(connString, idCol);
                    if (res == 0) {
                        //idConn = this.makeID();
                        setConnection(user, DynS, "", "", idCol);
                        return user;
                    } else {
                        idConn = "Errore nell'apertura dello shapefile: res = " + res + "; " + connString;
                    }
                    return idConn;
                }
            }
            catch (Exception e) {
                scriviLog(e);
                return "Errore nell'apertura dello shapefile: res = " + res + "; " + connString;
            }
        }
        else
        {
            scriviLog("initLRS: errore! Tipo LRS non valido");
            return null;
        }*/
    }

    /**
     * Chiude la connessione al motore LRS (Linear Referencing System).
     * @param idConn String Identificativo di connessione al motore LRS (Linear Referencing System).
     * @return boolean true se la disconnessione avviene con successo, false atrimenti.
     */

    @Path("/closeLRS")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
    public boolean closeLRS(@QueryParam("idConn") String idConn) {
        scriviLog("Invoacata closeLRS(" + idConn + ")");
        /*if (WSSession.getConnection(idConn) instanceof oracle.jdbc.OracleConnection) {
            try {
                OracleConnection conn = (OracleConnection)
                                        WSSession.getConnection(idConn);
                conn.close();
                WSSession.closeConnection(idConn);
                System.gc();
                return true;
            }
            catch (Exception e) {
                scriviLog(e);
                System.gc();
                return false;
            }
        }
        else if (WSSession.getConnection(idConn) instanceof com.esri.sde.sdk.
                   client.SeConnection) {
            try {
                com.esri.sde.sdk.client.SeConnection conn =
                        (com.esri.sde.sdk.client.SeConnection)
                        WSSession.getConnection(idConn);
                conn.close();
                WSSession.closeConnection(idConn);
                return true;
            }
            catch (Exception e) {
                scriviLog(e);
                return false;
            }
        }
        else if (WSSession.getConnection(idConn) instanceof com.siteco.JRs40DynSeg.DynSeg) {
            WSSession.closeConnection(idConn);
            return true;
        }
        else {
            WSSession.closeConnection(idConn);
            return true;
        }*/
    return true;
    }


    /**
     * Esegue una connessione ad un pool di connessioni Oracle
     * @return OracleConnection La connessione ti tipo OracleConnection;
     * null altrimenti
     */
    private OracleConnection initLRSPool() {
        try {
            javax.naming.Context initContext = new InitialContext();
            javax.naming.Context envContext = (javax.naming.Context) initContext.lookup("java:/comp/env");

            oracle.jdbc.pool.OracleDataSource ds =
                    (oracle.jdbc.pool.OracleDataSource)
                    envContext.lookup("jdbc/ASTA_GEO");
            OracleConnection conn = (OracleConnection) ds.getConnection();

            String versionSQL =
                    "select * from V$VERSION where banner like 'CORE%'";

            PreparedStatement ps = conn.prepareStatement(versionSQL);
            OracleResultSet ors = (OracleResultSet) ps.executeQuery();

            String ver = "";
            while (ors.next()) {
                ver = ors.getString(1);
                ver = ver.substring(5);
            }
            oraVersion = ver;
            return conn;
        } catch (Exception e) {
            scriviLog(e);
            return null;
        }
    }


    /**
     * Restituisce l'EVE_ID + vicino al punto specificato (Funziona con SDO+LRS)
     *
     * @param x double
     * @param y double
     * @param roadTable String
     * @param geomCol String
     * @param idCol String
     * @param asta String
     * @return long
     */
    //@Path("/queryPtOra")
	//@GET
	//@Produces({ MediaType.APPLICATION_XML })
    private long queryPtOra(@QueryParam("x") double x,
                           @QueryParam("y") double y,
                           @QueryParam("roadTable") String roadTable,
                           @QueryParam("geomCol") String geomCol,
                           @QueryParam("idCol") String idCol,
                           @QueryParam("asta") String asta) {
        long result = -1;
        OracleConnection conn = this.initLRSPool();
        PtPrjM res = new PtPrjM(x, y);
        res = this.projPT(x, y, idCol, geomCol,
                          roadTable, conn, asta);
        try {
            conn.close();
        } catch (Exception e) {
            scriviLog(e);
        }
        if (res == null) {
            return -1;
        }
        return res.getId();
        /*
                 oracle.spatial.geometry.JGeometry stradaGeom = null;

                 try {
            OracleConnection conn = (OracleConnection) WSSession.
                                    getOracleConnection(idConn);

            int srid = 0;
            int dim = 0;

            oracle.sql.STRUCT dbObject = null;

            //ricavo la dimensione, la dimensione della misura, e il sistema di riferimento della tabella dei percorsi
            String query = "SELECT " + geomCol + " FROM " + roadTable +
                           " R WHERE ROWNUM = 1";
            PreparedStatement ps = conn.prepareStatement(query);
            OracleResultSet ors = (OracleResultSet) ps.executeQuery();
            while (ors.next()) {
                dbObject = (oracle.sql.STRUCT) ors.getObject(1);
                stradaGeom = oracle.spatial.geometry.JGeometry.load(dbObject);
                srid = stradaGeom.getSRID();
                dim = stradaGeom.getDimensions();
            }

            //coordinate del punto da proiettare
            double[] coord;
            if (dim == 2) {
                //coordinate del punto da proiettare
                coord = new double[2];
                coord[0] = x;
                coord[1] = y;
            } else if (dim == 3) {
                //coordinate del punto da proiettare
                coord = new double[3];
                coord[0] = x;
                coord[1] = y;
                coord[2] = 0;
            } else if (dim == 4) {
                //coordinate del punto da proiettare
                coord = new double[4];
                coord[0] = x;
                coord[1] = y;
                coord[2] = 0;
                coord[3] = 0;
            } else {
                return result;
            }

            //punto da proiettare
            oracle.spatial.geometry.JGeometry jPoint = oracle.spatial.geometry.
                    JGeometry.createPoint(coord, dim,
                                          srid);
            dbObject = oracle.spatial.geometry.JGeometry.store(jPoint, conn);

            query = "SELECT " + idCol + " FROM " + roadTable +
                    " R WHERE SDO_NN(R." + geomCol +
                    ",?,'sdo_num_res=1') = 'TRUE'";

            ps = conn.prepareStatement(query);
            ps.setObject(1, dbObject);
            ors = (OracleResultSet) ps.executeQuery();
            while (ors.next()) {
                result = ors.getLong(1);
            }

                 } catch (Exception exc) {
            exc.getMessage();
                 }
                 return result;
         */
    }


    /**
     * Interrogazione puntuale alla coordinata specificata.
     * @param x double
     * @param y double
     * @param layers {@link ArrayOfGenLayer} Insieme di layers su cui effettuare l'interrogazione.
     * @param idCol String Nome della colonna che memorizza gli identificatori degli oggetti.
     * @param maxResult int Numero massimo di risultati da ritornare.
     * @param idMap String Identificatore della connessione al map server.
     * @return {@link ArrayOfObjsInLayer} Restituisce un array di {@link ObjsInLayer}
     * corrispondente agli oggetti individuati dall'interrogazione.
     */
    @Path("/queryPt2")
	@GET
	@Produces({ MediaType.APPLICATION_XML })
    public com.siteco.classes.ArrayOfObjsInLayer queryPt2(@QueryParam("x") double x,
                                                  @QueryParam("y") double y,
                                                  @QueryParam("layers") List<String> layers,
                                                  @QueryParam("idCol") String idCol,
                                                  @QueryParam("maxResult") int maxResult,
                                                  @QueryParam("idMap") String idMap)
    {
        try {
            ImageDisplay imageDisplay = (ImageDisplay) this.readDB("IMAGEDISPLAY", idMap);

            GenEnvelope env = this.getMapEnvelope(idMap);
            double xDistance = Math.abs(env.getMaxX() - env.getMinX());
            long xImage = imageDisplay.getImageWidth();
            double toll = xDistance * 10 / xImage;
            return this.queryRect2(x - toll, y - toll, x + toll, y + toll,
                                   layers, idCol, 1, idMap);
        } catch (Exception e) {
            scriviLog("queryPt: errore!", e);
            return null;
        }
    }

    /**
     * Interrogazione puntuale alla coordinata specificata.
     * @param x double
     * @param y double
     * @param layers {@link ArrayOfGenLayer} Insieme di layers su cui effettuare l'interrogazione.
     * @param idCol String Nome della colonna che memorizza gli identificatori degli oggetti.
     * @param maxResult int Numero massimo di risultati da ritornare.
     * @param idMap String Identificatore della connessione al map server.
     * @param callback String indica una chiamata jsonp
     * @return {@link ArrayOfObjsInLayer2} Restituisce un array di {@link ObjsInLayer2}
     * corrispondente agli oggetti individuati dall'interrogazione.
     */
    @Path("/queryPt3Json")
	@GET
	@Produces({"application/javascript"})
    public String queryPt3Json(@QueryParam("x") double x,
                            @QueryParam("y") double y,
                            @QueryParam("layers") List<String> layers,
                            @QueryParam("idCol") String idCol,
                            @QueryParam("maxResult") int maxResult,
                            @QueryParam("idMap") String idMap,
                            @QueryParam("callback") String callback)
    {
        scriviLog("Invocata queryPt3(" + x + "," + y + "," + layers + "," + idCol + "," + maxResult + "," + idMap + ")");
        try {
            ImageDisplay imageDisplay = (ImageDisplay) this.readDB("IMAGEDISPLAY", idMap);
            GenEnvelope env = this.getMapEnvelope(idMap);

            double xDistance = Math.abs(env.getMaxX() - env.getMinX());
            long xImage = imageDisplay.getImageWidth();
            double toll = xDistance * 10 / xImage;
            return this.queryRect3Json(x - toll, y - toll, x + toll, y + toll,
                                   layers, idCol, maxResult, idMap, callback);
        } catch (Exception exc) {
            scriviLog(exc);
        }

        return null;
    }
    
    @Path("/queryPt3")
    @GET
    @Produces({"application/xml"})
    public ArrayOfObjsInLayer2 queryPt3(@QueryParam("x") double x, @QueryParam("y") double y, @QueryParam("layers") List<String> layers, @QueryParam("idCol") String idCol, @QueryParam("maxResult") int maxResult, @QueryParam("idMap") String idMap) {
        scriviLog("Invocata queryPt3(" + x + "," + y + "," + layers + "," + idCol + "," + maxResult + "," + idMap + ")");
        try {
            ImageDisplay imageDisplay = (ImageDisplay) readDB("IMAGEDISPLAY", idMap);
            GenEnvelope env = getMapEnvelope(idMap);

            double xDistance = Math.abs(env.getMaxX() - env.getMinX());
            long xImage = imageDisplay.getImageWidth();
            double toll = xDistance * 10.0D / xImage;
            return queryRect3(x - toll, y - toll, x + toll, y + toll, layers, idCol, maxResult, idMap);
        } catch (Exception exc) {
            scriviLog(exc);
        }
        return null;
    }

    /**
     * Interrogazione puntuale alla coordinata specificata.
     * @param x double
     * @param y double
     * @param layers {@link ArrayOfGenLayer} Insieme di layers su cui effettuare l'interrogazione.
     * @param idCol String Nome della colonna che memorizza gli identificatori degli oggetti.
     * @param maxResult int Numero massimo di risultati da ritornare.
     * @param idMap String Identificatore della connessione al map server.
     * @param callback String indica una chiamata jsonp
     * @return {@link ArrayOfObjsInLayer2} Restituisce un array di {@link ObjsInLayer2}
     * corrispondente agli oggetti individuati dall'interrogazione.
     */
    @Path("/queryPt4Json")
    @GET
    @Produces({"application/javascript"})
    /*public com.siteco.ArrayOfObjsInLayer3 queryPt4(@QueryParam("x") double x,
                                                   @QueryParam("y") double y,
                                                   @QueryParam("layers") ArrayOfGenLayer layers,
                                                   @QueryParam("maxResult") int maxResult,
                                                   @QueryParam("idMap") String idMap)*/
    public String queryPt4Json(@QueryParam("x") double x,
                            @QueryParam("y") double y,
                            @QueryParam("layers") List<String> layers,
                            @QueryParam("maxResult") int maxResult,
                            @QueryParam("idMap") String idMap,
                            @QueryParam("callback") String callback)
    {
        scriviLog("Invocata queryPt4(" + x + "," + y + "," + layers + "," + maxResult + "," + idMap + ")");
        try {
            ImageDisplay imageDisplay = (ImageDisplay) this.readDB("IMAGEDISPLAY", idMap);
            GenEnvelope env = this.getMapEnvelope(idMap);

            double xDistance = Math.abs(env.getMaxX() - env.getMinX());
            long xImage = imageDisplay.getImageWidth();
            double toll = xDistance * 10 / xImage;
            return this.queryRect4Json(x - toll, y - toll, x + toll, y + toll,
                                   layers, maxResult, idMap, callback);
        } catch (Exception exc) {
            scriviLog(exc);
        }

        return null;
    }
    
    @Path("/queryPt4")
    @GET
    @Produces({"application/xml"})
    public ArrayOfObjsInLayer3 queryPt4(@QueryParam("x") double x, @QueryParam("y") double y, @QueryParam("layers") List<String> layers, @QueryParam("maxResult") int maxResult, @QueryParam("idMap") String idMap) {
        scriviLog("Invocata queryPt4(" + x + "," + y + "," + layers + "," + maxResult + "," + idMap + ")");
        try {
            ImageDisplay imageDisplay = (ImageDisplay) readDB("IMAGEDISPLAY", idMap);
            GenEnvelope env = getMapEnvelope(idMap);

            double xDistance = Math.abs(env.getMaxX() - env.getMinX());
            long xImage = imageDisplay.getImageWidth();
            double toll = xDistance * 10.0D / xImage;
            return queryRect4(x - toll, y - toll, x + toll, y + toll, layers, maxResult, idMap);
        } catch (Exception exc) {
            scriviLog(exc);
        }
        return null;
    }

    /**
     * Interrogazione sulla finestra identificata dalle coordinate specificate.
     * @param x1 double
     * @param y1 double
     * @param x2 double
     * @param y2 double
     * @param layers {@link ArrayOfGenLayer} Insieme di layers su cui effettuare l'interrogazione.
     * @param idCol String Nome della colonna che memorizza gli identificatori degli oggetti.
     * @param maxResult int Numero massimo di risultati da ritornare.
     * @param idMap String Identificatore della connessione al map server.
     * @return {@link ArrayOfObjsInLayer} Restituisce un array di {@link ObjsInLayer}
     * corrispondente agli oggetti individuati dall'interrogazione.
     */
    @Path("/queryRect2")
	@GET
	@Produces({ MediaType.APPLICATION_XML })
    public com.siteco.classes.ArrayOfObjsInLayer queryRect2(@QueryParam("x1") double x1,
                                                    @QueryParam("y1") double y1,
                                                    @QueryParam("x2") double x2,
                                                    @QueryParam("y2") double y2,
                                                    @QueryParam("layers") List<String> layers,
                                                    @QueryParam("idCol") String idCol,
                                                    @QueryParam("maxResult") int maxResult,
                                                    @QueryParam("idMap") String idMap) {
        com.siteco.classes.ArrayOfObjsInLayer selection = new com.siteco.classes.ArrayOfObjsInLayer();
        try {
            String mapName = this.readDB("MAPNAME", idMap).toString();
            MapServerBindingStub mapServer = new MapServerBindingStub(this.readDB("CONNSTRING", idMap).toString());
            MapDescription mDesc = (MapDescription) this.readDB("MAPDESCRIPTION", idMap);
            Vector layerConOggetti = new Vector(); 
            int numPartialResult = 0;
            EnvelopeN rect = new EnvelopeN();
            rect.setXMin(x1);
            rect.setYMin(y1);
            rect.setXMax(x2);
            rect.setYMax(y2);
            SpatialFilter filter = null;
            LayerDescription[] layerDescriptions = mDesc.
                    getLayerDescriptions();
            MapLayerInfo[] layerInfos = mapServer.getServerInfo(mapName).getMapLayerInfos();
            int numLayers = layerInfos.length;
            for (int t = 0; t < layers.size(); t++) {
                String nomeLayer = layers.get(t);
                for (int i = 0; i < numLayers; i++) {
                    if (layerInfos[i].getName().equalsIgnoreCase(
                            nomeLayer)) {
                        LayerDescription mapLayer = null;
                        MapLayerInfo layerInfo = layerInfos[i];
                        if (layerInfos[i].getSubLayerIDs() != null
                                || !layerInfos[i].getLayerType().equalsIgnoreCase("Feature Layer")) {
                            break;
                        }
                        for (int j = 0; j < layerDescriptions.length; j++) {
                            if (layerDescriptions[j].getLayerID() ==
                                layerInfos[i].getLayerID()) {
                                mapLayer = layerDescriptions[j];
                                break;
                            }
                        }
                        if (mapLayer.isVisible() == false)
                            break;
                        Fields fields = layerInfos[i].getFields();
                        com.esri.arcgisws.Field[] fieldArray = fields.getFieldArray();
                        boolean found = false;
                        for (int z = 0; z < fieldArray.length; z++) {
                            if (fieldArray[z].getName().equalsIgnoreCase(idCol) ||
                                fieldArray[z].getName().equalsIgnoreCase("ROAD_ID") ||
                                fieldArray[z].getName().equalsIgnoreCase("ID_ROAD") ||
                                fieldArray[z].getName().equalsIgnoreCase("EVE_ID") ||
                                fieldArray[z].getName().equalsIgnoreCase("ID_EVE")) {
                                found = true;
                            }
                        }
                        if (!found)
                            break;
                        filter = new SpatialFilter();
                        filter.setFilterGeometry(rect);
                        filter.setSpatialRel(EsriSpatialRelEnum.esriSpatialRelIntersects);

                        RecordSet records = mapServer.queryFeatureData(mapName,
                                mapLayer.getLayerID(), filter);
                        FIDSet ids = mapServer.queryFeatureIDs(mapName, mapLayer.getLayerID(),
                                filter);
                        mapLayer.setSelectionFeatures(ids.getFIDArray());
                        Record[] recordArray = records.getRecords();
                        //Cursor cursor = records..getCursor(true);
                        //IRow row = null;
                        int index = -1;
                        if (idCol.equalsIgnoreCase("ROAD_ID") ||
                            idCol.equalsIgnoreCase("ID_ROAD")) {
                            for (int z = 0; z < fieldArray.length; z++) {
                                if (fieldArray[z].getName().
                                    equalsIgnoreCase("ROAD_ID") ||
                                    fieldArray[z].getName().
                                    equalsIgnoreCase("ID_ROAD")) {
                                    index = z;
                                }
                            }
                        } else if (idCol.equalsIgnoreCase("EVE_ID") ||
                                   idCol.equalsIgnoreCase("ID_EVE")) {
                            for (int z = 0; z < fieldArray.length; z++) {
                                if (fieldArray[z].getName().
                                    equalsIgnoreCase("EVE_ID") ||
                                    fieldArray[z].getName().
                                    equalsIgnoreCase("ID_EVE")) {
                                    index = z;
                                }
                            }
                        }

                        if (index == -1) {
                            mapLayer.setSelectionFeatures(null);
                            continue;
                        }

                        if (recordArray != null && recordArray.length > 0) {
                            Vector ris = new Vector();
                            ObjsInLayer oil = new ObjsInLayer();
                            oil.setName(layerInfo.getName());
                            for (int z = 0; z < recordArray.length; z++) {
                                numPartialResult++;
                                ris.add(recordArray[z].getValues()[index]);
                            }
                            int[] array = new int[ris.size()];
                            for (int z = 0; z < ris.size(); z++) {
                                try {
                                    array[z] = (int) Double.parseDouble(ris.
                                            get(z).toString());
                                }
                                catch (Exception eee) {
                                    //per inciweb: tolgo lo 0 iniziale e poi le due lettere finali
                                    String r = ris.get(z).toString().substring(1);
                                    r = r.substring(0, r.length() -2);
                                    array[z] = (int) Double.parseDouble(r);
                                }
                            }
                            oil.setObjs(new com.siteco.classes.ArrayOfInt(array));
                            layerConOggetti.add(oil);
                        }
                        break;
                    }
                }
                if (numPartialResult >= maxResult)
                    break;
            }
            if (layerConOggetti.size() > 0) {
                ObjsInLayer[] array2 = new ObjsInLayer[layerConOggetti.
                                       size()];
                layerConOggetti.toArray(array2);
                selection.setOil(array2);
            }
            this.updateDB(idMap, "MAPDESCRIPTION", mDesc);
            return selection;
        } catch (Exception e) {
            scriviLog("queryRect: errore!", e);
            return null;
        }
    }


    /**
     * Interrogazione sulla finestra identificata dalle coordinate specificate.
     * @param x1 double
     * @param y1 double
     * @param x2 double
     * @param y2 double
     * @param layers {@link ArrayOfGenLayer} Insieme di layers su cui effettuare l'interrogazione.
     * @param idCol String Nome della colonna che memorizza gli identificatori degli oggetti.
     * @param maxResult int Numero massimo di risultati da ritornare.
     * @param idMap String Identificatore della connessione al map server.
     * @param callback String indica una chiamata jsonp
     * @return {@link ArrayOfObjsInLayer2} Restituisce un array di {@link ObjsInLayer2}
     * corrispondente agli oggetti individuati dall'interrogazione.
     */
    @Path("/queryRect3Json")
	@GET
	@Produces({"application/javascript"})
    public String queryRect3Json(@QueryParam("x1") double x1,
                                                     @QueryParam("y1") double y1,
                                                     @QueryParam("x2") double x2,
                                                     @QueryParam("y2") double y2,
                                                     @QueryParam("layers") List<String> layers,
                                                     @QueryParam("idCol") String idCol,
                                                     @QueryParam("maxResult") int maxResult,
                                                     @QueryParam("idMap") String idMap,
                                                     @QueryParam("callback") String callback) 
    {
        scriviLog("Invocata queryRect3(" + x1 + "," + y1 + "," + x2 + "," + y2 + "," + layers + "," + idCol + "," + maxResult + "," + idMap + ")");
        com.siteco.classes.ArrayOfObjsInLayer2 selection = new com.siteco.classes.ArrayOfObjsInLayer2();
         try {
            String mapName = this.readDB("MAPNAME", idMap).toString();
            MapServerBindingStub mapServer = new MapServerBindingStub(this.readDB("CONNSTRING", idMap).toString());
            MapDescription mDesc = (MapDescription) this.readDB("MAPDESCRIPTION", idMap);

            Vector layerConOggetti = new Vector();
            int numPartialResult = 0;
            EnvelopeN rect = new EnvelopeN();
            rect.setXMin(x1);
            rect.setYMin(y1);
            rect.setXMax(x2);
            rect.setYMax(y2);
            SpatialFilter filter = null;
            LayerDescription[] layerDescriptions = mDesc.
                    getLayerDescriptions();
            MapLayerInfo[] layerInfos = mapServer.getServerInfo(mapName).getMapLayerInfos();

            int numLayers = layerInfos.length;
            for (int t = 0; t < layers.size(); t++) {
                String nomeLayer = layers.get(t);
                for (int i = 0; i < numLayers; i++) {
                    if (layerInfos[i].getName().equalsIgnoreCase(
                            nomeLayer)) {
                        LayerDescription mapLayer = null;
                        MapLayerInfo layerInfo = layerInfos[i];
                        if (layerInfos[i].getSubLayerIDs() != null
                                 || !layerInfos[i].getLayerType().equalsIgnoreCase("Feature Layer")) {
                             break;
                        }
                        for (int j = 0; j < layerDescriptions.length; j++) {
                            if (layerDescriptions[j].getLayerID() ==
                                layerInfos[i].getLayerID()) {
                                mapLayer = layerDescriptions[j];
                                break;
                            }
                        }
                        //if (mapLayer.isVisible() == false)
                        //    break;
                        Fields fields = layerInfos[i].getFields();
                         com.esri.arcgisws.Field[] fieldArray = fields.getFieldArray();
                         boolean found = false;
                         for (int z = 0; z < fieldArray.length; z++) {
                             if (fieldArray[z].getName().equalsIgnoreCase(idCol) ||
                                 fieldArray[z].getName().equalsIgnoreCase("ROAD_ID") ||
                                 fieldArray[z].getName().equalsIgnoreCase("ID_ROAD") ||
                                 fieldArray[z].getName().equalsIgnoreCase("EVE_ID") ||
                                 fieldArray[z].getName().equalsIgnoreCase("ID_EVE")) {
                                 found = true;
                             }
                         }
                         if (!found)
                            break;
                        filter = new SpatialFilter();
                        filter.setFilterGeometry(rect);
                        filter.setSpatialRel(EsriSpatialRelEnum.esriSpatialRelIntersects);

                        RecordSet records = mapServer.queryFeatureData(mapName,
                                mapLayer.getLayerID(), filter);
                        FIDSet ids = mapServer.queryFeatureIDs(mapName, mapLayer.getLayerID(),
                                filter);
                        mapLayer.setSelectionFeatures(ids.getFIDArray());
                        Record[] recordArray = records.getRecords();
                        int index = -1;
                        if (idCol.equalsIgnoreCase("ROAD_ID") ||
                             idCol.equalsIgnoreCase("ID_ROAD")) {
                             for (int z = 0; z < fieldArray.length; z++) {
                                 if (fieldArray[z].getName().
                                     equalsIgnoreCase("ROAD_ID") ||
                                     fieldArray[z].getName().
                                     equalsIgnoreCase("ID_ROAD")) {
                                     index = z;
                                 }
                             }
                         } else if (idCol.equalsIgnoreCase("EVE_ID") ||
                                    idCol.equalsIgnoreCase("ID_EVE")) {
                             for (int z = 0; z < fieldArray.length; z++) {
                                 if (fieldArray[z].getName().
                                     equalsIgnoreCase("EVE_ID") ||
                                     fieldArray[z].getName().
                                     equalsIgnoreCase("ID_EVE")) {
                                     index = z;
                                 }
                             }
                         }
                         else {
                             for (int z = 0; z < fieldArray.length; z++) {
                                 if (fieldArray[z].getName().
                                     equalsIgnoreCase(idCol)) {
                                     index = z;
                                 }
                             }
                         }

                        if (index == -1) {
                            mapLayer.setSelectionFeatures(null);
                            continue;
                        }


                        if (recordArray != null && recordArray.length > 0) {
                            Vector ris = new Vector();
                            ObjsInLayer2 oil = new ObjsInLayer2();
                            oil.setName(layerInfo.getName());
                            for (int k = 0; k < Math.min(recordArray.length, maxResult); k++) {
                                Record record = recordArray[k];
                                numPartialResult++;
                                java.lang.Object o = record.getValues()[index];
                                if (fieldArray[index].getType() == EsriFieldType.esriFieldTypeDouble) {
                                    Double d = (Double) o;
                                    NumberFormat formatter = new DecimalFormat("0");
                                    ris.add(formatter.format(d.doubleValue()));
                                } else {
                                    ris.add(o.toString());
                                }
                            }
                            String[] array = new String[ris.size()];
                            for (int z = 0; z < ris.size(); z++) {
                                try {
                                    array[z] = (String) ris.get(z).toString();
                                }
                                catch (Exception eee) {
                                }
                            }
                            oil.setObjs(new com.siteco.classes.ArrayOfString(array));
                            layerConOggetti.add(oil);
                        }
                        break;
                    }
                }
            }
            if (layerConOggetti.size() > 0) {
                ObjsInLayer2[] array2 = new ObjsInLayer2[layerConOggetti.
                                       size()];
                layerConOggetti.toArray(array2);
                selection.setOil(array2);
            }
            this.updateDB(idMap, "MAPDESCRIPTION", mDesc);
            
            JSONObject res = new JSONObject(selection);
             if (callback != null && callback.length() > 0)
                return callback + "(" + res.toString() + ")";
             else
                 return res.toString();
             
        } catch (Exception exc) {
            scriviLog(exc);
        }
        return null;
    }

    @Path("/queryRect3")
    @GET
    @Produces({"application/xml"})
    public ArrayOfObjsInLayer2 queryRect3(@QueryParam("x1") double x1, @QueryParam("y1") double y1, @QueryParam("x2") double x2, @QueryParam("y2") double y2, @QueryParam("layers") List<String> layers, @QueryParam("idCol") String idCol, @QueryParam("maxResult") int maxResult, @QueryParam("idMap") String idMap) {
        scriviLog("Invocata queryRect3(" + x1 + "," + y1 + "," + x2 + "," + y2 + "," + layers + "," + idCol + "," + maxResult + "," + idMap + ")");
        ArrayOfObjsInLayer2 selection = new ArrayOfObjsInLayer2();
        try {
            String mapName = readDB("MAPNAME", idMap).toString();
            MapServerBindingStub mapServer = new MapServerBindingStub(readDB("CONNSTRING", idMap).toString());
            MapDescription mDesc = (MapDescription) readDB("MAPDESCRIPTION", idMap);

            Vector layerConOggetti = new Vector();
            int numPartialResult = 0;
            EnvelopeN rect = new EnvelopeN();
            rect.setXMin(x1);
            rect.setYMin(y1);
            rect.setXMax(x2);
            rect.setYMax(y2);
            SpatialFilter filter = null;

            LayerDescription[] layerDescriptions = mDesc.getLayerDescriptions();
            MapLayerInfo[] layerInfos = mapServer.getServerInfo(mapName).getMapLayerInfos();

            int numLayers = layerInfos.length;
            for (int t = 0; t < layers.size(); t++) {
                String nomeLayer = (String) layers.get(t);
                for (int i = 0; i < numLayers; i++) {
                    if (layerInfos[i].getName().equalsIgnoreCase(nomeLayer)) {
                        LayerDescription mapLayer = null;
                        MapLayerInfo layerInfo = layerInfos[i];
                        if ((layerInfos[i].getSubLayerIDs() != null)
                                || (!layerInfos[i].getLayerType().equalsIgnoreCase("Feature Layer"))) {
                            break;
                        }
                        for (int j = 0; j < layerDescriptions.length; j++) {
                            if (layerDescriptions[j].getLayerID() == layerInfos[i].getLayerID()) {
                                mapLayer = layerDescriptions[j];
                                break;
                            }
                        }
                        Fields fields = layerInfos[i].getFields();
                        Field[] fieldArray = fields.getFieldArray();
                        boolean found = false;
                        for (int z = 0; z < fieldArray.length; z++) {
                            if ((fieldArray[z].getName().equalsIgnoreCase(idCol))
                                    || (fieldArray[z].getName().equalsIgnoreCase("ROAD_ID"))
                                    || (fieldArray[z].getName().equalsIgnoreCase("ID_ROAD"))
                                    || (fieldArray[z].getName().equalsIgnoreCase("EVE_ID"))
                                    || (fieldArray[z].getName().equalsIgnoreCase("ID_EVE"))) {
                                found = true;
                            }
                        }
                        if (!found) {
                            break;
                        }
                        filter = new SpatialFilter();
                        filter.setFilterGeometry(rect);
                        filter.setSpatialRel(EsriSpatialRelEnum.esriSpatialRelIntersects);

                        RecordSet records = mapServer.queryFeatureData(mapName, mapLayer
                                .getLayerID(), filter);
                        FIDSet ids = mapServer.queryFeatureIDs(mapName, mapLayer.getLayerID(), filter);

                        mapLayer.setSelectionFeatures(ids.getFIDArray());
                        Record[] recordArray = records.getRecords();
                        int index = -1;
                        if ((idCol.equalsIgnoreCase("ROAD_ID"))
                                || (idCol.equalsIgnoreCase("ID_ROAD"))) {
                            for (int z = 0; z < fieldArray.length; z++) {
                                if ((fieldArray[z].getName().equalsIgnoreCase("ROAD_ID"))
                                        || (fieldArray[z].getName().equalsIgnoreCase("ID_ROAD"))) {
                                    index = z;
                                }
                            }
                        } else if ((idCol.equalsIgnoreCase("EVE_ID"))
                                || (idCol.equalsIgnoreCase("ID_EVE"))) {
                            for (int z = 0; z < fieldArray.length; z++) {
                                if ((fieldArray[z].getName().equalsIgnoreCase("EVE_ID"))
                                        || (fieldArray[z].getName().equalsIgnoreCase("ID_EVE"))) {
                                    index = z;
                                }
                            }
                        } else {
                            for (int z = 0; z < fieldArray.length; z++) {
                                if (fieldArray[z].getName().equalsIgnoreCase(idCol)) {
                                    index = z;
                                }
                            }
                        }
                        if (index == -1) {
                            mapLayer.setSelectionFeatures(null);
                        } else {
                            if ((recordArray == null) || (recordArray.length <= 0)) {
                                break;
                            }
                            Vector ris = new Vector();
                            ObjsInLayer2 oil = new ObjsInLayer2();
                            oil.setName(layerInfo.getName());
                            for (int k = 0; k < Math.min(recordArray.length, maxResult); k++) {
                                Record record = recordArray[k];
                                numPartialResult++;
                                Object o = record.getValues()[index];
                                if (fieldArray[index].getType() == EsriFieldType.esriFieldTypeDouble) {
                                    Double d = (Double) o;
                                    NumberFormat formatter = new DecimalFormat("0");
                                    ris.add(formatter.format(d.doubleValue()));
                                } else {
                                    ris.add(o.toString());
                                }
                            }
                            String[] array = new String[ris.size()];
                            for (int z = 0; z < ris.size(); z++) {
                                try {
                                    array[z] = ris.get(z).toString();
                                } catch (Exception eee) {
                                }
                            }
                            oil.setObjs(new com.siteco.classes.ArrayOfString(array));
                            layerConOggetti.add(oil);
                            break;
                        }
                    }
                }
            }
            if (layerConOggetti.size() > 0) {
                ObjsInLayer2[] array2 = new ObjsInLayer2[layerConOggetti.size()];
                layerConOggetti.toArray(array2);
                selection.setOil(array2);
            }
            updateDB(idMap, "MAPDESCRIPTION", mDesc);
            return selection;
        } catch (Exception exc) {
            scriviLog(exc);
        }
        return null;
    }

    /**
     * Interrogazione sulla finestra identificata dalle coordinate specificate.
     * @param x1 double
     * @param y1 double
     * @param x2 double
     * @param y2 double
     * @param layers {@link ArrayOfGenLayer} Insieme di layers su cui effettuare l'interrogazione.
     * @param idCol String Nome della colonna che memorizza gli identificatori degli oggetti.
     * @param maxResult int Numero massimo di risultati da ritornare.
     * @param idMap String Identificatore della connessione al map server.
     * @param callback String indica una chiamata jsonp
     * @return {@link ArrayOfObjsInLayer2} Restituisce un array di {@link ObjsInLayer2}
     * corrispondente agli oggetti individuati dall'interrogazione.
     */
    @Path("/queryRect4Json")
	@GET
	@Produces({"application/javascript"})
    /*public com.siteco.ArrayOfObjsInLayer3 queryRect4(@QueryParam("x1") double x1,
                                                     @QueryParam("y1") double y1,
                                                     @QueryParam("x2") double x2,
                                                     @QueryParam("y2") double y2,
                                                     @QueryParam("layers") ArrayOfGenLayer layers,
                                                     @QueryParam("maxResult") int maxResult,
                                                     @QueryParam("idMap") String idMap) {*/
    public String queryRect4Json(@QueryParam("x1") double x1,
                                                     @QueryParam("y1") double y1,
                                                     @QueryParam("x2") double x2,
                                                     @QueryParam("y2") double y2,
                                                     @QueryParam("layers") List<String> layers,
                                                     @QueryParam("maxResult") int maxResult,
                                                     @QueryParam("idMap") String idMap,
                                                     @QueryParam("callback") String callback)
    {
        scriviLog("Invocata queryRect4(" + x1 + "," + y1 + "," + x2 + "," + y2 + "," + layers + "," + maxResult + "," + idMap + ")");
        com.siteco.classes.ArrayOfObjsInLayer3 selection = new com.siteco.classes.ArrayOfObjsInLayer3();
         try {
            String mapName = this.readDB("MAPNAME", idMap).toString();
            MapServerBindingStub mapServer = new MapServerBindingStub(this.readDB("CONNSTRING", idMap).toString());
            MapDescription mDesc = (MapDescription) this.readDB("MAPDESCRIPTION", idMap);
            
            /*x1 = 11729760.0;
            y1 = 4918725.0;
            x2 = 1rei 1729770.0;
            y2 = 4918735.0;*/
            
            Vector layerConOggetti = new Vector();
            int numPartialResult = 0;
            EnvelopeN rect = new EnvelopeN();
            rect.setXMin(x1);
            rect.setYMin(y1);
            rect.setXMax(x2);
            rect.setYMax(y2);
            SpatialFilter filter = null;
            LayerDescription[] layerDescriptions = mDesc.
                    getLayerDescriptions();
            MapLayerInfo[] layerInfos = mapServer.getServerInfo(mapName).getMapLayerInfos();

            int numLayers = layerInfos.length;
            for (int t = 0; t < layers.size(); t++) {
                //GenLayer layer = layers.getGl(t);
                String nomeLayer = layers.get(t);
                for (int i = 0; i < numLayers; i++) {
                    if (layerInfos[i].getName().equalsIgnoreCase(
                            nomeLayer)) {
                        LayerDescription mapLayer = null;
                        MapLayerInfo layerInfo = layerInfos[i];
                        if (layerInfos[i].getSubLayerIDs() != null
                                 || !layerInfos[i].getLayerType().equalsIgnoreCase("Feature Layer")) {
                             break;
                        }
                        for (int j = 0; j < layerDescriptions.length; j++) {
                            if (layerDescriptions[j].getLayerID() ==
                                layerInfos[i].getLayerID()) {
                                mapLayer = layerDescriptions[j];
                                break;
                            }
                        }
                        //if (mapLayer.isVisible() == false)
                        //    break;
                        Fields fields = layerInfos[i].getFields();
                        com.esri.arcgisws.Field[] fieldArray = fields.getFieldArray();

                        filter = new SpatialFilter();
                        filter.setFilterGeometry(rect);
                        filter.setSpatialRel(EsriSpatialRelEnum.esriSpatialRelIntersects);

                        RecordSet records = mapServer.queryFeatureData(mapName,
                                mapLayer.getLayerID(), filter);
                        FIDSet ids = mapServer.queryFeatureIDs(mapName, mapLayer.getLayerID(),
                                filter);
                        mapLayer.setSelectionFeatures(ids.getFIDArray());
                        Record[] recordArray = records.getRecords();

                        if (recordArray != null && recordArray.length > 0) {
                            ObjsInLayer3 oil3 = new ObjsInLayer3();

                            com.siteco.classes.ArrayOfString campi = new com.siteco.classes.ArrayOfString();
                            String[] nomeCampi = new String[fieldArray.length];
                            for (int f = 0; f < fieldArray.length; f++) {
                                nomeCampi[f] = fieldArray[f].getName();
                            }
                            campi.setObjs(nomeCampi);

                            ArrayOfArrayOfString arrayOfRecords = new ArrayOfArrayOfString();
                            com.siteco.classes.ArrayOfString[] trecords = new com.siteco.classes.ArrayOfString[recordArray.length];
                            for (int f = 0; f < Math.min(recordArray.length, maxResult); f++) {
                                String[] arrayTemp = new String[recordArray[f].getValues().length];
                                for (int g = 0; g < recordArray[f].getValues().length; g++) {
                                    if (recordArray[f].getValues()[g] != null)
                                        arrayTemp[g] = recordArray[f].getValues()[g].toString();
                                    else 
                                        arrayTemp[g] = "";
                                }
                                com.siteco.classes.ArrayOfString tempAOS = new com.siteco.classes.ArrayOfString();
                                tempAOS.setObjs(arrayTemp);
                                trecords[f] = tempAOS;
                            }
                            arrayOfRecords.setObjs(trecords);

                            oil3.setName(nomeLayer);
                            oil3.setFields(campi);
                            oil3.setValues(arrayOfRecords);
                            layerConOggetti.add(oil3);
                            /*Vector ris = new Vector();
                            ObjsInLayer2 oil = new ObjsInLayer2();
                            oil.setName(layerInfo.getName());
                            for (int k = 0; k < Math.max(recordArray.length, maxResult); k++) {
                                Record record = recordArray[k];
                                numPartialResult++;
                                java.lang.Object o = record.getValues()[index];
                                if (fieldArray[index].getType() == EsriFieldType.esriFieldTypeDouble) {
                                    Double d = (Double) o;
                                    NumberFormat formatter = new DecimalFormat("0");
                                    ris.add(formatter.format(d.doubleValue()));
                                } else {
                                    ris.add(o.toString());
                                }
                            }
                            String[] array = new String[ris.size()];
                            for (int z = 0; z < ris.size(); z++) {
                                try {
                                    array[z] = (String) ris.get(z).toString();
                                }
                                catch (Exception eee) {
                                }
                            }
                            oil.setObjs(new ArrayOfString(array));
                            layerConOggetti.add(oil);*/
                        }
                        break;
                    }
                }
            }
            if (layerConOggetti.size() > 0) {
                ObjsInLayer3[] array3 = new ObjsInLayer3[layerConOggetti.size()];
                layerConOggetti.toArray(array3);
                selection.setOil(array3);
            }
            this.updateDB(idMap, "MAPDESCRIPTION", mDesc);
            
            JSONObject res = new JSONObject(selection);
             if (callback != null && callback.length() > 0)
                return callback + "(" + res.toString() + ")";
             else
                 return res.toString();
             
        } catch (Exception exc) {
            scriviLog(exc);
        }
        return null;
    }

@Path("/queryRect4")
    @GET
    @Produces({"application/xml"})
    public ArrayOfObjsInLayer3 queryRect4(@QueryParam("x1") double x1, @QueryParam("y1") double y1, @QueryParam("x2") double x2, @QueryParam("y2") double y2, @QueryParam("layers") List<String> layers, @QueryParam("maxResult") int maxResult, @QueryParam("idMap") String idMap) {
        scriviLog("Invocata queryRect4(" + x1 + "," + y1 + "," + x2 + "," + y2 + "," + layers + "," + maxResult + "," + idMap + ")");
        ArrayOfObjsInLayer3 selection = new ArrayOfObjsInLayer3();
        try {
            String mapName = readDB("MAPNAME", idMap).toString();
            MapServerBindingStub mapServer = new MapServerBindingStub(readDB("CONNSTRING", idMap).toString());
            MapDescription mDesc = (MapDescription) readDB("MAPDESCRIPTION", idMap);

            Vector layerConOggetti = new Vector();
            int numPartialResult = 0;
            EnvelopeN rect = new EnvelopeN();
            rect.setXMin(x1);
            rect.setYMin(y1);
            rect.setXMax(x2);
            rect.setYMax(y2);
            SpatialFilter filter = null;

            LayerDescription[] layerDescriptions = mDesc.getLayerDescriptions();
            MapLayerInfo[] layerInfos = mapServer.getServerInfo(mapName).getMapLayerInfos();

            int numLayers = layerInfos.length;
            for (int t = 0; t < layers.size(); t++) {
                String nomeLayer = (String) layers.get(t);
                for (int i = 0; i < numLayers; i++) {
                    if (layerInfos[i].getName().equalsIgnoreCase(nomeLayer)) {
                        LayerDescription mapLayer = null;
                        MapLayerInfo layerInfo = layerInfos[i];
                        if ((layerInfos[i].getSubLayerIDs() != null)
                                || (!layerInfos[i].getLayerType().equalsIgnoreCase("Feature Layer"))) {
                            break;
                        }
                        for (int j = 0; j < layerDescriptions.length; j++) {
                            if (layerDescriptions[j].getLayerID() == layerInfos[i].getLayerID()) {
                                mapLayer = layerDescriptions[j];
                                break;
                            }
                        }
                        Fields fields = layerInfos[i].getFields();
                        Field[] fieldArray = fields.getFieldArray();

                        filter = new SpatialFilter();
                        filter.setFilterGeometry(rect);
                        filter.setSpatialRel(EsriSpatialRelEnum.esriSpatialRelIntersects);

                        RecordSet records = mapServer.queryFeatureData(mapName, mapLayer
                                .getLayerID(), filter);
                        FIDSet ids = mapServer.queryFeatureIDs(mapName, mapLayer.getLayerID(), filter);

                        mapLayer.setSelectionFeatures(ids.getFIDArray());
                        Record[] recordArray = records.getRecords();
                        if ((recordArray == null) || (recordArray.length <= 0)) {
                            break;
                        }
                        ObjsInLayer3 oil3 = new ObjsInLayer3();

                        com.siteco.classes.ArrayOfString campi = new com.siteco.classes.ArrayOfString();
                        String[] nomeCampi = new String[fieldArray.length];
                        for (int f = 0; f < fieldArray.length; f++) {
                            nomeCampi[f] = fieldArray[f].getName();
                        }
                        campi.setObjs(nomeCampi);

                        ArrayOfArrayOfString arrayOfRecords = new ArrayOfArrayOfString();
                        com.siteco.classes.ArrayOfString[] trecords = new com.siteco.classes.ArrayOfString[recordArray.length];
                        for (int f = 0; f < Math.min(recordArray.length, maxResult); f++) {
                            String[] arrayTemp = new String[recordArray[f].getValues().length];
                            for (int g = 0; g < recordArray[f].getValues().length; g++) {
                                if (recordArray[f].getValues()[g] != null) {
                                    arrayTemp[g] = recordArray[f].getValues()[g].toString();
                                } else {
                                    arrayTemp[g] = "";
                                }
                            }
                            com.siteco.classes.ArrayOfString tempAOS = new com.siteco.classes.ArrayOfString();
                            tempAOS.setObjs(arrayTemp);
                            trecords[f] = tempAOS;
                        }
                        arrayOfRecords.setObjs(trecords);

                        oil3.setName(nomeLayer);
                        oil3.setFields(campi);
                        oil3.setValues(arrayOfRecords);
                        layerConOggetti.add(oil3);
                        break;
                    }
                }
            }
            if (layerConOggetti.size() > 0) {
                ObjsInLayer3[] array3 = new ObjsInLayer3[layerConOggetti.size()];
                layerConOggetti.toArray(array3);
                selection.setOil(array3);
            }
            updateDB(idMap, "MAPDESCRIPTION", mDesc);
            return selection;
        } catch (Exception exc) {
            scriviLog(exc);
        }
        return null;
    }

    /**
     * inizializza il modulo che gestisce la segmentazione dinamica in shapefile
     * (in assenza di SDO/SDE)
     *
     * @param shapefile String Nome delle shapefile che contiene il grafo dei
     *   percorsi
     * @return String
     */
    /*private String initDynSeg(String shapefile, String routeField) {
        try {
            String idConn;
            com.siteco.JRs40DynSeg.DynSeg DynS = new com.siteco.JRs40DynSeg.
                                                 DynSeg();
            int res = DynS.DSSetShapefile(shapefile, routeField);
            if (res == 0) {
                idConn = WSSession.makeIDConn().replace("%","");
                WSSession.setDynSegConnection(idConn, DynS);
                return idConn;
            } else {
                idConn = "ERROR " + res;
            }
            return idConn;
        } catch (Exception e) {
            scriviLog(e);
            return "ERROR " + e.getMessage();
        }
    }*/
    
    private void initLogger()
    {
        String sConfigFileName="log4j.xml";
        java.net.URL url = null;
        logger = Logger.getLogger("LOCALIZZATOREREST");
        if (logger == null)
        {
            sConfigFileName="log4j.xml";
            ClassLoader oLoader = getClass().getClassLoader();
            url = oLoader.getResource(sConfigFileName);
            DOMConfigurator.configure(url);
            logger = Logger.getLogger("localizzatore_rest");
        }      
    }

    private void scriviLog(Exception exc) {
        /*String sConfigFileName="log4j.xml";
        ClassLoader oLoader = getClass().getClassLoader();
        java.net.URL url = oLoader.getResource(sConfigFileName);
        DOMConfigurator.configure(url);
        Logger root = Logger.getLogger("localizzatore_rest");*/
        if (logger == null)
            initLogger();
        logger.fatal("Error di runtime", exc);
    }

    private void scriviLog(String messaggio) {
        /*String sConfigFileName="log4j.xml";
        ClassLoader oLoader = getClass().getClassLoader();
        java.net.URL url = oLoader.getResource(sConfigFileName);
        DOMConfigurator.configure(url);
        Logger root = Logger.getLogger("localizzatore_rest");*/
        if (logger == null)
            initLogger();
        logger.info(messaggio);
    }

    private void scriviLog(String messaggio, Exception e) {
        /*String sConfigFileName="log4j.xml";
        ClassLoader oLoader = getClass().getClassLoader();
        java.net.URL url = oLoader.getResource(sConfigFileName);
        DOMConfigurator.configure(url);
        Logger root = Logger.getLogger("localizzatore_rest");*/
        if (logger == null)
            initLogger();
        logger.fatal(messaggio, e);
    }

    private HashMap salvaTocArcgisServer(String idMap)
    {
        HashMap hmSimboli = new HashMap();
        try
        {
            String mapName = this.readDB("MAPNAME", idMap).toString();
            MapServerBindingStub mapServer = new MapServerBindingStub(this.readDB("CONNSTRING", idMap).toString());

            ImageType it = new ImageType();
            it.setImageFormat(EsriImageFormat.esriImageJPG);
            it.setImageReturnType(EsriImageReturnType.esriImageReturnURL);

            MapLayerInfo[] layerInfos = mapServer.getServerInfo(mapName).getMapLayerInfos();
            int numLayers = layerInfos.length;
            int[] laId = new int[numLayers];
            for (int i = 0; i < numLayers; i++)
            {
                Simbologia simbologia = null;
                MapLayerInfo layerInfo = layerInfos[i];
                if (layerInfo.getSubLayerIDs() != null)
                {
                    simbologia = new Simbologia();
                    simbologia.setIsGroupLayer(true);
                    hmSimboli.put(Integer.toString(layerInfo.getLayerID()), simbologia);
                }
                laId[i] = layerInfo.getLayerID();
            }
            MapServerLegendInfo[] legendInfos = mapServer.getLegendInfo(mapName, laId, null, it);
            for (int i = 0; i < legendInfos.length; i++)
            {
                Simbologia simbologia = new Simbologia();
                MapServerLegendInfo legendInfo = legendInfos[i];
                int layerId = legendInfo.getLayerID();
                MapServerLegendGroup[] legendsGroups = legendInfo.getLegendGroups();
                for (int k = 0; k < legendsGroups.length; k++)
                {
                    MapServerLegendGroup legendsGroup = legendsGroups[k];
                    String heading = legendsGroup.getHeading();
                    simbologia.setHeading(heading);
                    MapServerLegendClass[] legendClasses = legendsGroup.getLegendClasses();
                    Simbolo[] simboli = null;
                    if (legendClasses != null)
                    {
                        simboli = new Simbolo[legendClasses.length];
                        for (int j = 0; j < legendClasses.length; j++) {
                            simboli[j] = new Simbolo();
                            MapServerLegendClass legendClass = legendClasses[j];
                            String label = legendClass.getLabel();
                            ImageResult iR = legendClass.getSymbolImage();
                            String url = iR.getImageURL();
                            simboli[j].setDescrizione(label);
                            simboli[j].setUrlSymbol(url);
                        }
                    }
                    for (int z = 0; z < layerInfos.length; z++)
                    {
                        if (layerInfos[z].getLayerID() == layerId)
                        {
                            if (layerInfos[z].getParentLayerID() == -1)
                                simbologia.setParentLayerId(null);
                            else
                                simbologia.setParentLayerId(Integer.toString(layerInfos[z].getParentLayerID()));
                            break;
                        }
                    }
                    simbologia.setIsGroupLayer(false);
                    if (simboli != null)
                        simbologia.setSimboli(new ArrayOfSimbolo(simboli));
                    else
                        simbologia.setSimboli(null);
                    hmSimboli.put(Integer.toString(layerId), simbologia);
                }
            }
        }
        catch (Exception e)
        {
            scriviLog("Errore nel salvataggio delle immagini della TOC;\n", e);
        }
        return hmSimboli;
    }





    private boolean drawMarkerSDE(String markerLayer, String idCol,
                                  String geomCol,
                                  String idMarker, double x, double y, String idConn)
    {
        SeConnection conn = this.getSDEConn(idConn);
        SeInsert insert = null;
        try {
            SeLayer layerSDE = new SeLayer(conn, markerLayer,
                                           geomCol);

            SeTable table1 = null;
            table1 = new SeTable(conn, markerLayer);

            SeColumnDefinition[] tableDef = table1.describe();
            String[] cols = new String[2];
            //columns[] = {"XCOOR", "YCOOR", "ATTR1", "ATTR2", "SHAPE"};

            int geomIndex = -1;
            int colIdIndex = -1;
            int colIdType = -1;
            int temp = 0;
            for (int i = 0; i < tableDef.length; i++) {
                if (tableDef[i].getName().equalsIgnoreCase("objectid"))
                    continue;
                if (layerSDE.getSpatialColumn().matches(tableDef[i].getName())) {
                    geomIndex = i - 1;
                    cols[temp++] = geomCol;
                }
                if (tableDef[i].getName().matches(idCol)) {
                    colIdType = tableDef[i].getType();
                    colIdIndex = i - 1;
                    cols[temp++] = idCol;
                }
            }

            if (geomIndex == -1 || colIdIndex == -1) {
                scriviLog("Impossibile salvare l'incidente nel layer; " +
                          "colonna chiave o colonna geometria non trovate\n");
                return false;
            }

            if (table1 == null) {
                scriviLog("Impossibile salvare l'incidente nel layer; " +
                          "layer degli incidenti non trovato\n");
                return false;
            }

            insert = new SeInsert(conn);
            insert.intoTable(markerLayer, cols);
            insert.setWriteMode(true);
            SeRow row = insert.getRowToSet();

            SeCoordinateReference coordref = layerSDE.getCoordRef();

            SeShape point = null;
            point = new SeShape(coordref);
            SDEPoint[] ptArray = new SDEPoint[1];
            ptArray[0] = new SDEPoint(x, y);
            point.generatePoint(1, ptArray);

            // set the col values
            // MUST start from columns[0] as defined in the columns array before,
            // otherwise a CALL OUT OF SEQUENCE error will be thrown
            //row.set
            if (cols[0].equalsIgnoreCase(idCol)) {

                if (colIdType == 4)
                    row.setDouble(0, new Double(idMarker));
                else if (colIdType == 3)
                    row.setFloat(0, new Float(idMarker));
                else if (colIdType == 2)
                    row.setInteger(0, new Integer(idMarker));
                else if (colIdType == 11)
                    row.setLong(0, new Long(idMarker));
                else if (colIdType == 5)
                    row.setString(0, idMarker);
                else {
                    scriviLog("Impossibile salvare l'incidente nel layer; " +
                              "tipo della colonna chiave del layer dell' incidenti non valido\n");
                    return false;
                }
                row.setShape(1, point);
            } else {
                row.setShape(0, point);
                if (colIdType == 4)
                    row.setDouble(1, new Double(idMarker));
                else if (colIdType == 3)
                    row.setFloat(1, new Float(idMarker));
                else if (colIdType == 2)
                    row.setInteger(1, new Integer(idMarker));
                else if (colIdType == 11)
                    row.setLong(1, new Long(idMarker));
                else if (colIdType == 5)
                    row.setString(1, idMarker);
                else {
                    scriviLog("Impossibile salvare l'incidente nel layer; " +
                              "tipo della colonna chiave del layer dell' incidenti non valido\n");
                    conn.close();
                    return false;
                }
            }

            // insert row
            insert.execute();
            insert.flushBufferedWrites();

            insert.close();
            conn.close();
            return true;

        } catch (SeException seExc) {
            SeError seErr = seExc.getSeError();
            String errDesc = seErr.getErrDesc();
            String errExt = seErr.getExtErrMsg();
            String errStd = seErr.getSdeErrMsg();
            seErr.getSdeError();
            scriviLog("Impossibile salvare il marker nel layer; " + errDesc + ":"+ errExt + "\n");
            try {
                if (insert != null)
                    insert.close();
            } catch (Exception e2) {}
            return false;
        }
        catch (Exception e) {
            scriviLog("Impossibile salvare il marker nel layer;\n" +
                      e.getMessage());
            try {
                if (insert != null)
                    insert.close();
            } catch (Exception e2) {}
            return false;
        }

    }

    private boolean eraseMarkerSDE(String markerLayer,
                                      String where, String idConn)
    {
        SeConnection conn = this.getSDEConn(idConn);
        SeDelete del = null;
        try {
            del = new SeDelete(conn);

            del.fromTable(markerLayer, where);
            conn.commitTransaction();

            del.close();
            conn.close();
            return true;

        } catch (SeException seExc) {
            SeError seErr = seExc.getSeError();
            String errDesc = seErr.getErrDesc();
            String errExt = seErr.getExtErrMsg();
            String errStd = seErr.getSdeErrMsg();
            seErr.getSdeError();
            scriviLog("Impossibile eliminare i marker dal layer; " + errDesc + ":"+ errExt + "\n");
            try {
                if (del != null)
                    del.close();
            } catch (Exception e2) {}
            return false;
        } catch (Exception e) {
            scriviLog("Impossibile eliminare i marker dal layer;\n" +
                        e.getMessage());
            try {
                if (del != null)
                    del.close();
            } catch (Exception e2) {}

            return false;
        }
    }

    /**
     * Metodo utilizzato dall'applicativo InciWeb per l'inserimento della
     * geometria di un incidente all'interno del layer SDE apposito.
     * @param incidentiLayer String Nome del layer SDE contenente le geometrie degli incidenti.
     * @param incidentiIdCol String Nome della colonna degli identificatori
     * degli incidenti all'interno del layer SDE apposito.
     * @param incidentiGeomCol String Nome della colonna contenente le geometrie degli incidenti.
     * @param incidenteId String Valore dell'identificare dell'incedente da inserire.
     * @param x double Coordinata x dell'incidente.
     * @param y double Coordinata y dell'incidente.
     * @param idConn String Identificativo di connessione a SDE.
     * @return boolean true se l'operazione � andata a buon fine, false altrimenti.
     */
    @Path("/inserisciIncidente")
	@GET
	@Produces({"application/javascript"})
    public boolean inserisciIncidente(@QueryParam("incidentiLayer") String incidentiLayer,
                                      @QueryParam("incidentiIdCol") String incidentiIdCol,
                                      @QueryParam("incidentiGeomCol") String incidentiGeomCol,
                                      @QueryParam("incidenteId") String incidenteId,
                                      @QueryParam("x") double x,
                                      @QueryParam("y") double y,
                                      @QueryParam("idConn") String idConn)
    {
        scriviLog("Invocata inserisciIncidente(" + incidentiLayer + "," + incidentiIdCol + "," + incidentiGeomCol + "," + incidenteId + "," + x + "," + y + "," + idConn + ")");
        SeConnection conn = this.getSDEConn(idConn);
        try {
            SeLayer layerSDE = new SeLayer(conn, incidentiLayer, incidentiGeomCol);

            SeTable table1 = null;
            table1 = new SeTable(conn, incidentiLayer);

            SeColumnDefinition[] tableDef = table1.describe();
            String[] cols = new String[2];
            //columns[] = {"XCOOR", "YCOOR", "ATTR1", "ATTR2", "SHAPE"};

            int geomIndex = -1;
            int colIdIndex = -1;
            int colIdType = -1;
            int temp = 0;
            for (int i = 0; i < tableDef.length; i++) {
                if (tableDef[i].getName().equalsIgnoreCase("objectid"))
                    continue;
                if (layerSDE.getSpatialColumn().matches(tableDef[i].getName())) {
                    geomIndex = i;
                    cols[temp++] = incidentiGeomCol;
                }
                if (tableDef[i].getName().matches(incidentiIdCol)) {
                    colIdType = tableDef[i].getType();
                    colIdIndex = i;
                    cols[temp++] = incidentiIdCol;
                }
            }

            if (geomIndex == -1 || colIdIndex == -1) {
                scriviLog("Impossibile salvare l'incidente nel layer; " +
                        "colonna chiave o colonna geometria non trovate\n");
                return false;
            }

            if (table1 == null) {
                scriviLog("Impossibile salvare l'incidente nel layer; " +
                        "layer degli incidenti non trovato\n");
                return false;
            }

            SeInsert insert = new SeInsert(conn);
            insert.intoTable(incidentiLayer,cols);
            insert.setWriteMode(true);
            SeRow row = insert.getRowToSet();

            SeCoordinateReference coordref = layerSDE.getCoordRef();

            SeShape point = null;
            point = new SeShape(coordref);
            SDEPoint[] ptArray = new SDEPoint[1];
            ptArray[0] = new SDEPoint(x, y);
            point.generatePoint(1, ptArray);

            // set the col values
            // MUST start from columns[0] as defined in the columns array before,
            // otherwise a CALL OUT OF SEQUENCE error will be thrown
            //row.set
            if (cols[0].equalsIgnoreCase(incidentiIdCol))
            {

                if (colIdType == 4)
                    row.setDouble(0, new Double(incidenteId));
                else if (colIdType == 3)
                    row.setFloat(0, new Float(incidenteId));
                else if (colIdType == 2)
                    row.setInteger(0, new Integer(incidenteId));
                else if (colIdType == 11)
                    row.setLong(0, new Long(incidenteId));
                else if (colIdType == 5)
                    row.setString(0, incidenteId);
                else {
                    scriviLog("Impossibile salvare l'incidente nel layer; " +
                              "tipo della colonna chiave del layer dell' incidenti non valido\n");
                    return false;
                }
                row.setShape(1, point);
            }
            else
            {
                row.setShape(0, point);
                if (colIdType == 4)
                    row.setDouble(1, new Double(incidenteId));
                else if (colIdType == 3)
                    row.setFloat(1, new Float(incidenteId));
                else if (colIdType == 2)
                    row.setInteger(1, new Integer(incidenteId));
                else if (colIdType == 11)
                    row.setLong(1, new Long(incidenteId));
                else if (colIdType == 5)
                    row.setString(1, incidenteId);
                else {
                    scriviLog("Impossibile salvare l'incidente nel layer; " +
                              "tipo della colonna chiave del layer dell' incidenti non valido\n");
                    return false;
                }
            }


            // insert row
            insert.execute();
            insert.flushBufferedWrites();
            conn.close();
            return true;

        } catch (Exception e) {
            scriviLog("Impossibile salvare l'incidente nel layer;\n" +
                        e.getMessage());
            return false;
        }
    }

    /**
     * Metodo utilizzato dall'applicativo InciWeb per la cancellazione di un incidente
     * dal layer SDE apposito.
     * @param incidentiLayer String Nome del layer SDE contenente le geometrie degli incidenti.
     * @param where String Condizione di ricerca degli incidenti da cancellare.
     * @param idConn String Identificativo di connessione a SDE.
     * @return boolean true se l'operazione � andata a buon fine, false altrimenti.
     */

    @Path("/cancellaIncidente")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
    public boolean cancellaIncidente(@QueryParam("incidentiLayer") String incidentiLayer,
                                     @QueryParam("where") String where,
                                     @QueryParam("idConn") String idConn)
    {
        scriviLog("Invocata cancellaIncidente(" + incidentiLayer + "," + where + "," + idConn + ")");
        SeConnection conn = this.getSDEConn(idConn);
        try {
            SeDelete del = new SeDelete(conn);

            del.fromTable(incidentiLayer, where);
            conn.commitTransaction();
            del.close();
            conn.close();
            return true;

        } catch (Exception e) {
            scriviLog("Impossibile eliminare l'incidente dal layer;\n" +
                        e.getMessage());
            return false;
        }
    }


    /**
     * Metodo utilizzato dall'applicativo InciWeb per ricavare le coordinate
     * di un incrocio.
     * @param tabellaIncroci String Nome della tabella degli incroci.
     * @param incrociIdCol String Nome della colonna degli identificatori dei nodi degli incroci.
     * @param incrociGeomCol String Nome della colonna delle geometrie dei nodi degli incroci.
     * @param where String Condizione di ricerca dell'incrocio.
     * @param idConn Identificativo di connessione a SDE.
     * @return {@link Coord} dell'incrocio ricavato dalla query.
     */

    private Coord getCoordIncrocio(@QueryParam("tabellaIncroci") String tabellaIncroci,
                                  @QueryParam("incrociIdCol") String incrociIdCol,
                                  @QueryParam("incrociGeomCol")String incrociGeomCol,
                                  @QueryParam("where") String where,
                                  @QueryParam("idConn") String idConn)
    {
        SeConnection conn = this.getSDEConn(idConn);
        try {
            SeLayer layerSDE = new SeLayer(conn, tabellaIncroci, incrociGeomCol);

            SeTable table1 = null;
            table1 = new SeTable(conn, tabellaIncroci);

            SeColumnDefinition[] tableDef = table1.describe();

            String[] cols = new String[tableDef.length];

            int geomIndex = -1;
            int colIdIndex = -1;

            for (int i = 0; i < tableDef.length; i++) {
                cols[i] = tableDef[i].getName();
                if (layerSDE.getSpatialColumn().matches(tableDef[i].getName())) {
                    geomIndex = i;
                }
                if (tableDef[i].getName().matches(incrociIdCol)) {
                    colIdIndex = i;
                }
            }


            if (geomIndex == -1 || colIdIndex == -1) {
                scriviLog("Impossibile ricavare le coordinate dell'incrocio; " +
                        "colonna chiave o colonna geometria non trovate\n");
                return null;
            }

            if (table1 == null) {
                scriviLog("Impossibile ricavare le coordinate dell'incrocio; " +
                        "layer degli incroci non trovato\n");
                return null;
            }

            SeQuery query = null;
            boolean queryOk = false;
            try {
                SeSqlConstruct sqlConstruct = new SeSqlConstruct(table1.
                        getQualifiedName());

                sqlConstruct.setWhere(where);

                query = new SeQuery(conn, cols, sqlConstruct);

                query.prepareQuery();
                query.execute();
                queryOk = true;

            } catch (Exception ee) {
                scriviLog("Impossibile ricavare le coordinate dell'incrocio;\n" +
                        ee.getMessage());
                return null;
            }

            if (!queryOk)
                return null;

            SeRow row = query.fetch();
            Coord coord = null;
            while (row != null) {
                SeShape shp = row.getShape(geomIndex);
                ArrayList list = shp.getPoints(SeShape.TURN_DEFAULT, 1);
                SDEPoint[] pointsPerPart = (SDEPoint[]) list.get(0);
                SDEPoint point = pointsPerPart[0];
                coord = new Coord();
                coord.setX(point.getX());
                coord.setY(point.getY());
                row = query.fetch();
            }
            query.close();
            conn.close();
            return coord;
        } catch (Exception e) {
            scriviLog("Impossibile ricavare le coordinate dell'incrocio;\n" +
                        e.getMessage());
            return null;
        }
    }
    
    /**
     * Setta un'entry nella hash map per associare all'Id di una connessione, il roadLayer e
     * la colonna degli identificativi.
     * @param idConn String connID associato alla connessione Oracle.
     * @param Connection Object Connection associata alla connID.
     * @param roadLayer String roadLayer associato alla connessione.
     * @param idCol String idCol associato alla connessione.
     */
    public static void setConnection(String idConn, Object Connection, String roadLayer,
                                     String geometryCol, String idCol) {
        hm.put(idConn, Connection);
        conn_RoadLayer.put(idConn, roadLayer);
        conn_GeometryCol.put(idConn, geometryCol);
        conn_IdCol.put(idConn,idCol);
    }
    
    /**
     * Restituisce la Connection associata alla idConn.
     * @param idConn String ID associato alla connessione.
     * @return Object La Connection associata alla connID.
     */
    public static Object getConnection (String idConn) {
        return hm.get(idConn);
    }
}

