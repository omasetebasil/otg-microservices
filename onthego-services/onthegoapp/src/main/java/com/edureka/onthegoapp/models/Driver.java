package com.edureka.onthegoapp.models;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

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

@Data
@Entity
@Table(name = "driver")
public class Driver implements Serializable {
	@Id
	@Column(name = "driv_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "driv_name", nullable = false)
	private String drivName;

	@Column(name = "driv_joined_date", nullable = true)
	private Date joinedDate;

	@Column(name = "driv_licence_no", nullable = true)
	private String licenceNo;

	@Column(name = "driv_idnumber", nullable = false)
	private String idNumber;

	@Column(name = "driv_cession_active", nullable = true)
	private String cessionActive;

	@Column(name = "driv_dob", nullable = false)
	private Date dob;

	@Column(name = "driv_rating")
	private long rating;

	@Column(name = "driv_gender")
	private String gender;

	@Column(name = "driv_mobile_no")
	private String mobileNo;

	@Column(name = "driv_physical_address")
	private String physicalAddress;

	@Column(name = "driv_email_address")
	private String emailAddress;

	@Column(name = "driv_cou_id")
	private long couId;

	@Column(name = "driv_cpymt_id")
	private long cpymtId;

	@Column(name = "driv_user_id")
	private long userId;

	private String couName;
	private String password;
}

