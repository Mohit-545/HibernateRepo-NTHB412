//Doctor.java (Parent class)
package com.nt.entity;


import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public class Doctor {
	private Integer docId;
	private String docName;
	private String hospital;
	//to hold bunch of patient class Objects (Many to Many Association)
	private Set<Patient> patients;
	
	public Doctor() {
		System.out.println("Department :: 0-param constructor "+this.getClass());
	}

	@Override
	public String toString() {
		return "Doctor [docId=" + docId + ", docName=" + docName + ", hospital=" + hospital + "]";
	}
	

}//class
