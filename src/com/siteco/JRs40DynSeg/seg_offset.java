/*
 * seg_offset.java
 *
 * Created on 10 marzo 2006, 16.18
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.siteco.JRs40DynSeg;

/**
 *
 * @author vanna
 */
public class seg_offset {
    
    /** Creates a new instance of seg_offset */
    // segmento di offset
    public seg_offset()
    {
	seg = new SHPSegm();
	p1 = new SHPPoint();
	p2 = new SHPPoint();
    }
// public signed char verso;
	public boolean		canc;
	public SHPSegm		seg;
	public SHPPoint		p1;
	public SHPPoint		p2;
}
