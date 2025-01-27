package com.example.fleetmanagement.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.fleetmanagement.dao.VehicleRepository;
import com.example.fleetmanagement.domain.Vehicle;
import com.example.fleetmanagement.services.PositionTrackingExternalService;

@Controller
@RequestMapping("/website/vehicles")
public class VehicleController {
	
	@Autowired
	private VehicleRepository dao;	
	
	@Autowired
	private PositionTrackingExternalService externalService;
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
	 * Delete Vehicle
	 */
	@RequestMapping(value = "/deleteVehicle.html", method = RequestMethod.POST)
	public String deleteVehicle(@RequestParam Long id) {
		dao.deleteById(id);
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
	
	@RequestMapping(value = "/vehicle/{vehicleName}")
	public ModelAndView showVehicleByName(@PathVariable("vehicleName") String vehicleName) {
		
		//search vehicle
		Vehicle vName = dao.findByVehicleName(vehicleName);	
		
		PositionOfVehicle latestPosition = externalService.getLatestPositionForVehicleFromRemoteMicroservice(vehicleName);
		
				
		//put position and vehicle into the map
		Map<String, Object> model = new HashMap<>();
		model.put("vehicle", vName);
		model.put("position", latestPosition);
		
		return new ModelAndView("vehicleInfo", "model", model);
		
		
		
		
		
		
		
		
		
	}

}