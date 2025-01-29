package com.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
