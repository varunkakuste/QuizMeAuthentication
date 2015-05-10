/**
 * 
 */
package edu.sjsu.authentication.dao;

import edu.sjsu.authentication.UserModel;
import edu.sjsu.authentication.model.LoginModel;

/**
 * @author Varun
 *
 */
public interface IAuthenticationDao {
	public UserModel getUserDetails(LoginModel login) throws Exception;
	public boolean signUp(UserModel user) throws Exception;
	public boolean updateUserDetails(UserModel user) throws Exception;
}
