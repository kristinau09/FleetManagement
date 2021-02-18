package com.example.fleetmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fleetmanagement.domain.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

}
