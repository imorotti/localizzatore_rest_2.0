package com.siteco.classes;

/**
 *
 * <p>Classe che identifica un bounding box generico.</p>
 *
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company: Siteco Informatica s.r.l.</p>
 *
 * @author Fabio Adani, Ivan Morotti, Maurizio Musarella
 * @version 1.0
 */
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class GenEnvelope{
	private double minX;
	private double minY;
	private double maxX;
	private double maxY;

/**
	 * Restiruisce il valore minimo della X dell'envelop.
	 * @return double il valore minimo della X dell'envelop.
	 */
        @XmlElement(namespace="http://www.sitecoinf.it/values")
	public double getMinX () {
		return minX;
	}
        
	/**
	 * Setta il minimo valore della X dell'envelop.
	 * @param minX double.
	 */
	public void setMinX (double minXX) {
		this.minX = minXX;
	}
        
        /**
	 * Restiruisce il valore minimo della Y dell'envelop.
	 * @return double il valore minimo della Y dell'envelop.
	 */
        @XmlElement(namespace="http://www.sitecoinf.it/values")
	public double getMinY () {
		return minY;
	}
	/**
	 * Setta il minimo valore della Y dell'envelop.
	 * @param minY double.
	 */
	public void setMinY (double minYY) {
		this.minY = minYY;
	}
        
        /**
	 * Restiruisce il valore massimo della X dell'envelop.
	 * @return double il valore massimo della X dell'envelop.
	 */
        @XmlElement(namespace="http://www.sitecoinf.it/values")
	public double getMaxX () {
		return maxX;
	}
	/**
	 * Setta il massimo valore della X dell'envelop.
	 * @param maxX double.
	 */
	public void setMaxX (double maxXX) {
		this.maxX = maxXX;
	}
        
        /**
	 * Restiruisce il valore massimo della Y dell'envelop.
	 * @return double il valore massimo della Y dell'envelop.
	 */
        @XmlElement(namespace="http://www.sitecoinf.it/values")
	public double getMaxY () {
		return maxY;
	}
	/**
	 * Setta il massimo valore della Y dell'envelop.
	 * @param maxY double.
	 */
	public void setMaxY (double maxYY) {
		this.maxY = maxYY;
	}

	

	

	

	
}
