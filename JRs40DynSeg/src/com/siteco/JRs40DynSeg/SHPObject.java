/*
 * SHPObject.java
 *
 * Created on 10 marzo 2006, 17.16
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.siteco.JRs40DynSeg;

import java.lang.Object.*;
import java.util.*;
import java.io.*;

/**
 *
 * @author vanna
 */
public class SHPObject {

    /** Creates a new instance of SHPObject */
    public SHPObject() {
        vpolilinee = new ArrayList();
        //
        // TODO: Add constructor logic here
        //
        nSHPType = tipo_shpobj.NULLSHAPE;
        IsShapeNull = false;
        nVertices = 0;
        nParts = 0;
        bbox = new Box();
    }

/// <summary>
/// Crea un nuovo shape object
/// </summary>
/// <param name="Src"></param>
    public SHPObject(SHPObject Src) {
        this.bbox = new Box(Src.bbox);
        this.nVertices = Src.nVertices;
        this.nParts = Src.nParts;
        this.nShapeId = Src.nShapeId;
        this.nSHPType = Src.nSHPType;
        this.IsShapeNull = Src.IsShapeNull;
        this.lenght = Src.lenght;
        for (int i = 0; i < Src.vpolilinee.size(); i++) {
            this.vpolilinee.set(i, new SHPPoly((SHPPoly) Src.vpolilinee.get(i)));
        }
    }

/// <summary>
/// Crea un nuovo shapeobject
/// </summary>
/// <param name="tipo"></param>
/// <param name="id"></param>
/// <param name="nparti"></param>
/// <param name="panPartStart"></param>
/// <param name="panPartType"></param>
/// <param name="nvert"></param>
/// <param name="vpol"></param>
/// <returns></returns>
    public SHPObject(int tipo, boolean shpnull, int len, int id, int nparti,
                     int nvert, SHPPoly[] vpol) {
        this.bbox = new Box();
        this.nVertices = nvert;
        this.nParts = nparti;
        this.nShapeId = id;
        this.nSHPType = tipo;
        this.IsShapeNull = shpnull;
        this.lenght = len;
        if (vpol != null) {
            for (int i = 0; i < vpol.length; i++) {
                this.vpolilinee.add(i, new SHPPoly((SHPPoly) vpol[i]));
            }
        }
        //else
        //	this.vpolilinee = null; // MM
    }

    public static int SwapInt(int sm)
    {
          //long smallendian = Double.doubleToLongBits(sm);
          return Integer.reverseBytes(sm);
    }

    public static double SwapDouble(double sm)
    {
        long smallendian = Double.doubleToLongBits(sm);
        //long smallendian = Double.doubleToRawLongBits(sm);

        long result;
        long l1 = (smallendian & 0x00000000000000FFL) << 56;
        long l2 = (smallendian & 0x000000000000FF00L) << 40;
        long l3 = (smallendian & 0x0000000000FF0000L) << 24;
        long l4 = (smallendian & 0x00000000FF000000L) << 8;
        long l5 = (smallendian & 0x000000FF00000000L) >>> 8;
        long l6 = (smallendian & 0x0000FF0000000000L) >>> 24;
        long l7 = (smallendian & 0x00FF000000000000L) >>> 40;
        long l8 = (smallendian & 0xFF00000000000000L) >>> 56;

        result = l1 | l2 | l3 | l4 | l5 | l6 | l7 | l8;
        double d = Double.longBitsToDouble(result);
        //double d = Double.doubleToRawLongBits(result);

        return d;
    }



//
// Tipo dell'object
//
    public int nSHPType;
//
// vale true se viene letto uno shapenull, false altrimenti
//
    public boolean IsShapeNull;
    public int nShapeId;
    public int nParts;
    public int nVertices;
//
// Content lenght letto dal file
//
    public int lenght;
    public ArrayList vpolilinee = new ArrayList();

