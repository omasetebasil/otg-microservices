package com.edureka.onthegoapp.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "transport_rate")
public class TransportRate implements Serializable {
    @Id
    @Column(name = "trate_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "trate_vcategory_id")
    private long vcategoryId;

    @Column(name = "trate_amt")
    private long trateAmt;

    @Column(name = "trate_discount")
    private long trateDiscount;

    @Column(name = "trate_loading")
    private long trateLoading;

    @Column(name = "trate_wef", nullable = true)
    private Date wef;

    @Column(name = "trate_wet", nullable = true)
    private Date wet;

    @Column(name = "trate_loc_id")
    private long locId;

    @Column(name = "trate_cur_id")
    private long curId;

    @Column(name = "trate_doneby_user_id")
    private long donebyUserId;

    @Column(name = "trate_done_date", nullable = true)
    private Date doneDate;
}
