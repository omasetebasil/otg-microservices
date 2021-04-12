package com.edureka.onthegoapp.repositories;

import com.edureka.onthegoapp.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edureka.onthegoapp.models.Driver;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long>{
    @Query("SELECT q FROM  Driver q WHERE  q.cessionActive = ?1")
    Optional<Driver> findByCessionActive(String cessionActive);

    @Query("SELECT q FROM  Driver q WHERE  (q.idNumber = :idmobNo or q.mobileNo=:idmobNo)")
    Optional<Driver> findByByIdNoOrMobileNo(@Param("idmobNo") String idmobNo);
}
