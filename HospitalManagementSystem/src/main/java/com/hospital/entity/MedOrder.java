package com.hospital.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "med_orders")
public class MedOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private LocalDate orderDate;

	@Column(nullable = false)
	private double totalPrice;

	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	private Patient patient;

	@OneToMany(mappedBy = "medOrder")
	private List<MedOrderMedicines> medicines;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<MedOrderMedicines> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<MedOrderMedicines> medicines) {
		this.medicines = medicines;
	}

	@Override
	public String toString() {
		return "MedOrder [id=" + id + ", orderDate=" + orderDate + ", totalPrice=" + totalPrice + ", patient=" + patient
				+ ", medicines=" + medicines + "]";
	}

}
