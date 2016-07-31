package com.kcomp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Vehicle")
public class Vehicle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private String make;
	
	private Long enrollment_id;

	public Vehicle(){}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public Long getEnrollment_id() {
		return enrollment_id;
	}

	public void setEnrollment_id(Long enrollment_id) {
		this.enrollment_id = enrollment_id;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", make=" + make + ", enrollment_id="
				+ enrollment_id + "]";
	}
	
}
