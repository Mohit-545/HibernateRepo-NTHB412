//Patient.java (Child class)
package com.nt.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "ANNO_HB_PATIENT")
public class Patient {
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "PAT_SEQ", allocationSize = 100, initialValue = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer patId;
	@Column(length = 15)
	private String patName;
	@Column(length = 15)
	private String problem;
	
	@ManyToMany(targetEntity = Doctor.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "patients")
	@LazyCollection(LazyCollectionOption.EXTRA)
	private Set<Doctor> doctors;		//for many to many association to hold bunch of doctors
	
	public Patient() {
		System.out.println("Employee :: 0-param constructor "+this.getClass());
	}

	@Override
	public String toString() {
		return "Patient [patId=" + patId + ", patName=" + patName + ", problem=" + problem + "]";
	}
	
	

	
}//class
