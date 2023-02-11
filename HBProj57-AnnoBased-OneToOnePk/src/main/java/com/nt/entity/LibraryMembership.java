//LibraryMembership.java (Child class)
package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "ANNO_HB_LIBRARY_MEMBERSHIP")
public class LibraryMembership implements Serializable {

	@GenericGenerator(name = "gen1", strategy = "foreign",
												parameters = @Parameter(name = "property", value = "studentDetails"))
	@GeneratedValue(generator = "gen1")
	@Id
	private Integer lid;
	@Column(length = 15)
	private String type;
	@Column
	private LocalDate doj;
	@OneToOne(targetEntity = Student.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "libraryDetails")
	private Student studentDetails;		//for many to many association to hold bunch of doctors
	
	public LibraryMembership() {
		System.out.println("LibraryMembership :: 0-param constructor "+this.getClass());
	}

	@Override
	public String toString() {
		return "LibraryMembership [lid=" + lid + ", type=" + type + ", doj=" + doj + "]";
	}

	

	
}//class
