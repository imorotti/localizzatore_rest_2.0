package com.siteco.JRs40DynSeg;
/*
 * Box.java
 *
 * Created on 8 febbraio 2006, 0.00
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

import java.util.*;
import java.lang.*;
import java.math.*;

/**
 *
 * @author vanna
 */
public class Box {

    /** Creates a new instance of Box */
    public Box() {
        xmin = Double.MAX_VALUE;
        ymin = Double.MAX_VALUE;
        zmin = Double.MAX_VALUE;
        mmin = Double.MAX_VALUE;
        xmax = Double.MIN_VALUE;
        ymax = Double.MIN_VALUE;
        mmax = Double.MIN_VALUE;
        zmax = Double.MIN_VALUE;

    }

    public Box(Box Src)
    {
//
// TODO: Add constructor logic here
//
        xmin = Src.xmin;
        ymin = Src.ymin;
        zmin = Src.zmin;
        mmin = Src.mmin;
        xmax = Src.xmax;
        ymax = Src.ymax;
        zmax = Src.zmax;
        mmax = Src.mmax;
    }

    public Box(double bmin, double bmax)
    {
	//
	// TODO: Add constructor logic here
	//
	xmin = bmin;
	ymin = bmin;
	zmin = bmin;
	mmin = bmin;
	xmax = bmax;
	ymax = bmax;
	zmax = bmax;
	mmax = bmax;
    }


    public double xmin;
    public double ymin;
    public double zmin;
    public double mmin;
    public double xmax;
    public double ymax;
    public double zmax;
    public double mmax;



    public void Box(double bmin, double bmax) {
//
// TODO: Add constructor logic here
//
	xmin = bmin;
	ymin = bmin;
	zmin = bmin;
	mmin = bmin;
	xmax = bmax;
	ymax = bmax;
	zmax = bmax;
	mmax = bmax;
    }

/// <summary>
/// Unisce il box corrente con il box b e restituisce il risultato
/// </summary>
    public void SHPAggBox(Box b)
    {

	this.xmin = java.lang.Math.min(b.xmin, this.xmin);
	this.ymin = java.lang.Math.min(b.ymin, this.ymin);
	this.zmin = java.lang.Math.min(b.zmin, this.zmin);
	this.mmin = java.lang.Math.min(b.mmin, this.mmin);
	this.xmax = java.lang.Math.max(b.xmax, this.xmax);
	this.ymax = java.lang.Math.max(b.ymax, this.ymax);
	this.zmax = java.lang.Math.max(b.zmax, this.zmax);
	this.mmax = java.lang.Math.max(b.mmax, this.mmax);
    }


}
