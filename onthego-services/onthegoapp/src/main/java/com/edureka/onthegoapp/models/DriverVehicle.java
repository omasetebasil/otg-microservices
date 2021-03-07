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
@Table(name = "driver_vehicle")
public class DriverVehicle {

	private long id;
	private long drivId;

	@NotNull
	@Size(min = 1, message = "Preffered? should have atleast 1 characters") 
	private long vehId;
	@NotNull
	@Size(min = 2, message = "Account number should have atleast 2 characters")
	private String drivehActive;
	
	/*@Email
	@NotBlank
	private String emailId;*/

	public DriverVehicle() {

	}
	public DriverVehicle(Long drivId,String drivehActive,Long vehId) {
		this.drivId = drivId;
		this.drivehActive = drivehActive;
		this.vehId = vehId;
	}

	@Id
	@Column(name = "driveh_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "driveh_veh_id")
	public long getVehId() {
		return vehId;
	}

	public void setVehId(long vehId) {
		this.vehId = vehId;
	}

	@Column(name = "driveh_driv_id", nullable = false)  
	public Long getDrivId() {
		return drivId;
	}
	@Column(name = "driveh_active", nullable = false)  
	public String getDrivehActive() {
		return drivehActive;
	}

	public void setDrivId(Long drivId) {
		this.drivId = drivId;
	}
	
		public void setDrivehActive(String drivehActive) {
		this.drivehActive = drivehActive;
	}
}
