package com.siteco.classes;

/**
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company: Siteco Informatica s.r.l.</p>
 *
 * @author Fabio Adani, Ivan Morotti, Maurizio Musarella
 * @version 1.0
 */
public class PtPrjM {
    public PtPrjM() {
    }
    public PtPrjM(double xx,double yy) {
        x = xx;
        y = yy;
    }
    private double x = 0;
    private double y = 0;
    private double xPro = 0;
    private double yPro = 0;
    private double offset = 0;
    private double m = 0;
    private long id = 0;
    public int srid = 0;
    public int dim = 0;

    /**
     * Setta la x proiettata sul grafo.
     * @param xPro double x proiettata sul grafo.
     */
    public void setXPro(double xPro) {
        this.xPro = xPro;
    }

    /**
     * Setta la y proiettata sul grafo.
     * @param yPro double y proiettata sul grafo.
     */
    public void setY(double yy) {
        this.y = yy;
    }
    /**
     * Setta la x proiettata sul grafo.
     * @param xPro double x proiettata sul grafo.
     */
    public void setX(double xx) {
        this.x = xx;
    }

    /**
     * Setta la y proiettata sul grafo.
     * @param yPro double y proiettata sul grafo.
     */
    public void setYPro(double yPro) {
        this.yPro = yPro;
    }

    /**
     * Setta l'offset.
     * @param offset double offset.
     */
    public void setOffset(double offset) {
        this.offset = offset;
    }

    /**
     * Setta la misura m.
     * @param m double misura m.
     */
    public void setM(double m) {
        this.m = m;
    }


    /**
      * Setta l'identificativo della strada.
      * @param road_id double road_id.
      */
     public void setId(long idd) {
         this.id = idd;
     }


    /**
     * Ritorna la x proiettata sul grafo.
     * @return double la x proiettata sul grafo.
     */
    public double getXPro() {
        return xPro;
    }

    /**
     * Ritorna la y proiettata sul grafo.
     * @return double la y proiettata sul grafo.
     */
    public double getY() {
        return y;
    }

    /**
     * Ritorna la x proiettata sul grafo.
     * @return double la x proiettata sul grafo.
     */
    public double getX() {
        return x;
    }

    /**
     * Ritorna la y proiettata sul grafo.
     * @return double la y proiettata sul grafo.
     */
    public double getYPro() {
        return yPro;
    }

    /**
     * Ritorna la misura m della proiezione di un punto sul grafo.
     * @return double la misura m della proiezione di un punto sul grafo.
     */
    public double getM() {
        return m;
    }

    /**
     * Ritorna l'id della strada.
     * @return double l'id della strada.
     */
    public long getId() {
        return this.id;
    }

    /**
     * Ritorna l'offset del punto proiettato.
     * @return double l'offset del punto proiettato.
     */
    public double getOffset() {
        return offset;
    }


}
