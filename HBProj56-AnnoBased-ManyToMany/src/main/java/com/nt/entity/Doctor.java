//Doctor.java (Parent class)
package com.nt.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "ANNO_HB_DOCTOR")
public class Doctor {
	@Id
	@GeneratedValue
	private Integer docId;
	@Column(length = 15)
	private String docName;
	@Column(length = 15)
	private String hospital;
	
	//to hold bunch of patient class Objects (Many to Many Association)
	@ManyToMany(targetEntity = Patient.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "ANNO_HB_DOCTORS_PATIENTS",
							joinColumns = @JoinColumn(name = "DOCTOR_ID",referencedColumnName = "DOCID"),
							inverseJoinColumns = @JoinColumn(name = "PATIENT_ID",referencedColumnName = "PATID"))
	@LazyCollection(LazyCollectionOption.EXTRA)
	private Set<Patient> patients;
	
	public Doctor() {
		System.out.println("Department :: 0-param constructor "+this.getClass());
	}

	@Override
	public String toString() {
		return "Doctor [docId=" + docId + ", docName=" + docName + ", hospital=" + hospital + "]";
	}
	

}//class
