/*
 * Calibrazione.java
 *
 * Created on 21 marzo 2006, 12.32
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */
/// Contiene le funzioni necessarie alla calibrazione di un Shapefile

package com.siteco.JRs40DynSeg;
import com.svcon.jdbf.DBFReader;
import java.lang.Object.*;
import java.util.*;
/**
 *
 * @author vanna
 */
public class Calibrazione {

    /** Creates a new instance of Calibrazione */
    public Calibrazione() {
    }

/// <summary>
/// Calibra una shapefile
/// </summary>
/// <param name="CSFilePol">Shapefile di poliline non calibrato</param>
/// <param name="CSFilePnt">Shapefile di punti di calibrazione</param>
/// <param name="MField">Nome del campo che contiene la M nel caso non sia POINTM</param>
/// <param name="RouteFieldPol">Nome del campo che contiene il nome della strada nello shapefile di poly</param>
/// <param name="RouteFieldPnt">Nome del campo che contiene il nome della strada nello shapefile di punti</param>
/// <param name="FileNameOut">Nome del file shape calibrato da produrre</param> VV ref
/// <returns> false= errore</returns>
    public boolean Calibra(CShapeFile CSFilePol, CShapeFile CSFilePnt, String MField, String RouteFieldPol, String RouteFieldPnt, String FileNameOut, String strlog)
    {
	int nobj=0;
	int id=1;
	int nrecord = 0;
	strlog = "";

	// leggo i due datatable
//VV	System.Data.DataTable datatablePol = CSFilePol.DBF_Info;
//VV	System.Data.DataTable datatablePnt = CSFilePnt.DBF_Info;

//	int nrighe = datatablePol.Rows.Count;

	// creo con new shapefile un nuovo file di shape
	CShapeFile CSfile = new CShapeFile();
	CSfile.NewShape();
	CSfile.SHPType = tipo_shpobj.POLYLINEM;

	Hashtable CollObjPnt = new Hashtable();
/*
	for (int i=0; i<nrighe; i++)
	{
		strlog += RouteFieldPnt + '=' + datatablePol.Rows[i][RouteFieldPol].ToString()+ ' ';

		System.Data.DataRow [] righe;
		string str = RouteFieldPnt + "=" + datatablePol.Rows[i][RouteFieldPol].ToString();
		righe = datatablePnt.Select(str);
		SHPObject objpol = (SHPObject) CSFilePol.CollShpObj[i];
		// ciclo sul nu. dei punti selezionati dalla select
		CollObjPnt.Clear();
		for (int k=0; k<righe.Length; k++)
		{
			int indice = Convert.ToInt32(righe[k][CSFilePnt.IDProgressivo]);
			SHPObject objpnt = (SHPObject) CSFilePnt.CollShpObj[indice];
			SHPPoint pnt = new SHPPoint();
			SHPPoly pol = (SHPPoly)(objpnt.vpolilinee[0]);

			pnt.x = ((SHPPoint)(pol.pnt[0])).x;
			pnt.y = ((SHPPoint)(pol.pnt[0])).y;
			pnt.z = ((SHPPoint)(pol.pnt[0])).z;

			if (objpnt.nSHPType.Equals(tipo_shpobj.POINTM))
				pnt.m = ((SHPPoint)(pol.pnt[0])).m;
			else
				pnt.m = Convert.ToDouble(righe[k][MField].ToString());

			CollObjPnt.Add(k,pnt);
		}
		// Creo la nuova polym calibrata
		SHPObject objpolcal = new SHPObject(tipo_shpobj.POLYLINEM,false,0,id++,objpol.nParts,0,null);
		boolean res = this.CalibraPol(objpol, objpolcal, CollObjPnt, strlog);
		if (!res) return false;
		CSfile.AddSHPObj(nobj++,objpolcal);
		nrecord++;
	}
	CSfile.nRecords = nrecord;
	CSfile.SHCalbox();
	CSfile.SHWriteShapefile(FileNameOut);
 **/
	return true;
    }
/// <summary>
/// Calcola il valore del primo e dell'ultimo m e la loro posizione nel vettore dei punti
/// VV firstm imfirst lastm imlast ref
/// </summary>
    private boolean GetFirstLastM(SHPPoly pol,double firstm,int imfirst,double lastm,int imlast)
    {
	firstm = Double.NaN;
	lastm = Double.NaN;
	imfirst = 0; imlast = 0;
	for (int j=0; j<pol.pnt.size(); j++)
	{
		double valm = ((SHPPoint)pol.pnt.get(j)).m;
		if (valm == (Double.NaN)) continue;
		//if (valm.equals(Double.NaN)) continue;
		firstm = valm;
		imfirst = j;
		break;
	}
	if (firstm == (Double.NaN)) return false;
//	if (firstm.equals(Double.NaN)) return false;
	for (int j=pol.pnt.size()-1; j>=0; j--)
	{
		double valm = ((SHPPoint)pol.pnt.get(j)).m;
		if (valm == (Double.NaN)) continue;
//		if (valm.equals(Double.NaN)) continue;
		lastm = valm;
		imlast = j;
		break;
	}
	if (lastm == (Double.NaN)) return false;
	if (imfirst == (imlast)) return false;
//	if (lastm.equals(Double.NaN)) return false;
//	if (imfirst.Equals(imlast)) return false;
	return true;
    }
/// <summary>
/// Calcola l'indice del prossimo punto sulla poly, a partire dal k_esimo, con m valido (!= double.NaN).
/// Ritorna false in caso non ce ne siano altri.
/// VV nextim ref
/// </summary>
    private boolean GetNextM(SHPPoly pol,int k,int nextim)
    {
	for (int i=k; i<pol.pnt.size(); i++)
	{
		if (((((SHPPoint)pol.pnt.get(i))).m) == (Double.NaN)) continue;
		nextim = i;
		return true;
	}
	return false;
    }
/// <summary>
/// Calibra la singola poly (strada)
/// VV objpolcal strlog ref
/// </summary>
private boolean CalibraPol(SHPObject objpol, SHPObject objpolcal, Hashtable CollPnt, String strlog)
{
	double tval=0, tang=0;
	double firstm= 0.0, lastm=0.0;
	int imlast=0, imfirst=0, nv=0;
        SHPPoint pt;

	objpolcal.nVertices = objpol.nVertices;
	ArrayList vpol = new ArrayList();

	// eseguo la compensazione su ogni poly (parte) di objpol
	for (int i=0; i<objpol.nParts; i++)
	{
		SHPPoly pol = objpol.SHPGetPolyPart(i);

		for (int j=0; j<pol.pnt.size(); j++)	// inizializzo i valori di m
                {
                    pt = ((SHPPoint)pol.pnt.get((j)));
                    pt.m = Double.NaN;
                    pol.pnt.set(j, pt);
                }

		// aggiungo i punti proiettati alla poly pol
		for (int j=0; j<CollPnt.size(); j++)
		{
			SHPPoint pnt = ((SHPPoint) CollPnt.get(new Integer(j)));
			SHPPoint ptprj = new SHPPoint();
                        SHPprjptm prjptm = new SHPprjptm();
                        prjptm.pto = pnt;
                        prjptm.ptprj = ptprj;
			int nint = pol.SHPprjpt(prjptm);
			if (nint == 0) continue;
			ptprj.m = pnt.m;
			objpolcal.nVertices++;
                        Double dum = new Double(tval);
			int pos = dum.intValue();
			// aggiungo alla poly il punto proiettato a cui corrisponde un valore di m
			pol.SHPAddPointinPos(pos,ptprj);

			double dst = pnt.SHPdstpt(ptprj);
			strlog += "ptrjX=" + ptprj.x + "ptrjY=" + ptprj.y + "ptrjZ=" + ptprj.z + "ptrjM=" + ptprj.m + "dst=" + dst+ ' ';
		}
		// se i valori di m sono decrescenti, inverto la poly
		if (!GetFirstLastM(pol,firstm,imfirst,lastm,imlast)) return false;
		if (lastm < firstm)
		{
			SHPPoly newpol = new SHPPoly();
			for (int ii=pol.pnt.size()-1; ii>=0; ii--)
			{
				newpol.SHPAddPoint((SHPPoint)pol.pnt.get(ii));
			}
			pol.pnt = newpol.pnt;
			if (!GetFirstLastM(pol,firstm,imfirst,lastm,imlast)) return false;
                }
		// Eseguo la compensazione sulla poly pol
                pt = ((SHPPoint) (pol.pnt.get(0)));
		if (Double.compare(pt.m, Double.NaN) == 0)
                {
                    pt.m = 0.0;
                    pol.pnt.set(0, pt);
                }

		//inizializzazione delle variabili utili per il calcolo delle m
		int iprecm = 0;
		double lunprec = 0.0;
		int inextm = 0;
		boolean res = this.GetNextM(pol,1,inextm); //indice nella poly del prossimo pnt com m
		double lunnext = pol.SHPcallunt(inextm); // lunghezza della poly fino a inextm
		double deltalun = lunnext - lunprec;

		// assegno il valore m all'ultimo punto della poly
		int iend = pol.pnt.size()-1;
                pt = ((SHPPoint) (pol.pnt.get(iend)));
		if (Double.compare(pt.m, Double.NaN) == 0)
		{
			double lend = pol.SHPcallunt(iend); // lunghezza della poly fino a inextm
			double lendm = pol.SHPcallunt(imlast); // lunghezza della poly fino a imend
                        pt.m = lastm + (lend - lendm);
                        pol.pnt.set(iend, pt);
		}
		for (int k=1; k<pol.pnt.size()-1; k++)	// ciclo sui punti della poly saltando il primo e l'ultimo
		{
                    pt = ((SHPPoint)(pol.pnt.get(k)));
                    if (Double.compare(pt.m, Double.NaN) != 0)	//punto con m dato => aggiorno le variabili di calcolo
                    {
			iprecm = k;
			lunprec = pol.SHPcallunt(k);
			if (!this.GetNextM(pol,k+1,inextm)) return false;
			lunnext = pol.SHPcallunt(inextm);
			deltalun = lunnext - lunprec;
			continue;
                    }
                    // punto con m da calcolare
                    double lun = pol.SHPcallunt(k);
                    SHPPoint p1,p2;
                    p1 = ((SHPPoint)(pol.pnt.get(inextm)));
                    p2 = ((SHPPoint)(pol.pnt.get(iprecm)));
                    double deltam = p1.m - p2.m;
                    pt = ((SHPPoint)(pol.pnt.get(k)));
                    pt.m = lun * deltam / deltalun;
                    pol.pnt.set(k, pt);
		}
		vpol.add(pol);
		nv += pol.pnt.size();
	}
	objpolcal.vpolilinee = vpol;
	objpolcal.nVertices = nv;
	objpolcal.SHPCalBox();
	objpolcal.nSHPType = tipo_shpobj.POLYLINEM;
	objpolcal.SHPCalLenght();
	return true;
    }

}
