package com.edureka.onthegoapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edureka.onthegoapp.models.MapGrid;

@Repository
public interface MapGridRepository extends JpaRepository<MapGrid, Long>{

}
