package com.springmvc.demo;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;


@Component("AuthenticateServiceImpl")
@WebService(endpointInterface="com.springmvc.demo.AuthenticateService" ,portName="AuthenticateServicePort"
,serviceName="AuthenticateService")
public class AuthenticateServiceImpl extends SpringBeanAutowiringSupport implements AuthenticateService  {

	@Autowired
	private  LoginFormFacade loginFormFacade;
	
	

	@Override
	public boolean validateUser(String userName, String passowrd) {
		System.out.println("validateUser start");
		if(loginFormFacade.validateUser(userName, passowrd))
			return true;
		else
			return false;
		
	}

}
