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
@Table(name = "rider")
public class Rider implements Serializable {

	@Id
	@Column(name = "rid_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "rid_name", nullable = false)
	private String riderName;

	@Column(name = "rid_join_date", nullable = true)
	private Date joinedDate;

	@Column(name = "rid_idnumber", nullable = true)
	private String idNumber;

	@Column(name = "rid_dob", nullable = true)
	private Date dob;

	@Column(name = "rid_rating")
	private long rating;

	@Column(name = "rid_gender")
	private String gender;

	@Column(name = "rid_mobile_no")
	private String mobileNo;

	@Column(name = "rid_physical_address")
	private String physicalAddress;

	@Column(name = "rid_email_address")
	private String emailAddress;

	@Column(name = "rid_cou_id")
	private long couId;

	@Column(name = "rid_cpymt_id")
	private long cpymtId;

	@Column(name = "rid_user_id")
	private long userId;

	private String cessionActive;
	private String couName;
}
