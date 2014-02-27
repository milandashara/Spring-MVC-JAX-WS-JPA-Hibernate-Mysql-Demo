package com.springmvc.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object arg2) throws Exception {

		System.out.println("request.getRequestURI() :" +request.getRequestURI() + " userName" +request.getSession(true).getAttribute("userName"));
		if (request.getSession(true).getAttribute("userName") == null
				&& !(request.getRequestURI().equals("/demo/login") || request
						.getRequestURI().equals("/demo/authenticateWebservice"))) {
			response.sendRedirect("login");
			
			return false;
		} else if (request.getSession(true).getAttribute("userName") !=null && request.getRequestURI().equals("/demo/login")) {
			//request.getRequestDispatcher("/demo").forward(request, response);
			response.sendRedirect("/demo");
			return true;
		} else
			return true;

	}
}
