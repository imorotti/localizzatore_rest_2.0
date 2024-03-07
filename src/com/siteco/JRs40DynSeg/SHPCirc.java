package com.siteco.JRs40DynSeg;
/*
 * SHPCirc.java
 *
 * Created on 10 febbraio 2006, 17.24
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */
import com.siteco.JRsOpMat.*;
/**
 *
 * @author vanna
 */
    public class SHPCirc {
     /// <summary>
    /// centro circonferenza
    /// </summary>
    public SHPPoint centro;
    /// <summary>
    /// raggio circonferenza
    /// </summary>
    public double raggio;

    /** Creates a new instance of SHPCirc */
    public SHPCirc() {
        centro = new SHPPoint();
    }
/// <summary>
/// Calcola la circonferenza per 3 punti
/// </summary>
    public boolean SHPCir3pnt(SHPPoint pp1, SHPPoint pp2, SHPPoint pp3)
    {
        M3 a = new M3();
        V3 b = new V3();
        V3 x = new V3();
        double delta;
        SHPPoint p1 = new SHPPoint();
        SHPPoint p2 = new SHPPoint();
        SHPPoint p3 = new SHPPoint();
        //
        //  Trasla il primo punto nell'origine per maggiore stabilita'
        //
        p1.x = p1.y = 0.0;
        p2.x = pp2.x - pp1.x;
        p2.y = pp2.y - pp1.y;
        p3.x = pp3.x - pp1.x;
        p3.y = pp3.y - pp1.y;

        a.m00 = p1.x;
        a.m10 = p2.x;
        a.m20 = p3.x;
        a.m01 = p1.y;
        a.m11 = p2.y;
        a.m21 = p3.y;
        a.m02 = 1.0;
        a.m12 = 1.0;
        a.m22 = 1.0;
        b.v0 = -(a.m00 * a.m00 + a.m01 * a.m01);
        b.v1 = -(a.m10 * a.m10 + a.m11 * a.m11);
        b.v2 = -(a.m20 * a.m20 + a.m21 * a.m21);
        if (!a.RisLin3(b, x)) return false;
        this.centro.x = -x.v0 / 2.0 + pp1.x;
        this.centro.y = -x.v1 / 2.0 + pp1.y;
        delta = x.v0 * x.v0 + x.v1 * x.v1 - 4.0 * x.v2;
        if (delta < 0.0) return false;
        this.raggio = Math.sqrt(delta) / 2.0;
        return true;
    }

}
