package com.edureka.onthegoapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(name = "location")
public class Location { 

	private long id;
	private long gridId;

	@NotNull
	@Size(min = 2, message = "land mark should have atleast 2 characters")
	private String landmarkName;
	private String zipCode;

	public Location() {

	}

	public Location(String landmarkName,String zipCode,Long gridId) {
		this.landmarkName = landmarkName;
		this.zipCode = zipCode;
		this.gridId = gridId;
	}

	@Id
	@Column(name = "loc_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "loc_landmark_name", nullable = false)
	public String getLandmarkName() {
		return landmarkName;
	}

	public void setLandmarkName(String landmarkName) {
		this.landmarkName = landmarkName;
	}
	@Column(name = "loc_zip_code", nullable = false)
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@Column(name = "loc_grid_id", nullable = false)
	public long getGridId() {
		return gridId;
	}

	public void setGridId(long gridId) {
		this.gridId = gridId;
	}
}
