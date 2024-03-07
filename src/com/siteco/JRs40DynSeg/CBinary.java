package com.siteco.JRs40DynSeg;

import java.util.*;
import java.sql.*;


public class CBinary {
    private ArrayList PosizioniShpO;
    public String RouteField;
    public String Shape;
    public Connection conn;
    /// <summary>
    /// Nome del server
    /// </summary>
    public String Server;
    /// <summary>
    /// password
    /// </summary>
    public String Password;
    public String User;
    public ArrayList CollShpObj;
    /// <summary>
    /// Bounding Box
    /// </summary>
    public Box bbox;
    /// <summary>
    /// Contiene le informazioni della tabella
    /// </summary>
    public ResultSet Table_Info;
    int nRecords;


    /// <summary>
    /// Costruttore con la stringa di connessione al DB
    /// </summary>
    /// <param name="connString"></param>
    public CBinary(Connection conn, String shapeField, String routeField) {
        try {
            User = "";
            Password = "";
            Server = "";
            this.RouteField = routeField;
            this.Shape = shapeField;
            //iRouteFld = 0;
            CollShpObj = new ArrayList();
            //Table_Info = new System.Data.DataTable();
            PosizioniShpO = new ArrayList();
            //DSExpDb=new DataSet(); // Contiene tutte le tabelle che devono essere esportate
            this.conn = conn;
        } catch (Exception eee) {
            System.out.println(eee.getMessage());
        }
    }


