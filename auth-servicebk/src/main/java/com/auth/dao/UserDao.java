/**
 * 
 */
package com.auth.dao;

import java.util.List;

import com.auth.model.User;

/**
 * @author basil.omasete
 *
 */
public interface UserDao {

	int saveUser(User user);

	List<User> getAllUser();
	
	public User findUserByEmail(String username);

	public User findUserByMobilenumber(String mobilenumber);
}
