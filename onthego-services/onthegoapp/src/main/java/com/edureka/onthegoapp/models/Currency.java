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
@Table(name = "currencies")
public class Currency {

	private long id;

	@NotNull
	@Size(min = 2, message = "currency symbol should have atleast 2 characters")
	private String curSymbol;
	private String curDesc;

	public Currency() {

	}

	public Currency(String curSymbol,String curDesc) {
		this.curSymbol = curSymbol;
		this.curDesc = curDesc;
	}

	@Id
	@Column(name = "cur_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "cur_symbol", nullable = false)
	public String getCurSymbol() {
		return curSymbol;
	}

	public void setCurSymbol(String curSymbol) {
		this.curSymbol = curSymbol;
	}
	@Column(name = "cur_desc", nullable = false)
	public String getCurDesc() {
		return curDesc;
	}

	public void setCurDesc(String curDesc) {
		this.curDesc = curDesc;
	}
}

