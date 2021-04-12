package com.auth.repositories;

import com.auth.entities.UserInfo;
import com.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT q FROM  User q WHERE ((q.email = :email) or (q.mobilenumber = :mobilenumber))")
    User findUserByEmailAndMobilenumber(@Param("email") String email,
                                        @Param("mobilenumber") String mobilenumber);
    @Query("SELECT q.userid FROM  User q WHERE ((q.email = :email) or (q.mobilenumber = :mobilenumber))")
    Integer findUserIdByEmailAndMobilenumber(@Param("email") String email,
                                        @Param("mobilenumber") String mobilenumber);
}
