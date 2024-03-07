package com.siteco.JRs40DynSeg;

import java.sql.*;
class test {
    public static void main (String [] args)
    {
        //CShapeFile cs = new CShapeFile();
        //cs.SHReadShapefile("C:\\Temp\\cesano.shp");
        //cs.SHWriteShapefile("C:\\Temp\\prova");
        //cs.SHReadShapefile("C:\\Temp\\prova.shp");




        DynSeg ds = new DynSeg();
        ds.DSSetShapefile("C:\\Tomcat5028\\webapps\\modena\\RDSROAD.shp", "ROAD_ID");
        //SHPPoint[] points = ds.DSGetPoint("75", 11, 0);
        //SHPprjptm prjptm = ds.DSGetMeasureR("75", points[0]);
        //points[0].x = points[0].x + 20;
        //points[0].y = points[0].y + 20;
        SHPPoint point = new SHPPoint(660450, 953360);
        SHPprjptm prjptm = ds.DSGetMeasure(point, "");
        //SHPPoint pt = new SHPPoint(1512470.24, 5052204.42, 0, 0);
        //SHPprjptm prjptm = ds.DSGetMeasureR("223", pt);
        //prjptm = ds.DSGetMeasureR("223", pt, 0.0);
        //prjptm = ds.DSGetMeasureR(prjptm, 0);
        System.out.println(prjptm.mval);

        /*try {
            //Class.forName("jdbc:odbc:TestAbaco");
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String url = "jdbc:odbc:TestAbaco";
            Connection conn = DriverManager.getConnection(url, "", "");
            System.out.println("ok");
            CBinary cb = new CBinary(conn, "SHAPE", "ROAD_ID");
            cb.ReadTable("CESANO_ABACO");
            cb.WriteTable("CESANO_ABACO2");
            DynSegDB db = new DynSegDB(conn);
            db.DSSetRouteTable("CESANO_ABACO", "ROAD_ID", "SHAPE");




            SHPPoint pt = new SHPPoint(1512470.24, 5052204.42, 0, 0);
            SHPprjptm prjptm = db.DSGetMeasureR("223", pt);
            prjptm = db.DSGetMeasureR("223", pt, 0.0);
            prjptm = db.DSGetMeasureR(prjptm, 0);
            System.out.println(prjptm.mval);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }*/

    }
}
