package com.auth.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "roles", catalog = "users")
public class RoleInfo implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 952619993656863335L;
    private Integer roleid;
    private Integer userid;
    private String name;

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "roleid", unique = true, nullable = false)
    public Integer getRoleid() {
        return this.roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    @Column(name = "userid", nullable = false, length = 45)
    public Integer getUserid() {
        return this.userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }


    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
