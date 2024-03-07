@XmlSchema(
    elementFormDefault=XmlNsForm.QUALIFIED,
    xmlns={
        @XmlNs(prefix="", namespaceURI="http://www.sitecoinf.it/package"),
        @XmlNs(prefix="ns1", namespaceURI="http://www.sitecoinf.it/records"),
        @XmlNs(prefix="ns2", namespaceURI="http://www.sitecoinf.it/values")
    }
)

package com.siteco.classes;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema; 