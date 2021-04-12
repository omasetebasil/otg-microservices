package com.auth.repositories;

import com.auth.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserInfo, Integer> {
    @Query("SELECT q FROM  UserInfo q WHERE q.email = :email")
    UserInfo findUserByEmailAndMobilenumber(@Param("email") String email,
                                           @Param("mobilenumber") String mobilenumber);
}
