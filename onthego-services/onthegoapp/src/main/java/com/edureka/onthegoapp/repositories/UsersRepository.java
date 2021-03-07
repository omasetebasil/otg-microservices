package com.edureka.onthegoapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edureka.onthegoapp.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Integer> {
    Optional<User> findByFirstName(String firstname);
}
