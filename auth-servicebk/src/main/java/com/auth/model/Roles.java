package com.auth.model;
// Generated Feb 15, 2019 7:06:32 PM by Hibernate Tools 5.1.10.Final

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Roles generated by hbm2java
 */
@JsonIgnoreProperties(value = { "user" })
@Entity
@Table(name = "roles", catalog = "users")
public class Roles implements java.io.Serializable,GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 153138604903709925L;
	private Integer roleid;
	private User user;
	private String name;

	public Roles() {
	}

	public Roles(User user, String name) {
		this.user = user;
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "roleid", unique = true, nullable = false)
	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	@Transient
	public String getAuthority() {
		return this.name;
	}

}