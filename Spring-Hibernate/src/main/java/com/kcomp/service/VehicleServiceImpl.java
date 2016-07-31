package com.kcomp.service;

import java.util.logging.Logger;

import com.kcomp.dao.VehicleDAO;
import com.kcomp.model.Vehicle;

public class VehicleServiceImpl implements VehicleService{

	private VehicleDAO vehicleDAO;
	private final static Logger log = Logger.getLogger(VehicleServiceImpl.class.getName());
	
	public boolean createVehicle(Vehicle vehicle) {
		try {
			vehicleDAO.save(vehicle);
			log.info("User saved");
		} catch(Exception e) {
			log.severe("Could not save user");
			return false;
		}
		
		return true;
	}

	public VehicleDAO getVehicleDao() {
		return vehicleDAO;
	}

	public void setVehicleDao(VehicleDAO vehicleDao) {
		this.vehicleDAO = vehicleDao;
		
	}

}
