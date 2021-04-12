package com.auth.repositories;

import com.auth.model.RoleInfo;
import com.auth.model.Roles;
import com.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<RoleInfo, Integer> {
    @Query("SELECT q FROM  RoleInfo q WHERE q.userid = :user and q.name = :name")
    RoleInfo findUserByUserAndName(@Param("user") Integer user,
                                        @Param("name") String name);
}
