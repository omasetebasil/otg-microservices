package com.edureka.onthegoapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edureka.onthegoapp.models.VehicleCategory;

@Repository
public interface VehicleCategoryRepository extends JpaRepository<VehicleCategory, Long>{

}