package com.springmvc.demo;

import javax.jws.WebService;

@WebService
public interface AuthenticateService {

	public boolean validateUser(String userName,String passowrd);
}
