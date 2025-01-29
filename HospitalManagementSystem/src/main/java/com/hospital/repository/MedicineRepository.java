package com.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {

}
