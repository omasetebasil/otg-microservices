package com.edureka.onthegoapp.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "trip")
public class Trip implements Serializable {
    @Id
    @Column(name = "trip_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "trip_rid_id", nullable = false)
    private long ridId;

    @Column(name = "trip_driv_id", nullable = false)
    private long drivId;

    @Column(name = "trip_veh_id", nullable = false)
    private long vehId;

    @Column(name = "trip_start_loc_id", nullable = true)
    private long tripStartLocId;

    @Column(name = "trip_end_loc_id", nullable = true)
    private long tripEndLocId;

    @Column(name = "trip_request_time", nullable = true)
    private Date requestTime;

    @Column(name = "trip_start_time", nullable = true)
    private Date startTime;

    @Column(name = "trip_end_time", nullable = true)
    private Date endTime;

    @Column(name = "trip_rider_rating", nullable = true)
    private long riderRating;

    @Column(name = "trip_driver_rating", nullable = false)
    private long driverRating;

    @Column(name = "trip_trate_id", nullable = true)
    private long trateId;

    @Column(name = "trip_discount")
    private long discount;

    @Column(name = "trip_loading")
    private long loading;

    @Column(name = "trip_offload_needed")
    private String offloadNeeded;

    @Column(name = "trip_offload_charges")
    private long offloadCharges;

    @Column(name = "trip_cancelled")
    private String cancelled;

    @Column(name = "trip_cancelled_by")
    private String cancelledBy;

    @Column(name = "trip_pymt_status")
    private String pymtStatus;

    @Column(name = "trip_basic_amt")
    private long basicAmt;

    @Column(name = "trip_gross_amt")
    private long grossAmt;

}
