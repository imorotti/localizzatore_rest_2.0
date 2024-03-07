/**
 * NormalizzatoreLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class NormalizzatoreLocator extends org.apache.axis.client.Service implements e_SOAPDispenser.Normalizzatore.Normalizzatore {

    public NormalizzatoreLocator() {
    }


    public NormalizzatoreLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public NormalizzatoreLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for NormalizzatoreSoapPort
    private java.lang.String NormalizzatoreSoapPort_address = "http://localhost:8080/normalizzatore/eGeoCoding?serviceType=DBServices&serviceName=Normalizzatore";

    public java.lang.String getNormalizzatoreSoapPortAddress() {
        return NormalizzatoreSoapPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String NormalizzatoreSoapPortWSDDServiceName = "NormalizzatoreSoapPort";

    public java.lang.String getNormalizzatoreSoapPortWSDDServiceName() {
        return NormalizzatoreSoapPortWSDDServiceName;
    }

    public void setNormalizzatoreSoapPortWSDDServiceName(java.lang.String name) {
        NormalizzatoreSoapPortWSDDServiceName = name;
    }

    public e_SOAPDispenser.Normalizzatore.NormalizzatoreSoapPort getNormalizzatoreSoapPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(NormalizzatoreSoapPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getNormalizzatoreSoapPort(endpoint);
    }

    public e_SOAPDispenser.Normalizzatore.NormalizzatoreSoapPort getNormalizzatoreSoapPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            e_SOAPDispenser.Normalizzatore.NormalizzatoreBindingStub _stub = new e_SOAPDispenser.Normalizzatore.NormalizzatoreBindingStub(portAddress, this);
            _stub.setPortName(getNormalizzatoreSoapPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setNormalizzatoreSoapPortEndpointAddress(java.lang.String address) {
        NormalizzatoreSoapPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (e_SOAPDispenser.Normalizzatore.NormalizzatoreSoapPort.class.isAssignableFrom(serviceEndpointInterface)) {
                e_SOAPDispenser.Normalizzatore.NormalizzatoreBindingStub _stub = new e_SOAPDispenser.Normalizzatore.NormalizzatoreBindingStub(new java.net.URL(NormalizzatoreSoapPort_address), this);
                _stub.setPortName(getNormalizzatoreSoapPortWSDDServiceName());
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
        if ("NormalizzatoreSoapPort".equals(inputPortName)) {
            return getNormalizzatoreSoapPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Normalizzatore");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "NormalizzatoreSoapPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("NormalizzatoreSoapPort".equals(portName)) {
            setNormalizzatoreSoapPortEndpointAddress(address);
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
