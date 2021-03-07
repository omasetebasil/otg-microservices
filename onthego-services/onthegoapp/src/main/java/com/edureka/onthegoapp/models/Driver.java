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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDrivName() {
		return drivName;
	}

	public void setDrivName(String drivName) {
		this.drivName = drivName;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getCessionActive() {
		return cessionActive;
	}

	public void setCessionActive(String cessionActive) {
		this.cessionActive = cessionActive;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public long getRating() {
		return rating;
	}

	public void setRating(long rating) {
		this.rating = rating;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPhysicalAddress() {
		return physicalAddress;
	}

	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public long getCouId() {
		return couId;
	}

	public void setCouId(long couId) {
		this.couId = couId;
	}

	public long getCpymtId() {
		return cpymtId;
	}

	public void setCpymtId(long cpymtId) {
		this.cpymtId = cpymtId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getCouName() {
		return couName;
	}

	public void setCouName(String couName) {
		this.couName = couName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

