/*
 * DBFFile.java
 *
 * Created on 28 marzo 2006, 16.16
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.siteco.JRs40DynSeg;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;
import com.svcon.jdbf.*;

/**
 *
 * @author vanna
 */
public class DBFFile {

    /** Creates a new instance of DBFFile */
    public DBFFile() {
    }

    private DBFReader dbf_r;
    private DBFWriter dbf_w;

    public ArrayList [] lista_obj;
    public JDBField [] jlist;
    public int nrecorddbf  = 0;
    public int ncol = 0;


    public boolean DBFOpenFile(String nomefile_dbf)
    {
        nrecorddbf = 0;
        ncol = 0;
        try
        {
            dbf_r = new DBFReader(nomefile_dbf);

        }
	catch (Exception e)
	{
            return false;
	}
        int n_field = dbf_r.getFieldCount();
        ncol = n_field;
        //lista_obj = new ArrayList[n_field];
        lista_obj = new ArrayList[n_field + 1];
        jlist = new JDBField[n_field + 1];
        for (int i=0; i<n_field; i++)
        {
            jlist[i] = dbf_r.getField(i);
            lista_obj[i] = new ArrayList();
        }

        //aggiungo il campo XXID_
        try {
            jlist[n_field] = new JDBField("XXID_", 'N', 10, 0);
            lista_obj[n_field] = new ArrayList();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }


        while (dbf_r.hasNextRecord())
        {
            Object [] o;
            try
            {
                o = dbf_r.nextRecord();
            }
            catch (Exception e1)
            {
                return false;
            }
            for (int i=0; i<n_field; i++)
            {
                try {
                    lista_obj[i].add(jlist[i].parse(o[i].toString()));
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                    return false;
                }
            }
            nrecorddbf++;
        }

        //popolo XXID_
        for (int i = 0; i < nrecorddbf; i++)
        {
            lista_obj[n_field].add(i);
        }

        try
        {
            dbf_r.close();
        }
        catch (Exception e1)
        {
            System.out.println(e1.getMessage());
            return false;
        }
        return true;
    }

    public boolean AddRecord(Object[] o) {
        if (this.ncol != o.length)
            return false;

        for (int i=0; i < this.ncol; i++) {
            try {
                lista_obj[i].add(jlist[i].parse(o[i].toString()));
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
                return false;
            }
        }
        this.lista_obj[this.ncol].add(nrecorddbf);
        nrecorddbf++;
        return true;
    }

    public String DBFGetName(int nc) {
        return dbf_r.getField(nc).getName();
    }

    public long DBFGetNumeric(int nriga,String nome)
    {
        int n_field = jlist.length;
        for (int i=0; i<n_field;i++)
        {
            if (jlist[i].getName().compareTo(nome) == 0)
            {
                if (jlist[i].getType()== 'N') {
                    Object o =lista_obj[i].get(nriga);

                    return ((Long) o).longValue();
                }
                else
                    return Long.MAX_VALUE;
            }
        }
        return  Long.MAX_VALUE;
    }

    public String DBFGetCharacter(int nriga,String nome)
    {
        int n_field = jlist.length;
        for (int i=0; i<n_field;i++)
        {
            if (jlist[i].getName().compareTo(nome) == 0)
            {
                if (jlist[i].getType()== 'C') {
                    Object o = lista_obj[i].get(nriga);

                    return ((String) o).toString();
                }
                else
                    return "";
            }
        }
        return "";
    }

    public boolean DBFGetLogical(int nriga,String nome)
    {
        int n_field = jlist.length;
        for (int i=0; i<n_field;i++)
        {
            if (jlist[i].getName().compareTo(nome) == 0)
            {
                if (jlist[i].getType()== 'L'){
                    Object o = lista_obj[i].get(nriga);

                    return ((Boolean) o).booleanValue();
                }

                else
                    return false;
            }
        }
        return false;
    }

    public Date DBFGetDate(int nriga,String nome)
    {

        int n_field = jlist.length;
        for (int i=0; i<n_field;i++)
        {
            if (jlist[i].getName().compareTo(nome) == 0)
            {
                if (jlist[i].getType()== 'D'){
                    Object o = lista_obj[i].get(nriga);

                    return (Date) o;
                }

                else
                    return null;
            }
        }
        return null;
    }

    public double DBFGetFloat(int nriga,String nome)
    {
        int n_field = jlist.length;
        for (int i=0; i<n_field;i++)
        {
            if (jlist[i].getName().compareTo(nome) == 0)
            {
                if (jlist[i].getType()== 'F'){
                    Object o = lista_obj[i].get(nriga);

                    return ((Double) o).doubleValue();
                }

                else
                    return Double.MAX_VALUE;
            }
        }
        return Double.MAX_VALUE;
    }


    public boolean DBFWriteFile(String nomeFile)
    {
        try {
            dbf_w = new DBFWriter(nomeFile, this.jlist);
            for (int i = 0; i < this.nrecorddbf; i++)
            {
                Object[] o = new Object[this.ncol + 1];;
                for (int k = 0; k < this.ncol + 1; k++) {
                    //o[k] = jlist[k].format(this.lista_obj[k].get(i));
                    o[k] = jlist[k].parse(jlist[k].format(this.lista_obj[k].get(i)));
                }
                dbf_w.addRecord(o);

            }
            dbf_w.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
