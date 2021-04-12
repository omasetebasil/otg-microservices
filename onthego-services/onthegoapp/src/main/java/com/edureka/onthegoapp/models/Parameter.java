package com.edureka.onthegoapp.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "parameters")
public class Parameter implements Serializable {

    @Id
    @Column(name = "param_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "param_name", nullable = false)
    private String paramName;

    @Column(name = "param_value", nullable = true)
    private String paramValue;
}
