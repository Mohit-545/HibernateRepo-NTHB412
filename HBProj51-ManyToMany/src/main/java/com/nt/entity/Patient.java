//Patient.java (Child class)
package com.nt.entity;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public class Patient {
	private Integer patId;
	private String patName;
	private String problem;
	private Set<Doctor> doctors;		//for many to many association to hold bunch of doctors
	
	public Patient() {
		System.out.println("Employee :: 0-param constructor "+this.getClass());
	}

	@Override
	public String toString() {
		return "Patient [patId=" + patId + ", patName=" + patName + ", problem=" + problem + "]";
	}
	
	

	
}//class
