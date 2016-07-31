package com.kcomp.model;

public enum EnrollmentStatus {

	UNKNOWN(0, "UNKNOWN"),
	ACTIVE(1, "ACTIVE"),
	DEACTIVE(2, "DEACTIVE");
	
	final int key;
	final String value;
	
	EnrollmentStatus(int key, String value){
		this.key = key;
		this.value = value;
	}
	
}
