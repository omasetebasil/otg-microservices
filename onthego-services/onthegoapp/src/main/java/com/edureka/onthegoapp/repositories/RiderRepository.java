package com.edureka.onthegoapp.repositories;

import com.edureka.onthegoapp.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edureka.onthegoapp.models.Rider;

import java.util.Optional;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Long>{
    @Query("SELECT q FROM  Rider q WHERE  (q.idNumber = :idmobNo or q.mobileNo=:idmobNo)")
    Optional<Rider> findByByIdNoOrMobileNo(@Param("idmobNo") String idmobNo);
}