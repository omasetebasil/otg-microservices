package com.edureka.onthegoapp.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currency_rate")
public class CurrencyRate {

	private long id;
	private long baseCurId;
	private long curId;
	private String couName;
	private Date wef;
	private Date wet;
	private double rate;
	private long donebyUserId;
	private Date doneDate;

	public CurrencyRate() {

	}

	public CurrencyRate(String couName,Long baseCurId,Long curId,Date wef,Date wet,double rate,Long donebyUserId,Date doneDate) {
		this.couName = couName;
		this.baseCurId = baseCurId;
		this.curId = curId;
		this.wef = wef;
		this.wet = wet; 
		this.rate = rate;
		this.donebyUserId = donebyUserId;
		this.doneDate = doneDate;
	}

	@Id
	@Column(name = "crt_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "cou_name", nullable = false)
	public String getCouName() {
		return couName;
	}

	public void setCouName(String couName) {
		this.couName = couName;
	}
	@Column(name = "crt_base_cur_id")
	public long getBaseCurId() {
		return baseCurId;
	}

	public void setBaseCurId(long baseCurId) {
		this.baseCurId = baseCurId;
	}
	@Column(name = "crt_cur_id")
	public long getCurId() {
		return curId;
	}

	public void setCurId(long curId) {
		this.curId = curId;
	}
	@Column(name = "crt_wef")
	public Date getWef() {
		return wef;
	}

	public void setWef(Date wef) {
		this.wef = wef;
	}
	@Column(name = "crt_wet")
	public Date getWet() {
		return wet;
	}

	public void setWet(Date wet) {
		this.wet = wet;
	}
	@Column(name = "crt_rate", nullable = false)
	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
	@Column(name = "crt_doneby_user_id", nullable = false)
	public long getDonebyUserId() {
		return donebyUserId;
	}

	public void setDonebyUserId(long donebyUserId) {
		this.donebyUserId = donebyUserId;
	}
	@Column(name = "crt_done_date")
	public Date getDoneDate() {
		return doneDate;
	}

	public void setDoneDate(Date doneDate) {
		this.doneDate = doneDate;
	}
}

