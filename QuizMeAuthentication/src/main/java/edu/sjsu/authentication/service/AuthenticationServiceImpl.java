/**
 * 
 */
package edu.sjsu.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.sjsu.authentication.UserModel;
import edu.sjsu.authentication.dao.IAuthenticationDao;
import edu.sjsu.authentication.model.LoginModel;

/**
 * @author Varun
 *
 */
@Component
public class AuthenticationServiceImpl implements IAuthenticationService {
	
	/**
	 * authenticationDao instance
	 */
	@Autowired
	private IAuthenticationDao authenticationDao;

	/**
	 * Method to get user details
	 */
	@Override
	public UserModel getUserDetails(LoginModel login) throws Exception {
		return authenticationDao.getUserDetails(login);
	}

}
