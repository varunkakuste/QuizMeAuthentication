/**
 * 
 */
package edu.sjsu.authentication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.stereotype.Component;

import edu.sjsu.authentication.UserModel;
import edu.sjsu.authentication.model.LoginModel;

/**
 * @author Varun
 *
 */
@Component
public class AuthenticationDaoImpl implements IAuthenticationDao {
	
	public static final String GET_USER_DETAILS = "SELECT USER_ID, USERNAME, EMAIL, PASSWORD, LASTNAME, FIRSTNAME FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";
	
	/**
	 * dataSource
	 */
	private DataSource dataSource;
	
	/**
	 * Default Constructor
	 */
	public AuthenticationDaoImpl() {}

	/**
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	/**
	 * Method to get user details
	 */
	@Override
	public UserModel getUserDetails(LoginModel login) throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		UserModel user = null;		
		try {
			connection = (Connection) dataSource.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(GET_USER_DETAILS);
			preparedStatement.setString(1, login.getUserName());
			preparedStatement.setString(2, login.getPassword());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				user = new UserModel();
				user.setUserId(resultSet.getInt("USER_ID"));
				user.setUserName(resultSet.getString("USERNAME"));
				user.setEmail(resultSet.getString("EMAIL"));
				user.setPassword(resultSet.getString("PASSWORD"));
				user.setLastName(resultSet.getString("LASTNAME"));
				user.setFirstName(resultSet.getString("FIRSTNAME"));
			}
		} catch (SQLException sql) {
			throw new Exception(sql);
		} catch (Exception exp){
			throw new Exception(exp);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException sql) {
					throw new Exception(sql);
				}
			}
		}
		return user;
	}
	
}