    public Box bbox;

/// <summary>
/// Aggiunge una Poly alla struttura vpoly
/// </summary>
    public void AddPoly(SHPPoly pol) {
        this.vpolilinee.add(pol);
    }

/// <summary>
/// Calcola la lunghezza in 16 bit words dell'oggetto e lo memorizza nella variabile lenght
/// </summary>
    public void SHPCalLenght() {
        int len = 0;
        int nv = 0;
        int npart = 0;
        tipo_shpobj tipo;
        switch (this.nSHPType) {
//		case tipo.POINT:
        case 1:
            len = 10;
            break;
//		case tipo_shpobj.POINTM:
        case 21:
            len = 14;
            break;
//		case tipo_shpobj.POINTZ:
        case 11:
            len = 18;
            break;
//		case tipo_shpobj.MULTIPOINT:
        case 8:
            nv = this.nVertices;
            len = 20 + nv * 8;
            break;
//		case tipo_shpobj.MULTIPOINTM:
        case 28:
            nv = this.nVertices;
            len = 28 + nv * 12;
            break;
//		case tipo_shpobj.MULTIPOINTZ:
        case 18:
            nv = this.nVertices;
            len = 36 + nv * 16;
            break;
//		case tipo_shpobj.POLYLINE:
//		case tipo_shpobj.POLYGON:
        case 3:
        case 5:
            nv = this.nVertices;
            npart = this.nParts;
            len = 22 + npart * 2 + nv * 8;
            break;
//		case tipo_shpobj.POLYLINEM:
//		case tipo_shpobj.POLYGONM:
        case 23:
        case 25:
            nv = this.nVertices;
            npart = this.nParts;
            len = 30 + npart * 2 + nv * 12;
            break;
//		case tipo_shpobj.POLYLINEZ:
//		case tipo_shpobj.POLYGONZ:
        case 13:
        case 15:
            nv = this.nVertices;
            npart = this.nParts;
            len = 38 + npart * 2 + nv * 16;
            break;
        default:
            break;
        }
        this.lenght = len;
        return;
    }


/// <summary>
/// Calcola l'offset di un intervallo di uno shape object compreso tra m1 e m2
/// </summary>
    public SHPObject Offset(double offset, double m1, double m2) {
        SHPObject Ris;
        boolean trovato = false;
        SHPPoly poly = new SHPPoly();
        ArrayList tempvpoly = new ArrayList();
        int i, npart, nv;
        //
        // Non eseguo l'offset nel caso di POINT e MULTIPOINT (nparts = 0)
        //
        if (this.nParts == 0) {
            return null;
        }
        //
        // Cerca la poly nell'intervallo m1-m2 specificato
        //
        for (i = 0; i < this.nParts; i++) {
            poly = this.SHPGetPolyInPart2m(i, m1, m2);
            if (poly == null) {
                continue;
            }
            trovato = true;
            tempvpoly.add(poly);
        }
        if (!trovato) {
            return null;
        }

        SHPPoly[] vpoly = new SHPPoly[tempvpoly.size()];
        npart = tempvpoly.size();
        //
        // Eseguo l'offset sulle singole poly della lista
        //
        for (i = 0, nv = 0; i < npart; i++) {
            vpoly[i] = ((SHPPoly) tempvpoly.get(i)).SHPOffset(offset, m1, m2);
            if (vpoly[i] == null) {
                continue; // VV controllare
            }
            nv += vpoly[i].pnt.size();
            //System.GC.Collect();
        }
        Ris = new SHPObject(this.nSHPType, this.IsShapeNull, this.lenght,
                            this.nShapeId, npart, nv, vpoly);
        return Ris;
    }

/// <summary>
/// Restituisce la Poly npart dello shp object
/// </summary>
    public SHPPoly SHPGetPolyPart(int nPart) {
        try {
            return ((SHPPoly) (this.vpolilinee.get(nPart)));
        } catch (ArithmeticException e) {
            return null;
        }
    }

/// <summary>
/// Restituisce la poly tra i valori m1 e m2
/// </summary>
    public SHPPoly SHPGetPolyInPart2m(int nPart, double m1, double m2) {
        SHPPoly pol = this.SHPGetPolyPart(nPart).SHPGetPolyIn2m(m1, m2);
        pol.box = pol.SHPCalBox();
        return pol;
    }

/// <summary>
/// Restutuisce il nu. dei punti della npart-esima poly compresa tra m1 e m2
/// </summary>
/// <param name="nPart"></param>
/// <param name="m1"></param>
/// <param name="m2"></param>
/// <returns></returns>
    public long SHPGetNPointsInPart2m(int nPart, double m1, double m2) {
        SHPPoly pol = this.SHPGetPolyPart(nPart);
        pol.box = pol.SHPCalBox();
        return pol.SHPGetNPointsInPoly2m(m1, m2);
    }

/// <summary>
/// Restituisce il valore di m agli estremi della nPart-esima poly
/// </summary>
/// <param name="nPart"></param>
/// <param name="m1"></param> VV ref
/// <param name="m2"></param> VV ref
    public double[] SHPGet2m(int nPart) {
        SHPPoly pol = this.SHPGetPolyPart(nPart);
        double[] mMin_mMax = pol.SHPGet2m();
        return mMin_mMax;
    }

/// <summary>
/// Restituisce il nu. dei punti nella parte specificata
/// </summary>
/// <param name="nPart"></param>
/// <returns></returns>
    public int SHPGetNPointsInPart(int nPart) {
        SHPPoly pol = this.SHPGetPolyPart(nPart);
        return pol.pnt.size();
    }

/// <summary>
/// Restituisce il punto data la misura
/// </summary>
/// <param name="m">misura data</param>
/// <param name="pt">punto</param>
/// <returns>punto</returns>
    public SHPPoint[] SHPMGetPoint(double m) {
        ArrayList vpnt = new ArrayList();
        SHPPoint[] vpntres = null;
        SHPPoint pt = new SHPPoint();

        if (this.nSHPType != tipo_shpobj.POLYGONM &&
            this.nSHPType != tipo_shpobj.POLYLINEM &&
            this.nSHPType != tipo_shpobj.POLYLINEZ) {
            return null;
        }
        SHPPoly pol;
        double ang = 0.0, t = 0.0;
        int npoly = this.vpolilinee.size();
        for (int i = 0; i < npoly; i++) {
            pol = (SHPPoly)this.vpolilinee.get(i);
            if (pol.SHPcalpntm(m, pt, ang, t)) {
                vpnt.add(pt);
            }
        }
        if (vpnt.size() == 0) {
            return null;
        }
        vpntres = new SHPPoint[vpnt.size()];
        for (int i = 0; i < vpnt.size(); i++) {
            vpntres[i] = (SHPPoint) vpnt.get(i);
        }
        return vpntres;
    }

/// <summary>
/// Restituisce i punti sulla poly corrispondenti alla misura data
/// </summary>
/// <param name="m">misura data</param>
/// <param name="offset">offset di cui spostare i punti</param>
/// <returns>vettore di punti</returns>
    public SHPPoint[] SHPMGetPointOffset(double m, double offset) {
        if (this.nSHPType != tipo_shpobj.POLYGONM &&
            this.nSHPType != tipo_shpobj.POLYLINEM &&
            this.nSHPType != tipo_shpobj.POLYLINEZ) {
            return null;
        }
        int npoly = this.vpolilinee.size();
        SHPPoly pol;
        boolean res = false;
        int npt = 0;
        SHPPoint pt = new SHPPoint();

        ArrayList vpnt = new ArrayList();
        SHPPoint[] vpntres = null;

        for (int i = 0; i < npoly; i++) {
            pol = (SHPPoly)this.vpolilinee.get(i);
            res = pol.SHPcalpntoffsetm(m, offset, pt);
            if (!res) {
                continue;
            }
            vpnt.add(pt);
            npt++;
        }
        if (npt == 0) {
            return null;
        }
        vpntres = new SHPPoint[vpnt.size()];
        for (int i = 0; i < vpnt.size(); i++) {
            vpntres[i] = (SHPPoint) vpnt.get(i);
        }
        return vpntres;
    }

/// <summary>
/// Restituisce la misura dato il punto pt
/// </summary>
/// <param name="pt">punto</param>
/// <param name="lato">Lato del punto rispetto all'asse strada -1=sx 0=asse 1=dx</param> VV ref
/// <returns>misura</returns>
    public SHPprjptm SHPGetMeasure(SHPprjptm prjptm, int lato) {
        lato = 0;
        int npoly = this.vpolilinee.size();
        SHPPoly pol;
        int nint, npolymin = 0;
        SHPPoint ptprj = new SHPPoint();
        double tang, tval, dst;
        boolean find = false;
        double dmin = Double.MAX_VALUE;
        //
        // Cerco la parte di poly con la minima distanza dal punto pt dato
        //
        for (int i = 0; i < npoly; i++) {
            pol = (SHPPoly)this.vpolilinee.get(i);
            dst = pol.SHPdstptpr(prjptm.pto);
            if (dst < dmin) {
                find = true;
                dmin = dst;
                npolymin = i;
            }
        }
        if (!find) {
            return null;
        }
        pol = (SHPPoly)this.vpolilinee.get(npolymin);

        prjptm.lato = lato;
        prjptm.ptprj = ptprj;
        nint = pol.SHPprjptm(prjptm);
        return prjptm;
    }

/// <summary>
/// Restituisce la misura dato il punto pt
/// </summary>
/// <param name="pt">punto</param>
/// <param name="Offset">Offset dalla poly</param> VV ref
/// <returns>misura</returns>
    public SHPprjptm SHPGetMeasure(SHPprjptm prjptm, double Offset) {
        Offset = 0.0;
        /*if (this.nSHPType != tipo_shpobj.POLYGONM &&
            this.nSHPType != tipo_shpobj.POLYLINEM &&
            this.nSHPType != tipo_shpobj.POLYLINEZ) {
            return null;
        }*/
        int npoly = this.vpolilinee.size();
        SHPPoly pol;
        int nint, npolymin = 0;
        SHPPoint ptprj = new SHPPoint();
        double tang, tval, dst;
        boolean find = false;
        double dmin = Double.MAX_VALUE;
        //
        // Cerco la parte di poly con la minima distanza dal punto pt dato
        //
        for (int i = 0; i < npoly; i++) {
            pol = (SHPPoly)this.vpolilinee.get(i);
            dst = pol.SHPdstptpr(prjptm.pto);
            if (dst < dmin) {
                find = true;
                dmin = dst;
                npolymin = i;
            }
        }
        if (!find) {
            return null;
        }
        pol = (SHPPoly)this.vpolilinee.get(npolymin);

        prjptm.Offset = Offset;
        nint = pol.SHPprjptm(prjptm, Offset);
        return prjptm;
    }

/// <summary>
/// Restituisce la misura dato il punto pt
/// </summary>
/// <param name="pt">punto</param>
/// <returns>misura</returns>
    public SHPprjptm SHPGetMeasure(SHPPoint pt) {
        int lato = 0;
        SHPprjptm prjptm = new SHPprjptm();
        prjptm.pto = pt;
        prjptm.lato = lato;
        this.SHPGetMeasure(prjptm, lato);
        return prjptm;
    }


/// <summary>
/// Legge un oggetto di tipo punto
/// </summary>
/// <param name="nPart">n. di parte interessata</param>
/// <param name="RelativeIndex">indice del punto</param>
/// <returns>punto</returns>
    public SHPPoint SHPGetPoint(int nPart, int RelativeIndex) {
        if (nPart > this.vpolilinee.size()) {
            return null;
        }
        if (RelativeIndex >= ((SHPPoly) (this.vpolilinee.get(nPart))).pnt.size()) {
            return null;
        }
        SHPPoint pt = new SHPPoint();
        pt = (SHPPoint) (((SHPPoly) (this.vpolilinee.get(nPart))).pnt.get(
                RelativeIndex));
        return pt;
    }

/// <summary>
/// Calcola il box dell'oggetto
/// </summary>
    public void SHPCalBox() {
        SHPPoly pol;
        Box b = new Box(MConst.DOUBLEMAX, MConst.DOUBLEMIN);
        Box bpol;
        for (int i = 0; i < this.nParts; i++) {
            pol = this.SHPGetPolyPart(i);
            bpol = pol.SHPCalBox();
            b.SHPAggBox(bpol);
        }
        this.bbox = b;
        return;
    }

/// <summary>
/// Converte l'oggetto shape in un vettore di byte
/// </summary>
    /*
        public byte [] Convert_to_binary()
        {
     BinaryFormatter formatter = new BinaryFormatter();
     System.IO.MemoryStream stream = new System.IO.MemoryStream();
     formatter.Serialize(stream,this);
     byte [] vect = new byte [stream.Length];
     stream.Position =0;
     int res = stream.Read(vect,0,vect.Length);
     return vect;
     }
     */


/// <summary>
/// Legge l'oggetto hEntity dallo shapefile
/// </summary>
    public boolean SHPReadObject(CShapeFile shp, DataInputStream oip,
                                 int hEntity) {
        // VV long posizione = shp.fs_shp.Position;
        int i;
        SHPPoint pt;
        SHPPoly pol;
        SHPPoint[] vpnt;
        int[] iniparts;
        int[] vnpt;
        SHPPoly[] vpoly;

        try {
            this.nSHPType = shp.leggi_tipo(oip);

            if (this.nSHPType == tipo_shpobj.NULLSHAPE) {
                this.vpolilinee = null;
                this.IsShapeNull = true;

                return true;
            }
            if (this.nSHPType != shp.SHPType) {
                return false;
            }

            switch (this.nSHPType) {
//		case tipo_shpobj.POINT:
//		case tipo_shpobj.POINTM:
//		case tipo_shpobj.POINTZ:
            case 1:
            case 11:
            case 21:
                pol = new SHPPoly();
                this.nVertices = 1;
                pt = new SHPPoint();
                pt.x = shp.SwapDouble(oip.readDouble());
                pt.y = shp.SwapDouble(oip.readDouble());

                if (this.nSHPType == tipo_shpobj.POINTM ||
                    this.nSHPType == tipo_shpobj.POINTZ) {
                    if (this.nSHPType == tipo_shpobj.POINTZ) {
                        pt.z = shp.SwapDouble(oip.readDouble());
                        this.bbox.zmin = pt.z - MConst.TOLL;
                        this.bbox.zmax = pt.z + MConst.TOLL;
                    }
                    if (this.lenght > 14) { // c'e' scritta anche la m.
                        pt.m = MConst.nodata_in(shp.SwapDouble(oip.readDouble()));
                        this.bbox.mmin = MConst.nodata_in(pt.m - MConst.TOLL);
                        this.bbox.mmax = MConst.nodata_in(pt.m + MConst.TOLL);
                    }
                }
                pol.SHPAddPoint(pt);
                this.AddPoly(pol);
                this.nParts = 0;
                this.bbox.xmin = pt.x - MConst.TOLL;
                this.bbox.ymin = pt.y - MConst.TOLL;
                this.bbox.xmax = pt.x + MConst.TOLL;
                this.bbox.ymax = pt.y + MConst.TOLL;
                break;

//		case tipo_shpobj.MULTIPOINT:
//		case tipo_shpobj.MULTIPOINTM:
//		case tipo_shpobj.MULTIPOINTZ:
            case 8:
            case 18:
            case 28:
                pol = new SHPPoly();
                this.bbox.xmin = shp.SwapDouble(oip.readDouble()); // leggo il box
                this.bbox.ymin = shp.SwapDouble(oip.readDouble());
                this.bbox.xmax = shp.SwapDouble(oip.readDouble());
                this.bbox.ymax = shp.SwapDouble(oip.readDouble());
                nVertices = shp.SwapInt(oip.readInt());
                if (nVertices > 0) {
                    vnpt = new int[nVertices];
                    vpnt = new SHPPoint[nVertices];
                } else {
                    this.IsShapeNull = true;
                    vnpt = null;
                    vpnt = null;
                    this.vpolilinee = null;
                }
                for (i = 0; i < nVertices; i++) {
                    pt = new SHPPoint();
                    pt.x = shp.SwapDouble(oip.readDouble());
                    pt.y = shp.SwapDouble(oip.readDouble());
                    vpnt[i] = pt;
                }
                if (this.nSHPType == tipo_shpobj.MULTIPOINTM ||
                    this.nSHPType == tipo_shpobj.MULTIPOINTZ) {
                    if (this.nSHPType == tipo_shpobj.MULTIPOINTZ) {
                        this.bbox.zmin = shp.SwapDouble(oip.readDouble());
                        this.bbox.zmax = shp.SwapDouble(oip.readDouble());
                        for (i = 0; i < nVertices; i++) {
                            vpnt[i].z = shp.SwapDouble(oip.readDouble());
                        }
                    }
                    if (this.lenght > (28 + this.nVertices * 12))
                    // ci sono scritte anche le m
                    {
                        this.bbox.mmin = MConst.nodata_in(shp.SwapDouble(oip.readDouble()));
                        this.bbox.mmax = MConst.nodata_in(shp.SwapDouble(oip.readDouble()));
                        for (i = 0; i < nVertices; i++) {
                            vpnt[i].m = MConst.nodata_in(shp.SwapDouble(oip.readDouble()));
                        }
                    }
                }
                if (nVertices > 0) {
                    pol.SHPAddPoints(nVertices, vpnt);
                    this.AddPoly(pol);
                }
                this.nParts = 0;
                break;

//		case tipo_shpobj.POLYLINE:
//		case tipo_shpobj.POLYGON:
//		case tipo_shpobj.POLYLINEM:
//		case tipo_shpobj.POLYGONM:
//		case tipo_shpobj.POLYLINEZ:
//		case tipo_shpobj.POLYGONZ:
            case 3:
            case 13:
            case 23:
            case 5:
            case 15:
            case 25:
                this.bbox.xmin = shp.SwapDouble(oip.readDouble()); // leggo il box
                this.bbox.ymin = shp.SwapDouble(oip.readDouble());
                this.bbox.xmax = shp.SwapDouble(oip.readDouble());
                this.bbox.ymax = shp.SwapDouble(oip.readDouble());
                this.nParts = this.SwapInt(oip.readInt());
                this.nVertices = shp.SwapInt(oip.readInt()); //MMM si fa il contrario in java

                if (nVertices > 0) {
                    vpnt = new SHPPoint[nVertices];
                    iniparts = new int[nParts];
                    vnpt = new int[nParts];
                    vpoly = new SHPPoly[nParts];
                    //
                    // Legge l'indice del primo punto della parte
                    //
                    for (i = 0; i < nParts; i++) {
                        iniparts[i] = this.SwapInt(oip.readInt()); //MMM si fa il contrario in java
                        if (i > 0) {
                            vnpt[i - 1] = iniparts[i] - iniparts[i - 1];
                        }
                    }
                    vnpt[nParts - 1] = nVertices - iniparts[nParts - 1]; // n. dei punti di ogni parte
                } else { // poly nulla che memorizzo come IsShapeNull = true
                    this.IsShapeNull = true;
                    vnpt = null;
                    vpnt = null;
                    iniparts = null;
                    vpoly = null;
                    this.vpolilinee = null;
                }
                for (i = 0; i < nVertices; i++) {
                    pt = new SHPPoint();
                    pt.x = shp.SwapDouble(oip.readDouble());
                    pt.y = shp.SwapDouble(oip.readDouble());
                    vpnt[i] = pt;
                }

                if (this.nSHPType == tipo_shpobj.POLYLINEM ||
                    this.nSHPType == tipo_shpobj.POLYGONM ||
                    this.nSHPType == tipo_shpobj.POLYLINEZ ||
                    this.nSHPType == tipo_shpobj.POLYGONZ) {
                    if (this.nSHPType == tipo_shpobj.POLYLINEZ ||
                        this.nSHPType == tipo_shpobj.POLYGONZ) {
                        this.bbox.zmin = shp.SwapDouble(oip.readDouble());;
                        this.bbox.zmax = shp.SwapDouble(oip.readDouble());;
                        for (i = 0; i < nVertices; i++) {
                            vpnt[i].z = shp.SwapDouble(oip.readDouble());;
                        }
                    }
                    if (this.lenght >
                        (30 + this.nParts * 2 + this.nVertices * 12))
                    // ci sono scritte anche le m
                    {
                        this.bbox.mmin = MConst.nodata_in(shp.SwapDouble(oip.readDouble()));
                        this.bbox.mmax = MConst.nodata_in(shp.SwapDouble(oip.readDouble()));
                        for (i = 0; i < nVertices; i++) {
                            vpnt[i].m = MConst.nodata_in(shp.SwapDouble(oip.readDouble()));
                        }
                    }
                }

                for (i = 0; i < nParts; i++) {
                    pol = new SHPPoly();
                    for (int k = 0; k < vnpt[i]; k++) {
                        pol.SHPAddPoint(vpnt[iniparts[i] + k]);
                    }
                    this.vpolilinee.add(pol);
                }
                break;
            default:
                return false;
            }
        } catch (IOException e) {

            return false;
        }
        return true;
    }


