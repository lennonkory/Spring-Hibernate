package com.kcomp.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.kcomp.model.Device;
import com.kcomp.model.EnrollmentDevice;
import com.kcomp.model.User;

public class EnrollmentDeviceJpaDAO extends GenericJpaDao<EnrollmentDevice, Long> implements EnrollmentDeviceDAO{

	public EnrollmentDeviceJpaDAO() {
		super(EnrollmentDevice.class);
	}

	private Query createQuery(String hql){
		return this.getEntityManager().createQuery(hql);
	}
	
	private String getClassName(){
		return this.getPersistentClass().getSimpleName();
	}
	
	public EnrollmentDevice findByDevice(Device device) {
		EnrollmentDevice enrollmentDevice = null;
		
		String hql = "select ed from " + this.getClassName() + " ed where ed.device = :device";
		
		Query q = this.createQuery(hql);
		
		q.setParameter("device", device);
		
		try{
			enrollmentDevice = (EnrollmentDevice)q.getSingleResult();
		}
		catch(NoResultException nre){
			//Do something here
		}
		
		return enrollmentDevice;
	}

	public EnrollmentDevice findByUser(User user) {
		
		EnrollmentDevice enrollmentDevice = null;
		
		String hql = "select ed from " + this.getClassName() + " ed where ed.user = :user";
		
		Query q = this.createQuery(hql);
		
		q.setParameter("user", user);
		
		try{
			enrollmentDevice = (EnrollmentDevice)q.getSingleResult();
		}
		catch(NoResultException nre){
			//Do something here
		}
		
		return enrollmentDevice;
	}

	public Device findDeviceByEnrollmentId(Long id) {
		Device device = null;
		
		String hql = "select ed from " + this.getClassName() + " ed where ed.device_id = :id";
		
		Query q = this.createQuery(hql);
		
		q.setParameter("device_id", id);
		
		try{
			device = (Device)q.getSingleResult();
		}
		catch(NoResultException nre){
			//Do something here
		}
		
		return device;
	}

	public User findUserByEnrollmentId(Long id) {
		User user = null;
		
		String hql = "select ed from " + this.getClassName() + " ed where ed.user_id = :id";
		
		Query q = this.createQuery(hql);
		
		q.setParameter("user_id", id);
		
		try{
			user = (User)q.getSingleResult();
		}
		catch(NoResultException nre){
			//Do something here
		}
		
		return user;
	}

}
