package com.springmvc.demo;

public class AuthenticateServiceProxy implements com.springmvc.demo.AuthenticateService_PortType {
  private String _endpoint = null;
  private com.springmvc.demo.AuthenticateService_PortType authenticateService_PortType = null;
  
  public AuthenticateServiceProxy() {
    _initAuthenticateServiceProxy();
  }
  
  public AuthenticateServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initAuthenticateServiceProxy();
  }
  
  private void _initAuthenticateServiceProxy() {
    try {
      authenticateService_PortType = (new com.springmvc.demo.AuthenticateService_ServiceLocator()).getAuthenticateServicePort();
      if (authenticateService_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)authenticateService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)authenticateService_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (authenticateService_PortType != null)
      ((javax.xml.rpc.Stub)authenticateService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.springmvc.demo.AuthenticateService_PortType getAuthenticateService_PortType() {
    if (authenticateService_PortType == null)
      _initAuthenticateServiceProxy();
    return authenticateService_PortType;
  }
  
  public boolean validateUser(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (authenticateService_PortType == null)
      _initAuthenticateServiceProxy();
    return authenticateService_PortType.validateUser(arg0, arg1);
  }
  
  
}