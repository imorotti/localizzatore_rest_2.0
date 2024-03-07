package com.siteco.JRs40DynSeg;
/*
 * SHPPoly.java
 *
 * Created on 8 febbraio 2006, 12.43
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

import java.lang.Object.*;
import java.util.*;

/**
 *
 * @author vanna
 */
public class SHPPoly {

    /** Creates a new instance of SHPPoly */
    public SHPPoly() {
	pnt = new ArrayList();
    }
/// <summary>
///
/// </summary>
/// <param name="Src"></param>
    public SHPPoly(SHPPoly Src)
    {
        box = new Box(Src.box);
        for (int i=0; i<Src.pnt.size(); i++)
        {
            pnt.add(i,new SHPPoint((SHPPoint) Src.pnt.get(i)));
        }
    }

/// <summary>
/// vettore di Punti
/// </summary>
    public ArrayList pnt;
/// <summary>
/// Bounding box
/// </summary>
    public Box box;

/// <summary>
/// Aggiunge un punto al vettore dei punti
/// </summary>
/// <returns></returns>
    public void SHPAddPoint(SHPPoint p)
    {
	this.pnt.add(p);
    }
/// <summary>
/// Aggiunge un punto al vettore dei punti nella posizione specificata
/// </summary>
/// <returns></returns>
    public void SHPAddPointinPos(int pos, SHPPoint p)
    {
	SHPPoint newpt = new SHPPoint((SHPPoint)(this.pnt.get(this.pnt.size() - 1)));
	this.pnt.add(newpt);
	//
	// Sposto gli elementi per inserire il nuovo nella pos-esima posizione
	//
	for (int i=this.pnt.size()-1; i>=pos+1; i--)
	{
            this.pnt.set((i), this.pnt.get(i-1));
	}
	this.pnt.set(pos,new SHPPoint(p));
    }
/// <summary>
/// Aggiunge una poly al vettore di punti
/// </summary>
/// <returns></returns>
    public void SHPAddPoly(SHPPoly pol)
    {
	SHPPoint pt;
	for (int i=0; i<pol.pnt.size(); i++)
	{
            pt = ((SHPPoint)(pol.pnt.get(i)));
            this.pnt.add(pt);
	}
    }
/// <summary>
/// Aggiunge npt punti al vettore dei punti
/// </summary>
/// <returns></returns>
    public void SHPAddPoints(int npt,SHPPoint [] vpt)
    {
	SHPPoint pt;
	for (int i=0; i<npt; i++)
	{
            pt = vpt[i];
            this.pnt.add(pt);
	}
    }
/// <summary>
/// Inverte il vettore dei punti
/// </summary>
/// <returns></returns>
    public void SHPInvertPoints()
    {
	SHPPoly pol = new SHPPoly();
	for (int i=this.pnt.size()-1; i>=0; i--)
	{
            pol.pnt.add(((SHPPoint)(this.pnt.get(i))));
	}
	this.pnt = pol.pnt;
    }
/// <summary>
/// Calcola il box della poly
/// </summary>
/// <returns></returns>
    public Box SHPCalBox()
    {
	Box b = new Box();
	for (int i=0; i<this.pnt.size(); i++)
	{
		b.xmin = Math.min(b.xmin, ((SHPPoint)(this.pnt.get(i))).x);
		b.ymin = Math.min(b.ymin, ((SHPPoint)(this.pnt.get(i))).y);
		b.zmin = Math.min(b.zmin, ((SHPPoint)(this.pnt.get(i))).z);
		b.mmin = Math.min(b.mmin, ((SHPPoint)(this.pnt.get(i))).m);
		b.xmax = Math.max(b.xmax, ((SHPPoint)(this.pnt.get(i))).x);
		b.ymax = Math.max(b.ymax, ((SHPPoint)(this.pnt.get(i))).y);
		b.zmax = Math.max(b.zmax, ((SHPPoint)(this.pnt.get(i))).z);
		b.mmax = Math.max(b.mmax, ((SHPPoint)(this.pnt.get(i))).m);
	}
	return b;
    }

