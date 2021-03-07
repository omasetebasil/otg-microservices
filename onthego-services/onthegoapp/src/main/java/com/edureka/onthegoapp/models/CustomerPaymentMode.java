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
@Table(name = "customer_payment_modes")
public class CustomerPaymentMode {

	private long id;
	private long cpymtPymtId;

	@NotNull
	@Size(min = 1, message = "Preffered? should have atleast 1 characters") 
	private String cpymtPreffered;
	@NotNull
	@Size(min = 2, message = "Account number should have atleast 2 characters")
	private String cpymtAccno;
	
	/*@Email
	@NotBlank
	private String emailId;*/

	public CustomerPaymentMode() {

	}

	public CustomerPaymentMode(String cpymtPreffered,String cpymtAccno,Long cpymtPymtId) {
		this.cpymtPreffered = cpymtPreffered;
		this.cpymtAccno = cpymtAccno;
		this.cpymtPymtId = cpymtPymtId;
	}

	@Id
	@Column(name = "cpymt_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "cpymt_pymt_id")
	public long getCpymtPymtId() {
		return cpymtPymtId;
	}

	public void setCpymtPymtId(long cpymtPymtId) {
		this.cpymtPymtId = cpymtPymtId;
	}

	@Column(name = "cpymt_preffered", nullable = false)  
	public String getCpymtPreffered() {
		return cpymtPreffered;
	}
	@Column(name = "cpymt_accno", nullable = false)  
	public String getCpymtAccno() {
		return cpymtAccno;
	}

	public void setCpymtPreffered(String cpymtPreffered) {
		this.cpymtPreffered = cpymtPreffered;
	}
	
		public void setCpymtAccno(String cpymtAccno) {
		this.cpymtAccno = cpymtAccno;
	}
}
