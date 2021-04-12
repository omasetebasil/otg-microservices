package com.edureka.onthegoapp.repositories;

import com.edureka.onthegoapp.models.Trip;
import com.edureka.onthegoapp.models.Withdrawal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WithdrawalRepository extends JpaRepository<Withdrawal, Long> {
    @Query("SELECT q FROM  Withdrawal q WHERE  q.drivId = ?1")
    Optional<Withdrawal> findByDrivId(Long drivId);
}