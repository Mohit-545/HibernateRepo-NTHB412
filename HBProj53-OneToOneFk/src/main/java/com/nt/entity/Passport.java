//Passport.java (Child class)
package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Passport implements Serializable {
	private Integer passportNo;
	private String country;
	private LocalDate expiryDate;
	private Person personDetails;		//for many to one association to hold bunch of doctors
	
	public Passport() {
		System.out.println("LibraryMembership :: 0-param constructor "+this.getClass());
	}

	@Override
	public String toString() {
		return "Passport [passportNo=" + passportNo + ", country=" + country + ", expiryDate=" + expiryDate+"]";
	}//toString()

	

	
}//class
