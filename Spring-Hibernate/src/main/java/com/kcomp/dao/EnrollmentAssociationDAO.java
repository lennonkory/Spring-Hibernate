package com.kcomp.dao;

import com.kcomp.model.EnrollmentAssociation;
import com.kcomp.model.User;
import com.kcomp.model.Vehicle;

public interface EnrollmentAssociationDAO extends GenericDao<EnrollmentAssociation, Long> {
	
	public EnrollmentAssociation findByVehicle(Vehicle vehicle);
	public EnrollmentAssociation findByUserAndVehicle(User user, Vehicle vehicle);
}
