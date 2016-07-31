package com.kcomp.service;

import com.kcomp.dao.VehicleDAO;
import com.kcomp.model.Vehicle;

public interface VehicleService {

	boolean createVehicle(Vehicle vehicle);
	
	public VehicleDAO getVehicleDao();

	public void setVehicleDao(VehicleDAO vehicleDao);
	
}
