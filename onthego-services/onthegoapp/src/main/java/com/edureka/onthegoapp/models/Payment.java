package com.edureka.onthegoapp.models;

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
@Table(name = "payment")
public class Payment {

	private long id;

	@NotNull
	@Size(min = 2, message = "payment reason should have atleast 2 characters")
	private String pymtReason;
    private String pymtDrcr;
    private Date pymtDate;
    private long pymtAmt;
    private long curId;
	
	public Payment() {

	}

	public Payment(String pymtReason,String pymtDrcr,
			Date pymtDate,Long pymtAmt,Long curId) {
		this.pymtReason = pymtReason;
		this.pymtDrcr = pymtDrcr;
		this.pymtDate = pymtDate;
		this.pymtAmt = pymtAmt;
	}

	@Id
	@Column(name = "pyt_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "pymt_reason", nullable = false)
	public String getPymtReason() {
		return pymtReason;
	}

	public void setPymtReason(String pymtReason) {
		this.pymtReason = pymtReason;
	}
	@Column(name = "pymt_drcr", nullable = false)
	public String getPymtDrcr() {
		return pymtDrcr;
	}

	public void setPymtDrcr(String pymtDrcr) { 
		this.pymtDrcr = pymtDrcr;
	}
	@Column(name = "pymt_date", nullable = false)
	public Date getPymtDate() {
		return pymtDate;
	}

	public void setPymtDate(Date pymtDate) {
		this.pymtDate = pymtDate;
	}
	@Column(name = "pymt_amt")
	public long getPymtAmt() {
		return pymtAmt;
	}

	public void setPymtAmt(long pymtAmt) {
		this.pymtAmt = pymtAmt;
	}
	@Column(name = "pyt_cur_id")
	public long getCurId() {
		return curId;
	}

	public void setCurId(long curId) {
		this.curId = curId;
	}
}

