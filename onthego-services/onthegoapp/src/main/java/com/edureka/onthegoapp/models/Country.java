package com.edureka.onthegoapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "countries")
public class Country {

	private long id;

	@NotNull
	@Size(min = 2, message = "Country should have atleast 2 characters")
	private String couName;
	
	/*@Email
	@NotBlank
	private String emailId;*/

	public Country() {

	}

	public Country(String couName) {
		this.couName = couName;
	}

	@Id
	@Column(name = "cou_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "cou_name", nullable = false)
	public String getCouName() {
		return couName;
	}

	public void setCouName(String couName) {
		this.couName = couName;
	}
}
