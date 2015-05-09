/**
 * 
 */
package edu.sjsu.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.sjsu.authentication.dao.IAuthenticationDao;

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

}
