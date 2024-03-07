/*
 * OpShape.java
 *
 * Created on 10 marzo 2006, 17.02
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
public class OpShape {

    /** Creates a new instance of OpShape */
    public OpShape() {
    }
/// <summary>
/// Proietta un punto dato su una poly
/// </summary>
/// <param name="pnt">punto da proiettare</param>
/// <param name="pol">polyline su cui proiettare il punto</param>
/// <param name="prjpnt">punto proiettato</param> VV ref
/// <param name="dst">distanza lineare del punto proiettato sulla poly</param> VV ref
/// <returns> false= errore</returns>
    public SHPprjptm OpSHP_prjpntpol(SHPPoint pnt,SHPPoly pol,SHPPoint prjpnt,double dst)
    {
        SHPprjptm prjptm = new SHPprjptm();
        prjptm.pto = pnt;
        prjptm.ptprj = prjpnt;

	int nint = pol.SHPprjptm(prjptm);
	if (nint == 0) return null;

	int np = (int) 0.0;
	double dst1 = pol.SHPcallunt(np);
	SHPPoint pt = new SHPPoint(((SHPPoint)(pol.pnt.get(np))));
	double dst2 = pt.SHPdstptpr(prjpnt);
	dst = dst1+dst2;
        prjptm.Offset = dst;
	return prjptm;
    }

/// <summary>
/// Calcola il punto offsettato a partire da una poly e data una m
/// </summary>
/// <param name="pol">polyline da cui calcolare l'offset</param>
/// <param name="offset">offset sulla poly</param>
/// <param name="m">riferimento m da cui partire</param>
/// <param name="pnt">punto offsettato</param> VV ref
/// <returns> false= errore</returns>
    public boolean OpSHP_offpntm(SHPPoly pol,double m,double offset,SHPPoint pnt)
    {
	return pol.SHPcalpntoffsetm(m,offset,pnt);
    }

}
