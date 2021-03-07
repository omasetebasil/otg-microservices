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
@Table(name = "payment_modes")
public class PaymentMode {

	private long id;

	@NotNull
	@Size(min = 2, message = "PaymentMode should have atleast 2 characters")
	private String pymtServiceProv;
	@NotNull
	@Size(min = 2, message = "PaymentMode should have atleast 2 characters")
	private String pymtName;
	
	/*@Email
	@NotBlank
	private String emailId;*/

	public PaymentMode() {

	}

	public PaymentMode(String pymtServiceProv,String pymtName) {
		this.pymtServiceProv = pymtServiceProv;
		this.pymtName = pymtName;
	}

	@Id
	@Column(name = "pymt_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "pymt_service_prov", nullable = false)  
	public String getPymtServiceProv() {
		return pymtServiceProv;
	}
	@Column(name = "pymt_name", nullable = false)  
	public String getPymtName() {
		return pymtName;
	}

	public void setPymtServiceProv(String pymtServiceProv) {
		this.pymtServiceProv = pymtServiceProv;
	}
	
		public void setPymtName(String pymtName) {
		this.pymtName = pymtName;
	}
}
