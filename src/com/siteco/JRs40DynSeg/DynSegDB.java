package com.siteco.JRs40DynSeg;

import java.sql.*;
import java.util.*;
import net.sourceforge.jtds.jdbc.*;
import java.sql.*;
/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class DynSegDB {
    private CBinary cbinary;
    public Connection conn;
    public String RouteTableName;
    public String RouteFieldR;
    public String ShapeFieldR;
    public String EventTableName;
    public String KeyFieldE;
    public String RouteFieldE;


    public static void main(String[] args) {
        try {
            DriverManager.registerDriver(new net.sourceforge.jtds.jdbc.Driver());
            Connection conn2 = DriverManager.getConnection(
                    "jdbc:jtds:sqlserver://192.168.7.250:1433/cscm;user=CSCM;password=CSCM");
            DynSegDB abaco = new DynSegDB(conn2);
            abaco.setRouteField("IDENTIFICATIVO");
            abaco.DSSetRouteTable("RDS_PLANET_ROAD_ID", "IDENTIFICATIVO", "SHAPE");
            SHPPoint point = new SHPPoint(1505074, 5053474);
            SHPprjptm proj2 = abaco.DSGetMeasure(point, "");
            SHPPoint[] points = abaco.DSGetPoint("1.Z1.432", 352, 0);
            SHPprjptm proj = new SHPprjptm();
            proj.route = "432";
            proj.mval = 352;
            System.out.println(proj.mval);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }





    public DynSegDB(Connection conn) {
        this.conn = conn;
    }

    public int DSCountRecord() {
        int count = -1;
        try {
            this.cbinary.Table_Info.last();
            count = this.cbinary.Table_Info.getRow();
            this.cbinary.Table_Info.beforeFirst();
            return count;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    private String _RouteField;
    /// <summary>
    /// Nome della colonna che contiene l'indicazione del route
    /// </summary>
    public String getRouteField() {
        return _RouteField;
    }

    public void setRouteField(String value) {
        _RouteField = value;
    }

    /// <summary>
    /// Setta lo shapefile con misura M
    /// </summary>
    /// <param name="FileName">nome del file .shp</param>
    /// <param name="RouteField">nome del campo che contiene la sigla della strada</param>
    /// <returns>0=OK</returns>
    public void DSSetRouteTable(String RouteTableName, String RouteField,
                                String ShapeField) {
        this.RouteTableName = RouteTableName;
        this.RouteFieldR = RouteField;
        this.ShapeFieldR = ShapeField;
        this.cbinary = new CBinary(this.conn, this.ShapeFieldR, RouteFieldR);
        this.cbinary.ReadTable(RouteTableName);
    }

    public void DSSetEventTable(String EventTableName, String KeyField,
                                String RouteField) {
        this.EventTableName = EventTableName;
        this.KeyFieldE = KeyField;
        this.RouteFieldE = RouteField;
    }


    /// <summary>
    /// Restituisce il vettore di punti che corrispondono alla misusa data
    /// Normalmente ce solo 1 punto
    /// </summary>
    /// <param name="Route">Strada</param>
    /// <param name="Measure">Misura</param>
    /// <param name="Offset">Offset dei punti</param>
    /// <returns>null = 0 punti altrimenti vettore di punti</returns>
    public SHPPoint[] DSGetPoint(String Route, double Measure, double Offset) {
        if (this.cbinary == null) {
            return null;
        }
        int nrighe = this.DSCountRecord();
        String nome;
        AbacoSDA shpobj;
        SHPPoint[] vpnt;
        SHPPoint[] vpntres;
        ArrayList vpntarray = new ArrayList();

        vpntres = null;
        int npt = 0;
        int i = 0;

        try {
            while (this.cbinary.Table_Info.next()) {
                nome = this.cbinary.Table_Info.getString(this._RouteField);
                if (nome.compareTo(Route) != 0) {
                    i++;
                    continue;
                }
                shpobj = (AbacoSDA) this.cbinary.CollShpObj.get(i);
                vpnt = shpobj.SHPMGetPointOffset(Measure, Offset);
                if (vpnt != null) {
                    for (int j = 0; j < vpnt.length; j++) {
                        npt++;
                        vpntarray.add(vpnt[j]);
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

        if (npt == 0) {
            return null;
        }
        vpntres = new SHPPoint[npt];
        for (int k = 0; k < npt; k++) {
            vpntres[k] = (SHPPoint) vpntarray.get(k);
        }

        return vpntres;
    }


    /// <summary>
    /// Restituisce la misura del punto pt proiettato sul route piu' vicino al punto dato
    /// </summary>
    /// <param name="pt">punto da proiettare</param>
    /// <param name="string">strada su cui si trova la misura trovata</param>
    /// <returns></returns>
    public SHPprjptm DSGetMeasure(SHPPoint pt, String Route) {

        SHPprjptm prjptm = new SHPprjptm();
        SHPprjptm prjptmOut = new SHPprjptm();

        if (this.cbinary == null) {
            return null;
        }
        int nrighe = this.DSCountRecord();
        AbacoSDA shpobj;
        double measuremin = 0.0;
        //double measure = 0.0, measuremin = 0.0;
        //double tval = 0.0, mang = 0.0;
        SHPPoint ptprj = new SHPPoint();
        double dst, dmin = Double.MAX_VALUE;
        boolean find = false;
        int i = 0;
        try {
            this.cbinary.Table_Info.last();
            int a = this.cbinary.Table_Info.getRow();
            this.cbinary.Table_Info.beforeFirst();
        }
        catch (Exception e) {}
        try {
            while (this.cbinary.Table_Info.next()) {

                shpobj = (AbacoSDA)this.cbinary.CollShpObj.get(this.cbinary.Table_Info.getRow() - 1);
                if (shpobj == null ||shpobj.vpolilinee == null) {
                    continue;
                }
                Route = this.cbinary.Table_Info.getString(this._RouteField);
                int nparti = shpobj.vpolilinee.size();

                for (int j = 0; j < nparti; j++) {
                    SHPPoly pol = (SHPPoly) (shpobj.vpolilinee.get(j));
                    //prjptm = new SHPprjptm();
                    prjptm.pto = pt;
                    prjptm.ptprj = ptprj;
                    int nint = pol.SHPprjptm(prjptm);
                    if (nint != 1) {
                        continue;
                    }
                    dst = pt.SHPdstpt(prjptm.ptprj);
                    if (dst < dmin) {
                        dmin = dst;
                        prjptmOut.route = Route;
                        prjptmOut.pto = prjptm.pto;
                        prjptmOut.ptprj = prjptm.ptprj;
                        prjptmOut.mval = prjptm.mval;
                        prjptmOut.Offset = prjptm.Offset;
                        find = true;
                    }
                }
                i++;
            }
        } catch (Exception e) {
            System.out.println(i + " " + e.getMessage());
            return null;
        }
        if (!find) {
            return null;
        }
        this.ResetTableInfo();
        return prjptmOut;
    }

    /// <summary>
    /// Restituisce la misura del punto pt dello shapeobject indicato da route
    /// </summary>
    /// <param name="Route">Strada</param>
    /// <param name="pt">Punto</param>
    public SHPprjptm DSGetMeasureR(SHPprjptm prjptm, int lato) {
        if (this.cbinary == null) {
            return null;
        }

        int nrighe = this.DSCountRecord();
        String nome = null;
        AbacoSDA shpobj;
        double measure;
        lato = 0;
        int i = 0;
        boolean found = false;

        int indiceRouteField = -1;

        try {
            indiceRouteField = this.cbinary.Table_Info.findColumn(RouteFieldR);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

        try {
            while (this.cbinary.Table_Info.next()) {
                shpobj = (AbacoSDA) this.cbinary.CollShpObj.get(i);
                if (shpobj == null || shpobj.IsShapeNull) {
                    return null;
                }
                if (shpobj == null || shpobj.vpolilinee == null) {
                    return null;
                }

                int tipoSQL = this.cbinary.Table_Info.getMetaData().
                             getColumnType(indiceRouteField);

                switch (tipoSQL) {
                    case java.sql.Types.BIGINT: case java.sql.Types.INTEGER:
                    case java.sql.Types.SMALLINT:
                    {
                        if (this.cbinary.Table_Info.getString(RouteFieldR).compareTo(prjptm.route) == 0) {
                            found = true;
                        }
                        break;
                    }
                    case java.sql.Types.DOUBLE: case java.sql.Types.FLOAT: case java.sql.Types.DECIMAL:
                    case java.sql.Types.NUMERIC: case java.sql.Types.REAL:
                    {
                        int valore = (int) this.cbinary.Table_Info.getDouble(RouteFieldR);
                        if (Integer.toString(valore).compareTo(prjptm.route) == 0) {
                           found = true;
                        }
                        break;
                    }
                    default:
                    {
                        if (this.cbinary.Table_Info.getString(RouteFieldR).compareTo(prjptm.route) == 0) {
                            found = true;
                        }
                        break;
                    }
                }
                i++;
                if (!found) continue;

                shpobj.SHPGetMeasure(prjptm, lato);

                return prjptm;
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        this.ResetTableInfo();
        return null;
    }

    /// <summary>
    /// Restituisce la misura del punto pt dello shapeobject indicato da route
    /// </summary>
    /// <param name="Route">Strada</param>
    /// <param name="pt">Punto</param>
    /// <param name="Offset"></param>
    public SHPprjptm DSGetMeasureR(String Route, SHPPoint pt, double Offset) {
        if (this.cbinary == null) {
            return null;
        }

        SHPprjptm prjptm = new SHPprjptm();
        prjptm.route = Route;
        prjptm.pto = pt;
        prjptm.Offset = Offset;

        int nrighe = this.DSCountRecord();
        String nome;
        AbacoSDA shpobj;
        Offset = 0.0;
        int i = 0;
        boolean found = false;

        int indiceRouteField = -1;
        try {
            indiceRouteField = this.cbinary.Table_Info.findColumn(RouteFieldR);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }



        try {
            while (this.cbinary.Table_Info.next()) {
                shpobj = (AbacoSDA) this.cbinary.CollShpObj.get(i);

                if (shpobj == null || shpobj.IsShapeNull) {
                    return null;
                }
                if (shpobj == null || shpobj.vpolilinee == null) {
                    return null;
                }

                int tipoSQL = this.cbinary.Table_Info.getMetaData().
                             getColumnType(indiceRouteField);

                switch (tipoSQL) {
                    case java.sql.Types.BIGINT: case java.sql.Types.INTEGER:
                    case java.sql.Types.SMALLINT:
                    {
                        if (this.cbinary.Table_Info.getString(RouteFieldR).compareTo(prjptm.route) == 0) {
                            found = true;
                        }
                        break;
                    }
                    case java.sql.Types.DOUBLE: case java.sql.Types.FLOAT: case java.sql.Types.DECIMAL:
                    case java.sql.Types.NUMERIC: case java.sql.Types.REAL:
                    {
                        int valore = (int) this.cbinary.Table_Info.getDouble(RouteFieldR);
                        if (Integer.toString(valore).compareTo(prjptm.route) == 0) {
                           found = true;
                        }
                        break;
                    }
                    default:
                    {
                        if (this.cbinary.Table_Info.getString(RouteFieldR).compareTo(prjptm.route) == 0) {
                            found = true;
                        }
                        break;
                    }
                }
                i++;
                if (!found) continue;

                shpobj.SHPGetMeasure(prjptm, Offset);
                return prjptm;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        this.ResetTableInfo();
        return null;
    }

    public SHPprjptm DSGetMeasureR(String Route, SHPPoint pt) {
        int lato = 0;
        SHPprjptm prjptm = new SHPprjptm();
        prjptm.lato = lato;
        prjptm.route = Route;
        prjptm.pto = pt;
        return this.DSGetMeasureR(prjptm, lato);
    }


    private static String CorreggiNomeField(String NomeField) {
        String Ris = NomeField;

        Ris = Ris.replace(' ', '_');
        Ris = Ris.replace('.', '_');
        Ris = Ris.replace('-', '_');
        //Ris = Ris.replace('�', '_');
        Ris = Ris.replace('#', '_');
        Ris = Ris.replace('*', '_');
        Ris = Ris.replace('/', '_');
        Ris = Ris.replace('(', '_');
        Ris = Ris.replace(')', '_');
        Ris = Ris.replace('[', '_');
        Ris = Ris.replace(']', '_');
        return Ris;
    }


    private static String ConvColNome(String NomeCol, Hashtable nomi_col_DBF) {
        String NomeCorto = NomeCol.substring(0, Math.min(10, NomeCol.length())).
                           toUpperCase();

        NomeCorto = CorreggiNomeField(NomeCorto);

        if (nomi_col_DBF.contains(NomeCorto)) {
            int mm = nomi_col_DBF.size();
            // trovo un altro nome
            do {
                mm++;
                NomeCorto = NomeCorto.substring(0, 7);
                NomeCorto += mm;
            } while (nomi_col_DBF.contains(NomeCorto));
            nomi_col_DBF.put(NomeCorto, NomeCol);
            return NomeCorto;
        } else {
            nomi_col_DBF.put(NomeCorto, NomeCol);
            return NomeCorto;
        }
    }

    private void ResetTableInfo() {
        try {
            this.cbinary.Table_Info.beforeFirst();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
