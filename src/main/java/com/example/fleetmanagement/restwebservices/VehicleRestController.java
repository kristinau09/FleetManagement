package com.example.fleetmanagement.restwebservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fleetmanagement.dao.VehicleRepository;
import com.example.fleetmanagement.domain.Vehicle;

@RestController
public class VehicleRestController {
	
	@Autowired
	private VehicleRepository dao;
	
	@RequestMapping("/vehicles")
	public VehicleList allVehicles() {
		
		List<Vehicle> listOfVehicles = dao.findAll();
		return new VehicleList(listOfVehicles);
	}

}
