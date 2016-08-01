package com.kcomp.service;

import com.kcomp.dao.EnrollmentAssociationDAO;
import com.kcomp.model.EnrollmentAssociation;
import com.kcomp.model.User;
import com.kcomp.model.Vehicle;

public interface EnrollmentAssociationService {

	boolean createEnrollmentAssociation(EnrollmentAssociation enrollmentAssociation);
	void update(EnrollmentAssociation enrollmentAssociation);
	EnrollmentAssociation loadEnrollmentAssociationByVehicle(Vehicle vehicle);
	EnrollmentAssociation findByUserAndVehicle(User user, Vehicle vehicle);
	public EnrollmentAssociationDAO getEnrollmentAssociationDao();
	public void setEnrollmentAssociationDAO(EnrollmentAssociationDAO enrollmentAssociationDAO);
	
}
