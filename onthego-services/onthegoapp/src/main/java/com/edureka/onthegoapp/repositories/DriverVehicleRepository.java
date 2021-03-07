package com.edureka.onthegoapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edureka.onthegoapp.models.DriverVehicle;

@Repository
public interface DriverVehicleRepository extends JpaRepository<DriverVehicle, Long>{

}
