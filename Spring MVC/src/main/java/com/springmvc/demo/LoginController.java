package com.springmvc.demo;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.xml.rpc.ServiceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);

	//@Autowired
	//private LoginServiceClient loginServiceClient;

	@Autowired
	private LoginFormFacade loginFormFacade;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(@ModelAttribute("loginForm") LoginForm loginForm,
			Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "login";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String authenticateUser(
			@Valid @ModelAttribute("loginForm") LoginForm loginForm,
			BindingResult result, Map model,HttpServletRequest request) throws RemoteException, ServiceException {
		String userName = "UserName";
		String password = "password";
		if (result.hasErrors()) {
			return "login";
		}
		loginForm = (LoginForm) model.get("loginForm");
		
		//call soap webservice
		boolean isValid= new AuthenticateService_ServiceLocator().getAuthenticateServicePort().validateUser(loginForm.getUserName(), loginForm.getPassword());
		
		/*
		 * if (!loginForm.getUserName().equals(userName) ||
		 * !loginForm.getPassword().equals(password)) { return "login"; }
		 */
		// model.put("userName", loginServiceClient.getValue(userName,
		// password));

		//boolean isValid = loginFormFacade.validateUser(loginForm.getUserName(),
		//		loginForm.getPassword());
		
		/*loginServiceClient.getValue(loginForm.getUserName(),
				loginForm.getPassword());*/
		if (!isValid)
			return "login";
		else {
			Date date = new Date();
			DateFormat dateFormat = DateFormat.getDateTimeInstance(
					DateFormat.LONG, DateFormat.LONG, Locale.US);

			String formattedDate = dateFormat.format(date);

			model.put("serverTime", formattedDate);
			request.getSession(true).setAttribute("userName", loginForm.getUserName());
			return "home";
		}
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(@Valid @ModelAttribute("loginForm") LoginForm loginForm,BindingResult result,HttpServletRequest request,Map model) {
		
		request.getSession(true).setAttribute("userName", null);
		return "login";
 
	}
}
