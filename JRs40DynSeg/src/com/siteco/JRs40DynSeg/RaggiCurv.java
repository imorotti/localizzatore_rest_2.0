/*
 * RaggiCurv.java
 *
 * Created on 17 marzo 2006, 15.14
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.siteco.JRs40DynSeg;

//import com.sun.org.apache.xpath.internal.operations.String;
import java.lang.Object.*;
import java.util.*;
import java.lang.*;
 /**
 *
 * @author vanna
 */
public class RaggiCurv {
    
    /** Creates a new instance of RaggiCurv */
    public RaggiCurv() {
    }
    public ArrayList modo_percorso = new ArrayList();
    public ArrayList lista_raggi = new ArrayList();
    public ArrayList lista_versi = new ArrayList();

    // public System.Data.DataTable DT_RIS = new System.Data.DataTable();

    public static int modoarco = 1;
    public static int modoretta = 2;

    public static int ORARIO = 1;
    public static int ANTIORARIO = 2;

    public static int perc_altimetrico = 1;
    public static int perc_piano = 2;

    
    // VV provvisorio
    public raggi_parametri RP = new raggi_parametri();


/// <summary>
/// Calcola la nuova polyline seguendo il percorso altimetrico: ogni punto ha come x la distanza
/// dal punto iniziale e come y la z della poly originale; la m rimane invariata
/// </summary>
    public void crea_pol_alt(SHPPoly pol_in,SHPPoly pol_out)
    {
	double lun = 0.0;
	SHPPoint pt = new SHPPoint();
	pt.x = lun;
	pt.y = ((SHPPoint)(pol_in.pnt.get(0))).z;
	pt.m = ((SHPPoint)(pol_in.pnt.get(0))).m;
	pt.z = 0.0;
	pol_out.pnt.add(pt);
	for (int i=1; i<pol_in.pnt.size(); i++)
	{
		SHPPoint p1,p2;
		p1 = ((SHPPoint)(pol_in.pnt.get(i-1)));
		p2 = ((SHPPoint)(pol_in.pnt.get(i)));
		lun += p1.SHPdstpt(p2);
		SHPPoint pt1 = new SHPPoint();
		pt1.x = lun;
		pt1.y = ((SHPPoint)(pol_in.pnt.get(i))).z;
		pt1.m = ((SHPPoint)(pol_in.pnt.get(i))).m;
		pt1.z = 0.0;
		pol_out.pnt.add(pt1);
	}
    }

/// <summary>
/// Riempio i vettori modo_percorso,lista_versi e lista_raggi prendendo in considerazione 3 pnt consecutivi;
/// se l'arco per i punti p0-p1-p2 ha un raggio superiore a quello limite allora considero il tratto
/// p0-p2 come rettifilo altrimenti lo consirero un arco e memorizzo il suo raggio di curvatura e
/// il verso di percorrenza (orario o antiorario).
/// </summary>
    public void riempi_liste(raggi_parametri RP,SHPPoly pol)
    {
	double x,y;
	int vv;
        Double dum;
        Integer modo,verso;
	for (int i=1; i<pol.pnt.size()-1;)
	{
		x = ((SHPPoint)(pol.pnt.get(i-1))).x;
		y = ((SHPPoint)(pol.pnt.get(i-1))).y;
		SHPPoint p1 = new SHPPoint(x,y);
		x = ((SHPPoint)(pol.pnt.get(i))).x;
		y = ((SHPPoint)(pol.pnt.get(i))).y;
		SHPPoint p2 = new SHPPoint(x,y);
		x = ((SHPPoint)(pol.pnt.get(i+1))).x;
		y = ((SHPPoint)(pol.pnt.get(i+1))).y;
		SHPPoint p3 = new SHPPoint(x,y);
		SHPArco a = new SHPArco();
		if (a.SHPArc3pnt(p1,p3,p2))
		{
                    dum = new Double(a.raggio);
                    lista_raggi.add(dum);
                    double angc = MConst.angcen(a.angi,a.angf,MConst.ANTIORARIO);
			/// Prepara il vettore modo_percorso con i codici retta-arco 
                    if (a.raggio < RP.rag && angc > RP.ang)	// percorso curvilineo
                    {
                        modo = new Integer(modoarco);
			modo_percorso.add(modo);
			double ang = a.centro.SHPangx(p1);
			if (ang == a.angi)
                            verso = new Integer(ANTIORARIO);
			else
                            verso = new Integer(ORARIO);
                    }
                    else		// percorso rettilineo
                    {
                        modo = new Integer(modoretta);
			modo_percorso.add(modo);
			verso = new Integer(0);
                    }
                    lista_versi.add(verso);
		}
		else
		{
                    dum = new Double(0.0);
                    lista_raggi.add(dum);
                    modo = new Integer(modoretta);
                    modo_percorso.add(modo);
                    verso = new Integer(0);
                    lista_versi.add(verso);
		}
		i = i+2;
	}
    }

/// <summary>
/// modifico il vettore modo_percorso prendendo in considerazione intervalli di 4 pnt consecutivi;
/// se l'arco per i punti p0-p2-p4 ha un raggio superiore a quello limite allora considero il tratto
/// p0-p4 come rettifilo
/// </summary>
    public void compatta_liste_2(raggi_parametri RP,SHPPoly pol)
    {
	double x,y;
        Double dum = new Double(0.0);
        Integer idum = new Integer(modoretta);
	for (int i=2; i<pol.pnt.size()-2;)
	{
		x = ((SHPPoint)(pol.pnt.get(i-2))).x;
		y = ((SHPPoint)(pol.pnt.get(i-2))).y;
		SHPPoint p1 = new SHPPoint(x,y);
		x = ((SHPPoint)(pol.pnt.get(i))).x;
		y = ((SHPPoint)(pol.pnt.get(i))).y;
		SHPPoint p2 = new SHPPoint(x,y);
		x = ((SHPPoint)(pol.pnt.get(i+2))).x;
		y = ((SHPPoint)(pol.pnt.get(i+2))).y;
		SHPPoint p3 = new SHPPoint(x,y);
		SHPArco a = new SHPArco();
		if (a.SHPArc3pnt(p1,p2,p3))
		{
			if (a.raggio > RP.rag)
			{
				modo_percorso.set((i/2)-1, idum); 
                                modo_percorso.set(i/2, idum);
				lista_raggi.set((i/2)-1, dum);
                                lista_raggi.set(i/2, dum);
			}
		}
		else
		{
			modo_percorso.set((i/2)-1, idum);
                        modo_percorso.set(i/2, idum);
			lista_raggi.set((i/2)-1, dum);
                        lista_raggi.set(i/2, dum);
		}
		i = i+4;
	}
    }
/// <summary>
/// modifico il vettore modo_percorso prendendo in considerazione intervalli di 6 pnt consecutivi;
/// se l'arco per i punti p0-p3-p6 ha un raggio superiore a quello limite allora considero il tratto
/// p0-p6 come rettifilo
/// </summary>
    public void compatta_liste_3(raggi_parametri RP,SHPPoly pol)
    {
	double x,y;
        Double dum = new Double(0.0);
        Integer idum = new Integer(modoretta);
	for (int i=3; i<pol.pnt.size()-3;)
	{
		x = ((SHPPoint)(pol.pnt.get(i-3))).x;
		y = ((SHPPoint)(pol.pnt.get(i-3))).y;
		SHPPoint p1 = new SHPPoint(x,y);
		x = ((SHPPoint)(pol.pnt.get(i))).x;
		y = ((SHPPoint)(pol.pnt.get(i))).y;
		SHPPoint p2 = new SHPPoint(x,y);
		x = ((SHPPoint)(pol.pnt.get(i+3))).x;
		y = ((SHPPoint)(pol.pnt.get(i+3))).y;
		SHPPoint p3 = new SHPPoint(x,y);
		SHPArco a = new SHPArco();
		if (a.SHPArc3pnt(p1,p2,p3))
		{
			if (a.raggio > RP.rag)
			{
				modo_percorso.set((i/3)-1, idum);
                                modo_percorso.set(i/3, idum);
                                modo_percorso.set((i/3)+1, idum);
				lista_raggi.set((i/3)-1, dum); 
                                lista_raggi.set(i/3,dum);
                                lista_raggi.set((i/3)+1, dum);
			}
		}
		else
		{
			modo_percorso.set((i/3)-1, idum);
                        modo_percorso.set(i/3, idum);
                        modo_percorso.set((i/3)+1, idum);
			lista_raggi.set((i/3)-1, dum);
                        lista_raggi.set(i/3, dum);
                        lista_raggi.set((i/3)+1, dum);
		}
		i = i+6;
	}
    }
/// <summary>
/// modifico il vettore modo_percorso prendendo in considerazione intervalli di 8 pnt consecutivi;
/// se l'arco per i punti p0-p4-p8 ha un raggio superiore a quello limite allora considero il tratto
/// p0-p8 come rettifilo
/// </summary>
    public void compatta_liste_4(raggi_parametri RP,SHPPoly pol)
    {
	double x,y;
        Double dum = new Double(0.0);
        Integer idum = new Integer(modoretta);
	for (int i=4; i<pol.pnt.size()-4;)
	{
		x = ((SHPPoint)(pol.pnt.get(i-4))).x;
		y = ((SHPPoint)(pol.pnt.get(i-4))).y;
		SHPPoint p1 = new SHPPoint(x,y);
		x = ((SHPPoint)(pol.pnt.get(i))).x;
		y = ((SHPPoint)(pol.pnt.get(i))).y;
		SHPPoint p2 = new SHPPoint(x,y);
		x = ((SHPPoint)(pol.pnt.get(i+4))).x;
		y = ((SHPPoint)(pol.pnt.get(i+4))).y;
		SHPPoint p3 = new SHPPoint(x,y);
		SHPArco a = new SHPArco();
		if (a.SHPArc3pnt(p1,p2,p3))
		{
			if (a.raggio > RP.rag)
			{
				modo_percorso.set((i/4)-1, idum);
                                modo_percorso.set(i/4, idum);
                                modo_percorso.set((i/4)+1, idum); 
                                modo_percorso.set((i/4)+2, idum);
				lista_raggi.set((i/4)-1, dum); 
                                lista_raggi.set(i/4, dum);
                                lista_raggi.set((i/4)+1, dum); 
                                lista_raggi.set((i/4)+2, dum);
			}
		}
		else
		{
			modo_percorso.set((i/4)-1, idum);
                        modo_percorso.set(i/4, idum);
                        modo_percorso.set((i/4)+1, idum);
                        modo_percorso.set((i/4)+2, idum);
			lista_raggi.set((i/4)-1, dum); 
                        lista_raggi.set(i/4, dum);
                        lista_raggi.set((i/4)+1, dum); 
                        lista_raggi.set((i/4)+2, dum);
		}
		i = i+8;
	}
    }

/// <summary>
/// Elimina le situazioni tipo retta-arco-retta trasformandole in retta-retta-retta 
/// </summary>
    public void controlla_percorso(raggi_parametri RP)
    {
        int npart = modo_percorso.size();
        Integer idum = new Integer(modoretta);
        Double ddum;

	for (int i=1; i<npart-1; i++)
	{
		if (modo_percorso.get(i) == idum) continue;

		if ((modo_percorso.get(i-1) == idum) && (modo_percorso.get(i+1) == idum) && 
			(((Double)lista_raggi.get(i)).doubleValue() < RP.rag_toll))

			modo_percorso.set(i, idum);
	}
    }

/// <summary>
/// Memorizza il singolo percorso secondo il modo registrato nel vettore modo_percorso 
/// </summary>
    public void memorizza_percorso(raggi_parametri RP,SHPPoly pol,long road)
    {
	int np = modo_percorso.size();
	int first_i=0;
	int last_i=0;
        Integer iretta = new Integer(modoretta);
        Integer iarco = new Integer(modoarco);
        boolean b1,b2;
	for (int i=0; i<np; i++)
	{
            if (((Integer)modo_percorso.get(i)).intValue() == modoretta)	//compatto la retta sino al prossimo arco
            {
                b1 = (i==np-1) ? true : false ;
                b2 = (((Integer)modo_percorso.get(i+1)).intValue() == modoarco) ? true : false;
                if (b1 || b2)
                // lo memorizzo se e' l'ultimo rettifilo o se dopo segue un arco
                {
                    last_i = (i+1)*2;
                    Memorizza_Retta(pol,first_i,last_i,road);
                    if (i < (np-1)) first_i = (i+1)*2;
                }
            }
            else
            {
                b1 = (i==np-1) ? true:false;
                b2 = (((Integer)modo_percorso.get(i+1)).intValue() == modoretta) ? true : false;
                if (b1 || b2)
		// lo memorizzo se e' l'ultimo arco o se dopo segue un rettifilo
                {
                    last_i = (i+1)*2;
                    Memorizza_Arco(pol,first_i,last_i,road);
                    if (i < (np-1)) first_i = (i+1)*2;
                    continue;
                }
		// Segue un arco. Se archi_sing memorizzo un arco alla volta, altrimenti cerco di compattarli
                if (RP.archi_sing)
                {
                    last_i = (i+1)*2;
                    Memorizza_Arco(pol,first_i,last_i,road);
                    if (i < (np-1)) first_i = (i+1)*2;
                    continue;
                }
                else
		{
                    // Lo memorizzo se segue un arco di verso opposto 
                    if (((Integer)lista_versi.get(i)).intValue() != ((Integer)(lista_versi.get(i+1))).intValue())
                    {
			last_i = (i+1)*2;
			Memorizza_Arco(pol,first_i,last_i,road);
			if (i < (np-1)) first_i = (i+1)*2;
			continue;
                    }
                    double min_rag = Math.min(((Double)lista_raggi.get(i)).doubleValue(),
                                              ((Double)lista_raggi.get(i+1)).doubleValue());
                    double max_rag = Math.max(((Double)lista_raggi.get(i)).doubleValue(),
                                              ((Double)lista_raggi.get(i+1)).doubleValue());
                    double per = min_rag / max_rag * 100.0;
                    // lo memorizzo se segue un arco con una differenza di raggio superiore al per_rag_eli%
                    if (per < RP.per_rag_eli)
                    {
			last_i = (i+1)*2;
			Memorizza_Arco(pol,first_i,last_i,road);
			if (i < (np-1)) first_i = (i+1)*2;
			continue;
                    }
                }
            }
	}
    }
    
