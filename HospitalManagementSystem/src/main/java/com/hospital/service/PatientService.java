package com.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.entity.Patient;
import com.hospital.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;

	public Patient savePatient(Patient patient) {
		return patientRepository.save(patient);
	}

	public Patient getPatientById(long id) {
		return patientRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Patient with " + id + " not found"));
	}

	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	public void deletePatientById(long id) {
		if (patientRepository.existsById(id)) {
			patientRepository.deleteById(id);
		} else {
			throw new RuntimeException("Patient with " + id + " not found");
		}
	}

	public Patient updatePatient(long id, Patient updatePatient) {

		Patient newPatient = patientRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Patient with " + id + " not found"));

		newPatient.setDoctor(updatePatient.getDoctor());
		newPatient.setName(updatePatient.getName());
		newPatient.setEmail(updatePatient.getEmail());
		newPatient.setMedOrders(updatePatient.getMedOrders());
		newPatient.setPhone(updatePatient.getPhone());

		return patientRepository.save(newPatient);
	}

}
