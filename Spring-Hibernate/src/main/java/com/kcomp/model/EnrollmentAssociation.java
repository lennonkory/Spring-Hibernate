package com.kcomp.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "enrollment_association")
public class EnrollmentAssociation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinColumn (name = "vehicle_id")
	private Vehicle vehicle;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinColumn (name = "user_id")
	private User user;
	
	private EnrollmentStatus status;

	
	public EnrollmentAssociation(){}

	
	public EnrollmentStatus getStatus() {
		return status;
	}



	public void setStatus(EnrollmentStatus status) {
		this.status = status;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "EnrollmentAssociation [id=" + id + ", vehicle=" + vehicle + ", user=" + user + ", status=" + status
				+ "]";
	}

	
	
}
