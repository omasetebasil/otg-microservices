/**
 * 
 */
package com.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth.dao.UserDao;
import com.auth.model.User;

/**
 * @author basil.omasete
 *
 */
@Service
public class CustomUserDeatails implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        org.springframework.security.core.userdetails.User user =null;
                User findUserByEmail = userDao.findUserByEmail(username);
		if (findUserByEmail == null) {
            User findUserByMobilenumber = userDao.findUserByMobilenumber(username);
            if (findUserByMobilenumber == null) {
                throw new RuntimeException("User not found..!!!");
            }
            if(findUserByMobilenumber!=null) {
                user = new org.springframework.security.core.userdetails.User(findUserByMobilenumber.getMobilenumber(), findUserByMobilenumber.getPassword(), true, true, true, true, findUserByMobilenumber.getRoleses());
            }
		}
		if(findUserByEmail!=null) {
            user = new org.springframework.security.core.userdetails.User(findUserByEmail.getEmail(), findUserByEmail.getPassword(), true, true, true, true, findUserByEmail.getRoleses());
        }
		return user;
	}

}
