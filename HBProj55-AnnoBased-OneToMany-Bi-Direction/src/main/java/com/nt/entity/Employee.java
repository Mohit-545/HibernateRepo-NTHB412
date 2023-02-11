//Employee.java (Child class)
package com.nt.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "HB_ANNO_EMPLOYEE")
public class Employee {
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "EMPLOYEE_SEQ", allocationSize = 100, initialValue = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer empNo;
	private String empName;
	private Double empSalary;
	@ManyToOne(targetEntity = Department.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPARTMENT_NO",referencedColumnName = "DEPTNO")
	@LazyToOne(LazyToOneOption.FALSE)
	private Department dept;		//for many to one association
	
	public Employee() {
		System.out.println("Employee :: 0-param constructor "+this.getClass());
	}
	
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", empSalary=" + empSalary + "]";
	}

	
}//class
