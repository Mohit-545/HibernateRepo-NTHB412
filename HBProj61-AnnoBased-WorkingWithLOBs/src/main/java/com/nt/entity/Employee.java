//Employee.java (Entity class)
package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "HB_ANNO_EMPLOYEE_LOBs")
public class Employee {
	@Id
	@GeneratedValue
	private Integer empNo;
	@Column(length = 15)
	private String empName;
	@Column
	private Double empSalary;
	@Lob
	private byte[] empPhoto;
	@Lob
	private char[] empResume;
	
	
	public Employee() {
		System.out.println("Employee :: 0-param constructor "+this.getClass());
	}//constructor
	
		
}//class
