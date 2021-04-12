/**
 * 
 */
package com.auth.service;

import java.util.*;

import com.auth.entities.UserInfo;
import com.auth.model.UserRequest;
import com.auth.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.auth.dao.RoleDao;
import com.auth.dao.UserDao;
import com.auth.model.Roles;
import com.auth.model.User;

/**
 * @author basil.omasete
 *
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
	@Autowired
	JdbcTemplate jdbcTemplate;
	private static final String  email = "email";
	private static final String  mobilenumber = "mobilenumber";
	@Autowired
	UserDao userDao;

	@Autowired
	RoleDao roleDao;

	private final UserRepository userRepository;

	@Override
	public int save(User user) {
		 int saveUser = userDao.saveUser(user);
		 Set<Roles> roleses = user.getRoleses();
		 for (Roles roles : roleses) {
			 roleDao.saveRole(roles, user);
		}
		 return saveUser;
		 
	}

	@Override
	public List<User> list() {
		return userDao.getAllUser();
	}
	@Override
	public List<User> getRoleUserDtls(UserRequest userRequest) {
		String USER_SQL_QUERY = "select email,mobilenumber from user,roles where roles.userid=user.userid and name=:role and  ((mobilenumber=:mobileno) or (email=:emailaddress))";
		USER_SQL_QUERY =
				USER_SQL_QUERY.replaceAll(":role", userRequest.getRole() != null ? "'" + userRequest.getRole() +
						"'" : "null");
		USER_SQL_QUERY =
				USER_SQL_QUERY.replaceAll(":mobileno", userRequest.getMobileno() != null ? "'" + userRequest.getMobileno() +
						"'" : "null");
		USER_SQL_QUERY =
				USER_SQL_QUERY.replaceAll(":emailaddress", userRequest.getEmailaddress() != null ? "'" + userRequest.getEmailaddress() +
						"'" : "null");
		Collection<Map<String, Object>> rows = jdbcTemplate.queryForList(USER_SQL_QUERY);
		List<User> usersList = new ArrayList<>();
		rows.stream().map((row) -> {
			User user = new User();
			user.setEmail((String) row.get(email));
			user.setMobilenumber((String) row.get(mobilenumber));
			return user;
		}).forEach((ss) -> {
			usersList.add(ss);
		});
		return usersList;

	}
	@Override
	public UserInfo createUser(User userDTO) {
		java.sql.Date sd = null;
		UserInfo user=null;
		System.out.println(userDTO.getEmail()+"=="+userDTO.getMobilenumber());
		if(userDTO!=null) {
			System.out.println(userRepository.findUserByEmailAndMobilenumber(userDTO.getEmail(),userDTO.getMobilenumber()));
			user = userRepository.findUserByEmailAndMobilenumber(userDTO.getEmail(),userDTO.getMobilenumber());
			if (user==null) {
				user = new UserInfo();
			}
		}else{
		}
		if(userDTO !=null) {
			user.setUserid(userDTO.getUserid());
			user.setDob(new java.sql.Date((userDTO.getDob()).getTime()));
			user.setEmail(userDTO.getEmail());
			user.setFirstname(userDTO.getFirstname());
			//user.setGender(userDTO.getGender());
			user.setLastname(userDTO.getLastname());
			user.setMobilenumber(userDTO.getMobilenumber());
			user.setPassword(userDTO.getPassword());
			userRepository.save(user);
		}
		return user;

	}
}
