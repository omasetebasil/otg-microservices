package com.auth.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "user")
public class UserInfo implements Serializable {
    @Id
    @Column(name = "userid", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int userid;
    @Column(name = "email", length = 100, nullable = true)
    private String	email;
    @Column(name = "dob", length = 7, nullable = true)
    private Date dob;
    @Column(name = "firstname", length = 100, nullable = true)
    private String	firstname;
    @Column(name = "gender", length = 100, nullable = true)
    private String	gender;
    @Column(name = "lastname", length = 100, nullable = true)
    private String	lastname;
    @Column(name = "mobilenumber", length = 100, nullable = true)
    private String	mobilenumber;
    @Column(name = "password", length = 100, nullable = true)
    private String	password;
}

