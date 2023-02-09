//LibraryMembership.java (Child class)
package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LibraryMembership implements Serializable {
	private Integer lid;
	private String type;
	private LocalDate doj;
	private Student studentDetails;		//for many to many association to hold bunch of doctors
	
	public LibraryMembership() {
		System.out.println("LibraryMembership :: 0-param constructor "+this.getClass());
	}

	@Override
	public String toString() {
		return "LibraryMembership [lid=" + lid + ", type=" + type + ", doj=" + doj + "]";
	}

	

	
}//class
