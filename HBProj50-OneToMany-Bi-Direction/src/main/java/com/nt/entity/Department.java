//Department.java (Parent class)
package com.nt.entity;


import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public class Department implements IDepartment {
	private Integer deptNo;
	private String deptName;
	private String deptHead;
	//special property to hold bunch of child class Objects (One to Many Association)
	private Set<Employee> employees;
	
	public Department() {
		System.out.println("Department :: 0-param constructor "+this.getClass());
	}
	
	@Override
	public String toString() {
		return "Department [deptNo=" + deptNo + ", deptName=" + deptName + ", deptHead=" + deptHead + "]";
	}

}//class
