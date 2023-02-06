//Employee.java (subclass 2)
package com.nt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends Person {
	private String desg;
	private Double salary;
	private Integer deptno;

}//class
