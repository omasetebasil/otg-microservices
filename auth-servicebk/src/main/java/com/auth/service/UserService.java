/**
 * 
 */
package com.auth.service;

import java.util.List;

import com.auth.entities.UserInfo;
import com.auth.model.User;
import com.auth.model.UserRequest;

/**
 * @author basil.omasete
 *
 */
public interface UserService {

	int save(User user);
	
	List<User> list();

	List<User> getRoleUserDtls(UserRequest userRequest);

	UserInfo createUser(User userDTO);

}
