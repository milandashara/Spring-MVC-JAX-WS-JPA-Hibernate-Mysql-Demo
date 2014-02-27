/**
 * AuthenticateService_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.springmvc.demo;

public class AuthenticateService_ServiceLocator extends org.apache.axis.client.Service implements com.springmvc.demo.AuthenticateService_Service {

    public AuthenticateService_ServiceLocator() {
    }


    public AuthenticateService_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AuthenticateService_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AuthenticateServicePort
    private java.lang.String AuthenticateServicePort_address = "http://localhost:8080/demo/authenticateWebservice";

    public java.lang.String getAuthenticateServicePortAddress() {
        return AuthenticateServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AuthenticateServicePortWSDDServiceName = "AuthenticateServicePort";

    public java.lang.String getAuthenticateServicePortWSDDServiceName() {
        return AuthenticateServicePortWSDDServiceName;
    }

    public void setAuthenticateServicePortWSDDServiceName(java.lang.String name) {
        AuthenticateServicePortWSDDServiceName = name;
    }

    public com.springmvc.demo.AuthenticateService_PortType getAuthenticateServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AuthenticateServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAuthenticateServicePort(endpoint);
    }

    public com.springmvc.demo.AuthenticateService_PortType getAuthenticateServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.springmvc.demo.AuthenticateServicePortBindingStub _stub = new com.springmvc.demo.AuthenticateServicePortBindingStub(portAddress, this);
            _stub.setPortName(getAuthenticateServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAuthenticateServicePortEndpointAddress(java.lang.String address) {
        AuthenticateServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.springmvc.demo.AuthenticateService_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.springmvc.demo.AuthenticateServicePortBindingStub _stub = new com.springmvc.demo.AuthenticateServicePortBindingStub(new java.net.URL(AuthenticateServicePort_address), this);
                _stub.setPortName(getAuthenticateServicePortWSDDServiceName());
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
        if ("AuthenticateServicePort".equals(inputPortName)) {
            return getAuthenticateServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://demo.springmvc.com/", "AuthenticateService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://demo.springmvc.com/", "AuthenticateServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AuthenticateServicePort".equals(portName)) {
            setAuthenticateServicePortEndpointAddress(address);
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
