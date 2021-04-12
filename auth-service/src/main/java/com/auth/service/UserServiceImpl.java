/**
 * 
 */
package com.auth.service;

import java.text.SimpleDateFormat;
import java.util.*;

import com.auth.entities.UserInfo;
import com.auth.model.RoleInfo;
import com.auth.model.UserRequest;
import com.auth.repositories.RoleRepository;
import com.auth.repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
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

	@Autowired
	PasswordEncoder passwordEncoder;

	private final UserRepository userRepository;

	private final RoleRepository roleRepository;

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
	public User createUser(User userDTO) {
		Integer userId=null;
		ObjectMapper mapper = new ObjectMapper();
		String jsonSchedule =null;
		java.sql.Date sd = null;
		User user=null;
		RoleInfo roles=null;
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		//SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		java.util.Date utilDob = null;
		java.sql.Date sqlDob = null;
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String strDate = null;
		//System.out.println(userDTO.getEmail()+"=="+userDTO.getMobilenumber());
		if(userDTO!=null) {
			System.out.println(userRepository.findUserByEmailAndMobilenumber(userDTO.getEmail(),userDTO.getMobilenumber()));
			user = userRepository.findUserByEmailAndMobilenumber(userDTO.getEmail(),userDTO.getMobilenumber());
			if (user==null) {
				user = new User();
			}
		}else{
		}
		if(userDTO !=null) {
			try{
				jsonSchedule =  mapper.writeValueAsString(user) ;
				System.out.println("users1=="+jsonSchedule);
			} catch (Exception e) {
				System.out.println("Error Exctracting policy info");
			}
			user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
			//user.setUserid(userDTO.getUserid());
			user.setDob(userDTO.getDob());
			user.setEmail(userDTO.getEmail());
			user.setFirstname(userDTO.getFirstname());
			user.setGender(userDTO.getGender());
			user.setLastname(userDTO.getLastname());
			user.setMobilenumber(userDTO.getMobilenumber());
			//user.setPassword(userDTO.getPassword());
			userRepository.save(user);
			userId = userRepository.findUserIdByEmailAndMobilenumber(userDTO.getEmail(),userDTO.getMobilenumber());
			if (userDTO.getRoleses()!=null) {
				for (Roles role : userDTO.getRoleses()) {
				roles = roleRepository.findUserByUserAndName(user.getUserid(),role.getName());
				if (roles==null) {
					roles = new RoleInfo();
				}
					//roles.setUser(user);
				    roles.setName(role.getName());
					roles.setUserid(userId);
					try{
						jsonSchedule =  mapper.writeValueAsString(roles) ;
						System.out.println("roles2=="+jsonSchedule);
					} catch (Exception e) {
						System.out.println("Error Exctracting policy info");
					}
					roleRepository.save(roles);
				}
			}
		}
		return user;

	}
}
