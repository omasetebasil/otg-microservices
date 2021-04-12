package com.edureka.onthegoapp.models;

import lombok.Data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Data
@Table(name = "withdrawal")
public class Withdrawal {
    @Id
    @Column(name = "wtl_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "wtl_drcr")
    private String wtlDrcr;
    @Column(name = "wtl_date")
    private Date wtlDate;
    @Column(name = "wtl_amt")
    private long wtlAmt;
    @Column(name = "wtl_cur_id")
    private long curId;
    @Column(name = "wtl_driv_id")
    private long drivId;
}
