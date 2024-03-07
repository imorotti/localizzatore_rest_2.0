package com.siteco.JRs40DynSeg;
/*
 * MConst.java
 *
 * Created on 9 febbraio 2006, 16.09
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */
import java.lang.*;
import java.math.*;
/**
 *
 * @author vanna
 */
public class MConst {
    
    /** Creates a new instance of MConst */
    public MConst() {
    }
    public static int		ORARIO = 1;
    public static int		ANTIORARIO = 2;
    public static double	DOUBLEMAX=1.0e36;
    public static double	DOUBLEMIN=-1.0e36;
    public static double	TOLL=1.0e-4;
    public static double	MRAD =   1.0e-3;
    public static double	TOLANG =  1.0e-3;
    public static double	GRQUINDICI   =   0.261799388;
    public static double	PIQUARTI     =   0.785398163;
    public static double	PIMEZZI      =   1.570796327;
    public static double	PITREQUARTI  =   2.35619449;
    public static double	PIGRECO      =   3.141592654;
    public static double	PICINQUEQUARTI = 3.926990817;
    public static double	PITREMEZZI   =   4.71238898;
    public static double	PISETTEQUARTI=   5.497787144;
    public static double	DUEPIGRECO   =   6.283185307;
    public static double	DUEPIGRECO10 =   62.83185307;

/// <summary>
///  Calcola l'angolo al centro [0,2pi] dati i due estremi ang1, ang2
///  dato il verso di percorrenza dell'arco.
/// </summary>
/// <param name="ang1">estremi ang1</param>
/// <param name="ang2">estremi ang2</param>
/// <param name="verso">MConst.ANTIORARIO or MConst.ORARIO</param>
/// <returns>angolo</returns>
    public static double angcen(double ang1,double ang2,int verso)
    {
        double ang;
        if (verso == MConst.ANTIORARIO) 
            ang = ((ang2 < ang1) ? (ang2 + MConst.DUEPIGRECO - ang1) : (ang2 - ang1));
        else
            ang = ((ang1 < ang2) ? (ang1 + MConst.DUEPIGRECO - ang2) : (ang1 - ang2));

        if (ang > MConst.DUEPIGRECO) ang -= MConst.DUEPIGRECO;
        if (ang < 0.0) ang += MConst.DUEPIGRECO;
        return ang;
    }
/// <summary>
/// Verifica se il valore val (relativo solo alla misura) e' un 'no data' value per lo shape file;
/// in questo caso gli assegno il valore NaN
/// </summary>
/// <param name ="mval">misura</param>
/// <returns></returns>
    public static double nodata_in(double mval)
    {
        if (mval <= -1.0e38) return Double.NaN;
        return mval;
    }
/// <summary>
/// Se il valore val (relativo solo alla misura) e' un NaN gli assegno -1.0e38
/// </summary>
/// <param name ="mval">misura</param>
/// <returns></returns>
    public static double nodata_out(double mval)
    {
        if (Double.isNaN(mval)) return -1.0e38;
        return mval;
    }
}
