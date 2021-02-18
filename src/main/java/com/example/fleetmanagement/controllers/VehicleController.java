package com.example.fleetmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.fleetmanagement.dao.VehicleRepository;
import com.example.fleetmanagement.domain.Vehicle;

@Controller
@RequestMapping("/website/vehicles")
public class VehicleController {
	
	@Autowired
	private VehicleRepository dao;

	/* 
	 * Presenting the initial form to the user
	 */
	
	@RequestMapping(value = "/newVehicle.html", method = RequestMethod.GET)
	public ModelAndView renderNewVehicleForm() {
       Vehicle vehicle = new Vehicle();
       //newVehicle is view name, "form" is the model name for ModelAndView
       return new ModelAndView("newVehicle", "form", vehicle);
	}

	/*
	 *  Save the vehicle to the database
	 */
	
	@RequestMapping(value = "/newVehicle.html", method = RequestMethod.POST)
	public String saveNewVehicle(Vehicle vehicle) {
		dao.save(vehicle);
		return "redirect:/website/vehicles/list.html";

	}
	
	/*
	 * Listing all vehicles 
	*/
	
	@RequestMapping(value = "/list.html", method = RequestMethod.GET)
	public ModelAndView listAllVehicles() {
		
		List<Vehicle> listAllVehicles = dao.findAll();		
		return new ModelAndView("allVehicles", "vehicles", listAllVehicles);
	}

	/*
	 *  Search vehicles by its name 
	*/
	
	@RequestMapping(value = "/vehicle/{name}")
	public ModelAndView showVehicleByName(@PathVariable("name") String name) {
		
		//search vehicle
		Vehicle vehicleName = dao.findByVehicleName(name);
		return new ModelAndView("vehicleInfo", "vehicle", vehicleName);
		
	}

}