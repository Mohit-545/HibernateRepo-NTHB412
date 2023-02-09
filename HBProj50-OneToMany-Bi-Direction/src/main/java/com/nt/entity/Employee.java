//Employee.java (Child class)
package com.nt.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public class Employee {
	private Integer empNo;
	private String empName;
	private Double empSalary;
	private IDepartment dept;		//for many to one association
	
	public Employee() {
		System.out.println("Employee :: 0-param constructor "+this.getClass());
	}
	
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", empSalary=" + empSalary + "]";
	}

	
}//class