    /// <summary>
/// Scrive l'oggetto hEntity nello shapefile
/// </summary>
    public boolean SHPWriteObject(CShapeFile shp, DataOutputStream oos,
                                  int hEntity, SHPObject shpobj) {
        int tipo = shpobj.nSHPType;
        int i, j, ini, npt;
        SHPPoint pt;
        double dm;

        //lun = psObject->nVertices * 4 * sizeof(double) + psObject->nParts * 8 + 128;

        try {
            oos.writeInt(SwapInt(tipo));
            if (tipo == tipo_shpobj.NULLSHAPE) {
                return true;
            }
            switch (tipo) {
            case 1:
            case 11:
            case 21:
                pt = (SHPPoint) (((SHPPoly) (shpobj.vpolilinee.get(0))).pnt.get(
                        0));
                oos.writeDouble(SwapDouble(pt.x));
                oos.writeDouble(SwapDouble(pt.y));
                if (tipo == tipo_shpobj.POINTM || tipo == tipo_shpobj.POINTZ) {
                    if (tipo == tipo_shpobj.POINTZ) {
                        oos.writeDouble(SwapDouble(pt.z));
                    }
                    dm = MConst.nodata_out(pt.m);
                    oos.writeDouble(SwapDouble(dm));
                }
                break;

            case 8:
            case 18:
            case 28:
                oos.writeDouble(SwapDouble(shpobj.bbox.xmin));
                oos.writeDouble(SwapDouble(shpobj.bbox.ymin));
                oos.writeDouble(SwapDouble(shpobj.bbox.xmax));
                oos.writeDouble(SwapDouble(shpobj.bbox.ymax));
                oos.writeInt(SwapInt(shpobj.nVertices));
                for (i = 0; i < shpobj.nVertices; i++) {
                    pt = (SHPPoint) (((SHPPoly) (shpobj.vpolilinee.get(0)))).
                         pnt.get(i);
                    oos.writeDouble(SwapDouble(pt.x));
                    oos.writeDouble(SwapDouble(pt.y));
                }
                if (tipo == tipo_shpobj.MULTIPOINTM ||
                    tipo == tipo_shpobj.MULTIPOINTZ) {
                    if (tipo == tipo_shpobj.MULTIPOINTZ) {
                        oos.writeDouble(SwapDouble(shpobj.bbox.zmin));
                        oos.writeDouble(SwapDouble(shpobj.bbox.zmax));
                        for (i = 0; i < shpobj.nVertices; i++) {
                            pt = (SHPPoint) ((((SHPPoly) (shpobj.vpolilinee.get(
                                    0)))).pnt.get(i));
                            oos.writeDouble(SwapDouble(pt.z));
                        }
                    }
                    dm = MConst.nodata_out(shpobj.bbox.mmin);
                    oos.writeDouble(SwapDouble(dm));
                    dm = MConst.nodata_out(shpobj.bbox.mmax);
                    oos.writeDouble(SwapDouble(dm));
                    for (i = 0; i < shpobj.nVertices; i++) {
                        pt = (SHPPoint) ((((SHPPoly) (shpobj.vpolilinee.get(0)))).
                                         pnt.get(i));
                        dm = MConst.nodata_out(pt.m);
                        oos.writeDouble(SwapDouble(dm));
                    }
                }
                break;

            case 3:
            case 5:
            case 13:
            case 15:
            case 23:
            case 25:
                oos.writeDouble(SwapDouble(shpobj.bbox.xmin));
                oos.writeDouble(SwapDouble(shpobj.bbox.ymin));
                oos.writeDouble(SwapDouble(shpobj.bbox.xmax));
                oos.writeDouble(SwapDouble(shpobj.bbox.ymax));

                oos.writeInt(SwapInt(shpobj.nParts)); // nu. delle parti
                oos.writeInt(SwapInt(shpobj.nVertices)); // nu. totale dei punti

                for (i = 0, ini = 0; i < shpobj.nParts; i++) { // scrive l'indice del primo punto nella parte
                    oos.writeInt(SwapInt(ini));
                    ini += ((SHPPoly) (shpobj.vpolilinee.get(i))).pnt.size();
                }
                for (i = 0; i < shpobj.nParts; i++) { // scrivo i punti
                    npt = ((SHPPoly) (shpobj.vpolilinee.get(i))).pnt.size();
                    for (j = 0; j < npt; j++) {
                        pt = (SHPPoint) ((((SHPPoly) (shpobj.vpolilinee.get(i)))).
                                         pnt.get(j));
                        oos.writeDouble(SwapDouble(pt.x));
                        oos.writeDouble(SwapDouble(pt.y));
                    }
                }
                if (tipo == tipo_shpobj.POLYLINEM ||
                    tipo == tipo_shpobj.POLYGONM ||
                    tipo == tipo_shpobj.POLYLINEZ ||
                    tipo == tipo_shpobj.POLYGONZ) {
                    if (tipo == tipo_shpobj.POLYLINEZ ||
                        tipo == tipo_shpobj.POLYGONZ) {
                        oos.writeDouble(SwapDouble(shpobj.bbox.zmin));
                        oos.writeDouble(SwapDouble(shpobj.bbox.zmax));
                        for (i = 0; i < shpobj.nParts; i++) { // scrivo i punti
                            npt = ((SHPPoly) (shpobj.vpolilinee.get(i))).pnt.
                                  size();
                            for (j = 0; j < npt; j++) {
                                pt = (SHPPoint) ((((SHPPoly) (shpobj.vpolilinee.
                                        get(i)))).pnt.get(j));
                                oos.writeDouble(SwapDouble(pt.z));
                            }
                        }
                    }
                    dm = MConst.nodata_out(shpobj.bbox.mmin);
                    oos.writeDouble(SwapDouble(dm));
                    dm = MConst.nodata_out(shpobj.bbox.mmax);
                    oos.writeDouble(SwapDouble(dm));
                    for (i = 0; i < shpobj.nParts; i++) { // scrivo i punti
                        npt = ((SHPPoly) (shpobj.vpolilinee.get(i))).pnt.size();
                        for (j = 0; j < npt; j++) {
                            pt = (SHPPoint) (this.SHPGetPolyPart(i).pnt.get(j));
                            dm = MConst.nodata_out(pt.m);
                            oos.writeDouble(SwapDouble(dm));
                        }
                    }
                }
                break;

            default:
                return false;
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

}