    public boolean Memorizza_Arco(SHPPoly pol,int first_i,int last_i,long road)
    {
	double rag;
	if ((last_i - first_i) > 2)
		// devo prendere in considerazione una sequenza di archi di cui calcolo la media dei raggi
	{
		int narchi = (last_i - first_i)/2;
		int pos = first_i/2;
		double tot_rag=0.0;
		for (int i=0; i<narchi; i++)
		{
			tot_rag += ((Double)(lista_raggi.get(pos++))).doubleValue();
		}
		rag = tot_rag / narchi;
	}
	else
	{
		int pos = first_i / 2;
		rag = ((Double)(lista_raggi.get(pos))).doubleValue();
	}

/*
	DataRow r = DT_RIS.NewRow();
	r["ROAD_ID"] = road;
	r["FROM_M"] = ((SHPPoint)(pol.pnt.get(first_i))).m;
	r["TO_M"] = ((SHPPoint)(pol.pnt.get(last_i))).m;
	r["RAGGIO"] = rag;
	DT_RIS.Rows.Add(r);
 **/
	return true;
    }

    public void Memorizza_Retta(SHPPoly pol,int first_i,int last_i,long road)
    {
        /*
	DataRow r = DT_RIS.NewRow();
	r["ROAD_ID"] = road;
	r["FROM_M"] = ((SHPPoint)(pol.pnt[first_i])).m;
	r["TO_M"] = ((SHPPoint)(pol.pnt[last_i])).m;
	r["RAGGIO"] = 0.0;
	DT_RIS.Rows.Add(r);
         */
    }

