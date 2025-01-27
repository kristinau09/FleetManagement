package com.example.fleetmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fleetmanagement.domain.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{
	
	/* Vehicle name is unique so no duplicates */
	public Vehicle findByVehicleName(String vehicleName);

}
