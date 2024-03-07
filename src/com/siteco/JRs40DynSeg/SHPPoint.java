package com.siteco.JRs40DynSeg;
/*
 * SHPPoint.java
 *
 * Created on 9 febbraio 2006, 15.44
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

import java.lang.*;
import java.math.*;

/**
 *
 * @author vanna
 */
public class SHPPoint {
    
    public double y;
/// <summary>
/// 
/// </summary>
    public double x;
/// <summary>
/// 
/// </summary>
    public double m;
/// <summary>
/// 
/// </summary>
    public double z;
/// <summary>
/// Costruttori
/// </summary>
    public SHPPoint()
    {
        x = 0.0;
        y = 0.0;
        m = 0.0;
        z = 0.0;
    }
    public SHPPoint(SHPPoint pt)
    {
        x = pt.x;
        y = pt.y;
        m = pt.m;
        z = pt.z;
    }
    public SHPPoint(double x1, double  y1) 
    {
        x = x1;
        y = y1;
        m = 0.0;
        z = 0.0;
    }
    public SHPPoint(double x1, double  y1, double m1) 
    {
        x = x1;
        y = y1;
        m = m1;
        z = 0.0;
    }
    public SHPPoint(double x1, double  y1, double m1, double z1) 
    {
        x = x1;
        y = y1;
        m = m1;
        z = z1;
    }
/// <summary>
/// Verifica se il puntor corrente e' coincidente con pt2
/// a meno di una certa tolleranza 
/// </summary>
/// <param name="pt2">secondo punto</param>
/// <returns></returns>
    public boolean SHPpteq(SHPPoint pt2)
    {
        return (java.lang.Math.abs((pt2.x - this.x) + java.lang.Math.abs(pt2.y - this.y)) < MConst.TOLL);
    }
/// <summary>
/// Calcola l'offset di un punto pt su un segmento
/// </summary>
/// <param name="pt">punto sul segmento</param>
/// <param name="seg">segmento su cui giace pt</param>
/// <param name="offset">valore di offset</param>
/// <returns></returns>
    public SHPPoint SHPoffsetpnt(SHPPoint pt, SHPSegm seg, double offset)
    {
        SHPPoint ptoff = new SHPPoint(pt);
        double ang = seg.p1.SHPangx(seg.p2) + MConst.PIMEZZI;
        double cosa = Math.cos(ang);
        double sina = Math.sin(ang);
        offset = -offset; // Ho messo -offset perche' cosi mi da positivo l'offset che sta a destre del senso di percorrenza. MM 14/10/2005
        ptoff.x = pt.x + offset * cosa;
        ptoff.y = pt.y + offset * sina;

        return ptoff;
    }
/// <summary>
/// Calcola l'angolo [0:2PI] formato dal segmento corrente-p2 con l'asse X 
/// </summary>
/// <param name="p2"></param>
/// <returns></returns>
    public double SHPangx(SHPPoint p2)
    {
        double          dx, dy, ang;
        dx = p2.x - x;
        dy = p2.y - y;
        if ((Math.abs(dx) + Math.abs(dy)) < MConst.TOLL) return 0.0;
        ang = Math.atan2(dy, dx);
        return ((ang >= 0.0) ? ang : ang + MConst.DUEPIGRECO);
    }
/// <summary>
/// Calcola la distanza del punto da una retta
/// </summary>
/// <param name="ret"></param>
/// <returns></returns>
    public double SHPdptr(SHPRetta ret)
    {
        return ret.SHPdptr(this);
    }
/// <summary>
/// Calcola la distanza tra due punti
/// </summary>
/// <param name="pt"></param>
/// <returns></returns>
    public double SHPdstpt(SHPPoint pt)
    {
        double          dx,dy;
        dx = x - pt.x;
        dy = y - pt.y;
        return (Math.sqrt(dx * dx + dy * dy));
    }
/// <summary>
/// Calcola la distanza di un punto dal punto corrente.
/// </summary>
/// <param name="pt"></param>
/// <returns></returns>
public double SHPdstptpr(SHPPoint pt)
{
	SHPPoint pt1 = new SHPPoint();
	pt1.x = this.x;
	pt1.y = this.y;
	pt1.z = this.z;
	pt1.m = this.m;
	return pt.SHPdstpt(pt1);
    }

/// <summary>
/// Applica al punto la trasformazione inversa data (trasla + ruota)
/// </summary>
/// <param name="cosa">coseno ang di rotazione</param>
/// <param name="sena">sin angolo di rotazione</param>
/// <param name="tx">traslazione x</param>
/// <param name="ty">traslazione y</param>
    public void SHPinvtraruo(double cosa, double sena, double tx, double ty)
    {
        double  dx = x - tx,dy = y - ty;
        x = dx * cosa + dy * sena;
        y = dy * cosa - dx * sena;
    }
/// <summary>
/// Applica al punto la trasformazione data (trasla + ruota)
/// </summary>
/// <param name="cosa"></param>
/// <param name="sena"></param>
/// <param name="tx"></param>
/// <param name="ty"></param>
    public void SHPtraruo(double cosa, double sena, double tx, double ty) 
    {
        double  dx = x + tx, dy = y + ty;
        x = dx * cosa - dy * sena;
        y = dy * cosa + dx * sena;
    }
/// <summary>
/// Applica al punto la trasformazione data (ruota + trasla)
/// </summary>
/// <param name="cosa"></param>
/// <param name="sena"></param>
/// <param name="tx"></param>
/// <param name="ty"></param>
    public void SHPruotra(double cosa, double sena, double tx, double ty)
    {
        double  dx = x,	dy = y;
        x = dx * cosa - dy * sena + tx;
        y = dy * cosa + dx * sena + ty;
    }

}
