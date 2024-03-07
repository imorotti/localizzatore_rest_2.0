package com.siteco.JRs40DynSeg;

/*
 * SHPArco.java
 *
 * Created on 14 febbraio 2006, 15.43
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

/**
 *
 * @author vanna
 */
public class SHPArco {
    
    /** Creates a new instance of SHPArco */
    public SHPArco() {
        centro = new SHPPoint();
    }
    /// <summary>
    /// centro arco
    /// </summary>
    public SHPPoint centro;
    /// <summary>
    /// raggio arco
    /// </summary>
    public double raggio;
    /// <summary>
    /// angolo iniziale
    /// </summary>
    public double angi;
    /// <summary>
    /// angolo finale
    /// </summary>
    public double angf;
    /// <summary>
    /// calcola l'arco per tre punti
    /// </summary>
    public boolean SHPArc3pnt(SHPPoint p1, SHPPoint p2, SHPPoint p3)
    {
        SHPCirc c = new SHPCirc();
        double angp3,ang;
        SHPPoint perno;

        if (!c.SHPCir3pnt(p1,p2,p3))  return false;
        this.centro = perno = c.centro;
        this.raggio = c.raggio;
        this.angi = perno.SHPangx(p1);
        this.angf = perno.SHPangx(p2);
        angp3 = perno.SHPangx(p3);
        if (!SHPPtinang(angp3, angi, angf)) 
        {
            ang = this.angi;
            this.angi = this.angf;
            this.angf = ang;
        }
        return true;
    }
    /// <summary>
    /// verifica se l'angolo alfa dato e' compreso fra due dati beta1 e beta2
    /// </summary>
    public boolean SHPPtinang(double alfa, double beta1, double beta2)
    {
        boolean inang;
        double alfa1;

        alfa1 = alfa - MConst.TOLANG;
        if (alfa1 < 0.0)
            alfa1 += MConst.DUEPIGRECO;
        if (beta1 < beta2)
            inang = (alfa1 > beta1) && (alfa1 < beta2);
        else
            inang = (alfa1 >= beta1) || (alfa1 < beta2);
        if (inang || (MConst.TOLANG == 0.0))
            return inang;

        alfa1 = alfa + MConst.TOLANG;
        if (alfa1 > MConst.DUEPIGRECO)
            alfa1 -= MConst.DUEPIGRECO;
        if (beta1 < beta2)
            inang = alfa1 > beta1 && alfa1 < beta2;
        else
            inang = alfa1 >= beta1 || alfa1 < beta2;
        return inang;
    }

}
