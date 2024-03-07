package com.siteco.JRs40DynSeg;

import com.svcon.jdbf.*;
import java.util.Hashtable;
import java.lang.Object.*;
import java.util.*;
import java.lang.*;

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
public class DynSeg {
    private CShapeFile ShapeCur;

    public DynSeg() {
    }

    public int DSCountDBFField(String DbfFileName) {
        return this.ShapeCur.dbfr.numRecords();
        //return this.ShapeCur.DBF_Info.nrecorddbf;
    }
    private String _RouteField;
    private int _RouteFieldIndex;
    private byte tipoRouteField;
    /// <summary>
    /// Nome della colonna che contiene l'indicazione del route
    /// </summary>
    public String getRouteField() {
        return _RouteField;
    }

    public void setRouteField(String value) {
        _RouteField = value;
    }

    public int getRouteFieldIndex() {
       return _RouteFieldIndex;
    }

    public void setRouteFieldIndex(int value) {
        _RouteFieldIndex = value;
    }


    /// <summary>
    /// Setta lo shapefile con misura M
    /// </summary>
    /// <param name="FileName">nome del file .shp</param>
    /// <param name="RouteField">nome del campo che contiene la sigla della strada</param>
    /// <returns>0=OK</returns>
    public int DSSetShapefile(String FileName, String RouteField) {
        try {
            // apre lo shape file filename
            if (this.ShapeCur == null) {
                this.ShapeCur = new CShapeFile();
                if (!this.ShapeCur.SHReadShapefile(FileName)) {
                    return 1;
                }
            }
            // devono essere polyM altrimenti res = false
            //int ncol = this.ShapeCur.DBF_Info.ncol;
            int ncol = this.ShapeCur.dbfr.numFields();
            // loop su ncol per verificare che esista una colonna di nome RouteField
            Boolean exist = false;
            for (int nc = 0; nc < ncol; nc++) {
                //String JJ = this.ShapeCur.DBF_Info.DBFGetName(nc);
                String JJ = this.ShapeCur.dbfr.getFieldName(nc);
                if (JJ.compareToIgnoreCase(RouteField) == 0) {
                    exist = true;
                    //tipoRouteField = this.ShapeCur.DBF_Info.jlist[nc].getType();
                    tipoRouteField = this.ShapeCur.dbfr.getFieldType(nc);
                    this.setRouteFieldIndex(nc);
                    break;
                }
            }
            if (exist) {
                this.setRouteField(RouteField);
            }
            if (exist) {
                return 0;
            } else {
                return 2;
            }
        } catch (Exception eee) {
            System.out.println("DSSetShapefile Exc=" + eee.getMessage()); //mmm
            return 3;
        }
    }
    
    public int getRecordIndexFromId(String routeId) {
        int nrighe = this.ShapeCur.dbfr.numRecords();
        String nome;
        int res = -1;
        
        try 
        {
            this.ShapeCur.dbfr.openDBF(this.ShapeCur.NomeFile);
            for (int i = 0; i < nrighe; i++) {

                byte[] data = this.ShapeCur.dbfr.getRecord(i);
                nome = this.ShapeCur.dbfr.getFieldData(this.getRouteFieldIndex(), data);
                if (nome.compareTo(routeId) != 0) {
                    continue;
                }
                else {
                    res = i;
                    break;
                }
            } 
            this.ShapeCur.dbfr.closeDBF();
        } catch (Exception eee) {
            System.out.println("getRecordIndexFromId Exc=" + eee.getMessage()); //mmm
        }
        return res;
    }
    
