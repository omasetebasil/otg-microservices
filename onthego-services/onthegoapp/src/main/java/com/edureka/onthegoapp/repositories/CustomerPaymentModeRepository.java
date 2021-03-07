package com.edureka.onthegoapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edureka.onthegoapp.models.CustomerPaymentMode;

@Repository
public interface CustomerPaymentModeRepository extends JpaRepository<CustomerPaymentMode, Long>{

}