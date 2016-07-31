package com.kcomp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User implements Serializable{

	private static final long serialVersionUID = -8789920463809744548L;
	
	private String name;
	private int age;
	private Long enrollment_id;

	@Id
	@GeneratedValue
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Long getEnrollment_id() {
		return enrollment_id;
	}

	public void setEnrollment_id(Long enrollment_id) {
		this.enrollment_id = enrollment_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", enrollment_id="
				+ enrollment_id + ", id=" + id + "]";
	}
		
}
