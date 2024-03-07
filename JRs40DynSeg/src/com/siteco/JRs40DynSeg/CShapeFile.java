/*
 * CShapeFile.java
 *
 * Created on 15 marzo 2006, 16.07
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.siteco.JRs40DynSeg;

import java.io.*;
import java.util.ArrayList;
import java.lang.Object.*;
import java.util.*;
import java.lang.*;
import com.svcon.jdbf.*;
import oracle.spatial.util.DBFReaderJGeom;

/**
 *
 * @author vanna
 */
public class CShapeFile {


    public CShapeFile() {
    }

    public DBFReader dbf_r;
    public DBFWriter dbf_w;
    //public DBFFile DBF_Info = new DBFFile();
    public DBFReaderJGeom dbfr = null;
    public String Server;
    public String Password;
    public String NomeFile;

    public FileInputStream fs_shp_in;
    public FileOutputStream fs_shp_out;

    public FileInputStream fs_shx_in;
    public FileOutputStream fs_shx_out;

    public ArrayList CollShpObj = new ArrayList();
    private ArrayList PosizioniShpO = new ArrayList();


    public int nRecords;

    public String User;
    public int SHPType;

    public Box bbox;

    public int leggi_tipo(DataInputStream r) {
        // VV tipo_shpobj tipo;
        int tipo = 0;
        try {
            tipo = r.readInt();
            tipo = this.SwapInt(tipo); //MM in java si fa il contrario

        } catch (IOException e) {
            return tipo_shpobj.NULLSHAPE;
        }

        switch (tipo) {
        case 0:
            tipo = tipo_shpobj.NULLSHAPE;
            break;
        case 1:
            tipo = tipo_shpobj.POINT;
            break;
        case 3:
            tipo = tipo_shpobj.POLYLINE;
            break;
        case 5:
            tipo = tipo_shpobj.POLYGON;
            break;
        case 8:
            tipo = tipo_shpobj.MULTIPOINT;
            break;
        case 11:
            tipo = tipo_shpobj.POINTZ;
            break;
        case 13:
            tipo = tipo_shpobj.POLYLINEZ;
            break;
        case 15:
            tipo = tipo_shpobj.POLYGONZ;
            break;
        case 18:
            tipo = tipo_shpobj.MULTIPOINTZ;
            break;
        case 21:
            tipo = tipo_shpobj.POINTM;
            break;
        case 23:
            tipo = tipo_shpobj.POLYLINEM;
            break;
        case 25:
            tipo = tipo_shpobj.POLYGONM;
            break;
        case 28:
            tipo = tipo_shpobj.MULTIPOINTM;
            break;
        default:
            tipo = tipo_shpobj.NULLSHAPE;
            break;
        }
        return tipo;
    }


    public void scrivi_tipo(ObjectOutputStream w) {
        try {
            w.writeInt(this.SHPType);
        } catch (IOException e) {
            System.exit(0);
            return;
        }
        return ;
    }

