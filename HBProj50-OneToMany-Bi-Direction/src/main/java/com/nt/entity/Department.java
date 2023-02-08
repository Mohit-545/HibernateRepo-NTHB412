//Department.java (Parent class)
package com.nt.entity;


import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Department {
	private Integer deptNo;
	private String deptName;
	private String deptHead;
	//special property to hold bunch of child class Objects (One to Many Association)
	private Set<Employee> employees;

}//class
