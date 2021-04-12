package com.edureka.onthegoapp.repositories;

import com.edureka.onthegoapp.models.PaymentAllocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentAllocationRepository extends JpaRepository<PaymentAllocation, Long> {

}