    public boolean SHReadShapefile(String FileName) {
        int idum, lun;
        long posizione;
        String nomefile_shx;
        String nomefile_shp;
        String nomefile_dbf;

        lun = FileName.length();
        this.NomeFile = FileName.substring(0, lun - 4);

        DataInputStream ois;
        DataInputStream oip;
        //
        // Apre il file .shx
        //
        nomefile_shx = this.NomeFile + ".shx";
        try {
            //System.out.println("SHReadShapefile 1 Fileshx"+ nomefile_shx); //mmm
            this.fs_shx_in = new FileInputStream(nomefile_shx);
            //System.out.println("SHReadShapefile 1.2 "); //mmm
            ois = new DataInputStream(this.fs_shx_in);

            //System.out.println("SHReadShapefile 2"); //mmm
            //
            // leggo l'header del file .shx
            //
            idum = ois.readInt();
            idum = ois.readInt();
            idum = ois.readInt();
            idum = ois.readInt();
            idum = ois.readInt();
            idum = ois.readInt();

            //mio
            //file length
            nRecords = (ois.readInt() * 2 - 100) / 8;
            //diventa little-endian
            //version
            idum = SwapInt(ois.readInt());
            //shape type
            idum = SwapInt(ois.readInt());

            //boundary box
            double d = SwapDouble(ois.readDouble());
            d = SwapDouble(ois.readDouble());
            d = SwapDouble(ois.readDouble());
            d = SwapDouble(ois.readDouble());
            d = SwapDouble(ois.readDouble());
            d = SwapDouble(ois.readDouble());
            d = SwapDouble(ois.readDouble());
            d = SwapDouble(ois.readDouble());

            posizione = this.fs_shx_in.getChannel().position();

            long posO = 0;
            for (int i = 0; i < nRecords; i++) {
                idum = ois.readInt();
                //System.out.println("SHReadShapefile idum"+idum); //mmm
                //MM in java non si fa!idum = SwapInt(idum);
                posO = idum * 2;
                //System.out.println("SHReadShapefile Pos"+posO); //mmm

                Long P = new Long(posO);
                this.PosizioniShpO.add(P);
                idum = ois.readInt();
            }
            //System.out.println("SHReadShapefile 6"); //mmm

            this.fs_shx_in.close();
            ois.close();
        } catch (IOException e1) {
            System.out.println(e1.getMessage()); //mmm
            return false;
        }

        //
        // Apre il file .shp
        //
        nomefile_shp = this.NomeFile + ".shp";
        try {
            //System.out.println("SHReadShapefile 7"); //mmm

            this.fs_shp_in = new FileInputStream(nomefile_shp);
            oip = new DataInputStream(this.fs_shp_in);
            idum = oip.readInt();
            idum = oip.readInt();
            idum = oip.readInt();
            idum = oip.readInt();
            idum = oip.readInt();
            idum = oip.readInt();
            idum = oip.readInt();
            idum = SwapInt(oip.readInt());
            //System.out.println("SHReadShapefile 8"); //mmm

            this.SHPType = this.leggi_tipo(oip);
            this.bbox = new Box();
            this.bbox.xmin = SwapDouble(oip.readDouble());
            this.bbox.ymin = SwapDouble(oip.readDouble());
            this.bbox.xmax = SwapDouble(oip.readDouble());
            this.bbox.ymax = SwapDouble(oip.readDouble());
            this.bbox.zmin = SwapDouble(oip.readDouble());
            this.bbox.zmax = SwapDouble(oip.readDouble());
            this.bbox.mmin = SwapDouble(oip.readDouble());
            this.bbox.mmax = SwapDouble(oip.readDouble());
            posizione = this.fs_shp_in.getChannel().position();
            //
            // Leggo tutti gli shape object e li memorizzo nella collezione della classe
            //
            //System.out.println("SHReadShapefile 9"); //mmm

            SHPObject shpobj;
            long pos;
            for (int j = 0; j < nRecords; j++) {
                pos = ((Long) (this.PosizioniShpO.get(j))).longValue();
                this.fs_shp_in.getChannel().position(pos);
                shpobj = new SHPObject();
                //record number
                idum = oip.readInt();
                //record length
                shpobj.lenght = oip.readInt();
                if (!shpobj.SHPReadObject(this, oip, j)) {
                    System.out.println("Errore nella lettura!!! record " + j);
                    return false;
                }
                this.CollShpObj.add(j, shpobj); // aggiungo l'oggetto alla collezione degli oggetti letti
            }
            oip.close();
            this.fs_shp_in.close();

        } catch (IOException e2) {
            System.out.println("SHReadShapefile 11" + e2.getMessage()); //mmm

            return false;
        }
        //
        // Apre il file .dbf
        //
        boolean res;

        try {
            dbfr = new DBFReaderJGeom (this.NomeFile);
            dbfr.closeDBF();
            res = true;
        }
        catch (Exception exc)
        {
            res = false;
        }
        return res;
    }

/*    public boolean SHWriteShapefile(String FileName) {
        if (FileName.toLowerCase().endsWith(".shp")) {
            FileName.replaceAll(".shp", "");
        }

        String nomefile_shp = FileName + ".shp";
        String nomefile_shx = FileName + ".shx";
        String nomefile_dbf = FileName + ".dbf";

        DataOutputStream shx;
        DataOutputStream shp;

        try {
//
//          Apre il file .shx
//
            this.fs_shx_out = new FileOutputStream(nomefile_shx);
            shx = new DataOutputStream(this.fs_shx_out);

//
//          Apre il file .shp
//
            this.fs_shp_out = new FileOutputStream(nomefile_shp);
            shp = new DataOutputStream(this.fs_shp_out);
//
//          Scrivo gli header dei file shx e shp
//
            int filelen_shp = 0; // da ricalcolare e riscrivere dopo la lettura degli obj

            shx.writeInt(9994);
            shx.writeInt(0);
            shx.writeInt(0);
            shx.writeInt(0);
            shx.writeInt(0);
            shx.writeInt(0);
            shx.writeInt((nRecords * 8 + 100) / 2);
            shx.writeInt(SwapInt(1000));
            shx.writeInt(SwapInt(this.SHPType));
            shx.writeDouble(SwapDouble(this.bbox.xmin));
            shx.writeDouble(SwapDouble(this.bbox.ymin));
            shx.writeDouble(SwapDouble(this.bbox.xmax));
            shx.writeDouble(SwapDouble(this.bbox.ymax));
            shx.writeDouble(SwapDouble(this.bbox.zmin));
            shx.writeDouble(SwapDouble(this.bbox.zmax));
            shx.writeDouble(SwapDouble(this.bbox.mmin));
            shx.writeDouble(SwapDouble(this.bbox.mmax));

            shp.writeInt(9994);
            shp.writeInt(0);
            shp.writeInt(0);
            shp.writeInt(0);
            shp.writeInt(0);
            shp.writeInt(0);
            shp.writeInt((nRecords * 8 + 100) / 2);
            shp.writeInt(SwapInt(1000));
            shp.writeInt(SwapInt(this.SHPType));
            shp.writeDouble(SwapDouble(this.bbox.xmin));
            shp.writeDouble(SwapDouble(this.bbox.ymin));
            shp.writeDouble(SwapDouble(this.bbox.xmax));
            shp.writeDouble(SwapDouble(this.bbox.ymax));
            shp.writeDouble(SwapDouble(this.bbox.zmin));
            shp.writeDouble(SwapDouble(this.bbox.zmax));
            shp.writeDouble(SwapDouble(this.bbox.mmin));
            shp.writeDouble(SwapDouble(this.bbox.mmax));

            long offset = fs_shp_out.getChannel().position();
            //
            // Scrivo tutti gli shape object memorizzati nella collezione della classe
            //
            SHPObject shpobj;
            int ll = 0;
            for (int i = 0; i < CollShpObj.size(); i++) {
                shpobj = (SHPObject) CollShpObj.get(i);
                shp.writeInt(shpobj.nShapeId);
                ll = shpobj.lenght;
                shp.writeInt(ll);
                if (!shpobj.SHPWriteObject(this, shp, shpobj.nShapeId, shpobj)) {
                    return false;
                }
                shx.writeInt((int) offset / 2);
                offset = fs_shp_out.getChannel().position(); ;
                shx.writeInt(ll);
            }
            filelen_shp = (int) (fs_shp_out.getChannel().size()) / 2;
            fs_shp_out.getChannel().position(24);
            shp.writeInt(this.SwapInt(filelen_shp));

            shp.flush();
            shp.close();
            this.fs_shp_out.close();
            shx.flush();
            shx.close();
            this.fs_shx_out.close();
        } catch (IOException e1) {
            return false;
        }

        //scrivo il file dbf
        if (!this.DBF_Info.DBFWriteFile(nomefile_dbf)) {
            return false;
        }

        return true;
    }
 */