    /// <summary>
    /// Chiude la connessione al DB
    /// </summary>
    public void SHCloseDbConn() {
        try {
            this.conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    /// <summary>
    /// Aggiunge un oggetto alla collezione
    /// </summary>
    /*public void AddSHPObj(int id, AbacoSDA obj) {
        this.CollShpObj.add(id, obj);
        this.nRecords++;

        this.Table_Info.getr
        System.Data.DataRow R = this.Table_Info.NewRow();
        //R[_SHAPE] = obj.Convert_to_binary();
        //R[_IDProgressivo] = id;
        this.Table_Info.Rows.Add(R);
         }*/


    /// <summary>
    /// Aggiunge un oggetto alla collezione
    /// </summary>
    public boolean AddSHPObj(AbacoSDA obj, Object[] RigaO) {
        try {
            if (RigaO.length != this.Table_Info.getMetaData().getColumnCount()) {
                return false;
            }

            this.Table_Info.moveToInsertRow();
            for (int i = 0; i < this.Table_Info.getMetaData().getColumnCount();
                         i++) {
                this.Table_Info.updateObject(i, RigaO[i]);
            }
            this.Table_Info.insertRow();

            this.CollShpObj.add(obj);
            this.nRecords++;
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /// <summary>
    /// Verifica se il db e' aperto
    /// </summary>
    /*private bool _IsOpenDB;
         public bool IsOpenDB {
            get {
            if (this.conn != null &&
                this.conn.State == System.Data.ConnectionState.Open) {
        _IsOpenDB = true;
        return _IsOpenDB;
         } else {
        _IsOpenDB = false;
        return false;
         }
         }
         }
            /// <summary>
            /// Se lo shape e' aperto
            /// </summary>
            private bool _IsOpen;
         public bool IsOpen {
            get {
            return _IsOpen;
         }
         }
            /// <summary>
            /// Calcola il box di ingombro
            /// </summary>
      public void SHCalbox() {
        this.bbox = new Box();
        Box b = new Box(MConst.DOUBLEMAX, MConst.DOUBLEMIN);
        AbacoSDA shpobj;
        foreach(DictionaryEntry o in CollShpObj) {
            shpobj = (AbacoSDA) o.Value;
            b.SHPAggBox(shpobj.bbox);
        }
        this.bbox = b;
         }

         private string _RouteField;
         /// <summary>
         /// Nome del campo che contiene la strada
         /// </summary>
         public string RouteField {
            get {
            return _RouteField;
         }
            set {
            _RouteField = value;
         }
         }


            private string _TableCorr;
         /// <summary>
         /// Nome della tabella corrente
         /// </summary>
         public string TableCorr {
            get {
            return _TableCorr;
         }
            set {
            _TableCorr = value;
         }
         }


            private string _SHAPE = "XXSHAPE_";
         private string _IDProgressivo = "XXID_";
         /// <summary>
         /// Progressivo  dello shape di default= _ID
         /// </summary>
         public string IDProgressivo {
            get {
            return _IDProgressivo;
         }
            set {
            _IDProgressivo = value;
         }
         }
            /// <summary>
            /// nome della colonna che contiene la geometria
            /// </summary>
            public string Shape {
            get {
            return _SHAPE;
         }
            set {
            _SHAPE = value;
         }
         }*/
    /*
                     /// <summary>
                     /// Legge il tipo dell'oggetto
                     /// </summary>
                     /// <returns></returns>
                     public tipo_shpobj leggi_tipo()
                     {
            tipo_shpobj tipo;
            int itipo = this.r1.ReadInt32();
            switch(itipo)
            {
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
                     }*/

    /// <summary>
    /// Legge le informazioni della tabella
    /// </summary>
    /// <param name="TableName"></param>
    /// <returns>true = ok</returns>
    public boolean ReadTable(String TableName) {
        try {
            AbacoSDA shpobj;

            if (this.conn == null) {
                return false;
            }

            String query = "SELECT * FROM " + TableName;
            Statement stm = conn.createStatement(ResultSet.
                                                 TYPE_SCROLL_SENSITIVE,
                                                 ResultSet.CONCUR_UPDATABLE);

            this.Table_Info = stm.executeQuery(query);

            int shapeIndex = -1;

            try {
                shapeIndex = this.Table_Info.findColumn(this.Shape);
            } catch (Exception ee) {
                System.out.println(ee.getMessage());
                return false;
            }

            while (this.Table_Info.next()) {
                byte[] geometria = this.Table_Info.getBytes(shapeIndex);
                shpobj = new AbacoSDA(geometria);
                shpobj.SHPCalBox();
                this.CollShpObj.add(shpobj);
            }

            this.Table_Info.last();
            this.nRecords = this.Table_Info.getRow();

            this.Table_Info.beforeFirst();

            this.SHCalbox();
            return true;

        } catch (Exception caught) {
            System.out.println(caught.getMessage());
            return false;
        }
    }

    /// <summary>
    /// Scrive la tabella corrispondente al CBinary
    /// </summary>
    /// <param name="TableName"></param>
    /// <returns></returns>
    public boolean WriteTable(String TableName) {
        if (this.Table_Info == null) {
            return false;
        }

        //creo la tabella nel db
        if (this.conn == null) {
            return false;
        }

        Statement stm;
        String drop = "DROP TABLE " + TableName;

        //se esiste una tabella con lo stesso nome la cancello
        try {
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                       ResultSet.CONCUR_UPDATABLE);
        } catch (Exception ee) {
            System.out.println(ee.getMessage());
            return false;
        }

        try {
            stm.execute(drop);
        } catch (Exception ee) {
            System.out.println(ee.getMessage());
        }

        //creo la stringa di creazione tabella
        String createTable = "CREATE TABLE " + TableName + " (";
        ArrayList colonne = this.MappaTipoColonneDT();

        try {
            for (int i = 1; i < colonne.size() + 1; i++) {

                int tipoSQL = (Integer) colonne.get(i - 1);
                System.out.println(this.typeToString(tipoSQL));
                switch (tipoSQL) {
                case java.sql.Types.BIGINT: {
                    //se ho sql server
                    if (this.conn.getMetaData().getDatabaseProductName().startsWith(
                            "Microsoft")) {
                        createTable += this.Table_Info.getMetaData().
                                getColumnName(i) +
                                " BIGINT";
                        if (i == colonne.size()) {
                            createTable += ")";
                        } else {
                            createTable += ", ";
                        }
                    }
                    //se ho oracle
                    else if (this.conn.getMetaData().getDatabaseProductName().startsWith(
                            "Oracle")) {
                        createTable += this.Table_Info.getMetaData().
                                getColumnName(i) +
                                " INTEGER";
                        if (i == colonne.size()) {
                            createTable += ")";
                        } else {
                            createTable += ", ";
                        }
                    }

                    break;
                }

                case java.sql.Types.INTEGER:
                case java.sql.Types.SMALLINT: {
                    if (this.conn.getMetaData().getDatabaseProductName().startsWith(
                            "Microsoft")) {
                        createTable += this.Table_Info.getMetaData().
                                getColumnName(i) +
                                " INT";
                        if (i == colonne.size()) {
                            createTable += ")";
                        } else {
                            createTable += ", ";
                        }
                    }
                    //se ho oracle
                    else if (this.conn.getMetaData().getDatabaseProductName().
                             startsWith(
                                     "Oracle")) {
                        createTable += this.Table_Info.getMetaData().
                                getColumnName(i) +
                                " INTEGER";
                        if (i == colonne.size()) {
                            createTable += ")";
                        } else {
                            createTable += ", ";
                        }
                    }
                    break;
                }
                case java.sql.Types.DOUBLE:
                case java.sql.Types.FLOAT:
                case java.sql.Types.DECIMAL:
                case java.sql.Types.NUMERIC:
                case java.sql.Types.REAL: {
                    //se ho sql server
                    if (this.conn.getMetaData().getDatabaseProductName().startsWith(
                            "Microsoft")) {
                        createTable += this.Table_Info.getMetaData().
                                getColumnName(i) +
                                " FLOAT";
                        if (i == colonne.size()) {
                            createTable += ")";
                        } else {
                            createTable += ", ";
                        }
                    }
                    //se ho oracle
                    else if (this.conn.getMetaData().getDatabaseProductName().startsWith(
                            "Oracle")) {
                        createTable += this.Table_Info.getMetaData().
                                getColumnName(i) +
                                " DECIMAL";
                        if (i == colonne.size()) {
                            createTable += ")";
                        } else {
                            createTable += ", ";
                        }
                    }

                    break;
                }
                case java.sql.Types.BLOB:
                case java.sql.Types.BINARY:
                case java.sql.Types.LONGVARBINARY:
                {
                    //se ho sql server
                    if (this.conn.getMetaData().getDatabaseProductName().startsWith(
                            "Microsoft")) {
                        createTable += this.Table_Info.getMetaData().
                                getColumnName(i) +
                                " IMAGE";
                        if (i == colonne.size()) {
                            createTable += ")";
                        } else {
                            createTable += ", ";
                        }
                    }
                    //se ho oracle
                    else if (this.conn.getMetaData().getDatabaseProductName().startsWith(
                            "Oracle")) {
                        createTable += this.Table_Info.getMetaData().
                                getColumnName(i) +
                                " BLOB";
                        if (i == colonne.size()) {
                            createTable += ")";
                        } else {
                            createTable += ", ";
                        }
                    }

                    break;
                }

                default: {
                    //se ho sql server
                    if (this.conn.getMetaData().getDatabaseProductName().startsWith(
                            "Microsoft")) {
                        createTable += this.Table_Info.getMetaData().
                                getColumnName(i) +
                                " NVARCHAR(255)";
                        if (i == colonne.size()) {
                            createTable += ")";
                        } else {
                            createTable += ", ";
                        }
                    }
                    //se ho oracle
                    else if (this.conn.getMetaData().getDatabaseProductName().startsWith(
                            "Oracle")) {
                        createTable += this.Table_Info.getMetaData().
                                getColumnName(i) +
                                " VARCHAR2(255)";
                        if (i == colonne.size()) {
                            createTable += ")";
                        } else {
                            createTable += ", ";
                        }
                    }

                    break;
                }
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        //creo la tabella. se qualcosa va storto ritorno false
        try {
            stm.execute(createTable);
        } catch (Exception ee) {
            //conn.close();
            System.out.println(ee.getMessage());
            return false;
        }

        //popolo la tabella
        try {
            ResultSet rsTemp = stm.executeQuery("SELECT * FROM " + TableName);
            while (this.Table_Info.next()) {
                rsTemp.moveToInsertRow();
                for (int i = 1;
                             i < this.Table_Info.getMetaData().getColumnCount() + 1;
                             i++) {
                    rsTemp.updateObject(i, this.Table_Info.getObject(i));
                }
                rsTemp.insertRow();
            }
            conn.commit();
        } catch (Exception e) {
            //conn.close();
            System.out.println(e.getMessage());
            return false;
        }
        //conn.Close();
        return true;
    }

    private int ColLunMax(ResultSet DT, String NomeCol) {
        try {
            DT.last();
            int mm = 0, N = DT.getRow();
            DT.beforeFirst();
            while (this.Table_Info.next()) {
                String s = this.Table_Info.getString(NomeCol);
                if (mm <= s.length()) {
                    mm = s.length();
                }
            }
            DT.beforeFirst();
            return mm;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }


    /// <summary>
    /// Cambia il nome della tabella/foglio per renderlo compatibile con OleDB
    /// </summary>
    /// <param name="NomeTab">Nome della tabella</param>
    /// <returns>Nuovo Nome</returns>
    private String CambiaNomeTab(String NomeTab) {

        String res = NomeTab.replace(".", "");
        res = res.replace("&", "");
        res = res.replace("|", "");
        res = res.replace("^", "");
        res = res.replace("@", "");
        res = res.replace(" ", "_");
        //res = res.replace(" ", "D");
        return res;
    }


    /// <summary>
    /// Salva in un array il tipo di ogni colonna della dataTable
    /// </summary>
    /// <param name="shp"></param>
    /// <returns></returns>
    private ArrayList MappaTipoColonneDT() {
        ArrayList colonne = new ArrayList();
        try {
            for (int i = 1;
                         i < this.Table_Info.getMetaData().getColumnCount() + 1;
                         i++) {
                colonne.add(this.Table_Info.getMetaData().getColumnType(i));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return colonne;
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

    private String typeToString(int type) {
        switch (type) {
        case java.sql.Types.ARRAY:
            return "ARRAY";
        case java.sql.Types.BIGINT:
            return "BIGINT";
        case java.sql.Types.BINARY:
            return "BINARY";
        case java.sql.Types.BIT:
            return "BIT";
        case java.sql.Types.BLOB:
            return "BLOB";
        case java.sql.Types.CHAR:
            return "CHAR";
        case java.sql.Types.CLOB:
            return "CLOB";
        case java.sql.Types.DATE:
            return "DATE";
        case java.sql.Types.DECIMAL:
            return "DECIMAL";
        case java.sql.Types.DISTINCT:
            return "DISTINCT";
        case java.sql.Types.DOUBLE:
            return "DOUBLE";
        case java.sql.Types.FLOAT:
            return "FLOAT";
        case java.sql.Types.INTEGER:
            return "INTEGER";
        case java.sql.Types.JAVA_OBJECT:
            return "JAVA_OBJECT";
        case java.sql.Types.LONGVARBINARY:
            return "LONGVARBINARY";
        case java.sql.Types.LONGVARCHAR:
            return "LONGVARCHAR";
        case java.sql.Types.NULL:
            return "NULL";
        case java.sql.Types.NUMERIC:
            return "NUMERIC";
        case java.sql.Types.OTHER:
            return "OTHER";
        case java.sql.Types.REAL:
            return "REAL";
        case java.sql.Types.REF:
            return "REF";
        case java.sql.Types.SMALLINT:
            return "SMALLINT";
        case java.sql.Types.STRUCT:
            return "STRUCT";
        case java.sql.Types.TIME:
            return "TIME";
        case java.sql.Types.TIMESTAMP:
            return "TIMESTAMP";
        case java.sql.Types.TINYINT:
            return "TINYINT";
        case java.sql.Types.VARBINARY:
            return "VARBINARY";
        case java.sql.Types.VARCHAR:
            return "VARCHAR";
        default:
            return "UNKNOWN_SQL_TYPE?";
        }
    }
}
