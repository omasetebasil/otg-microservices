package com.edureka.onthegoapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edureka.onthegoapp.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{

}