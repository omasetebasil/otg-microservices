package com.edureka.onthegoapp.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "payment_allocations")
public class PaymentAllocation implements Serializable {
    @Id
    @Column(name = "pytalloc_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "pytalloc_pyt_id", nullable = true)
    private long pytId;

    @Column(name = "pytalloc_trip_id", nullable = true)
    private long tripId;

    @Column(name = "pytalloc_rid_id", nullable = true)
    private long ridId;

    @Column(name = "pytalloc_driv_id", nullable = true)
    private long drivId;

}
