package edu.sjsu.authentication;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.sjsu.authentication.model.LoginModel;
import edu.sjsu.authentication.service.IAuthenticationService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private IAuthenticationService authenticationService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/loginAuthentication", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody UserModel loginAuthentication(@RequestParam HashMap<String, String> loginDetailsMap) {
		UserModel user = null;
		try {
			LoginModel login = new LoginModel();
			login.setUserName(loginDetailsMap.get("userName"));
			login.setPassword(loginDetailsMap.get("password"));
			authenticationService.getUserDetails(login);
		} catch (Exception exception) {
			user = null;
		}
		return user;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public @ResponseBody boolean signUp(@RequestBody UserModel userModel) { 
		boolean isSignedUp = false;
		try {
			isSignedUp = authenticationService.signUp(userModel);
		} catch (Exception exception) {
			isSignedUp = false;
		}
		return isSignedUp;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/savechanges", method = RequestMethod.PUT)
	public @ResponseBody boolean saveChanges(@RequestBody UserModel userModel) { 
		boolean isSignedUp = false;
		try {
			isSignedUp = authenticationService.updateUserDetails(userModel);
		} catch (Exception exception) {
			isSignedUp = false;
		}
		return isSignedUp;
	}
}