    public String getFieldValue(int rowId, String fieldName) {
        String res = null;
        try {
            this.ShapeCur.dbfr.openDBF(this.ShapeCur.NomeFile);
            int ncol = this.ShapeCur.dbfr.numFields();
            int fieldIndex = -1;
            for (int nc = 0; nc < ncol; nc++) {
                //String JJ = this.ShapeCur.DBF_Info.DBFGetName(nc);
                String JJ = this.ShapeCur.dbfr.getFieldName(nc);
                if (JJ.compareToIgnoreCase(fieldName) == 0) {
                    fieldIndex = nc;
                    break;
                }
            }
            if (fieldIndex != -1) {
                byte[] data = this.ShapeCur.dbfr.getRecord(rowId);
                res = this.ShapeCur.dbfr.getFieldData(fieldIndex, data);
            }
            this.ShapeCur.dbfr.closeDBF();
            return res;
        } catch (Exception eee) {
            System.out.println("DSSetShapefile Exc=" + eee.getMessage()); //mmm
            return res;
        }
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
        if (this.ShapeCur == null) {
            return null;
        }
        SHPPoint[] vpntres = null;
        try {
            this.ShapeCur.dbfr.openDBF(this.ShapeCur.NomeFile);
            int nrighe = this.ShapeCur.dbfr.numRecords();
            String nome = "";
            SHPObject shpobj;
            SHPPoint[] vpnt;
            ArrayList vpntarray = new ArrayList();

            vpntres = null;
            int npt = 0;

            for (int i = 0; i < nrighe; i++) {
                byte[] data = this.ShapeCur.dbfr.getRecord(i);
                nome = this.ShapeCur.dbfr.getFieldData(this.getRouteFieldIndex(),
                        data);
                /*if (tipoRouteField == 'C')
                 nome = this.ShapeCur.DBF_Info.DBFGetCharacter(i, this._RouteField);
                             else if (tipoRouteField == 'N')
                 nome = Long.toString(this.ShapeCur.DBF_Info.DBFGetNumeric(i, this._RouteField));
                             else if (tipoRouteField == 'F')
                 nome = Double.toString(this.ShapeCur.DBF_Info.DBFGetFloat(i, this._RouteField));
                 */
                if (nome.compareTo(Route) != 0) {
                    continue;
                }

                shpobj = (SHPObject)this.ShapeCur.CollShpObj.get(i);
                double mmin = shpobj.bbox.mmin;
                double mmax = shpobj.bbox.mmax;
                if (Measure <= mmin)
                    vpnt = shpobj.SHPMGetPointOffset(mmin + 0.001, Offset);
                else if (Measure >= mmax)
                    vpnt = shpobj.SHPMGetPointOffset(mmax - 0.001, Offset);
                else
                    vpnt = shpobj.SHPMGetPointOffset(Measure, Offset);
                if (vpnt != null) {
                    for (int j = 0; j < vpnt.length; j++) {
                        npt++;
                        vpntarray.add(vpnt[j]);
                    }
                }
            }
            if (npt == 0) {
                return null;
            }
            vpntres = new SHPPoint[npt];
            for (int i = 0; i < npt; i++) {
                vpntres[i] = (SHPPoint) vpntarray.get(i);
            }
            this.ShapeCur.dbfr.closeDBF();
        }
        catch (Exception exc)
        {}
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
        boolean find = false;
        if (this.ShapeCur == null) {
            return null;
        }
        try
        {
            this.ShapeCur.dbfr.openDBF(this.ShapeCur.NomeFile);
            int nrighe = this.ShapeCur.dbfr.numRecords();
            SHPObject shpobj;
            double measuremin = 0.0;
            //double measure = 0.0, measuremin = 0.0;
            //double tval = 0.0, mang = 0.0;
            SHPPoint ptprj = new SHPPoint();
            double dst, dmin = Double.MAX_VALUE;

            int count = 0;
            for (int i = 0; i < nrighe; i++) {
                shpobj = (SHPObject)this.ShapeCur.CollShpObj.get(i);
                if (shpobj == null || shpobj.nSHPType == tipo_shpobj.NULLSHAPE ||
                    shpobj.vpolilinee == null) {
                    continue;
                }
                count++;
                //Route = Long.toString(this.ShapeCur.DBF_Info.DBFGetNumeric(i, this._RouteField));
                byte[] data = this.ShapeCur.dbfr.getRecord(i);
                Route = this.ShapeCur.dbfr.getFieldData(this.getRouteFieldIndex(),
                        data);
                if (Route.compareTo("21") == 0)
                   System.out.println(Route);
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
                        measuremin = prjptm.mval;
                        /*if (tipoRouteField == 'C')
                         Route = this.ShapeCur.DBF_Info.DBFGetCharacter(i, this._RouteField);
                                             else if (tipoRouteField == 'N')
                            Route = Long.toString(this.ShapeCur.DBF_Info.DBFGetNumeric(i, this._RouteField));
                                             else if (tipoRouteField == 'F')
                            Route = Double.toString(this.ShapeCur.DBF_Info.DBFGetFloat(i, this._RouteField));
                         */
                        prjptmOut.route = Route;
                        prjptmOut.pto = prjptm.pto;
                        prjptmOut.ptprj = prjptm.ptprj;
                        prjptmOut.mval = prjptm.mval;
                        prjptmOut.Offset = prjptm.Offset;
                        find = true;
                    }
                }
            }
            this.ShapeCur.dbfr.closeDBF();
        }
        catch (Exception exc)
        {}
        if (!find) {
            return null;
        }
        return prjptmOut;
    }

    /// <summary>
    /// Restituisce la misura del punto pt dello shapeobject indicato da route
    /// </summary>
    /// <param name="Route">Strada</param>
    /// <param name="pt">Punto</param>
    public SHPprjptm DSGetMeasureR(SHPprjptm prjptm, int lato) {
        if (this.ShapeCur == null) {
            return null;
        }

        int nrighe = this.ShapeCur.dbfr.numRecords();
        String nome = null;
        SHPObject shpobj;
        double measure;
        lato = 0;

        char tipo = '|';
        int indiceRouteField = -1;
        /*for (int i = 0; i < this.ShapeCur.DBF_Info.jlist.length; i++) {
            if (this.ShapeCur.DBF_Info.jlist[i].getName().toLowerCase()
                .matches(this.getRouteField().toLowerCase())) {
                tipo = this.ShapeCur.DBF_Info.jlist[i].getType();
                indiceRouteField = i;
                break;
            }
        }*/

        if (tipo == '|') {
            return null;
        }

        for (int i = 0; i < nrighe; i++) {

            /*if (tipo == 'C')
             nome = this.ShapeCur.DBF_Info.DBFGetCharacter(i, this._RouteField);
                         else if (tipo == 'N')
                nome = Long.toString(this.ShapeCur.DBF_Info.DBFGetNumeric(i, this.getRouteField()));
                         else return null;*/
            //int iNome = (int) Double.parseDouble(this.ShapeCur.DBF_Info.lista_obj[indiceRouteField].get(i).toString());
            int iNome = 0;
            nome = Integer.toString(iNome);

            if (nome.compareTo(prjptm.route) != 0) {
                continue;
            }

            shpobj = (SHPObject)this.ShapeCur.CollShpObj.get(i);
            if (shpobj == null || shpobj.IsShapeNull) {
                return null;
            }
            if (shpobj == null || shpobj.nSHPType == tipo_shpobj.NULLSHAPE ||
                shpobj.vpolilinee == null) {
                return null;
            }
            shpobj.SHPGetMeasure(prjptm, lato);
            return prjptm;
        }
        return null;
    }

    /// <summary>
    /// Restituisce la misura del punto pt dello shapeobject indicato da route
    /// </summary>
    /// <param name="Route">Strada</param>
    /// <param name="pt">Punto</param>
    /// <param name="Offset"></param>
    public SHPprjptm DSGetMeasureR(String Route, SHPPoint pt, double Offset) {
        if (this.ShapeCur == null) {
            return null;
        }

        SHPprjptm prjptm = new SHPprjptm();
        prjptm.route = Route;
        prjptm.pto = pt;
        prjptm.Offset = Offset;

        int nrighe = this.ShapeCur.dbfr.numRecords();
        String nome;
        SHPObject shpobj;
        Offset = 0.0;

        char tipo = '|';
        int indiceRouteField = -1;
        /*for (int i = 0; i < this.ShapeCur.DBF_Info.jlist.length; i++) {
            if (this.ShapeCur.DBF_Info.jlist[i].getName().toLowerCase()
                .matches(this.getRouteField().toLowerCase())) {
                tipo = this.ShapeCur.DBF_Info.jlist[i].getType();
                indiceRouteField = i;
                break;
            }
        }*/

        if (tipo == '|') {
            return null;
        }



        for (int i = 0; i < nrighe; i++) {
            //int iNome = (int) Double.parseDouble(this.ShapeCur.DBF_Info.lista_obj[indiceRouteField].get(i).toString());
            int iNome = 0;
            nome = Integer.toString(iNome);

            if (nome.compareTo(prjptm.route) != 0) {
                continue;
            }

            shpobj = (SHPObject)this.ShapeCur.CollShpObj.get(i);
            if (shpobj == null || shpobj.IsShapeNull) {
                return null;
            }
            if (shpobj == null || shpobj.nSHPType == tipo_shpobj.NULLSHAPE ||
                shpobj.vpolilinee == null) {
                return null;
            }
            shpobj.SHPGetMeasure(prjptm, Offset);
            return prjptm;
        }
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


}