    public int ScriviRisSuFile(String Nomefile) 
    {
	// System.IO.StreamWriter Sw = new StreamWriter(Nomefile,false,System.Text.Encoding.ASCII);
	String Linea = " ";
        /*
	foreach(DataColumn c in this.DT_RIS.Columns) 
	{
		Linea += c.ColumnName+"\t";
	}
	Linea = Linea.Substring(0,Linea.Length-1);
	Sw.WriteLine(Linea);
	foreach(DataRow R in DT_RIS.Rows) 
	{
		Linea = R["ROAD_ID"].ToString()+"\t";
		Linea += Convert.ToDouble(R["FROM_M"]).ToString("#.##0")+"\t";
		Linea += Convert.ToDouble(R["TO_M"]).ToString("#.##0")+"\t";
		Linea += Convert.ToDouble(R["RAGGIO"]).ToString("#.##0");
		Sw.WriteLine(Linea);
	}
         */
	// Sw.Close();
/*
#if false
			CShapeFile sp = new CShapeFile();
			string Dir = System.IO.Path.GetDirectoryName(Nomefile);
			string Nomefile1 = System.IO.Path.GetFileNameWithoutExtension(Nomefile);
			DT_RIS.TableName = Nomefile1;
		
			string cnStr = "Provider=Microsoft.Jet.OLEDB.4.0;Extended Properties=\"dBase III;hdr=Yes\";Data Source="+Dir+";";
			string str_from = Nomefile1+".dbf";
			if (System.IO.File.Exists(str_from)) System.IO.File.Delete(str_from);
			sp.ScriviFileDBF(cnStr,DT_RIS,Nomefile1);
#endif
 */
	return 0;
    }


}
