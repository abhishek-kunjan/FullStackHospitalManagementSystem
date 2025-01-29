package com.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.entity.MedOrder;

public interface MedOrderRepository extends JpaRepository<MedOrder, Long> {

}
