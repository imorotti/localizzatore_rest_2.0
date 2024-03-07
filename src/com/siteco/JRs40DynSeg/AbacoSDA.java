package com.siteco.JRs40DynSeg;

import java.util.*;
import java.io.*;
import java.sql.*;


public class AbacoSDA extends SHPObject {
    /// <summary>
    /// lunghezza in byte dell'oggetto
    /// </summary>
    public int length;
    /// <summary>
    /// dimensione della geometria
    /// </summary>
    public int dims;

    /// <summary>
    /// tipo SDA
    /// </summary>
    public int tipoSDA;

    //variabili private
    ByteArrayInputStream bais;
    boolean SDA_null = true;


    /// <summary>
    /// costruttore che crea un oggetto AbacoSDA a partire dall'array di byte ricavato
    /// dalla lettura del dato binario dal db
    /// </summary>
    /// <param name="geometria">array di byte ricavato
    /// dalla lettura del dato binario dal db </param>
    public AbacoSDA(byte[] geometria) {
        bais = new ByteArrayInputStream(geometria);
        SDA_null = false;

        DataInputStream dis = new DataInputStream(bais);
        this.vpolilinee = new ArrayList();

        this.nVertices = 0;
        this.nParts = 0;

        this.bbox = new Box();
        SHPPoly pol;
        SHPPoint pt;
        int[] pointsPerPart;
        length = geometria.length;


        try {
            //leggo il Boundary Box definito nell'SDA
            bbox.xmin = dis.readDouble();
            bbox.ymin = dis.readDouble();
            bbox.xmax = dis.readDouble();
            bbox.ymax = dis.readDouble();

            //leggo il tipo
            tipoSDA = dis.readInt();

            //leggo il numero di dimensioni
            this.dims = dis.readInt();

            //leggo le geometrie
            switch (tipoSDA) {
            //point
            case 1:
                this.nParts = 1;
                this.nVertices = 1;

                pol = new SHPPoly();
                pt = new SHPPoint();
                pt.x = dis.readDouble();
                pt.y = dis.readDouble();

                /*this.bbox.xmin = pt.x - MConst.TOLL;
                 this.bbox.ymin = pt.y - MConst.TOLL;
                 this.bbox.xmax = pt.x + MConst.TOLL;
                 this.bbox.ymax = pt.y + MConst.TOLL;*/

                //se ho anche la z
                if (dims == 3) {
                    pt.z = dis.readDouble();
                    /*this.bbox.zmin = pt.z - MConst.TOLL;
                     this.bbox.zmax = pt.z + MConst.TOLL;*/
                }

                //se ho z e m
                if (dims == 4) { // c'e' scritta anche la m.
                    pt.z = dis.readDouble();
                    pt.m = dis.readDouble();
                    /*this.bbox.zmin = MConst.nodata_in(pt.z - MConst.TOLL);
                     this.bbox.zmax = MConst.nodata_in(pt.z + MConst.TOLL);
                     this.bbox.mmin = MConst.nodata_in(pt.m - MConst.TOLL);
                     this.bbox.mmax = MConst.nodata_in(pt.m + MConst.TOLL);*/
                }

                pol.SHPAddPoint(pt);
                this.AddPoly(pol);
                this.nParts = 0;
                break;

                //arc
            case 3:

                //numero di parti
                nParts = dis.readInt();

                //numero di punti/vertici
                nVertices = dis.readInt();

                //vettore di punti per parte
                pointsPerPart = new int[nParts];
                for (int i = 0; i < nParts; i++) {
                    pointsPerPart[i] = dis.readInt();
                }

                //se ho 2 dimensioni
                if (dims == 2) {
                    for (int k = 0; k < nParts; k++) {
                        pol = new SHPPoly();
                        for (int i = 0; i < pointsPerPart[k]; i++) {
                            pt = new SHPPoint();
                            pt.x = dis.readDouble();
                            pt.y = dis.readDouble();
                            pol.SHPAddPoint(pt);
                        }
                        vpolilinee.add(pol);
                    }

                    //this.bbox.zmin = pt.z - MConst.TOLL;
                    //this.bbox.zmax = pt.z + MConst.TOLL;
                }

                //se ho 3 dimensioni
                if (dims == 3) {
                    for (int k = 0; k < nParts; k++) {
                        pol = new SHPPoly();
                        for (int i = 0; i < pointsPerPart[k]; i++) {
                            pt = new SHPPoint();
                            pt.x = dis.readDouble();
                            pt.y = dis.readDouble();
                            pt.z = dis.readDouble();
                            pol.SHPAddPoint(pt);
                        }
                        vpolilinee.add(pol);
                    }

                    //this.bbox.zmin = pt.z - MConst.TOLL;
                    //this.bbox.zmax = pt.z + MConst.TOLL;
                }

                //se ho 4 dimensioni
                if (dims == 4) {
                    for (int k = 0; k < nParts; k++) {
                        pol = new SHPPoly();
                        for (int i = 0; i < pointsPerPart[k]; i++) {
                            pt = new SHPPoint();
                            pt.x = dis.readDouble();
                            pt.y = dis.readDouble();
                            pt.z = dis.readDouble();
                            pt.m = dis.readDouble();
                            pol.SHPAddPoint(pt);
                        }
                        vpolilinee.add(pol);
                    }

                    //this.bbox.zmin = pt.z - MConst.TOLL;
                    //this.bbox.zmax = pt.z + MConst.TOLL;
                }
                break;

                //polygon
            case 5:
                nParts = dis.readInt();
                nVertices = dis.readInt();

                pointsPerPart = new int[nParts];
                for (int i = 0; i < nParts; i++) {
                    pointsPerPart[i] = dis.readInt();
                }

                //se ho 2 dimensioni
                if (dims == 2) {
                    for (int k = 0; k < nParts; k++) {
                        pol = new SHPPoly();
                        for (int i = 0; i < pointsPerPart[k]; i++) {
                            pt = new SHPPoint();
                            pt.x = dis.readDouble();
                            pt.y = dis.readDouble();
                            pol.SHPAddPoint(pt);
                        }
                        vpolilinee.add(pol);
                    }

                    //this.bbox.zmin = pt.z - MConst.TOLL;
                    //this.bbox.zmax = pt.z + MConst.TOLL;
                }

                //se ho 3 dimensioni
                if (dims == 3) {
                    for (int k = 0; k < nParts; k++) {
                        pol = new SHPPoly();
                        for (int i = 0; i < pointsPerPart[k]; i++) {
                            pt = new SHPPoint();
                            pt.x = dis.readDouble();
                            pt.y = dis.readDouble();
                            pt.z = dis.readDouble();
                            pol.SHPAddPoint(pt);
                        }
                        vpolilinee.add(pol);
                    }

                    //this.bbox.zmin = pt.z - MConst.TOLL;
                    //this.bbox.zmax = pt.z + MConst.TOLL;
                }

                //se ho 4 dimensioni
                if (dims == 4) {
                    for (int k = 0; k < nParts; k++) {
                        pol = new SHPPoly();
                        for (int i = 0; i < pointsPerPart[k]; i++) {
                            pt = new SHPPoint();
                            pt.x = dis.readDouble();
                            pt.y = dis.readDouble();
                            pt.z = dis.readDouble();
                            pt.m = dis.readDouble();
                            pol.SHPAddPoint(pt);
                        }
                        vpolilinee.add(pol);
                    }

                    //this.bbox.zmin = pt.z - MConst.TOLL;
                    //this.bbox.zmax = pt.z + MConst.TOLL;
                }
                break;

                //multipoint
            case 8:
                pol = new SHPPoly();
                this.nVertices = dis.readInt();
                this.nParts = this.nVertices;

                int nPoints = this.nVertices;

                for (int k = 0; k < nPoints; k++) {
                    //se ho 2 dimensioni
                    if (dims == 2) {
                        pol = new SHPPoly();

                        pt = new SHPPoint();
                        pt.x = dis.readDouble();
                        pt.y = dis.readDouble();
                        pol.SHPAddPoint(pt);

                        vpolilinee.add(pol);
                        //this.bbox.zmin = pt.z - MConst.TOLL;
                        //this.bbox.zmax = pt.z + MConst.TOLL;
                    }

                    //se ho 3 dimensioni
                    if (dims == 3) {
                        pol = new SHPPoly();

                        pt = new SHPPoint();
                        pt.x = dis.readDouble();
                        pt.y = dis.readDouble();
                        pt.z = dis.readDouble();
                        pol.SHPAddPoint(pt);

                        vpolilinee.add(pol);
                        //this.bbox.zmin = pt.z - MConst.TOLL;
                        //this.bbox.zmax = pt.z + MConst.TOLL;
                    }

                    //se ho 4 dimensioni
                    if (dims == 4) {
                        pol = new SHPPoly();

                        pt = new SHPPoint();
                        pt.x = dis.readDouble();
                        pt.y = dis.readDouble();
                        pt.z = dis.readDouble();
                        pt.m = dis.readDouble();
                        pol.SHPAddPoint(pt);

                        vpolilinee.add(pol);
                        //this.bbox.zmin = pt.z - MConst.TOLL;
                        //this.bbox.zmax = pt.z + MConst.TOLL;
                    }
                }
                break;
            default:
                break;
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    /// <summary>
    /// costruttore che crea un oggetto AbacoSDA a partire da tutte
    /// le informazioni base sulla geometria
    /// </summary>
    /// <param name="tipo">tipo della geometria: 1=point; 3=arc;
    /// <param name="dims">diemnsioni dell'oggetto</param>
    /// 5=polygon; 8=multipolygon</param>
    /// <param name="nparti">numero di parti di cui e' composta la geometria</param>
    /// <param name="nvert">numero totale di punti/vertici</param>
    /// <param name="vpol">array di SHPPoly della dimensione di nparti; ogni
    /// oggetto dell'array corrisponde ad una parte della geometria</param>
    public AbacoSDA(int tipo, int dims, int nparti, int nvert, SHPPoly[] vpol,
                    Box bb) {
        SDA_null = false;
        this.dims = dims;
        this.bbox = new Box();
        this.nVertices = nvert;
        this.nParts = nparti;
        this.tipoSDA = tipo;
        this.bbox.mmin = bb.mmin;
        this.bbox.mmax = bb.mmax;
        this.bbox.xmin = bb.xmin;
        this.bbox.ymin = bb.ymin;
        this.bbox.zmin = bb.zmin;
        this.bbox.xmax = bb.xmax;
        this.bbox.ymax = bb.ymax;
        this.bbox.zmax = bb.zmax;
        if (vpol != null) {
            for (int i = 0; i < vpol.length; i++) {
                this.vpolilinee.set(i, new SHPPoly((SHPPoly) vpol[i]));
            }
        }
        SHPCalLenght();
    }

    /// <summary>
    /// costruttore che crea un oggetto AbacoSDA a partire da tutte
    /// le informazioni base sulla geometria
    /// </summary>
    /// <param name="tipo">tipo della geometria: 1=point; 3=arc;
    /// <param name="dims">diemnsioni dell'oggetto</param>
    /// 5=polygon; 8=multipolygon</param>
    /// <param name="nparti">numero di parti di cui e' composta la geometria</param>
    /// <param name="nvert">numero totale di punti/vertici</param>
    /// <param name="vpol">array di SHPPoly della dimensione di nparti; ogni
    /// oggetto dell'array corrisponde ad una parte della geometria</param>
    public AbacoSDA(int tipo, int dims, int nparti, int nvert, SHPPoly[] vpol) {
        SDA_null = false;
        this.dims = dims;
        this.bbox = new Box();
        this.nVertices = nvert;
        this.nParts = nparti;
        this.tipoSDA = tipo;
        if (vpol != null) {
            for (int i = 0; i < vpol.length; i++) {
                this.vpolilinee.set(i, new SHPPoly((SHPPoly) vpol[i]));
            }
        }
        SHPCalLenght();
        SHPCalBox();
    }


    public byte[] getSDABytes() {
        //array di byte della lunghezza dell'oggetto SDA che corrispondera'
        //al formato binario SDA e che verra' restituito dalla funzione
        byte[] bytesSDA = new byte[this.length];

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);

        //variabili temporanee locali
        byte[] byteTemp;
        ArrayList alTemp;
        int indice = 0;

        try {
            //memorizzo le coordinate del boundary box
            dos.writeDouble(this.bbox.xmin);
            dos.writeDouble(this.bbox.ymin);
            dos.writeDouble(this.bbox.xmax);
            dos.writeDouble(this.bbox.ymax);

            //memorizzo il tipo
            dos.writeInt(this.tipoSDA);

            //memorizzo il numero di dimensioni
            dos.writeInt(this.dims);

            //memorizzo le coordinate
            double x, y, z, m;
            int nP, nV, pPP;
            SHPPoint pt;
            SHPPoly pol;

            switch (this.tipoSDA) {
            //point
            case 1:
                pol = (SHPPoly) vpolilinee.get(0);
                pt = (SHPPoint) pol.pnt.get(0);

                dos.writeDouble(pt.x);

                dos.writeDouble(pt.y);

                //se il punto ha 3 dimensioni
                if (this.dims == 3) {
                    dos.writeDouble(pt.z);
                }

                //se il punto ha 4 dimensioni
                if (this.dims == 4) {
                   dos.writeDouble(pt.z);
                   dos.writeDouble(pt.m);
                }
                break;

                //arc
            case 3:

                //numero di parti
                dos.writeInt(this.nParts);

                //numero di punti/vertici
                dos.writeInt(this.nVertices);

                //memorizzo il numero di punti per parte
                for (int i = 0; i < this.vpolilinee.size(); i++) {
                    pPP = ((SHPPoly) vpolilinee.get(i)).pnt.size();
                    dos.writeInt(pPP);
                }

                //memorizzo le coordinate dei punti
                for (int i = 0; i < this.vpolilinee.size(); i++) {
                    pol = (SHPPoly) vpolilinee.get(i);

                    if (this.dims == 2) {
                        for (int k = 0; k < pol.pnt.size(); k++) {
                            pt = (SHPPoint) pol.pnt.get(k);

                            dos.writeDouble(pt.x);
                            dos.writeDouble(pt.y);
                        }
                    }

                    if (this.dims == 3) {
                        for (int k = 0; k < pol.pnt.size(); k++) {
                            pt = (SHPPoint) pol.pnt.get(k);

                            dos.writeDouble(pt.x);
                            dos.writeDouble(pt.y);
                            dos.writeDouble(pt.z);
                        }
                    }

                    if (this.dims == 4) {
                        for (int k = 0; k < pol.pnt.size(); k++) {
                            pt = (SHPPoint) pol.pnt.get(k);

                            dos.writeDouble(pt.x);
                            dos.writeDouble(pt.y);
                            dos.writeDouble(pt.z);
                            dos.writeDouble(pt.m);
                        }
                    }
                }

                break;

                //polygon
            case 5:

                //numero di parti
                dos.writeInt(this.nParts);

                //numero di punti/vertici
                dos.writeInt(this.nVertices);

                //memorizzo il numero di punti per parte
                for (int i = 0; i < this.vpolilinee.size(); i++) {
                    pPP = ((SHPPoly) vpolilinee.get(i)).pnt.size();
                    dos.writeInt(pPP);
                }

                //memorizzo le coordinate dei punti
                for (int i = 0; i < this.vpolilinee.size(); i++) {
                    pol = (SHPPoly) vpolilinee.get(i);

                    if (this.dims == 2) {
                        for (int k = 0; k < pol.pnt.size(); k++) {
                            pt = (SHPPoint) pol.pnt.get(k);

                            dos.writeDouble(pt.x);
                            dos.writeDouble(pt.y);
                        }
                    }

                    if (this.dims == 3) {
                        for (int k = 0; k < pol.pnt.size(); k++) {
                            pt = (SHPPoint) pol.pnt.get(k);

                            dos.writeDouble(pt.x);
                            dos.writeDouble(pt.y);
                            dos.writeDouble(pt.z);
                        }
                    }

                    if (this.dims == 4) {
                        for (int k = 0; k < pol.pnt.size(); k++) {
                            pt = (SHPPoint) pol.pnt.get(k);

                            dos.writeDouble(pt.x);
                            dos.writeDouble(pt.y);
                            dos.writeDouble(pt.z);
                            dos.writeDouble(pt.m);

                        }
                    }
                }
                break;

                //multipoint
            case 8:

                //memorizzo il numero di punti
                dos.writeInt(this.nVertices);

                //memorizzo le coordinate dei punti
                for (int i = 0; i < this.vpolilinee.size(); i++) {
                    pol = (SHPPoly) vpolilinee.get(i);

                    if (this.dims == 2) {
                        for (int k = 0; k < pol.pnt.size(); k++) {
                            pt = (SHPPoint) pol.pnt.get(k);

                            dos.writeDouble(pt.x);
                            dos.writeDouble(pt.y);
                        }
                    }

                    if (this.dims == 3) {
                        for (int k = 0; k < pol.pnt.size(); k++) {
                            pt = (SHPPoint) pol.pnt.get(k);

                            dos.writeDouble(pt.x);
                            dos.writeDouble(pt.y);
                            dos.writeDouble(pt.z);
                        }
                    }

                    if (this.dims == 4) {
                        for (int k = 0; k < pol.pnt.size(); k++) {
                            pt = (SHPPoint) pol.pnt.get(i);

                            dos.writeDouble(pt.x);
                            dos.writeDouble(pt.y);
                            dos.writeDouble(pt.z);
                            dos.writeDouble(pt.m);
                        }
                    }
                }
                break;
            default:
                break;
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return bytesSDA;
    }

    /// <summary>
    /// trasforma la codifica del double da littleEndian a bigEndian
    /// </summary>
    /// <param name="d">il duoble a cui cambiare la codifica</param>
    /// <returns>il double con codifica modificata</returns>
    /*public static double invertIndianDouble(double d) {
        byte[] dArray = BitConverter.GetBytes(d);
        Array.Reverse(dArray);
        d = BitConverter.ToDouble(dArray, 0);
        return d;
    }*/


    /// <summary>
    /// trasforma la codifica dell'integer da littleEndian a bigEndian
    /// </summary>
    /// <param name="i">l'integer a cui cambiare la codifica</param>
    /// <returns>l'integer con codifica modificata</returns>
    /*public static int invertIndianInt(int i) {
        byte[] dArray = BitConverter.GetBytes(i);
        Array.Reverse(dArray);
        i = BitConverter.ToInt32(dArray, 0);
        return i;
    }*/


    /// <summary>
    /// calcola la lunghezza in byte nella geometria
    /// </summary>
    /// <returns>la lunghezza in byte nella geometria</returns>
    public void SHPCalLenght() {

        switch (tipoSDA) {
        //point
        case 1:
            this.length = 40 + 8 * dims;
            break;

            //arc
        case 3:
            this.length = 48 + 4 * nParts + 8 * nVertices * dims;
            break;

            //polygon
        case 5:
            this.length = 48 + 4 * nParts + 8 * nVertices * dims;
            break;

            //multipoint
        case 8:
            this.length = 44 + 8 * nVertices * dims;
            break;
        default:
            break;
        }
    }


    /// <summary>
    /// Calcola l'offset di un intervallo di uno shape object compreso tra m1 e m2
    /// </summary>
    public AbacoSDA Offset(double offset, double m1, double m2) {
        AbacoSDA Ris;
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
            System.gc();
        }
        Ris = new AbacoSDA(3, dims, npart, nv, vpoly);
        return Ris;
    }


    /// <summary>
    /// Restituisce i punti sulla poly corrispondenti alla misura data
    /// </summary>
    /// <param name="m">misura data</param>
    /// <param name="offset">offset di cui spostare i punti</param>
    /// <returns>vettore di punti</returns>
    public SHPPoint[] SHPMGetPointOffset(double m, double offset) {
        if (this.tipoSDA != 3 && this.dims < 3) {
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
    /// <param name="lato">Lato del punto rispetto all'asse strada -1=sx 0=asse 1=dx</param>
    /// <returns>misura</returns>
    public double SHPGetMeasure(SHPPoint pt, int lato) {
        lato = 0;
        if (this.tipoSDA != 3 && this.dims < 3) {
            return Double.NaN;
        }
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
            dst = pol.SHPdstptpr(pt);
            if (dst < dmin) {
                find = true;
                dmin = dst;
                npolymin = i;
            }
        }
        if (!find) {
            return Double.NaN;
        }
        pol = (SHPPoly)this.vpolilinee.get(npolymin);

        SHPprjptm prjptm = new SHPprjptm();
        prjptm.pto = pt;
        prjptm.ptprj = ptprj;
        prjptm.lato = lato;
        nint = pol.SHPprjptm(prjptm,
                             lato);
        return prjptm.mval;
    }


    /// <summary>
    /// Restituisce la misura dato il punto pt
    /// </summary>
    /// <param name="pt">punto</param>
    /// <param name="Offset">Offset dalla poly</param>
    /// <returns>misura</returns>
    public double SHPGetMeasure(SHPPoint pt, double Offset) {
        Offset = 0.0;
        if (this.tipoSDA != 3 && this.dims < 3) {
            return Double.NaN;
        }
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
            dst = pol.SHPdstptpr(pt);
            if (dst < dmin) {
                find = true;
                dmin = dst;
                npolymin = i;
            }
        }
        if (!find) {
            return Double.NaN;
        }
        pol = (SHPPoly)this.vpolilinee.get(npolymin);

        SHPprjptm prjptm = new SHPprjptm();
        prjptm.pto = pt;
        prjptm.ptprj = ptprj;
        prjptm.Offset = Offset;

        nint = pol.SHPprjptm(prjptm, Offset);
        return prjptm.mval;
    }


    /// <summary>
    /// Verifica che l'oggetto geometrico sia nullo o meno
    /// controllando se la lunghezza in byte e' uguale a 0,
    /// se l'array delle parti e' nullo e
    /// se il numero di punti memorizzati nell'array delle parti
    /// e' uguale a zero.
    /// </summary>
    /// <returns></returns>
    public boolean IsShapeNull() {
        if (this.length == 0 || this.vpolilinee == null
            || this.vpolilinee.size() == 0
                ) {
            return true;
        } else {
            return false;
        }
    }


    /// <summary>
    /// Ritorna un oggetto AbacoSDA data la connessione, la tabella,
    /// il campo della geometria, la chiave e il campo chiave
    /// </summary>
    /// <param name="Conn"></param>
    /// <param name="Table"></param>
    /// <param name="KeyField"></param>
    /// <returns></returns>
    public static AbacoSDA SelectObject(Connection Conn, String TableName,
                                        String ShapeField, String KeyField,
                                        String Key) {
        try {
            AbacoSDA shpobj = null;

            if (Conn == null) return null;
            if (Conn.isClosed()) return null;

            String query = "SELECT " + ShapeField +
                    " FROM " + TableName + " WHERE " +
                    KeyField + "= '" + Key + "'";
            Statement stm = Conn.createStatement();
            ResultSet rs = stm.executeQuery(query);

            byte[] geometria = null;
            int count = 0;
            while (rs.next()) {
                geometria = rs.getBytes(ShapeField);
                shpobj = new AbacoSDA(geometria);
                count++;
            }

            if (shpobj == null || count > 1) {
                return null;
            }

            rs.close();
            stm.close();
            Conn.close();

            return shpobj;

        } catch (Exception caught) {
            System.out.println(caught.getMessage());
            return null;
        }
    }
}
