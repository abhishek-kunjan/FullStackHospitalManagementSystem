package com.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.entity.Doctor;
import com.hospital.repository.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);

	}

	public Doctor getDoctorById(long id) {
		return doctorRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Doctor with ID :" + id + " not found"));
	}

	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}

	public void deleteDoctorById(long id) {
		if (doctorRepository.existsById(id)) {
			doctorRepository.deleteById(id);

		} else {
			throw new RuntimeException("Doctor with ID :" + id + " not found");
		}
	}

	public Doctor updateDoctor(long id, Doctor updateDoctor) {

		Doctor newDoctor = doctorRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Doctor with ID :" + id + " not found"));

		newDoctor.setName(updateDoctor.getName());
		newDoctor.setPatients(updateDoctor.getPatients());
		newDoctor.setPhone(updateDoctor.getPhone());
		newDoctor.setSpecialization(updateDoctor.getSpecialization());
		return doctorRepository.save(newDoctor);
	}
}