    /**
     * restituisce un vettore di double contenente la m al primo estremo
     * e la m all'ultimo estremo
     * @return double[]
     */
    public double[] SHPGet2m()
    {
        double[] mMin_mMax = new double[2];
	double mmin = ((SHPPoint)this.pnt.get(0)).m;
	double mmax = ((SHPPoint)this.pnt.get(this.pnt.size() -1)).m;
        mMin_mMax[0] = mmin;
        mMin_mMax[1] = mmax;
        return mMin_mMax;
    }

/// <summary>
/// Restituisce il nu. dei punti tra m1 e m2
/// </summary>
/// <param name="m1"></param>
/// <param name="m2"></param>
/// <returns></returns>
    public long SHPGetNPointsInPoly2m(double m1,double m2)
    {
	long npt = this.pnt.size();
	if (npt == 0) return 0;
        double[] mMin_mMax = new double[2];
        mMin_mMax = this.SHPGet2m();
	double mmin = mMin_mMax[0];
	double mmax = mMin_mMax[1];
	if((m1 <= mmin) && (m2 >= mmax))
	{
            // tutto dentro;
            return npt;
	}
	else if((mmin > m2) || (mmax < m1))
	{
            // tutto fuori
            return 0;
	}
	else
	{
            boolean res1,res2;
            SHPPoint p1=new SHPPoint(),p2=new SHPPoint();
            double a1=0.0,a2=0.0,b1=0.0,b2=0.0,t1=0.0,t2=0.0;
            // c'e' intersezione calcolo i punti
            res1 = this.SHPcalpntm(m1,p1,a1,t1);
            res2 = this.SHPcalpntm(m2,p2,a2,t2);
            b2 = Math.floor(t2-0.0000001);
            b1 = Math.ceil(t1+0.0000001);

            if(res1 && res2)
            {
            	// tutto compreso nella parte
		if(b2 < b1) return 2;
		//return (((int) b2) - ((int) b1) + 2);
		npt = (int)(Math.floor(t2-t1)) + 2;
		return npt;
            }
            else if(res1 && !res2)
            {
		// da t1 alla fine
		return (npt - (long) b1 +2);
            }
            else if(!res1 && res2)
            {
            	// dall'inizio a t2
            	return ((long) b2 +2);
            }
            else
            {
            	// non c'e' nessun punto res1 = false res2 = false
            	return 0;
            }
	}
    }
/// <summary>
/// Proietta un punto su una poly
/// </summary>
/// <param name="pto"></param>
/// <param name="mval"></param> VV ref
/// <param name="tval"></param> VV ref
/// <param name="mang"></param> VV ref
/// <param name="ptprj"></param> VV ref
/// <returns></returns>
    public int SHPprjptm(SHPprjptm prjptm)
    {
        int lato = 0;
        prjptm.lato = lato;
        return this.SHPprjptm(prjptm ,lato);
    }
/// <summary>
/// Proietta un punto su una poly
/// </summary>
/// <param name="pto"></param>
/// <param name="mval"></param> VV ref
/// <param name="tval"></param> VV ref
/// <param name="mang"></param> VV ref
/// <param name="ptprj"></param> VV ref
/// <returns></returns>
    //public int SHPprjptm(SHPPoint pto, double mval,double tval, double mang, SHPPoint ptprj,int lato)
    public int SHPprjptm(SHPprjptm prjptm, int lato)
    {
	int np,npt,nsol,nint;
	double dmin,dst,d1,d2,t=0.0,diffm;
	double dlato = 0.0;

	npt = this.pnt.size();
	nint = 0;
	dmin = 1.0e36;
	for (np = 0; np < (npt - 1); np++)
	{
            SHPSegm seg = new SHPSegm();
            seg.p1 = (SHPPoint)this.pnt.get(np);
            seg.p2 = (SHPPoint)this.pnt.get(np+1);
            SHPPoint p1 = new SHPPoint(seg.p1.x,seg.p1.y);
            SHPPoint p2 = new SHPPoint(seg.p2.x,seg.p2.y);

            SHPRetta ret = new SHPRetta();
            SHPRetta rnor = new SHPRetta();
            ret.SHPret2pt(p1, p2);
            ret.SHPrnp(prjptm.pto, rnor);

            SHPPoint piede = new SHPPoint();
            //nsol = seg.SHPisr(rnor, piede, t);
            t = seg.SHPisr(rnor, piede, t);
            //if (nsol == 0) continue;
            if (t == 0) continue;
            if (t < 0.0 || t > 1.0)
            {
            	d1 = prjptm.pto.SHPdstpt(p1);
            	d2 = prjptm.pto.SHPdstpt(p2);
                dst = Math.min(d1,d2);
                if (dst > dmin) continue;
                dlato = ret.SHPdptr(prjptm.pto);
		if(dlato == 0.0) prjptm.lato = 0;
		else
		{
                    if(dlato < 0.0) prjptm.lato = -1;
                    else prjptm.lato = 1;
		}
		if (d1 < d2)
		{
                    prjptm.ptprj = p1;
                    t = 0.0;
                    if (np == 0) nint = 0;
                    else  nint = 1;
                }
		else
		{
                    prjptm.ptprj = p2;
                    t = 0.99999999;
                    if (np == (npt - 2)) nint = 0;
                    else  nint = 1;
		}
            }
            else
            {
		dst = prjptm.pto.SHPdstpt(piede);
		if (dst > dmin) continue;
		dlato = ret.SHPdptr(prjptm.pto);
		if(dlato == 0.0) prjptm.lato = 0;
		else
		{
                    if(dlato < 0.0) prjptm.lato = -1;
                    else prjptm.lato = 1;
		}
                prjptm.ptprj = piede;
		nint = 1;
            }
            dmin = dst;
            diffm = ((SHPPoint)this.pnt.get(np+1)).m - ((SHPPoint)this.pnt.get(np)).m;
            prjptm.mval = t*diffm + ((SHPPoint)this.pnt.get(np)).m;
            prjptm.tval = t + np;
            prjptm.mang = p1.SHPangx(p2);
	}
	return nint;
    }

/// <summary>
/// Proietta un punto su una poly
/// </summary>
/// <param name="pto"></param> VV ref
/// <param name="mval"></param>VV ref
/// <param name="tval"></param>VV ref
/// <param name="mang"></param>VV ref
/// <param name="ptprj"></param>VV ref
/// <param name="Offset"></param>VV ref
/// <returns></returns>
    public int SHPprjptm(SHPprjptm prjptm ,double Offset)
    {
	int np,npt,nsol,nint;
	double dmin,dst,d1,d2,t=0.0,diffm;
	Offset = 0.0;
	npt = this.pnt.size();
	nint = 0;
	dmin = 1.0e36;
	for (np = 0; np < (npt - 1); np++)
	{
            SHPSegm seg = new SHPSegm();
            seg.p1 = (SHPPoint)this.pnt.get(np);
            seg.p2 = (SHPPoint)this.pnt.get(np+1);
            SHPPoint p1 = new SHPPoint(seg.p1.x,seg.p1.y);
            SHPPoint p2 = new SHPPoint(seg.p2.x,seg.p2.y);

            SHPRetta ret = new SHPRetta();
            SHPRetta rnor = new SHPRetta();
            ret.SHPret2pt(p1, p2);
            ret.SHPrnp(prjptm.pto,rnor);

            SHPPoint piede = new SHPPoint();
            //nsol = seg.SHPisr(rnor,piede,t);
            t = seg.SHPisr(rnor,piede,t);
            //if (nsol == 0) continue;
            if (t == 0) continue;
            if (t < 0.0 || t > 1.0)
            {
                d1 = prjptm.pto.SHPdstpt(p1);
                d2 = prjptm.pto.SHPdstpt(p2);
                dst = Math.min(d1,d2);
                if (dst > dmin) continue;
                Offset = ret.SHPdptr(prjptm.pto);
                if (d1 < d2)
                {
                    prjptm.ptprj = p1;
                    t = 0.0;
                    if (np == 0) nint = 0;
                    else  nint = 1;
                }
                else
                {
                    prjptm.ptprj = p2;
                    t = 0.99999999;
                    if (np == (npt - 2)) nint = 0;
                    else  nint = 1;
                }
            }
            else
            {
                dst = prjptm.pto.SHPdstpt(piede);
                if (dst > dmin) continue;
                Offset = ret.SHPdptr(prjptm.pto);
                prjptm.ptprj = piede;
                nint = 1;
            }
            dmin = dst;
            diffm = ((SHPPoint)this.pnt.get(np+1)).m - ((SHPPoint)this.pnt.get(np)).m;
            prjptm.mval  = t*diffm + ((SHPPoint)this.pnt.get(np)).m;
            prjptm.tval  = t + np;
            prjptm.mang = p1.SHPangx(p2);
            prjptm.Offset = Offset;
	}
	return nint;
    }
/// <summary>
/// Calcola il valore del punto pt e il relativo angolo e tval in corrispondenza del parametro mval
/// </summary>
/// <param name="mval">misura data</param>
/// <param name="pt">punto calcolato</param> VV ref
/// <param name="angr">angolo che forma il punto sulla poly</param> VV ref
/// <param name="tval">valore t del punto pt sulla poly</param> VV ref
/// <returns></returns>
    public boolean SHPcalpntm(double mval,SHPPoint pt,double angr,double tval)
    {
	double lun,m1,m2,ang;
	int i;
	int npt = this.pnt.size();
	for (i=0; i<npt-1; i++)
	{
            m1 = ((SHPPoint)this.pnt.get(i)).m;
            if(mval == m1)
            {
		// caso particolare ma non raro
		pt = new SHPPoint((SHPPoint)pnt.get(i));
		angr = ((SHPPoint)pnt.get(i)).SHPangx((SHPPoint)pnt.get(i+1));
		tval = (double) i;
		return true;
            }
            m2 = ((SHPPoint)pnt.get(i+1)).m;
            if((mval > m2) || (mval < m1)) continue;
            lun = ((SHPPoint)pnt.get(i)).SHPdstpt((SHPPoint)pnt.get(i+1));
            double diffm = m2-m1;
            double k = (mval-m1)*lun/diffm;
            ang = ((SHPPoint)pnt.get(i)).SHPangx((SHPPoint)pnt.get(i+1));
            pt = new SHPPoint();
            pt.x = ((SHPPoint)pnt.get(i)).x + Math.cos(ang)*k;
            pt.y = ((SHPPoint)pnt.get(i)).y + Math.sin(ang)*k;
            pt.m = mval;
            angr = ang;
            tval = (double) i + (mval - m1) / diffm;
            return true;
	}
	return false;
    }
/// <summary>
/// In corrispondenza del parametro mval, calcolo il punto e poi ne faccio l'offset
/// </summary>
/// <param name="mval">misura data</param>
/// <param name="offset">valore di spostamento del punto</param>
/// <param name="pt">punto calcolato</param> VV ref
/// <returns></returns>
    public boolean SHPcalpntoffsetm(double mval, double offset, SHPPoint pt)
    {
	double lun,m1,m2,ang;
	int npt = this.pnt.size();
	SHPSegm seg;
	SHPPoint pt1;
	for (int i=0; i<npt-1; i++)
	{
		m1 = ((SHPPoint)this.pnt.get(i)).m;
		seg = new SHPSegm((SHPPoint) this.pnt.get(i),(SHPPoint) this.pnt.get(i+1));
		if(mval == m1)
		{
			// caso particolare ma non raro in cui coincide con un estremo
			pt.SHPoffsetpnt((SHPPoint)pnt.get(i),seg,offset);
			return true;
		}
		m2 = ((SHPPoint)pnt.get(i+1)).m;
		if((mval > m2) || (mval < m1)) continue;

		lun = ((SHPPoint)pnt.get(i)).SHPdstpt((SHPPoint)pnt.get(i+1));
		double diffm = m2-m1;
		double k = (mval-m1)*lun/diffm;
		ang = ((SHPPoint)pnt.get(i)).SHPangx((SHPPoint)pnt.get(i+1));
		pt1 = new SHPPoint();
		pt1.x = ((SHPPoint)pnt.get(i)).x + Math.cos(ang)*k;
		pt1.y = ((SHPPoint)pnt.get(i)).y + Math.sin(ang)*k;
		pt1.m = mval;
                SHPPoint point = pt1.SHPoffsetpnt(pt1,seg,offset);
                pt.m = point.m;
                pt.x = point.x;
                pt.y = point.y;
                pt.z = point.z;
		//pt = pt1.SHPoffsetpnt(pt1,seg,offset);
		return true;
	}
	return false;
    }
/// <summary>
///
/// </summary>
/// <param name="pt"></param> VV ref
/// <returns></returns>
    public boolean SHPpos_pt(SHPPoint pt)
    {
	int i,pos,npt;
	double dst,dmin;
	SHPSegm seg = new SHPSegm();
	SHPRetta ret = new SHPRetta();

	npt = this.pnt.size();
	if (npt < 2) return false;
	dmin = 1.0e36;
	pos = 0;
	for (i=0; i<npt-1; i++)
	{
            seg.p1 = (SHPPoint)this.pnt.get(i);
            seg.p2 = (SHPPoint)this.pnt.get(i+1);
            dst = seg.SHPdstptpr(pt);
            if (dst < dmin)
            {
		dmin = dst;
		pos = i;
            }
	}
	ret.SHPret2pt((SHPPoint)this.pnt.get(pos),(SHPPoint)this.pnt.get(pos+1));
	dst = pt.SHPdptr(ret);
	if (dst < 0.0)
            return true;
	else
            return false;
    }
/// <summary>
/// Calcola la distanza del punto pt dalla poly
/// </summary>
/// <param name="pt"></param>
/// <returns></returns>
    public double SHPdstptpr(SHPPoint pt)
    {
	int i,npunti,nint;
	double dd,dst,tval=0.0,tang=0.0;
	SHPSegm	seg = new SHPSegm();
	SHPPoint piede = new SHPPoint();

	npunti = this.pnt.size() - 1;
	dd = 1.0e36;

	for (i=0; i<npunti; i++)
	{
		seg.p1 = (SHPPoint)this.pnt.get(i);
		seg.p2 = (SHPPoint)this.pnt.get(i+1);

		nint = seg.SHPprjpt(pt,tval,tang,piede);
		if (nint == 0)
			dst = Math.min(pt.SHPdstpt(seg.p1),pt.SHPdstpt(seg.p2));
		else
			dst = pt.SHPdstpt(piede);

		if (dst < dd) dd = dst;
	}
	return dd;
    }
/// <summary>
///
/// </summary>
/// <param name="tval"></param>
/// <param name="precs"></param>
/// <param name="pt"></param>
/// <param name="angr"></param>
/// <returns></returns>
    public boolean SHPcalpnt(double tval,double precs,SHPPoint pt,double angr)
    {
	int i,npt;
	double tlun,lun,ang=0.0;
	npt = this.pnt.size();
	tlun = 0.0;
	for (i=0; i<npt-1; i++)
	{
		lun = ((SHPPoint)this.pnt.get(i)).SHPdstpt((SHPPoint)this.pnt.get(i+1));
		ang = ((SHPPoint)this.pnt.get(i)).SHPangx((SHPPoint)this.pnt.get(i+1));
		if (tval <= (tlun+lun+precs))
		{
			ang = ((SHPPoint)this.pnt.get(i)).SHPangx((SHPPoint)this.pnt.get(i+1));
			pt.x = ((SHPPoint)this.pnt.get(i)).x + Math.cos(ang)*(tval-tlun);
			pt.y = ((SHPPoint)this.pnt.get(i)).y + Math.sin(ang)*(tval-tlun);
			angr = ang;
			return true;
		}
        	tlun += lun;
	}
	angr = ang;
	return true;
    }
/// <summary>
/// Calcola la lunghezza della poly fino al np_esimo punto
/// </summary>
/// <returns></returns>
    public double SHPcallunt(int np)
    {
	double tlun,lun;

	tlun = 0.0;
	for (int i=0; i<np; i++)
	{
		lun = ((SHPPoint)this.pnt.get(i)).SHPdstpt((SHPPoint)this.pnt.get(i+1));
		tlun += lun;
	}
	return tlun;
    }
/// <summary>
/// Se non presente, calcola la m come lunghezza della poly sino al punto
/// </summary>
/// <returns></returns>
    public void SHPAggM()
    {
	double dum = ((SHPPoint)this.pnt.get(0)).m;
	//if (!double.IsNaN(dum)) return;
	((SHPPoint)this.pnt.get(0)).m = 0.0;
	for (int i=1; i<this.pnt.size(); i++)
	{
		((SHPPoint)(this.pnt.get(i))).m = this.SHPcallunt(i);
	}
	return;
    }
/// <summary>
/// Proietta il punto pto sulla poly restituendo anche i valori di t e dell'angolo tang
/// </summary>
/// <param name="pto"></param>
/// <param name="tval"></param> VV ref
/// <param name="tang"></param> VV ref
/// <param name="ptprj"></param> VV ref
/// <returns></returns>
    public int SHPprjpt(SHPprjptm prjptm)
    {
	int np,nsol,nint=0;
	double dmin,dst,d1,d2,t=0.0;

	dmin = 1.0e36;
	for (np = 0; np < (this.pnt.size() - 1); np++)
	{
		SHPSegm seg = new SHPSegm();
		seg.p1 = ((SHPPoint)this.pnt.get(np));
		seg.p2 = ((SHPPoint)this.pnt.get(np+1));
		SHPPoint p1 = new SHPPoint(seg.p1.x,seg.p1.y);
		SHPPoint p2 = new SHPPoint(seg.p2.x,seg.p2.y);

		SHPRetta ret = new SHPRetta();
		SHPRetta rnor = new SHPRetta();
		ret.SHPret2pt(p1, p2);
		ret.SHPrnp(prjptm.pto,rnor);

		SHPPoint piede = new SHPPoint();
		//nsol = seg.SHPisr(rnor,piede,t);
                t = seg.SHPisr(rnor,piede,t);
		//if (nsol == 0) continue;
                if (t == 0) continue;
		if (t < 0.0 || t > 1.0)
		{
			d1 = prjptm.pto.SHPdstpt(p1);
			d2 = prjptm.pto.SHPdstpt(p2);
			dst = Math.min(d1,d2);
			if (dst > dmin) continue;
			if (d1 < d2)
			{
				prjptm.ptprj = p1;
				t = 0.0;
				if (np == 0) nint = 0;
				else  nint = 1;
			}
			else
			{
				prjptm.ptprj = p2;
				t = 0.99999999;
				if (np == (this.pnt.size() - 2)) nint = 0;
				else  nint = 1;
			}
		}
		else
		{
			dst = prjptm.pto.SHPdstpt(piede);
			if (dst > dmin) continue;
			prjptm.ptprj.x = piede.x;
			prjptm.ptprj.y = piede.y;
			prjptm.ptprj.z = piede.z;
			prjptm.ptprj.m = piede.m;
			nint = 1;
		}
		dmin = dst;
		prjptm.tval  = t + np;
		prjptm.mang = p1.SHPangx(p2);
	}
	return nint;
    }
/// <summary>
/// Calcola l'offset di una poly nell'intervallo da m1 a m2
/// </summary>
/// <param name="offset">valore dell'offset</param>
/// <param name="m1">dalla misura m1</param>
/// <param name="m2">alla misura m2</param>
/// <returns></returns>
    public SHPPoly SHPOffset(double offset, double m1,double m2)
    {
	int	nsegoff,nl,nl2;
	seg_offset [] segoff;
	SHPSegm	seg;
	SHPPoly pol = this.SHPGetPolyIn2m(m1,m2);
	if (pol == null) return null;
	if(offset == 0.0) return pol; // se non c'e' offset da fare esce

	if (pol.pnt.size() == 2) // semplificazione per poly di soli 2 punti
	{
		seg = new SHPSegm((SHPPoint) pol.pnt.get(0), (SHPPoint) pol.pnt.get(1));
		if (!seg.SHPOffsetP(offset)) return null;

		SHPPoly pol3 = new SHPPoly();
		pol3.SHPAddPoint(seg.p1);
		pol3.SHPAddPoint(seg.p2);
		pol3.box = pol3.SHPCalBox();
		return pol3;
	}

	nsegoff = pol.pnt.size() - 1;
	segoff = new seg_offset[nsegoff];

	for (nl=0; nl<nsegoff; nl++) {
		segoff[nl] = new seg_offset();
		seg = new SHPSegm((SHPPoint) pol.pnt.get(nl), (SHPPoint) pol.pnt.get(nl+1));
		if (!seg.SHPOffsetP(offset))
			segoff[nl].canc = true;
		else
			segoff[nl].canc = false;

		segoff[nl].seg.p1 = seg.p1;
		segoff[nl].seg.p2 = seg.p2;

		segoff[nl].p1 = segoff[nl].seg.p1;
		segoff[nl].p2 = segoff[nl].seg.p2;
	}
	if (!this.SHPOffsetPol(nsegoff, segoff)) return null;

	SHPPoly pol2 = new SHPPoly();
	for (nl=0, nl2=0; nl<nsegoff; nl++) {
		if (segoff[nl].canc) continue;
		pol2.SHPAddPoint(segoff[nl].p1);
		nl2 = nl;
	}
	pol2.SHPAddPoint(segoff[nl2].p2);
	pol2.box = pol2.SHPCalBox();
	return pol2;
    }
/// <summary>
/// Calcola l'offset di una poly rappresentata come n. di segmenti e vettore di segmenti
/// </summary>
/// <param name="nsegoff">nu. di segmenti da offsettare</param>
/// <param name="segoff">segmenti della poly da offsettare</param>
/// <returns></returns>
    private boolean SHPOffsetPol(int nsegoff,seg_offset [] segoff)
    {
	int nl1,nl2,nint;
	boolean flag,primo;
	double	ang,ang1,ang2,t1,t2;
	SHPSegm	seg;
	t1 = 0.0; t2 = 0.0;

	primo = false;
	while (!primo)
	{
		flag = false;
		//
		// Assegna ad nl1 il primo lato non cancellato
		//
		for(nl1 = 0; nl1 < nsegoff; nl1++) if (!segoff[nl1].canc) break;
		if (nl1 == nsegoff) return false;
		while (true)
		{
			if (segoff[nl1].canc)
			{
				flag = true;
				break;
			}
			for(nl2=nl1+1; nl2 < nsegoff; nl2++) if (!segoff[nl2].canc) break;
			if (nl2 >= nsegoff) break;
			seg = new SHPSegm(segoff[nl1].seg.p1,segoff[nl1].seg.p2);
			SHPPoint xyint = new SHPPoint();
			nint = seg.SHPint2seg(segoff[nl2].seg,xyint,t1,t2);
			switch(nint)
			{
				case 0:
					segoff[nl1].canc = true;
					continue;
				case 1:
					segoff[nl1].p2 = xyint;
					segoff[nl2].p1 = xyint;
					break;
			}
			nl1 = nl2;
		}
		if (flag) continue;
		//
		// Controlla che ciascun lato di tipo segmento mantenga
		// la stessa direzione del lato originale; in caso contrario lo cancella dalla lista
		//
		for(nl2=0; nl2<nsegoff; nl2++)
		{
			primo = true;
			if(segoff[nl2].canc) continue;

			ang1 = segoff[nl2].p1.SHPangx(segoff[nl2].p2);
			ang2 = segoff[nl2].seg.p1.SHPangx(segoff[nl2].seg.p2);
			ang = Math.min(MConst.angcen(ang1,ang2,MConst.ANTIORARIO),MConst.angcen(ang2,ang1,MConst.ANTIORARIO));
			if (ang > 1.0e-1)
			{
				segoff[nl1].p2 = segoff[nl1].seg.p2;
				segoff[nl2].canc = true;
				primo = false;
				break;
			}
		}
	}
	return true;
    }
/// <summary>
/// Estrae dalla poly corrente la poly pol compresa tra m1 ed m2
/// </summary>
/// <param name="m1">primo valore di m</param>
/// <param name="m2">secondo valore di m</param>
    public SHPPoly SHPGetPolyIn2m(double m1, double m2)
    {
	int npt = this.pnt.size();
	int nptn = (int) this.SHPGetNPointsInPoly2m(m1, m2);
	if (nptn == 0) return null;
	double t1=0.0,t2=0.0,a1=0.0,a2=0.0,mmin=0.0,mmax=0.0;
	SHPPoint p1=new SHPPoint(),p2=new SHPPoint();
	int i,indL,indU;
	boolean res1,res2;
	SHPPoly pol = new SHPPoly();

        double[] mMin_mMax = this.SHPGet2m();
        mmin = mMin_mMax[0];
        mmax = mMin_mMax[1];
	if((m1 <= mmin) && ( m2 >= mmax))
	{
		// tutto dentro;
		for(i=0; i<nptn; i++)
		{
			pol.SHPAddPoint((SHPPoint)this.pnt.get(i));
		}
		pol.box = pol.SHPCalBox();
		return pol;
	}
	else
	{
		res1 = this.SHPcalpntm(m1,p1,a1,t1);
		res2 = this.SHPcalpntm(m2,p2,a2,t2);
		if(res1 && res2)
		{
			// tutto compreso nella parte
			// t1 e t2 invariati
		}
		else if(res1 && !res2)
		{
			// da t1 alla fine
			t2 = npt;
			p2 = (SHPPoint)this.pnt.get(npt-1);
		}
		else if(!res1 && res2)
		{
			// dall'inizio a t2
			t1 = 0;
			p1 = (SHPPoint)this.pnt.get(0);
		}
		else
		{
			// non c'e' nessun punto res1 = false res2 = false
			return null;
		}
		int nn;
		for (nn=0; nn<nptn; nn++)
			pol.SHPAddPoint(p1);

		nn = 0;
		pol.pnt.set(nn++,p1);
		pol.pnt.set(nptn-1,p2);
		indL = (int) Math.ceil(t1+0.000000001);
		indU = (int) Math.floor(t2-0.00000001);
		for(i=indL; i<=indU; i++)
		{
			pol.pnt.set(nn,this.pnt.get(i));
			nn++;
		}
		pol.box =  pol.SHPCalBox();
		return pol;
	}
    }

}
