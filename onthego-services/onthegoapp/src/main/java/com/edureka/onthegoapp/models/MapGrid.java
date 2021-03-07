package com.edureka.onthegoapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "map_grid")
public class MapGrid {

	private long id;
	private double latitude;
	private double longitude;
	

	public MapGrid() {

	}

	public MapGrid(double latitude,double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	@Id
	@Column(name = "grid_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "grid_latitude", nullable = false)
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	@Column(name = "grid_longitude", nullable = false)
	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
}
