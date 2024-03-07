package com.siteco.classes;

/**
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

public class Coord{
        private double x;
        private double y;

        /**
         * Restiruisce il valore della X.
         * @return double il valore della X.
         */
        @XmlElement(namespace="http://www.sitecoinf.it/values")
        public double getX () {
                return x;
        }
        /**
         * Setta il valore della X.
         * @param x double.
         */
        public void setX (double xx) {
                this.x = xx;
        }
        
        /**
         * Restiruisce il valore della Y.
         * @return double il valore della Y.
         */
        @XmlElement(namespace="http://www.sitecoinf.it/values")
        public double getY () {
                return y;
        }
        /**
         * Setta il valore della Y.
         * @param y double.
         */
        public void setY (double yy) {
                this.y = yy;
        }




        

       
}
