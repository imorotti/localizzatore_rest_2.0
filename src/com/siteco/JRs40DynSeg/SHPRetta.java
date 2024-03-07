package com.siteco.JRs40DynSeg;

/*
 * SHPRetta.java
 *
 * Created on 9 febbraio 2006, 19.49
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

/**
 *
 * @author vanna
 */
public class SHPRetta {

    public double c;
    public double b;
    public double a;
    /** Creates a new instance of SHPRetta */
    public SHPRetta() {
    }
/// <summary>
/// Costruttore della retta
/// </summary>
/// <param name="pnt1"></param>
/// <param name="pnt2"></param>
    public SHPRetta(SHPPoint pnt1, SHPPoint pnt2)
    {
        SHPret2pt(pnt1,pnt2);
    }
/// <summary>
/// Calcola la retta per due punti
/// </summary>
/// <param name="p1"></param>
/// <param name="p2"></param>
    public void SHPret2pt(SHPPoint p1, SHPPoint p2)
    {
        double          denom;
        a = p2.y - p1.y;
        b = p1.x - p2.x;
        c = 0.0;
        //
        //  Normalizza
        //
        denom = Math.sqrt(a * a + b * b);
        if (denom == 0.0) return;
        a = a / denom;
        b = b / denom;
        c = -p1.x * a - p1.y * b;
    }

/// <summary>
/// Calcola la distanza (con segno) tra un punto e una retta
/// </summary>
/// <param name="pt"></param>
/// <returns></returns>
    public double SHPdptr(SHPPoint pt)
    {
        double          dd;
        if ((dd = Math.sqrt(a * a + b * b)) == 0.0)	return 0.0;
        return ((a * pt.x + b * pt.y + c) / dd);
    }
/// <summary>
/// Normalizza l'equazione di una retta
/// </summary>
    public void SHPretnor()
    {
        double denom;

        denom = Math.sqrt(a * a + b * b);
        if (denom == 0.0)  denom = 1.0;
        a /= denom;
        b /= denom;
        c /= denom;
    }
/// <summary>
/// Trasla la retta corrente a se' stessa a distanza delta con verso concorde al punto dato
/// </summary>
/// <param name="ret"></param> VVVV era passato ref ret
/// <param name="pt"></param>
/// <param name="delta"></param>
    public void SHPtrsr(SHPRetta ret, SHPPoint pt, double delta)
    {
    //
    // Trasla la retta corrente // a se' stessa a distanza delta con verso
    // concorde al punto dato
    //
        ret.a = a;
        ret.b = b;
        if (SHPdptr(pt) > 0.0)  delta = -delta;
        ret.c = c + delta;
    }
/// <summary>
/// retta normale
/// </summary>
/// <param name="pt"> punto di passaggio</param>
/// <param name="r">retta risultante </param> VVVV era passato ref r
    public void SHPrnp(SHPPoint pt, SHPRetta r)
    {
        r.a = b;
        r.b = -a;
        r.c = -r.a * pt.x - r.b * pt.y;
    }
/// <summary>
/// Calcola la distanza (con segno) tra un punto e una retta
/// </summary>
/// <param name="pt"></param>
/// <returns></returns>
    public double SHPdptrr(SHPPoint pt)
    {
        double          dd;
        if ((dd = Math.sqrt(a * a + b * b)) == 0.0)	return 0.0;
        return ((a * pt.x + b * pt.y + c) / dd);
    }
/// <summary>
/// Calcola l'intersezione tra due rette
/// </summary>
/// <param name="r2"></param>
/// <param name="pt"></param> VV era ref pt
/// <returns></returns>
    public int SHPi2r(SHPRetta r2, SHPPoint pt)
    {
        double dd;
        //
        //  Verifica se le rette sono parallele
        //
        SHPretnor();
        r2.SHPretnor();
        dd = a * r2.b - b * r2.a;
        if (Math.abs(dd) < MConst.MRAD)  return 0;
        pt.x = -(c * r2.b - r2.c * b) / dd;
        pt.y = -(a * r2.c - r2.a * c) / dd;
        return 1;
    }
/// <summary>
/// Calcola l'intersezione segmento retta
/// </summary>
/// <param name="seg"></param>
/// <param name="pt"></param> VV era ref pt
/// <param name="t"></param> VV era ref t
/// <returns></returns>
    public double SHPisr(SHPSegm seg, SHPPoint pt, double t)
    {
        double dx,dy,den,dd;
        SHPRetta ret1 = new SHPRetta();

        dx = seg.p2.x - seg.p1.x;
        ret1.b = -dx;
        ret1.a = dy = seg.p2.y - seg.p1.y;
        den = Math.sqrt(ret1.a * ret1.a + ret1.b * ret1.b);
        if (den  <= 0.0) return 0;

        ret1.a /= den;
        ret1.b /= den;
        ret1.c = -seg.p1.x * ret1.a - seg.p1.y * ret1.b;
        //
        //  Interseca le due rette
        //
        dd = ret1.a * b - ret1.b * a;
        if (Math.abs(dd) < MConst.MRAD)  return 0;

        pt.x = -(ret1.c * b - ret1.b * c) / dd;
        pt.y = -(ret1.a * c - ret1.c * a) / dd;
        if (Math.abs(dx) > Math.abs(dy))
            t = (pt.x - seg.p1.x) / dx;
        else
            t = (pt.y - seg.p1.y) / dy;
        return t;
    }
/// <summary>
/// Calcola la retta dato un punto di passaggio e l'angolo di inclinazione
/// </summary>
/// <param name="pt">punto di passaggio</param>
/// <param name="alfa">angolo</param>
    public void SHPrptang(SHPPoint pt, double alfa)
    {
        SHPPoint pt2 = new SHPPoint();

        pt2.x = pt.x + Math.cos(alfa);
        pt2.y = pt.y + Math.sin(alfa);
        this.SHPret2pt(pt,pt2);
    }

}
