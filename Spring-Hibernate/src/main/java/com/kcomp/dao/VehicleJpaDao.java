package com.kcomp.dao;

import com.kcomp.model.Vehicle;

public class VehicleJpaDao extends GenericJpaDao<Vehicle, Long> implements VehicleDAO {

	public VehicleJpaDao() {
		super(Vehicle.class);
	}

}
