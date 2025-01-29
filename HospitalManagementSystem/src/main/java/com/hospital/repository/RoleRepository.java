package com.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
