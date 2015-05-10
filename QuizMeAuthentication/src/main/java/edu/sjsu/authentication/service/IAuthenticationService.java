/**
 * 
 */
package edu.sjsu.authentication.service;

import edu.sjsu.authentication.UserModel;
import edu.sjsu.authentication.model.LoginModel;

/**
 * @author Varun
 *
 */
public interface IAuthenticationService {
	public UserModel getUserDetails(LoginModel login) throws Exception;
	public boolean signUp(UserModel user) throws Exception;
	public boolean updateUserDetails(UserModel user) throws Exception;
}
