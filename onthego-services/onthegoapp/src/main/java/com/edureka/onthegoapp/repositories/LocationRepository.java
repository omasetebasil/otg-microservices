package com.edureka.onthegoapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edureka.onthegoapp.models.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long>{

}
