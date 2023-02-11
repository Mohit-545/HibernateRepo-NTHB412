//Passport.java (Child class)
package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "ANNO_HB_PASSPORT")
public class Passport implements Serializable {
	@SequenceGenerator(name = "gen1", sequenceName = "PASSPORT_SEQ", allocationSize = 100, initialValue = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	@Id
	private Integer passportNo;
	@Column(length = 15)
	private String country;
	@Column
	private LocalDate expiryDate;
	
	@OneToOne(targetEntity = Person.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSON_ID", referencedColumnName = "PID")
	private Person personDetails;		//for many to one association to hold bunch of doctors
	
	public Passport() {
		System.out.println("LibraryMembership :: 0-param constructor "+this.getClass());
	}

	@Override
	public String toString() {
		return "Passport [passportNo=" + passportNo + ", country=" + country + ", expiryDate=" + expiryDate+"]";
	}//toString()

	

	
}//class
