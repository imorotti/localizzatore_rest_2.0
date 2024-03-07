package com.siteco.JRs40DynSeg;

/*
 * SHPSegm.java
 *
 * Created on 9 febbraio 2006, 19.11
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

/**
 *
 * @author vanna
 */
public class SHPSegm {
    public SHPPoint p1;
    public SHPPoint p2;

    /** Creates a new instance of SHPSegm */
    public SHPSegm()
    {
        p1 = new SHPPoint();
        p2 = new SHPPoint();
    }
    public SHPSegm(double x1,double y1,double x2,double y2)
    {
        p1 = new SHPPoint();
        p2 = new SHPPoint();
        p1.x = x1;
        p1.y = y1;
        p2.x = x2;
        p2.y = y2;
        p1.m = p2.m = 0.0;
        p1.z = p2.z = 0.0;
    }
    public SHPSegm(double x1,double y1,double m1,double x2,double y2,double m2)
    {
        p1 = new SHPPoint();
        p2 = new SHPPoint();
        p1.x = x1;
        p1.y = y1;
        p2.x = x2;
        p2.y = y2;
        p1.m = m1;
        p2.m = m2;
        p1.z = p2.z = 0.0;
    }
    public SHPSegm(double x1,double y1,double m1,double z1,double x2,double y2,double m2,double z2)
    {
        p1 = new SHPPoint();
        p2 = new SHPPoint();
        p1.x = x1;
        p1.y = y1;
        p2.x = x2;
        p2.y = y2;
        p1.m = m1;
        p2.m = m2;
        p1.z = z1;
        p2.z = z2;
    }
    public SHPSegm(SHPPoint pt1,SHPPoint pt2)
    {
        p1 = new SHPPoint();
        p2 = new SHPPoint();
        p1.x = pt1.x;
        p1.y = pt1.y;
        p2.x = pt2.x;
        p2.y = pt2.y;
        p1.m = pt1.m;
        p2.m = pt2.m;
        p1.z = pt1.z;
        p2.z = pt2.z;
    }
/// <summary>
/// Calcola il punto sul segmento e l'angolo di inclinazione dello stesso, dato il parametro t [0:1]
/// </summary>
/// <param name="tval"></param>
/// <param name="precs"></param>
/// <param name="pnt"></param> VV era ref
/// <param name="angr"></param> VV era ref
/// <returns></returns>
    public double SHPcalpnt(double tval, double precs, SHPPoint pnt, double angr)
    {
        double	ang;

        if(pnt == null) return Double.NaN;
        ang = p1.SHPangx(p2);
        pnt.x = p1.x + Math.cos(ang) * tval;
        pnt.y = p1.y + Math.sin(ang) * tval;
        angr = ang;
        return angr;
    }
/// <summary>
/// Calcola la lunghezza del segmento
/// </summary>
/// <returns></returns>
    public double SHPprlun()
    {
        double	dxt,dyt,lun;

        dxt = p2.x - p1.x;
        dyt = p2.y - p1.y;
        lun = Math.sqrt(dxt * dxt + dyt *dyt);
        return lun;
    }
/// <summary>
/// Calcola l'intersezione segmento retta
/// </summary>
/// <param name="ret"></param>
/// <param name="pt"></param> VV era ref
/// <param name="t"></param> VV era ref
/// <returns></returns>
    public double SHPisr(SHPRetta ret, SHPPoint pt, double t)
    {
        return ret.SHPisr(this, pt, t);
    }
/// <summary>
/// Calcola il segmento offsettato
/// </summary>
/// <param name="offset"></param>
/// <returns></returns>
    public boolean SHPOffsetP(double offset)
    {
        double	cosa,sena,tx,ty,ang1;
        SHPPoint	pnt2 = new SHPPoint(),pnt3 = new SHPPoint();
        ang1 = p1.SHPangx(p2);

        tx = p1.x;
        ty = p1.y;
        cosa = Math.cos(ang1);
        sena = Math.sin(ang1);

        pnt3 = p2;
        pnt3.SHPinvtraruo(cosa,sena,tx,ty);

        pnt2.x = 0.0;
        pnt2.m = p1.m;
        pnt2.z = p1.z;
        offset = -offset; // Ho messo -offset perchè cosi mi da positivo l'offset che sta a destre del senso di percorrenza. MM 14/10/2005
        pnt2.y = offset;
        pnt3.y = offset;

        pnt2.SHPruotra(cosa,sena,tx,ty);
        p1 = pnt2;

        pnt3.SHPruotra(cosa,sena,tx,ty);
        p2 = pnt3;

        if (p1.SHPdstpt(p2) < MConst.TOLL) return false;
        return true;
    }
/// <summary>
/// Calcola il punto di intersezione tra due segmenti e i valori
/// dei parametri t su entrambi.
/// </summary>
/// <param name="s2">segmento di intersezione</param>
/// <param name="pt">punto di intersezione</param> VV era ref
/// <param name="t1">param t sul primo segmento</param> VV era ref
/// <param name="t2">paramt sul secondo segmento</param> VV era ref
/// <returns></returns>
    public int SHPint2seg(SHPSegm s2, SHPPoint pt, double t1, double t2)
    {
        double dx1,dy1,dx2,dy2,den,det,m1,m2;
        SHPRetta ret1,ret2;
        //
        //  Coefficienti prima retta
        //
        dx1 = this.p2.x - this.p1.x;
        ret1 = new SHPRetta();
        ret1.b = -dx1;
        ret1.a = dy1 = this.p2.y - this.p1.y;
        den = Math.sqrt(ret1.a * ret1.a + ret1.b * ret1.b);
        if (den  <= 0.0) return 0;

        ret1.a /= den;
        ret1.b /= den;
        ret1.c = -this.p1.x * ret1.a - this.p1.y * ret1.b;
        //
        //  Coefficienti seconda retta
        //
        dx2 = s2.p2.x - s2.p1.x;
        ret2 = new SHPRetta();
        ret2.b = -dx2;
        ret2.a = dy2 = s2.p2.y - s2.p1.y;
        den = Math.sqrt(ret2.a * ret2.a + ret2.b * ret2.b);
        if (den  <= 0.0) return 0;

        ret2.a /= den;
        ret2.b /= den;
        ret2.c = -s2.p1.x * ret2.a - s2.p1.y * ret2.b;

        det =   ret1.a * ret2.b  -  ret2.a * ret1.b;
        if (Math.abs(det) >= 1.0e-5)
        {
            pt.x = -(ret1.c * ret2.b - ret2.c * ret1.b) / det;
            pt.y = -(ret2.c * ret1.a - ret1.c * ret2.a) / det;

            t1 = (Math.abs(dx1) > Math.abs(dy1)) ? (pt.x - this.p1.x) / dx1 : (pt.y - this.p1.y) / dy1;
            t2 = (Math.abs(dx2) > Math.abs(dy2)) ? (pt.x - s2.p1.x) / dx2 : (pt.y - s2.p1.y) / dy2;
            pt.z = (this.p2.z - this.p1.z) * t1 + this.p1.z; // calcolo le z e le m
            pt.m = (this.p2.m - this.p1.m) * t1 + this.p1.m;
            return 1;
        }
        //
        // Segmenti paralleli
        //
        m1 = ret1.a * s2.p1.x + ret1.b * s2.p1.y + ret1.c;
        m2 = ret1.a * s2.p2.x + ret1.b * s2.p2.y + ret1.c;
        if ((Math.abs(m1) > 1.0e-7) || (Math.abs(m2) > 1.0e-7)) return 0;
        //
        //  Segmenti collineari -> verifica se hanno estremo in comune
        //
        if (p1.SHPpteq(s2.p1))
        {
            pt = this.p1;
            t1 = 0.0;
            t2 = 0.0;
            return 1;
        }
        else if (p1.SHPpteq(s2.p2))
        {
            pt = this.p1;
            t1 = 0.0;
            t2 = 1.0;
            return 1;
        }
        else if (p2.SHPpteq(s2.p1))
        {
            pt = this.p2;
            t1 = 1.0;
            t2 = 0.0;
            return 1;
        }
        else if (p2.SHPpteq(s2.p2))
        {
            pt = this.p2;
            t1 = 1.0;
            t2 = 1.0;
            return 1;
        }
        return 0;
    }
/// <summary>
/// Calcola il segmento offsettato sul semipiano indicato da pt
/// </summary>
/// <param name="offset"></param>
/// <param name="pt"></param>
/// <param name="pr2"></param> VV era ref
/// <returns></returns>
    public void SHPOffset(double offset, SHPPoint pt, SHPSegm pr2)
    {
        double	tx,ty,ang,cosa,sena,doff;
        SHPPoint	pt1 = new SHPPoint(),pt2= new SHPPoint(),pt3 = new SHPPoint();

        doff = this.SHPOffsetSeg(pt,offset);

        tx = p1.x;
        ty = p1.y;
        ang = p1.SHPangx(p2);
        cosa = Math.cos(ang);
        sena = Math.sin(ang);
        pt3 = p2;
        pt3.SHPinvtraruo(cosa,sena,tx,ty);

        pt2.x = 0.0;
        pt2.y = doff;
        pt2.SHPruotra(cosa,sena,tx,ty);
        pr2.p1 = pt2;

        pt3.y = doff;
        pt3.SHPruotra(cosa,sena,tx,ty);
        pr2.p2 = pt3;
    }
///
/// </summary>
/// <param name="pt"></param>
/// <param name="offset"></param>
/// <returns></returns>
    public double SHPOffsetSeg(SHPPoint pt, double offset)
    {
        double	doff,ang,cosa,sena,tx,ty;
        SHPPoint	pt1 =new SHPPoint();

        ang = this.p1.SHPangx(this.p2);
        tx = this.p1.x;
        ty = this.p1.y;
        cosa = Math.cos(ang);
        sena = Math.sin(ang);
        pt1 = pt;
        pt1.SHPinvtraruo(cosa,sena,tx,ty);
         // Ho messo -offset perchè cosi mi da positivo l'offset che sta a destre del senso di percorrenza. MM 14/10/2005

        if (pt1.y > 0.0)
            doff = -offset;
        else
            doff = offset;

        return doff;
    }
/// <summary>
/// Calcola la distanza segmento punto
/// </summary>
/// <param name="pt"></param>
/// <returns></returns>
    public double SHPdstptpr(SHPPoint pt)
    {
        int		nint;
        double	dd,tval,tang;
        SHPPoint	piede = new SHPPoint();
        tang = tval = 0.0;

  //      nint = this.SHPprjpt(pt,ref tval,ref tang,ref piede);
        nint = this.SHPprjpt(pt,tval,tang,piede);
        if (nint == 0)
        {
            dd = Math.min(pt.SHPdstpt(p1),pt.SHPdstpt(p2));
        }
        else
        {
            dd = pt.SHPdstpt(piede);
        }
        return dd;
    }
/// </summary>
/// <param name="pto"></param>
/// <param name="tval"></param> VV era ref
/// <param name="tang"></param> VV era ref
/// <param name="ptprj"></param> VV era ref
/// <returns></returns>
    public int SHPprjpt(SHPPoint pto,double tval, double tang, SHPPoint ptprj)
    {
        int		nint;
        SHPRetta	ret = new SHPRetta(),rnor = new SHPRetta();
        SHPPoint	piede = new SHPPoint();
        double	dxt,dyt,t;

        nint = 0;
        ret.SHPret2pt(p1, p2);
        ret.SHPrnp(pto, rnor);
        nint = ret.SHPi2r(rnor, piede);
        //
        //  parametro t lungo il segmento.
        //
        dxt = p2.x - p1.x;
        dyt = p2.y - p1.y;
        if ((Math.abs(dxt) + Math.abs(dyt)) < MConst.TOLL) return 0;

        t = (Math.abs(dxt) < Math.abs(dyt)) ? (piede.y - p1.y) / dyt : 	(piede.x - p1.x) / dxt;
        if (t + MConst.TOLL < 0.0) return 0;
        if (t - MConst.TOLL > 1.0) return 0;
        ptprj = piede;
        tval  = t;
        tang = p1.SHPangx(p2);
        return 1;
    }

}
