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


public class Localizzazione {
    private double x;
    private double y;
    private double m;
    private String road_id1;
    private String road_id2;
    private String n_civico;
    private int tipoLocalizzazione;
    private String esito;
    private boolean riuscita;

    //metodi per settare le variabili
    public void setX(double x)
    {
        this.x = x;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public void setM(double m)
    {
        this.m = m;
    }

    public void setRoad_id1(String road_id1)
    {
        this.road_id1 = road_id1;
    }

    public void setRoad_id2(String road_id2)
    {
        this.road_id2 = road_id2;
    }

    public void setN_civico(String n_civico)
    {
        this.n_civico = n_civico;
    }

    public void setTipoLocalizzazione(int tipoLocalizzazione)
    {
        this.tipoLocalizzazione = tipoLocalizzazione;
    }

    public void setEsito(String esito)
    {
        this.esito = esito;
    }

    public void setRiuscita(boolean riuscita)
    {
        this.riuscita = riuscita;
    }


    //metodi che restituiscono i valori delle variabili
    public double getX()
    {
        return this.x;
    }

    public double getY()
    {
        return this.y;
    }

    public double getM()
    {
        return this.m;
    }

    public String getRoad_id1()
    {
        return this.road_id1;
    }

    public String getRoad_id2()
    {
        return this.road_id2;
    }

    public String getN_civico()
    {
        return this.n_civico;
    }

    public int getTipoLocalizzazione()
    {
        return this.tipoLocalizzazione;
    }

    public String getEsito()
    {
        return this.esito;
    }

    public boolean getRiuscita()
    {
        return this.riuscita;
    }
}
