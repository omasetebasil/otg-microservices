package com.edureka.onthegoapp.repositories;

import com.edureka.onthegoapp.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    @Query("SELECT q FROM  Trip q WHERE  q.drivId = ?1")
    Optional<Trip> findByDrivId(Long drivId);
    @Query("SELECT q FROM  Trip q WHERE  q.ridId = ?1")
    Optional<Trip> findByRidId(Long ridId);
    @Query("SELECT q FROM  Trip q WHERE  (q.id = :id or q.pymtStatus=:pymtStatus)")
    Optional<Trip> checkPaidTrips(Long id,String pymtStatus);
    @Query("SELECT q FROM  Trip q WHERE  (q.id = :id)")
    Trip findByTripId(Long id);
}
