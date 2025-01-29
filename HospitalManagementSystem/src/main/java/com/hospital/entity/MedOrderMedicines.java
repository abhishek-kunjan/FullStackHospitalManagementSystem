package com.hospital.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "med_order_medicines")
public class MedOrderMedicines {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "med_order_id", nullable = false)
	private MedOrder medOrder;

	@ManyToOne
	@JoinColumn(name = "medicine_id", nullable = false)
	private Medicine medicine;

	@Column(nullable = false)
	private int quantity;

	@Column(nullable = false)
	private double price;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public MedOrder getMedOrder() {
		return medOrder;
	}

	public void setMedOrder(MedOrder medOrder) {
		this.medOrder = medOrder;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "MedOrderMedicines [id=" + id + ", medOrder=" + medOrder + ", medicine=" + medicine + ", quantity="
				+ quantity + ", price=" + price + "]";
	}

}
