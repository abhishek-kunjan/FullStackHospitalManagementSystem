package com.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.entity.MedOrder;
import com.hospital.repository.MedOrderRepository;

@Service
public class MedOrderService {

	@Autowired
	private MedOrderRepository medOrderRepository;

	public MedOrder saveMedOrder(MedOrder medOrder) {
		return medOrderRepository.save(medOrder);

	}

	public MedOrder getMedOrderById(long id) {
		return medOrderRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("MedOrder with ID :" + id + " not found"));
	}

	public List<MedOrder> getAllMedOrders() {
		return medOrderRepository.findAll();

	}

	public void deleteMedOrderById(long id) {
		if (medOrderRepository.existsById(id)) {
			medOrderRepository.deleteById(id);
		} else {
			throw new RuntimeException("MedOrder with ID :" + id + " not found");
		}
	}

	public MedOrder updateMedOrder(long id, MedOrder updateMedOrder) {

		MedOrder newMedOrder = medOrderRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("MedOrder with ID :" + id + " not found"));

		newMedOrder.setMedicines(updateMedOrder.getMedicines());
		newMedOrder.setOrderDate(updateMedOrder.getOrderDate());
		newMedOrder.setPatient(updateMedOrder.getPatient());
		newMedOrder.setTotalPrice(updateMedOrder.getTotalPrice());
		return medOrderRepository.save(newMedOrder);
	}
}
