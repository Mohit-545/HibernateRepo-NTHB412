//Employee.java (Child class)
package com.nt.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Employee {
	private Integer empNo;
	private String empName;
	private Double empSalary;
	private Department dept;		//for many to one association

}//class
