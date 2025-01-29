package com.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.entity.MedOrderMedicines;

public interface MedOrderMedicinesRepository extends JpaRepository<MedOrderMedicines, Long> {

}
