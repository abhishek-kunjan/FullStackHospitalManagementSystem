package com.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.entity.MedOrderMedicines;
import com.hospital.repository.MedOrderMedicinesRepository;

@Service
public class MedOrderMedicinesService {

	@Autowired
	private MedOrderMedicinesRepository medOrderMedicinesRepository;

	public MedOrderMedicines saveMedOrderMedicines(MedOrderMedicines medOrderMedicines) {
		return medOrderMedicinesRepository.save(medOrderMedicines);
	}

	public MedOrderMedicines getMedOrderMedicinesById(long id) {
		return medOrderMedicinesRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("MedOrderMedicine with " + id + " not found"));
	}

	public List<MedOrderMedicines> getAllMedOrderMedicines() {
		return medOrderMedicinesRepository.findAll();
	}

	public void deleteMedOrderMedicine(long id) {
		if (medOrderMedicinesRepository.existsById(id)) {
			medOrderMedicinesRepository.deleteById(id);
		} else {
			throw new RuntimeException("MedOrderMedicine with " + id + " not found");
		}

	}
}