    public static double SwapDouble(double sm) {
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
        return Double.longBitsToDouble(result);
        //return Double.doubleToRawLongBits(result);
    }

    public static int SwapInt(int sm) {
        //long smallendian = Double.doubleToLongBits(sm);
        return Integer.reverseBytes(sm);
    }


    /// <summary>
    /// Aggiunge un oggetto alla collezione
    /// </summary>
    /*
    public boolean AddSHPObj(SHPObject obj, Object[] RigaO) {
        if (!this.DBF_Info.AddRecord(RigaO))
            return false;

        this.CollShpObj.add(obj);
        this.nRecords++;
        return true;
    }
*/
    public void NewShape() {
        /*this.DBF_Info = new DataTable();
        byte[] bbb = new byte[2];
        System.Data.SqlTypes.SqlBinary b = new System.Data.SqlTypes.SqlBinary(
                bbb);
        this.DBF_Info.Columns.Add(_SHAPE, b.GetType());
        this.DBF_Info.Columns.Add(_IDProgressivo, typeof(int));*/
    }

    public void SHCalbox() {
        this.bbox = new Box();
        Box b = new Box(MConst.DOUBLEMAX, MConst.DOUBLEMIN);
        SHPObject shpobj;
        for (int i = 0; i < CollShpObj.size(); i++) {
            shpobj = (SHPObject) CollShpObj.get(i);
            b.SHPAggBox(shpobj.bbox);
        }
        this.bbox = b;
    }
}
