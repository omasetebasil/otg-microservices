package com.edureka.onthegoapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edureka.onthegoapp.models.PaymentMode;

@Repository
public interface PaymentModeRepository extends JpaRepository<PaymentMode, Long>{

}