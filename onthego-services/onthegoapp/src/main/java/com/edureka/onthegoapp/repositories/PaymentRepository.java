package com.edureka.onthegoapp.repositories;

import com.edureka.onthegoapp.models.Withdrawal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edureka.onthegoapp.models.Payment;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{
    @Query("SELECT q FROM  Withdrawal q WHERE  q.drivId = ?1")
    Optional<Payment> findByRiderId(Long drivId);
}