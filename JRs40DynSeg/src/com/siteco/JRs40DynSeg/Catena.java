/*
 * Catena.java
 *
 * Created on 27 marzo 2006, 15.52
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.siteco.JRs40DynSeg;
import com.svcon.jdbf.DBFReader;
import java.lang.Object.*;
import java.util.*;
/**
 *
 * @author vanna
 */
public class Catena {
    
    /** Creates a new instance of Catena */
    public Catena() {
    }
/// <summary>
/// Crea una catena 
/// </summary>
/// <param name="CSFilePol">Shapefile di poliline</param>
/// <param name="CField">Nome del campo che determina la concatenazione delle poly</param>
/// <param name="FileNameOut">Nome del file shape da produrre</param>
/// <returns> false= errore</returns>
    public boolean Concatena(CShapeFile CSFilePol, String CField, String FileNameOut, String strlog)
    {
	int idobj;
	int idobjnew=1;
	String str;
//	System.Data.DataRow [] righe;
	SHPObject objpol=null;
	int id=1;
	int nrecord = 0;

	strlog = "";
	// leggo il datatable
        /*
	System.Data.DataTable datatab = CSFilePol.DBF_Info;
	int nrighe = datatab.Rows.Count;

	// creo con new shapefile un nuovo file di shape
	CShapeFile CSfile = new CShapeFile();
	CSfile.NewShape();
	CSfile.SHPType = tipo_shpobj.POLYLINEZ;

	// aggiunge la colonna CField al DB
	System.Data.DataColumn Colnew = CSfile.DBF_Info.Columns.Add();
	Colnew.ColumnName = CField;
	Colnew.DataType = CSFilePol.DBF_Info.Columns[CField].DataType;
	Colnew.Caption = CSFilePol.DBF_Info.Columns[CField].Caption;
	Colnew.MaxLength = CSFilePol.DBF_Info.Columns[CField].MaxLength;

	// Costruisco un array contenente i valori del campo CField (univoco)
	System.Collections.ArrayList strarray = new System.Collections.ArrayList();
	for (int i=0; i<nrighe; i++)
	{
		str = datatab.Rows[i][CField].ToString();
		if (strarray.Contains(str)) continue;
		strarray.Add(str);
	}
	// scorro l'array che ho preparato per selezionare l'insieme delle righe (poly)
	// del data table che hanno il campo CField uguale
	for (int j=0; j<strarray.Count; j++)
	{
		strlog += "\n"+CField + '=' + strarray[j]+"\n";
		System.Collections.ArrayList CollPoly = new System.Collections.ArrayList();

		// seleziono gli oggetti del datatable che hanno lo stesso valore di CField
		str = CField +"='"+strarray[j]+"'";
		righe = datatab.Select(str);
		if (righe.Length <= 0) continue;
		// ciclo sul nu. degli oggetti selezionati dalla select
		for (int k=0; k<righe.Length; k++)
		{
			idobj = Convert.ToInt32(righe[k][CSFilePol.IDProgressivo]);
			objpol = (SHPObject) CSFilePol.CollShpObj[idobj];
			// scomponi la objpol in poly semplici
			for (int h=0; h<objpol.nParts; h++)
			{
				CollPoly.Add(objpol.vpolilinee[h]);
			}
		}
		// Creo la nuova polym
		SHPObject objpolcat = new SHPObject(tipo_shpobj.POLYLINEZ,false,0,id++,0,0,null);
		if (!this.ConcatenaPol(CollPoly, objpolcat, strlog)) return false;
		CSfile.AddSHPObj(idobjnew,objpolcat);
		CSfile.DBF_Info.Rows[idobjnew-1][CField] = strarray[j].ToString();
		idobjnew++;
		nrecord++;
	}

	CSfile.nRecords = nrecord;
	CSfile.SHCalbox();
	CSfile.SHWriteShapefile(FileNameOut);
         */
        return true;
    }
/// <summary>
/// Crea una catena di poliline
/// </summary>
/// <param name="CollObjPol">Collezione di poly semplici da concatenare</param>
/// <param name="FileNameOut">Poly risultante</param>
/// <returns> false= errore</returns>
    private boolean ConcatenaPol(ArrayList CollPoly, SHPObject objpolcat, String strlog)
    {
	ArrayList vpol = new ArrayList();
	boolean [] incatena = new boolean[CollPoly.size()];
	int nparti=0;
	int i,j,npt1,npt2,nv=0;
	int nunioni=0;

	for (i=0; i<CollPoly.size(); i++)
	{
		incatena[i] = false;
	}
	for (i=0; i<CollPoly.size(); i++)
	{
		if (incatena[i]) continue;
		incatena[i] = true;

		SHPPoly polbuff1 = ((SHPPoly)(CollPoly.get(i)));
		SHPPoly pol1=new SHPPoly();
		pol1.SHPAddPoly(polbuff1);

		for (j=i+1; j<CollPoly.size(); j++)
		{
			if (incatena[j]) continue;

			SHPPoly polbuff2 = ((SHPPoly)(CollPoly.get(j)));
			SHPPoly pol2=new SHPPoly();
			pol2.SHPAddPoly(polbuff2);

			npt1 = pol1.pnt.size();
			npt2 = pol2.pnt.size();
			SHPPoint p11 = ((SHPPoint)(pol1.pnt.get(0)));
			SHPPoint p12 = ((SHPPoint)(pol1.pnt.get(npt1-1)));
			SHPPoint p21 = ((SHPPoint)(pol2.pnt.get(0)));
			SHPPoint p22 = ((SHPPoint)(pol2.pnt.get(npt2-1)));
			if (p12.SHPpteq(p21))
			{
                            if (Math.abs(p12.z - p21.z) < MConst.TOLL)
				((SHPPoint)(pol2.pnt.get(0))).z = (p12.z + p21.z) / 2.0;

				pol1.SHPAddPoly(pol2);
				incatena[j] = true;
				j = i;
				nunioni++;
				continue;
			}
			if (p11.SHPpteq(p21))
			{
				if (Math.abs(p11.z - p21.z) < MConst.TOLL)
					((SHPPoint)(pol2.pnt.get(0))).z = (p11.z + p21.z) / 2.0;
				pol1.SHPInvertPoints();
				pol1.SHPAddPoly(pol2);
				incatena[j] = true;
				j = i;
				nunioni++;
				continue;
			}
			if (p12.SHPpteq(p22))
			{
				if (Math.abs(p12.z - p22.z) < MConst.TOLL)
					((SHPPoint)(pol2.pnt.get(npt2-1))).z = (p12.z + p22.z) / 2.0;

				pol2.SHPInvertPoints();
				pol1.SHPAddPoly(pol2);
				incatena[j] = true;
				j = i;
				nunioni++;
				continue;
			}
			if (p11.SHPpteq(p22))
			{
				if (Math.abs(p11.z - p22.z) < MConst.TOLL)
					((SHPPoint)(pol2.pnt.get(npt2-1))).z = (p11.z + p22.z) / 2.0;
				pol1.SHPInvertPoints();
				pol2.SHPInvertPoints();
				pol1.SHPAddPoly(pol2);
				incatena[j] = true;
				j=i;
				nunioni++;
				continue;
			}
		}
		nparti++;
		pol1.SHPAggM();
		vpol.add(pol1);
		nv += pol1.pnt.size();
                SHPPoint p0,pn;
                int np = pol1.pnt.size() - 1;
                p0 = (SHPPoint)pol1.pnt.get(0);
                pn = (SHPPoint)pol1.pnt.get(np);
                Double x0 = new Double(p0.x);
                Double y0 = new Double(p0.y);
                Double z0 = new Double(p0.z);
                Double m0 = new Double(p0.m);
                Double xn = new Double(pn.x);
                Double yn = new Double(pn.y);
                Double zn = new Double(pn.z);
                Double mn = new Double(pn.m);

		strlog += " X1= "+x0.toString()+" Y1= "+y0.toString()+
				  " Z1= "+z0.toString()+" M1= "+m0.toString()+"\n";
		strlog += " X2= "+xn.toString()+" Y2= "+yn.toString()+
				  " Z2= "+zn.toString()+" M2= "+mn.toString()+"\n";
	}
        Integer nu = new Integer(nunioni);
        Integer npr = new Integer(nparti);
	strlog += "\nTotale Unioni"+nu.toString()+" Nparti ="+npr.toString()+"\n";
	objpolcat.vpolilinee = vpol;
	objpolcat.nParts = nparti;
	objpolcat.nSHPType = tipo_shpobj.POLYLINEZ;
	objpolcat.nVertices = nv;
	objpolcat.SHPCalBox();
	objpolcat.SHPCalLenght();
	return true;
    }
}
