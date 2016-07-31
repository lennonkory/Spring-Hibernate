package com.kcomp.service;

import com.kcomp.dao.EnrollmentAssociationDAO;
import com.kcomp.model.EnrollmentAssociation;
import com.kcomp.model.Vehicle;

public interface EnrollmentAssociationService {

	boolean createEnrollmentAssociation(EnrollmentAssociation enrollmentAssociation);
	EnrollmentAssociation loadEnrollmentAssociationByVehicle(Vehicle vehicle);
	public EnrollmentAssociationDAO getEnrollmentAssociationDao();
	public void setEnrollmentAssociationDAO(EnrollmentAssociationDAO enrollmentAssociationDAO);
	
}
