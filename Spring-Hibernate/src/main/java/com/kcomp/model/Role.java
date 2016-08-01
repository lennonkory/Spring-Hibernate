package com.kcomp.model;

public enum Role {

	UNKNOWN(0,"UNKNOWN"),
	OWNER(1,"OWNER"),
	GUEST(2, "GUEST");
	
	private int key;
	private String value;
	
	Role(int key, String value){
		this.key = key;
		this.value = value;
	}
	
}
