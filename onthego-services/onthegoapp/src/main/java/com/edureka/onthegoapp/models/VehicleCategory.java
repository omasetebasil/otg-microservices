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
@Table(name = "vehicle_category")
public class VehicleCategory {

	private long id;

	@NotNull
	@Size(min = 2, message = "Vehicle Category should have atleast 2 characters")
	private String vCategoryDesc; 

	public VehicleCategory() {

	}

	public VehicleCategory(String vCategoryDesc) {
		this.vCategoryDesc = vCategoryDesc;
	}

	@Id
	@Column(name = "vcategory_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "vcategory_desc", nullable = false)
	public String getVCategoryDesc() {
		return vCategoryDesc;
	}

	public void setVCategoryDesc(String vCategoryDesc) {
		this.vCategoryDesc = vCategoryDesc;
	}
}

