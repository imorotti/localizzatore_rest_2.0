package com.siteco.classes;

import java.sql.*;

/**
 *
 * <p>Classe che identifica una Percorso, inteso come una geometria associata a
 * una Strada/p>
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

public class Percorso {
    private String sigla = "";
    private String denominazione = "";
    private String st_nome = "";
    private String road_id = "";
    private String roadg_id = "";
    private double prg_ini = 0.0;
    private double prg_fin = 0.0;

    public Percorso() {
    }

    /**
     * Ritorna la sigla del percorso.
     * @return String la sigla del percorso.
     */
    public String getSigla ()
    {
        return this.sigla;
    }

    /**
     * Setta la sigla del percorso.
     * @param sigla String la sigla del percorso.
     */
    public void setSigla (String sigla)
    {
        this.sigla = sigla;
    }

    /**
     * Ritorna la denominazione del percorso.
     * @return String la denominazione del percorso.
     */
    public String getDenominazione ()
    {
        return this.denominazione;
    }

    /**
     * Setta la denominazione del percorso.
     * @param denominazione String la denominazione del percorso.
     */
    public void setDenominazione (String denominazione)
    {
        this.denominazione = denominazione;
    }

    /**
     * Ritorna il nome della strada a cui � associato il percorso.
     * @return String il nome della strada a cui � associato il percorso.
     */
    public String getNome ()
    {
        return this.st_nome;
    }

    /**
     * Setta il nome della strada a cui � associato il percorso.
     * @param nome String il nome della strada a cui � associato il percorso.
     */
    public void setNome (String nome)
    {
        this.st_nome = nome;
    }

    /**
     * Ritorna il road_id del percorso.
     * @return String il road_id del percorso.
     */
    public String getRoad_Id ()
    {
        return this.road_id;
    }

    /**
     * Setta il road_id del percorso.
     * @param road_id String il road_id del percorso.
     */
    public void setRoad_Id (String road_id)
    {
        this.road_id = road_id;
    }

    /**
     * Ritorna il roadg_id del percorso.
     * @return String il roadg_id del percorso.
     */
    public String getRoadg_Id ()
    {
        return this.roadg_id;
    }

    /**
     * Setta il roadg_id del percorso.
     * @param roadg_id String il roadg_id del percorso.
     */
    public void setRoadg_Id (String roadg_id)
    {
        this.roadg_id = roadg_id;
    }

    /**
     * Ritorna la progressiva iniziale del percorso.
     * @return double la progressiva iniziale del percorso.
     */
    public double getPrg_Ini ()
    {
        return this.prg_ini;
    }

    /**
     * Setta la progressiva iniziale del percorso.
     * @param prg_ini double la progressiva iniziale del percorso.
     */
    public void setPrg_Ini (double prg_ini)
    {
        this.prg_ini = prg_ini;
    }

    /**
     * Ritorna la progressiva finale del percorso.
     * @return double la progressiva finale del percorso.
     */
    public double getPrg_Fin ()
    {
        return this.prg_fin;
    }

    /**
     * Setta la progressiva finale del percorso.
     * @param prg_fin double la progressiva finale del percorso.
     */
    public void setPrg_Fin (double prg_fin)
    {
        this.prg_fin = prg_fin;
    }
}
