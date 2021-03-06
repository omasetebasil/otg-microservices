/**
 * 
 */
package com.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author basil.omasete
 *
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId("restservice");
	}

//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		//http.requestMatchers().antMatchers("/user").and().authorizeRequests().antMatchers("/user").access("#oauth2.hasScope('read')");
//		//http.csrf().disable().authorizeRequests().antMatchers("/save","/get").permitAll().and().authorizeRequests().antMatchers("/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER");
//		http.csrf().disable().authorizeRequests().anyRequest().authenticated();
//	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().anyRequest().permitAll();
		//http.csrf().disable().authorizeRequests().anyRequest().authenticated();
		//http.anonymous().disable().csrf().disable().authorizeRequests().anyRequest().authenticated();
	}
	
}
