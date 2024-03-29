/**
 * SitecoWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package com.siteco.generated;

public class SitecoWSServiceLocator extends org.apache.axis.client.Service implements com.siteco.generated.SitecoWSService {

    public SitecoWSServiceLocator() {
    }


    public SitecoWSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SitecoWSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SitecoWS
    private java.lang.String SitecoWS_address = "http://213.209.218.211.8080/SitecoWS/services/SitecoWS";

    public java.lang.String getSitecoWSAddress() {
        return SitecoWS_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SitecoWSWSDDServiceName = "SitecoWS";

    public java.lang.String getSitecoWSWSDDServiceName() {
        return SitecoWSWSDDServiceName;
    }

    public void setSitecoWSWSDDServiceName(java.lang.String name) {
        SitecoWSWSDDServiceName = name;
    }

    public com.siteco.generated.SitecoWS getSitecoWS() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SitecoWS_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSitecoWS(endpoint);
    }

    public com.siteco.generated.SitecoWS getSitecoWS(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.siteco.generated.SitecoWSSoapBindingStub _stub = new com.siteco.generated.SitecoWSSoapBindingStub(portAddress, this);
            _stub.setPortName(getSitecoWSWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSitecoWSEndpointAddress(java.lang.String address) {
        SitecoWS_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.siteco.generated.SitecoWS.class.isAssignableFrom(serviceEndpointInterface)) {
                com.siteco.generated.SitecoWSSoapBindingStub _stub = new com.siteco.generated.SitecoWSSoapBindingStub(new java.net.URL(SitecoWS_address), this);
                _stub.setPortName(getSitecoWSWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SitecoWS".equals(inputPortName)) {
            return getSitecoWS();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://siteco.com", "SitecoWSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://siteco.com", "SitecoWS"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SitecoWS".equals(portName)) {
            setSitecoWSEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
