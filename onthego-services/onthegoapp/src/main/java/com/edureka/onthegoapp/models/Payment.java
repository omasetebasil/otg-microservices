package com.edureka.onthegoapp.models;

import lombok.Data;

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
@Entity
@Data
@Table(name = "payment")
public class Payment {
	@Id
	@Column(name = "pyt_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "pymt_reason")
	@NotNull
	@Size(min = 2, message = "payment reason should have atleast 2 characters")
	private String pymtReason;
	@Column(name = "pymt_drcr")
    private String pymtDrcr;
	@Column(name = "pymt_date")
    private Date pymtDate;
	@Column(name = "pymt_amt")
    private long pymtAmt;
	@Column(name = "pyt_cur_id")
    private long curId;
}

