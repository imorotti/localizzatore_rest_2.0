/*
 * raggi_parametri.java
 *
 * Created on 17 marzo 2006, 16.01
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.siteco.JRs40DynSeg;

/**
 *
 * @author vanna
 */
public class raggi_parametri {
    
    /** Creates a new instance of raggi_parametri */
    public raggi_parametri() {
	percorso = -1;
	road_id = null;
	liv_comp = 1;
    }
    public String road_id;
    public double rag;
    public double rag_toll;
    public double ang;
    public double per_rag_eli;
    public boolean archi_sing;
    public boolean elim_rar;
    public int percorso;
    public int liv_comp;

}
