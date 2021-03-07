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
@Table(name = "vehicle")
public class Vehicle {

	private long id;

	@NotNull
	@Size(min = 2, message = "Country should have atleast 2 characters")
	private String regNo;
	private String make;
	private String model;
	private String tonnage;
	private String type;
    private long yom;
	private long baseRate;
	private Long vcategoryId;
	private byte[] image;
	
	public Vehicle() {

	}

	public Vehicle(String regNo,String make,String model,String tonnage,
	String type,Long yom,Long baseRate,Long vcategoryId,byte[] image) {
		this.regNo = regNo;
		this.make = make;
		this.model = model;
		this.tonnage = tonnage;
		this.type = type;
		this.yom = yom;
		this.baseRate = baseRate;
		this.vcategoryId = vcategoryId;
		this.image = image;
	}

	@Id
	@Column(name = "veh_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "veh_reg_no", nullable = false)
	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	@Column(name = "veh_make", nullable = false)
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}
	@Column(name = "veh_model", nullable = false)
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	@Column(name = "veh_tonnage", nullable = false)
	public String getTonnage() {
		return tonnage;
	}

	public void setTonnage(String tonnage) {
		this.tonnage = tonnage;
	}	
	@Column(name = "veh_type", nullable = false)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}	
	@Column(name = "veh_yom")
	public long getYom() {
		return yom;
	}

	public void setYom(long yom) {
		this.yom = yom;
	}
	@Column(name = "veh_base_rate")
	public long getBaseRate() {
		return baseRate;
	}

	public void setBaseRate(long baseRate) {
		this.baseRate = baseRate;
	}
	@Column(name = "veh_vcategory_id")
	public long getVcategoryId() {
		return vcategoryId;
	}

	public void setVcategoryId(long vcategoryId) {
		this.vcategoryId = vcategoryId;
	}
	@Column(name = "veh_image")
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
}