package com.siteco.classes;

/**
 * <p>Classe che identifica un insieme di oggetti di un {@link GenLayer}
 * memorizzati in un {@link ArrayOfInt}. Il layer � caratterrizzato dal nome e/o
 * dal tag.</p>
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

public class ObjsInLayer3 {
    private String mtag = null;
    private String name = null;
    private ArrayOfString fields;
    private ArrayOfArrayOfString values;

    public ObjsInLayer3() {
    }
    
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public String getMtag() {
        return mtag;
    }

    public void setMtag (String mtag) {
        this.mtag = mtag;
    }
    
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public String getName() {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }
    
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public ArrayOfString getFields() {
        return fields;
    }

    public void setFields (ArrayOfString fields) {
        this.fields = fields;
    }
    
    @XmlElement(namespace="http://www.sitecoinf.it/values")
    public ArrayOfArrayOfString getValues() {
        return values;
    }

    public void setValues (ArrayOfArrayOfString values) {
        this.values = values;
    }
}
