package com.example.fleetmanagement.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String vehicleName;
	private int odometer; //measure the distance of vehicle travel in its lifetime
	private String status; //status of the vehicle 
	private String currentPosition; //latitude and longitude of that vehicle
	private String currentDriver;
	
	
	
	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public int getOdometer() {
		return odometer;
	}

	public void setOdometer(int odometer) {
		this.odometer = odometer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(String currentPosition) {
		this.currentPosition = currentPosition;
	}

	public String getCurrentDriver() {
		return currentDriver;
	}
	
	public void setCurrentDriver(String currentDriver) {
		this.currentDriver = currentDriver;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", vehicleName=" + vehicleName + ", odometer=" + odometer + ", status=" + status
				+ ", currentPosition=" + currentPosition + ", currentDriver=" + currentDriver + "]";
	}

		

}
